package com.myweb.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.myweb.dao.FavoriteDao;
import com.myweb.dao.FollowcardDao;
import com.myweb.dao.SendcardDao;
import com.myweb.dao.UserDao;
import com.myweb.entity.Favorite;
import com.myweb.entity.Followcard;
import com.myweb.entity.Sendcard;
import com.myweb.entity.User;
import com.myweb.result.BizResult;
import com.myweb.result.CardDetailQueryResult;
import com.myweb.result.SendCardListQueryResult;
import com.myweb.service.ISendCardService;
import com.myweb.template.QueryCallBack;
import com.myweb.template.ServiceCallBack;
import com.myweb.util.Constant;
import com.myweb.util.StringUtil;
import com.myweb.view.FollowCardListView;
import com.myweb.view.SendCardDetailView;
import com.myweb.view.SendCardListView;
import com.myweb.view.SendCardView;
import com.opensymphony.xwork2.ActionContext;

/**
 * 讨论模版服务
 * @author huleiwind
 * @version $Id: SendCardServiceImpl.java, v 0.1 2015-10-18 下午4:35:21 huleiwind Exp $
 */
public class SendCardServiceImpl extends BaseService implements ISendCardService {
    private SendcardDao   sendcardDao;
    private FollowcardDao followcardDao;
    private UserDao       userDao;
    private FavoriteDao   favoriteDao;

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
                    sendCardDetailView.setUserName(user.getName());

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
                    //检查是否收藏
                    ActionContext actionContext = ActionContext.getContext();
                    Map session = actionContext.getSession();
                    User suser = (User) session.get("USER");
                    List<Favorite> fas = favoriteDao.findBySendCardIdAndUserId(sendCardId,
                        suser.getUserId());
                    if (fas.size() == 0) {
                        sendCardDetailView.setIfFavorite(0);
                    } else {
                        sendCardDetailView.setIfFavorite(1);
                    }

                    //热门问题
                    List<Sendcard> sendCards = sendcardDao.findByPages(Constant.FIRST_PAGE_NO,
                        Constant.PAGE_SIZE, Constant.ORDER_BY_FOLLOWNUMS);
                    List<SendCardView> sendCardView = getViewObjectMapper().map(sendCards,
                        SendCardView.class);
                    sendCardDetailView.setFollowCardListViews(followCardListViews);
                    sendCardDetailView.setSendCardView(sendCardView);
                    result.setSendCardDetailView(sendCardDetailView);
                }
            });

    }

    @Override
    public BizResult addCardComment(final int sendCardId, final String message) {
        BizResult<Object> bizResult = getServiceTemplate().serviceProcess(
            new ServiceCallBack<Object>() {
                Sendcard sendCard = sendcardDao.findById(sendCardId);

                @Override
                public void beforeService() {

                    if (StringUtil.isEmpty(message) || sendCard == null) {
                        throw new RuntimeException();
                    }

                }

                @Override
                public BizResult<Object> executeService() {
                    ActionContext actionContext = ActionContext.getContext();
                    Map session = actionContext.getSession();
                    User user = (User) session.get("USER");
                    Followcard followcard = new Followcard();
                    followcard.setUserId(user.getUserId());
                    followcard.setFollowContent(message);
                    followcard.setCardOrFollowId(sendCardId);
                    followcard.setFollowType(Constant.FOLLOW_OBJ);
                    followcard.setPubTime(new Timestamp(System.currentTimeMillis()));
                    followcardDao.save(followcard);
                    //更新话题数量
                    sendCard.setFollowCount(sendCard.getFollowCount() + 1);
                    sendcardDao.update(sendCard);
                    return BizResult.valueOfSuccessed();
                }

                @Override
                public void afterService(BizResult<Object> result) {

                }

            });
        return bizResult;
    }

    @Override
    public BizResult<Object> addOthCardComment(final int followCardId, final String message) {
        BizResult<Object> bizResult = getServiceTemplate().serviceProcess(
            new ServiceCallBack<Object>() {
                @Override
                public void beforeService() {

                    Followcard followcard = followcardDao.findById(followCardId);

                    if (StringUtil.isEmpty(message) || followcard == null) {
                        //待细分
                        throw new RuntimeException();
                    }

                }

                @Override
                public BizResult<Object> executeService() {
                    ActionContext actionContext = ActionContext.getContext();
                    Map session = actionContext.getSession();
                    User user = (User) session.get("USER");
                    Followcard followcard = new Followcard();
                    followcard.setUserId(user.getUserId());
                    followcard.setFollowContent(message);
                    followcard.setCardOrFollowId(followCardId);
                    followcard.setFollowType(Constant.FOLLOW_OTHS);
                    followcard.setPubTime(new Timestamp(System.currentTimeMillis()));
                    followcardDao.save(followcard);

                    return BizResult.valueOfSuccessed();
                }

                @Override
                public void afterService(BizResult<Object> result) {

                }

            });
        return bizResult;
    }

    @Override
    public BizResult<Object> updateCardFavorite(final int sendCardId, final int updateFavoriteType) {
        BizResult<Object> bizResult = getServiceTemplate().serviceProcess(
            new ServiceCallBack<Object>() {
                ActionContext  actionContext = ActionContext.getContext();
                Map            session       = actionContext.getSession();
                User           user          = (User) session.get("USER");
                Sendcard       sendcard      = sendcardDao.findById(sendCardId);
                List<Favorite> favorites     = favoriteDao.findBySendCardIdAndUserId(sendCardId,
                                                 user.getUserId());

                @Override
                public void beforeService() {

                    if (sendcard == null
                        || (updateFavoriteType != Constant.DEL_CARD_FAVORITE && updateFavoriteType != Constant.ADD_CARD_FAVORITE)) {
                        //待细分
                        throw new RuntimeException();
                    }
                    if (favorites.size() != 0 && favorites.size() != 1) {
                        //待细分
                        throw new RuntimeException();
                    }

                }

                @Override
                public BizResult<Object> executeService() {

                    //更新话题收藏数，同时更新
                    if (updateFavoriteType == Constant.ADD_CARD_FAVORITE) {
                        sendcard.setFavoriteCount(sendcard.getFavoriteCount() + 1);
                        //添加用户收藏记录
                        if (favorites.size() == 1) {
                            Favorite favorite = favorites.get(0);
                            //更新时间
                            favorite.setAddTime(new Timestamp(System.currentTimeMillis()));
                            favoriteDao.update(favorite);

                        } else {
                            Favorite favorite = new Favorite();
                            favorite.setCardId(sendCardId);
                            favorite.setUserId(user.getUserId());
                            favorite.setAddTime(new Timestamp(System.currentTimeMillis()));
                            favoriteDao.save(favorite);
                        }

                    }
                    if (updateFavoriteType == Constant.DEL_CARD_FAVORITE) {
                        sendcard.setFavoriteCount(sendcard.getFavoriteCount() - 1);
                        if (favorites.size() != 0) {
                            Favorite favorite = favorites.get(0);
                            favoriteDao.deleteById(favorite.getFavoriteId());
                        }
                    }
                    sendcardDao.update(sendcard);
                    return BizResult.valueOfSuccessed();
                }

                @Override
                public void afterService(BizResult<Object> result) {

                }

            });
        return bizResult;
    }

    @Override
    public BizResult<Object> saveSendCard(final String cardTitle, final String cardContent,
                                          final String cardLabel) {
        BizResult<Object> bizResult = getServiceTemplate().serviceProcess(
            new ServiceCallBack<Object>() {
                ActionContext actionContext = ActionContext.getContext();
                Map           session       = actionContext.getSession();
                User          user          = (User) session.get("USER");

                @Override
                public void beforeService() {

                    if (cardTitle == null || cardContent == null || cardLabel == null) {
                        //待细分
                        throw new RuntimeException();
                    }
                }

                @Override
                public BizResult<Object> executeService() {
                    Sendcard sendcard = new Sendcard();
                    sendcard.setTitle(cardTitle);
                    sendcard.setContent(cardContent);
                    sendcard.setLabel(cardLabel);
                    sendcard.setUserId(user.getUserId());
                    sendcard.setFavoriteCount(0);
                    sendcard.setFollowCount(0);
                    sendcard.setViewCount(0);
                    sendcard.setPubTime(new Timestamp(System.currentTimeMillis()));
                    sendcardDao.save(sendcard);

                    BizResult<Object> bizResult = BizResult.valueOfSuccessed();
                    bizResult.setObject(sendcard);
                    return bizResult;
                }

                @Override
                public void afterService(BizResult<Object> result) {

                }

            });
        return bizResult;
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

    public FavoriteDao getFavoriteDao() {
        return favoriteDao;
    }

    public void setFavoriteDao(FavoriteDao favoriteDao) {
        this.favoriteDao = favoriteDao;
    }

}
