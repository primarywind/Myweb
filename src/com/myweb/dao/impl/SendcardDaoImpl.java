package com.myweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myweb.dao.SendcardDao;
import com.myweb.entity.Sendcard;
import com.myweb.util.PageNoUtil;

/**
 * 
 * @author huleiwind
 * @version $Id: SendcardDaoImpl.java, v 0.1 2015-10-18 下午3:14:10 huleiwind Exp $
 */
public class SendcardDaoImpl extends HibernateDaoSupport implements SendcardDao {

    public List<Sendcard> findByPages(final int pageNo, final int pageSize) {
        final String hql = "from Sendcard s order by s.pubTime desc";
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
        System.out.println("Dao" + sendcard.getViewCount());
        return (Integer) getHibernateTemplate().save(sendcard);
    }
}
