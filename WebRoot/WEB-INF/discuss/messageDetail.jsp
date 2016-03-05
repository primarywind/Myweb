<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.myweb.entity.User"%>
<%@page import="com.myweb.view.MessageView"%>
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
<link rel="stylesheet" type="text/css" href="/Myweb/assets/css/user.css">
<link rel="stylesheet" type="text/css" href="/Myweb/assets/css/link.css" />

<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/style.css" />



</head>

<body>
	<%
	    HttpSession sessions = request.getSession();
	    User sessionValues = (User) sessions.getAttribute("USER");
	    List<MessageView> messageViews = (List<MessageView>) request
	        .getAttribute("messageViewList");
	    int userId = sessionValues.getUserId();
	    String connectUserName = "";
	    int receiveUserId = 0;
	    if (messageViews.get(0).getSendUserId() != userId) {
	        connectUserName = messageViews.get(0).getSendUserName();
	        receiveUserId = messageViews.get(0).getSendUserId();
	    } else {
	        connectUserName = messageViews.get(0).getReceiveUserName();
	        receiveUserId = messageViews.get(0).getReceiveUserId();
	    }
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
					<div class="col-sm-12 col-md-12 aw-main-content">
						<div class="aw-mod aw-inbox-read">
							<div class="mod-head common-head">
								<h2>
									<a href="/Myweb/admin/gotoMessage.action" class="pull-right">返回私信列表
										»</a> 私信对话：<%=connectUserName%>
								</h2>
							</div>
							<div class="mod-body">
								<!-- 私信内容输入框　-->
								<form id="recipient_form">
									<input name="receiveUserId" value="<%=receiveUserId%>"
										type="hidden"><input name="messageGroup"
										value="<%=messageViews.get(0).getMessageGroup()%>"
										type="hidden"><input name="messageId"
										value="<%=messageViews.get(0).getMessageId()%>" type="hidden">
									<a href="#" data-id="2" class="aw-user-img aw-border-radius-5"><img
										src="<%=sessionValues.getFaceImg()%>" alt="" width="32" height="32"> </a>
									<textarea rows="3" class="form-control"
										placeholder="想要对ta说点什么?" type="text" name="messageContent"></textarea>
									<p>
										<button class="btn btn-mini btn-success"
											onclick="submitReceiveMessage()">
											发送</a>
									</p>
								</form>
								<!-- end 私信内容输入框 -->
							</div>
							<div class="mod-footer">
								<!-- 私信内容列表 -->
								<a name="contents"></a>
								<ul>
									<%
									    for (int i = 0; i < messageViews.size(); i++) {
									        if (messageViews.get(i).getSendUserId() == userId) {
									%>
									<li class="active"><a href="#" data-id="2"
										class="aw-user-img aw-border-radius-5"><img
											src="<%=messageViews.get(i).getSendUserFaceImg()%>" alt="">
									</a>
										<div class="aw-item">
											<p>
												<a href="#">我</a>:
												<%=messageViews.get(i).getMessageContent()%>
											</p>
											<p class="text-color-999"><%=messageViews.get(i).getSendTime()%></p>
											<i class="i-private-replay-triangle"></i>
										</div></li>
									<%
									    } else {
									%>
									<li><a href="#" data-id="1"
										class="aw-user-img aw-border-radius-5"><img
											src="<%=messageViews.get(i).getSendUserFaceImg()%>" alt="">
									</a>
										<div class="aw-item">
											<p>
												<a href="#"><%=messageViews.get(i).getSendUserName()%></a>:
												<%=messageViews.get(i).getMessageContent()%>
											</p>
											<p class="text-color-999">
												<%=messageViews.get(i).getSendTime()%>
											</p>
											<i class="i-private-replay-triangle"></i>
										</div></li>
									<%
									    }
									    }
									%>


								</ul>
								<!-- end 私信内容列表 -->
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
	<div style="display: none;" class="modal fade" id="newmessage"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form id="messageForm">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title" id="exampleModalLabel">私信</h4>
					</div>
					<div class="modal-body">

						<div class="form-group">
							<input class="form-control" name="receiveName"
								id="recipient-name" type="text" placeholder="用户账号">
						</div>
						<div class="form-group">
							<textarea class="form-control" id="message-text"
								name="messageContent" placeholder="内容"></textarea>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary"
							onclick="submitMessage()">发送</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/template" id="messageListView">
<div class="aw-item" >
									<div class="mod-head">
	<a class="aw-user-img aw-border-radius-5 hidden-xs" data-id=""
											href="#"><img
											src="{sendUserFaceImg}"
											alt=""> </a>
										<p>
											<a class="aw-user-name" data-id="2"
												href="http://wenda.golaravel.com/people/wangsai">{sendUserName}</a>
										</p>
										<p class="content">
											<a href="#">{messageContent}</a>
										</p>
										<p class="text-color-999">
											<span class="pull-right"><a href="javascript:;" class="text-color-999"
												onclick="AWS.dialog('confirm', {'message' : '确认删除对话?'}, function(){window.location = G_BASE_URL + '/inbox/delete_dialog/dialog_id-2669'});">删除</a>
											</span> <span>{sendTime}</span>
										</p>
</div></div>
	</script>
	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<script src="/Myweb/assets/js/bootstrap.js"></script>
	<script src="/Myweb/assets/js/message.js"></script>

</body>
</html>