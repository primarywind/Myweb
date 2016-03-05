package com.myweb.service;

import com.myweb.entity.User;
import com.myweb.result.BizResult;
import com.myweb.result.HotUserQueryResult;
import com.myweb.result.UserInfoQueryResult;

/**
 * 
 * @author huleiwind
 * @version $Id: IUserService.java, v 0.1 2015-10-8 上午11:03:48 huleiwind Exp $
 */
public interface IUserService {
    /**
     * 保存用户
     * @param name
     * @param password
     * @param sex
     * @param city
     * @return
     */
    public BizResult<User> saveUser(String name, String password, int sex, String city);

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

    /**
     * 更新用户信息
     * 
     * @param userId
     * @param sex
     * @param userName
     * @param nationality
     * @param blogUrl
     * @param faceImg
     * @return
     */
    public BizResult<User> updateUserInfo(Integer userId, int sex, String userName,
                                          String nationality, String blogUrl, String faceImg);

    /**
     * 按照发问数进行用户排序
     * @param hotUserSize
     * @return
     */
   public  HotUserQueryResult findHotUsers(int hotUserSize);
}
