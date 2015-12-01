package com.myweb.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.myweb.dao.ArticleDao;
import com.myweb.dao.CategoryDAO;
import com.myweb.dao.UserDao;
import com.myweb.entity.Article;
import com.myweb.entity.User;
import com.myweb.service.IArticleService;
import com.myweb.view.ArticleListView;
import com.myweb.view.ArticleView;
import com.opensymphony.xwork2.ActionContext;

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
        List<ArticleListView> articleListViews = getViewObjectMapper().map(articles,
            ArticleListView.class);
        for (ArticleListView articleListView : articleListViews) {
            User user = userDao.findById(articleListView.getUserId());
            articleListView.setUserName(user.getUserName());
            articleListView.setPubTime(articleListView.getPubTime().substring(0, 19));
        }
        return articleListViews;
    }

    public int findArticlesNum(int categoryId) {
        return categoryDao.findNums(categoryId);
    }

    public ArticleView findArticleDetailById(int articleId) {
        Article article = articleDao.findById(articleId);
        ArticleView articleView = getViewObjectMapper().map(article, ArticleView.class);
        User user = userDao.findById(articleView.getUserId());
        articleView.setUserName(user.getUserName());
        articleView.setBlogUrl(user.getBlogUrl());
        articleView.setNationality(user.getNationality());
        articleView.setPubTime(articleView.getPubTime().substring(0, 19));
        return articleView;
    }

    public List<ArticleView> findArticleDetailList(int categoryId) {
        List<Article> articles = articleDao.findByPages(1, 100, categoryId);
        List<ArticleView> articleListViews = getViewObjectMapper().map(articles, ArticleView.class);
        for (ArticleView articleView : articleListViews) {
            User user = userDao.findById(articleView.getUserId());
            articleView.setUserName(user.getUserName());
            articleView.setBlogUrl(user.getBlogUrl());
            articleView.setNationality(user.getNationality());
            articleView.setPubTime(articleView.getPubTime().substring(0, 19));
        }
        return articleListViews;
    }

    public int addAndUpdateCategoryArticles(String[] articleIds, int[] categoryIds,
                                            String[] labels, String[] titles,
                                            String[] brefContents, String[] contents) {
        try {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();

            for (int i = 0, size = articleIds.length; i < size; i++) {
                if (!articleIds[i].equals("0")) {
                    //已存在文章，进行修改
                    Article article = articleDao.findById(Integer.parseInt(articleIds[i]));

                    article.setCategoryId(categoryIds[i]);
                    article.setLabel(labels[i]);
                    article.setTitle(titles[i]);
                    article.setBriefIndc(brefContents[i]);
                    article.setContent(contents[i]);
                    articleDao.update(article);
                } else {
                    //新增文章，进行添加
                    Article article = new Article();
                    User user = (User) session.get("USER");
                    article.setUserId(user.getUserId());
                    article.setCategoryId(categoryIds[i]);
                    article.setLabel(labels[i]);
                    article.setTitle(titles[i]);
                    article.setBriefIndc(brefContents[i]);
                    article.setContent(contents[i]);
                    Date date = new Date();
                    Timestamp nousedate = new Timestamp(date.getTime());
                    article.setPubTime(nousedate);
                    articleDao.save(article);
                }
            }
            return 1;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return 0;
        }

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
