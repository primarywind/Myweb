package com.myweb.view;

import java.sql.Timestamp;

/**
 * 
 * @author huleiwind
 * @version $Id: PictureListView.java, v 0.1 2015-10-14 下午4:09:40 huleiwind Exp $
 */
public class PictureListView {
    private Integer   picId;
    private String    picName;
    private String    picType;
    private String    picSize;
    private String    picPath;
    private Integer   picOwnerId;
    private Timestamp pubTime;
    //Userdo
    private String    userName;

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Integer getPicOwnerId() {
        return picOwnerId;
    }

    public void setPicOwnerId(Integer picOwnerId) {
        this.picOwnerId = picOwnerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPicSize() {
        return picSize;
    }

    public void setPicSize(String picSize) {
        this.picSize = picSize;
    }

    public Timestamp getPubTime() {
        return pubTime;
    }

    public void setPubTime(Timestamp pubTime) {
        this.pubTime = pubTime;
    }

}
