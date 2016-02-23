package com.myweb.view;

import java.sql.Timestamp;
import java.util.List;

/**
 * 
 * @author huleiwind
 * @version $Id: SendCardDetailView.java, v 0.1 2015-10-19 下午3:47:01 huleiwind Exp $
 */
public class SendCardDetailView {
    // Fields    

    private Integer                  cardId;
    private Integer                  userId;
    private String                   title;
    private String                   content;
    private Timestamp                pubTime;
    private String                   label;
    private Integer                  viewCount;
    private Integer                  followCount;
    private Integer                  favoriteCount;
    private List<FollowCardListView> FollowCardListViews;

    //userDo
    private String                   userName;
    private String                   faceImg;

    //是否收藏
    private Integer                  ifFavorite;

    //热门问题
    private List<SendCardView>       sendCardView;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPubTime() {
        return pubTime;
    }

    public void setPubTime(Timestamp pubTime) {
        this.pubTime = pubTime;
    }

    public List<FollowCardListView> getFollowCardListViews() {
        return FollowCardListViews;
    }

    public void setFollowCardListViews(List<FollowCardListView> followCardListViews) {
        FollowCardListViews = followCardListViews;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Integer getIfFavorite() {
        return ifFavorite;
    }

    public void setIfFavorite(Integer ifFavorite) {
        this.ifFavorite = ifFavorite;
    }

    public List<SendCardView> getSendCardView() {
        return sendCardView;
    }

    public void setSendCardView(List<SendCardView> sendCardView) {
        this.sendCardView = sendCardView;
    }

}
