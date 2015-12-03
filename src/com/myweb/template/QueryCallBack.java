package com.myweb.template;

import com.myweb.result.QueryResult;

/**
 * 查询回调接口
 * @author huleiwind
 * @version $Id: QueryCallBack.java, v 0.1 2015-12-2 下午2:22:15 huleiwind Exp $
 */
public interface QueryCallBack<T extends QueryResult> {

    /**
     * 查询前的检查，一般是参数的检查
     */
    public void check();

    /**
     * 实际查询的处理回调方法
     * @return
     */
    public void doProcess(T result);

}
