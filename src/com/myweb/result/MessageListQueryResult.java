package com.myweb.result;

import java.util.List;

import com.myweb.view.MessageView;

/**
 * 
 * @author huleiwind
 * @version $Id: MessageListQueryResult.java, v 0.1 2016-2-24 上午1:00:01 huleiwind Exp $
 */
public class MessageListQueryResult extends QueryResult {

    /** serialVersionUID */
    private static final long serialVersionUID = 5943821419043636454L;
    private List<MessageView> messageViewList;

    public List<MessageView> getMessageViewList() {
        return messageViewList;
    }

    public void setMessageViewList(List<MessageView> messageViewList) {
        this.messageViewList = messageViewList;
    }

}
