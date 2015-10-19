package com.myweb.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myweb.service.ISendCardService;
import com.myweb.util.SendCardViewCountUtil;

/**
 * 
 * @author huleiwind
 * @version $Id: ArticleServiceTest.java, v 0.1 2015-10-8 上午11:03:48 huleiwind Exp $
 */
public class SendCardViewCountUtilTest extends SpringTestBase {
    @Autowired
    private ISendCardService sendCardService;

    @Test
    public void testConfig() {
        for (int i = 0; i < 4; i++) {
            SendCardViewCountUtil sendCardViewCountUtil = new SendCardViewCountUtil(1,
                sendCardService);
            Thread thread1 = new Thread(sendCardViewCountUtil);
            thread1.start();
        }

        //for (int i = 0; i < 30; i++) {

        //            SendCardViewCountUtil sendCardViewCountUti2 = new SendCardViewCountUtil(1,
        //                sendCardService);
        //            Thread thread2 = new Thread(sendCardViewCountUti2);
        //            thread2.start();
        //
        //            SendCardViewCountUtil sendCardViewCountUtil3 = new SendCardViewCountUtil(1,
        //                sendCardService);
        //            Thread thread3 = new Thread(sendCardViewCountUtil3);
        //            thread3.start();
        //        }

    }

    public ISendCardService getSendCardService() {
        return sendCardService;
    }

    public void setSendCardService(ISendCardService sendCardService) {
        this.sendCardService = sendCardService;
    }

}
