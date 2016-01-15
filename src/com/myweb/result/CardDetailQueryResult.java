package com.myweb.result;

import com.myweb.view.SendCardDetailView;

/**
 * 
 * @author huleiwind
 * @version $Id: CardDetailQueryResult.java, v 0.1 2016-1-14 下午8:23:45 huleiwind Exp $
 */
public class CardDetailQueryResult extends QueryResult {

    /** serialVersionUID */
    private static final long  serialVersionUID = 1034602478364341847L;
    private SendCardDetailView sendCardDetailView;

    public SendCardDetailView getSendCardDetailView() {
        return sendCardDetailView;
    }

    public void setSendCardDetailView(SendCardDetailView sendCardDetailView) {
        this.sendCardDetailView = sendCardDetailView;
    }

}
