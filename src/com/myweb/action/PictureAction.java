package com.myweb.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myweb.result.PictureListQueryResult;
import com.myweb.service.IPictureService;
import com.myweb.view.PictureListView;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author huleiwind
 * @version $Id: PictureAction.java, v 0.1 2015-10-14 下午4:47:12 huleiwind Exp $
 */
public class PictureAction extends ActionSupport {
    /**  */
    private static final long serialVersionUID = 3198512705781943241L;
    private IPictureService   pictureService;
    private int               pageNo           = 1;
    //默认一页10条
    private int               pageSize         = 10;
    public Map                responseJson;

    public String findPicturesByPage() {
        Map<String, Object> map = new HashMap<String, Object>();
        PictureListQueryResult pictureListQueryResult = pictureService
            .findByPages(pageNo, pageSize);
        List<PictureListView> pictureListViews = pictureListQueryResult.getPictureList();
        map.put("pictureListViews", pictureListViews);
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public IPictureService getPictureService() {
        return pictureService;
    }

    public void setPictureService(IPictureService pictureService) {
        this.pictureService = pictureService;
    }

    public Map getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(Map responseJson) {
        this.responseJson = responseJson;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
