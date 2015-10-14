package com.myweb.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myweb.service.IPictureService;
import com.myweb.view.PictureListView;

/**
 * 
 * @author huleiwind
 * @version $Id: PictureServiceTest.java, v 0.1 2015-10-14 下午4:23:11 huleiwind Exp $
 */
public class PictureServiceTest extends SpringTestBase {
    @Autowired
    private IPictureService prictureService;

    @Test
    public void testFindCategories() {
        List<PictureListView> lists = prictureService.findByPages(1, 2);
        System.out.println(lists);
    }
}
