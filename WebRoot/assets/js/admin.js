// 实例化编辑器
// 建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例

var articleSize = 0;

// 保存简介窗口实例
var bues = new Array();
// 保存详细窗口实例
var ues = new Array();

// 保存提交者以便于新增文章输入框填充
var name = "";
// 保存提交者以便于新增文章输入框填充
var categoryId = "";
// 保存新增文章序号
var addArticleIndex = 0;

var deleteCategoriesId = new Array();

// 加载栏目列表数据
loadCategoriesDatas();

// 加载文章栏目下拉框数据
loadCategoriesSelectsDatas();

// 加载图片列表数据
getPicturesByPage();

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
												+ "<td><input type='text' class='form-control ' value='"
												+ o.addTime
												+ "' ></td>"
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
													+ "<td><input type='button' class='btn btn-info delete-btn' value='删除'/></td><td><input type='button' class='btn btn-info delete-btn' value='修改文章'/></td></tr>";
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

// 加载文章类型栏目下拉选项
function loadCategoriesSelectsDatas() {
	$.ajax({
		type : "get",
		url : "jsonkpi/findArticleCategories.action",
		cache : false,
		dataType : "json",
		success : function(dta) {
			if (!dta.categoryListView || dta.categoryListView.length <= 0) {
				return;
			}
			var innerhtml = "";
			// 对数据进行遍历
			$.each(dta.categoryListView, function(i, o) {
				if (i == 0) {
					innerhtml = innerhtml
							+ "<option selected='selected' value="
							+ o.categoryId + ">" + o.name + "</option>";
					// 加载默认栏目下文章
					loadCategoryArticle(o.categoryId);
				} else {
					innerhtml = innerhtml + "<option value=" + o.categoryId
							+ ">" + o.name + "</option>";
				}
			});
			$("#categoriesSelect").empty();
			$("#categoriesSelect").append(innerhtml);
		},
		error : function(dta) {
			alert("文章类型栏目下拉数据拉取失败...");
		}
	});
}

// 加载指定栏目下文章
function loadCategoryArticle(categoreId) {
	$
			.ajax({
				type : "get",
				url : "jsonkpi/findArticleDetailListByCategoryId.action",
				data : {
					"categoryId" : categoreId
				},
				cache : false,
				dataType : "json",
				success : function(dta) {

					if (!dta.articleViews || dta.articleViews.length <= 0) {
						alert("该栏目下文章为空！");
						return;
					}

					// 重建简介窗口实例
					bues = new Array();
					// 重建详细窗口实例
					ues = new Array();

					name = dta.articleViews[0].userName;
					categoryId = dta.articleViews[0].categoryId;
					var innertext = "";

					$("#articleContent").empty();
					// 对数据进行遍历
					$
							.each(
									dta.articleViews,
									function(i, o) {
										var htmltext = "<div class='row col-md-8 col-md-offset-2' style='margin-top: 30px;'><div class='input-group' style='margin-bottom: 10px;'><div class='input-group-addon'>文章ID</div>"
												+ "<input type='text' class='form-control' name='articleIds' value='"
												+ o.articleId
												+ "' disabled><input type='hidden' name='articleIds' value='"
												+ o.articleId
												+ "'><div class='input-group-addon' disabled>发布者</div>"
												+ "<input type='text' class='form-control' name='userName' value='"
												+ o.userName
												+ "' disabled>"
												+ "</div><div class='input-group' style='margin-bottom: 10px;'>"
												+ "<div class='input-group-addon'>标题</div>"
												+ "<input type='text' class='form-control' name='titles' value='"
												+ o.title
												+ "'>"
												+ "<div class='input-group-addon'>发布时间</div>"
												+ "<input type='text' class='form-control' name='pubTime' value='"
												+ o.pubTime
												+ "' disabled>"
												+ "</div><div class='input-group' style='margin-bottom: 10px;'>"
												+ "<div class='input-group-addon'>类别ID</div>"
												+ "<input type='text' class='form-control' name='categoryIds' value='"
												+ o.categoryId
												+ "' disable>"
												+ "<div class='input-group-addon'>标签</div>"
												+ "<input type='text' class='form-control' name='labels' value='"
												+ o.label
												+ "'>"
												+ "</div>"
												+ "<div class='input-group' style='margin-bottom: 10px;'>"
												+ "<div class='input-group-addon'>标题</div>"
												+ "<input type='text' class='form-control' name='titles' value='"
												+ o.title
												+ "'>"
												+ "<div class='input-group-addon'>发布时间</div>"
												+ "<input type='text' class='form-control' name='pubTime' value='"
												+ o.pubTime
												+ "' disabled>"
												+ "</div><div class='input-group' style='margin-bottom: 10px;'>"
												+ "<div class='checkbox'><label><input type='checkbox' name='delAIds' value='"
												+ o.articleId
												+ "'>是否删除</label></div>"
												+ "</div>"
												+ "</div>"
												+ "<div class='row col-md-8  col-md-offset-2' style='margin-top: 30px;'>"
												+ "文件简介:<script id='brefeditor"
												+ o.categoryId
												+ "-"
												+ i
												+ "' name='brefContents' type='text/plain' style='width:700px;height:250px;'></script>"
												+ "</div><div class='row col-md-8  col-md-offset-2' style='margin-top: 30px;'>文章详细内容:"
												+ "<script id='editor"
												+ o.categoryId
												+ "-"
												+ i
												+ "' name='contents' type='text/plain' style='width:700px;height:250px;'></script></div>";
										innertext = innertext + htmltext;

									});

					// 填充拼装html内容
					$("#articleContent").append(innertext);
					// 对数据进行遍历
					$.each(dta.articleViews, function(i, o) {

						var bue = UE.getEditor("brefeditor" + o.categoryId
								+ "-" + i, {
							// 最大字符限制
							maximumWords : 200
						});
						// 填充文本内容
						bue.ready(function() {
							bue.setContent(o.briefIndc);
						});
						var ue = UE.getEditor(
								"editor" + o.categoryId + "-" + i, {
								// 最大字符限制默认10000
								});
						// 填充文本内容
						ue.ready(function() {
							ue.setContent(o.content);
						});
						bues.push(bue);
						ues.push(ue);
					});
				},
				error : function(dta) {
					alert("获取栏目文章失败...");
				}
			});
}

// 加载栏目下文章
$("#categoriesSelect").change(function() {
	var categoreId = this.value;
	loadCategoryArticle(categoreId);
});

// 绑定栏目新增按钮事件
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
										window.location.reload();
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

// 保存并更新指定栏目下文章
function addAndUpdateCategoryArticles() {
	$.ajax({
		type : "post",
		url : "jsonkpi/addAndUpdateCategoryArticles.action",
		data : $("#articlesForm").serialize(),
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
// 获取图片信息
function getPicturesByPage() {
	$
			.ajax({
				type : "post",
				url : "jsonkpi/findPicturesByPage.action",
				data : {
					"pageNo" : 1,
					"pageSize" : 100
				},
				cache : false,
				dataType : "json",
				success : function(dta) {
					if (!dta.pictureListViews
							|| dta.pictureListViews.length <= 0) {
						alert("已无图片...");
					}
					var innerHtml = "";
					// 对数据进行遍历
					$
							.each(
									dta.pictureListViews,
									function(i, o) {
										innerHtml = innerHtml
												+ "<tr><th scope='row'>"
												+ o.picId
												+ "</th><td>"
												+ o.picName
												+ "</td><td>"
												+ o.picSize
												+ "</td><td>"
												+ o.picType
												+ "</td><td>"
												+ o.pubTime
												+ "</td><td>"
												+ o.userName
												+ "</td><td><img alt='' height='100' width='100' src='"
												+ o.picPath
												+ "'></td><td><div class='checkbox'><label><input type='checkbox' name='delAIds' value='"
												+ o.picId
												+ "'>是否删除</label></td></tr>";
									});
					$('#pictureTbody').empty();
					// append items to grid
					$('#pictureTbody').append(innerHtml);
				},
				error : function(dta) {
					alert("图片信息拉取失败...");
				}
			});
}

// 上传图片
function uploadPic() {
	$.ajaxFileUpload({
		url : "jsonkpi/uploadSpecialRecommendPic.action",
		secureuri : false,
		fileElementId : 'uploadPicfile',
		dataType : 'json',
		success : function(d, status) {
			var data = eval('(' + d + ')');
			if (data.flag == 1) {
				$("#uploadPicShow").attr("src", data.path);
				$("#uploadPicture").val(data.picName);
				alert("上传成功");
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
}

// 提交图片修改
function savePictureForm() {
	$.ajax({
		type : "post",
		url : "jsonkpi/savePictureChange.action",
		data : $("#pictureForm").serialize(),
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
// 绑定新增文章按钮
$("#addCategoryArticle")
		.click(
				function() {
					var htmltext = "<div class='row col-md-8 col-md-offset-2' style='margin-top: 30px;'><div class='input-group' style='margin-bottom: 10px;'><div class='input-group-addon'>文章ID</div>"
							+ "<input type='text' class='form-control' name='articleIds' value='0' disabled><input type='hidden' name='articleIds' value='0'><div class='input-group-addon' disabled>发布者</div>"
							+ "<input type='text' class='form-control' name='userName' value='"
							+ name
							+ "' disabled>"
							+ "</div><div class='input-group' style='margin-bottom: 10px;'>"
							+ "<div class='input-group-addon'>标题</div>"
							+ "<input type='text' class='form-control' name='titles' value='"
							+ "'>"
							+ "<div class='input-group-addon'>发布时间</div>"
							+ "<input type='text' class='form-control' name='pubTime' value='"
							+ "' disabled>"
							+ "</div><div class='input-group' style='margin-bottom: 10px;'>"
							+ "<div class='input-group-addon'>类别ID</div>"
							+ "<input type='text' class='form-control' name='categoryIds' value='"
							+ categoryId
							+ "' disable>"
							+ "<div class='input-group-addon'>标签</div>"
							+ "<input type='text' class='form-control' name='labels' value='"
							+ "'>"
							+ "</div>"
							+ "</div><div class='row col-md-8  col-md-offset-2' style='margin-top: 30px;'>"
							+ "文件简介:<script id='brefeditorAdd"
							+ "-"
							+ addArticleIndex
							+ "' name='brefContents' type='text/plain' style='width:700px;height:250px;'></script>"
							+ "</div><div class='row col-md-8  col-md-offset-2' style='margin-top: 30px;'>文章详细内容:"
							+ "<script id='editorAdd"
							+ "-"
							+ addArticleIndex
							+ "' name='contents' type='text/plain' style='width:700px;height:250px;'></script></div>";

					// 填充拼装html内容
					$("#articleContent").append(htmltext);

					// 初始化输入框
					var bue = UE.getEditor("brefeditorAdd" + "-"
							+ addArticleIndex, {
						// 最大字符限制
						maximumWords : 200
					});
					var ue = UE.getEditor("editorAdd" + "-" + addArticleIndex,
							{
							// 最大字符限制默认10000
							});
					bues.push(bue);
					ues.push(ue);
					addArticleIndex++;
				});
