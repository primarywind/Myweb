/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.myweb.result;

import java.io.Serializable;

/**
 * 
 * @author huleiwind
 * @version $Id: QueryResult.java, v 0.1 2015-12-2 下午2:23:29 huleiwind Exp $
 */
public class QueryResult implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -7116342709416472537L;
    /** 是否成功 */
    private boolean           success          = true;

    public static QueryResult valueOfFailed() {
        QueryResult result = new QueryResult();
        result.setSuccess(false);
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
