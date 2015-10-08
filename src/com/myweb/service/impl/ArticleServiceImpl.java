package com.myweb.service.impl;

import java.util.List;

import com.myweb.dao.ArticleDao;
import com.myweb.entity.Article;
import com.myweb.service.IArticleService;

/**
 * 
 * @author huleiwind
 * @version $Id: ArticleServiceImpl.java, v 0.1 2015-10-8 上午11:03:48 huleiwind Exp $
 */
public class ArticleServiceImpl implements IArticleService {
    private ArticleDao articleDao;

    public List<Article> findArticlesByPage(int pageNo, int pageSize) {
        return articleDao.findByPages(pageNo, pageSize);
    }

    public Article findArticleById(int id) {
        return articleDao.findById(id);
    }

    public ArticleDao getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

}
