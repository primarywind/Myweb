$(document).ready(function() {
	$('.aw-nav-tabs li').click(function() {
		$(this).addClass('active').siblings().removeClass('active');
		$('#focus .tab-pane').eq($(this).index()).show().siblings().hide();
	});

});
function loadUserDatas() {
	$
			.ajax({
				type : "get",
				url : "jsonkpi/getUserDatas.action",
				cache : false,
				dataType : "json",
				success : function(dta) {
					if (!dta.userInfo) {
						return;
					}
					$("#faceimgId").attr("src", dta.userInfo.userView.faceImg);
					$("#nameId").html(dta.userInfo.userView.name);
					// 发问列表填充
					$("#sendCardListId").empty();
					var sendCardListHtml = "";
					if (dta.userInfo.sendCardListViews.length == 0) {
						$("#sendCardListId").append("无发问");
					} else {
						$
								.each(
										dta.userInfo.sendCardListViews,
										function(i, o) {
											sendCardListHtml = sendCardListHtml
													+ "<a href='/Myweb/admin/getDiscussDetail.action?sendCardId="
													+ o.cardId + "'>" + o.title
													+ "</a><br>";

										});
						$("#sendCardListId").append(sendCardListHtml);
					}
					// 答复列表填充
					$("#followCardListId").empty();
					var followCardListHtml = "";
					if (dta.userInfo.followCardViews.length == 0) {
						$("#followCardListId").append("无回复");
					} else {
						$
								.each(
										dta.userInfo.followCardViews,
										function(i, o) {
											followCardListHtml = followCardListHtml
													+ "<a href='/Myweb/admin/getDiscussDetail.action?sendCardId="
													+ o.cardOrFollowId
													+ "'>"
													+ o.followContent
													+ "</a><br>";
										});
						$("#followCardListId").append(followCardListHtml);
					}
					// 关注列表填充
					$("#favoriteListId").empty();
					var favoriteListHtml = "";
					if (dta.userInfo.favoriteListViews.length == 0) {
						$("#favoriteListId").append("无关注");
					} else {
						$
								.each(
										dta.userInfo.favoriteListViews,
										function(i, o) {
											favoriteListHtml = favoriteListHtml
													+ "<a href='/Myweb/admin/getDiscussDetail.action?sendCardId="
													+ o.cardId + "'>" + o.title
													+ "</a><br>";
										});
						$("#favoriteListId").append(favoriteListHtml);
					}
				},
				error : function(dta) {
					alert("文章类型栏目下拉数据拉取失败...");
				}
			});
}
loadUserDatas();