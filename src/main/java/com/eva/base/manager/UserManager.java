package com.eva.base.manager;

import com.eva.base.dao.UserDao;
import com.eva.base.manager.base.AbstractBaseManager;
import com.eva.base.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Jamin on 2017/5/25.
 */
@Service
public class UserManager extends AbstractBaseManager<User> {

    @Resource
    private UserDao userDao;



}
