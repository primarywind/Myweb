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
	href="/Myweb/assets/css/user-setting.css" />
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
				<a href="/Myweb/admin/goToDiscuss.action"></a>
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

		</div>
	</div>

	<div class="aw-container-wrap">
		<div class="container">
			<div class="row">
				<div class="aw-content-wrap clearfix">
					<div class="aw-user-setting">
						<div class="tabbable"></div>

						<div class="tab-content clearfix">
							<!-- 基本信息 -->
							<div class="aw-mod">
								<div class="mod-body">
									<form id="user_form">
										<div class="aw-mod mod-base">
											<div class="mod-head">
												<h3>基本信息</h3>
											</div>

											<div class="mod-body">
												<dl>
													<dt>账号:</dt>
													<dd><%=sessionValues.getName()%></dd>
												</dl>
												<dl>
													<dt>真实姓名:</dt>
													<dd>
														<input class="form-control" name="userName"
															maxlength="128" value="<%=sessionValues.getUserName()%>"
															type="text">
													</dd>
												</dl>
												<dl>
													<dt>性别:</dt>
													<dd>
														<label> <%
     if (sessionValues.getGender() == 1) {
 %><input name="sex" id="sex" value="1" type="radio" checked> 男
														</label> <label> <input name="sex" id="sex" value="2"
															type="radio"> 女 </label>
														<%
														    } else {
														%>
														<input name="sex" id="sex" value="1" type="radio">
														男 </label> <label> <input name="sex" id="sex" value="2"
															type="radio" checked> 女 </label>
														<%
														    }
														%>
													</dd>
												</dl>

												<dl>
													<dt>
														<label>现居:</label>
													</dt>
													<dd class="introduce">
														<input class="form-control" name="nationality"
															maxlength="128"
															value="<%=sessionValues.getNationality()%>" type="text">
													</dd>
												</dl>
												<dl class="form-horizontal">
													<dt>
														<label>博客网址:</label>
													</dt>
													<dd>
														<input class="form-control"
															value="<%=sessionValues.getBlogUrl()%>" maxlength="60"
															name="blogUrl"
															style="display:inline;width:250px;margin-bottom:0;"
															type="text">

													</dd>
												</dl>

												<!-- 上传头像 -->
												<div class="side-bar">
													<dl>
														<dt class="pull-left">
															<img alt="" id="avatar_src" height="100" width="100"
																src="<%=sessionValues.getFaceImg()%>">

														</dt>
														<dd class="pull-left">
															<h5>头像设置</h5>
															<p>支持 jpg、gif、png 等格式的图片</p>

															<input type=hidden class="span5" id="uploadPicture"
																name="faceImg" value="<%=sessionValues.getFaceImg()%>">
															<input name="file" id="uploadUserImgId"
																class="file-input" type="file">

															<button type="button" onclick="uploadUserImgPic()"
																class="btn btn-warning btn-lg">上传</button>
														</dd>
													</dl>
												</div>
												<!-- end 上传头像 -->
											</div>

										</div>
										<!-- end 基本信息 -->

										<!-- 联系方式 -->
										<div class="aw-mod mod-contact">
											<div class="mod-head">
												<h3>联系方式</h3>
											</div>
											<div class="mod-body clearfix">
												<ul>
													<li><label for="input-qq">QQ :</label> <input
														class="form-control" id="input-qq" name="qq" value=""
														type="text">
													</li>
													<li><label for="input-mobile">手机号码 :</label> <input
														class="form-control" id="input-mobile" name="mobile"
														value="" type="text">
													</li>
													<li><label for="input-common-email">常用邮箱 :</label> <input
														class="form-control" id="input-common-email"
														name="common_email" value="" type="text">
													</li>

												</ul>
											</div>
										</div>
										<!-- end 联系方式 -->
									</form>
								</div>
								<div class="mod-footer clearfix">
									<a href="javascript:;"
										class="btn btn-large btn-success pull-right"
										onclick="updateUserInfo()">保存</a>
								</div>
							</div>



						</div>
					</div>
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
	<script src="/Myweb/assets/js/profile.js"></script>
	<script src="/Myweb/assets/js/ajaxfileupload.js"></script>
</body>
</html>