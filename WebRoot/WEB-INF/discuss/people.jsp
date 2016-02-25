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
<link rel="stylesheet" type="text/css" href="/Myweb/assets/css/user.css">
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
								class="badge badge-important hide" id="inbox_unread">0</span> </a></li>
						<li class="hidden-xs"><a
							href="/Myweb/admin/gotoProfile.action">设置</a></li>
						<li><a href="/Myweb/admin/logonOut.action">退出</a></li>
					</ul>
				</div>
				<!-- end 登陆&注册栏 -->
			</div>
			<!-- end 用户栏 -->

		</div>
	</div>

	<div class="aw-container-wrap">
		<div class="container">
			<div class="row">
				<div class="aw-content-wrap clearfix">
					<div class="col-sm-12 col-md-9 aw-main-content">
						<!-- 用户数据内容 -->
						<div class="aw-mod aw-user-detail-box">
							<div class="mod-head">
								<img id="faceimgId"
									src="http://wenda.golaravel.com/uploads/avatar/000/00/25/14_avatar_max.jpg"
									alt="nullpoint" width="100" height="100"> <span class="pull-right operate">
									<a href="http://wenda.golaravel.com/setting/profile/"
									class="btn btn-mini btn-success">编辑</a> </span>
								<h1 id="nameId">nullpoint</h1>
								<p class="text-color-999"></p>
								<p class="aw-user-flag"></p>
							</div>
							<div class="mod-footer" id="gotoTab">
								<ul class="nav nav-tabs aw-nav-tabs">
									<li class="active"><a href="#sendCard" data-toggle="tab">发问</a>
									</li>
									<li><a href="#followCard" data-toggle="tab">回复 </a></li>
									<li><a href="#favorite" data-toggle="tab">关注</a></li>
<!-- 									<li><a href="#active" data-toggle="tab">动态</a></li> -->
								</ul>
							</div>
						</div>
						<!-- end 用户数据内容 -->

						<div class="aw-user-center-tab">
							<div class="tab-content" id="focus">
								<div class="tab-pane active" id="sendCard">
									<!-- 发问列表 -->
									<div class="aw-mod">
										<div class="mod-body">
											<div class="aw-profile-answer-list">
												<div class="aw-item">
													<div class="mod-head">
														<h4 style="margin-top: 10px;" id="sendCardListId">
															<a href="http://wenda.golaravel.com/question/1973">发问列表</a>
														</h4>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- end 发问列表 -->
								</div>
								<div class="tab-pane " id="followCard">
									<!-- 回复列表 -->
									<div class="aw-mod">
										<div class="mod-body">
											<div class="aw-profile-answer-list">
												<div class="aw-item">
													<div class="mod-head">
														<h4 style="margin-top: 10px;" id="followCardListId">
															<a href="http://wenda.golaravel.com/question/1973">回复列表</a>
														</h4>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- end 回复列表 -->
								</div>
								<div class="tab-pane" id="favorite">
									<!-- 关注列表 -->
									<div class="aw-mod">
										<div class="mod-body">
											<div class="aw-profile-answer-list">
												<div class="aw-item">
													<div class="mod-head">
														<h4 style="margin-top: 10px;" id="favoriteListId">
															<a href="http://wenda.golaravel.com/question/1973">关注列表</a>
														</h4>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- end 关注列表 -->
								</div>
								<!-- <div class="tab-pane" id="active">
									活动列表
									<div class="aw-mod">
										<div class="mod-body">
											<div class="aw-profile-answer-list">
												<div class="aw-item">
													<div class="mod-head">
														<h4 style="margin-top: 10px;">
															<a href="http://wenda.golaravel.com/question/1973">活动列表</a>
														</h4>
													</div>
												</div>
											</div>
										</div>
									</div>
									end 活动列表
								</div> -->
							</div>
						</div>
					</div>

					<!-- 侧边栏 -->
					<div class="col-sm-12 col-md-3 aw-side-bar">


						<div class="aw-mod people-following">
							<!-- <div class="mod-body">
								<a
									onclick="$('#page_focus').click();$('#focus .aw-tabs ul li').eq(1).click();$.scrollTo($('#focus').offset()['top'], 600, {queue:true})"
									class="pull-right font-size-12">更多 »</a> 关注 <em
									class="aw-text-color-blue">1</em> 话题
								<div class="aw-topic-bar">
									<div class="tag-bar clearfix">
										<span class="topic-tag"> <a
											href="http://wenda.golaravel.com/topic/123123" class="text"
											data-id="1064">123123</a> </span>
									</div>
								</div>
							</div> -->
						</div>
						<div class="aw-mod">
							<div class="mod-body">
								<span class="aw-text-color-666"> 主页访问量 : 20 次访问 </span>
							</div>
						</div>
					</div>
					<!-- end 侧边栏 -->
				</div>
			</div>
		</div>
	</div>

	<div class="aw-footer-wrap">
		<div class="aw-footer">
			Copyright © 2015, All Rights Reserved</span> <span class="hidden-xs">Powered
				By <a href="http://www.wecenter.com/?copyright" target="blank">hulei</a>
			</span>

		</div>
	</div>

	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<script src="/Myweb/assets/js/bootstrap.js"></script>
	<script src="/Myweb/assets/js/user.js"></script>

</body>
</html>