package com.myweb.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;

/**
 * 
 * @author huleiwind
 * @version $Id: TracerLoggerFactory.java, v 0.1 2015-12-26 下午6:41:29 huleiwind Exp $
 */
public class TracerLoggerFactory extends LoggerFactory {

    /**
     * 取得扩展的<code>Logger</code>.
     *
     * @param clazz 代表<code>Logger</code>名称的类
     * @return 扩展的<code>Logger</code>实现
     */
    @SuppressWarnings("rawtypes")
    public static Logger getLogger(Class clazz) {
        return getLogger(getLog(clazz));
    }

    /**
     * 取得扩展的<code>Logger</code>.
     *
     * @param name <code>Logger</code>名称
     * @return 扩展的<code>Logger</code>实现
     */
    public static Logger getLogger(String name) {
        return getLogger(getLog(name));
    }

    /**
     * 取得扩展的<code>Logger</code>, 如果指定的log对象已经实现了<code>Logger</code>接口, 则直接返回, 否则包装一下再返回.
     *
     * @param log 实现commons-logging的<code>Log</code>接口的对象
     * @return 扩展的<code>Logger</code>实现
     */
    private static Logger getLogger(Log log) {

        if (log instanceof TracerLogger) {
            return (TracerLogger) log;
        }

        return new TracerLogger(log);
    }

    @Override
    public Object getAttribute(String arg0) {
        return null;
    }

    @Override
    public String[] getAttributeNames() {
        return null;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Log getInstance(Class arg0) throws LogConfigurationException {
        return null;
    }

    @Override
    public Log getInstance(String arg0) throws LogConfigurationException {
        return null;
    }

    @Override
    public void release() {
    }

    @Override
    public void removeAttribute(String arg0) {
    }

    @Override
    public void setAttribute(String arg0, Object arg1) {
    }

}
