package com.myweb.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myweb.service.ICategoryService;
import com.myweb.view.CategoryView;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author huleiwind
 * @version $Id: CategoryAction.java, v 0.1 2015-10-13 下午1:33:52 huleiwind Exp $
 */
public class CategoryAction extends ActionSupport {

    /**  */
    private static final long serialVersionUID = -8108315286419338012L;
    private ICategoryService  categoryService;
    public Map                responseJson;

    public String findAllCategories() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<CategoryView> categoryListView = categoryService.findCategories();
        map.put("categoryListView", categoryListView);
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public ICategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Map getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(Map responseJson) {
        this.responseJson = responseJson;
    }

}
