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

	var pageNo = 1;
	var pageSize = 2;
	var pageCount = 0;
	var categoryId;

	getArticleByPages();
	GetTotalCount();
	// 上一页按钮click事件
	$("#previous").click(function() {
		if (pageNo != 1) {
			pageNo--;
		}
		getArticleByPages();
	});

	// 下一页按钮click事件
	$("#next").click(function() {
		if (pageNo != pageCount) {
			pageNo++;
		}
		getArticleByPages();
	});

	// 分页拉取文章列表
	function getArticleByPages() {
		$.ajax({
			type : "get",
			url : "jsonkpi/findArticlesByPage.action",
			data : {
				"pageNo" : pageNo,
				"pageSize" : pageSize
			},
			cache : false,
			dataType : "json",
			success : function(dta) {
				if (!dta || !dta.articleViews || dta.articleViews.length <= 0) {
					return;
				}
				// 获取模板上的HTML
				var html = $('script[type="text/template"]').html();
				// 定义一个数组，用来接收格式化合的数据
				var arr = [];
				// 对数据进行遍历
				$.each(dta.articleViews, function(i, o) {
					arr.push(formatTemplate(o, html));
				});
				// 把数组化成字符串，并添加到table中去。
				$('#main-content').empty();
				$('#main-content').append(arr.join(''));
				
				$("#page-number").text(
						"第" + pageNo + "页  共 " + pageCount + " 页");
			},
			error : function(dta) {
				alert("文章拉取失败...");
			}
		});
	}

	// 获取总条数
	function GetTotalCount() {
		$.ajax({
			type : "get",
			url : "jsonkpi/findArticlesNums.action",
			data : {
				"categoryId" : categoryId
			},
			cache : false,
			dataType : "json",
			success : function(dta) {
				if (!dta.nums || dta.nums.length <= 0) {
					return;
				}
				// 设置总条数
				pageCount = Math.ceil(dta.nums / pageSize);
				$("#page-number").text(
						"第" + pageNo + "页  共 " + pageCount + " 页");
			}
		});
	}
});
