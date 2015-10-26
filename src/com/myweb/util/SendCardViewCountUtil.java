package com.myweb.util;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.myweb.entity.Sendcard;
import com.myweb.service.ISendCardService;

/**
 * 
 * @author huleiwind
 * @version $Id: SendCardViewCountUtil.java, v 0.1 2015-10-18 下午8:42:20 huleiwind Exp $
 */
public class SendCardViewCountUtil implements Runnable {
    private int                             sendCardId        = 0;

    @Autowired
    private ISendCardService                sendCardService;
    public static HashMap<Integer, Integer> sendCardViewCount = new HashMap<Integer, Integer>();

    public SendCardViewCountUtil() {
    }

    public SendCardViewCountUtil(int sendCardId, ISendCardService sendCardService) {
        this.sendCardId = sendCardId;
        this.sendCardService = sendCardService;
    }

    public void run() {
        System.out.println("进入run方法" + Thread.currentThread().getName() + " " + sendCardService);
        addCount();
    }

    //添加话题浏览数
    public void addCount() {
        synchronized (sendCardViewCount) {

            if (sendCardViewCount.get(sendCardId) == null) {
                sendCardViewCount.put(sendCardId, 1);

            } else {
                System.out.println("viewCount:" + sendCardViewCount.get(sendCardId)
                                   + "  sendCardId:" + sendCardId + " "
                                   + Thread.currentThread().getName());
                int viewCount = sendCardViewCount.get(sendCardId);
                if (viewCount >= 3) {
                    System.out.println("进入更新模块");
                    //操作数据库
                    Sendcard sendcard = sendCardService.findSendCardById(sendCardId);
                    System.out.println("viewCount:" + sendCardViewCount.get(sendCardId)
                                       + "  sendCardId:" + sendCardId + " "
                                       + sendcard.getViewCount() + " "
                                       + Thread.currentThread().getName());
                    sendcard.setViewCount(sendcard.getViewCount() + viewCount);
                    sendCardService.saveOrUpdateSendCard(sendcard);
                    //重置次数
                    sendCardViewCount.put(sendCardId, 1);
                } else {
                    sendCardViewCount.put(sendCardId, sendCardViewCount.get(sendCardId) + 1);
                }
            }
        }
    }
}
