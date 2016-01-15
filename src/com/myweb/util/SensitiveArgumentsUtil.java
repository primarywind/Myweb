package com.myweb.util;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myweb.log.constants.LogConstants;
import com.myweb.util.sensitive.annotations.SensitiveInfo;
import com.myweb.util.sensitive.rules.SensitiveRule;

/**
 *  敏感参数处理工具
 * @author huleiwind
 * @version $Id: SensitiveArgumentsUtil.java, v 0.1 2015-12-26 下午7:01:12 huleiwind Exp $
 */
public class SensitiveArgumentsUtil {

    /** logger for this libary */
    protected final static Log LOGGER = LogFactory.getLog(LogConstants.COMMON_DIGEST_LOGGER_NAME);

    public static Object[] processSensitiveArguments(MethodInvocation invocation,
                                                     Annotation[][] parameterAnnotations,
                                                     Map<String, Object> sensitiveRuleMap) {
        // 拷贝一份参数进行脱敏
        Object[] parameters = invocation.getArguments();
        Object[] changedParameters = new Object[parameters.length];
        for (int i = 0; i < changedParameters.length; i++) {
            changedParameters[i] = parameters[i];
        }

        // 循环获取参数上的注解
        for (int paramIndex = 0; paramIndex < parameterAnnotations.length; paramIndex++) {
            int length = parameterAnnotations[paramIndex].length;
            for (int k = 0; k < length; k++) {
                //获得指定的注释：  
                if (parameterAnnotations[paramIndex][k] instanceof SensitiveInfo) {
                    SensitiveInfo pa = (SensitiveInfo) parameterAnnotations[paramIndex][k];
                    if (null != pa) {
                        if (null == changedParameters[paramIndex]) {
                            continue;
                        }
                        // 如果参数类型不是字符串，跳过此参数的脱敏
                        if (!(changedParameters[paramIndex] instanceof String)) {
                            LOGGER.warn("不支持非字符串的参数脱敏");
                            continue;
                        }

                        // 获取自定义敏感信息脱敏工具
                        SensitiveRule rule = findCustomSensitiveRule(pa.value(), sensitiveRuleMap);
                        if (null != rule) {
                            // 自定义脱敏
                            changedParameters[paramIndex] = rule.maskSensitiveInfo(invocation,
                                (String) changedParameters[paramIndex]);
                        } else {
                            // 默认脱敏规则
                            changedParameters[paramIndex] = defaultMaskSensitiveInfo(pa.value(),
                                (String) changedParameters[paramIndex]);
                        }
                    }
                }
            }
        }

        return changedParameters;
    }

    /**
     * 查找自定义的敏感信息脱敏规则
     * 
     * @param ruleName
     * @param sensitiveRuleMap
     * @return
     */
    private static SensitiveRule findCustomSensitiveRule(String ruleName,
                                                         Map<String, Object> sensitiveRuleMap) {
        // 在自定义的规则map中查找脱敏规则
        if (sensitiveRuleMap.containsKey(ruleName)) {
            SensitiveRule rule = (SensitiveRule) sensitiveRuleMap.get(ruleName);
            return rule;
        }
        return null;
    }

    /**
     * 默认规则脱敏
     * 
     * @param type 脱敏规则类型
     * @param info 脱敏前字符串
     * @return 脱敏后字符串
     */
    private static String defaultMaskSensitiveInfo(String type, String info) {

        // 密码脱敏
        if (StringUtil.equalsIgnoreCase(type, SensitiveInfo.PASSWORD_RULE)) {
            return SensitiveInfoMaskUtil.maskPassword(info);
        }

        // 没有找到指定的脱敏类型
        LOGGER.warn("没有找到指定的脱敏规则， type is " + type);
        return info;
    }

}
