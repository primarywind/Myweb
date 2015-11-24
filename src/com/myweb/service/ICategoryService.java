package com.myweb.service;

import java.util.List;

import com.myweb.view.CategoryView;

public interface ICategoryService {
    /**
     * 获取栏目信息（可见或者不可见）
     * @return
     */
    public List<CategoryView> findCategories(int ifView);

    /**
     * 获取所有栏目信息
     * @return
     */
    public List<CategoryView> findAllCategories();

    /**
     * 批量添加或者更新栏目信息
     * 
     * @param cName
     * @param cHref
     * @param cifView
     * @return
     */
    public int addAndUpdateCategories(String[] cId, String[] cName, String[] cHref,
                                      String[] CIndex, String[] cifView);

    /**
     * 根据cid删除栏目
     * 
     * @param delCId
     * @return
     */
    public int deleteCategoryByCId(int delCId);

    /**
     * 查找所有文章类型栏目（href为空，ifview＝1）
     * 
     * @return
     */
    public List<CategoryView> findArticleCategories();
}
