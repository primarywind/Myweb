package com.myweb.entity;

import java.sql.Timestamp;

/**
 * Followcard entity. @author MyEclipse Persistence Tools
 */

public class Followcard implements java.io.Serializable {

    // Fields    

    private Integer   followId;
    private Integer   userId;
    private Integer   cardOrFollowId;
    private String    followContent;
    private Timestamp pubTime;
    private Integer   followType;

    // Constructors

    /** default constructor */
    public Followcard() {
    }

    /** full constructor */
    public Followcard(Integer userId, Integer cardOrFollowId, String followContent,
                      Timestamp pubTime, Integer followType) {
        this.userId = userId;
        this.cardOrFollowId = cardOrFollowId;
        this.followContent = followContent;
        this.pubTime = pubTime;
        this.followType = followType;
    }

    // Property accessors

    public Integer getFollowId() {
        return this.followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCardOrFollowId() {
        return this.cardOrFollowId;
    }

    public void setCardOrFollowId(Integer cardOrFollowId) {
        this.cardOrFollowId = cardOrFollowId;
    }

    public String getFollowContent() {
        return this.followContent;
    }

    public void setFollowContent(String followContent) {
        this.followContent = followContent;
    }

    public Timestamp getPubTime() {
        return this.pubTime;
    }

    public void setPubTime(Timestamp pubTime) {
        this.pubTime = pubTime;
    }

    public Integer getFollowType() {
        return this.followType;
    }

    public void setFollowType(Integer followType) {
        this.followType = followType;
    }

}