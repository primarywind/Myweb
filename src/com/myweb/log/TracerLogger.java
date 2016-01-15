package com.myweb.log;

import java.util.ResourceBundle;

import org.apache.commons.logging.Log;

/**
 * 
 * @author huleiwind
 * @version $Id: TracerLogger.java, v 0.1 2015-12-26 下午6:32:22 huleiwind Exp $
 */
public class TracerLogger implements Logger {

    /** 被封装的Log */
    private final Log      log;

    /** logger对应的资源束 */
    private ResourceBundle bundle;

    /**
     * 构造函数
     * @param log 封装的log
     */
    public TracerLogger(Log log) {
        this.log = log;
    }

    /**
     * 判断trace level是否被打开.
     *
     * @return 如果trace level被打开, 则返回<code>true</code>
     */
    @Override
    public boolean isTraceEnabled() {
        return log.isTraceEnabled();
    }

    /**
     * 判断debug level是否被打开.
     *
     * @return 如果debug level被打开, 则返回<code>true</code>
     */
    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    /**
     * 判断info level是否被打开.
     *
     * @return 如果info level被打开, 则返回<code>true</code>
     */
    @Override
    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    /**
     * 判断warn level是否被打开.
     *
     * @return 如果warn level被打开, 则返回<code>true</code>
     */
    @Override
    public boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }

    /**
     * 判断error level是否被打开.
     *
     * @return 如果error level被打开, 则返回<code>true</code>
     */
    @Override
    public boolean isErrorEnabled() {
        return log.isErrorEnabled();
    }

    /**
     * 判断fatal level是否被打开.
     *
     * @return 如果fatal level被打开, 则返回<code>true</code>
     */
    @Override
    public boolean isFatalEnabled() {
        return log.isFatalEnabled();
    }

    /**
     * 输出trace level的log信息.
     *
     * @param message log信息
     */
    @Override
    public void trace(Object message) {
        if (log.isTraceEnabled()) {
            log.trace(message);
        }
    }

    /**
     * 输出trace level的log信息.
     *
     * @param message log信息
     * @param cause 异常
     */
    @Override
    public void trace(Object message, Throwable cause) {
        if (log.isTraceEnabled()) {
            log.trace(message, cause);
        }
    }

    /**
     * 输出trace level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     */
    @Override
    public void trace(Object key, Object[] params) {
        if (log.isTraceEnabled()) {
            log.trace(LoggerUtil.getMessage(this, key, params));
        }
    }

    /**
     * 输出trace level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     * @param cause 异常
     */
    @Override
    public void trace(Object key, Object[] params, Throwable cause) {
        if (log.isTraceEnabled()) {
            log.trace(LoggerUtil.getMessage(this, key, params), cause);
        }
    }

    /**
     * 输出debug level的log信息.
     *
     * @param message log信息
     */
    @Override
    public void debug(Object message) {
        if (log.isDebugEnabled()) {
            log.debug(tranceInfoFormat(message));
        }
    }

    /**
     * 输出debug level的log信息.
     *
     * @param message log信息
     * @param cause 异常
     */
    @Override
    public void debug(Object message, Throwable cause) {
        if (log.isDebugEnabled()) {
            log.debug(tranceInfoFormat(message), cause);
        }
    }

    /**
     * 输出debug level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     */
    @Override
    public void debug(Object key, Object[] params) {
        if (log.isDebugEnabled()) {
            log.debug(tranceInfoFormat(LoggerUtil.getMessage(this, key, params)));
        }
    }

    /**
     * 输出debug level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     * @param cause 异常
     */
    @Override
    public void debug(Object key, Object[] params, Throwable cause) {
        if (log.isDebugEnabled()) {
            log.debug(tranceInfoFormat(LoggerUtil.getMessage(this, key, params)), cause);
        }
    }

    /**
     * 输出info level的log信息.
     *
     * @param message log信息
     */
    @Override
    public void info(Object message) {
        if (log.isInfoEnabled()) {
            log.info(tranceInfoFormat(message));
        }
    }

    /**
     * 输出info level的log信息.
     *
     * @param message log信息
     * @param cause 异常
     */
    @Override
    public void info(Object message, Throwable cause) {
        if (log.isInfoEnabled()) {
            log.info(tranceInfoFormat(message), cause);
        }
    }

    /**
     * 输出info level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     */
    @Override
    public void info(Object key, Object[] params) {
        if (log.isInfoEnabled()) {
            log.info(tranceInfoFormat(LoggerUtil.getMessage(this, key, params)));
        }
    }

    /**
     * 输出info level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     * @param cause 异常
     */
    @Override
    public void info(Object key, Object[] params, Throwable cause) {
        if (log.isInfoEnabled()) {
            log.info(tranceInfoFormat(LoggerUtil.getMessage(this, key, params)), cause);
        }
    }

    /**
     * 输出warn level的log信息.
     *
     * @param message log信息
     */
    @Override
    public void warn(Object message) {
        log.warn(tranceInfoFormat(message));
    }

    /**
     * 输出warn level的log信息.
     *
     * @param message log信息
     * @param cause 异常
     */
    @Override
    public void warn(Object message, Throwable cause) {
        log.warn(tranceInfoFormat(message), cause);
    }

    /**
     * 输出warn level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     */
    @Override
    public void warn(Object key, Object[] params) {
        if (log.isWarnEnabled()) {
            log.warn(tranceInfoFormat(LoggerUtil.getMessage(this, key, params)));
        }
    }

    /**
     * 输出warn level的log信息.
     *
     * @param key    代表log信息的resource bundle key
     * @param params 参数数组
     * @param cause  异常
     */
    @Override
    public void warn(Object key, Object[] params, Throwable cause) {
        if (log.isWarnEnabled()) {
            log.warn(tranceInfoFormat(LoggerUtil.getMessage(this, key, params)), cause);
        }
    }

    /**
     * 输出error level的log信息.
     *
     * @param message log信息
     */
    @Override
    public void error(Object message) {
        log.error(tranceInfoFormat(message));
    }

    /**
     * 输出error level的log信息.
     *
     * @param message log信息
     * @param cause   异常
     */
    @Override
    public void error(Object message, Throwable cause) {
        String casuedBy = LogInfoFilterUtil.genExcepMsg(cause);
        log.error(tranceInfoFormat(message, casuedBy), cause);
    }

    /**
     * 输出error level的log信息.
     *
     * @param key    代表log信息的resource bundle key
     * @param params 参数数组
     */
    @Override
    public void error(Object key, Object[] params) {
        if (log.isErrorEnabled()) {
            log.error(tranceInfoFormat(LoggerUtil.getMessage(this, key, params)));
        }
    }

    /**
     * 输出error level的log信息.
     *
     * @param key    代表log信息的resource bundle key
     * @param params 参数数组
     * @param cause  异常
     */
    @Override
    public void error(Object key, Object[] params, Throwable cause) {
        if (log.isErrorEnabled()) {
            log.error(tranceInfoFormat(LoggerUtil.getMessage(this, key, params)), cause);
        }
    }

    /**
     * 输出fatal level的log信息.
     *
     * @param message log信息
     */
    @Override
    public void fatal(Object message) {
        log.fatal(message);
    }

    /**
     * 输出fatal level的log信息.
     *
     * @param message log信息
     * @param cause   异常
     */
    @Override
    public void fatal(Object message, Throwable cause) {
        log.fatal(message, cause);
    }

    /**
     * 输出fatal level的log信息.
     *
     * @param key    代表log信息的resource bundle key
     * @param params 参数数组
     */
    @Override
    public void fatal(Object key, Object[] params) {
        if (log.isFatalEnabled()) {
            log.fatal(LoggerUtil.getMessage(this, key, params));
        }
    }

    /**
     * 输出fatal level的log信息.
     *
     * @param key    代表log信息的resource bundle key
     * @param params 参数数组
     * @param cause  异常
     */
    @Override
    public void fatal(Object key, Object[] params, Throwable cause) {
        if (log.isFatalEnabled()) {
            log.fatal(LoggerUtil.getMessage(this, key, params), cause);
        }
    }

    /**
     * 取得logger的字符串表示, 通常返回logger的名称.
     *
     * @return logger的字符串表示
     */
    @Override
    public String toString() {
        return log.toString();
    }

    /**
     * 格式化日志内容
     * @param message 待格式化的日志内容
     * @return        格式化后的日志内容
     */
    private String tranceInfoFormat(Object message) {
        return message + "[" + LogInfoUtil.getInvokeTraceStr(LogHolder.getDigestInfo()) + "]";
    }

    private String tranceInfoFormat(Object message, String causeBy) {
        return message + " " + causeBy + "["
               + LogInfoUtil.getInvokeTraceStr(LogHolder.getDigestInfo()) + "]";
    }

    /** 
     * @see com.alibaba.common.logging.Logger#getResourceBundle()
     */
    @Override
    public ResourceBundle getResourceBundle() {
        return bundle;
    }

    /** 
     * @see com.alibaba.common.logging.Logger#setResourceBundle(java.util.ResourceBundle)
     */
    @Override
    public void setResourceBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }

}