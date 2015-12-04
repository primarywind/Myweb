package com.myweb.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.myweb.dao.ArticleDao;
import com.myweb.dao.CategoryDAO;
import com.myweb.entity.Article;
import com.myweb.entity.Category;
import com.myweb.result.BizResult;
import com.myweb.result.CategoryListQueryResult;
import com.myweb.service.ICategoryService;
import com.myweb.template.QueryCallBack;
import com.myweb.template.ServiceCallBack;
import com.myweb.view.CategoryView;

/**
 * 栏目模块服务
 * @author huleiwind
 * @version $Id: CategoryService.java, v 0.1 2015-10-13 下午12:51:11 huleiwind Exp $
 */
public class CategoryServiceImpl extends BaseService implements ICategoryService {
    private CategoryDAO categoryDao;
    private ArticleDao  articleDao;

    public CategoryListQueryResult findCategories(final int ifView) {
        return getViewQueryTemplate().process(CategoryListQueryResult.class,
            new QueryCallBack<CategoryListQueryResult>() {
                @Override
                public void check() {

                }

                @Override
                public void doProcess(CategoryListQueryResult result) {
                    List<Category> categories = categoryDao.findCategories(ifView);
                    List<CategoryView> categoryListViews = getViewObjectMapper().map(categories,
                        CategoryView.class);
                    result.setCategoryList(categoryListViews);
                }
            });

    }

    public CategoryListQueryResult findAllCategories() {
        return getViewQueryTemplate().process(CategoryListQueryResult.class,
            new QueryCallBack<CategoryListQueryResult>() {
                @Override
                public void check() {

                }

                @Override
                public void doProcess(CategoryListQueryResult result) {
                    List<Category> categories = categoryDao.findAllCategories();
                    List<CategoryView> categoryListViews = getViewObjectMapper().map(categories,
                        CategoryView.class);
                    result.setCategoryList(categoryListViews);
                }
            });

    }

    public BizResult<Object> addAndUpdateCategories(final String[] cId, final String[] cName,
                                                    final String[] cHref, final String[] CIndex,
                                                    final String[] cifView) {
        return getServiceTemplate().serviceProcess(new ServiceCallBack<Object>() {

            @Override
            public void beforeService() {
            }

            @Override
            public BizResult<Object> executeService() {
                Timestamp time = new Timestamp(System.currentTimeMillis());
                for (int i = 0; i < cifView.length; i++) {
                    //批量更新栏目或者添加栏目
                    if ("?".equals(cId[i]) || "？".equals(cId[i])) {
                        //添加
                        Category category = new Category();
                        category.setName(cName[i]);
                        category.setCHref(cHref[i]);
                        category.setIfview(Integer.parseInt(cifView[i]));
                        category.setAddTime(time);
                        category.setCIndex(Integer.parseInt(CIndex[i]));
                        categoryDao.save(category);
                    } else {
                        //更新
                        Category category = categoryDao.findById(Integer.parseInt(cId[i]));
                        category.setName(cName[i]);
                        category.setCHref(cHref[i]);
                        category.setIfview(Integer.parseInt(cifView[i]));
                        category.setCIndex(Integer.parseInt(CIndex[i]));
                        categoryDao.update(category);
                    }
                }
                return BizResult.valueOfSuccessed();
            }

            @Override
            public void afterService(BizResult<Object> result) {
            }
        });
    }

    public BizResult<Object> deleteCategoryByCId(final int delCId) {
        return getServiceTemplate().serviceProcess(new ServiceCallBack<Object>() {

            @Override
            public void beforeService() {
            }

            @Override
            public BizResult<Object> executeService() {
                List<Article> articles = articleDao.findByCId(delCId);
                if (articles.size() == 0) {
                    categoryDao.deleteByCid(delCId);
                    //符合条件，可以删除
                    return BizResult.valueOfSuccessed();
                } else {
                    //栏目下有文章，无法删除
                    return BizResult.valueOfFailed();
                }
            }

            @Override
            public void afterService(BizResult<Object> result) {
            }

        });
    }

    public CategoryListQueryResult findArticleCategories() {
        return getViewQueryTemplate().process(CategoryListQueryResult.class,
            new QueryCallBack<CategoryListQueryResult>() {

                @Override
                public void check() {
                }

                @Override
                public void doProcess(CategoryListQueryResult result) {
                    List<Category> categories = categoryDao.findAllCategories();
                    List<Category> categoryResult = new ArrayList<Category>();
                    for (Category category : categories) {
                        if (("".equals(category.getCHref()) || category.getCHref() == null)
                            && category.getIfview() == 1) {
                            //符合条件加入队列
                            categoryResult.add(category);
                        }
                    }
                    List<CategoryView> categoryListViews = getViewObjectMapper().map(
                        categoryResult, CategoryView.class);
                    result.setCategoryList(categoryListViews);
                }
            });
    }

    public CategoryDAO getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDAO categoryDao) {
        this.categoryDao = categoryDao;
    }

    public ArticleDao getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }
}
