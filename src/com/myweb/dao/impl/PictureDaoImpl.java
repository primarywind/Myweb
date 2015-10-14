package com.myweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myweb.dao.PictureDao;
import com.myweb.entity.Picture;
import com.myweb.util.PageNoUtil;

/**
 * 
 * @author huleiwind
 * @version $Id: PictureDaoImpl.java, v 0.1 2015-10-14 下午4:02:09 huleiwind Exp $
 */
public class PictureDaoImpl extends HibernateDaoSupport implements PictureDao {

    public List<Picture> findByPages(final int pageNo, final int pageSize) {
        final String hql = "from Picture p order by p.pubTime desc";
        List<Picture> lists = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return PageNoUtil.getList(session, hql, pageNo, pageSize);
            }
        });
        return lists;
    }

}
