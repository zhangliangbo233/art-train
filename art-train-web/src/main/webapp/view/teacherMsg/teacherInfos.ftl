<html>
	<head>
		<title>仲艺文化艺术培训中心管理系统</title>
		<style type="text/css">
	        #fm
	        {
	            margin: 0;
	            padding: 5px 15px;
	        }
	        .fitem
	        {
	            margin-bottom: 5px;
	        }
	        .fitem label
	        {
	            display: inline-block;
	            width: 80px;
	        }
    	</style>
	</head>
	
	<body class="easyui-layout" style="overflow-y: hidden" id="fm">
		<div style="margin:10px 0">
		</div>
		<table id="tt" toolbar="#tb"></table>
		<!-- toolbar -->
		<div id="tb" style="padding:5px;height:auto">
			<div style="margin-bottom:5px">
                <a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true"  onclick="reloadList()">刷新</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"  onclick="showAddDialog()">添加</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="showEditedInfo()">编辑</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"onclick="deleteTeacherInfo()">删除</a>
			</div>
			<div>
				入职时间: <input class="easyui-datebox" style="width:120px" id="startTime">
				-<input class="easyui-datebox" style="width:120px" id="endTime">
				姓名: 
				<input class="easyui-validatebox" style="width:150px" id="teacherName">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()">搜索</a>
			</div>
		</div>
		<!-- 添加修改信息弹出框 -->
		<div id="saveDialog" class="easyui-dialog" style="width:380px;padding:10px 20px;" title="添加老师信息" closed="true" buttons="#saveButtons"> 
	       <div class="fitem"> 
	           <label>姓名</label> 
	           <input id="name" type="text" class="easyui-validatebox" data-options="required:true,validType:'length[2,6]'" 
	           			 missingMessage="姓名必须填写" invalidMessage="姓名长度为2-6位字符"/> 
	       </div> 
	       <div class="fitem"> 
	           <label>年龄</label> 
	           <input id="age" class="easyui-validatebox"/> 
	       </div> 
	       <div class="fitem"> 
	           <label>联系电话</label> 
	           <input id="contactMobile" class="easyui-validatebox" data-options="required:true,validType:'length[11,11]'" 
	           			missingMessage="联系电话必须填写" invalidMessage="联系电话为11的手机号码"/> 
	       </div>
	       <div class="fitem"> 
	           <label>入职时间</label> 
	           <input id= "assumeTime" class="easyui-datetimebox"/>
	       </div> 
	       <div class="fitem"> 
	           <label>工资/月</label> 
	           <input id="salary" class="easyui-validatebox" data-options="required:true,validType:'length[1,6]'" 
	           		missingMessage="工资必须填写" invalidMessage="授课老师长度为1-6位字符"/> 
	       </div> 
	   </div>
	   <div id="saveButtons"> 
	        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveTeacherInfo()" iconcls="icon-save">保存</a> 
	        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#saveDialog').dialog('close')" iconcls="icon-cancel">取消</a> 
	   </div> 
	</body>
	<script type="text/javascript">
		var result="";
		var queryParams = {};
		var selectedRow;
		var teacherInfo=null;
		
		$().ready(function(){
            joinQueryParams();
   			createTable();
   		});
   		
   		function createTable(){
   			$('#tt').datagrid({
   				iconCls:'icon-edit',
   				width:'auto',  
                height:'auto',
   				singleSelect:true,
   				idField:'studentId',
   				url:'${ctx}/teacher/listTeacherInfos.html',
   				queryParams:queryParams,
   				loadMsg:'数据加载中请稍后……',
   				pagination: true,
	   			fit: false, //datagrid自适应宽度
	            fitColumn: true, //列自适应宽度
	            nowap: true, //列内容多时自动折至第二行
   				rownumbers: true,
   				onLoadSuccess:function(data){
	   				if(!data.rows.length){
	                 	var body = $(this).data().datagrid.dc.body2;
	                 	body.find('table tbody').append('<tr><td width="' + body.width() + '" style="height:25px;text-align:center;color:red;">没有数据</td></tr>');
	                }
   				}, 
   				columns:[[
   					{field:'name',title:'姓名',align:'center',width:210},
   					{field:'age',title:'年龄',align:'center',width:210,editor:'text'},
   					{field:'contactMobile',title:'联系电话',align:'center',width:210,editor:'text'},
   					{field:'assumeTime',title:'入职时间',align:'center',width:210,editor:'text'},
   					{field:'salary',title:'工资/月',align:'center',width:210,editor:'text'}
   				]]
   			});
   			displayPageMsg();
   		}
   		
   		function displayPageMsg() {//自定义分页显示
   		    $('#tt').datagrid('getPager').pagination({
   		       pageSize:10,
   			   pageList: [10, 20, 30, 50], //页大小下拉选项此项各value是pageSize的倍数
   		       beforePageText: '第',           
               afterPageText: '页    共 {pages} 页',
   		       displayMsg : '当前显示从{from}到{to}，共{total}条记录'
   		    });
   		}
   		
	   	function showAddDialog() {
	         $("#saveDialog").dialog("open");
	         $("#name,#age","#contactMobile","#assumeTime","#salary").val('');
	         $("#name,#contactMobile,#salary").addClass('validatebox-invalid');
	         $("#assumeTime").datebox("setValue","");
	     }
	   	
	   	function saveTeacherInfo() {
	   		var name = $('#name').val();
	   		var age = $('#age').val();  
	   		var contactMobile = $('#contactMobile').val();
	   		var assumeTime = $("#assumeTime").datebox("getValue");
	   		var salary = $('#salary').val();
	   		var teacherInfoId = teacherInfo==null?0:teacherInfo.id;
	   		
	   		if(!checkBeforeSave(name,contactMobile,salary)){
	   			return;
	   		}
	   		var paramJson='{teacherInfoId:'+teacherInfoId+',name:\''+name+'\',age:\''+age+'\',contactMobile:\''+contactMobile+'\',assumeTime:\''+assumeTime+'\',salary:\''+salary+'\'}';
	   		result = SHOPMSG.ajax('${ctx}/teacher/saveTeacherInfo.html',{paramJson:paramJson});
	   		if(result.success){
	   			SHOPMSG.showMessage('成功提示',result.message,'info');
	   			$("#saveDialog").dialog("close");
	   			$('#tt').datagrid('reload');
	   		}else{
	   			SHOPMSG.showMessage('错误提示',result.message,'error');
	   		}
	    }
	   	
	   	function checkBeforeSave(name,contactMobile,salary){
	   		var returnFlag = false;
	   		if(SHOPMSG.isEmpty(name)){
	   			SHOPMSG.showMessage('警告提示','姓名必须填写','warning');
	   			return false;
	   		}
	   		if(SHOPMSG.isEmpty(contactMobile)){
	   			SHOPMSG.showMessage('警告提示','联系电话必须填写','warning');
	   			return false;
	   		}
	   		if(SHOPMSG.isEmpty(salary)){
	   			SHOPMSG.showMessage('警告提示','工资必须填写','warning');
	   			return false;
	   		}
	   		return true;
	   	}
	   	
	   	function deleteTeacherInfo() {
            if(!showDeleteOrEditMsg('删除')) return;
            $.messager.confirm('确认提示', '确定要删除选中的信息吗?', function (r) {
            	if(!r){
            		return;
            	}
            	result = SHOPMSG.ajax('${ctx}/teacher/deleteTeacherInfo.html', {id:selectedRow.id});
                if(result.success){
    	   			$('#tt').datagrid('reload');
    	   		}else{
    	   			SHOPMSG.showMessage('错误提示',result.message,'error');
    	   		}
            });
        } 
	   	
	   	function showDeleteOrEditMsg(msg){
	   		 selectedRow = $('#tt').datagrid('getSelected');
	         if(!selectedRow){
	         	SHOPMSG.showMessage('警告提示','请选择要'+msg+'的信息','warning');
	         	return false;
	         }
	         return true;
	   	}
	   	
	   	function showEditedInfo(){
	   		if(!showDeleteOrEditMsg('编辑')) return;
	   		result = SHOPMSG.ajax('${ctx}/teacher/loadTeacherInfo.html', {id:selectedRow.id});
	   		if(!result.success){
	   			SHOPMSG.showMessage('错误提示',result.message,'error');
	   			return;
	   		}
	   		$("#saveDialog").dialog("open");
	   	 	$("#name,#contactMobile,#salary").removeClass('validatebox-invalid');
	   		
	   		teacherInfo = result.data;
		    $("#name").val(teacherInfo.name);
	        $("#age").val(teacherInfo.age);
	        $("#contactMobile").val(teacherInfo.contactMobile);
	        $("#assumeTime").datebox("setValue",teacherInfo.assumeTime);
	        $("#salary").val(teacherInfo.salary);
	   	}
	   	
	   	
	   	function searchInfo(){
            joinQueryParams();
	   		createTable();
	   	}

        function joinQueryParams(){
            var startTime = $("#startTime").datebox("getValue");
            var endTime = $("#endTime").datebox("getValue");
            var teacherName = $('#teacherName').val();

            var param='{startTime:\''+startTime+'\',endTime:\''+endTime+'\',teacherName:\''+teacherName+'\'}';
            queryParams = {teacherInfoListParam:param};
        }

        function reloadList(){
            createTable();
        }
	  </script>
</html>