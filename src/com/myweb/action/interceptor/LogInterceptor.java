package com.myweb.action.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myweb.log.LogInfo;
import com.myweb.log.LogInfoUtil;
import com.myweb.log.Logger;
import com.myweb.log.TracerLoggerFactory;
import com.myweb.log.constants.LogConstants;
import com.myweb.util.SensitiveArgumentsUtil;

/**
 * 日志拦截器
 * @author huleiwind
 * @version $Id: LogInterceptor.java, v 0.1 2015-12-26 下午6:57:53 huleiwind Exp $
 */
public abstract class LogInterceptor implements MethodInterceptor {

    /** logger for this libary */
    protected final static Log    LOGGER               = LogFactory
                                                           .getLog(LogConstants.COMMON_DIGEST_LOGGER_NAME);

    /** biz service in and out logger */
    protected final static Logger INVOKE_IN_OUT_LOGGER = TracerLoggerFactory
                                                           .getLogger(LogConstants.INVOKE_INOUT_LOGGER_NMAE);

    private Map<String, Object>   sensitiveRuleMap     = new HashMap<String, Object>();

    /** 
     * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 创建LogInfo
        LogInfo logInfo = createLogInfo(invocation);

        // 准备日志信息
        prepareLogInfo(invocation, logInfo);

        // 进行服务调用
        Object result = null;
        try {
            result = invocation.proceed();
            return result;
        } catch (Exception ex) {
            logInfo.setExceptional();
            throw ex;
        } finally {

            // 打印日志信息
            printLogInfo(logInfo, result);

            // 清理线程变量
            clearThreadLocal();
        }
    }

    /**
     * 打印日志信息
     * 
     * @param logInfo
     * @param result
     */
    private void printLogInfo(LogInfo logInfo, Object result) {
        try {
            // log service out
            logMethodOut(logInfo, result);

            // 打印摘要日志
            logDigest(logInfo, result);
        } catch (Exception e) {
            LOGGER.warn("日志信息打印出错", e);
        }
    }

    /**
     * 准备日志信息
     * 
     * @param invocation
     * @param logInfo
     */
    private void prepareLogInfo(MethodInvocation invocation, LogInfo logInfo) {
        try {

            // 其他信息搜集
            completeCustomLogInfo(invocation, logInfo);

            // 公共信息搜集
            completeCommonLogInfo(invocation, logInfo);

            // 参数脱敏
            completeArgsLogInfo(invocation, logInfo);

            // 初始化LogInfo到线程变量
            putLogInfoIntoThreadLocal(logInfo);

            // log service in
            logMethodIn(logInfo);

        } catch (Exception e) {
            LOGGER.warn("日志信息采集出错", e);
        }
    }

    /**
     * 完成loginfo的公共信息
     * 
     * @param invocation
     * @param logInfo
     */
    protected void completeCommonLogInfo(MethodInvocation invocation, LogInfo logInfo) {
        String className = invocation.getMethod().getDeclaringClass().getSimpleName();
        String methodName = invocation.getMethod().getName();
        logInfo.setMethodName(className + "." + methodName);
    }

    /**
     * 默认空实现，可由子类添加自定义的实现
     * 
     * @param invocation
     * @param logInfo
     */
    protected void completeCustomLogInfo(MethodInvocation invocation, LogInfo logInfo) {
    }

    /**
     * 完善参数日志信息
     * 
     * @param invocation
     * @param logInfo
     */
    private void completeArgsLogInfo(MethodInvocation invocation, LogInfo logInfo) {
        // 获取调用的接口的实现类的方法
        Method targetMethod = null;
        try {
            targetMethod = invocation
                .getThis()
                .getClass()
                .getMethod(invocation.getMethod().getName(),
                    invocation.getMethod().getParameterTypes());

            // 获得所有参数的注解
            Annotation[][] parameterAnnotations = targetMethod.getParameterAnnotations();

            // 处理敏感参数
            Object[] changedParameters = SensitiveArgumentsUtil.processSensitiveArguments(
                invocation, parameterAnnotations, sensitiveRuleMap);

            // 将脱敏后的参数信息设置进LogInfo
            logInfo.setArgs(changedParameters);

        } catch (NoSuchMethodException e) {
            LOGGER.warn("没有找到指定方法", e);
        } catch (Exception e) {
            LOGGER.warn("敏感信息处理失败", e);
        }

    }

    /**
     * 创建LogInfo的新实例
     * 
     * @param invocation
     * @return LogInfo
     */
    private LogInfo createLogInfo(MethodInvocation invocation) {
        LogInfo info = new LogInfo();
        info.setQueryFunc(LogInfoUtil.isQueryFunc(invocation.getMethod().getName()));
        return info;
    }

    /**
     * 将LogInfo存入ThreadLocal
     * 注意如果将LogInfo存入了ThreadLocal，一定要重写clearThreadLocal清除LogInfo
     * 
     * @param info
     */
    protected void putLogInfoIntoThreadLocal(LogInfo info) {
    }

    /**
     *清理ThreadLocal
     * 
     */
    protected void clearThreadLocal() {
    }

    /**
     * 打印摘要日志
     */
    protected abstract void logDigest(LogInfo logInfo, Object result);

    /**
     * 打印进入服务日志，默认空实现，由有需要的子类重写
     */
    protected void logMethodIn(LogInfo logInfo) {
    }

    /**
     * 打印退出服务日志，默认空实现，由有需要的子类重写
     */
    protected void logMethodOut(LogInfo logInfo, Object result) {
    }

    public Map<String, Object> getSensitiveRuleMap() {
        return sensitiveRuleMap;
    }

    public void setSensitiveRuleMap(Map<String, Object> sensitiveRuleMap) {
        this.sensitiveRuleMap = sensitiveRuleMap;
    }

}
