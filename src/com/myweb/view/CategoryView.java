package com.myweb.view;

import java.sql.Timestamp;

/**
 * 
 * @author huleiwind
 * @version $Id: CategoryView.java, v 0.1 2015-10-13 下午12:53:53 huleiwind Exp $
 */
public class CategoryView {
    private Integer   categoryId;
    private String    name;
    private String    chref;
    private Timestamp addTime;
    private Integer   ifview;
    private Integer   CIndex;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChref() {
        return chref;
    }

    public void setChref(String chref) {
        this.chref = chref;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Integer getIfview() {
        return ifview;
    }

    public void setIfview(Integer ifview) {
        this.ifview = ifview;
    }

    public Integer getCIndex() {
        return CIndex;
    }

    public void setCIndex(Integer cIndex) {
        CIndex = cIndex;
    }

}
