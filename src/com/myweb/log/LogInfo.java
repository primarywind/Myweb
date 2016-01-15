package com.myweb.log;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.myweb.util.StringUtil;

/**
 * 
 * @author huleiwind
 * @version $Id: LogInfo.java, v 0.1 2015-12-26 下午2:14:15 huleiwind Exp $
 */
public class LogInfo implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 7046982214482865087L;
    /** 服务类 */
    private String            serviceName;

    /** 服务方法 */
    private String            methodName;

    /** 服务开始时间 */
    private final long        startTime        = System.currentTimeMillis();

    /** 服务结束时间 */
    private long              endTime;

    /** 是否抛出异常 */
    private boolean           exceptional;

    /** 是否调用服务失败 */
    private boolean           isFailure;

    /** 返回错误信息 */
    private String            errorMsg;

    /** 调用参数 */
    private Object[]          args;

    /** 调用方应用名*/
    private String            appName;

    /**UUID*/
    private String            UUID;

    /** 操作类型 */
    private boolean           isQueryFunc;

    /**  
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    /**
     * 获取服务消耗时间
     * 
     * @return 服务消耗时间
     */
    public long getElapseTime() {
        this.endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * 获取追踪信息
     * 
     * @return 追踪信息
     */
    public String getInvokeTraceInfo() {
        return "(" + StringUtil.defaultIfBlank(this.appName, "-") + ","
               + StringUtil.defaultIfBlank(this.methodName, "-") + ","
               + StringUtil.defaultIfBlank(String.valueOf(this.startTime), "-") + ")";
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public long getStartTime() {
        return startTime;
    }

    public boolean isExceptional() {
        return exceptional;
    }

    public void setExceptional() {
        this.exceptional = true;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setUUID(String uUID) {
        UUID = uUID;
    }

    public String getUUID() {
        return UUID;
    }

    public String getAppName() {
        return appName;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public boolean isFailure() {
        return isFailure;
    }

    public void setFailure() {
        this.isFailure = true;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setFailure(boolean isFailure) {
        this.isFailure = isFailure;
    }

    public void setExceptional(boolean exceptional) {
        this.exceptional = exceptional;
    }

    public boolean isQueryFunc() {
        return isQueryFunc;
    }

    public void setQueryFunc(boolean isQueryFunc) {
        this.isQueryFunc = isQueryFunc;
    }

}
