package com.myweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.myweb.dao.MessageDao;
import com.myweb.dao.UserDao;
import com.myweb.entity.Message;
import com.myweb.entity.User;
import com.myweb.result.BizResult;
import com.myweb.result.MessageListQueryResult;
import com.myweb.service.IMessageService;
import com.myweb.template.QueryCallBack;
import com.myweb.template.ServiceCallBack;
import com.myweb.util.StringUtil;
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

    @Override
    public BizResult<Object> addMessage(final int sendUserId, final String receiveName,
                                        final String messageContent) {
        return getServiceTemplate().serviceProcess(new ServiceCallBack<Object>() {

            @Override
            public void beforeService() {
                if (StringUtil.isEmpty(receiveName) || StringUtil.isEmpty(messageContent)) {
                    throw new RuntimeException();
                }
            }

            @Override
            public BizResult<Object> executeService() {
                Timestamp time = new Timestamp(System.currentTimeMillis());
                User user = userDao.findByName(receiveName);
                Message message = new Message();
                int maxGroup = messageDao.getMaxGroupBySendUserId(sendUserId);
                int newGroup = maxGroup + 1;
                message.setMessageGroup(newGroup);
                message.setMessageContent(messageContent);
                message.setSendTime(time);
                message.setSendUserId(sendUserId);
                message.setReceiveUserId(user.getUserId());
                messageDao.save(message);
                return BizResult.valueOfSuccessed();
            }

            @Override
            public void afterService(BizResult<Object> result) {
            }
        });
    }

    @Override
    public MessageListQueryResult getMessageDetailList(final int messageId, final int pageNo,
                                                       final int pageSize) {
        return getViewQueryTemplate().process(MessageListQueryResult.class,
            new QueryCallBack<MessageListQueryResult>() {
                @Override
                public void check() {

                }

                @Override
                public void doProcess(MessageListQueryResult result) {
                    Message message = messageDao.findById(messageId);
                    int messageGroup = message.getMessageGroup();
                    List<Message> messages = messageDao.findByGroup(messageGroup, pageNo, pageSize);
                    List<MessageView> messageViewList = getViewObjectMapper().map(messages,
                        MessageView.class);
                    for (MessageView messageView : messageViewList) {
                        int SendUserId = messageView.getSendUserId();
                        User sendUser = userDao.findById(SendUserId);
                        messageView.setSendUserFaceImg(sendUser.getFaceImg());
                        messageView.setSendUserName(sendUser.getUserName());

                        int receiveUserId = messageView.getReceiveUserId();
                        User receiveUser = userDao.findById(receiveUserId);
                        messageView.setReceiveUserFaceImg(receiveUser.getFaceImg());
                        messageView.setReceiveUserName(receiveUser.getUserName());
                    }
                    result.setMessageViewList(messageViewList);
                }
            });
    }

    @Override
    public BizResult<Object> addReceiveMessage(final int sendUserId, final int receiveUserId,
                                               final int messageGroup, final String messageContent) {
        return getServiceTemplate().serviceProcess(new ServiceCallBack<Object>() {

            @Override
            public void beforeService() {
                if (StringUtil.isEmpty(messageContent)) {
                    throw new RuntimeException();
                }
            }

            @Override
            public BizResult<Object> executeService() {
                Timestamp time = new Timestamp(System.currentTimeMillis());

                Message message = new Message();

                message.setMessageGroup(messageGroup);
                message.setMessageContent(messageContent);
                message.setSendTime(time);
                message.setSendUserId(sendUserId);
                message.setReceiveUserId(receiveUserId);
                messageDao.save(message);
                return BizResult.valueOfSuccessed();
            }

            @Override
            public void afterService(BizResult<Object> result) {
            }
        });
    }
}
