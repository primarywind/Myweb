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
	var pageSize = 100;

	// 瀑布流初始化
	$('#waterfall').masonry({
		columnWidth : 30,
		itemSelector : '.cell',
		isAnimated : true
	});

	// 绑定点击图片消失事件
	$('#waterfall').on('click', '.cell', function() {
		// remove clicked element
		$('#waterfall').masonry('remove', this)
		// layout remaining item elements
		.masonry('layout');
	});

	// 绑定页面滚动事件
	$(window).scroll(function() {
		var scrollTop = $(this).scrollTop();
		var scrollHeight = $(document).height();
		var windowHeight = $(this).height();
		if (scrollTop + windowHeight == scrollHeight) {
			GetPicturesByPage();
		}
	});

	// 分页获取图片信息
	function GetPicturesByPage() {
		$.ajax({
			type : "get",
			url : "jsonkpi/findPicturesByPage.action",
			data : {
				"pageNo" : pageNo,
				"pageSize" : pageSize
			},
			cache : false,
			dataType : "json",
			success : function(dta) {
				if (!dta.pictureListViews || dta.pictureListViews.length <= 0) {
					alert("已无图片...");
				}
				pageNo++;
				// 获取模板上的HTML
				var phtml = $('script[type="text/template"][id="pictures"]')
						.html();

				// 定义一个数组，用来接收格式化合的数据
				var arr = [];
				// 对数据进行遍历
				$.each(dta.pictureListViews, function(i, o) {
					arr.push(formatTemplate(o, phtml));
				});

				var $items = $(arr.join(''));
				// append items to grid
				$('#waterfall').empty();
				$('#waterfall').append($items)
				// add and lay out newly appended items
				.masonry('appended', $items);
			},
			error : function(dta) {
				alert("图片信息拉取失败...");
			}
		});
	}
	GetPicturesByPage();
});