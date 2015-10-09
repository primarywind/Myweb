package com.myweb.service.impl;

import java.util.List;

import com.myweb.dao.ArticleDao;
import com.myweb.dao.CategoryDAO;
import com.myweb.dao.UserDao;
import com.myweb.entity.Article;
import com.myweb.entity.User;
import com.myweb.service.IArticleService;
import com.myweb.view.ArticleListView;

/**
 * 
 * @author huleiwind
 * @version $Id: ArticleServiceImpl.java, v 0.1 2015-10-8 上午11:03:48 huleiwind Exp $
 */
public class ArticleServiceImpl extends BaseService implements IArticleService {
    private ArticleDao  articleDao;
    private UserDao     userDao;
    private CategoryDAO categoryDao;

    public List<ArticleListView> findArticlesByPage(int pageNo, int pageSize, int categoryId) {
        List<Article> articles = articleDao.findByPages(pageNo, pageSize, categoryId);
        System.out.println(getViewObjectMapper());
        List<ArticleListView> articleViews = getViewObjectMapper().map(articles,
            ArticleListView.class);
        for (ArticleListView articleView : articleViews) {
            User user = userDao.findById(articleView.getUserId());
            articleView.setUserName(user.getUserName());
            articleView.setPubTime(articleView.getPubTime().substring(0, 19));
        }
        return articleViews;
    }

    public int findArticlesNum(int categoryId) {
        return categoryDao.findNums(categoryId);
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

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public CategoryDAO getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDAO categoryDao) {
        this.categoryDao = categoryDao;
    }

}
