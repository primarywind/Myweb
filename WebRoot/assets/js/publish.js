function submitSendCardForm() {
	var card_title = $("#card_title").val();
	var card_content = $("#card_content").val();
	var card_label = $("#card_label").val();
	if (card_title == "" || card_content == "" || card_label == "") {
		alert("必填项为空！");
		return;
	}
	$.ajax({
		type : "post",
		url : "jsonkpi/submitSendCard.action",
		data : $("#card_form").serialize(),
		cache : false,
		dataType : "json",
		success : function(dta) {
			alert(dta.msg);
			alert(dta.sendCardId);
			window.location.href = "/Myweb/admin/getDiscussDetail.action?sendCardId="+dta.sendCardId;
		},
		error : function(dta) {
			alert("系统错误...");
		}
	});
}