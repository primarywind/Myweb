package com.myweb.entity;

import java.sql.Timestamp;

/**
 * Picture entity. @author MyEclipse Persistence Tools
 */

public class Picture implements java.io.Serializable {

    // Fields    

    private Integer   picId;
    private String    picName;
    private String    picSize;
    private String    picType;
    private String    picPath;
    private Timestamp pubTime;
    private Integer   picOwnerId;

    // Constructors

    /** default constructor */
    public Picture() {
    }

    /** full constructor */
    public Picture(Integer picId, String picName, String picSize, String picType, String picPath,
                   Timestamp pubTime, Integer picOwnerId) {
        this.picId = picId;
        this.picName = picName;
        this.picSize = picSize;
        this.picType = picType;
        this.picPath = picPath;
        this.pubTime = pubTime;
        this.picOwnerId = picOwnerId;
    }

    // Property accessors

    public Integer getPicId() {
        return this.picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getPicName() {
        return this.picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicSize() {
        return this.picSize;
    }

    public void setPicSize(String picSize) {
        this.picSize = picSize;
    }

    public String getPicType() {
        return this.picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }

    public String getPicPath() {
        return this.picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Timestamp getPubTime() {
        return this.pubTime;
    }

    public void setPubTime(Timestamp pubTime) {
        this.pubTime = pubTime;
    }

    public Integer getPicOwnerId() {
        return this.picOwnerId;
    }

    public void setPicOwnerId(Integer picOwnerId) {
        this.picOwnerId = picOwnerId;
    }

}