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
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"  onclick="showAddStudentDialog()">添加</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="showEditedInfo()">编辑</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"onclick="deleteStudentSignInfo()">删除</a>
			</div>
			<div>
				报名时间: <input class="easyui-datebox" style="width:120px" id="startTime">
				- <input class="easyui-datebox" style="width:120px" id="endTime">
				姓名: 
				<input class="easyui-validatebox" style="width:100px" id="studentName">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()">搜索</a>
			</div>
		</div>
		<!-- 添加信息弹出框 -->
		<div id="saveDialog" class="easyui-dialog" style="width:380px;padding:10px 20px;" closed="true" buttons="#saveButtons"> 
	       <div class="fitem"> 
	           <label>姓名</label> 
	           <input id="name" type="text" class="easyui-validatebox" data-options="required:true,validType:'length[2,6]'" 
	           			 missingMessage="姓名必须填写" invalidMessage="姓名长度为2-6位字符"/> 
	       </div> 
	       <div class="fitem"> 
	           <label>年龄</label> 
	           <input id="age" class="easyui-validatebox" data-options="required:true,validType:'length[1,3]'"
	           		missingMessage="年龄必须填写" invalidMessage="年龄为1-100的整数"/> 
	       </div> 
	       <div class="fitem"> 
	           <label>出生年月</label> 
	           <input id= "birthday" class="easyui-datebox" data-options="required:true" missingMessage="出生年月必须填写"/> 
	       </div> 
	       <div class="fitem"> 
	           <label>家庭住址</label> 
	           <input id="address" class="easyui-vlidatebox" /> 
	       </div> 
	       <div class="fitem"> 
	           <label>联系人</label> 
	           <input id="contactPerson" class="easyui-validatebox" data-options="required:true,validType:'length[2,6]'" 
	           		missingMessage="联系人必须填写" invalidMessage="联系人长度为2-6位字符"/> 
	       </div> 
	       <div class="fitem"> 
	           <label>联系电话</label> 
	           <input id="contactMobile" class="easyui-validatebox" data-options="required:true,validType:'length[11,11]'" 
	           			missingMessage="联系电话必须填写" invalidMessage="联系电话为11的手机号码"/> 
	       </div>
	       <div class="fitem"> 
	           <label>就读学校</label> 
	           <input id="school" class="easyui-validatebox"/> 
	       </div>  
	       <div class="fitem"> 
	           <label>年级</label> 
	           <input id="level" class="easyui-validatebox"/> 
	       </div>
	       <div class="fitem"> 
	           <label>报名课程</label> 
	           <%--<input id="signCourseName" class="easyui-validatebox" data-options="required:true" missingMessage="报名课程必须填写"/>--%>
               <select id="signCourseName" name="dept" style="width:158px;"></select>
	       </div>
	       <div class="fitem"> 
	           <label>报名费用</label> 
	           <input id="signExpense" class="easyui-validatebox" data-options="required:true" missingMessage="报名费用必须填写"/>
	       </div>   
	   </div>
	   <div id="saveButtons"> 
	        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveStudentSignInfo()" iconcls="icon-save">保存</a> 
	        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#saveDialog').dialog('close')" iconcls="icon-cancel">取消</a> 
	   </div> 
	</body>
	<script type="text/javascript">
		var result="";
		var queryParams={};
		var selectedRow;
		var signView=null;
		
		$().ready(function(){
            loadCourseInfo();
   			createTable();
   		});
   		
   		function createTable(){
   			$('#tt').datagrid({
   				iconCls:'icon-edit',
   				width:'auto',  
                height:'auto',
   				singleSelect:true,
   				idField:'studentId',
   				url:'${ctx}/studentMsg/listStudentSignInfos.html',
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
   					/* {field:'studentId',title:'学生Id',width:60}, */
   					{field:'studentName',title:'学生姓名',align:'center',width:60},
   					{field:'signTime',title:'报名时间',align:'center',width:180,editor:'text'},
   					{field:'signExpense',title:'报名费用(元)',align:'center',width:150,editor:'text'},
   					{field:'signCourseName',title:'报名课程',align:'center',width:180,editor:'text'},
   					{field:'school',title:'就读学校',align:'center',width:180,editor:'text'},
   					{field:'contactPerson',title:'联系人',align:'center',width:180,editor:'text'},
   					{field:'contactMobile',title:'联系电话',align:'center',width:180,editor:'text'}
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
   		
	   	function showAddStudentDialog() {
	         $("#saveDialog").dialog("open").dialog('setTitle','添加学生信息');
	         $("#name,#age,#address,#contactPerson,#contactMobile,#school,#level,#signCourseName,#signExpense").val('');
	         $("#name,#age,#birthday,#contactPerson,#contactMobile,#signCourseName,#signExpense").addClass('validatebox-invalid');
	         $("#birthday").datebox("setValue","");
	     }
	   	
	   	function saveStudentSignInfo() {
	   		var name = $('#name').val();
	   		var age = $('#age').val();  
	   		var birthday = $("#birthday").datebox("getValue");  
	   		var address = $('#address').val();
	   		var contactPerson = $('#contactPerson').val();
	   		var contactMobile = $('#contactMobile').val();
	   		var school = $('#school').val();
	   		var level = $('#level').val();
	   		//var signCourseName = $('#signCourseName').val();
	   		var signExpense = $('#signExpense').val();
	   		var signId = signView==null?0:signView.id;
	   		var studentId = signView==null?0:signView.studentId;

            var selectedRow = $('#signCourseName').combogrid('grid').datagrid('getSelected');//获取选中的select

            if(!checkBeforeSave(name,age,birthday,contactPerson,contactMobile,selectedRow,signExpense)){
                return;
            }

            var signCourseName = selectedRow.courseName;
            var signCourseId = selectedRow.id;

	   		var paramJson='{name:\''+name+'\',age:'+age+',birthday:\''+birthday+'\',address:\''+address+'\',contactPerson:\''+contactPerson
	   			+'\',contactMobile:\''+contactMobile+'\',school:\''+school+'\',level:\''+level+'\',signCourseName:\''+signCourseName
	   			+'\',signExpense:\''+signExpense+'\',signId:\''+signId+'\',studentId:\''+studentId+'\',signCourseId:\''+signCourseId+'\'}';
	   		result = SHOPMSG.ajax('${ctx}/studentMsg/saveStudentSign.html',{paramJson:paramJson});
	   		if(result.success){
	   			SHOPMSG.showMessage('成功提示',result.message,'info');
	   			$("#saveDialog").dialog("close");
	   			$('#tt').datagrid('reload');
	   		}else{
	   			SHOPMSG.showMessage('错误提示',result.message,'error');
	   		}
	    }
	   	
	   	function checkBeforeSave(name,age,birthday,contactPerson,contactMobile,selectedRow,signExpense){
	   		var returnFlag = false;
	   		if(SHOPMSG.isEmpty(name)){
	   			SHOPMSG.showMessage('警告提示','姓名必须填写','warning');
	   			return false;
	   		}
	   		if(SHOPMSG.isEmpty(age)){
	   			SHOPMSG.showMessage('警告提示','年龄必须填写','warning');
	   			return false;
	   		}
	   		if(SHOPMSG.isEmpty(birthday)){
	   			SHOPMSG.showMessage('警告提示','出生年月必须填写','warning');
	   			return false;
	   		}
	   		if(SHOPMSG.isEmpty(contactPerson)){
	   			SHOPMSG.showMessage('警告提示','联系人必须填写','warning');
	   			return false;
	   		}
	   		if(SHOPMSG.isEmpty(contactMobile)){
	   			SHOPMSG.showMessage('警告提示','联系电话必须填写','warning');
	   			return false;
	   		}
	   		if(null == selectedRow || SHOPMSG.isEmpty(selectedRow)){
	   			SHOPMSG.showMessage('警告提示','报名课程必须填写','warning');
	   			return false;
	   		}
	   		if(SHOPMSG.isEmpty(signExpense)){
	   			SHOPMSG.showMessage('警告提示','报名费用必须填写','warning');
	   			return false;
	   		}
	   		return true;
	   	}
	   	
	   	function deleteStudentSignInfo() {
            if(!showDeleteOrEditMsg('删除')) return;
            $.messager.confirm('确认提示', '确定要删除选中的信息吗?', function (r) {
            	if(!r){
            		return;
            	}
            	result = SHOPMSG.ajax('${ctx}/studentMsg/deleteStudentSign.html', {id:selectedRow.id});
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
	   		result = SHOPMSG.ajax('${ctx}/studentMsg/loadStudentSign.html', {id:selectedRow.id});
	   		if(!result.success){
	   			SHOPMSG.showMessage('错误提示',result.message,'error');
	   			return;
	   		}
	   		$("#saveDialog").dialog("open").dialog('setTitle','编辑学生信息');
	   		$("#name,#age,#address,#birthday,#contactPerson,#contactMobile,#school,#level,#signCourseName,#signExpense").removeClass('validatebox-invalid');
	   		
	   		signView = result.data;
		    $("#name").val(signView.studentName);
	        $("#age").val(signView.age);
	        $("#birthday").datebox("setValue",signView.birthday);
	        $("#address").val(signView.address);
	        $("#contactPerson").val(signView.contactPerson);
	        $("#contactMobile").val(signView.contactMobile);
	        $("#school").val(signView.school);
	        $("#level").val(signView.level);
	        $("#signCourseName").val(signView.signCourseName);
	        $("#signExpense").val(signView.signExpense);
	   	}
	   	
	   	function searchInfo(){
	   		var studentName = $('#studentName').val();
	   		var startTime = $("#startTime").datebox("getValue");  
	   		var endTime = $("#endTime").datebox("getValue"); 
	   		queryParams = {startTime:startTime,endTime:endTime,studentName:studentName};
	   		createTable();
	   	}

        function loadCourseInfo(){
            $('#signCourseName').combogrid({
                panelWidth:160,
                idField:'id',
                textField: 'courseName',
                loadMsg:'数据加载中...',
                rownumbers:false,
                url:'${ctx}/course/queryCourseInfos.html',
                columns:[[
                    {field:'courseName',title:'课程名称',width:80},
                    {field:'price',title:'课程价格(元)',width:80}
                ]]
            });
        }

        function reloadList(){
            createTable();
        }
	  </script>
</html>