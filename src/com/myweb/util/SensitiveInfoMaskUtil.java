package com.myweb.util;

/**
 * 敏感信息隐藏工具类
 * @author huleiwind
 * @version $Id: SensitiveInfoMaskUtil.java, v 0.1 2015-12-26 下午8:05:45 huleiwind Exp $
 */
public class SensitiveInfoMaskUtil {

    /**
     * 隐藏密码信息
     * 
     * @param pwd 原密码
     * @return 隐藏后的密码
     */
    public static String maskPassword(String pwd) {
        return StringUtil.repeat("*", 6);
    }

    /**
     * 将银行卡号的部分隐藏。
     * 隐藏规则为：只显示银行卡前6位和后4位，其余部分用*代替。
     * @param cardNo 原银行卡号
     * @return 隐藏之后的卡号
     */
    public static String maskBankCardNo(String cardNo) {
        return maskMiddleString(6, 4, cardNo);
    }

    /**
     * 将身份证号码隐藏。
     * 
     * <p>除了前5位和后3位，其他都用*代替，比如411329198908224515显示为41132**********515 这样的形式</p>
     * 
     * @param certNo 原证件号
     * @return 隐藏之后的证件号
     */
    public static String maskCertNo(String certNo) {
        return maskMiddleString(5, 3, certNo);

    }

    /**
     * 隐藏字符串中间部分
     * 
     * @param leftLen 字符串左侧保留的长度
     * @param rightLen 字符串右侧保留的长度
     * @param srcStr 原字符串
     * @return 隐藏后结果
     */
    private static String maskMiddleString(int leftLen, int rightLen, String srcStr) {
        if (StringUtil.isBlank(srcStr)) {
            return srcStr;
        }

        if (srcStr.length() > (leftLen + rightLen)) {
            return StringUtil.left(srcStr, leftLen)
                   + StringUtil.repeat("*", srcStr.length() - (leftLen + rightLen))
                   + StringUtil.right(srcStr, rightLen);
        } else {
            return StringUtil.repeat("*", 6) + StringUtil.right(srcStr, 1);
        }
    }
}
