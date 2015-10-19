package com.myweb.service;

import java.util.List;

import com.myweb.entity.Sendcard;
import com.myweb.view.SendCardDetailView;
import com.myweb.view.SendCardListView;

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
     * @return
     */
    public List<SendCardListView> findSendCardsByPage(int pageNo, int pageSize);

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
    public SendCardDetailView getSendCardDetail(int sendCardId);
}
