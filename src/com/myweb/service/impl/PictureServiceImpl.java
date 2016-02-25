package com.myweb.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.myweb.dao.PictureDao;
import com.myweb.dao.UserDao;
import com.myweb.entity.Picture;
import com.myweb.entity.User;
import com.myweb.result.BizResult;
import com.myweb.result.PictureListQueryResult;
import com.myweb.service.IPictureService;
import com.myweb.template.QueryCallBack;
import com.myweb.template.ServiceCallBack;
import com.myweb.util.HandlerPath;
import com.myweb.view.PictureListView;
import com.opensymphony.xwork2.ActionContext;

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

    public BizResult<Picture> uploadPicFile(final File file, final String fileName) {
        BizResult<Picture> bizResult = getServiceTemplate().serviceProcess(
            new ServiceCallBack<Picture>() {
                @Override
                public void beforeService() {

                }

                @Override
                public BizResult<Picture> executeService() {
                    String finalfileName = null;
                    ActionContext actionContext = ActionContext.getContext();
                    Map session = actionContext.getSession();
                    User user = (User) session.get("USER");
                    try {
                        UUID uuid = UUID.randomUUID();
                        finalfileName = uuid.toString() + fileName;
                        FileUtils.copyFile(file,
                            new File(HandlerPath.getHostSimulateAuthorLogoPath() + finalfileName));
                        Picture picture = new Picture();
                        picture.setPicName(finalfileName);
                        picture.setPicPath(HandlerPath.getPicturePath() + finalfileName);
                        picture.setPicSize(HandlerPath.FormetFileSize(file.length()));
                        String[] fileNames = finalfileName.split("\\.");
                        picture.setPicType(fileNames[fileNames.length - 1]);
                        picture.setPubTime(new Timestamp(System.currentTimeMillis()));
                        picture.setPicOwnerId(user.getUserId());
                        pictureDao.save(picture);
                        BizResult<Picture> bizResult = BizResult.valueOfSuccessed();
                        bizResult.setObject(picture);
                        return bizResult;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return BizResult.valueOfFailed();
                    }
                }

                @Override
                public void afterService(BizResult<Picture> result) {

                }

            });
        return bizResult;
    }

    public BizResult<Object> savePictureChange(final String[] delAIds) {
        BizResult<Object> bizResult = getServiceTemplate().serviceProcess(
            new ServiceCallBack<Object>() {
                @Override
                public void beforeService() {

                }

                @Override
                public BizResult<Object> executeService() {
                    if (delAIds == null || delAIds.length == 0) {
                        return BizResult.valueOfSuccessed();
                    }
                    for (String delAId : delAIds) {
                        pictureDao.deleteById(Integer.parseInt(delAId));
                    }
                    return BizResult.valueOfSuccessed();
                }

                @Override
                public void afterService(BizResult<Object> result) {

                }

            });
        return bizResult;
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

    @Override
    public BizResult<Picture> uploadUserImgPic(final File file, final String fileName) {
        BizResult<Picture> bizResult = getServiceTemplate().serviceProcess(
            new ServiceCallBack<Picture>() {
                @Override
                public void beforeService() {

                }

                @Override
                public BizResult<Picture> executeService() {
                    String finalfileName = null;
                    ActionContext actionContext = ActionContext.getContext();
                    Map session = actionContext.getSession();
                    User user = (User) session.get("USER");
                    try {
                        UUID uuid = UUID.randomUUID();
                        finalfileName = uuid.toString() + fileName;
                        FileUtils.copyFile(file,
                            new File(HandlerPath.getHostSimulateAuthorLogoPath() + finalfileName));
                        Picture picture = new Picture();
                        picture.setPicName(finalfileName);
                        if (finalfileName.indexOf("/Myweb") == -1) {
                            picture.setPicPath(HandlerPath.getPicturePath() + finalfileName);
                        } else {
                            picture.setPicPath(finalfileName);
                        }
                        picture.setPicSize(HandlerPath.FormetFileSize(file.length()));
                        String[] fileNames = finalfileName.split("\\.");
                        picture.setPicType(fileNames[fileNames.length - 1]);
                        picture.setPubTime(new Timestamp(System.currentTimeMillis()));
                        picture.setPicOwnerId(user.getUserId());
                        BizResult<Picture> bizResult = BizResult.valueOfSuccessed();
                        bizResult.setObject(picture);
                        return bizResult;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return BizResult.valueOfFailed();
                    }
                }

                @Override
                public void afterService(BizResult<Picture> result) {

                }

            });
        return bizResult;
    }
}
