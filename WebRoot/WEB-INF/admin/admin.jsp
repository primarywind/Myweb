<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
                      + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>后台管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!--网址列前面出现的Icon-->
<link rel="shortcut icon" href="/Myweb/assets/images/favicon.ico">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/screen.css" />

</head>

<body>
	<!-- start header -->
	<header class="main-header"
		style="background-image:url('/Myweb/assets/images/index.jpg');">
	<div class="container">
		<div class="row">
			<div class="col-sm-12">

				<h1>
					<span class="hide">Laravel - </span>为自己搭建的小窝 -- Primarywind
				</h1>

				<h2 class="hide">PHP THAT DOESN'T HURT. CODE HAPPY &amp; ENJOY
					THE FRESH AIR.</h2>

				<img
					src="http://image.golaravel.com/e/b0/4e4bd788405aab87f03d26edc4ab4.png"
					alt="Laravel" class="hide">
			</div>

			<div class="col-sm-12">
				<a href="http://struts.apache.org/" class="btn btn-default btn-doc"
					target="_blank">struts</a> <a
					href="http://projects.spring.io/spring-framework/"
					class="btn btn-default btn-doc" target="_blank">spring</a> <a
					href="http://hibernate.org/" class="btn btn-default btn-doc"
					target="_blank">hibernate</a> <a href="http://www.java.com/zh_CN/"
					class="btn btn-default btn-doc" target="_blank">java</a> <a
					href="http://developer.51cto.com/art/201001/176550.htm"
					class="btn btn-default btn-doc" target="_blank">jvm</a> <a
					href="http://wenda.golaravel.com" class="btn btn-default btn-doc"
					target="_blank">交流屋</a>
			</div>
		</div>
	</div>
	</header>
	<!-- end header -->

	<!-- start navigation -->
	<div class="main-navigation">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 .pull-right">
					<div class="navbar-header">
						<span class="nav-toggle-button collapsed" data-toggle="collapse"
							data-target="#main-menu"> <span class="sr-only">Toggle
								navigation</span> <i class="fa fa-bars"></i> </span>
					</div>
					<div class="collapse navbar-collapse" id="main-menu">
						<ul class="menu">
							<div id="menu">
								<ul class="nav pull-right">
									<li class="active">欢迎<s:property value="user.userName" /></a>
									</li>
									<li class="active"><a href="/Myweb/logonOut.action">退出</a>
									</li>
								</ul>
							</div>

						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end navigation -->


	<div class="container">


		<div class="post tag-laravel-5-1 tag-xin-ban-ben-fa-bu">
			<div class="tabbable">
				<!-- Only required for left/right tabs -->
				<ul class="nav nav-tabs">
					<li class="active"><a href="#tab1" data-toggle="tab">栏目管理</a>
					</li>
					<li><a href="#tab2" data-toggle="tab">文章管理</a>
					</li>
				</ul>
				<div class="tab-content">
					<!-- 栏目管理标签页 -->
					<div class="tab-pane  active" id="tab1">
						<form id="categoriesForm">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>栏目ID</th>
										<th>栏目名称</th>
										<th>添加时间</th>
										<th>栏目链接(可选)</th>
										<th>序列</th>
										<th>是否可见</th>
									</tr>
								</thead>
								<tbody id="caTbody">
									<!-- 待填充内容 -->
								</tbody>
							</table>
							<center>
								<button type="button" class="btn btn-info " id="addCategory">新增</button>
								<button type="button" class="btn btn-info " id="saveAndUpdate"
									onclick="addAndUpdateCategories();">保存</button>
							</center>
						</form>
					</div>
					<!---------------------------------- 文章管理标签页 --------------->
					<div class="tab-pane fade" id="tab2">

						<div class="row col-md-4  col-md-offset-4"
							style="margin-top: 20px;">
							<div class="input-group">
								<select class="form-control" id="categoriesSelect">
								</select><span class="input-group-btn"> <!--<button class="btn btn-default" type="button">搜索文章</button> </span>-->
							</div>
						</div>
						<form id="articlesForm">
							<div id="articleContent">
								<!-- 						<div class="row col-md-8 col-md-offset-2"
							style="margin-top: 30px;">
							<div class="input-group" style="margin-bottom: 10px;">
								<div class="input-group-addon">文章ID</div>
								<input type="text" class="form-control" id="title">
								<div class="input-group-addon">发布者</div>
								<input type="text" class="form-control" id="title">

							</div>
							<div class="input-group" style="margin-bottom: 10px;">
								<div class="input-group-addon">标题</div>
								<input type="text" class="form-control" id="title">
								<div class="input-group-addon">发布时间</div>
								<input type="text" class="form-control" id="title">
							</div>
							<div class="input-group" style="margin-bottom: 10px;">
								<div class="input-group-addon">类别</div>
								<input type="text" class="form-control" id="title">
								<div class="input-group-addon">标签</div>
								<input type="text" class="form-control" id="title">
							</div>
						</div>
						
						<div class="row col-md-10  col-md-offset-2"
							style="margin-top: 30px;">
							文件简介:
							<script id="brefeditor" type="text/plain"
								style="width:700px;height:250px;"></script>
						</div>

						<div class="row col-md-10  col-md-offset-2"
							style="margin-top: 30px;">
							文章详细内容:
							<script id="editor" type="text/plain"
								style="width:700px;height:250px;"></script>
						</div>
						 -->
							</div>
						</form>
						<div class="row col-md-8 col-md-offset-2"
							style="margin-top: 30px;">
							<div class="input-group" style="margin-bottom: 10px;">

								<input class="btn btn-default" type="button"
									onclick="addAndUpdateCategoryArticles();" value="保存">
							</div>
						</div>
						<div class="row col-md-8 col-md-offset-2"
							style="margin-top: 30px;">
							<div class="input-group" style="margin-bottom: 10px;">

								<input class="btn btn-default" type="button"
									onclick="addCategoryArticle();" value="新增文章">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
		<script
			src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

		<script src="/Myweb/assets/js/ueditor/ueditor.config.js"></script>
		<script src="/Myweb/assets/js/ueditor/ueditor.all.js"></script>
		<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
		<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->

		<script src="/Myweb/assets/js/ueditor/lang/zh-cn/zh-cn.js"></script>
		<script src="/Myweb/assets/js/admin.js"></script>
</body>
</html>
