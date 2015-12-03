package com.myweb.result;

import java.util.List;

import com.myweb.view.ArticleListView;

/**
 * 
 * @author huleiwind
 * @version $Id: ArticleListQueryResult.java, v 0.1 2015-12-3 下午2:55:52 huleiwind Exp $
 */
public class ArticleListQueryResult extends QueryResult {

    /** serialVersionUID */
    private static final long serialVersionUID = -5697278217895451122L;

    List<ArticleListView>     articleList;

    public List<ArticleListView> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<ArticleListView> articleList) {
        this.articleList = articleList;
    }

}
