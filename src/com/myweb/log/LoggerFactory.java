package com.myweb.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author huleiwind
 * @version $Id: LoggerFactory.java, v 0.1 2015-12-26 下午12:59:31 huleiwind Exp $
 */
public abstract class LoggerFactory extends LogFactory {
    /**
     * 取得扩展的<code>Logger</code>.
     *
     * @param clazz 代表<code>Logger</code>名称的类
     *
     * @return 扩展的<code>Logger</code>实现
     */
    public static Logger getLogger(Class clazz) {
        return getLogger(getLog(clazz));
    }

    /**
     * 取得扩展的<code>Logger</code>.
     *
     * @param name <code>Logger</code>名称
     *
     * @return 扩展的<code>Logger</code>实现
     */
    public static Logger getLogger(String name) {
        return getLogger(getLog(name));
    }

    /**
     * 取得扩展的<code>Logger</code>, 如果指定的log对象已经实现了<code>Logger</code>接口, 则直接返回, 否则包装一下再返回.
     *
     * @param log 实现commons-logging的<code>Log</code>接口的对象
     *
     * @return 扩展的<code>Logger</code>实现
     */
    private static Logger getLogger(Log log) {
        if (log instanceof Logger) {
            return (Logger) log;
        }

        return new LoggerWrapper(log);
    }
}
