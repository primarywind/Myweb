package com.myweb.util.sensitive.rules;

import org.aopalliance.intercept.MethodInvocation;

/**
 * 敏感信息脱敏规则
 * @author huleiwind
 * @version $Id: SensitiveRule.java, v 0.1 2015-12-26 下午7:59:38 huleiwind Exp $
 */
public interface SensitiveRule {

    /**
     * 去除敏感信息
     * 
     * @param info 待脱敏的信息
     * @return 脱敏后的信息
     */
    public String maskSensitiveInfo(MethodInvocation invocation, String info);
}
