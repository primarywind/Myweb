package com.myweb.service.mapper;

import java.util.List;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * 
 * @author huleiwind
 * @version $Id: BaseOrikaMapperImpl.java, v 0.1 2015-10-9 上午12:05:30 huleiwind Exp $
 */
public abstract class BaseOrikaMapperImpl implements ObjectMapper {
    /** mapperFacade */
    private MapperFacade mapperFacade;

    /**
     * 初始化
     */
    public void init() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        registerMapClass(mapperFactory);

        mapperFacade = mapperFactory.getMapperFacade();
    }

    /**
     * 注册需要映射的类
     * 
     * @param mapperFactory
     */
    protected abstract void registerMapClass(MapperFactory mapperFactory);

    public <A, B> B map(A source, Class<B> clazz) {
        if (source == null) {
            return null;
        }

        return mapperFacade.map(source, clazz);
    }

    public <A, B> void map(A source, B destination) {
        if (source == null || destination == null) {
            return;
        }
        mapperFacade.map(source, destination);
    }

    public <A, B> List<B> map(List<A> sourceList, Class<B> clazz) {
        if (sourceList == null) {
            return null;
        }

        return mapperFacade.mapAsList(sourceList, clazz);
    }
}
