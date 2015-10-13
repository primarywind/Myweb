package com.myweb.service.impl;

import java.util.List;

import com.myweb.dao.CategoryDAO;
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

    public List<CategoryView> findCategories() {
        List<Category> categories = categoryDao.findAllCategories();
        List<CategoryView> categoryListViews = getViewObjectMapper().map(categories,
            CategoryView.class);
        return categoryListViews;
    }

    public CategoryDAO getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDAO categoryDao) {
        this.categoryDao = categoryDao;
    }
}
