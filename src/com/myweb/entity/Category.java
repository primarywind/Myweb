package com.myweb.entity;

import java.sql.Timestamp;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

    // Fields    

    private Integer   categoryId;
    private String    name;
    private String    CHref;
    private Timestamp addTime;
    private Integer   ifview;
    private Integer   CIndex;

    // Constructors

    /** default constructor */
    public Category() {
    }

    /** minimal constructor */
    public Category(String name, Timestamp addTime, Integer ifview, Integer CIndex) {
        this.name = name;
        this.addTime = addTime;
        this.ifview = ifview;
        this.CIndex = CIndex;
    }

    /** full constructor */
    public Category(String name, String CHref, Timestamp addTime, Integer ifview, Integer CIndex) {
        this.name = name;
        this.CHref = CHref;
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

    public String getCHref() {
        return this.CHref;
    }

    public void setCHref(String CHref) {
        this.CHref = CHref;
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