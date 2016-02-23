package com.myweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myweb.dao.FollowcardDao;
import com.myweb.entity.Followcard;
import com.myweb.util.PageNoUtil;

/**
 * 
 * @author huleiwind
 * @version $Id: FollowcardDaoImpl.java, v 0.1 2015-10-18 下午3:27:38 huleiwind Exp $
 */
public class FollowcardDaoImpl extends HibernateDaoSupport implements FollowcardDao {

    public List<Followcard> findByPages(int sendCardId, final int pageNo, final int pageSize,
                                        int followType) {
        //followType=0 为回复主题， =1为回复别人回复
        final String hql = "from Followcard s where s.followType=" + followType
                           + " and s.cardOrFollowId =" + sendCardId + "  order by s.pubTime desc";
        List<Followcard> lists = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return PageNoUtil.getList(session, hql, pageNo, pageSize);
            }
        });
        return lists;
    }

    public Integer save(Followcard followcard) {
        return (Integer) getHibernateTemplate().save(followcard);
    }

    @Override
    public Followcard findById(int id) {
        Followcard instance = (Followcard) getHibernateTemplate().get(
            "com.myweb.entity.Followcard", id);
        return instance;
    }

    @Override
    public List<Followcard> findByUserId(int userId, final int pageNo, final int pageSize) {
        //followType=0 为回复主题， =1为回复别人回复
        final String hql = "from Followcard f where f.userId=" + userId
                           + " and f.followType =0 order by f.pubTime desc";
        List<Followcard> lists = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return PageNoUtil.getList(session, hql, pageNo, pageSize);
            }
        });
        return lists;
    }
}
