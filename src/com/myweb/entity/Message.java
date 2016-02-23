package com.myweb.entity;

import java.sql.Timestamp;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

    // Fields    

    private Integer   messageId;
    private Integer   sendUserId;
    private Integer   receiveUserId;
    private String    messageContent;
    private Timestamp sendTime;
    private Integer   group;

    // Constructors

    /** default constructor */
    public Message() {
    }

    /** full constructor */
    public Message(Integer sendUserId, Integer receiveUserId, String messageContent,
                   Timestamp sendTime, Integer group) {
        this.sendUserId = sendUserId;
        this.receiveUserId = receiveUserId;
        this.messageContent = messageContent;
        this.sendTime = sendTime;
        this.group = group;
    }

    // Property accessors

    public Integer getMessageId() {
        return this.messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getSendUserId() {
        return this.sendUserId;
    }

    public void setSendUserId(Integer sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Integer getReceiveUserId() {
        return this.receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public String getMessageContent() {
        return this.messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Timestamp getSendTime() {
        return this.sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getGroup() {
        return this.group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

}