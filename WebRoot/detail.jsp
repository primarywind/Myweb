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
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"
	name="viewport" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta name="renderer" content="webkit" />
<title>话题详细页面</title>
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
	var _D9DA2ABD1130E8F5AB661C15A1B7BCC5 = '';
	var G_POST_HASH = _D9DA2ABD1130E8F5AB661C15A1B7BCC5;
	var G_INDEX_SCRIPT = '';
	var G_SITE_NAME = 'Laravel中文网问答社区';
	var G_BASE_URL = 'http://wenda.golaravel.com';
	var G_STATIC_URL = 'http://wenda.golaravel.com/static';
	var G_UPLOAD_URL = 'http://wenda.golaravel.com/uploads';
	var G_USER_ID = '';
	var G_USER_NAME = '';
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
<script
	src="http://wenda.golaravel.com/static/js/plug_module/plug-in_module.js?v=20140930"
	type="text/javascript"></script>
<script src="http://wenda.golaravel.com/static/js/aws.js?v=20140930"
	type="text/javascript"></script>
<script
	src="http://wenda.golaravel.com/static/js/aw_template.js?v=20140930"
	type="text/javascript"></script>
<script src="http://wenda.golaravel.com/static/js/app.js?v=20140930"
	type="text/javascript"></script>
<script
	src="http://wenda.golaravel.com/static/js/editor/Markdown.Converter.js?v=20140930"
	type="text/javascript"></script>
<script
	src="http://wenda.golaravel.com/static/js/editor/Markdown.Sanitizer.js?v=20140930"
	type="text/javascript"></script>
<script
	src="http://wenda.golaravel.com/static/js/editor/Markdown.Editor.js?v=20140930"
	type="text/javascript"></script>
<script type="text/javascript"
	src="http://wenda.golaravel.com/static/js/compatibility.js"></script>
<!--[if lte IE 8]>
	<script type="text/javascript" src="http://wenda.golaravel.com/static/js/respond.js"></script>
<![endif]-->
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
						<li><a href="" class=""><i class="icon icon-ul"></i> 发现</a></li>
						<li><a href="http://wenda.golaravel.com/topic/"><i
								class="icon icon-topic"></i> 话题</a></li>

					</ul>
				</nav>
			</div>
			<!-- end 导航 -->
		</div>
	</div>

	<div class="aw-container-wrap">
		<div class="container">
			<div class="row">
				<div class="aw-content-wrap clearfix">
					<div class="col-sm-12 col-md-9 aw-main-content">

						<div class="aw-mod aw-question-detail aw-item">
							<div class="mod-head">
								<h1>laravel前后端分离，如何实现两个登录系统？</h1>

							</div>
							<div class="mod-body">
								<div class="content markitup-box">
									用laravel既有后台又有前台都需要登录，用auth只能验证一个登录系统，<br /> 该如何来实现，求指点迷津？

								</div>
							</div>
							<div class="mod-footer">
								<div class="meta">
									<span class="text-color-999">2015-04-07</span> <a data-id="789"
										data-type="question" class="aw-add-comment text-color-999 "
										data-comment-count="0" data-first-click="hide"><i
										class="icon icon-comment"></i>添加评论</a>



									<div class="pull-right more-operate">

										<div aria-labelledby="dropdownMenu" role="menu"
											class="aw-dropdown shareout pull-right">
											<ul class="aw-dropdown-list">
												<li><a onclick="AWS.User.share_out('tsina');"><i
														class="icon icon-weibo"></i> 新浪微博</a></li>
												<li><a onclick="AWS.User.share_out('qzone');"><i
														class="icon icon-qzone"></i> QZONE</a></li>
												<li><a onclick="AWS.User.share_out('weixin');"><i
														class="icon icon-wechat"></i> 微信</a></li>
											</ul>
										</div>

									</div>
								</div>
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
									method="post" onsubmit="" id="related_link_form">
									<div class="mod-head">
										<h2>与内容相关的链接</h2>
									</div>
									<div class="mod-body clearfix">
										<input type="hidden" name="item_id" value="789" /> <input
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

									<h2 class="hidden-xs">6 个回复</h2>
								</ul>
							</div>
							<div class="mod-body aw-feed-list">
								<div class="aw-item" uninterested_count="0" force_fold="0"
									id="answer_list_1787">
									<div class="mod-head">
										<a class="anchor" name="answer_1787"></a>
										<!-- 用户头像 -->
										<a class="aw-user-img aw-border-radius-5 pull-right"
											href="http://wenda.golaravel.com/people/%E8%B5%B5%E7%8B%97%E8%83%9C"
											data-id="886"><img
											src="http://wenda.golaravel.com/uploads/avatar/000/00/08/86_avatar_mid.jpg"
											alt="" /> </a>
										<!-- end 用户头像 -->
										<div class="title">
											<p>
												<a class="aw-user-name"
													href="http://wenda.golaravel.com/people/%E8%B5%B5%E7%8B%97%E8%83%9C"
													data-id="886">赵狗胜</a> - <span class="text-color-999">谢谢帮助过我的人！</span>
											</p>
											<p class="text-color-999 aw-agree-by">
												赞同来自: <a href="http://wenda.golaravel.com/people/strglee"
													data-id="564" class="aw-user-name">strglee</a>
											</p>
										</div>
									</div>
									<div class="mod-body clearfix">
										<!-- 评论内容 -->
										<div class="markitup-box">
											<a href="http://www.youthtribe.com/archives/1457"><a
												href="http://www.youthtribe.com/archives/1457"
												rel="nofollow" target="_blank">http://www.youthtribe.com/archives/1457</a>
											</a><br /> laravel 5.0 实现默认的多表auth认证，如前后台表<br /> <br />
											有问题留言，我自己试是ok了。。
										</div>


										<!-- end 评论内容 -->
									</div>
									<div class="mod-footer">
										<!-- 社交操作 -->
										<div class="meta clearfix">
											<span class="text-color-999 pull-right">2015-05-07</span>
											<!-- 投票栏 -->
											<span class="operate"> <a class="agree  disabled"><i
													data-placement="right" title="" data-toggle="tooltip"
													class="icon icon-agree" data-original-title="赞同回复"></i> <b
													class="count">1</b> </a> </span>
											<!-- end 投票栏 -->
											<span class="operate"> <a class="aw-add-comment"
												data-id="1787" data-type="answer" data-comment-count="0"
												data-first-click="hide" href="javascript:;"><i
													class="icon icon-comment"></i> 0</a> </span>
											<!-- 可显示/隐藏的操作box -->
											<div class="more-operate">

												<div class="btn-group pull-left">
													<a class="text-color-999 dropdown-toggle"
														data-toggle="dropdown"> <i class="icon icon-share"></i>
														分享 </a>
													<div aria-labelledby="dropdownMenu" role="menu"
														class="aw-dropdown shareout pull-right">
														<ul class="aw-dropdown-list">
															<li><a
																onclick="AWS.User.share_out('tsina', $(this).parents('.aw-item').find('.markitup-box').text());"><i
																	class="icon icon-weibo"></i> 新浪微博</a></li>
															<li><a
																onclick="AWS.User.share_out('qzone', $(this).parents('.aw-item').find('.markitup-box').text());"><i
																	class="icon icon-qzone"></i> QZONE</a></li>
															<li><a
																onclick="AWS.User.share_out('weixin', $(this).parents('.aw-item').find('.markitup-box').text());"><i
																	class="icon icon-wechat"></i> 微信</a></li>
														</ul>
													</div>
												</div>
											</div>
											<!-- end 可显示/隐藏的操作box -->

										</div>
										<!-- end 社交操作 -->
									</div>
								</div>





							</div>
							<div class="mod-footer">
								<div class="aw-load-more-content hide"
									id="load_uninterested_answers">
									<span class="text-color-999 aw-alert-box text-color-999"
										href="javascript:;" tabindex="-1"
										onclick="AWS.alert('被折叠的回复是被你或者被大多数用户认为没有帮助的回复');">为什么被折叠?</span>
									<a href="javascript:;" class="aw-load-more-content"><span
										class="hide_answers_count">0</span> 个回复被折叠</a>
								</div>

								<div class="hide aw-feed-list" id="uninterested_answers_list"></div>
							</div>

						</div>
						<!-- end  话题详细模块 -->

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
										<a href="http://wenda.golaravel.com/people/webclz"><img
											alt="webclz"
											src="http://wenda.golaravel.com/static/common/avatar-mid-img.png" />
										</a>
									</dt>
									<dd class="pull-left">
										<a class="aw-user-name"
											href="http://wenda.golaravel.com/people/webclz" data-id="950">webclz</a>
										<p></p>
									</dd>
								</dl>
							</div>
						</div>
						<!-- end 发起人 -->



						<!-- 相关话题 -->
						<div class="aw-mod">
							<div class="mod-head">
								<h3>热门话题</h3>
							</div>
							<div class="mod-body font-size-12">
								<ul>
									<li><a href="http://wenda.golaravel.com/question/1338">吐槽一下laravel问答系统</a>
									</li>
									<li><a href="http://wenda.golaravel.com/question/4">关于Laravel教程的一些调研</a>
									</li>
									<li><a href="http://wenda.golaravel.com/question/101">laravel现在有什么现成的案例吗</a>
									</li>
									<li><a href="http://wenda.golaravel.com/question/486">在Eloquent的关联中如何实现分页</a>
									</li>
									<li><a href="http://wenda.golaravel.com/question/1048">Laravel
											到底哪优雅了？</a></li>
									<li><a href="http://wenda.golaravel.com/question/336">我想使用laravel的时间戳</a>
									</li>
									<li><a href="http://wenda.golaravel.com/question/341">队列怎么实现定时任务,类似于每天0点定时清除某个数据库</a>
									</li>
									<li><a href="http://wenda.golaravel.com/question/746">laravel
											安装如何选择低版本问题</a></li>
									<li><a href="http://wenda.golaravel.com/question/452">@安正超
											@王赛 @FiveSay @JohnLui @码农,几位大神 发布些laravel原理的高级教程吧！</a></li>
									<li><a href="http://wenda.golaravel.com/question/404">用sentry。。但是如果前台使用手机号登录，后台使用email登录，如何配置？</a>
									</li>
									<li><a href="http://wenda.golaravel.com/question/530">$GLOBALS['HTTP_RAW_POST_DATA']用laravel如何获取</a>
									</li>
								</ul>
							</div>
						</div>
						<!-- end 相关话题 -->

						<!-- 话题状态 -->
						<div class="aw-mod question-status">
							<div class="mod-head">
								<h3>话题状态</h3>
							</div>
							<div class="mod-body">
								<ul>
									<li>浏览: <span class="aw-text-color-blue">1663</span></li>
									<li>关注: <span class="aw-text-color-blue">8</span> 人</li>
									<li class="aw-border-radius-5" id="focus_users"></li>
								</ul>
							</div>
						</div>
						<!-- end  话题状态 -->
					</div>
					<!-- end 侧边栏 -->
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		ATTACH_ACCESS_KEY = 'd9da2abd1130e8f5ab661c15a1b7bcc5';
		ITEM_IDS = '';
		COMMENT_UNFOLD = 'all';

		QUESTION_ID = 789;
		UNINTERESTED_COUNT = 5;
	</script>

	<script type="text/javascript"
		src="http://wenda.golaravel.com/static/js/app/question_detail.js"></script>

	<div class="aw-footer-wrap">
		<div class="aw-footer">
			Copyright © 2015, All Rights Reserved</span> <span class="hidden-xs">Powered
				By <a href="http://www.wecenter.com/?copyright" target="blank">WeCenter
					3.0 Beta 2</a> </span>

		</div>
	</div>



	<a class="aw-back-top hidden-xs" href="javascript:;"
		onclick="$.scrollTo(1, 600, {queue:true});"><i
		class="icon icon-up"></i> </a>

	<script type="text/javascript">
		var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://"
				: " http://");
		document
				.write(unescape("%3Cscript src='"
						+ _bdhmProtocol
						+ "hm.baidu.com/h.js%3Fc8d13872a523d9c286aa7affbe0921f1' type='text/javascript'%3E%3C/script%3E"));
	</script>
	<!-- DO NOT REMOVE -->
	<div id="aw-ajax-box" class="aw-ajax-box"></div>
	<div style="display:none;" id="__crond">
		<script type="text/javascript">
			$(document)
					.ready(
							function() {
								$('#__crond')
										.html(
												unescape('%3Cimg%20src%3D%22'
														+ G_BASE_URL
														+ '/crond/run/1445325554%22%20width%3D%221%22%20height%3D%221%22%20/%3E'));
							});
		</script>
	</div>

	<!-- Escape time: 0.028064012527466 -->
	<!-- / DO NOT REMOVE -->

</body>
</html>