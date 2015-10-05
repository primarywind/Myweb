package com.myweb.entity;

import java.util.Date;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */

public class Article implements java.io.Serializable {

    // Fields    

    private Integer articleId;
    private Integer userId;
    private String  title;
    private Date    pubTime;
    private String  content;
    private String  label;
    private String  category;

    // Constructors

    /** default constructor */
    public Article() {
    }

    /** full constructor */
    public Article(Integer articleId, Integer userId, String title, Date pubTime, String content,
                   String label, String category) {
        this.articleId = articleId;
        this.userId = userId;
        this.title = title;
        this.pubTime = pubTime;
        this.content = content;
        this.label = label;
        this.category = category;
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

    public Date getPubTime() {
        return this.pubTime;
    }

    public void setPubTime(Date pubTime) {
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

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}