package com.myweb.dao;

import java.util.List;

import com.myweb.entity.Category;

public interface CategoryDAO {
    public Integer save(Category category);

    public void delete(Category category);

    public Category findById(int id);

    public Integer findNums(int categoryId);

    public List<Category> findAllCategories();
}
