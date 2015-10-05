package com.myweb.service.impl;

import java.sql.Timestamp;

import com.myweb.dao.UserDao;
import com.myweb.entity.User;
import com.myweb.service.IUserService;

public class UserServiceImpl implements IUserService {
    private UserDao userDao;

    public void save(User tuser) {
        User user = new User();
        user.setGender(1);
        user.setLevel(1);
        user.setNationality("中国");
        Timestamp time1 = new Timestamp(System.currentTimeMillis());
        user.setRegTime(time1);
        user.setUserName("胡磊");
        //设定密码为默认值
        user.setPwd("123");
        this.userDao.save(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
