<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
                      + request.getServerPort() + path + "/";
%>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<title>我的私人博客(项目起始于2015.10.03)</title>
<meta name="description" content="这个网站是一个用于我自己发表博客的 -- by Primarywind" />

<!-- 针对手持设备优化，主要是针对一些老的不识别viewport的浏览器，比如黑莓 -->
<meta name="HandheldFriendly" content="True" />

<!--viewport 可以让布局在移动浏览器上显示的更好-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--网址列前面出现的Icon-->
<link rel="shortcut icon" href="/Myweb/assets/images/favicon.ico">

<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/highlight.js/8.5/styles/monokai_sublime.min.css">
<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/screen.css" />
<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/template.css" />
<link rel="alternate" type="application/rss+xml" title="我的私人博客"
	href="http://blog.csdn.net/primary_wind" />


</head>
<body class="home-template">

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

	<!-- start site's main content area -->
	<section class="content-wrap">
		<div class="container">
			<div class="row">
				<main class="col-md-12 main-content">
				<div id="main-content">
					<div class="sp-column ">
						<div id="system-message-container"></div>
						<div class="row">
							<div class="col-sm-4 col-sm-offset-4">
								<div class="page-login-form login" style="margin-top: 90px;">
									<div class="login-description text-center">后台管理系统</div>
									<form action="/Myweb/logon.action" method="post"
										class="form-validate">
										<div class="form-group">
											<div class="group-control">
												<input name="name" id="name" value=""
													class="validate-username required" size="25"
													placeholder="管理员手机或者邮箱" required="" aria-required="true"
													autofocus="" type="text">
											</div>
										</div>
										<div class="form-group">
											<div class="group-control">
												<input name="passWord" id="password" value=""
													placeholder="密码" class="validate-password required"
													size="25" maxlength="99" required="" aria-required="true"
													type="password">
											</div>
										</div>
										<div class="form-group">
											<button type="submit"
												class="btn btn-success btn-lg btn-block btn-login">
												登入</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				</main>
			</div>
		</div>
	</section>



	<!-- 	<div class="copyright">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<span>Copyright &copy; <a href="#"> 中文网</a> </span> | <span><a
						href="/" target="_blank">京ICP备1111号</a> </span> | <span>京公网安备1111</span>
				</div>
			</div>
		</div>
	</div> -->

	<a href="#" id="back-to-top"><i class="fa fa-angle-up"></i> </a>

	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script
		src="http://cdn.bootcss.com/fitvids/1.1.0/jquery.fitvids.min.js"></script>
	<script src="http://cdn.bootcss.com/highlight.js/8.5/highlight.min.js"></script>
	<script src="/Myweb/assets/js/main.js"></script>
</body>
</html>