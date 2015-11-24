package com.myweb.dao;

import java.util.List;

import com.myweb.entity.Article;

/**
 * 
 * @author huleiwind
 * @version $Id: ArticleDao.java, v 0.1 2015-10-4 下午8:33:33 huleiwind Exp $
 */
public interface ArticleDao {
    public Integer save(Article article);

    public void update(Article article);

    public void delete(Article article);

    public Article findById(int id);

    public List<Article> findByCId(int categoryId);

    public List<Article> findByPages(int pageNo, int pageSize, int categoryId);
}
