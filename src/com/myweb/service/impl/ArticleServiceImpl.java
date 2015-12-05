package com.myweb.service.impl;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.myweb.dao.ArticleDao;
import com.myweb.dao.CategoryDAO;
import com.myweb.dao.UserDao;
import com.myweb.entity.Article;
import com.myweb.entity.User;
import com.myweb.result.ArticleDetailListQueryResult;
import com.myweb.result.ArticleListQueryResult;
import com.myweb.result.ArticleQueryResult;
import com.myweb.result.ArticlesNumQueryResult;
import com.myweb.result.BizResult;
import com.myweb.service.IArticleService;
import com.myweb.template.QueryCallBack;
import com.myweb.template.ServiceCallBack;
import com.myweb.view.ArticleListView;
import com.myweb.view.ArticleView;
import com.opensymphony.xwork2.ActionContext;

/**
 * 文章模块服务
 * @author huleiwind
 * @version $Id: ArticleServiceImpl.java, v 0.1 2015-10-8 上午11:03:48 huleiwind Exp $
 */
public class ArticleServiceImpl extends BaseService implements IArticleService {
    private ArticleDao  articleDao;
    private UserDao     userDao;
    private CategoryDAO categoryDao;

    public ArticleListQueryResult findArticlesByPage(final int pageNo, final int pageSize,
                                                     final int categoryId) {

        return getViewQueryTemplate().process(ArticleListQueryResult.class,
            new QueryCallBack<ArticleListQueryResult>() {

                @Override
                public void check() {
                    if (pageNo == 0 || pageSize == 0) {
                        //异常类待细分，现统一抛出运行时异常
                        throw new RuntimeException();
                    }
                }

                @Override
                public void doProcess(ArticleListQueryResult result) {
                    List<Article> articles = articleDao.findByPages(pageNo, pageSize, categoryId);
                    List<ArticleListView> articleListViews = getViewObjectMapper().map(articles,
                        ArticleListView.class);
                    for (ArticleListView articleListView : articleListViews) {
                        User user = userDao.findById(articleListView.getUserId());
                        articleListView.setUserName(user.getUserName());
                        articleListView.setPubTime(articleListView.getPubTime().substring(0, 19));
                    }
                    result.setArticleList(articleListViews);
                }
            });

    }

    public ArticlesNumQueryResult findArticlesNum(final int categoryId) {

        return getViewQueryTemplate().process(ArticlesNumQueryResult.class,
            new QueryCallBack<ArticlesNumQueryResult>() {
                @Override
                public void check() {
                    if (categoryId < 0) {
                        //异常类待细分，现统一抛出运行时异常
                        throw new RuntimeException();
                    }
                }

                @Override
                public void doProcess(ArticlesNumQueryResult result) {
                    int nums = categoryDao.findNums(categoryId);
                    result.setNums(nums);
                }
            });

    }

    public ArticleQueryResult findArticleDetailById(final int articleId) {
        return getViewQueryTemplate().process(ArticleQueryResult.class,
            new QueryCallBack<ArticleQueryResult>() {

                @Override
                public void check() {
                    if (articleId < 0) {
                        //异常类待细分，现统一抛出运行时异常
                        throw new RuntimeException();
                    }
                }

                @Override
                public void doProcess(ArticleQueryResult result) {
                    Article article = articleDao.findById(articleId);
                    ArticleView articleView = getViewObjectMapper().map(article, ArticleView.class);
                    User user = userDao.findById(articleView.getUserId());
                    articleView.setUserName(user.getUserName());
                    articleView.setBlogUrl(user.getBlogUrl());
                    articleView.setNationality(user.getNationality());
                    articleView.setPubTime(articleView.getPubTime().substring(0, 19));
                    result.setArticleView(articleView);
                }
            });

    }

    public ArticleDetailListQueryResult findArticleDetailList(final int categoryId) {
        return getViewQueryTemplate().process(ArticleDetailListQueryResult.class,
            new QueryCallBack<ArticleDetailListQueryResult>() {

                @Override
                public void check() {
                    if (categoryId < 0) {
                        //异常类待细分，现统一抛出运行时异常
                        throw new RuntimeException();
                    }
                }

                @Override
                public void doProcess(ArticleDetailListQueryResult result) {
                    List<Article> articles = articleDao.findByPages(1, 100, categoryId);
                    List<ArticleView> articleListViews = getViewObjectMapper().map(articles,
                        ArticleView.class);
                    for (ArticleView articleView : articleListViews) {
                        User user = userDao.findById(articleView.getUserId());
                        articleView.setUserName(user.getUserName());
                        articleView.setBlogUrl(user.getBlogUrl());
                        articleView.setNationality(user.getNationality());
                        articleView.setPubTime(articleView.getPubTime().substring(0, 19));
                    }
                    result.setArticleViewList(articleListViews);
                }
            });
    }

    public BizResult addAndUpdateCategoryArticles(final String[] articleIds,
                                                  final int[] categoryIds, final String[] labels,
                                                  final String[] titles,
                                                  final String[] brefContents,
                                                  final String[] contents, final String[] delAIds) {

        BizResult<Object> bizResult = getServiceTemplate().serviceProcess(
            new ServiceCallBack<Object>() {
                @Override
                public void beforeService() {

                }

                @Override
                public BizResult<Object> executeService() {
                    ActionContext actionContext = ActionContext.getContext();
                    Map session = actionContext.getSession();

                    for (int i = 0, size = articleIds.length; i < size; i++) {
                        if (!articleIds[i].equals("0")) {
                            //已存在文章，进行修改

                            if (delAIds != null && delAIds.length != 0
                                && Arrays.asList(delAIds).contains(articleIds[i])) {
                                //1.如果为删除项目，则直接删除
                                articleDao.deleteById(Integer.parseInt(articleIds[i]));
                            } else {
                                //2.如果不为删除项目，则更新
                                Article article = articleDao.findById(Integer
                                    .parseInt(articleIds[i]));
                                article.setCategoryId(categoryIds[i]);
                                article.setLabel(labels[i]);
                                article.setTitle(titles[i]);
                                article.setBriefIndc(brefContents[i]);
                                article.setContent(contents[i]);
                                articleDao.update(article);
                            }
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
                    return BizResult.valueOfSuccessed();
                }

                @Override
                public void afterService(BizResult<Object> result) {

                }

            });
        return bizResult;

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
