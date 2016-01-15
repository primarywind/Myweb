package com.myweb.service.impl;

import java.sql.Timestamp;

import com.myweb.dao.UserDao;
import com.myweb.entity.User;
import com.myweb.result.BizResult;
import com.myweb.service.IUserService;
import com.myweb.template.ServiceCallBack;
import com.myweb.util.Constant;
import com.myweb.util.MD5Util;
import com.myweb.util.StringUtil;
import com.myweb.util.sensitive.annotations.SensitiveInfo;

/**
 * 用户模版服务
 * @author huleiwind
 * @version $Id: UserServiceImpl.java, v 0.1 2015-10-8 上午11:03:48 huleiwind Exp $
 */
public class UserServiceImpl extends BaseService implements IUserService {
    private UserDao userDao;

    public BizResult<User> saveUser(final String name, final String password, final String sex,
                                    final String city) {
        return getServiceTemplate().serviceProcess(new ServiceCallBack<User>() {
            @Override
            public void beforeService() {
                //检查是否非空
                if (StringUtil.isBlank(name) || StringUtil.isBlank(password)
                    || StringUtil.isBlank(sex) || StringUtil.isBlank(city)) {
                    //异常类待细分，现统一抛出运行时异常
                    throw new RuntimeException();
                }
                //检查是否合法
                if (!StringUtil.equals(sex, Constant.WOMANSEX + "")
                    && !StringUtil.equals(sex, Constant.MANSEX + "")) {
                    //异常类待细分，现统一抛出运行时异常
                    throw new RuntimeException();
                }
            }

            @Override
            public BizResult<User> executeService() {
                User user = new User();
                user.setName(name);
                user.setGender(Integer.parseInt(sex));
                user.setNationality(city);
                user.setLevel(Constant.USER_LEVEL);
                user.setRegTime(new Timestamp(System.currentTimeMillis()));
                try {
                    user.setPwd(MD5Util.md5Encode(password));
                } catch (Exception e) {
                    //异常类待细分，现统一抛出运行时异常
                    throw new RuntimeException();
                }
                userDao.save(user);
                BizResult<User> bizResult = BizResult.valueOfSuccessed();
                bizResult.setObject(user);
                return bizResult;
            }

            @Override
            public void afterService(BizResult<User> result) {
            }
        });
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public BizResult<User> logon(final String name,
                                 @SensitiveInfo(SensitiveInfo.PASSWORD_RULE) final String password) {
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
