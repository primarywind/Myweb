// 内容格式化模板方法
function formatTemplate(dta, tmpl) {
    var format = {
        name: function (x) {
            return x;
        }
    };
    return tmpl.replace(/{(\w+)}/g, function (m1, m2) {
        if (!m2)
            return "";
        return (format && format[m2]) ? format[m2](dta[m2]) : dta[m2];
    });
}

var totalSize = 0;
// 页码
var pageNo = 1;
// 一页条数
var pageSize = 10;
// 默认按时间倒序
var orderType = 2;
// 热门用户数
var hotUserSize = 10;
// 分页获取话题信息
function findSendCardsByPage(currentOrderType, currentPageNo) {
    pageNo = currentPageNo;
    orderType = currentOrderType;
    $
        .ajax({
            type: "get",
            url: "jsonkpi/findSendCardsByPage.action",
            data: {
                "pageNo": currentPageNo,
                "pageSize": pageSize,
                "orderType": currentOrderType
            },
            cache: false,
            dataType: "json",
            success: function (dta) {
                if (!dta.sendCardListViews
                    || dta.sendCardListViews.length <= 0) {
                    alert("已无新话题...");
                }
                totalSize = dta.totalSize;
                //初始化分页列表
                $("#discussPaginationId").empty();
                gotoPrevious
                var pageHtml = "<li><a href='javascript:gotoPrevious(" + orderType + "," + (pageNo - 1) + ");'><</a></li>";
                for (var i = 0; i < totalSize / pageSize; i++) {
                    if (pageNo - 1 == i) {
                        pageHtml = pageHtml + "<li class='active'><a href='javascript:findSendCardsByPage(" + orderType + "," + (i + 1) + ");'>" + (i + 1) + "</a> </li>";
                    } else {
                        pageHtml = pageHtml + "<li><a href='javascript:findSendCardsByPage(" + orderType + "," + (i + 1) + ");'>" + (i + 1) + "</a> </li>";
                    }
                }
                pageHtml = pageHtml + "<li><a href='javascript:gotoNext(" + orderType + "," + (pageNo + 1) + ");'>></a> </li>";
                $("#discussPaginationId").append(pageHtml);

                // 清空内容
                $("#aw-common-list").empty();
                // 获取模板上的HTML
                var phtml = $('script[type="text/template"][id="sendCard"]')
                    .html();

                // 定义一个数组，用来接收格式化合的数据
                var arr = [];
                // 对数据进行遍历
                $.each(dta.sendCardListViews, function (i, o) {
                    arr.push(formatTemplate(o, phtml));
                });

                var $items = $(arr.join(''));
                // append items to grid
                $('#aw-common-list').append($items);
            },
            error: function (dta) {
                alert("话题列表信息拉取失败...");
            }
        });
}

function findHotUser(hotUserSize) {
    $
        .ajax({
            type: "get",
            url: "jsonkpi/findHotUsers.action",
            data: {
                "hotUserSize": hotUserSize
            },
            cache: false,
            dataType: "json",
            success: function (dta) {
                if (!dta.hotUserViewList
                    || dta.hotUserViewList.length <= 0) {
                    alert("热门用户数据拉取失败...");
                }
                // 清空内容
                $("#hotUser").empty();
                // 获取模板上的HTML
                var phtml = $('script[type="text/template"][id="hotUserListId"]')
                    .html();

                // 定义一个数组，用来接收格式化合的数据
                var arr = [];
                // 对数据进行遍历
                $.each(dta.hotUserViewList, function (i, o) {
                    arr.push(formatTemplate(o, phtml));
                });

                var $items = $(arr.join(''));
                // append items to grid
                $('#hotUser').append($items)
            },
            error: function (dta) {
                alert("话题列表信息拉取失败...");
            }
        });
}
function gotoNext(orderType, nextPageNo) {
    if (nextPageNo > ((totalSize / pageSize) + 1)) {
        alert("无下一页");
    } else {
        findSendCardsByPage(orderType, nextPageNo);
    }
}

function gotoPrevious(orderType, previousPageNo) {
    if (previousPageNo < ((totalSize / pageSize) - 1)) {
        alert("无上一页");
    } else {
        findSendCardsByPage(orderType, previousPageNo);
    }
}
// 执行数据初始化
findSendCardsByPage(orderType, pageNo);
findHotUser(hotUserSize);
