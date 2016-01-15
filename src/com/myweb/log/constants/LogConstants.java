package com.myweb.log.constants;

/**
 * 
 * @author huleiwind
 * @version $Id: LogConstants.java, v 0.1 2015-12-26 下午4:05:45 huleiwind Exp $
 */
public class LogConstants {
    /** 进入服务文案 */
    public final static String   SERVICE_ENTER               = "进入";

    /** 离开服务文案 */
    public final static String   SERVICE_LEAVE               = "退出";

    /** 截取个数 */
    public final static int      CUT_OFF_SIZE                = 10;

    /** 读操作方法名前缀列表 */
    public final static String[] QUERY_METHOD_PREFIX_LIST    = { "logon", "get", "query", "find",
            "list", "count", "is", "convert", "can", "download" };

    /** 业务执行结果是否成功的属性名 */
    public final static String   SUCCESS_PROPERTY            = "success";

    /** success属性的get方法 */
    public final static String   GET_SUCCESS_METHOD_NAME     = "getSuccess";

    /** success属性boolean值的is方法 */
    public final static String   IS_SUCCESS_METHOD_NAME      = "isSuccess";

    /** 时间单位 */
    public final static String   TIME_UNIT                   = "ms";

    /** 左中括号 */
    public final static String   LEFT_SQUARE_BRACKET         = "[";

    /** 右中括号 */
    public final static String   RIGHT_SQUARE_BRACKET        = "]";

    /** 左小括号 */
    public final static String   LEFT_PARENTHESES            = "(";

    /** 右小括号 */
    public final static String   RIGHT_PARENTHESES           = ")";

    /** 成功 */
    public final static String   SUCCESS_FLAG_YES            = "Y";

    /** 失败 */
    public final static String   SUCCESS_FLAG_NO             = "N";

    /** 未知 */
    public final static String   UNKOWN_FLAG                 = "-";

    /** 证件号码 */
    public final static String   CERT_NO_RULE                = "CERTNO";

    /** 密码号码 */
    public final static String   PASSWORD_RULE               = "PASSWORD";

    /** 银行卡号码 */
    public final static String   BANK_CARD_NO_RULE           = "BANKCARDNO";

    /** DAL层默认数据源名称 */
    public final static String   DEFAULT_DATASOURCE_KEY      = "DEFAULT";

    /** SAL层包名 */
    public final static String   INTEGRATION_PACKAGE_NAME    = "integration";

    /** ======================================logger names====================================*/

    /** log interceptor lib logger name */
    public final static String   COMMON_DIGEST_LOGGER_NAME   = "COMMON-DIGEST-LOG";

    /** biz service digest loggers name */
    public final static String   BIZ_SERVICE_LOGGER_NMAE     = "BIZ-SERVICE-DIGEST";

    /** query service digest loggers name */
    public final static String   QUERY_SERVICE_LOGGER_NMAE   = "QUERY-SERVICE-DIGEST";

    /** biz service in and out loggers name */
    public final static String   INVOKE_INOUT_LOGGER_NMAE    = "INVOKE-INOUT";

    /** biz DAL digest loggers name */
    public final static String   BIZ_DAL_LOGGER_NMAE         = "BIZ-DAL-DIGEST";

    /** query DAL digest loggers name */
    public final static String   QUERY_DAL_LOGGER_NMAE       = "QUERY-DAL-DIGEST";

    /** biz SAL digest loggers name */
    public final static String   BIZ_SAL_LOGGER_NMAE         = "BIZ-SAL-DIGEST";

    /** query SAL digest loggers name */
    public final static String   QUERY_SAL_LOGGER_NMAE       = "QUERY-SAL-DIGEST";

    /** receive message digest loggers name */
    public final static String   MESSAGE_RECEIVE_LOGGER_NMAE = "MSG-RECV-DIGEST";

    /** send message digest loggers name */
    public final static String   MESSAGE_SEND_LOGGER_NMAE    = "MSG-SEND-DIGEST";

}
