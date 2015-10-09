package com.myweb.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myweb.dao.CategoryDAO;
import com.myweb.entity.Category;

/**
 	* A data access object (DAO) providing persistence and search support for Category entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.myweb.entity.Category
  * @author MyEclipse Persistence Tools 
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
}