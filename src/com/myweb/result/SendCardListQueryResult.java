package com.myweb.result;

import java.util.List;

import com.myweb.view.SendCardListView;

/**
 * 
 * @author huleiwind
 * @version $Id: SendCardListQueryView.java, v 0.1 2016-1-13 下午5:44:07 huleiwind Exp $
 */
public class SendCardListQueryResult extends QueryResult {

    /** serialVersionUID */
    private static final long serialVersionUID = -7908313491124272615L;
    List<SendCardListView>    sendCardListView;
    int totalSize;

    public List<SendCardListView> getSendCardListView() {
        return sendCardListView;
    }

    public void setSendCardListView(List<SendCardListView> sendCardListView) {
        this.sendCardListView = sendCardListView;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
}
