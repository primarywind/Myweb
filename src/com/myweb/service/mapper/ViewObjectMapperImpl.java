package com.myweb.service.mapper;

import ma.glasnost.orika.MapperFactory;

import com.myweb.entity.Article;
import com.myweb.view.ArticleListView;

/**
 * 
 * @author huleiwind
 * @version $Id: ViewObjectMapperImpl.java, v 0.1 2015-10-9 上午12:13:42 huleiwind Exp $
 */
public class ViewObjectMapperImpl extends BaseOrikaMapperImpl {

    @Override
    protected void registerMapClass(MapperFactory mapperFactory) {
        // 文章视图
        mapperFactory.classMap(Article.class, ArticleListView.class).byDefault()
            .field("articleId", "articleId").field("userId", "userId")
            .field("briefIndc", "briefIndc").field("pubTime", "pubTime").field("label", "label")
            .field("userId", "userId").register();
    }
}
