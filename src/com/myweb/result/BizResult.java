package com.myweb.result;

import java.io.Serializable;

/**
 * 
 * @author huleiwind
 * @version $Id: BizResult.java, v 0.1 2015-12-2 下午1:31:32 huleiwind Exp $
 */
public class BizResult<T> implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 162083564565883197L;

    /** 是否成功。*/
    private boolean           success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static <T> BizResult<T> valueOfFailed() {
        BizResult<T> result = new BizResult<T>();
        result.setSuccess(false);
        return result;
    }

    public static <T> BizResult<T> valueOfSuccessed() {
        BizResult<T> result = new BizResult<T>();
        result.setSuccess(true);
        return result;
    }
}
