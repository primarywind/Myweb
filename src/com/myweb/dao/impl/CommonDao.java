package com.myweb.dao.impl;

import java.io.Serializable;

public class CommonDao extends BaseHibernateDAO {

    public void save(Serializable obj) {
        try {
            getSession().save(obj);
        } catch (RuntimeException re) {
            throw re;
        }
    }
}
