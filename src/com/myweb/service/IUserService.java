package com.myweb.service;

import com.myweb.entity.User;
import com.myweb.result.BizResult;

/**
 * 
 * @author huleiwind
 * @version $Id: IUserService.java, v 0.1 2015-10-8 上午11:03:48 huleiwind Exp $
 */
public interface IUserService {
    /**
     * 保存用户
     * 
     * @param user
     */
    public Integer saveUser(User user);

    /**
     * 用户登录验证
     */
    public BizResult<User> logon(String userName, String password);
}
