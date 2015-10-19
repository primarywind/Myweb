<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
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

<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/Myweb/assets/css/icon.css" />

<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/common.css" />

<link rel="stylesheet" type="text/css" href="/Myweb/assets/css/link.css" />

<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/style.css" />

<script type="text/javascript">
	var _646630DB96067949FADF9ACCB93703CE = 'd12695da758c7473';
	var G_POST_HASH = _646630DB96067949FADF9ACCB93703CE;
	var G_INDEX_SCRIPT = '';
	var G_SITE_NAME = 'Laravel中文网问答社区';
	var G_BASE_URL = 'http://wenda.golaravel.com';
	var G_STATIC_URL = 'http://wenda.golaravel.com/static';
	var G_UPLOAD_URL = 'http://wenda.golaravel.com/uploads';
	var G_USER_ID = '2514';
	var G_USER_NAME = 'nullpoint';
	var G_UPLOAD_ENABLE = 'N';
	var G_UNREAD_NOTIFICATION = 0;
	var G_NOTIFICATION_INTERVAL = 100000;
	var G_CAN_CREATE_TOPIC = '';
</script>
<script
	src="http://wenda.golaravel.com/static/js/jquery.2.js?v=20140930"
	type="text/javascript"></script>
<script
	src="http://wenda.golaravel.com/static/js/jquery.form.js?v=20140930"
	type="text/javascript"></script>
<script src="http://wenda.golaravel.com/static/js/aws.js?v=20140930"
	type="text/javascript"></script>
<script
	src="http://wenda.golaravel.com/static/js/aw_template.js?v=20140930"
	type="text/javascript"></script>
<script src="http://wenda.golaravel.com/static/js/app.js?v=20140930"
	type="text/javascript"></script>
<script type="text/javascript"
	src="http://wenda.golaravel.com/static/js/compatibility.js"></script>

</head>
<noscript unselectable="on" id="noscript">
	<div class="aw-404 aw-404-wrap container">
		<img src="http://wenda.golaravel.com/static/common/no-js.jpg">
		<p>你的浏览器禁用了JavaScript, 请开启后刷新浏览器获得更好的体验!</p>
	</div>
</noscript>
<body>
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
						id="aw-search-query" /> <span title="搜索" id="global_search_btns"
						onClick="$('#global_search_form').submit();"><i
						class="icon icon-search"></i> </span>
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
				<nav role="navigation"
					class="collapse navbar-collapse bs-navbar-collapse">
					<ul class="nav navbar-nav">
						<li><a href="http://wenda.golaravel.com/home/"><i
								class="icon icon-home"></i> 动态</a>
						</li>
						<li><a href="" class="active"><i class="icon icon-ul"></i>
								发现</a>
						</li>

						<!-- <li><a href="http://wenda.golaravel.com/question/" class="">问题</a></li>

					<li><a href="http://wenda.golaravel.com/article/" class="">文章</a></li> -->

						<li><a href="http://wenda.golaravel.com/topic/"><i
								class="icon icon-topic"></i> 话题</a>
						</li>

						<li><a href="http://wenda.golaravel.com/notifications/"
							class=""><i class="icon icon-bell"></i> 通知</a> <span
							class="badge badge-important" style="display:none"
							id="notifications_unread">0</span>
							<div class="aw-dropdown pull-right hidden-xs">
								<div class="mod-body">
									<ul id="header_notification_list"></ul>
								</div>
								<div class="mod-footer">
									<a href="http://wenda.golaravel.com/notifications/">查看全部</a>
								</div>
							</div></li>
					</ul>
				</nav>
			</div>
			<!-- end 导航 -->
			<!-- 用户栏 -->
			<div class="aw-user-nav">
				<!-- 登陆&注册栏 -->
				<a href="http://wenda.golaravel.com/people/nullpoint"
					class="aw-user-nav-dropdown"> <img alt="nullpoint"
					src="http://wenda.golaravel.com/uploads/avatar/000/00/25/14_avatar_mid.jpg" />

				</a>
				<div class="aw-dropdown dropdown-list pull-right">
					<ul class="aw-dropdown-list">
						<li><a href="http://wenda.golaravel.com/inbox/"><i
								class="icon icon-inbox"></i> 私信<span
								class="badge badge-important hide" id="inbox_unread">0</span> </a>
						</li>
						<li class="hidden-xs"><a
							href="http://wenda.golaravel.com/setting/profile/"><i
								class="icon icon-setting"></i> 设置</a>
						</li>
						<li><a href="http://wenda.golaravel.com/logout/"><i
								class="icon icon-logout"></i> 退出</a>
						</li>
					</ul>
				</div>
				<!-- end 登陆&注册栏 -->
			</div>
			<!-- end 用户栏 -->
			<!-- 发起 -->
			<div class="aw-publish-btn">
				<a id="header_publish" href="http://wenda.golaravel.com/publish/"
					class="btn-primary"><i class="icon icon-ask"></i>发起</a>
				<div class="dropdown-list pull-right">
					<ul>
						<li><a href="http://wenda.golaravel.com/publish/">问题</a>
						</li>
						<li><a href="http://wenda.golaravel.com/publish/article/">文章</a>
						</li>
					</ul>
				</div>
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
							<li><a
								href="http://wenda.golaravel.com/sort_type-unresponsive">等待回复</a>
							</li>
							<li><a
								href="http://wenda.golaravel.com/sort_type-hot__day-7"
								id="sort_control_hot">热门</a>
							</li>
							<li><a href="http://wenda.golaravel.com/is_recommend-1">推荐</a>
							</li>
							<li class="active"><a href="">最新</a>
							</li>

							<h2 class="hidden-xs">
								<i class="icon icon-list"></i> 发现
							</h2>
						</ul>
						<!-- end tab切换 -->


						<div class="aw-mod aw-explore-list">
							<div class="mod-body">
								<div class="aw-common-list">
									<div class="aw-item active" data-topic-id="57,">
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
									</div>

								</div>
							</div>
							<div class="mod-footer">
								<div class="page-control">
									<ul class="pagination pull-right">
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
						<div class="aw-mod">
							<div class="mod-head">
								<h3>专题</h3>
							</div>
							<div class="mod-body">
								<ul>
									<li><a href="http://wenda.golaravel.com/feature/1">Composer中国镜像</a>
									</li>
								</ul>
							</div>
						</div>
						<div class="aw-mod aw-text-align-justify">
							<div class="mod-head">
								<a href="http://wenda.golaravel.com/topic/channel-hot"
									class="pull-right">更多 &gt;</a>
								<h3>热门话题</h3>
							</div>
							<div class="mod-body">
								<dl>
									<dt class="pull-left aw-border-radius-5">
										<a href="http://wenda.golaravel.com/topic/laravel5"><img
											alt=""
											src="http://wenda.golaravel.com/static/common/topic-mid-img.png" />
										</a>
									</dt>
									<dd class="pull-left">
										<p class="clearfix">
											<span class="topic-tag"> <a
												href="http://wenda.golaravel.com/topic/laravel5"
												class="text" data-id="118">laravel5</a> </span>
										</p>
										<p>
											<b>59</b> 个问题, <b>13</b> 人关注
										</p>
									</dd>
								</dl>
								<dl>
									<dt class="pull-left aw-border-radius-5">
										<a href="http://wenda.golaravel.com/topic/laravel"><img
											alt=""
											src="http://wenda.golaravel.com/static/common/topic-mid-img.png" />
										</a>
									</dt>
									<dd class="pull-left">
										<p class="clearfix">
											<span class="topic-tag"> <a
												href="http://wenda.golaravel.com/topic/laravel" class="text"
												data-id="57">laravel</a> </span>
										</p>
										<p>
											<b>164</b> 个问题, <b>24</b> 人关注
										</p>
									</dd>
								</dl>
								<dl>
									<dt class="pull-left aw-border-radius-5">
										<a href="http://wenda.golaravel.com/topic/Laravel5.0"><img
											alt=""
											src="http://wenda.golaravel.com/static/common/topic-mid-img.png" />
										</a>
									</dt>
									<dd class="pull-left">
										<p class="clearfix">
											<span class="topic-tag"> <a
												href="http://wenda.golaravel.com/topic/Laravel5.0"
												class="text" data-id="467">Laravel5.0</a> </span>
										</p>
										<p>
											<b>8</b> 个问题, <b>2</b> 人关注
										</p>
									</dd>
								</dl>
								<dl>
									<dt class="pull-left aw-border-radius-5">
										<a href="http://wenda.golaravel.com/topic/安装问题"><img
											alt=""
											src="http://wenda.golaravel.com/static/common/topic-mid-img.png" />
										</a>
									</dt>
									<dd class="pull-left">
										<p class="clearfix">
											<span class="topic-tag"> <a
												href="http://wenda.golaravel.com/topic/安装问题" class="text"
												data-id="261">安装问题</a> </span>
										</p>
										<p>
											<b>10</b> 个问题, <b>1</b> 人关注
										</p>
									</dd>
								</dl>
								<dl>
									<dt class="pull-left aw-border-radius-5">
										<a href="http://wenda.golaravel.com/topic/Composer"><img
											alt=""
											src="http://wenda.golaravel.com/static/common/topic-mid-img.png" />
										</a>
									</dt>
									<dd class="pull-left">
										<p class="clearfix">
											<span class="topic-tag"> <a
												href="http://wenda.golaravel.com/topic/Composer"
												class="text" data-id="24">Composer</a> </span>
										</p>
										<p>
											<b>50</b> 个问题, <b>9</b> 人关注
										</p>
									</dd>
								</dl>
							</div>
						</div>
						<div class="aw-mod aw-text-align-justify">
							<div class="mod-head">
								<a href="http://wenda.golaravel.com/people/" class="pull-right">更多
									&gt;</a>
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

	<div class="aw-footer-wrap">
		<div class="aw-footer">
			Copyright © 2015, All Rights Reserved</span> <span class="hidden-xs">Powered
				By <a href="http://www.wecenter.com/?copyright" target="blank">WeCenter
					3.0 Beta 2</a> </span>

		</div>
	</div>



	<script type="text/template" id="sendCard">  
     <div class="aw-item active" data-topic-id="57,">
	<a class="aw-user-name hidden-xs" data-id="2483"
		rel="nofollow"><img
		src="{faceImg}"
		alt=""> </a>
	<div class="aw-question-content">
		<h4>
			<a href="http://wenda.golaravel.com/question/1691">我想在中间件中调用一个控制器函数，代码该怎么写呢</a>
		</h4>
		<a href="http://wenda.golaravel.com/question/1691#!answer_form"
			class="pull-right text-color-999">回复</a>

		<p>
			<a href="http://wenda.golaravel.com/people/John%E8%8B%91"
				class="aw-user-name">John苑</a> <span class="text-color-999">发起了问题
				• 1 人关注 • 0 个回复 • 2 次浏览 • 34 分钟前 </span> <span
				class="text-color-999 related-topic hide"> • 来自相关话题</span>
		</p>

	</div>
</div>
	</script>

	<script src="/Myweb/assets/js/discuss.js"></script>
</body>
</html>