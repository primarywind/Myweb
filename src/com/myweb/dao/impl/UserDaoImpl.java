package com.myweb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myweb.dao.UserDao;
import com.myweb.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    public Integer save(User user) {
        return (Integer) getHibernateTemplate().save(user);
    }

    public User findById(int id) {
        User instance = (User) getHibernateTemplate().get("com.myweb.entity.User", id);
        return instance;
    }

    public User findByNameAndPassowrd(String name, String md5PassWord) {
        String queryString = "from User u where u.name='" + name + "' and u.pwd='" + md5PassWord
                             + "'";
        List<User> users = getHibernateTemplate().find(queryString);
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }
}
