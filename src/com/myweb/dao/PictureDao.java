package com.myweb.dao;

import java.util.List;

import com.myweb.entity.Picture;

/**
 * 
 * @author huleiwind
 * @version $Id: PictureDao.java, v 0.1 2015-10-14 下午3:58:22 huleiwind Exp $
 */
public interface PictureDao {
    public List<Picture> findByPages(int pageNo, int pageSize);

    public Integer save(Picture picture);
}
