package com.myweb.dao.impl;

import com.myweb.dao.ArticleDao;
import com.myweb.entity.Article;

/**
 * 
 * @author huleiwind
 * @version $Id: ArticleDaoImpl.java, v 0.1 2015-10-4 下午8:34:25 huleiwind Exp $
 */
public class ArticleDaoImpl extends CommonDao implements ArticleDao {

    public void save(Article article) {
        super.save(article);
    }

}
