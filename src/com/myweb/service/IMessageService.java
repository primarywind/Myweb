package com.myweb.service;

import com.myweb.result.BizResult;
import com.myweb.result.MessageListQueryResult;

/**
 * 
 * @author huleiwind
 * @version $Id: IMessageService.java, v 0.1 2016-2-24 上午1:02:28 huleiwind Exp $
 */
public interface IMessageService {
    /**
     * 根据接受人id分页查询消息列表
     * 
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public MessageListQueryResult getMessageListByReceiveUserId(int userId, int pageNo, int pageSize);

    /**
     * 保存消息
     * 
     * @param sendUserId
     * @param receiveName
     * @param messageContent
     * @return
     */
    public BizResult<Object> addMessage(int sendUserId, String receiveName, String messageContent);

    /**
     * 根据messageId查询私信列表
     * 
     * @param messageId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public MessageListQueryResult getMessageDetailList(int messageId, int pageNo, int pageSize);

    /**
     *  回复私信
     * 
     * @param sendUserId
     * @param receiveUserId
     * @param messageContent
     * @return
     */
    public BizResult<Object> addReceiveMessage(int sendUserId, int receiveUserId, int messageGroup,
                                               String messageContent);

}
