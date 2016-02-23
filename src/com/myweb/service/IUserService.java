package com.myweb.service;

import com.myweb.entity.User;
import com.myweb.result.BizResult;
import com.myweb.result.UserInfoQueryResult;

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
    public BizResult<User> saveUser(String name, String password, String sex, String city);

    /**
     * 用户登录验证
     */
    public BizResult<User> logon(String userName, String password);

    /**
     * 获取用户个人信息
     * 
     * @param userId
     * @return
     */
    public UserInfoQueryResult getUserInfo(Integer userId, Integer pageNo, Integer pageSize);
}
