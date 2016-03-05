package com.myweb.view;

import java.sql.Timestamp;

/**
 *
 * @author huleiwind
 * @version $Id: HotUserView.java, v 0.1 2016-03-16/3/5-15:32 huleiwind Exp $$
 */
public class HotUserView {
    // Fields
    private Integer   userId;
    private String    userName;
    private String    blogUrl;
    private Integer   gender;
    private String    nationality;
    private Integer level;
    private String  name;
    private String  faceImg;

    //发问数量
    private Integer sendCardNum;
    //关注数量
    private Integer favoriteNum;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    public Integer getSendCardNum() {
        return sendCardNum;
    }

    public void setSendCardNum(Integer sendCardNum) {
        this.sendCardNum = sendCardNum;
    }

    public Integer getFavoriteNum() {
        return favoriteNum;
    }

    public void setFavoriteNum(Integer favoriteNum) {
        this.favoriteNum = favoriteNum;
    }
}
