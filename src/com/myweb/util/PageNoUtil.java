package com.myweb.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**

 *本工具类主要用来实现分页

 */

public class PageNoUtil {
    /**
         * @param             session :一个会话
         * @param            hql:是需要执行的hql语句，
         * @param            pageNo 设置开始页数
         * @param              pageSize读取记录条数
         * return             返回结果集List<?>
         */
    public static List<?> getList(Session session, String hql, int pageNo, int pageSize) {
        Query q = session.createQuery(hql);
        q.setFirstResult((pageNo - 1) * pageSize);
        q.setMaxResults(pageSize);
        List<?> list = q.list();
        return list;
    }

}