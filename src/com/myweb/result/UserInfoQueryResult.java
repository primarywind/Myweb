package com.myweb.result;

import com.myweb.view.UserInfoView;

/**
 * 
 * @author huleiwind
 * @version $Id: UserInfoQueryResult.java, v 0.1 2016-2-20 下午2:43:25 huleiwind Exp $
 */
public class UserInfoQueryResult extends QueryResult {

    /** serialVersionUID */
    private static final long serialVersionUID = -4941649686907395307L;
    private UserInfoView      userInfoView;

    public UserInfoView getUserInfoView() {
        return userInfoView;
    }

    public void setUserInfoView(UserInfoView userInfoView) {
        this.userInfoView = userInfoView;
    }

}
