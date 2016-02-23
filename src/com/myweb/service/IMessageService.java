package com.myweb.service;

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
}
