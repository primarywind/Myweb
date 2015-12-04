package com.myweb.result;

import java.util.List;

import com.myweb.view.CategoryView;

/**
 * 
 * @author huleiwind
 * @version $Id: CategoryListQueryResult.java, v 0.1 2015-12-4 下午12:48:23 huleiwind Exp $
 */
public class CategoryListQueryResult extends QueryResult {

    /** serialVersionUID */
    private static final long  serialVersionUID = 5358590173136599830L;

    private List<CategoryView> categoryList;

    public List<CategoryView> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryView> categoryList) {
        this.categoryList = categoryList;
    }

}
