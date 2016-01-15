package com.myweb.util.sensitive.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 脱敏注解
 * @author huleiwind
 * @version $Id: SensitiveInfo.java, v 0.1 2015-12-26 下午7:33:29 huleiwind Exp $
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface SensitiveInfo {
    /** 密码号码 */
    public final static String PASSWORD_RULE = "PASSWORD";

    /**
     * 脱敏规则
     * 
     * @return 脱敏规则名称
     */
    String value();
}
