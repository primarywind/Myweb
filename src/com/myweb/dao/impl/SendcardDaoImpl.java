package com.myweb.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myweb.dao.SendcardDao;
import com.myweb.entity.Sendcard;
import com.myweb.util.Constant;
import com.myweb.util.PageNoUtil;

/**
 * 
 * @author huleiwind
 * @version $Id: SendcardDaoImpl.java, v 0.1 2015-10-18 下午3:14:10 huleiwind Exp $
 */
public class SendcardDaoImpl extends HibernateDaoSupport implements SendcardDao {

    public List<Sendcard> findByPages(final int pageNo, final int pageSize, final int orderType) {
        String temphql = null;
        if (orderType == Constant.ORDER_BY_TIME) {
            temphql = "from Sendcard s order by s.pubTime desc";
        } else if (orderType == Constant.ORDER_BY_FOLLOWNUMS) {
            temphql = "from Sendcard s order by s.followCount desc and s.pubTime desc";
        } else if (orderType == Constant.ORDER_BY_RECOM) {
            temphql = "from Sendcard s order by s.favoriteCount desc and s.pubTime desc";
        } else if (orderType == Constant.ORDER_BY_TO_FOLLOW) {
            temphql = "from Sendcard s where s.followCount=0  order by s.pubTime desc";
        } else {
            return new ArrayList<Sendcard>();
        }
        final String hql = temphql;
        List<Sendcard> lists = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return PageNoUtil.getList(session, hql, pageNo, pageSize);
            }
        });
        return lists;
    }

    public Sendcard findById(int id) {
        Sendcard instance = (Sendcard) getHibernateTemplate().get("com.myweb.entity.Sendcard", id);
        return instance;
    }

    public Integer save(Sendcard sendcard) {

        return (Integer) getHibernateTemplate().save(sendcard);
    }

    @Override
    public void update(Sendcard sendcard) {
        getHibernateTemplate().update(sendcard);
    }

    @Override
    public List<Sendcard> findByUserId(int userId, final int pageNo, final int pageSize) {
        final String hql = "from Sendcard s where s.userId =" + userId + " order by s.pubTime desc";
        List<Sendcard> lists = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return PageNoUtil.getList(session, hql, pageNo, pageSize);
            }
        });
        return lists;
    }

    @Override
    public int getTotalSize() {
        String hql = "select count(*) from Sendcard";
        Long a = (Long) getHibernateTemplate().find(hql).listIterator().next();
        int count = a.intValue();
        return count;
    }

    @Override public int getSendCardNumByUserId(int userId) {
        String hql = "select count(*) from Sendcard s where s.userId="+userId;
        Long a = (Long) getHibernateTemplate().find(hql).listIterator().next();
        int count = a.intValue();
        return count;
    }

}
