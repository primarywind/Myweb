package com.myweb.log;

/**
 * 维护摘要日志上下文的本地线程变量
 * @author huleiwind
 * @version $Id: LogHolder.java, v 0.1 2015-12-26 下午2:12:38 huleiwind Exp $
 */
public class LogHolder {

    /** 过渡标记位 */
    private static boolean              newLogMode       = false;

    /** ThreadLocal */
    private static ThreadLocal<LogInfo> digestInfoHolder = new ThreadLocal<LogInfo>();

    public static void setDigestInfo(LogInfo cifDigestInfo) {
        digestInfoHolder.set(cifDigestInfo);
    }

    public static LogInfo getDigestInfo() {

        LogInfo result = digestInfoHolder.get();

        if (result == null) {
            result = new LogInfo();
            result.setAppName("LocalHost");
            result.setMethodName(Thread.currentThread().getName());
            setDigestInfo(result);
        }
        return result;
    }

    public static boolean hasContext() {
        return (digestInfoHolder.get() != null);
    }

    public static void clean() {
        digestInfoHolder.set(null);
    }

    public static long getTimeKey() {
        LogInfo digestInfo = getDigestInfo();

        long timeKey = 0;

        if (digestInfo != null) {
            timeKey = digestInfo.getStartTime();
        }

        return timeKey;
    }

    public static void setNewLogMode(boolean newLogMode) {
        LogHolder.newLogMode = newLogMode;
    }

    public static boolean isNewLogMode() {
        return LogHolder.newLogMode;
    }

}
