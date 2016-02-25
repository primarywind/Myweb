// 内容格式化模板方法
function formatTemplate(dta, tmpl) {
	var format = {
		name : function(x) {
			return x;
		}
	};
	return tmpl.replace(/{(\w+)}/g, function(m1, m2) {
		if (!m2)
			return "";
		return (format && format[m2]) ? format[m2](dta[m2]) : dta[m2];
	});
}
var pageNo = 1;
var pageSize = 100;
function loadMessageListDatas() {
	$.ajax({
		type : "get",
		url : "jsonkpi/getMessageList.action",
		cache : false,
		data : {
			"pageNo" : pageNo,
			"pageSize" : pageSize
		},
		dataType : "json",
		success : function(dta) {
			if (dta.messageViewList.length == 0) {

				return;
			}
			// 清空内容
			$("#messageListId").empty();
			// 获取模板上的HTML
			var phtml = $('script[type="text/template"][id="messageListView"]')
					.html();

			// 定义一个数组，用来接收格式化合的数据
			var arr = [];
			// 对数据进行遍历
			$.each(dta.messageViewList, function(i, o) {
				arr.push(formatTemplate(o, phtml));
			});

			var $items = $(arr.join(''));
			// append items to grid
			$('#messageListId').append($items);
		},
		error : function(dta) {
			alert("消息拉取失败...");
		}
	});
}

function submitMessage() {
	$.ajax({
		type : "post",
		url : "jsonkpi/addMessage.action",
		data : $("#messageForm").serialize(),
		cache : false,
		dataType : "json",
		success : function(dta) {
			alert(dta.msg);
			$("#newmessage").modal("hide");
			return;
		},
		error : function(dta) {
			alert("发送失败...");
		}
	});
}

function submitReceiveMessage() {
	$.ajax({
		type : "post",
		url : "jsonkpi/addReceiveMessage.action",
		data : $("#recipient_form").serialize(),
		cache : false,
		dataType : "json",
		success : function(dta) {
			alert(dta.msg);
			$("#newmessage").modal("hide");
			window.location.href = "/Myweb/admin/gotoMessageDetail.action?messageId="+dta.messageId;
			return;
		},
		error : function(dta) {
			alert("发送失败...");
		}
	});
}
loadMessageListDatas();