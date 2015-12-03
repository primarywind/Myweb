package com.myweb.result;

import com.myweb.view.ArticleView;

/**
 * 
 * @author huleiwind
 * @version $Id: ArticleQueryResult.java, v 0.1 2015-12-3 下午3:31:10 huleiwind Exp $
 */
public class ArticleQueryResult extends QueryResult {

    /** serialVersionUID */
    private static final long serialVersionUID = -2211281076663921024L;

    ArticleView               articleView;

    public ArticleView getArticleView() {
        return articleView;
    }

    public void setArticleView(ArticleView articleView) {
        this.articleView = articleView;
    }

}
