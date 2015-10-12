package com.myweb.entity;

import java.sql.Timestamp;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

    // Fields    

    private Integer   userId;
    private String    userName;
    private String    blogUrl;
    private Integer   gender;
    private String    nationality;
    private Timestamp regTime;
    private Integer   level;
    private String    pwd;

    // Constructors

    /** default constructor */
    public User() {
    }

    /** full constructor */
    public User(String userName, String blogUrl, Integer gender, String nationality,
                Timestamp regTime, Integer level, String pwd) {
        this.userName = userName;
        this.blogUrl = blogUrl;
        this.gender = gender;
        this.nationality = nationality;
        this.regTime = regTime;
        this.level = level;
        this.pwd = pwd;
    }

    // Property accessors

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBlogUrl() {
        return this.blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public Integer getGender() {
        return this.gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Timestamp getRegTime() {
        return this.regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}