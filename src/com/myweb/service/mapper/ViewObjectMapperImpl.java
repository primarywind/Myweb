package com.myweb.service.mapper;

import com.myweb.view.*;
import ma.glasnost.orika.MapperFactory;

import com.myweb.entity.Article;
import com.myweb.entity.Category;
import com.myweb.entity.Favorite;
import com.myweb.entity.Followcard;
import com.myweb.entity.Message;
import com.myweb.entity.Picture;
import com.myweb.entity.Sendcard;
import com.myweb.entity.User;

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
            .field("addTime", "addTime").field("ifview", "ifview").field("CIndex", "CIndex")
            .register();

        // 图片列表视图
        mapperFactory.classMap(Picture.class, PictureListView.class).byDefault()
            .field("picId", "picId").field("picName", "picName").field("picPath", "picPath")
            .field("picType", "picType").field("picOwnerId", "picOwnerId")
            .field("picSize", "picSize").field("pubTime", "pubTime").register();

        // 帖子列表视图
        mapperFactory.classMap(Sendcard.class, SendCardListView.class).byDefault()
            .field("cardId", "cardId").field("userId", "userId").field("title", "title")
            .field("pubTime", "pubTime").field("viewCount", "viewCount")
            .field("followCount", "followCount").field("favoriteCount", "favoriteCount").register();

        // 帖子详细内容视图
        mapperFactory.classMap(Sendcard.class, SendCardDetailView.class).byDefault()
            .field("cardId", "cardId").field("userId", "userId").field("title", "title")
            .field("pubTime", "pubTime").field("label", "label").field("viewCount", "viewCount")
            .field("followCount", "followCount").field("favoriteCount", "favoriteCount").register();

        // 帖子回复列表视图
        mapperFactory.classMap(Followcard.class, FollowCardListView.class).byDefault()
            .field("followId", "followId").field("userId", "userId")
            .field("cardOrFollowId", "cardOrFollowId").field("followContent", "followContent")
            .field("pubTime", "pubTime").field("followType", "followType").register();

        //热门话题列表视图
        mapperFactory.classMap(Sendcard.class, SendCardView.class).byDefault()
            .field("cardId", "cardId").field("title", "title").register();

        //用户信息视图
        mapperFactory.classMap(User.class, UserView.class).byDefault().field("userId", "userId")
            .field("userName", "userName").field("blogUrl", "blogUrl").field("gender", "gender")
            .field("nationality", "nationality").field("regTime", "regTime")
            .field("level", "level").field("name", "name").field("faceImg", "faceImg").register();
        //关注列表视图
        mapperFactory.classMap(Favorite.class, FavoriteListView.class).byDefault()
            .field("favoriteId", "favoriteId").field("userId", "userId").field("cardId", "cardId")
            .field("addTime", "addTime").register();

        //消息列表视图
        mapperFactory.classMap(Message.class, MessageView.class).byDefault()
            .field("messageId", "messageId").field("sendUserId", "sendUserId")
            .field("receiveUserId", "receiveUserId").field("sendTime", "sendTime")
            .field("messageGroup", "messageGroup").field("messageContent", "messageContent")
            .register();
        //热门用户视图
        mapperFactory.classMap(User.class, HotUserView.class).byDefault().field("userId", "userId")
            .field("userName", "userName").field("blogUrl", "blogUrl").field("gender", "gender")
            .field("nationality", "nationality").field("level", "level").field("name", "name")
            .field("faceImg", "faceImg").register();
    }
}
