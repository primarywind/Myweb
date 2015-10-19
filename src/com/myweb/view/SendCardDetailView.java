package com.myweb.view;

import java.sql.Timestamp;
import java.util.List;

/**
 * 
 * @author huleiwind
 * @version $Id: SendCardDetailView.java, v 0.1 2015-10-19 下午3:47:01 huleiwind Exp $
 */
public class SendCardDetailView {
    // Fields    

    private Integer                  cardId;
    private Integer                  userId;
    private String                   title;
    private String                   content;
    private Timestamp                pubTime;

    private List<FollowCardListView> FollowCardListViews;

    //userDo
    private String                   userName;
    private String                   faceImg;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPubTime() {
        return pubTime;
    }

    public void setPubTime(Timestamp pubTime) {
        this.pubTime = pubTime;
    }

    public List<FollowCardListView> getFollowCardListViews() {
        return FollowCardListViews;
    }

    public void setFollowCardListViews(List<FollowCardListView> followCardListViews) {
        FollowCardListViews = followCardListViews;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

}
