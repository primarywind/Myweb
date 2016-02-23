package com.myweb.dao;

import java.util.List;

import com.myweb.entity.Followcard;

/**
 * 
 * @author huleiwind
 * @version $Id: FollowcardDao.java, v 0.1 2015-10-18 下午3:24:05 huleiwind Exp $
 */
public interface FollowcardDao {
    public List<Followcard> findByPages(int sendCardId, int pageNo, int pageSize, int followType);

    public Integer save(Followcard followcard);

    public Followcard findById(int id);

    public List<Followcard> findByUserId(int userId, int pageNo, int pageSize);
}
