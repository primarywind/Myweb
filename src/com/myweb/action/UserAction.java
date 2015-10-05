package com.myweb.action;

import com.myweb.entity.User;
import com.myweb.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
    /**  */
    private static final long serialVersionUID = -8606662112364181323L;

    private User              user;

    private IUserService      userService;

    public String reg() {
        System.out.println("reg ...");
        this.userService.save(user);
        return "reg_ok";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

}
