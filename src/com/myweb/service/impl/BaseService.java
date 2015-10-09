package com.myweb.service.impl;

import com.myweb.service.mapper.ObjectMapper;

/**
 * 
 * @author huleiwind
 * @version $Id: BaseService.java, v 0.1 2015-10-9 上午10:33:10 huleiwind Exp $
 */
public class BaseService {
    /** 视图转换器 */
    private ObjectMapper viewObjectMapper;

    public ObjectMapper getViewObjectMapper() {
        return viewObjectMapper;
    }

    public void setViewObjectMapper(ObjectMapper viewObjectMapper) {
        this.viewObjectMapper = viewObjectMapper;
    }

}
