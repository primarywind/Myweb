package com.myweb.log;

import java.util.ResourceBundle;

import org.apache.commons.logging.Log;

/**
 * 
 * @author huleiwind
 * @version $Id: Logger.java, v 0.1 2015-12-26 下午1:01:12 huleiwind Exp $
 */
public interface Logger extends Log {
    /**
     * 输出trace level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     */
    void trace(Object key, Object[] params);

    /**
     * 输出trace level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     * @param cause 异常
     */
    void trace(Object key, Object[] params, Throwable cause);

    /**
     * 输出debug level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     */
    void debug(Object key, Object[] params);

    /**
     * 输出debug level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     * @param cause 异常
     */
    void debug(Object key, Object[] params, Throwable cause);

    /**
     * 输出info level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     */
    void info(Object key, Object[] params);

    /**
     * 输出info level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     * @param cause 异常
     */
    void info(Object key, Object[] params, Throwable cause);

    /**
     * 输出warn level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     */
    void warn(Object key, Object[] params);

    /**
     * 输出warn level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     * @param cause 异常
     */
    void warn(Object key, Object[] params, Throwable cause);

    /**
     * 输出error level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     */
    void error(Object key, Object[] params);

    /**
     * 输出error level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     * @param cause 异常
     */
    void error(Object key, Object[] params, Throwable cause);

    /**
     * 输出fatal level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     */
    void fatal(Object key, Object[] params);

    /**
     * 输出fatal level的log信息.
     *
     * @param key 代表log信息的resource bundle key
     * @param params 参数数组
     * @param cause 异常
     */
    void fatal(Object key, Object[] params, Throwable cause);

    /**
     * 取得logger对应的资源束.
     *
     * @return 资源束
     */
    ResourceBundle getResourceBundle();

    /**
     * 设置logger对应的资源束.
     *
     * @param bundle 资源束
     */
    void setResourceBundle(ResourceBundle bundle);

    /**
     * 取得logger的字符串表示, 通常返回logger的名称.
     *
     * @return logger的字符串表示
     */
    String toString();
}
