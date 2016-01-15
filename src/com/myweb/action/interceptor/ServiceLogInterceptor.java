package com.myweb.action.interceptor;

import com.myweb.log.LogHolder;
import com.myweb.log.LogInfo;
import com.myweb.log.Logger;
import com.myweb.log.LoggerPrinter;
import com.myweb.log.TracerLoggerFactory;
import com.myweb.log.constants.LogConstants;

/**
 * 服务日志层
 * @author huleiwind
 * @version $Id: ServiceLogInterceptor.java, v 0.1 2015-12-26 下午5:50:40 huleiwind Exp $
 */
public class ServiceLogInterceptor extends LogInterceptor {
    /** biz service digest logger */
    private final static Logger BIZ_SERVICE_DIGEST_LOGGER   = TracerLoggerFactory
                                                                .getLogger(LogConstants.BIZ_SERVICE_LOGGER_NMAE);
    /** query service digest logger */
    private final static Logger QUERY_SERVICE_DIGEST_LOGGER = TracerLoggerFactory
                                                                .getLogger(LogConstants.QUERY_SERVICE_LOGGER_NMAE);

    /**
     * @see com.alipay.cifcommon.basic.log.digest.interceptor.LogInterceptor#putLogInfoIntoThreadLocal(com.alipay.cifcommon.basic.log.LogInfo)
     */
    @Override
    protected void putLogInfoIntoThreadLocal(LogInfo info) {
        LogHolder.setDigestInfo(info);
    }

    /**
     * @see com.alipay.cifcommon.basic.log.digest.interceptor.LogInterceptor#clearThreadLocal()
     */
    @Override
    protected void clearThreadLocal() {
        LogHolder.clean();
    }

    /**
     * @see com.alipay.cifcommon.basic.log.digest.interceptor.LogInterceptor#logDigest(com.alipay.cifcommon.basic.log.LogInfo, java.lang.Object)
     */
    @Override
    protected void logDigest(LogInfo logInfo, Object result) {
        if (logInfo.isQueryFunc()) {
            LoggerPrinter.logQueryServiceDigest(QUERY_SERVICE_DIGEST_LOGGER, logInfo, result);
        } else {
            LoggerPrinter.logBizServiceDigest(BIZ_SERVICE_DIGEST_LOGGER, logInfo, result);
        }
    }

    /**
     * @see com.alipay.cifcommon.basic.log.digest.interceptor.LogInterceptor#logMethodIn(com.alipay.cifcommon.basic.log.LogInfo)
     */
    @Override
    protected void logMethodIn(LogInfo logInfo) {
        // 只给写方法打印
        if (!logInfo.isQueryFunc()) {
            LoggerPrinter.logServiceIn(INVOKE_IN_OUT_LOGGER, logInfo);
        }
    }

    /**
     * @see com.alipay.cifcommon.basic.log.digest.interceptor.LogInterceptor#logMethodOut(com.alipay.cifcommon.basic.log.LogInfo, java.lang.Object)
     */
    @Override
    protected void logMethodOut(LogInfo logInfo, Object result) {
        // 只给写方法打印
        if (!logInfo.isQueryFunc()) {
            LoggerPrinter.logServiceOut(INVOKE_IN_OUT_LOGGER, logInfo, result);
        }
    }
}
