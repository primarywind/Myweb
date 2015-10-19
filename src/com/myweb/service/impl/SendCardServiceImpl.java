package com.myweb.service.impl;

import java.util.List;

import com.myweb.dao.FollowcardDao;
import com.myweb.dao.SendcardDao;
import com.myweb.dao.UserDao;
import com.myweb.entity.Followcard;
import com.myweb.entity.Sendcard;
import com.myweb.entity.User;
import com.myweb.service.ISendCardService;
import com.myweb.view.FollowCardListView;
import com.myweb.view.SendCardDetailView;
import com.myweb.view.SendCardListView;

/**
 * 
 * @author huleiwind
 * @version $Id: SendCardServiceImpl.java, v 0.1 2015-10-18 下午4:35:21 huleiwind Exp $
 */
public class SendCardServiceImpl extends BaseService implements ISendCardService {
    private SendcardDao   sendcardDao;
    private FollowcardDao followcardDao;
    private UserDao       userDao;

    public List<SendCardListView> findSendCardsByPage(int pageNo, int pageSize) {
        List<Sendcard> sendcards = sendcardDao.findByPages(pageNo, pageSize);
        List<SendCardListView> sendCardListViews = getViewObjectMapper().map(sendcards,
            SendCardListView.class);
        for (SendCardListView sendCardListView : sendCardListViews) {
            User user = userDao.findById(sendCardListView.getUserId());
            sendCardListView.setUserName(user.getUserName());
            sendCardListView.setFaceImg(user.getFaceImg());
        }
        return sendCardListViews;
    }

    public SendCardDetailView getSendCardDetail(int sendCardId) {
        Sendcard sendcard = sendcardDao.findById(sendCardId);
        if (sendcard == null) {
            return null;
        }
        SendCardDetailView sendCardDetailView = getViewObjectMapper().map(sendcard,
            SendCardDetailView.class);
        User user = userDao.findById(sendCardDetailView.getUserId());

        sendCardDetailView.setFaceImg(user.getFaceImg());
        sendCardDetailView.setUserName(user.getUserName());

        List<Followcard> followcards = followcardDao.findByPages(sendCardId, 1, 100, 0);
        List<FollowCardListView> followCardListViews = getViewObjectMapper().map(followcards,
            FollowCardListView.class);
        for (FollowCardListView followCardListView : followCardListViews) {

            User followuser = userDao.findById(followCardListView.getUserId());
            sendCardDetailView.setFaceImg(followuser.getFaceImg());
            sendCardDetailView.setUserName(followuser.getUserName());

            List<Followcard> followToFollowcards = followcardDao.findByPages(
                followCardListView.getFollowId(), 1, 100, 1);
            followCardListView.setFollowcards(followToFollowcards);

        }
        sendCardDetailView.setFollowCardListViews(followCardListViews);
        return sendCardDetailView;
    }

    public Sendcard findSendCardById(int sendCardId) {
        return sendcardDao.findById(sendCardId);
    }

    public Integer saveOrUpdateSendCard(Sendcard sendcard) {
        return sendcardDao.save(sendcard);
    }

    public SendcardDao getSendcardDao() {
        return sendcardDao;
    }

    public void setSendcardDao(SendcardDao sendcardDao) {
        this.sendcardDao = sendcardDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public FollowcardDao getFollowcardDao() {
        return followcardDao;
    }

    public void setFollowcardDao(FollowcardDao followcardDao) {
        this.followcardDao = followcardDao;
    }

}
