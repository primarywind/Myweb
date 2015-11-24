package com.myweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myweb.dao.ArticleDao;
import com.myweb.entity.Article;
import com.myweb.util.PageNoUtil;

/**
 * 
 * @author huleiwind
 * @version $Id: ArticleDaoImpl.java, v 0.1 2015-10-4 下午8:34:25 huleiwind Exp $
 */
public class ArticleDaoImpl extends HibernateDaoSupport implements ArticleDao {

    public Integer save(Article article) {
        return (Integer) getHibernateTemplate().save(article);
    }

    public void delete(Article article) {
        getHibernateTemplate().delete(article);
    }

    public Article findById(int id) {
        Article instance = (Article) getHibernateTemplate().get("com.myweb.entity.Article", id);
        return instance;
    }

    public List<Article> findByPages(final int pageNo, final int pageSize, int categoryId) {
        final String hql;
        if (categoryId != 0) {
            hql = "from Article a where a.categoryId=" + categoryId + " order by a.pubTime desc";
        } else {
            hql = "from Article a order by a.pubTime desc";
        }
        List<Article> lists = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return PageNoUtil.getList(session, hql, pageNo, pageSize);
            }
        });
        return lists;
    }

    public List<Article> findByCId(int categoryId) {
        String hql = "from com.myweb.entity.Article a  where a.categoryId=" + categoryId;
        return getHibernateTemplate().find(hql);
    }

    public void update(Article article) {
        getHibernateTemplate().update(article);
    }
}
