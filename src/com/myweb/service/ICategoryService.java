package com.myweb.service;

import java.util.List;

import com.myweb.view.CategoryView;

public interface ICategoryService {
    /**
     * 获取所有栏目信息
     * @return
     */
    public List<CategoryView> findCategories();
}
