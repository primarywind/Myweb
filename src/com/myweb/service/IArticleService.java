package com.myweb.service;

import java.util.List;

import com.myweb.entity.Article;
import com.myweb.view.ArticleListView;

/**
 * 
 * @author huleiwind
 * @version $Id: IArticleService.java, v 0.1 2015-10-8 上午11:03:48 huleiwind Exp $
 */
public interface IArticleService {

    /**
     * 分页查询文章
     * 
     * @param pageNo   起始页码
     * @param pageSize  一页条数
     * @return
     */
    public List<ArticleListView> findArticlesByPage(int pageNo, int pageSize, int categoryId);

    /**
     * 根据文章id查询文章
     * 
     * @param id  文章id
     * @return
     */
    public Article findArticleById(int id);

    public int findArticlesNum(int findArticlesNum);
}
