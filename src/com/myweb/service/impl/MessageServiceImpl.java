package com.myweb.service.impl;

import java.util.List;

import com.myweb.dao.MessageDao;
import com.myweb.dao.UserDao;
import com.myweb.entity.Message;
import com.myweb.entity.User;
import com.myweb.result.MessageListQueryResult;
import com.myweb.service.IMessageService;
import com.myweb.template.QueryCallBack;
import com.myweb.view.MessageView;

/**
 * 
 * @author huleiwind
 * @version $Id: MessageServiceImpl.java, v 0.1 2016-2-24 上午1:06:24 huleiwind Exp $
 */
public class MessageServiceImpl extends BaseService implements IMessageService {
    private MessageDao messageDao;
    private UserDao    userDao;

    @Override
    public MessageListQueryResult getMessageListByReceiveUserId(final int userId, final int pageNo,
                                                                final int pageSize) {
        return getViewQueryTemplate().process(MessageListQueryResult.class,
            new QueryCallBack<MessageListQueryResult>() {
                @Override
                public void check() {

                }

                @Override
                public void doProcess(MessageListQueryResult result) {
                    List<Message> messages = messageDao.findByReceiveUserId(userId, pageNo,
                        pageSize);

                    List<MessageView> messageViewList = getViewObjectMapper().map(messages,
                        MessageView.class);
                    for (MessageView messageView : messageViewList) {
                        int SendUserId = messageView.getSendUserId();
                        User sendUser = userDao.findById(SendUserId);
                        messageView.setSendUserFaceImg(sendUser.getFaceImg());
                        messageView.setSendUserName(sendUser.getUserName());
                    }
                    result.setMessageViewList(messageViewList);
                }
            });
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
