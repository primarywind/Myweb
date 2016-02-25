package com.myweb.dao;

import java.util.List;

import com.myweb.entity.Message;

/**
 * 
 * @author huleiwind
 * @version $Id: MessageDao.java, v 0.1 2016-2-23 上午12:22:59 huleiwind Exp $
 */
public interface MessageDao {
    public List<Message> findByReceiveUserId(int userId, int pageNo, int pageSize);

    public Integer save(Message message);

    public int deleteById(Integer id);

    public Integer getMaxGroupBySendUserId(int sendUserId);

    public Message findById(Integer id);

    public List<Message> findByGroup(int messageGroup, int pageNo, int pageSize);
}
