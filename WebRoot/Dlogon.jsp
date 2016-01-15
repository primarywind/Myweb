<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录－讨论区</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="知识社区,社交社区,问答社区">
<meta http-equiv="description" content="社交化知识社区">
<!--网址列前面出现的Icon-->
<link rel="shortcut icon" href="/Myweb/assets/images/favicon.ico">


<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/template.css" />
<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/dlogon.css" />
<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/common.css" />
<link rel="stylesheet" type="text/css" href="/Myweb/assets/css/link.css" />
<link rel="alternate" type="application/rss+xml" title="我的私人博客"
	href="http://blog.csdn.net/primary_wind" />
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>

</head>

<body>
	<div id="wrapper">
		<div class="aw-login-box">
			<div class="mod-body clearfix">
				<div class="content pull-left">
					<h2>讨论区登录</h2>
					<form id="login_form" method="post"
						action="/Myweb/admin/logon.action" onsubmit="return checkUser();">
						<ul>
							<li><input type="text" id="aw-login-user-name"
								class="form-control" placeholder="邮箱 / 用户名" name="name" /></li>
							<li><input type="password" id="aw-login-user-password"
								class="form-control" placeholder="密码" name="passWord" /></li>
							<li class="alert alert-danger hide error_message"><i
								class="icon icon-delete"></i> <em></em></li>
							<li class="last"><input type="submit" id="login_submit"
								class="pull-right btn btn-large btn-primary" value="登录">
							</li>
						</ul>
					</form>
				</div>
				<div class="side-bar pull-left">
					注意事项：<br>注册姓名使用真名，所有言<br>论将负法律责任
				</div>
			</div>
			<div class="mod-footer">
				<span>还没有账号?</span>&nbsp;&nbsp; <a href="/Myweb/Dregister.jsp">立即注册</a>

			</div>
		</div>
	</div>
	<script>
		function checkUser() {
			var name = $("#aw-login-user-name").val();
			var password = $("#aw-login-user-password").val();

			if (name == "") {
				alert("用户名不能为空");
				return false;
			}
			if (password == "") {
				alert("密码不能为空");
				return false;
			}
			$("#login_form").submit();
		}
	</script>
</body>
</html>
