package com.eva.base;

import com.eva.base.service.UserService;
import com.eva.base.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTests {

    @Resource
    private UserService userService;

    @Test
    public void add() {
        User u = new User();
        u.setName("和和和");
        userService.save(u);
    }
}
