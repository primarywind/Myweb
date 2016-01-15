package com.myweb.util.sensitive.rules.impl;

import org.aopalliance.intercept.MethodInvocation;

import com.myweb.util.SensitiveInfoMaskUtil;
import com.myweb.util.sensitive.rules.SensitiveRule;

/**
 * 密码脱敏规则
 * @author huleiwind
 * @version $Id: PasswordSensitiveRule.java, v 0.1 2015-12-26 下午8:01:31 huleiwind Exp $
 */
public class PasswordSensitiveRule implements SensitiveRule {

    /**
     * @see com.alipay.cifcommon.basic.sensitive.rules.SensitiveRule#maskSensitiveInfo(org.aopalliance.intercept.MethodInvocation, java.lang.String)
     */
    @Override
    public String maskSensitiveInfo(MethodInvocation invocation, String info) {
        return SensitiveInfoMaskUtil.maskPassword(info);
    }

}
