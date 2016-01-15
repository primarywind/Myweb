package com.myweb.action;

import java.util.HashMap;
import java.util.Map;

import com.myweb.entity.User;
import com.myweb.result.BizResult;
import com.myweb.service.IUserService;
import com.myweb.util.Constant;
import com.opensymphony.xwork2.Action;
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
    private String            name;
    private String            passWord;
    public Map                responseJson;

    public String logon() {

        BizResult<User> bizResult = userService.logon(name, passWord);
        if (bizResult.getObject() == null) {
            return "logon_failed";
        }
        user = bizResult.getObject();
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("USER", bizResult.getObject());
        if (user.getLevel() == Constant.USER_LEVEL) {
            return "verify_user_ok";
        }
        if (user.getLevel() == Constant.ADMIN_LEVEL) {
            return "verify_admin_ok";
        }
        return "logon_failed";
    }

    public String logonOut() {
        Map<String, Object> attibutes = ActionContext.getContext().getSession();
        attibutes.remove("USER");
        return "logonOut_ok";
    }

    public String logonFailed() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("logonFailed", 1);
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String goToDiscuss() {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        User user = (User) session.get("USER");
        if (user == null) {
            return "verify_failed";
        }
        if (user.getLevel() == Constant.USER_LEVEL) {
            return "verify_user_ok";
        }
        return "verify_failed";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}
