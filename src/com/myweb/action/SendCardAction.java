/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.myweb.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myweb.service.ISendCardService;
import com.myweb.view.SendCardDetailView;
import com.myweb.view.SendCardListView;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author huleiwind
 * @version $Id: SendCardAction.java, v 0.1 2015-10-18 下午4:50:59 huleiwind Exp $
 */
public class SendCardAction extends ActionSupport {

    /**  */
    private static final long serialVersionUID = 8832078066500609240L;

    private ISendCardService  sendCardService;

    private int               pageNo           = 1;
    //默认一页10条
    private int               pageSize         = 10;

    private int               sendCardId       = 0;
    public Map                responseJson;

    public String findSendCardsByPage() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<SendCardListView> sendCardListViews = sendCardService.findSendCardsByPage(pageNo,
            pageSize);
        map.put("sendCardListViews", sendCardListViews);
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String findSendCardDateilsByPage() {
        Map<String, Object> map = new HashMap<String, Object>();
        SendCardDetailView SendCardDetailView = sendCardService.getSendCardDetail(sendCardId);
        map.put("sendCardDetailView", SendCardDetailView);
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public ISendCardService getSendCardService() {
        return sendCardService;
    }

    public void setSendCardService(ISendCardService sendCardService) {
        this.sendCardService = sendCardService;
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

    public Map getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(Map responseJson) {
        this.responseJson = responseJson;
    }

    public int getSendCardId() {
        return sendCardId;
    }

    public void setSendCardId(int sendCardId) {
        this.sendCardId = sendCardId;
    }

}
