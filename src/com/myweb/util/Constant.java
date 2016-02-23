package com.myweb.util;

/**
 * 常量定义
 * @author huleiwind
 * @version $Id: Constant.java, v 0.1 2016-1-11 下午3:31:16 huleiwind Exp $
 */
public class Constant {
    /**
     * 男性
     */
    public final static int MANSEX              = 1;
    /**
     * 女性
     */
    public final static int WOMANSEX            = 2;

    /**
     * 管理员权限
     */
    public final static int ADMIN_LEVEL         = 1;
    /**
     * 普通用户权限
     */
    public final static int USER_LEVEL          = 0;

    /**
     * 默认起始页码
     */
    public final static int FIRST_PAGE_NO       = 1;
    /**
     * 默认页条数
     */
    public final static int PAGE_SIZE           = 100;

    /**
     * 回复别人
     */
    public final static int FOLLOW_OTHS         = 1;
    /**
     * 回复主题
     */
    public final static int FOLLOW_OBJ          = 0;

    /**
     * 可见
     */
    public final static int VIEW                = 1;
    /**
     * 不可见
     */
    public final static int NO_VIEW             = 0;

    /**
     * 话题按回复数量递减排序
     */
    public final static int ORDER_BY_FOLLOWNUMS = 1;
    /**
     * 话题按发表时间递减排序
     */
    public final static int ORDER_BY_TIME       = 2;
    /**
     * 话题按推荐排序
     */
    public final static int ORDER_BY_RECOM      = 3;
    /**
     * 等待回复排序（回复数为0）
     */
    public final static int ORDER_BY_TO_FOLLOW  = 4;

    /**
     * 取消话题关注
     */
    public final static int DEL_CARD_FAVORITE   = 0;
    /**
     * 新增话题关注
     */
    public final static int ADD_CARD_FAVORITE   = 1;

}
