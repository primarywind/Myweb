<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
<title>��̨����</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!--��ַ��ǰ����ֵ�Icon-->
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
					<span class="hide">Laravel - </span>Ϊ�Լ����С�� -- Primarywind
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
					target="_blank">������</a>
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
									<li class="active">��ӭ<s:property value="user.userName" /></a>
									</li>
									<li class="active"><a href="/Myweb/logonOut.action">�˳�</a>
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
					<li class="active"><a href="#tab1" data-toggle="tab">��Ŀ����</a>
					</li>
					<li><a href="#tab2" data-toggle="tab">���¹���</a></li>
				</ul>
				<div class="tab-content">
					<!-- ��Ŀ�����ǩҳ -->
					<div class="tab-pane  active" id="tab1">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>��ĿID</th>
									<th>��Ŀ����</th>
									<th>���ʱ��</th>
									<th>��Ŀ���</th>
									<th>��Ŀ����(��ѡ)</th>
									<th>�Ƿ�ɼ�</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">1</th>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><select class="form-control">
											<option selected="selected">0</option>
											<option>1</option>
									</select></td>
									<td><button type="button" class="btn btn-info ">ɾ��</button>
									</td>
								</tr>
								<tr>
									<th scope="row">1</th>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><select class="form-control">
											<option selected="selected">0</option>
											<option>1</option>
									</select></td>
									<td><button type="button" class="btn btn-info ">ɾ��</button>
									</td>
								</tr>
								<tr>
									<th scope="row">1</th>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><select class="form-control">
											<option selected="selected">0</option>
											<option>1</option>
									</select></td>
									<td><button type="button" class="btn btn-info ">ɾ��</button>
									</td>
								</tr>
								<tr>
									<th scope="row">1</th>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><input type="text" class="form-control" value="Otto">
									</td>
									<td><select class="form-control">
											<option selected="selected">0</option>
											<option>1</option>
									</select></td>
									<td><button type="button" class="btn btn-info ">ɾ��</button>
									</td>
								</tr>
							</tbody>
						</table>
						<center>
							<button type="button" class="btn btn-info ">����</button>
							<button type="button" class="btn btn-info ">����</button>
						</center>
					</div>
					<div class="tab-pane fade" id="tab2">
						<center>
							<!-- ���¹����ǩҳ -->
							<div class="row col-md-4  col-md-offset-4"
								style="margin-top: 20px;">

								<div class="input-group">
									<select class="form-control">
										<option selected="selected" value=0>�������</option>
										<option selected="selected" value=0>�������</option>
									</select><span class="input-group-btn">
										<button class="btn btn-default" type="button">��������</button> </span>
								</div>


							</div>
						</center>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
