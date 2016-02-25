package com.myweb.view;

import java.sql.Timestamp;

/**
 * 
 * @author huleiwind
 * @version $Id: MessageView.java, v 0.1 2016-2-24 上午12:51:21 huleiwind Exp $
 */
public class MessageView {
    private Integer   messageId;
    private Integer   sendUserId;
    private Integer   receiveUserId;
    private String    messageContent;
    private Timestamp sendTime;
    private Integer   messageGroup;

    private String    sendUserName;
    private String    sendUserFaceImg;

    private String    receiveUserName;
    private String    receiveUserFaceImg;

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public String getSendUserFaceImg() {
        return sendUserFaceImg;
    }

    public void setSendUserFaceImg(String sendUserFaceImg) {
        this.sendUserFaceImg = sendUserFaceImg;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Integer sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getMessageGroup() {
        return messageGroup;
    }

    public void setMessageGroup(Integer messageGroup) {
        this.messageGroup = messageGroup;
    }

    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }

    public String getReceiveUserFaceImg() {
        return receiveUserFaceImg;
    }

    public void setReceiveUserFaceImg(String receiveUserFaceImg) {
        this.receiveUserFaceImg = receiveUserFaceImg;
    }

}
