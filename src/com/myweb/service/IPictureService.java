package com.myweb.service;

import java.io.File;

import com.myweb.entity.Picture;
import com.myweb.result.BizResult;
import com.myweb.result.PictureListQueryResult;

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
    public PictureListQueryResult findByPages(int pageNo, int pageSize);

    /**
     * 上传图片并保存
     * 
     * @param file
     * @param fileName
     * @return
     */
    public BizResult<Picture> uploadPicFile(File file, String fileName);
}
