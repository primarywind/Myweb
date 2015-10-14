package com.myweb.service;

import java.util.List;

import com.myweb.view.PictureListView;

/**
 * 
 * @author huleiwind
 * @version $Id: IPictureService.java, v 0.1 2015-10-14 下午3:57:40 huleiwind Exp $
 */
public interface IPictureService {
    /**
     * 分页查看图片信息
     * 
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<PictureListView> findByPages(int pageNo, int pageSize);
}
