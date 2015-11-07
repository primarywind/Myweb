package com.myweb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myweb.service.ICategoryService;
import com.myweb.view.CategoryView;

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
        List<CategoryView> lists = categoryService.findCategories(1);
        System.out.println(lists);
    }
}
