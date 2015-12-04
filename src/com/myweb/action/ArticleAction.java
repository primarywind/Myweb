package com.myweb.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myweb.result.ArticleDetailListQueryResult;
import com.myweb.result.ArticleListQueryResult;
import com.myweb.result.ArticleQueryResult;
import com.myweb.result.ArticlesNumQueryResult;
import com.myweb.result.BizResult;
import com.myweb.service.IArticleService;
import com.myweb.view.ArticleListView;
import com.myweb.view.ArticleView;
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

    private List<ArticleListView> articleListViews;
    private ArticleView           articleView;
    private List<ArticleView>     articleViews;
    private int                   pageNo           = 1;
    //默认一页10条
    private int                   pageSize         = 10;
    private int                   categoryId       = 0;
    private int                   articleId        = 0;
    public Map                    responseJson;

    //文章Id
    private String[]              articleIds;
    //标题
    private String[]              titles;
    //栏目Id
    private int[]                 categoryIds;
    //文章标签
    private String[]              labels;
    //文章简介
    private String[]              brefContents;
    //文章内容
    private String[]              contents;

    public String findArticlesByPage() {
        Map<String, Object> map = new HashMap<String, Object>();
        ArticleListQueryResult articleListQueryResult = articleService.findArticlesByPage(pageNo,
            pageSize, categoryId);
        map.put("articleListViews", articleListQueryResult.getArticleList());
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String findArticlesNums() {
        Map<String, Object> map = new HashMap<String, Object>();
        ArticlesNumQueryResult articlesNumQueryResult = articleService.findArticlesNum(categoryId);
        map.put("nums", articlesNumQueryResult.getNums());
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String findArticleDetail() {
        Map<String, Object> map = new HashMap<String, Object>();
        ArticleQueryResult articleQueryResult = articleService.findArticleDetailById(articleId);
        map.put("articleView", articleQueryResult.getArticleView());
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String findArticleDetailListByCategoryId() {
        Map<String, Object> map = new HashMap<String, Object>();
        ArticleDetailListQueryResult articleDetailListQueryResult = articleService
            .findArticleDetailList(categoryId);
        map.put("articleViews", articleDetailListQueryResult.getArticleViewList());
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String addAndUpdateCategoryArticles() {
        Map<String, Object> map = new HashMap<String, Object>();

        BizResult bizResult = articleService.addAndUpdateCategoryArticles(articleIds, categoryIds,
            labels, titles, brefContents, contents);
        if (bizResult.isSuccess()) {
            map.put("msg", "保存成功！");
        } else {
            map.put("msg", "保存失败！");
        }
        this.setResponseJson(map);
        return Action.SUCCESS;
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

    public void setResponseJson(Map responseJson) {
        this.responseJson = responseJson;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public List<ArticleListView> getArticleListViews() {
        return articleListViews;
    }

    public void setArticleListViews(List<ArticleListView> articleListViews) {
        this.articleListViews = articleListViews;
    }

    public ArticleView getArticleView() {
        return articleView;
    }

    public void setArticleView(ArticleView articleView) {
        this.articleView = articleView;
    }

    public List<ArticleView> getArticleViews() {
        return articleViews;
    }

    public void setArticleViews(List<ArticleView> articleViews) {
        this.articleViews = articleViews;
    }

    public IArticleService getArticleService() {
        return articleService;
    }

    public Map getResponseJson() {
        return responseJson;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public String[] getBrefContents() {
        return brefContents;
    }

    public void setBrefContents(String[] brefContents) {
        this.brefContents = brefContents;
    }

    public String[] getContents() {
        return contents;
    }

    public void setContents(String[] contents) {
        this.contents = contents;
    }

    public String[] getArticleIds() {
        return articleIds;
    }

    public void setArticleIds(String[] articleIds) {
        this.articleIds = articleIds;
    }

    public int[] getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(int[] categoryIds) {
        this.categoryIds = categoryIds;
    }

}
