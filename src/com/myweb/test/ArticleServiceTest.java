package com.myweb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myweb.entity.Article;
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
        List<Article> articles = articleService.findArticlesByPage(1, 3);
        assertNotNull(articles);
    }

    @Test
    public void testFindArticleById() {
        Article article = articleService.findArticleById(1);
        assertNotNull(article);
    }

}
