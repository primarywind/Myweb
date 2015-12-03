package com.myweb.template;

import com.myweb.result.BizResult;

public interface ServiceCallBack<T> {
    /**
     * 事务前方法
     */
    void beforeService();

    /**
     * 执行业务事务
     *
     * @param bizContext 业务上下文
     * @return 业务执行结果
     */
    BizResult executeService();

    /**
     * 事务后方法，beforeService失败的时候不执行
     *
     * @param bizContext 业务上下文
     */
    void afterService(BizResult<T> result);
}
