package com.myweb.action.interceptor;

import org.apache.struts2.ServletActionContext;

import com.myweb.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 
 * @author huleiwind
 * @version $Id: SessionIterceptor.java, v 0.1 2015-12-10 下午12:33:18 huleiwind Exp $
 */
public class SessionIterceptor extends AbstractInterceptor {

    /** serialVersionUID */
    private static final long serialVersionUID = -2778018142445335470L;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        //取得请求的URL  
        String url = ServletActionContext.getRequest().getRequestURL().toString();

        //对登录与注销请求直接放行,不予拦截  
        if (url.indexOf("logon") != -1 || url.indexOf("logonOut") != -1) {
            return invocation.invoke();
        }

        ActionContext ctx = invocation.getInvocationContext();
        User user = (User) ctx.getSession().get("USER");
        if (user != null) {
            return invocation.invoke();
        }
        //如果超时，返回提示页面
        return "logon_failed";
    }
}