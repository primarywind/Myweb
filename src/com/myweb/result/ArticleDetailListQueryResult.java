/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.myweb.result;

import java.util.List;

import com.myweb.view.ArticleView;

/**
 * 
 * @author huleiwind
 * @version $Id: ArticleDetailListQueryResult.java, v 0.1 2015-12-3 下午3:38:03 huleiwind Exp $
 */
public class ArticleDetailListQueryResult extends QueryResult {

    /** serialVersionUID */
    private static final long serialVersionUID = 7151843042500575508L;

    private List<ArticleView> articleViewList;

    public List<ArticleView> getArticleViewList() {
        return articleViewList;
    }

    public void setArticleViewList(List<ArticleView> articleViewList) {
        this.articleViewList = articleViewList;
    }

}
