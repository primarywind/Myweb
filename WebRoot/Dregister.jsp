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

<title>ע�ᣭ������</title>

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
	href="/Myweb/assets/css/dregister.css" />
<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/common.css" />
<link rel="stylesheet" type="text/css" href="/Myweb/assets/css/link.css" />
<link rel="alternate" type="application/rss+xml" title="�ҵ�˽�˲���"
	href="http://blog.csdn.net/primary_wind" />


<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>

<script type="text/javascript">
	var _6B95ABCA1824BAF799DC4872536FDFB4 = "";
	var G_POST_HASH = _6B95ABCA1824BAF799DC4872536FDFB4;
	var G_INDEX_SCRIPT = "?/";
	var G_SITE_NAME = "WeCenter";
	var G_BASE_URL = "http://localhost/Discuss/?";
	var G_STATIC_URL = "http://localhost/Discuss/static";
	var G_UPLOAD_URL = "http://localhost/Discuss/uploads";
	var G_USER_ID = "";
	var G_USER_NAME = "";
	var G_UPLOAD_ENABLE = "N";
	var G_UNREAD_NOTIFICATION = 0;
	var G_NOTIFICATION_INTERVAL = 100000;
	var G_CAN_CREATE_TOPIC = "";
	var G_ADVANCED_EDITOR_ENABLE = "Y";

	function loadimage() {
		document.getElementById("randImage").src = "image.jsp?" + Math.random();
	}
</script>
</head>

<body>
	<div class="aw-register-box">
		<div class="mod-head">
			<a href=""><img
				src="http://localhost/Discuss/static/css/default/img/login_logo.png"
				alt="" /> </a>
			<h1>ע�����û�</h1>
		</div>
		<div class="mod-body">
			<form class="aw-register-form" id="register_form">

				<ul>
					<li class="alert alert-danger hide error_message text-left"><i
						class="icon icon-delete"></i> <em></em>
					</li>
					<li><input class="aw-register-name form-control" type="text"
						name="name" id="name" placeholder="�û���" tips="������һ�� 2-14 λ���û���"
						errortips="�û������Ȳ�����" value="" />
					</li>
					<li><input class="aw-register-pwd form-control"
						type="password" name="password" id="password" placeholder="����"
						tips="������ 6-16 ���ַ�,���ִ�Сд" errortips="���벻���Ϲ���" />
					</li>
					<li><input class="aw-register-pwd form-control"
						type="password" id="cpassword" placeholder="ȷ������"
						tips="������ 6-16 ���ַ�,���ִ�Сд" errortips="���벻һ��" />
					</li>

					<li>�Ա�: <label> <input name="sex" value="1"
							type="radio" checked="checked" /> �� </label>&nbsp; <label> <input
							name="sex" value="2" type="radio" /> Ů </label>
					</li>

					<li><input class=" form-control" type="text" name="city"
						id="city" placeholder="���ڳ���" errortips="����Ϊ��" />
					</li>

					<li class="aw-register-verify"><a
						href="javascript:loadimage();"><img class="pull-right"
							name="randImage" id="randImage" src="image.jsp" align="absmiddle"
							style="width:90px;height:36px"> </a> <input type="text"
						class="form-control" name="seccode_verify" id="seccode_verify"
						placeholder="��֤��" />
					</li>
					<li class="last"><label><input type="checkbox"
							checked="checked" value="agree" name="agreement_chk" /> ��ͬ��</label> <a
						href="javascript:;" class="aw-agreement-btn">�û�Э��</a> <a
						href="http://localhost/Discuss/?/account/login/"
						class="pull-right">�����˺�?</a>
						<div class="aw-register-agreement hide">
							<div class="aw-register-agreement-txt" id="register_agreement"></div>
						</div>
					</li>
					<li class="clearfix"><input class="" onclick="register();"
						type="button" value="ע��" /></li>
				</ul>
			</form>
		</div>
		<div class="mod-footer"></div>
	</div>

	<script type="text/javascript">
		var isPassWord = true;
		var isName = true;
		var isSex = true;
		var isCity = true;

		$(document).ready(function() {
			verify_register_form('#register_form');

		});
		/* ע��ҳ����֤ */
		function verify_register_form(element) {

			$(element)
					.find('[type=text]')
					.on(
							{
								focus : function() {
									if (typeof $(this).attr('tips') != 'undefined'
											&& $(this).attr('tips') != '') {
										$(this).parent().append(
												'<span class="aw-reg-tips">'
														+ $(this).attr('tips')
														+ '</span>');

									}
								},
								blur : function() {
									if ($(this).attr('tips') != '') {
										switch ($(this).attr('name')) {
										case 'name':
											var _this = $(this);
											$(this).parent().find(
													'.aw-reg-tips').detach();
											if ($(this).val().length >= 0
													&& $(this).val().length < 2) {
												$(this).parent().find(
														'.aw-reg-tips')
														.detach();
												$(this)
														.parent()
														.append(
																'<span class="aw-reg-tips aw-reg-err"><i class="aw-icon i-err"></i>'
																		+ $(
																				this)
																				.attr(
																						'errortips')
																		+ '</span>');

												return;
											}
											if ($(this).val().length > 17) {
												$(this).parent().find(
														'.aw-reg-tips')
														.detach();
												$(this)
														.parent()
														.append(
																'<span class="aw-reg-tips aw-reg-err"><i class="aw-icon i-err"></i>'
																		+ $(
																				this)
																				.attr(
																						'errortips')
																		+ '</span>');
												return;
											} else {
												$
														.post(
																G_BASE_URL
																		+ '/account/ajax/check_username/',
																{
																	username : $(
																			this)
																			.val()
																},
																function(result) {
																	if (result.errno == -1) {
																		_this
																				.parent()
																				.find(
																						'.aw-reg-tips')
																				.detach();
																		_this
																				.parent()
																				.append(
																						'<span class="aw-reg-tips aw-reg-err"><i class="aw-icon i-err"></i>'
																								+ result.err
																								+ '</span>');
																	} else {
																		_this
																				.parent()
																				.find(
																						'.aw-reg-tips')
																				.detach();
																		_this
																				.parent()
																				.append(
																						'<span class="aw-reg-tips aw-reg-right"><i class="aw-icon i-followed"></i></span>');
																	}
																}, 'json');
											}
											return;
										}
									}

								}
							});
			//У������
			$("#password")
					.on(
							{
								focus : function() {
									if (typeof $(this).attr('tips') != 'undefined'
											&& $(this).attr('tips') != '') {
										$(this).parent().append(
												'<span class="aw-reg-tips">'
														+ $(this).attr('tips')
														+ '</span>');
									}
								},
								blur : function() {
									if ($(this).attr('tips') != '') {
										switch ($(this).attr('name')) {
										case 'password':
											$(this).parent().find(
													'.aw-reg-tips').detach();
											if ($(this).val().length >= 0
													&& $(this).val().length < 6) {
												$(this).parent().find(
														'.aw-reg-tips')
														.detach();
												$(this)
														.parent()
														.append(
																'<span class="aw-reg-tips aw-reg-err"><i class="aw-icon i-err"></i>'
																		+ $(
																				this)
																				.attr(
																						'errortips')
																		+ '</span>');
												return;
											}
											if ($(this).val().length > 17) {
												$(this).parent().find(
														'.aw-reg-tips')
														.detach();
												$(this)
														.parent()
														.append(
																'<span class="aw-reg-tips aw-reg-err"><i class="aw-icon i-err"></i>'
																		+ $(
																				this)
																				.attr(
																						'errortips')
																		+ '</span>');
												return;
											} else {
												$(this).parent().find(
														'.aw-reg-tips')
														.detach();
												$(this)
														.parent()
														.append(
																'<span class="aw-reg-tips aw-reg-right"><i class="aw-icon i-followed"></i></span>');
											}
											return;

										}
									}

								}
							});
			$("#cpassword").on(
					{
						blur : function() {
							$(this).parent().find('.aw-reg-tips').detach();
							if ($('#password').val() != $(this).val()) {
								$(this).parent().append(
										'<span class="aw-reg-tips aw-reg-err"><i class="aw-icon i-err"></i>'
												+ $(this).attr('errortips')
												+ '</span>');
								return;
							}
						}
					});
			$("#city").on(
					{
						blur : function() {
							$(this).parent().find('.aw-reg-tips').detach();
							if ($(this).val() == "") {
								$(this).parent().append(
										'<span class="aw-reg-tips aw-reg-err"><i class="aw-icon i-err"></i>'
												+ $(this).attr('errortips')
												+ '</span>');
							}
							return;
						}
					});
		}

		function register() {
			var Rand =
	<%=session.getAttribute("rand")%>
		;
			//У����У��
			/* if (Rand != $('#seccode_verify').val()) {
				return false;
			} */
			var name = $('#name').val();
			var password = $('#password').val();
			var cpassword = $('#cpassword').val();
			var sex = $("input[name='sex']:checked").val();
			var city = $('#city').val();
			//�����У��
			if (password == "" || password != cpassword) {
				alert("���������룡");
				return;
			}
			if (password != cpassword) {
				alert("���벻һ�£�");
				return;
			}
			if (name == "" || password == "" || sex == "" || city == "") {
				alert("������Ϊ�գ�");
				return;
			}
			$.ajax({
				cache : true,
				type : "POST",
				url : "jsonkpi/registerUser.action",
				data : $('#register_form').serialize(),// ���formid
				async : false,
				success : function(data) {
					alert(data.msg);
					window.location.href = "/Myweb/admin/goToDiscuss.action";
				},
				error : function(request) {
					alert("Connection error");
				}
			});
		}
	</script>

</body>
</html>
