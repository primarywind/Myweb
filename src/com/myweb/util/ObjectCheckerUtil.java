package com.myweb.util;

import java.util.Collection;

/**
 * 
 * @author huleiwind
 * @version $Id: ObjectCheckerUtil.java, v 0.1 2015-10-4 下午8:13:49 huleiwind Exp $
 */
public class ObjectCheckerUtil {
    /**
     * 检查一个集合是否为空
     * 
     * @param collection
     * @return 是否为空
     */
    public static boolean checkEmptyCollection(Collection<?> collection) {
        if (null == collection || collection.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 检查一个对象是否为空
     * 针对String和Collection类型对象
     * @param obj
     * @return 是否为空
     */
    public static boolean checkEmpty(Object obj) {
        if (null == obj) {
            return true;
        }

        if (obj instanceof String && StringUtil.isBlank((String) obj)) {
            return true;
        }

        if (obj instanceof Collection) {
            return checkEmptyCollection((Collection<?>) obj);
        }
        return false;
    }

    /**
     * 检查一个对象是否不为空
     * 
     * @param obj
     * @return 是否不为空
     */
    public static boolean checkNotEmpty(Object obj) {
        return !checkEmpty(obj);
    }

    /**
     * 检查一系列的Object是否为空
     * 如果有一个Object为空，就返回true
     * 如果所有的Object都不为空，返回false
     * 
     * @param objs
     * @return 是否为空
     */
    public static boolean containEmpty(Object... objs) {

        if (checkEmpty(objs)) {
            return true;
        }

        for (Object obj : objs) {

            if (checkEmpty(obj)) {
                return true;
            }
            if (obj instanceof Collection) {
                checkEmptyCollection((Collection<?>) obj);
            }

        }
        return false;
    }

    /**
     * 检查一系列的Object是否不为空
     * 如果所有的Object都不为空，返回true
     * 如果有一个或者更多的Object为空，返回false
     * 
     * @param objs
     * @return 是否为空
     */
    public static boolean checkAllNotEmpty(Object... objs) {
        return !containEmpty(objs);
    }

    /**
     * 检查一系列的Object是否全为空
     * 如果所有的Object都为空，返回true
     * 如果有一个或者更多的Object不为空，返回false
     * 
     * @param objs
     * @return 是否全为空
     */
    public static boolean checkAllEmpty(Object... objs) {

        if (checkEmpty(objs)) {
            return true;
        }
        for (Object obj : objs) {
            if (!checkEmpty(obj)) {
                return false;
            }
        }
        return true;
    }
}
