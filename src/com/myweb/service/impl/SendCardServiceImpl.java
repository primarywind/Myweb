package com.myweb.service.impl;

import java.util.List;

import com.myweb.dao.FollowcardDao;
import com.myweb.dao.SendcardDao;
import com.myweb.dao.UserDao;
import com.myweb.entity.Followcard;
import com.myweb.entity.Sendcard;
import com.myweb.entity.User;
import com.myweb.result.CardDetailQueryResult;
import com.myweb.result.SendCardListQueryResult;
import com.myweb.service.ISendCardService;
import com.myweb.template.QueryCallBack;
import com.myweb.util.Constant;
import com.myweb.view.FollowCardListView;
import com.myweb.view.SendCardDetailView;
import com.myweb.view.SendCardListView;

/**
 * 讨论模版服务
 * @author huleiwind
 * @version $Id: SendCardServiceImpl.java, v 0.1 2015-10-18 下午4:35:21 huleiwind Exp $
 */
public class SendCardServiceImpl extends BaseService implements ISendCardService {
    private SendcardDao   sendcardDao;
    private FollowcardDao followcardDao;
    private UserDao       userDao;

    public SendCardListQueryResult findSendCardsByPage(final int pageNo, final int pageSize,
                                                       final int orderType) {
        return getViewQueryTemplate().process(SendCardListQueryResult.class,
            new QueryCallBack<SendCardListQueryResult>() {

                @Override
                public void check() {
                    if (pageNo == 0
                        || pageSize == 0
                        || (orderType != Constant.ORDER_BY_FOLLOWNUMS
                            && orderType != Constant.ORDER_BY_RECOM
                            && orderType != Constant.ORDER_BY_TIME && orderType != Constant.ORDER_BY_TO_FOLLOW)) {
                        //异常类待细分，现统一抛出运行时异常
                        throw new RuntimeException();
                    }
                }

                @Override
                public void doProcess(SendCardListQueryResult result) {
                    List<Sendcard> sendcards = sendcardDao.findByPages(pageNo, pageSize, orderType);
                    List<SendCardListView> sendCardListViews = getViewObjectMapper().map(sendcards,
                        SendCardListView.class);
                    for (SendCardListView sendCardListView : sendCardListViews) {
                        User user = userDao.findById(sendCardListView.getUserId());
                        sendCardListView.setUserName(user.getUserName());
                        sendCardListView.setFaceImg(user.getFaceImg());
                    }
                    result.setSendCardListView(sendCardListViews);
                }
            });

    }

    public CardDetailQueryResult getSendCardDetail(final int sendCardId) {

        return getViewQueryTemplate().process(CardDetailQueryResult.class,
            new QueryCallBack<CardDetailQueryResult>() {
                Sendcard sendcard = sendcardDao.findById(sendCardId);

                @Override
                public void check() {
                    if (sendcard == null) {
                        //异常类待细分，现统一抛出运行时异常
                        throw new RuntimeException();
                    }
                }

                @Override
                public void doProcess(CardDetailQueryResult result) {

                    SendCardDetailView sendCardDetailView = getViewObjectMapper().map(sendcard,
                        SendCardDetailView.class);
                    User user = userDao.findById(sendCardDetailView.getUserId());

                    sendCardDetailView.setFaceImg(user.getFaceImg());
                    sendCardDetailView.setUserName(user.getUserName());

                    List<Followcard> followcards = followcardDao.findByPages(sendCardId,
                        Constant.FIRST_PAGE_NO, Constant.PAGE_SIZE, Constant.FOLLOW_OBJ);
                    List<FollowCardListView> followCardListViews = getViewObjectMapper().map(
                        followcards, FollowCardListView.class);
                    for (FollowCardListView followCardListView : followCardListViews) {

                        User followuser = userDao.findById(followCardListView.getUserId());
                        followCardListView.setFaceImg(followuser.getFaceImg());
                        followCardListView.setUserName(followuser.getName());

                        List<Followcard> followToFollowcards = followcardDao.findByPages(
                            followCardListView.getFollowId(), Constant.FIRST_PAGE_NO,
                            Constant.PAGE_SIZE, Constant.FOLLOW_OTHS);

                        List<FollowCardListView> followOtsCardListViews = getViewObjectMapper()
                            .map(followToFollowcards, FollowCardListView.class);
                        for (FollowCardListView followOtsCardListView : followOtsCardListViews) {
                            User followOts = userDao.findById(followOtsCardListView.getUserId());
                            followOtsCardListView.setFaceImg(followOts.getFaceImg());
                            followOtsCardListView.setUserName(followOts.getName());
                        }
                        followCardListView.setFollowCardListView(followOtsCardListViews);

                    }
                    sendCardDetailView.setFollowCardListViews(followCardListViews);
                    result.setSendCardDetailView(sendCardDetailView);
                }
            });

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
