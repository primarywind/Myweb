package com.myweb.entity;

import java.sql.Timestamp;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

    // Fields    

    private Integer   categoryId;
    private String    name;
    private Timestamp addTime;
    private Integer   ifview;
    private Integer   CIndex;

    // Constructors

    /** default constructor */
    public Category() {
    }

    /** full constructor */
    public Category(String name, Timestamp addTime, Integer ifview, Integer CIndex) {
        this.name = name;
        this.addTime = addTime;
        this.ifview = ifview;
        this.CIndex = CIndex;
    }

    // Property accessors

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getAddTime() {
        return this.addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Integer getIfview() {
        return this.ifview;
    }

    public void setIfview(Integer ifview) {
        this.ifview = ifview;
    }

    public Integer getCIndex() {
        return this.CIndex;
    }

    public void setCIndex(Integer CIndex) {
        this.CIndex = CIndex;
    }

}