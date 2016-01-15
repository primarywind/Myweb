package com.myweb.service;

import com.myweb.entity.Sendcard;
import com.myweb.result.CardDetailQueryResult;
import com.myweb.result.SendCardListQueryResult;

/**
 * 
 * @author huleiwind
 * @version $Id: ISendCardService.java, v 0.1 2015-10-18 下午4:29:52 huleiwind Exp $
 */
public interface ISendCardService {

    /**
     * 分页查看话题贴
     * 
     * @param pageNo
     * @param pageSize
     * @param orderType 
     * @return
     */
    public SendCardListQueryResult findSendCardsByPage(int pageNo, int pageSize, int orderType);

    /**
     * 根据id查看话题贴
     * 
     * @param sendCardId
     * @return
     */
    public Sendcard findSendCardById(int sendCardId);

    /**
     * 保存或更新话题贴
     * 
     * @param sendcard
     * @return
     */
    public Integer saveOrUpdateSendCard(Sendcard sendcard);

    /**
     * 根据id查看话题详细信息
     * 
     * @param sendCardId
     * @return
     */
    public CardDetailQueryResult getSendCardDetail(int sendCardId);
}
