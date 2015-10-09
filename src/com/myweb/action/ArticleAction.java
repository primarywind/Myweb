package com.myweb.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myweb.service.IArticleService;
import com.myweb.view.ArticleListView;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author huleiwind
 * @version $Id: ArticleAction.java, v 0.1 2015-10-8 下午9:15:25 huleiwind Exp $
 */
public class ArticleAction extends ActionSupport {

    /**  */
    private static final long     serialVersionUID = 1174404680631562411L;
    private IArticleService       articleService;

    private List<ArticleListView> articleViews;

    private int                   pageNo           = 1;
    private int                   pageSize         = 10;
    private int                   categoryId       = 0;
    public Map                    responseJson;

    public String findArticlesByPage() {
        Map<String, Object> map = new HashMap<String, Object>();
        articleViews = articleService.findArticlesByPage(pageNo, pageSize, categoryId);
        map.put("articleViews", articleViews);
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String findArticlesNums() {
        Map<String, Object> map = new HashMap<String, Object>();
        int nums = articleService.findArticlesNum(categoryId);
        map.put("nums", nums);
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public List<ArticleListView> getArticleViews() {
        return articleViews;
    }

    public void setArticleViews(List<ArticleListView> articleViews) {
        this.articleViews = articleViews;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setArticleService(IArticleService articleService) {
        this.articleService = articleService;
    }

    public Map getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(Map responseJson) {
        this.responseJson = responseJson;
    }

    public IArticleService getArticleService() {
        return articleService;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

}
