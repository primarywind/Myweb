package com.myweb.view;

import java.sql.Timestamp;

/**
 * 
 * @author huleiwind
 * @version $Id: FavoriteListView.java, v 0.1 2016-2-20 下午2:38:33 huleiwind Exp $
 */
public class FavoriteListView {
    private Integer   favoriteId;
    private Integer   userId;
    private Integer   cardId;
    private Timestamp addTime;
    private String    title;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

}
