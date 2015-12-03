/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.myweb.template;

import com.myweb.result.BizResult;

/**
 * 
 * @author huleiwind
 * @version $Id: ServiceTemplateImpl.java, v 0.1 2015-12-2 下午1:42:00 huleiwind Exp $
 */
public class ServiceTemplateImpl implements ServiceTemplate {

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
            e.printStackTrace();
            // 业务异常
            result.setSuccess(false);
            return result;
        } finally {
            //残留对象销毁等等

        }
        return result;
    }
}
