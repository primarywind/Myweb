package com.myweb.template;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myweb.log.constants.LogConstants;
import com.myweb.result.BizResult;

/**
 * 
 * @author huleiwind
 * @version $Id: ServiceTemplateImpl.java, v 0.1 2015-12-2 下午1:42:00 huleiwind Exp $
 */
public class ServiceTemplateImpl implements ServiceTemplate {
    /** logger for this libary */
    protected final static Log LOGGER = LogFactory.getLog(LogConstants.COMMON_DIGEST_LOGGER_NAME);

    @Override
    public <T> BizResult<T> serviceProcess(final ServiceCallBack<T> callback) {
        //默认设置错误
        BizResult<T> result = BizResult.valueOfFailed();
        try {
            //1.服务前回调方法
            callback.beforeService();
            //2.事务回调方法
            result = callback.executeService();
            //3.事务执行后方法
            callback.afterService(result);

        } catch (Exception e) {
            LOGGER.warn("执行服务出错", e);
            // 业务异常
            result.setSuccess(false);
            return result;
        } finally {
            //残留对象销毁等等

        }
        return result;
    }
}
