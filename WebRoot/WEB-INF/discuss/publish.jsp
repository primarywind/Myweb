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
							href="http://wenda.golaravel.com/setting/profile/">设置</a>
						</li>
						<li><a href="http://wenda.golaravel.com/logout/">退出</a>
						</li>
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
						<form id="card_form">
							<div class="aw-mod aw-mod-publish">
								<div class="mod-body">
									<h3>话题标题:</h3>
									<!-- 话题标题 -->
									<div class="aw-publish-title active">
										<div>
											<input type="text" placeholder="话题标题..." name="cardTitle"
												id="card_title" value="" class="form-control" />
											<div class="aw-publish-suggest-question hide">
												<p class="text-color-999">你的问题可能已经有答案</p>
												<ul class="aw-dropdown-list">
												</ul>
											</div>
										</div>
									</div>
									<!-- end 话题标题 -->

									<h3>话题内容:</h3>
									<div class="aw-mod aw-editor-box">
										<div class="mod-head">
											<div class="wmd-panel">
												<div id="wmd-button-bar"></div>
												<textarea class="wmd-input form-control autosize"
													id="card_content" rows="15" name="cardContent"></textarea>
											</div>
										</div>
										<div class="mod-body">
											<span class="pull-right text-color-999"
												id="question_detail_message">&nbsp;</span>

										</div>

									</div>

								</div>
								<div style="display: block;"
									class="aw-edit-topic-box form-inline">
									标签： <input class="form-control" id="card_label"
										name="cardLabel" autocomplete="off" placeholder="话题标签..."
										type="text">

								</div>
								<div class="mod-footer clearfix">
									<a href="http://wenda.golaravel.com/page/integral"
										target="_blank">[积分规则]</a> <span class="aw-anonymity">

									</span> <a class="btn btn-large btn-success btn-publish-submit"
										id="publish_submit" onclick="javascript:submitSendCardForm();">确认发起</a>
								</div>
							</div>
						</form>
					</div>
					<!-- 侧边栏 -->
					<div class="col-sm-12 col-md-3 aw-side-bar hidden-xs">
						<!-- 问题发起指南 -->
						<div class="aw-mod publish-help">
							<div class="mod-head">
								<h3>问题发起指南</h3>
							</div>
							<div class="mod-body">
								<p>
									<b>• 问题标题:</b> 请用准确的语言描述您发布的问题思想
								</p>
								<p>
									<b>• 问题补充:</b> 详细补充您的问题内容, 并提供一些相关的素材以供参与者更多的了解您所要问题的主题思想
								</p>
								<p>
									<b>• 选择话题:</b> 选择一个或者多个合适的话题, 让您发布的问题得到更多有相同兴趣的人参与.
									所有人可以在您发布问题之后添加和编辑该问题所属的话题
								</p>
							</div>
						</div>
						<!-- end 问题发起指南 -->
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