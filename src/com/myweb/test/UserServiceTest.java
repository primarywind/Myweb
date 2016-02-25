package com.myweb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myweb.entity.User;
import com.myweb.service.IUserService;

/**
 * 
 * @author huleiwind
 * @version $Id: UserServiceTest.java, v 0.1 2015-10-8 上午11:03:48 huleiwind Exp $
 */
public class UserServiceTest extends SpringTestBase {
    @Autowired
    private IUserService userService;

    @Test
    public void testConfig() {
        assertNotNull(userService);
        assertTrue(userService != null);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setGender(1);
        user.setLevel(1);
        user.setNationality("中国");
        Timestamp time1 = new Timestamp(System.currentTimeMillis());
        user.setRegTime(time1);
        user.setUserName("胡磊");
        //设定密码为默认值
        user.setPwd("123");
        assertNotNull(userService.saveUser("hulei", "123", 1, "whu"));
    }
}