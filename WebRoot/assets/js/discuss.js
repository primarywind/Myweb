$(function() {
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

	// 页码
	var pageNo = 1;
	// 一页条数
	var pageSize = 2;

	// 分页获取图片信息
	function findSendCardsByPage() {
		$
				.ajax({
					type : "get",
					url : "jsonkpi/findSendCardsByPage.action",
					data : {
						"pageNo" : pageNo,
						"pageSize" : pageSize
					},
					cache : false,
					dataType : "json",
					success : function(dta) {
						if (!dta.sendCardListViews
								|| dta.sendCardListViews.length <= 0) {
							alert("已无新话题...");
						}
						pageNo++;
						// 获取模板上的HTML
						var phtml = $(
								'script[type="text/template"][id="sendCard"]')
								.html();

						// 定义一个数组，用来接收格式化合的数据
						var arr = [];
						// 对数据进行遍历
						$.each(dta.sendCardListViews, function(i, o) {
							arr.push(formatTemplate(o, phtml));
						});

						var $items = $(arr.join(''));
						// append items to grid
						$('#aw-common-list').append($items)
					},
					error : function(dta) {
						alert("话题列表信息拉取失败...");
					}
				});
	}
	findSendCardsByPage();
});