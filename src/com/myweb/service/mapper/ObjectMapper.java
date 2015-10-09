package com.myweb.service.mapper;

import java.util.List;

/**
 * 
 * @author huleiwind
 * @version $Id: ObjectMapper.java, v 0.1 2015-10-9 上午12:04:32 huleiwind Exp $
 */
public interface ObjectMapper {
    /**
     * 映射
     * 
     * @param source
     * @param clazz
     * @return
     */
    <A, B> B map(A source, Class<B> clazz);

    /**
     * 映射
     * 
     * @param source
     * @param destination
     * @return
     */
    <A, B> void map(A source, B destination);

    /**
     * 映射
     * 
     * @param sourceList
     * @param clazz
     */
    <A, B> List<B> map(List<A> sourceList, Class<B> clazz);
}
