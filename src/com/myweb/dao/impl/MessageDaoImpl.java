package com.myweb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
        final String hql = "from Message m where m.receiveUserId=" + userId + "or m.sendUserId="
                           + userId + " group by m.messageGroup order by m.sendTime desc ";

        List<Message> lists = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return PageNoUtil.getList(session, hql, pageNo, pageSize);
            }
        });
        return lists;
    }

    @Override
    public Integer save(Message message) {
        return (Integer) getHibernateTemplate().save(message);
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public Integer getMaxGroupBySendUserId(int sendUserId) {
        String sql = "select {m.*} from message m for update";
        Session s = getHibernateTemplate().getSessionFactory().openSession();
        Query q = s.createSQLQuery(sql).addEntity("m", Message.class);

        List<Message> list = q.list();
        int max = 0;
        for (Message message : list) {
            if (message.getMessageGroup() > max) {
                max = message.getMessageGroup();
            }
        }
        return max;
    }

    @Override
    public Message findById(Integer id) {
        Message instance = (Message) getHibernateTemplate().get("com.myweb.entity.Message", id);
        return instance;
    }

    @Override
    public List<Message> findByGroup(int messageGroup, final int pageNo, final int pageSize) {
        final String hql = "from Message m where m.messageGroup=" + messageGroup
                           + " order by m.sendTime desc ";
        List<Message> lists = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return PageNoUtil.getList(session, hql, pageNo, pageSize);
            }
        });
        return lists;
    }
}
