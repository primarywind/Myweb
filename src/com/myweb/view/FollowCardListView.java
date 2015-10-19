package com.myweb.view;

import java.sql.Timestamp;
import java.util.List;

import com.myweb.entity.Followcard;

/**
 * 
 * @author huleiwind
 * @version $Id: FollowCardListView.java, v 0.1 2015-10-19 下午3:50:12 huleiwind Exp $
 */
public class FollowCardListView {
    // Fields    

    private Integer          followId;
    private Integer          userId;
    private Integer          cardOrFollowId;
    private String           followContent;
    private Timestamp        pubTime;
    private Integer          followType;

    //userDo
    private String           userName;
    private String           faceImg;
    // 若本回复下有回复则为非空
    private List<Followcard> followcards;

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCardOrFollowId() {
        return cardOrFollowId;
    }

    public void setCardOrFollowId(Integer cardOrFollowId) {
        this.cardOrFollowId = cardOrFollowId;
    }

    public String getFollowContent() {
        return followContent;
    }

    public void setFollowContent(String followContent) {
        this.followContent = followContent;
    }

    public Timestamp getPubTime() {
        return pubTime;
    }

    public void setPubTime(Timestamp pubTime) {
        this.pubTime = pubTime;
    }

    public Integer getFollowType() {
        return followType;
    }

    public void setFollowType(Integer followType) {
        this.followType = followType;
    }

    public List<Followcard> getFollowcards() {
        return followcards;
    }

    public void setFollowcards(List<Followcard> followcards) {
        this.followcards = followcards;
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
