package com.eva.base.manager.base;

import com.eva.base.model.Page;
import com.eva.base.model.User;
import com.eva.base.model.base.BaseModel;

import java.util.List;
import java.util.Map;

/**
 * Created by Jamin on 2017/5/25.
 */
public interface BaseManager <T extends BaseModel>{

    void insert(T t);

    void update(T t);

    void delete(long id);

    T get(long id);

    Page<T> findPage(Page<T> page,Map<String,Object> filter);

    List<T> findList(Map<String,Object> filter);

    long count(Map<String,Object> filter);


}
