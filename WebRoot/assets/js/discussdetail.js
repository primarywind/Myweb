$("#addComment").click(function() {
	$("#aw-comment-box-question").toggle();
});

$("#textareaid").focus(function() {
	$("#aw-comment-box-btn").show();
});

$("#favoriteButton")
		.click(
				function() {
					var fButton = $(this);
					var sendCardId = $("#sendCardId").val();
					if ($(this).attr("data-original-title") == 0) {
						// 没有关注，添加关注
						$
								.ajax({
									type : "post",
									url : "jsonkpi/updateCardFavorite.action",
									data : {
										sendCardId : sendCardId,
										updateFavoriteType : 1
									},
									cache : false,
									dataType : "json",
									success : function(dta) {
										fButton
												.removeClass("follow btn btn-normal btn-success pull-left");
										fButton
												.addClass("follow btn btn-normal btn-success pull-left active");
										fButton.attr("data-original-title", 1);
									},
									error : function(dta) {
										alert("系统错误...");
									}
								});

					} else {
						// 有关注，取消关注
						$
								.ajax({
									type : "post",
									url : "jsonkpi/updateCardFavorite.action",
									data : {
										sendCardId : sendCardId,
										updateFavoriteType : 0
									},
									cache : false,
									dataType : "json",
									success : function(dta) {
										fButton
												.removeClass("follow btn btn-normal btn-success pull-left active");
										fButton
												.addClass("follow btn btn-normal btn-success pull-left");
										fButton.attr("data-original-title", 0);
									},
									error : function(dta) {
										alert("系统错误...");
									}
								});

					}

				});

function submitCommentToOth() {
	$.ajax({
		type : "post",
		url : "jsonkpi/addOthCardComment.action",
		data : $("#commentToOthersForm").serialize(),
		cache : false,
		dataType : "json",
		success : function(dta) {
			alert(dta.msg);
		},
		error : function(dta) {
			alert("系统错误...");
		}
	});
}

function showComments(thisId) {
	var index = "#" + thisId + " ul";

	$("#" + thisId).toggle();

}

function submitCommentForm() {
	var sendCardId = $("#sendCardId").val();
	var message = $("#textareaid").val();
	$.ajax({
		type : "post",
		url : "jsonkpi/addCardComment.action",
		data : {
			sendCardId : sendCardId,
			message : message
		},
		cache : false,
		dataType : "json",
		success : function(dta) {
			alert(dta.msg);
		},
		error : function(dta) {
			alert("系统错误...");
		}
	});
}
