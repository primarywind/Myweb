package com.myweb.service.impl;

import com.myweb.dao.UserDao;
import com.myweb.entity.User;
import com.myweb.service.IUserService;
import com.myweb.util.MD5Util;

/**
 * 
 * @author huleiwind
 * @version $Id: UserServiceImpl.java, v 0.1 2015-10-8 上午11:03:48 huleiwind Exp $
 */
public class UserServiceImpl extends BaseService implements IUserService {
    private UserDao userDao;

    public Integer saveUser(User user) {
        return userDao.save(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User logon(String name, String password) {
        String md5Password = null;
        try {
            md5Password = MD5Util.md5Encode(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = userDao.findByNameAndPassowrd(name, md5Password);
        return user;
    }
}
