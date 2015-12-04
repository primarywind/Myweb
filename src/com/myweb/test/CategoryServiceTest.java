package com.myweb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myweb.result.CategoryListQueryResult;
import com.myweb.service.ICategoryService;

/**
 * 
 * @author huleiwind
 * @version $Id: CategoryServiceTest.java, v 0.1 2015-10-13 下午1:16:53 huleiwind Exp $
 */
public class CategoryServiceTest extends SpringTestBase {
    @Autowired
    private ICategoryService categoryService;

    @Test
    public void testConfig() {
        assertNotNull(categoryService);
        assertTrue(categoryService != null);
    }

    @Test
    public void testFindCategories() {
        CategoryListQueryResult categoryListQueryResult = categoryService.findCategories(1);
        System.out.println(categoryListQueryResult);
    }
}
