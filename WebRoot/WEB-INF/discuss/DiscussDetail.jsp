<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.myweb.entity.User"%>
<%@page import="com.myweb.view.SendCardDetailView"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
                      + request.getServerPort() + path + "/";
%>
<html lang="zh-CN">
<head>
<meta content="text/html;charset=utf-8" http-equiv="Content-Type" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="renderer" content="webkit" />
<title>讨论区</title>
<meta name="description" content="这个网站是一个用于我自己发表博客的 -- by Primarywind" />

<link
	href="http://wenda.golaravel.com/static/css/default/ico/favicon.ico"
	rel="shortcut icon" type="image/x-icon" />

<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/Myweb/assets/css/icon.css" />

<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/common.css" />

<link rel="stylesheet" type="text/css" href="/Myweb/assets/css/link.css" />

<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/style.css" />



</head>

<body>
	<%
	    HttpSession sessions = request.getSession();
	    User sessionValues = (User) sessions.getAttribute("USER");
	    SendCardDetailView sendCardDetailView = (SendCardDetailView) request
	        .getAttribute("sendCardDetailView");
	%>
	<div class="aw-top-menu-wrap">
		<div class="container">
			<!-- logo -->
			<div class="aw-logo hidden-xs">
				<a href="/Myweb/admin/goToDiscuss.action"></a>
			</div>
			<!-- end logo -->
			<!-- 搜索框 -->
			<div class="aw-search-box  hidden-xs hidden-sm">
				<form class="navbar-search" action="#/search/"
					id="global_search_form" method="post">
					<input class="form-control search-query" type="text"
						placeholder="搜索问题、话题或人" autocomplete="off" name="q"
						id="aw-search-query" />
					<div class="aw-dropdown">
						<div class="mod-body">
							<p class="title">输入关键字进行搜索</p>
							<ul class="aw-dropdown-list hide"></ul>
							<p class="search">
								<span>搜索:</span><a onClick="$('#global_search_form').submit();"></a>
							</p>
						</div>
						<div class="mod-footer">
							<a href="" onClick="$('#header_publish').click();"
								class="pull-right btn btn-mini btn-success publish">发起问题</a>
						</div>
					</div>
				</form>
			</div>
			<!-- end 搜索框 -->
			<!-- 导航 -->
			<div class="aw-top-nav navbar">
				<div class="navbar-header">
					<button class="navbar-toggle pull-left">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
			</div>
			<!-- end 导航 -->
			<!-- 用户栏 -->
			<div class="aw-user-nav">
				<!-- 登陆&注册栏 -->
				<a href="/Myweb/admin/goToPeople.action"> <img
					alt="<%=sessionValues.getName()%>"
					src="<%=sessionValues.getFaceImg()%>"> </a>
				<div class="aw-dropdown dropdown-list pull-right">
					<ul class="aw-dropdown-list">
						<li><a href="/Myweb/admin/gotoMessage.action">私信<span
								class="badge badge-important hide" id="inbox_unread">0</span> </a></li>
						<li class="hidden-xs"><a
							href="/Myweb/admin/gotoProfile.action">设置</a></li>
						<li><a href="/Myweb/admin/logonOut.action">退出</a></li>
					</ul>
				</div>
				<!-- end 登陆&注册栏 -->
			</div>
			<!-- end 用户栏 -->
			<!-- 发起 -->
			<div class="aw-publish-btn">
				<a id="header_publish" href="http://wenda.golaravel.com/publish/"
					class="btn-primary">发声</a>
			</div>
			<!-- end 发起 -->
		</div>
	</div>

	<div class="aw-container-wrap">
		<div class="container">
			<div class="row">
				<div class="aw-content-wrap clearfix">
					<div class="col-sm-12 col-md-9 aw-main-content">
						<!-- 话题bar -->
						<div class="aw-mod aw-topic-bar" id="question_topic_editor"
							data-type="question">
							<div class="tag-bar clearfix">
								<span class="topic-tag"> <a href="#" class="text"><%=sendCardDetailView.getLabel()%></a>
								</span>

							</div>
						</div>
						<!-- end 话题bar -->
						<div class="aw-mod aw-question-detail aw-item">
							<div class="mod-head">
								<h1><%=sendCardDetailView.getTitle()%></h1>
								<div class="operate clearfix">
									<a title=""
										data-original-title="<%=sendCardDetailView.getIfFavorite()%>"
										href="javascript:;"
										<%if (sendCardDetailView.getIfFavorite() == 0) {%>
										class="follow btn btn-normal btn-success pull-left"
										<%} else {%>
										class="follow btn btn-normal btn-success pull-left active"
										<%}%> id="favoriteButton"><span>关注</span> </a>
								</div>
							</div>
							<div class="mod-body">
								<div class="content markitup-box"><%=sendCardDetailView.getContent()%></div>
							</div>
							<div class="mod-footer">
								<div class="meta">
									<span class="text-color-999"><%=sendCardDetailView.getPubTime()%></span>
									<a id="addComment" data-type="question"
										class="aw-add-comment text-color-999 " data-comment-count="0"
										data-first-click="hide"><i class="icon icon-comment"></i>添加回复</a>
								</div>
								<!-- 隐藏回复区 -->
								<div style="display: none;" class="aw-comment-box"
									id="aw-comment-box-question">
									<div class="aw-comment-list">
										<div class="aw-padding10" align="center">回复此主题</div>
									</div>
									<form id="addCommentForm">
										<input type="hidden"
											value="<%=sendCardDetailView.getCardId()%>" name="sendCardId"
											id="sendCardId">
										<div class="aw-comment-box-main">
											<textarea
												style="overflow: hidden; word-wrap: break-word; resize: none; height: 34px;"
												class="aw-comment-txt form-control" rows="2" name="message"
												placeholder="评论一下..." id="textareaid"></textarea>
											<div style="display: none;" class="aw-comment-box-btn"
												id="aw-comment-box-btn">
												<span class="pull-right"><a
													href="javascript:submitCommentForm();"
													class="btn btn-mini btn-success">评论</a> </span>
											</div>
										</div>
									</form>
								</div>
								<!-- 隐藏回复区结束 -->
							</div>
							<!-- 站内邀请 -->
							<div class="aw-invite-box hide">
								<div class="mod-head clearfix">
									<div class="search-box pull-left">
										<input id="invite-input" class="form-control" type="text"
											placeholder="搜索你想邀请的人..." />
										<div class="aw-dropdown">
											<p class="title">没有找到相关结果</p>
											<ul class="aw-dropdown-list"></ul>
										</div>
										<i class="icon icon-search"></i>
									</div>
									<div class="invite-list pull-left hide">已邀请:</div>
								</div>
							</div>
							<!-- end 站内邀请 -->
							<!-- 相关链接 -->
							<div class="aw-question-related-box hide">
								<form
									action="http://wenda.golaravel.com/publish/ajax/save_related_link/"
									method="post" onsubmit="return false;" id="related_link_form">
									<div class="mod-head">
										<h2>与内容相关的链接</h2>
									</div>
									<div class="mod-body clearfix">
										<input type="hidden" name="item_id" value="1948" /> <input
											type="text" class="form-control pull-left" name="link"
											value="http://" /> <a
											onclick="AWS.ajax_post($('#related_link_form'));"
											class="pull-left btn btn-success">提交</a>
									</div>
								</form>
							</div>
							<!-- end 相关链接 -->
						</div>

						<div class="aw-mod aw-question-comment">
							<div class="mod-head">
								<ul class="nav nav-tabs aw-nav-tabs active">

									<h2 class="hidden-xs"><%=sendCardDetailView.getFollowCardListViews().size()%>个回复
									</h2>
								</ul>
							</div>

							<!--  显示回复区 -->
							<div class="mod-body aw-feed-list">
								<%
								    for (int i = 0; i < sendCardDetailView.getFollowCardListViews().size(); i++) {
								%>

								<div class="aw-item" uninterested_count="0" force_fold="0"
									id="answer_list_2851">
									<div class="mod-head">
										<a class="anchor" name="answer_2851"></a>
										<!-- 用户头像 -->
										<a class="aw-user-img aw-border-radius-5 pull-right" href="#"><img
											src="<%=sendCardDetailView.getFollowCardListViews().get(i).getFaceImg()%>"
											alt=""> </a>
										<!-- end 用户头像 -->
										<div class="title">
											<p>
												<a class="aw-user-name"
													href="http://wenda.golaravel.com/people/xiaoluyouyue"><%=sendCardDetailView.getFollowCardListViews().get(i).getUserName()%></a>
											</p>

										</div>
									</div>
									<div class="mod-body clearfix">
										<!-- 评论内容 -->
										<div class="markitup-box"><%=sendCardDetailView.getFollowCardListViews().get(i).getFollowContent()%>
										</div>
										<!-- end 评论内容 -->
									</div>
									<div class="mod-footer">
										<!-- 社交操作 -->
										<div class="meta clearfix">
											<span class="text-color-999 pull-right"><%=sendCardDetailView.getFollowCardListViews().get(i).getPubTime()%></span>
											<span class="operate"> <a class="aw-add-comment"
												href="javascript:showComments('aw-comment-box-answer-<%=sendCardDetailView.getFollowCardListViews().get(i).getFollowId()%>')"><i
													class="icon icon-comment"></i><%=sendCardDetailView.getFollowCardListViews().get(i)
                    .getFollowCardListView().size()%></a> </span>
										</div>
										<!-- end 社交操作 -->
										<div class="aw-comment-box" style="display: none;"
											id="aw-comment-box-answer-<%=sendCardDetailView.getFollowCardListViews().get(i).getFollowId()%>">
											<%
											    if (sendCardDetailView.getFollowCardListViews().get(i).getFollowCardListView()
											            .size() != 0) {
											            for (int j = 0; j < sendCardDetailView.getFollowCardListViews().get(i)
											                .getFollowCardListView().size(); j++) {
											%>


											<div class="aw-comment-list">
												<ul>
													<li><a class="aw-user-name" href="#"><img
															src="<%=sendCardDetailView.getFollowCardListViews().get(i)
                            .getFollowCardListView().get(j).getFaceImg()%>"
															alt=""> </a>
														<div>
															<p class="clearfix">
																<!-- <span class="pull-right"> <a href="javascript:;"
																	onclick="AWS.User.remove_comment($(this).parent(), 'answer', 1514);">删除</a>
																	&nbsp; <a href="javascript:;"
																	onclick="$(this).parents('.aw-comment-box').find('form textarea').insertAtCaret('@nullpoint:');$(this).parents('.aw-comment-box').find('form').show().find('textarea').focus();$.scrollTo($(this).parents('.aw-comment-box').find('form'), 300, {queue:true});">回复</a>
																</span> -->
																<a href="http://wenda.golaravel.com/people/nullpoint"
																	class="aw-user-name author" data-id="2514"><%=sendCardDetailView.getFollowCardListViews().get(i)
                            .getFollowCardListView().get(j).getUserName()%></a>
																• <span><%=sendCardDetailView.getFollowCardListViews().get(i)
                            .getFollowCardListView().get(j).getPubTime()%></span>
															</p>
															<p class="clearfix"><%=sendCardDetailView.getFollowCardListViews().get(i)
                            .getFollowCardListView().get(j).getFollowContent()%></p>
														</div>
													</li>
												</ul>
											</div>


											<%
											    }
											%>
											<form id="commentToOthersForm"
												style="padding:15px;background-color:#FAFAFA;">
												<input type="hidden"
													value="<%=sendCardDetailView.getFollowCardListViews().get(i).getFollowId()%>"
													name="followCardId">
												<div class="aw-comment-box-main">
													<textarea
														style="overflow: hidden; word-wrap: break-word; resize: none; height: 34px;"
														class="aw-comment-txt form-control" rows="2"
														name="message" placeholder="评论一下..."></textarea>
													<div style="display: block;" class="aw-comment-box-btn">
														<span class="pull-right"><a
															href="javascript:submitCommentToOth();"
															class="btn btn-mini btn-success">评论</a> </span>
													</div>
												</div>
											</form>

											<%
											    } else {
											%>
											<form id="commentToOthersForm"
												style="padding:15px;background-color:#FAFAFA;">
												<input type="hidden"
													value="<%=sendCardDetailView.getFollowCardListViews().get(i).getFollowId()%>"
													name="followCardId">
												<div class="aw-comment-box-main">
													<textarea
														style="overflow: hidden; word-wrap: break-word; resize: none; height: 34px;"
														class="aw-comment-txt form-control" rows="2"
														name="message" placeholder="评论一下..."></textarea>
													<div style="display: block;" class="aw-comment-box-btn">
														<span class="pull-right"><a
															href="javascript:submitCommentToOth();"
															class="btn btn-mini btn-success">评论</a> </span>
													</div>
												</div>
											</form>
											<%
											    }
											%>
										</div>
									</div>
								</div>

								<%
								    }
								%>

							</div>
							<!--  显示回复区 -->
						</div>
						<!-- end 问题详细模块 -->

						<!-- 回复编辑器 -->
						<div class="aw-mod aw-replay-box question">
							<!-- <a name="answer_form"></a>
							<p align="center">
								要回复问题请先<a href="http://wenda.golaravel.com/login/">登录</a>或<a
									href="http://wenda.golaravel.com/account/register/">注册</a>
							</p> -->
						</div>
						<!-- end 回复编辑器 -->
					</div>
					<!-- 侧边栏 -->
					<div class="col-md-3 aw-side-bar hidden-xs hidden-sm">
						<!-- 发起人 -->
						<div class="aw-mod">
							<div class="mod-head">
								<h3>发起人</h3>
							</div>
							<div class="mod-body">
								<dl>
									<dt class="pull-left aw-border-radius-5">
										<a href="#"><img alt="laravelwy"
											src="<%=sendCardDetailView.getFaceImg()%>" /> </a>
									</dt>
									<dd class="pull-left">
										<a class="aw-user-name" href="#"><%=sendCardDetailView.getUserName()%></a>
										<p></p>
									</dd>
								</dl>
							</div>
						</div>
						<!-- end 发起人 -->



						<!-- 热门问题 -->
						<div class="aw-mod">
							<div class="mod-head">
								<h3>热门问题</h3>
							</div>
							<div class="mod-body font-size-12">
								<ul>
									<%
									    for (int i = 0; i < sendCardDetailView.getSendCardView().size(); i++) {
									%>
									<li><a
										href="/Myweb/admin/getDiscussDetail.action?sendCardId=<%=sendCardDetailView.getSendCardView().get(i).getCardId()%>"><%=sendCardDetailView.getSendCardView().get(i).getTitle()%></a>
									</li>
									<%
									    }
									%>

								</ul>
							</div>
						</div>
						<!-- end 相关问题 -->

						<!-- 问题状态 -->
						<div class="aw-mod question-status">
							<div class="mod-head">
								<h3>问题状态</h3>
							</div>
							<div class="mod-body" style="font-size:12px">
								<ul>
									<%
									    if (sendCardDetailView.getFollowCardListViews().size() != 0) {
									%>
									<li>最新活动: <span class="aw-text-color-blue"><%=sendCardDetailView.getFollowCardListViews().get(0).getPubTime()%></span>
									</li>
									<%
									    }
									%>
									<li>浏览: <span class="aw-text-color-blue"><%=sendCardDetailView.getViewCount()%></span>
									</li>
									<li>关注: <span class="aw-text-color-blue"><%=sendCardDetailView.getFavoriteCount()%></span>
										人</li>

									<li class="aw-border-radius-5" id="focus_users"></li>
								</ul>
							</div>
						</div>
						<!-- end 问题状态 -->
					</div>
					<!-- end 侧边栏 -->
				</div>
			</div>
		</div>
	</div>

	<div class="aw-footer-wrap">
		<div class="aw-footer">
			Copyright © 2015, All Rights Reserved</span> <span class="hidden-xs">Powered
				By <a href="http://www.wecenter.com/?copyright" target="blank">WeCenter
					3.0 Beta 2</a> </span>

		</div>
	</div>

	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<script src="/Myweb/assets/js/discussdetail.js"></script>
</body>
</html>