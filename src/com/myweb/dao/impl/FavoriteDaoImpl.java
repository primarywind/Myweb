package com.myweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myweb.dao.FavoriteDao;
import com.myweb.entity.Favorite;
import com.myweb.util.PageNoUtil;

/**
 * 
 * @author huleiwind
 * @version $Id: FavoriteDaoImpl.java, v 0.1 2016-1-18 下午5:18:19 huleiwind Exp $
 */
public class FavoriteDaoImpl extends HibernateDaoSupport implements FavoriteDao {

    @Override
    public Integer save(Favorite favorite) {
        return (Integer) getHibernateTemplate().save(favorite);
    }

    @Override
    public Favorite findById(int id) {
        Favorite instance = (Favorite) getHibernateTemplate().get("com.myweb.entity.Favorite", id);
        return instance;
    }

    @Override
    public int deleteById(Integer id) {
        final String hql = "delete Favorite f where f.favoriteId= " + id;
        getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                session.createQuery(hql).executeUpdate();
                return 1;
            }
        });
        return 1;
    }

    @Override
    public List<Favorite> findBySendCardIdAndUserId(int sendCardId, int userId) {
        String hql = "from Favorite f where f.cardId = " + sendCardId + " and f.userId=" + userId;
        return getHibernateTemplate().find(hql);
    }

    @Override
    public void update(Favorite favorite) {
        getHibernateTemplate().update(favorite);
    }

    @Override
    public List<Favorite> findByUserId(final int userId, final int pageNo, final int pageSize) {
        //followType=0 为回复主题， =1为回复别人回复
        final String hql = "from Favorite f where f.userId=" + userId + " order by f.addTime desc";
        List<Favorite> lists = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return PageNoUtil.getList(session, hql, pageNo, pageSize);
            }
        });
        return lists;
    }

    @Override public int findFavoriteNumByUserId(int userId) {
        String hql = "select count(*) from Favorite f where f.userId ="+userId;
        Long a = (Long) getHibernateTemplate().find(hql).listIterator().next();
        int count = a.intValue();
        return count;
    }

}
