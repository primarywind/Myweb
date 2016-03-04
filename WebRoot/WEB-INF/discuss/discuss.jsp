<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.myweb.entity.User"%>
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
	href="http://wenda.golaravel.com/static/css/default/ico/favicon.ico?v=20140930"
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
	%>
	<div class="aw-top-menu-wrap">
		<div class="container">
			<!-- logo -->
			<div class="aw-logo hidden-xs">
				<a href="http://wenda.golaravel.com"></a>
			</div>
			<!-- end logo -->
			<!-- 搜索框 -->
			<div class="aw-search-box  hidden-xs hidden-sm">
				<form class="navbar-search"
					action="http://wenda.golaravel.com/search/" id="global_search_form"
					method="post">
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
								class="badge badge-important hide" id="inbox_unread">0</span> </a>
						</li>
						<li class="hidden-xs"><a
							href="/Myweb/admin/gotoProfile.action">设置</a>
						</li>
						<li><a href="/Myweb/admin/logonOut.action">退出</a>
						</li>
					</ul>
				</div>
				<!-- end 登陆&注册栏 -->
			</div>
			<!-- end 用户栏 -->
			<!-- 发起 -->
			<div class="aw-publish-btn">
				<a id="header_publish" href="/Myweb/admin/goToPublish.action"
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
						<!-- 新消息通知 -->
						<div class="aw-mod aw-notification-box hide"
							id="index_notification">
							<div class="mod-head common-head">
								<h2>
									<span class="pull-right"><a
										href="http://wenda.golaravel.com/setting/privacy/#notifications"
										class="text-color-999"><i class="icon icon-setting"></i>
											通知设置</a> </span> <i class="icon icon-bell"></i>新通知<em
										class="badge badge-important" name="notification_unread_num">0</em>
								</h2>
							</div>
							<div class="mod-body">
								<ul id="notification_list"></ul>
							</div>
							<div class="mod-footer clearfix">
								<a href="javascript:;"
									onclick="AWS.Message.read_notification(false, 0, false);"
									class="pull-left btn btn-mini btn-gray">我知道了</a> <a
									href="http://wenda.golaravel.com/notifications/"
									class="pull-right btn btn-mini btn-success">查看所有</a>
							</div>
						</div>
						<!-- end 新消息通知 -->
						<!-- tab切换 -->
						<ul class="nav nav-tabs aw-nav-tabs active hidden-xs">
							<li><a href="javascript:findSendCardsByPage(4)">等待回复</a></li>
							<li><a href="javascript:findSendCardsByPage(1)">热门</a></li>
							<li><a href="javascript:findSendCardsByPage(3)">推荐</a></li>
							<li><a href="javascript:findSendCardsByPage(2)">最新</a>
							</li>

							<h2 class="hidden-xs">
								<i class="icon icon-list"></i> 发现
							</h2>
						</ul>
						<!-- end tab切换 -->


						<div class="aw-mod aw-explore-list">
							<div class="mod-body">
								<div class="aw-common-list">
									<!-- <div class="aw-item active" data-topic-id="57,">
										<a class="aw-user-name hidden-xs" data-id="2483"
											rel="nofollow"><img
											src="http://wenda.golaravel.com/static/common/avatar-max-img.png"
											alt="" /> </a>
										<div class="aw-question-content">
											<h4>
												<a href="http://wenda.golaravel.com/question/1691">我想在中间件中调用一个控制器函数，代码该怎么写呢</a>
											</h4>
											<a
												href="http://wenda.golaravel.com/question/1691#!answer_form"
												class="pull-right text-color-999">回复</a>

											<p>
												<a href="http://wenda.golaravel.com/people/John%E8%8B%91"
													class="aw-user-name">John苑</a> <span class="text-color-999">发起了问题
													• 1 人关注 • 0 个回复 • 2 次浏览 • 34 分钟前 </span> <span
													class="text-color-999 related-topic hide"> • 来自相关话题</span>
											</p>

										</div>
									</div> -->
									<div id="aw-common-list"></div>
								</div>
							</div>
							<div class="mod-footer">
								<div class="page-control">
									<ul class="pagination pull-right" id="discussPaginationId">
										<li class="active"><a href="javascript:;">1</a>
										</li>
										<li><a
											href="http://wenda.golaravel.com/sort_type-new__day-0__is_recommend-0__page-2">2</a>
										</li>
										<li><a
											href="http://wenda.golaravel.com/sort_type-new__day-0__is_recommend-0__page-3">3</a>
										</li>
										<li><a
											href="http://wenda.golaravel.com/sort_type-new__day-0__is_recommend-0__page-4">4</a>
										</li>
										<li><a
											href="http://wenda.golaravel.com/sort_type-new__day-0__is_recommend-0__page-2">&gt;</a>
										</li>
										<li><a
											href="http://wenda.golaravel.com/sort_type-new__day-0__is_recommend-0__page-37">&gt;&gt;</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>

					<!-- 侧边栏 -->
					<div class="col-sm-12 col-md-3 aw-side-bar hidden-xs hidden-sm">
						<div class="aw-mod aw-text-align-justify">
							<div class="mod-head">
								<h3>热门用户</h3>
							</div>
							<div class="mod-body">

								<dl>
									<dt class="pull-left aw-border-radius-5">
										<a href="http://wenda.golaravel.com/people/sun"><img
											alt=""
											src="http://wenda.golaravel.com/static/common/avatar-mid-img.png" />
										</a>
									</dt>
									<dd class="pull-left">
										<a href="http://wenda.golaravel.com/people/sun" data-id="1822"
											class="aw-user-name">sun </a>
										<p class="signature"></p>
										<p>
											<b>3</b> 个问题, <b>0</b> 次赞同
										</p>
									</dd>
								</dl>

								<dl>
									<dt class="pull-left aw-border-radius-5">
										<a href="http://wenda.golaravel.com/people/agan"><img
											alt=""
											src="http://wenda.golaravel.com/static/common/avatar-mid-img.png" />
										</a>
									</dt>
									<dd class="pull-left">
										<a href="http://wenda.golaravel.com/people/agan"
											data-id="1642" class="aw-user-name">agan </a>
										<p class="signature"></p>
										<p>
											<b>3</b> 个问题, <b>0</b> 次赞同
										</p>
									</dd>
								</dl>

								<dl>
									<dt class="pull-left aw-border-radius-5">
										<a href="http://wenda.golaravel.com/people/digitalpro"><img
											alt=""
											src="http://wenda.golaravel.com/uploads/avatar/000/00/19/09_avatar_mid.jpg" />
										</a>
									</dt>
									<dd class="pull-left">
										<a href="http://wenda.golaravel.com/people/digitalpro"
											data-id="1909" class="aw-user-name">digitalpro </a>
										<p class="signature"></p>
										<p>
											<b>17</b> 个问题, <b>3</b> 次赞同
										</p>
									</dd>
								</dl>

								<dl>
									<dt class="pull-left aw-border-radius-5">
										<a href="http://wenda.golaravel.com/people/G8Ycn"><img
											alt=""
											src="http://wenda.golaravel.com/static/common/avatar-mid-img.png" />
										</a>
									</dt>
									<dd class="pull-left">
										<a href="http://wenda.golaravel.com/people/G8Ycn"
											data-id="740" class="aw-user-name">G8Ycn </a>
										<p class="signature"></p>
										<p>
											<b>29</b> 个问题, <b>2</b> 次赞同
										</p>
									</dd>
								</dl>

								<dl>
									<dt class="pull-left aw-border-radius-5">
										<a
											href="http://wenda.golaravel.com/people/%E7%88%AC%E8%A1%8C%E7%9A%84%E5%A4%A7%E7%88%B7"><img
											alt=""
											src="http://wenda.golaravel.com/uploads/avatar/000/00/17/28_avatar_mid.jpg" />
										</a>
									</dt>
									<dd class="pull-left">
										<a
											href="http://wenda.golaravel.com/people/%E7%88%AC%E8%A1%8C%E7%9A%84%E5%A4%A7%E7%88%B7"
											data-id="1728" class="aw-user-name">爬行的大爷 </a>
										<p class="signature"></p>
										<p>
											<b>4</b> 个问题, <b>2</b> 次赞同
										</p>
									</dd>
								</dl>
							</div>
						</div>
					</div>
					<!-- end 侧边栏 -->
				</div>
			</div>
		</div>
	</div>
	<!-- 
	<div class="aw-footer-wrap">
		<div class="aw-footer">
			Copyright © 2015, All Rights Reserved</span> <span class="hidden-xs">Powered
				By <a href="http://www.wecenter.com/?copyright" target="blank">WeCenter
					3.0 Beta 2</a> </span>

		</div>
	</div> -->

	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>


	<script type="text/template" id="sendCard">  
     <div class="aw-item active" data-topic-id="57,">
	 <a class="aw-user-name hidden-xs" data-id="2483"
		rel="nofollow"><img
		src="{faceImg}"
		alt=""> </a>
	 <div class="aw-question-content">
		<h4>
			<a href="/Myweb/admin/getDiscussDetail.action?sendCardId={cardId}">{title}</a>
		</h4>
		<a href="/Myweb/admin/getDiscussDetail.action?sendCardId={cardId}"
			class="pull-right text-color-999">回复</a>

		<p>
			<a href="#" class="aw-user-name">{userName}</a> <span class="text-color-999">发起了问题
				• {favoriteCount} 人关注 • {followCount} 个回复 • {viewCount} 次浏览 </span> <span
				class="text-color-999 related-topic hide"> • 来自相关话题</span>
		</p>

	 </div>
    </div>
	</script>

	<script src="/Myweb/assets/js/discuss.js"></script>
</body>
</html>