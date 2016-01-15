package com.myweb.log;

import com.myweb.util.StringUtil;

/**
 * 
 * @author huleiwind
 * @version $Id: LogInfoFilterUtil.java, v 0.1 2015-12-26 下午2:23:23 huleiwind Exp $
 */
public class LogInfoFilterUtil {
    /**
     * 生成系统异常信息
     */
    public static String genExcepMsg(Throwable target) {

        while (target.getCause() != null) {
            target = target.getCause();
        }

        int count = StringUtil.defaultIfBlank(target.getMessage(), "").length();
        if (count > 3) {
            //返回最初的异常的信息，去除最后可能的换行
            return target.getMessage().substring(0, target.getMessage().length() - 3);
        } else {
            //如果信息过短，返回异常类名
            return target.getClass().getSimpleName();
        }

    }
}
