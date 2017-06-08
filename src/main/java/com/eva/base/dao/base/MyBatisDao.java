package com.eva.base.dao.base;

import com.eva.base.model.Page;
import com.eva.base.model.base.BaseModel;
import com.eva.base.util.ReflectionUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jamin.Ma on 2017/5/20.
 */
public class MyBatisDao  <T extends BaseModel> extends SqlSessionDaoSupport {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected Class<T> entityClass;

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate){
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    /**
     * 用于Dao层子类使用的构造函数. 通过子类的泛型定义取得对象类型Class. eg. public class UserDao extends SimpleHibernateDao<User>
     */
    public MyBatisDao() {
        this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass(),0);
    }

    /**
     * 用于用于省略Dao层, 在Service层直接使用通用MyBatisDao的构造函数. 在构造函数中定义对象类型Class. eg. SimpleHibernateDao<User> userDao = new
     * MyBatisDao<User>(sessionFactory, User.class);
     */
    public MyBatisDao(final Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    public void insert(T t){
        getSqlSession().insert(getStatementName("insert"),t);
    }

    public void update(T t){
        updateByStatement("update",t);
    }

    public void updateByStatement(String statement,T t){
        getSqlSession().update(getStatementName(statement),t);
    }

    public void delete(Long id){
        getSqlSession().delete(getStatementName("delete"),id);
    }

    public void deleteByStatement(String statement,Map<String,Object> filter){
        getSqlSession().delete(getStatementName(statement),filter);
    }

    public T get(Long id){
        return getSqlSession().selectOne(getStatementName("get"),id);
    }

    public T getByStatement(String statementName,Map<String,Object> filter){
        return getSqlSession().selectOne(getStatementName(statementName),filter);
    }

    public List<T> findList(Map<String,Object> filter){
        return findListByStatement("findList",filter);
    }

    public List<T> findListByStatement(String statentName,Map<String,Object> filter){
        return getSqlSession().selectList(getStatementName(statentName),filter);
    }

    public Page<T> findPage(Page<T> page, Map<String,Object> filter){
        int totalCount = count(filter);
        page.setCount(totalCount);
        if(filter==null){
            filter = new HashMap<>();
        }
        filter.put("pageNo",page.getPageNo()-1);
        filter.put("pageSize",page.getPageSize());
        filter.put("offset",(page.getPageNo()-1)*page.getPageSize());

        List<T> list = getSqlSession().selectList(getStatementName("findPage"), filter);
        page.setResoult(list);
        return page;
    }

    public int count(Map<String,Object> filter){
        return getSqlSession().selectOne(getStatementName("count"),filter);
    }

    private String getStatementName(String statementName) {
        return entityClass.getName() + "." + statementName;
    }


}
