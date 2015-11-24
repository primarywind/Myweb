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
    private int               ifView;

    private String[]          cName;
    private String[]          cHref;
    private String[]          cifView;
    private String[]          cId;
    private String[]          CIndex;
    private int               delCId;

    public String findCategories() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<CategoryView> categoryListView = categoryService.findCategories(ifView);
        map.put("categoryListView", categoryListView);
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String findAllCategories() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<CategoryView> categoryListView = categoryService.findAllCategories();
        map.put("categoryListView", categoryListView);
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String findArticleCategories() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<CategoryView> categoryListView = categoryService.findArticleCategories();
        map.put("categoryListView", categoryListView);
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String addAndUpdateCategories() {
        System.out.println(cName);
        System.out.println(cHref);
        System.out.println(cifView);
        System.out.println(cId);
        int saveResult = categoryService.addAndUpdateCategories(cId, cName, cHref, CIndex, cifView);
        Map<String, Object> map = new HashMap<String, Object>();
        if (saveResult == 1) {
            map.put("msg", "保存成功！");
        } else {
            map.put("msg", "保存异常，数据回滚！");
        }
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String deleteCategory() {
        int result = categoryService.deleteCategoryByCId(delCId);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result == 1) {
            map.put("msg", "删除成功！");
        } else if (result == 2) {
            map.put("msg", "栏目下存在文章，无法删除！");
        } else {
            map.put("msg", "删除异常，数据回滚！");
        }
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

    public int getIfView() {
        return ifView;
    }

    public void setIfView(int ifView) {
        this.ifView = ifView;
    }

    public String[] getcName() {
        return cName;
    }

    public void setcName(String[] cName) {
        this.cName = cName;
    }

    public String[] getcHref() {
        return cHref;
    }

    public void setcHref(String[] cHref) {
        this.cHref = cHref;
    }

    public String[] getCifView() {
        return cifView;
    }

    public void setCifView(String[] cifView) {
        this.cifView = cifView;
    }

    public int getDelCId() {
        return delCId;
    }

    public void setDelCId(int delCId) {
        this.delCId = delCId;
    }

    public String[] getcId() {
        return cId;
    }

    public void setcId(String[] cId) {
        this.cId = cId;
    }

    public String[] getCIndex() {
        return CIndex;
    }

    public void setCIndex(String[] cIndex) {
        CIndex = cIndex;
    }

}
