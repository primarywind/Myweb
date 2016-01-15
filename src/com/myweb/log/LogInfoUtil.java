package com.myweb.log;

import java.lang.reflect.Method;

import com.myweb.log.constants.LogConstants;
import com.myweb.util.StringUtil;

/**
 * 日志信息LogInfo相关工具类
 * @author huleiwind
 * @version $Id: LogInfoUtil.java, v 0.1 2015-12-26 下午6:36:09 huleiwind Exp $
 */
public class LogInfoUtil {

    /** logger */
    private final static Logger LOGGER = TracerLoggerFactory
                                           .getLogger(LogConstants.COMMON_DIGEST_LOGGER_NAME);

    /**
     * 判断是否是查询函数
     * @param methodName 函数名
     * @return           是否是查询函数
     */
    public static boolean isQueryFunc(String methodName) {
        for (String prefix : LogConstants.QUERY_METHOD_PREFIX_LIST) {
            if (StringUtil.startsWith(methodName, prefix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取包含tracer id 的调用信息
     * 
     * @param info
     * @return tracer id
     */
    public static String getInvokeTraceStr(LogInfo info) {
        return "(" + StringUtil.defaultIfBlank(info.getAppName(), "-") + ","
               + StringUtil.defaultIfBlank(info.getUUID(), "-") + ","
               + StringUtil.defaultIfBlank(String.valueOf(info.getStartTime()), "-") + ")";
    }

    /**
     * 获取调用结果的成功属性来判断执行是否成功
     * 
     * @param result
     * @return 是否成功
     */
    public static boolean getResultSuccessProperty(Object result) {
        // isSuccess方法情况
        Method method = getDeclaredMethod(result, LogConstants.IS_SUCCESS_METHOD_NAME);
        if (null != method) {
            method.setAccessible(true);
            Boolean successBoolean;
            try {
                successBoolean = (Boolean) method.invoke(result);
                return successBoolean;
            } catch (Exception e) {
            }
        }

        // getSuccess方法情况
        method = getDeclaredMethod(result, LogConstants.GET_SUCCESS_METHOD_NAME);
        if (null != method) {
            method.setAccessible(true);
            String successString;
            try {
                successString = (String) method.invoke(result);
                return StringUtil.equals(successString, "true");
            } catch (Exception e) {
            }
        }
        return true;
    }

    /**
     * 获取类的实例的方法，包括父类定义的方法
     * 
     * @param object
     * @param methodName
     * @param parameterTypes
     * @return 方法或null
     */
    private static Method getDeclaredMethod(Object object, String methodName,
                                            Class<?>... parameterTypes) {
        Method method = null;

        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz
            .getSuperclass()) {
            try {
                method = clazz.getDeclaredMethod(methodName, parameterTypes);
                return method;
            } catch (Exception e) {
            }
        }
        return null;
    }
}
