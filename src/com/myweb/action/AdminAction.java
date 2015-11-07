package com.myweb.action;

import java.util.Map;

import com.myweb.entity.User;
import com.myweb.service.ICategoryService;
import com.myweb.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author huleiwind
 * @version $Id: AdminAction.java, v 0.1 2015-10-25 下午1:43:21 huleiwind Exp $
 */
public class AdminAction extends ActionSupport {
    /**  */
    private static final long serialVersionUID = -4149993028729686564L;
    private User              user;
    private IUserService      userService;
    private ICategoryService  categoryService;
    private String            name;
    private String            passWord;

    public Map                responseJson;

    public String logon() {
        user = userService.logon(name, passWord);
        if (user == null) {
            return "logon_failed";
        }
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("USER", user);
        return "logon_ok";
    }

    public String logonOut() {
        Map<String, Object> attibutes = ActionContext.getContext().getSession();
        attibutes.remove("USER");
        return "logonOut_ok";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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

    public Map getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(Map responseJson) {
        this.responseJson = responseJson;
    }

}
