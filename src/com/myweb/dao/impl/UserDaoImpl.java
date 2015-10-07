package com.myweb.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myweb.dao.UserDao;
import com.myweb.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    public Integer save(User user) {
        return (Integer) getHibernateTemplate().save(user);
    }
}