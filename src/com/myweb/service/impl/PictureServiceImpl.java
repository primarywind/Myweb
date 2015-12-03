package com.myweb.service.impl;

import java.util.List;

import com.myweb.dao.PictureDao;
import com.myweb.dao.UserDao;
import com.myweb.entity.Picture;
import com.myweb.entity.User;
import com.myweb.result.PictureListQueryResult;
import com.myweb.service.IPictureService;
import com.myweb.template.QueryCallBack;
import com.myweb.view.PictureListView;

/**
 * 图片模块服务
 * @author huleiwind
 * @version $Id: PictureServiceImpl.java, v 0.1 2015-10-14 下午4:13:01 huleiwind Exp $
 */
public class PictureServiceImpl extends BaseService implements IPictureService {

    private PictureDao pictureDao;
    private UserDao    userDao;

    public PictureListQueryResult findByPages(final int pageNo, final int pageSize) {
        return getViewQueryTemplate().process(PictureListQueryResult.class,
            new QueryCallBack<PictureListQueryResult>() {

                @Override
                public void check() {
                    if (pageNo == 0 || pageSize == 0) {
                        //异常类待细分，现统一抛出运行时异常
                        throw new RuntimeException();
                    }
                }

                @Override
                public void doProcess(PictureListQueryResult result) {
                    List<Picture> pictures = pictureDao.findByPages(pageNo, pageSize);
                    List<PictureListView> pictureListViews = getViewObjectMapper().map(pictures,
                        PictureListView.class);
                    for (PictureListView pictureListView : pictureListViews) {
                        User user = userDao.findById(pictureListView.getPicOwnerId());
                        pictureListView.setUserName(user.getUserName());
                    }
                    result.setPictureList(pictureListViews);
                }
            });
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
