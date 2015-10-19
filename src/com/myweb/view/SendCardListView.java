package com.myweb.view;

import java.sql.Timestamp;

/**
 * 
 * @author huleiwind
 * @version $Id: SendCardListView.java, v 0.1 2015-10-18 下午4:26:50 huleiwind Exp $
 */
public class SendCardListView {
    private Integer   cardId;
    private Integer   userId;
    private String    title;
    private Timestamp pubTime;
    private Integer   viewCount;
    private Integer   followCount;
    private Integer   favoriteCount;

    //userDo
    private String    userName;
    private String    faceImg;

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

    public Timestamp getPubTime() {
        return pubTime;
    }

    public void setPubTime(Timestamp pubTime) {
        this.pubTime = pubTime;
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

}
