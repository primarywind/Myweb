package com.myweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.myweb.dao.FavoriteDao;
import com.myweb.dao.FollowcardDao;
import com.myweb.dao.SendcardDao;
import com.myweb.dao.UserDao;
import com.myweb.entity.Favorite;
import com.myweb.entity.Followcard;
import com.myweb.entity.Sendcard;
import com.myweb.entity.User;
import com.myweb.result.BizResult;
import com.myweb.result.UserInfoQueryResult;
import com.myweb.service.IUserService;
import com.myweb.template.QueryCallBack;
import com.myweb.template.ServiceCallBack;
import com.myweb.util.Constant;
import com.myweb.util.HandlerPath;
import com.myweb.util.MD5Util;
import com.myweb.util.StringUtil;
import com.myweb.util.sensitive.annotations.SensitiveInfo;
import com.myweb.view.FavoriteListView;
import com.myweb.view.FollowCardView;
import com.myweb.view.SendCardListView;
import com.myweb.view.UserInfoView;
import com.myweb.view.UserView;

/**
 * 用户模版服务
 * @author huleiwind
 * @version $Id: UserServiceImpl.java, v 0.1 2015-10-8 上午11:03:48 huleiwind Exp $
 */
public class UserServiceImpl extends BaseService implements IUserService {
    private UserDao       userDao;
    private SendcardDao   sendcardDao;
    private FollowcardDao followcardDao;
    private FavoriteDao   favoriteDao;

    public BizResult<User> saveUser(final String name, final String password, final int sex,
                                    final String city) {
        return getServiceTemplate().serviceProcess(new ServiceCallBack<User>() {
            @Override
            public void beforeService() {
                //检查是否非空
                if (StringUtil.isBlank(name) || StringUtil.isBlank(password)
                    || StringUtil.isBlank(city)) {
                    //异常类待细分，现统一抛出运行时异常
                    throw new RuntimeException();
                }
                //检查是否合法
                if (sex != Constant.WOMANSEX && sex != Constant.MANSEX) {
                    //异常类待细分，现统一抛出运行时异常
                    throw new RuntimeException();
                }
            }

            @Override
            public BizResult<User> executeService() {
                User user = new User();
                user.setName(name);
                user.setGender(sex);
                user.setNationality(city);
                user.setLevel(Constant.USER_LEVEL);
                user.setFaceImg("/Myweb/assets/images/default-img.png");
                user.setRegTime(new Timestamp(System.currentTimeMillis()));
                try {
                    user.setPwd(MD5Util.md5Encode(password));
                } catch (Exception e) {
                    //异常类待细分，现统一抛出运行时异常
                    throw new RuntimeException();
                }
                userDao.save(user);
                BizResult<User> bizResult = BizResult.valueOfSuccessed();
                bizResult.setObject(user);
                return bizResult;
            }

            @Override
            public void afterService(BizResult<User> result) {
            }
        });
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public BizResult<User> logon(final String name,
                                 @SensitiveInfo(SensitiveInfo.PASSWORD_RULE) final String password) {
        return getServiceTemplate().serviceProcess(new ServiceCallBack<User>() {
            @Override
            public void beforeService() {
            }

            @Override
            public BizResult<User> executeService() {
                String md5Password = null;
                try {
                    md5Password = MD5Util.md5Encode(password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                User user = userDao.findByNameAndPassowrd(name, md5Password);
                BizResult<User> bizResult = BizResult.valueOfSuccessed();
                bizResult.setObject(user);
                return bizResult;
            }

            @Override
            public void afterService(BizResult<User> result) {
            }
        });

    }

    @Override
    public UserInfoQueryResult getUserInfo(final Integer userId, final Integer pageNo,
                                           final Integer pageSize) {
        return getViewQueryTemplate().process(UserInfoQueryResult.class,
            new QueryCallBack<UserInfoQueryResult>() {

                @Override
                public void check() {
                    if (userId == null) {
                        //异常类待细分，现统一抛出运行时异常
                        throw new RuntimeException();
                    }
                }

                @Override
                public void doProcess(UserInfoQueryResult result) {
                    User user = userDao.findById(userId);
                    List<Sendcard> sendCards = sendcardDao.findByUserId(userId, pageNo, pageSize);
                    List<Followcard> followCards = followcardDao.findByUserId(userId, pageNo,
                        pageSize);
                    List<Favorite> favorites = favoriteDao.findByUserId(userId, pageNo, pageSize);

                    List<SendCardListView> sendCardListViews = getViewObjectMapper().map(sendCards,
                        SendCardListView.class);

                    UserView userView = getViewObjectMapper().map(user, UserView.class);

                    List<FollowCardView> followCardListViews = getViewObjectMapper().map(
                        followCards, FollowCardView.class);
                    for (FollowCardView followCardView : followCardListViews) {
                        int sendCardId = followCardView.getCardOrFollowId();
                        followCardView.setTitle(sendcardDao.findById(sendCardId).getTitle());
                    }

                    List<FavoriteListView> favoriteListViews = getViewObjectMapper().map(favorites,
                        FavoriteListView.class);
                    for (FavoriteListView favoriteListView : favoriteListViews) {
                        int sendCardId = favoriteListView.getCardId();
                        favoriteListView.setTitle(sendcardDao.findById(sendCardId).getTitle());
                    }
                    UserInfoView userInfoView = new UserInfoView();
                    userInfoView.setUserView(userView);
                    userInfoView.setFavoriteListViews(favoriteListViews);
                    userInfoView.setFollowCardViews(followCardListViews);
                    userInfoView.setSendCardListViews(sendCardListViews);
                    result.setUserInfoView(userInfoView);
                }
            });
    }

    public SendcardDao getSendcardDao() {
        return sendcardDao;
    }

    public void setSendcardDao(SendcardDao sendcardDao) {
        this.sendcardDao = sendcardDao;
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

    @Override
    public BizResult<User> updateUserInfo(final Integer userId, final int sex,
                                          final String userName, final String nationality,
                                          final String blogUrl, final String faceImg) {
        return getServiceTemplate().serviceProcess(new ServiceCallBack<User>() {
            @Override
            public void beforeService() {
            }

            @Override
            public BizResult<User> executeService() {

                User user = userDao.findById(userId);
                user.setBlogUrl(blogUrl);
                user.setFaceImg(HandlerPath.getPicturePath() + faceImg);
                user.setGender(sex);
                user.setNationality(nationality);
                user.setUserName(userName);
                userDao.update(user);
                BizResult<User> bizResult = BizResult.valueOfSuccessed();
                bizResult.setObject(user);
                return bizResult;
            }

            @Override
            public void afterService(BizResult<User> result) {
            }
        });
    }

}
