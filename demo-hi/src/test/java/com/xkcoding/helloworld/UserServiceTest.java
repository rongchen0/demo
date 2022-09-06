package com.xkcoding.helloworld;

import   org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
@Autowired
private UserService userService;
    @Test
    public void getUserInfo() {
        Assert.assertEquals("aa", userService.getUserInfo());

    }
}