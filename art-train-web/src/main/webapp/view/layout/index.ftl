<html>
<head>
<title>仲艺文化艺术培训中心管理系统</title>
<script type="text/javascript">
	//设置登录窗口
	function openPwd() {
		$('#w').window({
			title : '修改密码',
			width : 300,
			modal : true,
			shadow : true,
			closed : true,
			height : 160,
			resizable : false
		});
	}

	//关闭登录窗口
	function closePwd() {
		$('#w').window('close');
	}

	//修改密码
	function serverLogin() {
		var $newpass = $('#txtNewPass');
		var $rePass = $('#txtRePass');

		if ($newpass.val() == '') {
			msgShow('系统提示', '请输入密码！', 'warning');
			return false;
		}
		if ($rePass.val() == '') {
			msgShow('系统提示', '请在一次输入密码！', 'warning');
			return false;
		}

		if ($newpass.val() != $rePass.val()) {
			msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
			return false;
		}

		$.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(
				msg) {
			msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
			$newpass.val('');
			$rePass.val('');
			close();
		})

	}

    $(function() {

        var treeMenu = loadTreeMenuData();

        //$('#helloTips').html(getHelloTips());

        $('#tt').tree({
            data: treeMenu,
            lines:false,
            onClick : function (node) {
                if (node.attributes) {
                    Open(node);
                }
            }

        });

		openPwd();

		$('#editpass').click(function() {
			$('#w').window('open');
		});

		$('#btnEp').click(function() {
			serverLogin();
		})

		$('#btnCancel').click(function() {
			closePwd();
		})

		$('#loginOut').click(function() {
			$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

				if (r) {
					location.href = '/ajax/loginout.ashx';
				}
			});
		})
	});

    function loadTreeMenuData(){
        var data = SHOPMSG.ajax('/menu/listMenuInfos.html',{id:0});

        return data;
    }
</script>

</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
	<noscript>
		<div
			style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px; width: 100%; background: white; text-align: center;">
			<img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
	<div region="north" split="true" border="false" class="header">
		<%--<span style="float:right;padding-right:20px;padding-top: 12px;" class="head">欢迎
			admin <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a>
		</span> --%>
		<span style="padding-left: 10px; font-size: 16px;">
			<div class="toptitle">仲艺文化艺术培训中心管理系统</div>
		</span>
        <%--  <span style="float:right;padding-right:20px;padding-top: 12px;">
			<div class="head"><span id="helloTips"></span></div>
		</span>--%>
	</div>
	<div region="west" hide="true" split="true" title="导航菜单"
		style="width: 180px;" id="west">
		<div id="nav" class="easyui-accordion" fit="true" border="false">
			<!--  tree导航内容 -->
            <ul id="tt"></ul>
        </div>
	</div>
	<div id="mainPanle" region="center"
		style="background: #eee; overflow-y: hidden">
		<div id="tabs" class="easyui-tabs" fit="true" border="true">
			<div title="首页" style="padding: 20px; overflow: hidden; color: #da0000;">
				<h1 style="font-size: 24px;">* 欢迎使用仲艺文化艺术培训管理系统</h1>
			</div>
		</div>
	</div>


	<!--修改密码窗口-->
	<div id="w" class="easyui-window" title="修改密码" collapsible="false"
		minimizable="false" maximizable="false" icon="icon-save"
		style="width: 300px; height: 150px; padding: 5px; background: #fafafa;display: none">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<table cellpadding=3>
					<tr>
						<td>新密码：</td>
						<td><input id="txtNewPass" type="Password" class="txt01" /></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input id="txtRePass" type="Password" class="txt01" /></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false"
				style="text-align: right; height: 30px; line-height: 30px;">
				<a id="btnEp" class="easyui-linkbutton" icon="icon-ok"
					href="javascript:void(0)"> 确定</a> <a id="btnCancel"
					class="easyui-linkbutton" icon="icon-cancel"
					href="javascript:void(0)">取消</a>
			</div>
		</div>
	</div>

    <div id="tabsMenu" class="easyui-menu" style="width:120px;">
        <div id="mm-tabupdate">刷新</div>
        <div name="close">关闭</div>
        <div name="Other">关闭其他</div>
        <div name="All">关闭所有</div>
    </div>
</body>
</html>