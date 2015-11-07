package com.myweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.myweb.dao.ArticleDao;
import com.myweb.dao.CategoryDAO;
import com.myweb.entity.Article;
import com.myweb.entity.Category;
import com.myweb.service.ICategoryService;
import com.myweb.view.CategoryView;

/**
 * 
 * @author huleiwind
 * @version $Id: CategoryService.java, v 0.1 2015-10-13 下午12:51:11 huleiwind Exp $
 */
public class CategoryServiceImpl extends BaseService implements ICategoryService {
    private CategoryDAO categoryDao;
    private ArticleDao  articleDao;

    public List<CategoryView> findCategories(int ifView) {
        List<Category> categories = categoryDao.findCategories(ifView);
        List<CategoryView> categoryListViews = getViewObjectMapper().map(categories,
            CategoryView.class);
        return categoryListViews;
    }

    public List<CategoryView> findAllCategories() {
        List<Category> categories = categoryDao.findAllCategories();
        List<CategoryView> categoryListViews = getViewObjectMapper().map(categories,
            CategoryView.class);
        return categoryListViews;
    }

    public int addAndUpdateCategories(String[] cId, String[] cName, String[] cHref,
                                      String[] CIndex, String[] cifView) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public int deleteCategoryByCId(int delCId) {
        try {
            List<Article> articles = articleDao.findByCId(delCId);
            if (articles.size() == 0) {
                categoryDao.deleteByCid(delCId);
                //符合条件，可以删除
                return 1;
            } else {
                //栏目下有文章，无法删除
                return 2;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            //系统异常
            return 0;
        }
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
