package com.myweb.service.impl;

import com.myweb.dao.UserDao;
import com.myweb.entity.User;
import com.myweb.service.IUserService;

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
}
