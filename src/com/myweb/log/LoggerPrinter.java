package com.myweb.log;

/**
 * 日志打印器
 * @author huleiwind
 * @version $Id: LoggerPrinter.java, v 0.1 2015-12-26 下午3:52:31 huleiwind Exp $
 */

public class LoggerPrinter {

    /**
     * 打印进入服务的摘要日志
     * 
     * @param logger
     * @param info
     */
    public static void logServiceIn(Logger logger, LogInfo info) {
        logger.info(LogMsgBuilder.buildMethodInLog(info));

    }

    /**
     * 打印退出服务的摘要日志
     * 
     * @param logger
     * @param info
     * @param result
     */
    public static void logServiceOut(Logger logger, LogInfo info, Object result) {
        logger.info(LogMsgBuilder.buildMethodOutLog(info, result));
    }

    /**
     * 打印facade服务层的写方法摘要日志
     * 
     * @param logger
     * @param info
     */
    public static void logBizServiceDigest(Logger logger, LogInfo info, Object result) {
        logger.info(LogMsgBuilder.buildDigestLogWithoutArgsAndResult(info, result));
    }

    /**
     * 打印SAL层的写方法摘要日志
     * 
     * @param logger
     * @param info
     * @param result
     */
    public static void logBizSalDigest(Logger logger, LogInfo info, Object result) {
        logger.info(LogMsgBuilder.buildDigestLog(info, result));
    }

    /**
     * 打印DAL层的写方法摘要日志
     * 
     * @param logger
     * @param info
     * @param result
     */
    public static void logBizDalDigest(Logger logger, LogInfo info, Object result) {
        logger.info(LogMsgBuilder.buildDigestLog(info, result));
    }

    /**
     * 打印收到消息的摘要日志
     * 
     * @param logger
     * @param info
     */
    public static void logRecvMsgDigest(Logger logger, LogInfo info, Object result) {
        logger.info(LogMsgBuilder.buildDigestLogWithoutArgsAndResult(info, result));
    }

    /**
     * 打印facade服务层的读方法的摘要日志
     * 
     * @param logger
     * @param info
     * @param result
     */
    public static void logQueryServiceDigest(Logger logger, LogInfo info, Object result) {
        logger.info(LogMsgBuilder.buildDigestLogWithBizResultFlag(info, result));
    }

    /**
     * 打印SAL层的读方法的摘要日志
     * 
     * @param logger
     * @param info
     * @param result
     */
    public static void logQuerySalDigest(Logger logger, LogInfo info, Object result) {
        logger.info(LogMsgBuilder.buildDigestLog(info, result));
    }

    /**
     * 打印DAL层的读方法的摘要日志
     * 
     * @param logger
     * @param info
     * @param result
     */
    public static void logQueryDalDigest(Logger logger, LogInfo info, Object result) {
        logger.info(LogMsgBuilder.buildDigestLog(info, result));
    }

    /**
     * 打印发送异步消息的摘要日志
     * 
     * @param logger
     * @param info
     * @param result
     */
    public static void logSendMsgDigest(Logger logger, LogInfo info, Object result) {
        logger.info(LogMsgBuilder.buildDigestLogWithBizResultFlag(info, result));
    }

}
