package com.myweb.view;

import java.util.List;

/**
 * 
 * @author huleiwind
 * @version $Id: UserInfoView.java, v 0.1 2016-2-20 下午2:18:30 huleiwind Exp $
 */
public class UserInfoView {
    private UserView               userView;
    private List<SendCardListView> sendCardListViews;
    private List<FollowCardView>   followCardViews;
    private List<FavoriteListView> favoriteListViews;

    public List<SendCardListView> getSendCardListViews() {
        return sendCardListViews;
    }

    public void setSendCardListViews(List<SendCardListView> sendCardListViews) {
        this.sendCardListViews = sendCardListViews;
    }

    public List<FollowCardView> getFollowCardViews() {
        return followCardViews;
    }

    public void setFollowCardViews(List<FollowCardView> followCardViews) {
        this.followCardViews = followCardViews;
    }

    public List<FavoriteListView> getFavoriteListViews() {
        return favoriteListViews;
    }

    public void setFavoriteListViews(List<FavoriteListView> favoriteListViews) {
        this.favoriteListViews = favoriteListViews;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

}
