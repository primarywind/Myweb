package com.myweb.action;

import java.util.HashMap;
import java.util.Map;

import com.myweb.result.BizResult;
import com.myweb.result.CategoryListQueryResult;
import com.myweb.service.ICategoryService;
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
        CategoryListQueryResult categoryListQueryResult = categoryService.findCategories(ifView);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("categoryListView", categoryListQueryResult.getCategoryList());
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String findAllCategories() {
        CategoryListQueryResult categoryListQueryResult = categoryService.findAllCategories();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("categoryListView", categoryListQueryResult.getCategoryList());
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String findArticleCategories() {
        CategoryListQueryResult categoryListQueryResult = categoryService.findArticleCategories();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("categoryListView", categoryListQueryResult.getCategoryList());
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String addAndUpdateCategories() {
        BizResult<Object> bizResult = categoryService.addAndUpdateCategories(cId, cName, cHref,
            CIndex, cifView);
        Map<String, Object> map = new HashMap<String, Object>();
        if (bizResult.isSuccess()) {
            map.put("msg", "保存成功！");
        } else {
            map.put("msg", "保存异常，数据回滚！");
        }
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String deleteCategory() {
        BizResult<Object> bizResult = categoryService.deleteCategoryByCId(delCId);
        Map<String, Object> map = new HashMap<String, Object>();
        if (bizResult.isSuccess()) {
            map.put("msg", "删除成功！");
        } else {
            map.put("msg", "栏目下存在文章，无法删除！");
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
