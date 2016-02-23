package com.myweb.view;

import java.sql.Timestamp;

/**
 * 
 * @author huleiwind
 * @version $Id: FollowCardView.java, v 0.1 2016-1-15 下午3:25:55 huleiwind Exp $
 */
public class FollowCardView {
    private Integer   followId;
    private Integer   userId;
    private Integer   cardOrFollowId;
    private String    followContent;
    private Timestamp pubTime;
    private Integer   followType;
    private String    name;
    private String    title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
