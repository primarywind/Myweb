// 上传头像
function uploadUserImgPic() {
	$.ajaxFileUpload({
		url : "jsonkpi/uploadUserFaceImg.action",
		secureuri : false,
		fileElementId : 'uploadUserImgId',
		dataType : 'json',
		success : function(d, status) {
			if (d.logonFailed == 1) {
				window.location.href = "/Myweb/logon.jsp";
			}
			var data = eval('(' + d + ')');
			if (data.flag == 1) {
				$("#avatar_src").attr("src", data.path);
				$("#uploadPicture").val(data.picName);
				alert("上传成功");
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}
function updateUserInfo() {
	$.ajax({
		type : "post",
		url : "jsonkpi/updateUserInfo.action",
		data : $("#user_form").serialize(),
		cache : false,
		dataType : "json",
		success : function(dta) {
			if (dta.logonFailed == 1) {
				window.location.href = "/Myweb/logon.jsp";
			}
			alert(dta.msg);
			return;
		},
		error : function(dta) {
			alert("保存失败...");
		}
	});
}