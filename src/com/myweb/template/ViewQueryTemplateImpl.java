package com.myweb.template;

import org.springframework.beans.BeanInstantiationException;
import org.springframework.util.Assert;

import com.myweb.result.QueryResult;

/**
 * 
 * @author huleiwind
 * @version $Id: ViewQueryTemplateImpl.java, v 0.1 2015-12-2 下午2:53:20 huleiwind Exp $
 */
public class ViewQueryTemplateImpl implements ViewQueryTemplate {

    @Override
    public <T extends QueryResult> T process(Class<T> clazz, QueryCallBack<T> callBack) {

        Assert.notNull(clazz, "Class must not be null");
        if (clazz.isInterface()) {
            throw new BeanInstantiationException(clazz, "Specified class is an interface");
        }

        T queryResult = (T) QueryResult.valueOfFailed();
        try {
            queryResult = clazz.newInstance();
            // 1. 实例化Result

            queryResult = clazz.newInstance();

            //2 校验参数 callback实现
            callBack.check();

            //3. 查询
            callBack.doProcess(queryResult);

        } catch (Exception e) {
            e.printStackTrace();
            queryResult.setSuccess(false);
            return queryResult;
        } finally {
            //残留对象销毁等等
        }
        return queryResult;
    }
}
