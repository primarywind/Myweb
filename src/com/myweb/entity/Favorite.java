package com.myweb.entity;

import java.sql.Timestamp;

/**
 * Favorite entity. @author MyEclipse Persistence Tools
 */

public class Favorite implements java.io.Serializable {

    // Fields    

    private Integer   favoriteId;
    private Integer   userId;
    private Integer   cardId;
    private Timestamp addTime;

    // Constructors

    /** default constructor */
    public Favorite() {
    }

    /** full constructor */
    public Favorite(Integer userId, Integer cardId, Timestamp addTime) {
        this.userId = userId;
        this.cardId = cardId;
        this.addTime = addTime;
    }

    // Property accessors

    public Integer getFavoriteId() {
        return this.favoriteId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCardId() {
        return this.cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Timestamp getAddTime() {
        return this.addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

}