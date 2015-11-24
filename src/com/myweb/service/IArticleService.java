package com.myweb.service;

import java.util.List;

import com.myweb.view.ArticleListView;
import com.myweb.view.ArticleView;

/**
 * 
 * @author huleiwind
 * @version $Id: IArticleService.java, v 0.1 2015-10-8 上午11:03:48 huleiwind Exp $
 */
public interface IArticleService {

    /**
     * 分页查询文章（不包括文章内容）
     * 
     * @param pageNo   起始页码
     * @param pageSize  一页条数
     * @return
     */
    public List<ArticleListView> findArticlesByPage(int pageNo, int pageSize, int categoryId);

    /**
     * 根据文章id查询文章详细内容
     * 
     * @param articleId  文章id
     * @return
     */
    public ArticleView findArticleDetailById(int articleId);

    /**
     * 查询文章数
     * 
     * @param categoryId  文章栏目id
     * @return
     */
    public int findArticlesNum(int categoryId);

    /**
     * 根据栏目id查询出最近发表的100篇文章详细内容
     * 
     * @param categoryId  文章栏目id
     * @return
     */
    public List<ArticleView> findArticleDetailList(int categoryId);

    /**
     * 批量添加或修改指定栏目下文章
     * 
     * @param articleIds
     * @param categoryIds
     * @param labels
     * @param titles
     * @param brefContents
     * @param contents
     * @return
     */
    public int addAndUpdateCategoryArticles(int[] articleIds, int[] categoryIds, String[] labels,
                                            String[] titles, String[] brefContents,
                                            String[] contents);
}
