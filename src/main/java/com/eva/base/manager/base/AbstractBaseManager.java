package com.eva.base.manager.base;

import com.eva.base.component.ApplicationContextProvider;
import com.eva.base.dao.base.MyBatisDao;
import com.eva.base.model.Page;
import com.eva.base.model.User;
import com.eva.base.model.base.BaseModel;
import com.eva.base.util.ReflectionUtils;
import com.eva.base.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Jamin on 2017/5/25.
 */
public abstract class AbstractBaseManager<T extends BaseModel> implements BaseManager<T>{


    protected Class<T> entityClass;

    @Autowired
    private ApplicationContextProvider contextProvider;

    public AbstractBaseManager() {
        super();
        this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
    }

    @Override
    public void insert(T t) {
        getDao().insert(t);
    }

    @Override
    public void update(T t) {
        getDao().update(t);
    }

    @Override
    public void delete(long id) {
        getDao().delete(id);
    }

    @Override
    public  T  get(long id) {
        return getDao().get(id);
    }

    @Override
    public Page<T> findPage(Page<T> page,Map<String,Object> filter) {
        return getDao().findPage(page,filter);
    }

    @Override
    public List<T> findList(Map<String,Object> filter) {
        return getDao().findList(filter);
    }

    @Override
    public long count(Map<String,Object> filter) {
        return getDao().count(filter);
    }

    @SuppressWarnings("unchecked")
    protected MyBatisDao<T> getDao() {
        String entityClassName = entityClass.getSimpleName();
        String daoName = StringUtils.lowercaseFirstLetter(entityClassName) + "Dao";
        MyBatisDao<T> dao = (MyBatisDao<T>) ApplicationContextProvider.getBean(daoName);
        return dao;
    }

}
