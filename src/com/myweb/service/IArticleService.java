package com.myweb.service;

import com.myweb.result.ArticleDetailListQueryResult;
import com.myweb.result.ArticleListQueryResult;
import com.myweb.result.ArticleQueryResult;
import com.myweb.result.ArticlesNumQueryResult;
import com.myweb.result.BizResult;

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
    public ArticleListQueryResult findArticlesByPage(int pageNo, int pageSize, int categoryId);

    /**
     * 根据文章id查询文章详细内容
     * 
     * @param articleId  文章id
     * @return
     */
    public ArticleQueryResult findArticleDetailById(int articleId);

    /**
     * 查询文章数
     * 
     * @param categoryId  文章栏目id
     * @return
     */
    public ArticlesNumQueryResult findArticlesNum(int categoryId);

    /**
     * 根据栏目id查询出最近发表的100篇文章详细内容
     * 
     * @param categoryId  文章栏目id
     * @return
     */
    public ArticleDetailListQueryResult findArticleDetailList(int categoryId);

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
    public BizResult addAndUpdateCategoryArticles(String[] articleIds, int[] categoryIds,
                                                  String[] labels, String[] titles,
                                                  String[] brefContents, String[] contents,
                                                  String[] delAIds);
}
