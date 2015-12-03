package com.myweb.template;

import com.myweb.result.QueryResult;

/**
 * 
 * @author huleiwind
 * @version $Id: ViewQueryTemplate.java, v 0.1 2015-12-2 下午2:45:45 huleiwind Exp $
 */
public interface ViewQueryTemplate {
    /**
     * 查询处理
     * 
     * @param clazz 结果类的Class，非空。clazz应当继承QueryResult;
     * @param queryContext 查询上下文
     * @param callBack 模板回调接口
     * @return
     */
    public <T extends QueryResult> T process(Class<T> clazz, QueryCallBack<T> callBack);
}
