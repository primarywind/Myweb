package com.myweb.service.impl;

import java.util.List;

import com.myweb.dao.PictureDao;
import com.myweb.dao.UserDao;
import com.myweb.entity.Picture;
import com.myweb.entity.User;
import com.myweb.service.IPictureService;
import com.myweb.view.PictureListView;

/**
 * 
 * @author huleiwind
 * @version $Id: PictureServiceImpl.java, v 0.1 2015-10-14 下午4:13:01 huleiwind Exp $
 */
public class PictureServiceImpl extends BaseService implements IPictureService {

    private PictureDao pictureDao;
    private UserDao    userDao;

    public List<PictureListView> findByPages(int pageNo, int pageSize) {
        List<Picture> pictures = pictureDao.findByPages(pageNo, pageSize);
        List<PictureListView> pictureListViews = getViewObjectMapper().map(pictures,
            PictureListView.class);
        for (PictureListView pictureListView : pictureListViews) {
            User user = userDao.findById(pictureListView.getPicOwnerId());
            pictureListView.setUserName(user.getUserName());
        }
        return pictureListViews;
    }

    public PictureDao getPictureDao() {
        return pictureDao;
    }

    public void setPictureDao(PictureDao pictureDao) {
        this.pictureDao = pictureDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
