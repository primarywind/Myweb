package com.myweb.service.impl;

import java.sql.Timestamp;

import com.myweb.dao.UserDao;
import com.myweb.entity.User;
import com.myweb.service.IUserService;

public class UserServiceImpl implements IUserService {
    private UserDao userDao;

    public void saveUser(User tuser) {
        User user = new User();
        user.setGender(1);
        user.setLevel(1);
        user.setNationality("中国");
        Timestamp time1 = new Timestamp(System.currentTimeMillis());
        user.setRegTime(time1);
        user.setUserName("胡磊");
        //设定密码为默认值
        user.setPwd("123");
        userDao.save(user);
        //        User user1 = new User();
        //        user1.setGender(1);
        //        user1.setLevel(1);
        //        user1.setNationality("中国");
        //        Timestamp time2 = new Timestamp(System.currentTimeMillis());
        //        user1.setRegTime(time2);
        //        user1.setUserName("胡磊");
        //        //设定密码为默认值
        //        user1.setPwd("123");
        //        userDao.save(user1);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
