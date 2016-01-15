package com.myweb.action;

import java.util.HashMap;
import java.util.Map;

import com.myweb.entity.User;
import com.myweb.result.BizResult;
import com.myweb.service.IUserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
    /**  */
    private static final long serialVersionUID = -8606662112364181323L;

    private String            name;
    private String            password;
    private String            sex;
    private String            city;
    private IUserService      userService;
    public Map                responseJson;

    public String registerUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        BizResult<User> bizResult = userService.saveUser(name, password, sex, city);

        if (bizResult.isSuccess()) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("USER", bizResult.getObject());
            map.put("msg", "注册成功");
        } else {
            map.put("msg", "注册失败");
        }

        this.setResponseJson(map);
        return Action.SUCCESS;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
