package com.myweb.service.impl;

import com.myweb.dao.UserDao;
import com.myweb.entity.User;
import com.myweb.result.BizResult;
import com.myweb.service.IUserService;
import com.myweb.template.ServiceCallBack;
import com.myweb.util.MD5Util;

/**
 * 用户模版服务
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

    public BizResult<User> logon(final String name, final String password) {
        return getServiceTemplate().serviceProcess(new ServiceCallBack<User>() {
            @Override
            public void beforeService() {
            }

            @Override
            public BizResult<User> executeService() {
                String md5Password = null;
                try {
                    md5Password = MD5Util.md5Encode(password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                User user = userDao.findByNameAndPassowrd(name, md5Password);
                BizResult<User> bizResult = BizResult.valueOfSuccessed();
                bizResult.setObject(user);
                return bizResult;
            }

            @Override
            public void afterService(BizResult<User> result) {
            }
        });

    }
}
