package com.myweb.view;

/**
 * 
 * @author huleiwind
 * @version $Id: ArticleView.java, v 0.1 2015-10-10 下午3:19:35 huleiwind Exp $
 */
public class ArticleView {

    //articleDo
    private Integer articleId;
    private Integer userId;
    private String  userName;
    private String  title;
    private String  content;
    private String  briefIndc;
    private String  pubTime;
    private String  label;
    private Integer categoryId;

    //userDo
    private String  blogUrl;
    private String  nationality;

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBriefIndc() {
        return briefIndc;
    }

    public void setBriefIndc(String briefIndc) {
        this.briefIndc = briefIndc;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
