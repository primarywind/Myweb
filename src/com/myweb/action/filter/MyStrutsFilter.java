package com.myweb.action.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class MyStrutsFilter extends StrutsPrepareAndExecuteFilter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
                                                                                    throws IOException,
                                                                                    ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        //不过滤的url
        String url = request.getRequestURI();
        String contextPath = request.getContextPath();
        HttpServletResponse response = (HttpServletResponse) res;
        if (url.endsWith("jsp")) {
            chain.doFilter(req, res);
        } else {
            super.doFilter(req, res, chain);
        }
    }
}