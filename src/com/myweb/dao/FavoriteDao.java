package com.myweb.dao;

import java.util.List;

import com.myweb.entity.Favorite;

/**
 * 
 * @author huleiwind
 * @version $Id: FavoriteDao.java, v 0.1 2016-1-18 下午5:15:49 huleiwind Exp $
 */
public interface FavoriteDao {

    public Integer save(Favorite favorite);

    public Favorite findById(int id);

    public List<Favorite> findBySendCardIdAndUserId(int sendCardId, int userId);

    public int deleteById(Integer delId);

    public void update(Favorite favorite);

    public List<Favorite> findByUserId(int userId, int pageNo, int pageSize);

}
