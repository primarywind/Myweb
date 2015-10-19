package com.myweb.service.mapper;

import ma.glasnost.orika.MapperFactory;

import com.myweb.entity.Article;
import com.myweb.entity.Category;
import com.myweb.entity.Followcard;
import com.myweb.entity.Picture;
import com.myweb.entity.Sendcard;
import com.myweb.view.ArticleListView;
import com.myweb.view.ArticleView;
import com.myweb.view.CategoryView;
import com.myweb.view.FollowCardListView;
import com.myweb.view.PictureListView;
import com.myweb.view.SendCardDetailView;
import com.myweb.view.SendCardListView;

/**
 * 
 * @author huleiwind
 * @version $Id: ViewObjectMapperImpl.java, v 0.1 2015-10-9 上午12:13:42 huleiwind Exp $
 */
public class ViewObjectMapperImpl extends BaseOrikaMapperImpl {

    @Override
    protected void registerMapClass(MapperFactory mapperFactory) {

        // 文章列表视图
        mapperFactory.classMap(Article.class, ArticleListView.class).byDefault()
            .field("articleId", "articleId").field("briefIndc", "briefIndc")
            .field("title", "title").field("pubTime", "pubTime").field("label", "label")
            .field("userId", "userId").register();

        // 文章详细内容视图
        mapperFactory.classMap(Article.class, ArticleView.class).byDefault()
            .field("articleId", "articleId").field("userId", "userId").field("title", "title")
            .field("pubTime", "pubTime").field("content", "content").field("label", "label")
            .field("categoryId", "categoryId").register();

        // 栏目列表视图
        mapperFactory.classMap(Category.class, CategoryView.class).byDefault()
            .field("categoryId", "categoryId").field("name", "name").field("CHref", "chref")
            .register();

        // 图片列表视图
        mapperFactory.classMap(Picture.class, PictureListView.class).byDefault()
            .field("picId", "picId").field("picName", "picName").field("picPath", "picPath")
            .field("picType", "picType").field("picOwnerId", "picOwnerId").register();

        // 帖子列表视图
        mapperFactory.classMap(Sendcard.class, SendCardListView.class).byDefault()
            .field("cardId", "cardId").field("userId", "userId").field("title", "title")
            .field("pubTime", "pubTime").field("viewCount", "viewCount")
            .field("followCount", "followCount").field("favoriteCount", "favoriteCount").register();

        // 帖子详细内容视图
        mapperFactory.classMap(Sendcard.class, SendCardDetailView.class).byDefault()
            .field("cardId", "cardId").field("userId", "userId").field("title", "title")
            .field("pubTime", "pubTime").register();

        // 帖子回复列表视图
        mapperFactory.classMap(Followcard.class, FollowCardListView.class).byDefault()
            .field("followId", "followId").field("userId", "userId")
            .field("cardOrFollowId", "cardOrFollowId").field("followContent", "followContent")
            .field("pubTime", "pubTime").field("followType", "followType").register();
    }
}
