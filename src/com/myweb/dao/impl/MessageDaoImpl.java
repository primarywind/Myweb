package com.myweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myweb.dao.MessageDao;
import com.myweb.entity.Message;
import com.myweb.util.PageNoUtil;

/**
 * 
 * @author huleiwind
 * @version $Id: MessageDaoImpl.java, v 0.1 2016-2-24 上午12:40:34 huleiwind Exp $
 */
public class MessageDaoImpl extends HibernateDaoSupport implements MessageDao {

    @Override
    public List<Message> findByReceiveUserId(final int userId, final int pageNo, final int pageSize) {
        final String hql = "from Message m where m.receiveUserId=" + userId
                           + " group by m.group order by m.sendTime desc ";

        List<Message> lists = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return PageNoUtil.getList(session, hql, pageNo, pageSize);
            }
        });
        return lists;
    }

    @Override
    public Integer save(Message message) {
        return null;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

}
