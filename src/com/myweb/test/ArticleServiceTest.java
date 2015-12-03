package com.myweb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myweb.result.ArticleListQueryResult;
import com.myweb.result.ArticleQueryResult;
import com.myweb.result.ArticlesNumQueryResult;
import com.myweb.service.IArticleService;

/**
 * 
 * @author huleiwind
 * @version $Id: ArticleServiceTest.java, v 0.1 2015-10-8 上午11:03:48 huleiwind Exp $
 */
public class ArticleServiceTest extends SpringTestBase {
    @Autowired
    private IArticleService articleService;

    @Test
    public void testConfig() {
        assertNotNull(articleService);
        assertTrue(articleService != null);
    }

    @Test
    public void testFindArticlesByPage() {
        ArticleListQueryResult articles = articleService.findArticlesByPage(1, 3, 0);
        assertNotNull(articles);
    }

    @Test
    public void testFindArticlesNums() {
        ArticlesNumQueryResult nums = articleService.findArticlesNum(0);
        assertNotNull(nums);
    }

    @Test
    public void testFindArticleById() {
        ArticleQueryResult article = articleService.findArticleDetailById(1);
        assertNotNull(article);
    }

}
