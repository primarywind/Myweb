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

<title>��¼��������</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="֪ʶ����,�罻����,�ʴ�����">
<meta http-equiv="description" content="�罻��֪ʶ����">
<!--��ַ��ǰ����ֵ�Icon-->
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
<link rel="alternate" type="application/rss+xml" title="�ҵ�˽�˲���"
	href="http://blog.csdn.net/primary_wind" />
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>

</head>

<body>
	<div id="wrapper">
		<div class="aw-login-box">
			<div class="mod-body clearfix">
				<div class="content pull-left">
					<h2>��������¼</h2>
					<form id="login_form" method="post"
						action="/Myweb/admin/logon.action" onsubmit="return checkUser();">
						<ul>
							<li><input type="text" id="aw-login-user-name"
								class="form-control" placeholder="���� / �û���" name="name" /></li>
							<li><input type="password" id="aw-login-user-password"
								class="form-control" placeholder="����" name="passWord" /></li>
							<li class="alert alert-danger hide error_message"><i
								class="icon icon-delete"></i> <em></em></li>
							<li class="last"><input type="submit" id="login_submit"
								class="pull-right btn btn-large btn-primary" value="��¼">
							</li>
						</ul>
					</form>
				</div>
				<div class="side-bar pull-left">
					ע�����<br>ע������ʹ��������������<br>�۽�����������
				</div>
			</div>
			<div class="mod-footer">
				<span>��û���˺�?</span>&nbsp;&nbsp; <a href="/Myweb/Dregister.jsp">����ע��</a>

			</div>
		</div>
	</div>
	<script>
		function checkUser() {
			var name = $("#aw-login-user-name").val();
			var password = $("#aw-login-user-password").val();

			if (name == "") {
				alert("�û�������Ϊ��");
				return false;
			}
			if (password == "") {
				alert("���벻��Ϊ��");
				return false;
			}
			$("#login_form").submit();
		}
	</script>
</body>
</html>
