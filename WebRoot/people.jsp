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
<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/user.css">
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
				<a href="/Myweb/people/<%=sessionValues.getName()%>"> <img
					alt="<%=sessionValues.getName()%>"
					src="<%=sessionValues.getFaceImg()%>"> </a>
				<div class="aw-dropdown dropdown-list pull-right">
					<ul class="aw-dropdown-list">
						<li><a href="http://wenda.golaravel.com/inbox/">私信<span
								class="badge badge-important hide" id="inbox_unread">0</span> </a></li>
						<li class="hidden-xs"><a
							href="http://wenda.golaravel.com/setting/profile/">设置</a></li>
						<li><a href="http://wenda.golaravel.com/logout/">退出</a></li>
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
								<img
									src="http://wenda.golaravel.com/uploads/avatar/000/00/25/14_avatar_max.jpg"
									alt="nullpoint"> <span class="pull-right operate">
									<a href="http://wenda.golaravel.com/setting/profile/"
									class="btn btn-mini btn-success">编辑</a> </span>
								<h1>nullpoint</h1>
								<p class="text-color-999"></p>
								<p class="aw-user-flag"></p>
							</div>
							<div class="mod-body">
								<div class="meta">
									<span><i class="icon icon-prestige"></i> 威望 : <em
										class="aw-text-color-green">0</em>
									</span> <span><i class="icon icon-agree"></i> 赞同 : <em
										class="aw-text-color-orange">0</em>
									</span> <span><i class="icon icon-thank"></i> 感谢 : <em
										class="aw-text-color-orange">0</em>
									</span>
								</div>

							</div>
							<div class="mod-footer">
								<ul class="nav nav-tabs aw-nav-tabs">
									<li class="active"><a href="#overview" id="page_overview"
										data-toggle="tab">概述</a>
									</li>
									<li class=""><a href="#questions" id="page_questions"
										data-toggle="tab">发问<span class="badge">1</span>
									</a>
									</li>
									<li><a href="#answers" id="page_answers" data-toggle="tab">回复<span
											class="badge">0</span>
									</a>
									</li>
									<li><a href="#articles" id="page_articles"
										data-toggle="tab">文章</a>
									</li>
									<li><a href="#focus" id="page_focus" data-toggle="tab">关注</a>
									</li>
									<li><a href="#actions" id="page_actions" data-toggle="tab">动态</a>
									</li>
									<li><a href="#detail" id="page_detail" data-toggle="tab">详细资料</a>
									</li>
								</ul>
							</div>
						</div>
						<!-- end 用户数据内容 -->

						<div class="aw-user-center-tab">
							<div class="tab-content">
								<div class="tab-pane active" id="overview">
									<!-- 回复 -->
									<div class="aw-mod">
										<div class="mod-head">
											<h3>
												<a class="pull-right aw-more-content" href="javascript:;"
													onclick="$('#page_answers').click();">更多 »</a>回复
											</h3>
										</div>
										<div class="mod-body">
											<div class="aw-profile-answer-list">
												<p class="padding10 text-center">没有内容</p>
											</div>
										</div>
									</div>
									<!-- end 回复 -->

									<!-- 发问 -->
									<div class="aw-mod">
										<div class="mod-head">
											<h3>
												<a class="pull-right aw-more-content" href="javascript:;"
													onclick="$('#page_questions').click();">更多 »</a>发问
											</h3>
										</div>
										<div class="mod-body">
											<div class="aw-profile-publish-list">
												<div class="aw-item">
													<div class="mod-head">
														<h4>
															<a href="http://wenda.golaravel.com/question/1991">·12阿斯顿发大水</a>
														</h4>
													</div>
													<div class="mod-body">
														<span class="aw-border-radius-5 count pull-left"><i
															class="icon icon-reply"></i>0</span>
														<p class="aw-hide-txt">14 次浏览 &nbsp;• 1 个关注 &nbsp; • 2
															小时前</p>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- end 发问 -->

									<!-- 最新动态 -->
									<div class="aw-mod">
										<div class="mod-head">
											<h3>
												<a class="pull-right aw-more-content" href="javascript:;"
													onclick="$('#page_actions').click();">更多 »</a>动态
											</h3>
										</div>
										<div class="mod-body">
											<ul>
												<p class="padding10 text-center">没有内容</p>
											</ul>
										</div>
									</div>
								</div>
								<div class="tab-pane" id="questions">
									<div class="aw-mod">
										<div class="mod-head">
											<h3>发问</h3>
										</div>
										<div class="mod-body">
											<div class="aw-profile-publish-list"
												id="contents_user_actions_questions">
												<div class="aw-item">
													<div class="aw-mod">
														<div class="mod-head">
															<h4 class="aw-hide-txt">
																<a href="http://wenda.golaravel.com/question/1991">·12阿斯顿发大水</a>
															</h4>
														</div>
														<div class="mod-body">
															<span class="aw-border-radius-5 count pull-left"><i
																class="icon icon-reply"></i>0</span>
															<p class="text-color-999">14 次浏览 • 1 个关注</p>
															<p class="text-color-999">2 小时前</p>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="mod-footer">
											<!-- 加载更多内容 -->
											<a data-page="1" class="aw-load-more-content disabled"
												id="bp_user_actions_questions_more"> <span>没有更多了</span>
											</a>
											<!-- end 加载更多内容 -->
										</div>
									</div>
								</div>
								<div class="tab-pane" id="answers">
									<div class="aw-mod">
										<div class="mod-head">
											<h3>回复</h3>
										</div>
										<div class="mod-body">
											<div class="aw-profile-answer-list"
												id="contents_user_actions_answers">
												<p style="padding: 15px 0" align="center">没有内容</p>
											</div>
										</div>
										<div class="mod-footer">
											<!-- 加载更多内容 -->
											<a data-page="0" class="aw-load-more-content disabled"
												id="bp_user_actions_answers_more"> <span>没有更多了</span> </a>
											<!-- end 加载更多内容 -->
										</div>
									</div>
								</div>
								<div class="tab-pane" id="articles">
									<div class="aw-mod">
										<div class="mod-head">
											<h3>文章</h3>
										</div>
										<div class="mod-body">
											<div class="aw-profile-publish-list"
												id="contents_user_actions_articles">
												<p style="padding: 15px 0" align="center">没有内容</p>
											</div>
										</div>
										<div class="mod-footer">
											<!-- 加载更多内容 -->
											<a data-page="0" class="aw-load-more-content disabled"
												id="bp_user_actions_articles_more"> <span>没有更多了</span> </a>
											<!-- end 加载更多内容 -->
										</div>
									</div>
								</div>
								<div class="tab-pane" id="focus">
									<!-- 自定义切换 -->
									<div class="aw-mod">
										<div class="aw-tabs text-center">
											<ul>
												<li class="active"><a>关注的人</a>
												</li>
												<li><a>关注者</a>
												</li>
												<li><a>关注的话题</a>
												</li>
											</ul>
										</div>
										<div class="mod-body">
											<div class="aw-tab-content">
												<div class="aw-mod aw-user-center-follow-mod">
													<div class="mod-body">
														<ul id="contents_user_follows" class="clearfix">
															<p style="padding: 15px 0" align="center">没有内容</p>
														</ul>
													</div>
													<div class="mod-footer">
														<!-- 加载更多内容 -->
														<a data-page="0" class="aw-load-more-content disabled"
															id="bp_user_follows_more"> <span>没有更多了</span> </a>
														<!-- end 加载更多内容 -->
													</div>
												</div>
												<div class="aw-mod aw-user-center-follow-mod hide">
													<div class="mod-body">
														<ul class="clearfix" id="contents_user_fans">
															<p style="padding: 15px 0" align="center">没有内容</p>
														</ul>
													</div>
													<div class="mod-footer">
														<!-- 加载更多内容 -->
														<a data-page="0" class="aw-load-more-content disabled"
															id="bp_user_fans_more"> <span>没有更多了</span> </a>
														<!-- end 加载更多内容 -->
													</div>
												</div>
												<div class="aw-mod aw-user-center-follow-mod hide">
													<div class="mod-body">
														<ul id="contents_user_topics" class="clearfix">
															<li>
																<div class="mod-head">
																	<a class="aw-topic-img pull-left aw-border-radius-5"
																		data-id="1064"
																		href="http://wenda.golaravel.com/topic/123123"> <img
																		src="http://wenda.golaravel.com/static/common/topic-mid-img.png"
																		alt="123123"> </a>
																	<p>
																		<a class="aw-topic-name" data-id="1064"
																			href="http://wenda.golaravel.com/topic/123123"><span>123123</span>
																		</a>
																	</p>
																</div>
																<div class="mod-footer">
																	<p class="aw-user-center-follow-meta">1 个讨论 • 1 个关注
																	</p>
																</div></li>

														</ul>
													</div>
													<div class="mod-footer">
														<!-- 加载更多内容 -->
														<a data-page="1" class="aw-load-more-content"
															id="bp_user_topics_more"> <span>更多</span> </a>
														<!-- end 加载更多内容 -->
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- end 自定义切换 -->
								</div>
								<div class="tab-pane" id="actions">
									<div class="aw-mod">
										<div class="mod-head">
											<h3>最新动态</h3>
										</div>
										<div class="mod-body">
											<div id="contents_user_actions">
												<div class="aw-item">
													<p>
														<span class="pull-right text-color-999">2 小时前</span> <em
															class="pull-left"><a
															href="http://wenda.golaravel.com/people/2514"
															class="aw-user-name" data-id="2514">nullpoint</a> 将该问题添加到
															<a href="http://wenda.golaravel.com/topic/123123"
															class="aw-topic-name" data-id="1064">123123</a> 话题:</em> <a
															class="aw-hide-txt"
															href="http://wenda.golaravel.com/question/1991">·12阿斯顿发大水</a>

													</p>
												</div>
												<div class="aw-item">
													<p>
														<span class="pull-right text-color-999">2 小时前</span> <em
															class="pull-left"><a
															href="http://wenda.golaravel.com/people/2514"
															class="aw-user-name" data-id="2514">nullpoint</a> 发起了问题:</em>

														<a class="aw-hide-txt"
															href="http://wenda.golaravel.com/question/1991">·12阿斯顿发大水</a>

													</p>
												</div>
											</div>
										</div>
										<div class="mod-footer">
											<!-- 加载更多内容 -->
											<a data-page="1" class="aw-load-more-content"
												id="bp_user_actions_more"> <span>更多</span> </a>
											<!-- end 加载更多内容 -->
										</div>
									</div>
								</div>
								<div class="tab-pane" id="detail">
									<div class="aw-mod">
										<div class="mod-head">
											<h3>详细资料</h3>
										</div>
										<div class="mod-body aw-user-center-details">
											<dl>
												<dt>
													<span>个人成就:</span>
												</dt>
												<dd>
													<p class="meta">
														<span><i class="icon icon-prestige"></i>威望: <em
															class="aw-text-color-green">0</em>
														</span> <span><i class="icon icon-agree"></i>赞同: <em
															class="aw-text-color-orange">0</em>
														</span> <span><i class="icon icon-thank"></i>感谢: <em
															class="aw-text-color-orange">0</em>
														</span>
													</p>
												</dd>
											</dl>



											<dl>
												<dt>
													<span>最后活跃:</span>
												</dt>
												<dd>28 秒前</dd>
											</dl>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- 侧边栏 -->
					<div class="col-sm-12 col-md-3 aw-side-bar">
						<div class="aw-mod people-following">
							<div class="mod-body">
								<a
									onclick="$('#page_focus').click();$('#focus .aw-tabs ul li').eq(0).click();$.scrollTo($('#focus').offset()['top'], 600, {queue:true})"
									class="pull-right font-size-12">更多 »</a> <span> 关注 <em
									class="aw-text-color-blue">0</em> 人 </span>
							</div>
						</div>
						<div class="aw-mod people-following">
							<div class="mod-body">
								<a
									onclick="$('#page_focus').click();$('#focus .aw-tabs ul li').eq(1).click();$.scrollTo($('#focus').offset()['top'], 600, {queue:true})"
									class="pull-right font-size-12">更多 »</a> <span> 被 <em
									class="aw-text-color-blue">0</em> 人关注 </span>

							</div>

						</div>
						<div class="aw-mod people-following">
							<div class="mod-body">
								关注 <em class="aw-text-color-blue">1</em> 话题
								<div class="aw-topic-bar">
									<div class="tag-bar clearfix">
										<span class="topic-tag"> <a
											href="http://wenda.golaravel.com/topic/123123" class="text"
											data-id="1064">123123</a> </span>
									</div>
								</div>
							</div>
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
	<!-- 
	<div class="aw-footer-wrap">
		<div class="aw-footer">
			Copyright © 2015, All Rights Reserved</span> <span class="hidden-xs">Powered
				By <a href="http://www.wecenter.com/?copyright" target="blank">WeCenter
					3.0 Beta 2</a> </span>

		</div>
	</div> -->

	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<script src="/Myweb/assets/js/discuss.js"></script>
	<script src="/Myweb/assets/js/publish.js"></script>
</body>
</html>