var SHOPMSG = {};

SHOPMSG.ajax = function (url, param) {
    var msg = null;
    $.ajax({
        type: "POST",
        url: url,
        async: false,
        data: param,
        timeout: 5000,
        success: function (data) {
            //$.messager.alert('成功提示','恭喜，操作成功','info');
            msg = data;
        },
        error: function (data) {
            $.messager.alert('错误提示', '服务器调用出错，请稍候重试!', 'error');
        }
    });
    return msg;
}

SHOPMSG.isEmpty = function (msg) {
    return !/.+/.test(msg);
}

SHOPMSG.showMessage = function (tip, message, type) {
    $.messager.alert(tip, message, type);
}

$(function () {
    //tabClose();
    //tabCloseEven();
    fireContextMenu();
    /*$('#tabs').tabs('add',{
     title:'疯狂秀才',
     content:createFrame('http://hxling.cnblogs.com')
     }).tabs({
     onSelect: function (title) {
     var currTab = $('#tabs').tabs('getTab', title);
     var iframe = $(currTab.panel('options').content);

     var src = iframe.attr('src');
     if(src)
     $('#tabs').tabs('update', { tab: currTab, options: { content: createFrame(src)} });

     }
     });*/

})

//在右边center区域打开菜单，新增tab
function Open(node) {
    if ($("#tabs").tabs('exists', node.text)) {
        $('#tabs').tabs('select', node.text);
    } else {
        $('#tabs').tabs('add', {
            title: node.text,
            closable: true,
            content: createFrame(node.attributes.url),
            iconCls: node.iconCls
        });
    }
}

function createFrame(url) {
    var s = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
    return s;
}

//绑定tabs的右键菜单
function fireContextMenu() {
    $("#tabs").tabs({
        onContextMenu: function (e, title) {
            e.preventDefault();
            $('#tabsMenu').menu('show', {
                left: e.pageX,
                top: e.pageY
            }).data("tabTitle", title);
        }
    });

    $("#tabsMenu").menu({
        onClick: function (item) {
            CloseTab(this, item.name);
        }
    });
}

function tabClose() {
    /*双击关闭TAB选项卡*/
    $(".tabs-inner").dblclick(function () {
        var subtitle = $(this).children(".tabs-closable").text();
        $('#tabs').tabs('close', subtitle);
    })
    /*为选项卡绑定右键*/
    $(".tabs-inner").bind('contextmenu', function (e) {
        $('#mm').menu('show', {
            left: e.pageX,
            top: e.pageY
        });

        var subtitle = $(this).children(".tabs-closable").text();

        $('#mm').data("currtab", subtitle);
        $('#tabs').tabs('select', subtitle);
        return false;
    });
}
//绑定右键菜单事件
function tabCloseEven() {
    //刷新
    $('#mm-tabupdate').click(function () {
        var currTab = $('#tabs').tabs('getSelected');
        var url = $(currTab.panel('options').content).attr('src');
        $('#tabs').tabs('update', {
            tab: currTab,
            options: {
                content: createFrame(url)
            }
        })
    })
    //关闭当前
    $('#mm-tabclose').click(function () {
        var currtab_title = $('#tabs').tabs('getSelected');
        alert(currtab_title.data('currtab'));
        //var currtab_title = $('#mm').data("currtab");
        $('#tabs').tabs('close', currtab_title);
    })
    //全部关闭
    $('#mm-tabcloseall').click(function () {
        $('.tabs-inner span').each(function (i, n) {
            var t = $(n).text();
            $('#tabs').tabs('close', t);
        });
    });
    //关闭除当前之外的TAB
    $('#mm-tabcloseother').click(function () {
        $('#mm-tabcloseright').click();
        $('#mm-tabcloseleft').click();
    });
    //关闭当前右侧的TAB
    $('#mm-tabcloseright').click(function () {
        var nextall = $('.tabs-selected').nextAll();
        if (nextall.length == 0) {
            //msgShow('系统提示','后边没有啦~~','error');
            alert('后边没有啦~~');
            return false;
        }
        nextall.each(function (i, n) {
            var t = $('a:eq(0) span', $(n)).text();
            $('#tabs').tabs('close', t);
        });
        return false;
    });
    //关闭当前左侧的TAB
    $('#mm-tabcloseleft').click(function () {
        var prevall = $('.tabs-selected').prevAll();
        if (prevall.length == 0) {
            alert('到头了，前边没有啦~~');
            return false;
        }
        prevall.each(function (i, n) {
            var t = $('a:eq(0) span', $(n)).text();
            $('#tabs').tabs('close', t);
        });
        return false;
    });

    //退出
    $("#mm-exit").click(function () {
        $('#mm').menu('hide');
    })
}

//几个关闭事件的实现
function CloseTab(menu, type) {
    var curTabTitle = $(menu).data("tabTitle");
    var tabs = $("#tabs");

    if (type === "close") {
        tabs.tabs("close", curTabTitle);
        return;
    }

    var allTabs = tabs.tabs("tabs");
    var closeTabsTitle = [];

    //刷新
    $('#mm-tabupdate').click(function () {
        var currTab = $('#tabs').tabs('getSelected');
        var url = $(currTab.panel('options').content).attr('src');
        $('#tabs').tabs('update', {
            tab: currTab,
            options: {
                content: createFrame(url)
            }
        })
    })

    $.each(allTabs, function () {
        var opt = $(this).panel("options");
        if (opt.closable && opt.title != curTabTitle && type === "Other") {
            closeTabsTitle.push(opt.title);
        } else if (opt.closable && type === "All") {
            closeTabsTitle.push(opt.title);
        }
    });

    for (var i = 0; i < closeTabsTitle.length; i++) {
        tabs.tabs("close", closeTabsTitle[i]);
    }
}


function getHelloTips() {
    var now = new Date();
    var hour = now.getHours();
    var helloTips = "";
    if (hour < 6) {
        helloTips = "凌晨好！";
    }
    else if (hour < 9) {
        helloTips = "早上好！";
    }
    else if (hour < 12) {
        helloTips = "上午好！";
    }
    else if (hour < 14) {
        helloTips = "中午好！";
    }
    else if (hour < 17) {
        helloTips = "下午好！";
    }
    else if (hour < 19) {
        helloTips = "傍晚好！";
    }
    else if (hour < 22) {
        helloTips = "晚上好！";
        document.write("晚上好！")
    }
    else {
        helloTips = "夜里好！";
    }
    return helloTips;
}
//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
    $.messager.alert(title, msgString, msgType);
}