// 实例化编辑器
// 建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
var ue = UE.getEditor('editor');
var deleteCategoriesId = new Array();
loadCategoriesDatas();

// 加载栏目数据
function loadCategoriesDatas() {
	$
			.ajax({
				type : "get",
				url : "jsonkpi/findAllCategories.action",
				cache : false,
				dataType : "json",
				success : function(dta) {
					if (!dta.categoryListView
							|| dta.categoryListView.length <= 0) {
						alert("栏目数据为空");
					}
					var innerHtml = "";
					// 对数据进行遍历
					$
							.each(
									dta.categoryListView,
									function(i, o) {
										var htmltext = "<tr class='columns' name='categoryId'>"
												+ "<td><input type='text'value='"
												+ o.categoryId
												+ "' class='form-control' required disabled>"
												+ "<input type='hidden'value='"
												+ o.categoryId
												+ "' name='cId'></td>"
												+ "<td><input type='text' name='cName' class='form-control' required value='"
												+ o.name
												+ "'></td>"
												+ "<td><input type='text' class='form-control' value='"
												+ o.addTime
												+ "' disabled></td>"
												+ "<td><input type='text' name='cHref' class='form-control' value='"
												+ o.chref
												+ "'></td>"
												+ "<td><input type='text' name='CIndex' class='form-control' required value='"
												+ o.CIndex + "'></td>";
										if (o.ifview == 1) {
											htmltext += "<td><select name='cifView' class='form-control'><option selected='selected' value='1'>可见</option><option value='0'>不可见</option></select></td>"
													+ "<td><input type='button' class='btn btn-info delete-btn' value='删除'/></td></tr>";
										} else {
											htmltext += "<td><select name='cifView' class='form-control'><option  value='1'>可见</option><option selected='selected' value='0'>不可见</option></select></td>"
													+ "<td><input type='button' class='btn btn-info delete-btn' value='删除'/></td></tr>";
										}
										innerHtml += htmltext;
									});
					// 把数组化成字符串，并添加到table中去。
					$('#caTbody').append(innerHtml);
					$(".delete-btn")
							.click(
									function() {
										var delCId = $(this).parent().parent()
												.children("td").children(
														"input")[1].value;
										// 异步删除栏目
										// 1.栏目下存在文章则无法删除
										// 2.栏目下空文章则进行删除
										$
												.ajax({
													type : "get",
													url : "jsonkpi/deleteCategory.action",
													data : {
														"delCId" : delCId
													},
													cache : false,
													dataType : "json",
													success : function(dta) {
														$(this).parent()
																.parent()
																.remove();
														alert(dta.msg);
													},
													error : function(dta) {
														alert("系统错误...");
													}
												});

									});
				},
				error : function(dta) {
					alert("栏目拉取失败...");
				}
			});
}

// 绑定新增按钮事件
$("#addCategory")
		.click(
				function() {
					var innerhtml = "<tr class='columns'>"
							+ "<td><input type='text' value='?' name='cId' class='form-control' required disabled><input type='hidden' value='?' name='cId'></td>"
							+ "<td><input type='text' name='cName' required class='form-control'></td>"
							+ "<td><input type='text' class='form-control' disabled></td>"
							+ "<td><input type='text' name='cHref' class='form-control''></td><td><input type='text' name='CIndex' class='form-control'></td><td><select name='cifView' class='form-control'><option selected='selected' value='1'>可见</option><option value='0'>不可见</option></select></td>"
							+ "<td><input type='button' class='btn btn-info delete-btn' value='删除'/></td></tr>";
					$('#caTbody').append(innerhtml);
					$(".delete-btn").click(
							function() {
								var delCId = $(this).parent().parent()
										.children("td")[0].innerHTML;
								// 异步删除栏目
								// 1.栏目下存在文章则无法删除
								// 2.栏目下空文章则进行删除
								$.ajax({
									type : "get",
									url : "jsonkpi/deleteCategory.action",
									data : {
										"delCId" : delCId
									},
									cache : false,
									dataType : "json",
									success : function(dta) {
										$(this).parent().parent().remove();
										alert(dta.msg);
									},
									error : function(dta) {
										alert("系统错误...");
									}
								});

							});
				});

// 保存栏目数据
function addAndUpdateCategories() {
	$.ajax({
		type : "post",
		url : "jsonkpi/addAndUpdateCategories.action",
		data : $("#categoriesForm").serialize(),
		cache : false,
		dataType : "json",
		success : function(dta) {
			alert(dta.msg);
			return;
		},
		error : function(dta) {
			alert("保存失败...");
		}
	});
}
