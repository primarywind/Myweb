package com.myweb.dao;

import java.util.List;

import com.myweb.entity.Category;

public interface CategoryDAO {
    public Integer save(Category category);

    public void update(Category category);

    public void delete(Category category);

    public int deleteByCid(Integer delCId);

    public Category findById(int id);

    public Integer findNums(int categoryId);

    public List<Category> findCategories(int ifView);

    public List<Category> findAllCategories();

}
