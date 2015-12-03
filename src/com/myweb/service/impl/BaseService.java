package com.myweb.service.impl;

import com.myweb.service.mapper.ObjectMapper;
import com.myweb.template.ServiceTemplate;
import com.myweb.template.ViewQueryTemplate;

/**
 * 
 * @author huleiwind
 * @version $Id: BaseService.java, v 0.1 2015-10-9 上午10:33:10 huleiwind Exp $
 */
public class BaseService {
    /** 视图转换器 */
    private ObjectMapper      viewObjectMapper;

    /** 视图查询模版 */
    private ViewQueryTemplate viewQueryTemplate;

    /** 业务操作模版 */
    private ServiceTemplate   serviceTemplate;

    public ViewQueryTemplate getViewQueryTemplate() {
        return viewQueryTemplate;
    }

    public void setViewQueryTemplate(ViewQueryTemplate viewQueryTemplate) {
        this.viewQueryTemplate = viewQueryTemplate;
    }

    public ObjectMapper getViewObjectMapper() {
        return viewObjectMapper;
    }

    public void setViewObjectMapper(ObjectMapper viewObjectMapper) {
        this.viewObjectMapper = viewObjectMapper;
    }

    public ServiceTemplate getServiceTemplate() {
        return serviceTemplate;
    }

    public void setServiceTemplate(ServiceTemplate serviceTemplate) {
        this.serviceTemplate = serviceTemplate;
    }

}
