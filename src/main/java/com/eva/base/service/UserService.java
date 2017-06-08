package com.eva.base.service;

import com.eva.base.manager.UserManager;
import com.eva.base.model.Page;
import com.eva.base.model.User;
import com.eva.base.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Jamin.Ma on 2017/5/20.
 */
@Service
public class UserService implements BaseService<User> {

    @Resource
    private UserManager userManager;


    @Override
    public void save(User user) {
        userManager.insert(user);
    }

    @Override
    public void update(User user) {
        userManager.update(user);
    }

    @Override
    public void delete(long id) {
        userManager.delete(id);
    }

    @Override
    public User get(long id) {
        return userManager.get(id);
    }

    @Override
    public Page<User> findPage(Page<User> page, Map<String, Object> filter) {
        return userManager.findPage(page,filter);
    }

    @Override
    public List<User> findList(Map<String, Object> filter) {
        return userManager.findList(filter);
    }

    @Override
    public long count(Map<String, Object> filter) {
        return userManager.count(filter);
    }
}
