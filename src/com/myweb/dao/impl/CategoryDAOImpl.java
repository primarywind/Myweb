package com.myweb.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myweb.dao.CategoryDAO;
import com.myweb.entity.Category;

/**
 * 
 * @author huleiwind
 * @version $Id: CategoryDAOImpl.java, v 0.1 2015-10-4 下午8:34:25 huleiwind Exp $
 */

public class CategoryDAOImpl extends HibernateDaoSupport implements CategoryDAO {

    public Integer save(Category category) {
        return (Integer) getHibernateTemplate().save(category);
    }

    public void delete(Category category) {
        getHibernateTemplate().delete(category);
    }

    public Category findById(int id) {
        Category instance = (Category) getHibernateTemplate().get("com.myweb.entity.Category", id);
        return instance;
    }

    public Integer findNums(int categoryId) {
        String hql;
        if (categoryId != 0) {
            hql = "select count(*) from Article a where a.categoryId=" + categoryId;
        } else {
            hql = "select count(*) from Article a";
        }
        Long a = (Long) getHibernateTemplate().find(hql).listIterator().next();
        int count = a.intValue();
        return count;
    }

    public List<Category> findCategories(int ifView) {
        String hql = "from Category c where c.ifview = " + ifView + " order by c.CIndex asc";
        return getHibernateTemplate().find(hql);
    }

    public List<Category> findAllCategories() {
        String hql = "from Category c  order by c.CIndex asc";
        return getHibernateTemplate().find(hql);
    }

    public int deleteByCid(Integer delCId) {
        final String hql = "delete Category c where c.categoryId = " + delCId;
        getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                session.createQuery(hql).executeUpdate();
                return 1;
            }
        });
        return 1;
    }

    public void update(Category category) {
        getHibernateTemplate().update(category);
    }
}