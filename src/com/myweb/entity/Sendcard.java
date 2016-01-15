package com.myweb.entity;

import java.sql.Timestamp;

/**
 * Sendcard entity. @author MyEclipse Persistence Tools
 */

public class Sendcard implements java.io.Serializable {

    // Fields    

    private Integer   cardId;
    private Integer   userId;
    private String    title;
    private String    content;
    private Timestamp pubTime;
    private Integer   viewCount;
    private Integer   followCount;
    private Integer   favoriteCount;
    private String    label;

    // Constructors

    /** default constructor */
    public Sendcard() {
    }

    /** full constructor */
    public Sendcard(Integer userId, String title, String content, Timestamp pubTime,
                    Integer viewCount, Integer followCount, Integer favoriteCount, String label) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.pubTime = pubTime;
        this.viewCount = viewCount;
        this.followCount = followCount;
        this.favoriteCount = favoriteCount;
        this.label = label;
    }

    // Property accessors

    public Integer getCardId() {
        return this.cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPubTime() {
        return this.pubTime;
    }

    public void setPubTime(Timestamp pubTime) {
        this.pubTime = pubTime;
    }

    public Integer getViewCount() {
        return this.viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getFollowCount() {
        return this.followCount;
    }

    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
    }

    public Integer getFavoriteCount() {
        return this.favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}