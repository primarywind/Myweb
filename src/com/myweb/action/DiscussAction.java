package com.myweb.action;

import java.util.HashMap;
import java.util.Map;

import com.myweb.result.CardDetailQueryResult;
import com.myweb.result.SendCardListQueryResult;
import com.myweb.service.ISendCardService;
import com.myweb.view.SendCardDetailView;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author huleiwind
 * @version $Id: SendCardAction.java, v 0.1 2015-10-18 下午4:50:59 huleiwind Exp $
 */
public class DiscussAction extends ActionSupport {

    /**  */
    private static final long  serialVersionUID = 8832078066500609240L;

    private ISendCardService   sendCardService;

    private int                pageNo           = 1;
    //默认一页10条
    private int                pageSize         = 10;

    private int                sendCardId;

    //搜索关键词（为空则全显示）
    private String             keyWord;
    //排序（1＝按回复数量  2＝按时间（默认）  3＝推荐   4＝等待回复）
    private int                orderType;

    private SendCardDetailView sendCardDetailView;

    public Map                 responseJson;

    public String findSendCardsByPage() {
        SendCardListQueryResult sendCardListResult = sendCardService.findSendCardsByPage(pageNo,
            pageSize, orderType);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sendCardListViews", sendCardListResult.getSendCardListView());
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String getDiscussDetail() {
        CardDetailQueryResult cardDetailQueryResult = sendCardService.getSendCardDetail(sendCardId);

        if (cardDetailQueryResult.isSuccess()) {
            sendCardDetailView = cardDetailQueryResult.getSendCardDetailView();
            return Action.SUCCESS;
        } else {
            return Action.ERROR;
        }

    }

    public String findSendCardDateilsByPage() {

        return Action.SUCCESS;
    }

    public String fillDiscuss() {
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

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public SendCardDetailView getSendCardDetailView() {
        return sendCardDetailView;
    }

    public void setSendCardDetailView(SendCardDetailView sendCardDetailView) {
        this.sendCardDetailView = sendCardDetailView;
    }

}
