package com.myweb.template;

import com.myweb.result.BizResult;

/**
 * 
 * @author huleiwind
 * @version $Id: ServiceTemplate.java, v 0.1 2015-12-2 下午12:14:14 huleiwind Exp $
 */
public interface ServiceTemplate {
    /**
     * 
     * <p>
     *   <b>执行服务，并且发送普通消息</b>
     * </p>
     * @param callback  回调函数,用以实现具体业务内容
     * 
     * @return   基础的结果类
     * */
    public <T> BizResult<T> serviceProcess(ServiceCallBack<T> callback);
}
