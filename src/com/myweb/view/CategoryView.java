/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.myweb.view;

/**
 * 
 * @author huleiwind
 * @version $Id: CategoryView.java, v 0.1 2015-10-13 下午12:53:53 huleiwind Exp $
 */
public class CategoryView {
    private Integer categoryId;
    private String  name;
    private String  chref;

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

}
