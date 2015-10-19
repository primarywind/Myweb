package com.myweb.dao;

import java.util.List;

import com.myweb.entity.Sendcard;

/**
 * 
 * @author huleiwind
 * @version $Id: SendcardDao.java, v 0.1 2015-10-18 下午3:10:56 huleiwind Exp $
 */
public interface SendcardDao {
    public List<Sendcard> findByPages(int pageNo, int pageSize);

    public Sendcard findById(int sendCardId);

    public Integer save(Sendcard sendcard);
}
