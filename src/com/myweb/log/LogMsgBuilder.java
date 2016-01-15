package com.myweb.log;

import java.lang.reflect.Array;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.ArrayUtils;

import com.myweb.log.constants.LogConstants;
import com.myweb.util.StringUtil;

/**
 * 日志信息组装器
 * @author huleiwind
 * @version $Id: LogMsgBuilder.java, v 0.1 2015-12-26 下午4:02:50 huleiwind Exp $
 */
public class LogMsgBuilder {

    /**
     * 生成进入层次的日志
     * 
     * @param info
     * @return 进入日志信息
     */
    public static String buildMethodInLog(LogInfo info) {
        StringBuilder builder = new StringBuilder();

        builder.append(LogConstants.SERVICE_ENTER);

        // 添加调用层次信息
        builder.append(addInternalBracket(buildDigestInfo(info, null, false, true)));

        // 添加参数信息
        builder.append(addInternalBracket(genParamString(info.getArgs())));

        return addOutterBracket(builder.toString());
    }

    /**
     * 生成离开层次的日志
     * 
     * @param info
     * @return 离开日志信息
     */
    public static String buildMethodOutLog(LogInfo info, Object result) {
        StringBuilder builder = new StringBuilder();

        builder.append(LogConstants.SERVICE_LEAVE);

        // 添加调用层次信息
        builder.append(addInternalBracket(buildDigestInfo(info, result, true, true)));

        // 添加结果信息
        builder.append(addInternalBracket(genResultString(result)));

        return addOutterBracket(builder.toString());
    }

    /**
     * 生成带参数和结果的摘要日志
     * 
     * @param info
     * @param result
     * @return 摘要日志信息
     */
    public static String buildDigestLog(LogInfo info, Object result) {
        StringBuilder builder = new StringBuilder();
        // 添加调用层次信息
        builder.append(addInternalBracket(buildDigestInfo(info, result, true, false)));
        // dal层会加数据源，sal层会加外部系统名称
        if (StringUtil.isNotBlank(info.getServiceName())) {
            builder.append(addInternalBracket(info.getServiceName()));
        }
        // 添加参数信息
        builder.append(addInternalBracket(genDigestParamsString(info.getArgs())));
        // 添加结果信息
        builder.append(addInternalBracket(getResultSize(result)));

        return addOutterBracket(builder.toString());
    }

    /**
     * 生成不带参数结果的摘要日志
     * 
     * @param info
     * @param result
     * @return 摘要日志信息
     */
    public static String buildDigestLogWithoutArgsAndResult(LogInfo info, Object result) {
        StringBuilder builder = new StringBuilder();
        // 添加调用层次信息
        builder.append(addInternalBracket(buildDigestInfo(info, result, true, true)));
        return addOutterBracket(builder.toString());
    }

    /**
     * 生成摘要日志使用业务结果方式判断执行结果
     * 即判断结果的success属性的值
     * 
     * @param info
     * @param result
     * @return 生成结果
     */
    public static String buildDigestLogWithBizResultFlag(LogInfo info, Object result) {
        StringBuilder builder = new StringBuilder();
        // 添加调用层次信息
        builder.append(addInternalBracket(buildDigestInfo(info, result, true, true)));
        if (StringUtil.isNotBlank(info.getServiceName())) {
            builder.append(addInternalBracket(info.getServiceName()));
        }
        // 添加参数信息
        builder.append(addInternalBracket(genDigestParamsString(info.getArgs())));
        // 添加结果信息
        builder.append(addInternalBracket(getResultSize(result)));

        return addOutterBracket(builder.toString());
    }

    /**
     * 生成层次调用相关摘要信息字符串
     * 
     * @param info
     * @param result
     * @return 格式化后的调用层次相关信息字符串，形如：
     * <li>(类名.方法名,Y,-,5ms)</li>
     */
    private static String buildDigestInfo(LogInfo info, Object result, boolean hasResult,
                                          boolean bizResultFlag) {

        ArrayList<String> strList = new ArrayList<String>();
        // 获取类型名和方法名的拼接
        strList.add(info.getMethodName());
        // 获取结果是否成功
        if (hasResult) {
            strList.add(getSuccessFlag(info, result, bizResultFlag));
        } else {
            // 还没有生成结果的情况，例如进入服务日志的打印
            strList.add(LogConstants.UNKOWN_FLAG);
        }
        strList.add(LogConstants.UNKOWN_FLAG);
        // 获取执行时间
        strList.add(info.getElapseTime() + LogConstants.TIME_UNIT);

        return StringUtil.join(strList, ",");
    }

    /**
     * 获取执行结果的标识
     * 
     * @param result
     * @return 执行结果标识
     * <ul>
     *  <li>"Y"执行成功</li>
     *  <li>"N"执行失败</li>
     *  <li>"-"业务请求没有返回结果或者返回结果中没有success字段</li>
     * </ul>
     */
    private static String getSuccessFlag(LogInfo info, Object result, boolean bizResultFlag) {
        // 如果捕获到异常，设置结果为失败
        if (null == info || info.isExceptional()) {
            return LogConstants.SUCCESS_FLAG_NO;
        }
        // service层，dal层 如果没抛异常就返回正确
        if (!bizResultFlag) {
            return LogConstants.SUCCESS_FLAG_YES;
        }

        if (result == null) {
            // 读请求
            if (info.isQueryFunc()) {
                return LogConstants.SUCCESS_FLAG_NO;
            }
            // 写请求
            else {
                return LogConstants.SUCCESS_FLAG_YES;
            }
        }
        if (result instanceof Boolean) {
            return (Boolean) result ? LogConstants.SUCCESS_FLAG_YES : LogConstants.SUCCESS_FLAG_NO;
        }
        try {
            return LogInfoUtil.getResultSuccessProperty(result) ? LogConstants.SUCCESS_FLAG_YES
                : LogConstants.SUCCESS_FLAG_NO;
        } catch (Exception e) {
            return LogConstants.SUCCESS_FLAG_YES;
        }
    }

    /**
     * 得到结果个数，如果返回值是数组或者集合的大小
     * 
     * @param result      摘要结果
     * @return String     返回结果大小信息
     */
    private static String getResultSize(Object result) {
        StringBuilder builder = new StringBuilder();
        builder.append("resultSize=");

        if (result == null) {
            builder.append(0);
        } else if (result instanceof Collection<?>) {
            builder.append(((Collection<?>) result).size());
        } else if (result.getClass().isArray()) {
            builder.append(Array.getLength(result));
        } else {
            builder.append(1);
        }

        return builder.toString();
    }

    /**
     * 完整的参数组装成字符串
     * 
     * @param args
     * @return
     */
    private static String genParamString(Object[] args) {
        if (args == null || args.length == 0) {
            return addInternalBracket(LogConstants.UNKOWN_FLAG);
        }

        StringBuilder builder = new StringBuilder();
        for (Object each : args) {
            builder.append(LogConstants.LEFT_PARENTHESES);
            if (each != null) {
                builder.append(each);
            } else {
                builder.append(LogConstants.UNKOWN_FLAG);
            }
            builder.append(LogConstants.RIGHT_PARENTHESES);
        }
        return builder.toString();

    }

    /**
     * 完整的参数组装成字符串
     * 
     * @param args
     * @return
     */
    private static String genResultString(Object arg) {
        if (arg == null) {
            return addInternalBracket(LogConstants.UNKOWN_FLAG);
        }
        StringBuilder builder = new StringBuilder();
        builder.append(LogConstants.LEFT_PARENTHESES);
        builder.append(arg);
        builder.append(LogConstants.RIGHT_PARENTHESES);
        return builder.toString();

    }

    /**
     * 摘要日志的部分参数组装，防止摘要日志过大
     * 
     * @param args 查询参数
     * @return
     */
    private static String genDigestParamsString(Object[] args) {

        if (args == null || args.length == 0) {
            return addInternalBracket(LogConstants.UNKOWN_FLAG);
        }

        StringBuilder builder = new StringBuilder();
        for (Object each : args) {
            builder.append(LogConstants.LEFT_PARENTHESES);
            if (each != null) {
                if (each instanceof Collection<?>) {
                    builder.append(cutOffCollection((Collection<?>) each) + ",size="
                                   + ((Collection<?>) each).size());
                } else if (each.getClass().isArray()) {
                    builder.append(cutOffArray(each) + ",size=" + Array.getLength(each));
                } else if (each instanceof Principal) {
                    builder.append(((Principal) each).getName());
                } else {
                    builder.append(each);
                }
            } else {
                builder.append(LogConstants.UNKOWN_FLAG);
            }
            builder.append(LogConstants.RIGHT_PARENTHESES);
        }
        return builder.toString();
    }

    /**
     * 如果集合size大于10，截取十位
     * 
     * @param collection  集合
     * @return            数组前十位构成的字符串
     */
    private static Object cutOffCollection(Collection<?> collection) {
        if (collection.size() > LogConstants.CUT_OFF_SIZE) {
            //手工遍历转为数组，防止大集合
            Object[] objectArray = new Object[LogConstants.CUT_OFF_SIZE];
            int i = 0;
            for (Object object : collection) {
                if (i >= LogConstants.CUT_OFF_SIZE) {
                    break;
                }
                objectArray[i] = object;
                i++;
            }
            return cutOffArray(objectArray);
        } else {
            return cutOffArray(collection.toArray());
        }
    }

    /**
     * 如果数组length大于10，截取十位,主要兼容long[],int[]转化为Object[]
     * 
     * @param array 数组
     * @return      数组前十位构成的字符串
     */
    private static String cutOffArray(Object array) {
        if (Array.getLength(array) > LogConstants.CUT_OFF_SIZE) {

            //手工遍历转为数组，主要兼容long[],int[]转化为Object[]
            Object[] objectArray = new Object[LogConstants.CUT_OFF_SIZE];
            for (int i = 0; i < LogConstants.CUT_OFF_SIZE; i++) {
                objectArray[i] = String.valueOf(Array.get(array, i));
            }
            return ArrayUtils.toString(ArrayUtils.subarray(objectArray, 0,
                LogConstants.CUT_OFF_SIZE));
        } else {
            return ArrayUtils.toString(array);
        }
    }

    /**
     * 如果数组length大于10，截取十位
     * 
     * @param array 数组
     * @return      数组前十位构成的字符串
     */
    private static String cutOffArray(Object[] array) {
        if (array.length > LogConstants.CUT_OFF_SIZE) {
            return ArrayUtils.toString(ArrayUtils.subarray(array, 0, LogConstants.CUT_OFF_SIZE));
        } else {
            return ArrayUtils.toString(array);
        }
    }

    /**
     * 构建摘要日志内部的边框，目前是在字符串外围添加小括号
     * 
     * @param str
     * @return
     */
    private static String addInternalBracket(String str) {
        return addBracket(str, LogConstants.LEFT_PARENTHESES, LogConstants.RIGHT_PARENTHESES);
    }

    /**
     * 构建摘要日志格式外部边框，目前是在字符串外边添加大括号
     * 
     * @param str
     * @return
     */
    private static String addOutterBracket(String str) {
        return addBracket(str, LogConstants.LEFT_SQUARE_BRACKET, LogConstants.RIGHT_SQUARE_BRACKET);
    }

    /** 在字符串外围加边框，比如各种括号 */
    private static String addBracket(String str, String leftFrame, String rightFrame) {
        if (StringUtil.isBlank(str)) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(leftFrame);
        builder.append(str);
        builder.append(rightFrame);
        return builder.toString();
    }
}
