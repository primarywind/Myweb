package com.myweb.action;

import java.util.HashMap;
import java.util.Map;

import com.myweb.entity.Sendcard;
import com.myweb.entity.User;
import com.myweb.result.BizResult;
import com.myweb.result.CardDetailQueryResult;
import com.myweb.result.MessageListQueryResult;
import com.myweb.result.SendCardListQueryResult;
import com.myweb.service.IMessageService;
import com.myweb.service.ISendCardService;
import com.myweb.view.SendCardDetailView;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
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
    private IMessageService    messageService;
    private int                pageNo           = 1;
    //默认一页10条
    private int                pageSize         = 10;

    private int                sendCardId;

    private int                followCardId;
    private int                updateFavoriteType;
    private String             message;
    //搜索关键词（为空则全显示）
    private String             keyWord;
    //排序（1＝按回复数量  2＝按时间（默认）  3＝推荐   4＝等待回复）
    private int                orderType;

    private String             cardTitle;
    private String             cardContent;
    private String             cardLabel;
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

    public String addCardComment() {
        BizResult<Object> bizResult = sendCardService.addCardComment(sendCardId, message);
        Map<String, Object> map = new HashMap<String, Object>();
        if (bizResult.isSuccess()) {
            map.put("msg", "添加成功");
        } else {
            map.put("msg", "添加失败");
        }
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String addOthCardComment() {
        BizResult<Object> bizResult = sendCardService.addOthCardComment(followCardId, message);
        Map<String, Object> map = new HashMap<String, Object>();
        if (bizResult.isSuccess()) {
            map.put("msg", "添加成功");
        } else {
            map.put("msg", "添加失败");
        }
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String updateCardFavorite() {

        BizResult<Object> bizResult = sendCardService.updateCardFavorite(sendCardId,
            updateFavoriteType);
        Map<String, Object> map = new HashMap<String, Object>();
        if (bizResult.isSuccess()) {
            map.put("msg", "添加成功");
        } else {
            map.put("msg", "添加失败");
        }
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String goToPublish() {
        return Action.SUCCESS;
    }

    public String goToPeople() {
        return Action.SUCCESS;
    }

    public String submitSendCard() {
        BizResult<Object> bizResult = sendCardService.saveSendCard(cardTitle, cardContent,
            cardLabel);
        Map<String, Object> map = new HashMap<String, Object>();
        if (bizResult.isSuccess()) {
            map.put("msg", "添加成功");
            map.put("sendCardId", ((Sendcard) bizResult.getObject()).getCardId());
        } else {
            map.put("msg", "添加失败");
        }
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String getMessageList() {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        int userId = ((User) session.get("USER")).getUserId();
        MessageListQueryResult messageListQueryResult = messageService
            .getMessageListByReceiveUserId(userId, pageNo, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("messageViewList", messageListQueryResult.getMessageViewList());
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String gotoMessage() {
        return Action.SUCCESS;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getFollowCardId() {
        return followCardId;
    }

    public void setFollowCardId(int followCardId) {
        this.followCardId = followCardId;
    }

    public int getUpdateFavoriteType() {
        return updateFavoriteType;
    }

    public void setUpdateFavoriteType(int updateFavoriteType) {
        this.updateFavoriteType = updateFavoriteType;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public String getCardContent() {
        return cardContent;
    }

    public void setCardContent(String cardContent) {
        this.cardContent = cardContent;
    }

    public String getCardLabel() {
        return cardLabel;
    }

    public void setCardLabel(String cardLabel) {
        this.cardLabel = cardLabel;
    }

    public IMessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(IMessageService messageService) {
        this.messageService = messageService;
    }

}
