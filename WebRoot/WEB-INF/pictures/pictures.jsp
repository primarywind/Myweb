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

<title>照片画廊</title>


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="照片画廊">

<!--网址列前面出现的Icon-->
<link rel="shortcut icon" href="/Myweb/assets/images/favicon.ico">

<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/pictures.css" />

<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/masonry/3.3.2/masonry.pkgd.js"></script>
</head>

<body>
	<div id="waterfall">
		<div class="cell">...</div>
		<div class="cell">...</div>
		<div class="cell">...</div>
	</div>
	<br>
</body>
</html>
