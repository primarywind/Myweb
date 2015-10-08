package com.myweb.entity;

import java.sql.Timestamp;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */

public class Article implements java.io.Serializable {

    // Fields    

    private Integer   articleId;
    private Integer   userId;
    private String    title;
    private String    briefIndc;
    private Timestamp pubTime;
    private String    content;
    private String    label;
    private Integer   categoryId;

    // Constructors

    /** default constructor */
    public Article() {
    }

    /** full constructor */
    public Article(Integer userId, String title, String briefIndc, Timestamp pubTime,
                   String content, String label, Integer categoryId) {
        this.userId = userId;
        this.title = title;
        this.briefIndc = briefIndc;
        this.pubTime = pubTime;
        this.content = content;
        this.label = label;
        this.categoryId = categoryId;
    }

    // Property accessors

    public Integer getArticleId() {
        return this.articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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

    public String getBriefIndc() {
        return this.briefIndc;
    }

    public void setBriefIndc(String briefIndc) {
        this.briefIndc = briefIndc;
    }

    public Timestamp getPubTime() {
        return this.pubTime;
    }

    public void setPubTime(Timestamp pubTime) {
        this.pubTime = pubTime;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}