package com.myweb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myweb.dao.UserDao;
import com.myweb.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public Integer save(User user) {
        return (Integer) getHibernateTemplate().save(user);
    }

    @Override
    public User findById(int id) {
        User instance = (User) getHibernateTemplate().get("com.myweb.entity.User", id);
        return instance;
    }

    @Override
    public User findByNameAndPassowrd(String name, String md5PassWord) {
        String queryString = "from User u where u.name='" + name + "' and u.pwd='" + md5PassWord
                             + "'";
        List<User> users = getHibernateTemplate().find(queryString);
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public User findByName(String name) {
        String queryString = "from User u where u.name='" + name + "'";
        List<User> users = getHibernateTemplate().find(queryString);
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public void update(User user) {
        getHibernateTemplate().update(user);
    }
}
