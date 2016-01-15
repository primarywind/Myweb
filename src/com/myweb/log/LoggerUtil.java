package com.myweb.log;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * 
 * @author huleiwind
 * @version $Id: LoggerUtil.java, v 0.1 2015-12-26 下午1:37:18 huleiwind Exp $
 */
public class LoggerUtil {
    public static String formatMessage(String message, Object[] params) {
        if ((message == null) || (params == null) || (params.length == 0)) {
            return message;
        }
        return MessageFormat.format(message, params);
    }

    /**
     * 从resource bundle中取得格式化的消息.
     *
     * @param logger logger
     * @param key resource bundle key
     * @param params 参数数组
     *
     * @return 格式化的消息字符串, 如果resource bundle不存在, 或key未找到, 则返回<code>key</code>
     */
    public static String getMessage(Logger logger, Object key, Object[] params) {
        ResourceBundle bundle = logger.getResourceBundle();
        String keyStr = String.valueOf(key);
        String message = null;

        if (bundle == null) {
            logger.error(new StringBuffer().append("Resource bundle not set for logger \"")
                .append(logger).append("\"").toString());
        } else {
            try {
                message = getMessage(bundle, keyStr, params);
            } catch (MissingResourceException e) {
                logger.error(new StringBuffer().append("No resource is associated with key \"")
                    .append(keyStr).append("\" in logger \"").append(logger).append("\"")
                    .toString(), e);
            }
        }

        return (message == null) ? keyStr : message;
    }

    public static String getMessage(ResourceBundle bundle, String key, Object[] params) {
        if ((bundle == null) || (key == null)) {
            return key;
        }

        try {
            String message = bundle.getString(key);

            return formatMessage(message, params);
        } catch (MissingResourceException e) {
            return key;
        }
    }
}
