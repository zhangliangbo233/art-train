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
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"onclick="deleteCourse()">删除</a>
			</div>
			<div>
				开课时间: <input class="easyui-datebox" style="width:120px" id="startCourseTime">
				- <input class="easyui-datebox" style="width:120px" id="endCourseTime">
				课程名称: 
				<input class="easyui-validatebox" style="width:150px" id="name">
				授课老师姓名: 
				<input class="easyui-validatebox" style="width:150px" id="teacherName4Search">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()">搜索</a>
			</div>
		</div>
		<!-- 添加修改信息弹出框 -->
		<div id="saveDialog" class="easyui-dialog" style="width:380px;padding:10px 20px;" closed="true" buttons="#saveButtons"> 
	       <div class="fitem"> 
	           <label>课程名称</label> 
	           <input id="courseName" type="text" class="easyui-validatebox" data-options="required:true,validType:'length[2,6]'"
	           			 missingMessage="课程名称必须填写" invalidMessage="课程名称长度为2-6位字符"/> 
	       </div> 
	       <div class="fitem"> 
	           <label>课程价格</label> 
	           <input id="price" class="easyui-validatebox" data-options="required:true,validType:'length[1,5]'"
	           		missingMessage="课程价格必须填写" invalidMessage="课程价格为1-10000的整数"/> 
	       </div> 
	       <div class="fitem"> 
	           <label>开课时间</label> 
	           <input id= "beginTime" class="easyui-datebox"/>
	       </div>
           <div class="fitem">
                <label>课程天数</label>
                <input id= "totalDays" class="easyui-validatebox" data-options="required:true,validType:'length[1,4]'"
                       missingMessage="课程天数必须填写" invalidMessage="课程天数为1-1000的整数"/>
           </div>
	       <div class="fitem"> 
	           <label>授课老师</label> 
	           <%--<input id="teacherName" class="easyui-validatebox" data-options="required:true,validType:'length[2,6]'"
	           		missingMessage="授课老师必须填写" invalidMessage="授课老师长度为2-6位字符"/> --%>
               <select id="teacherName" name="dept" style="width:158px;">
                </select>
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
		var course=null;
		
		$().ready(function(){
            joinQueryParams();
   			createTable();
            loadTeacherInfo();
   		});
   		
   		function createTable(){
   			$('#tt').datagrid({
   				iconCls:'icon-edit',
   				width:'auto',  
                height:'auto',
   				singleSelect:true,
   				idField:'studentId',
   				url:'${rootPath}/course/listCourseInfos.html',
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
   					{field:'courseName',title:'课程名称',align:'center',width:280},
   					{field:'price',title:'课程价格(元)',align:'center',width:180,editor:'text'},
   					{field:'beginTime',title:'开课时间',align:'center',width:180,editor:'text'},
   					{field:'endTime',title:'结束时间',align:'center',width:180,editor:'text'},
   					{field:'totalDays',title:'课程天数',align:'center',width:180,editor:'text'},
   					{field:'teacherName',title:'授课老师',align:'center',width:250,editor:'text'}
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
	         $("#saveDialog").dialog("open").dialog('setTitle','添加课程信息');
	         $("#courseName,#price,#teacherName,#totalDays").val('').addClass('validatebox-invalid');
	         //$("#courseName,#price,#teacherName").addClass('validatebox-invalid');
	         $("#beginTime").datebox("setValue","");
	     }

        function loadTeacherInfo(){
            $('#teacherName').combogrid({
                panelWidth:140,
                idField:'id',
                textField: 'name',
                loadMsg:'数据加载中...',
                rownumbers:false,
                url:'${rootPath}/teacher/queryTeacherInfos.html',
                columns:[[
                    {field:'name',title:'老师姓名',width:70},
                    {field:'salary',title:'工资(元/月)',width:70}
                ]]
            });
        }
	   	
	   	function saveStudentSignInfo() {
	   		var courseName = $('#courseName').val();
	   		var price = $('#price').val();
	   		var beginTime = $("#beginTime").datebox("getValue");  
	   		var totalDays = $("#totalDays").val();

	   		var courseId = course==null?0:course.id;

            var selectedRow = $('#teacherName').combogrid('grid').datagrid('getSelected');//获取选中的select

	   		if(!checkBeforeSave(courseName,price,beginTime,selectedRow,totalDays)){
	   			return;
	   		}

            var teacherName = selectedRow.name;
            var teacherId = selectedRow.id;
	   		
	   		var paramJson='{courseId:'+courseId+',courseName:\''+courseName+'\',price:'+price+',beginTime:\''+beginTime+
                    '\',teacherName:\''+teacherName+'\',teacherId:\''+teacherId+'\',totalDays:\''+totalDays+'\'}';
	   		result = SHOPMSG.ajax('${rootPath}/course/saveCourseInfo.html',{paramJson:paramJson});
	   		if(result.success){
	   			SHOPMSG.showMessage('成功提示',result.message,'info');
	   			$("#saveDialog").dialog("close");
	   			$('#tt').datagrid('reload');
	   		}else{
	   			SHOPMSG.showMessage('错误提示',result.message,'error');
	   		}
	    }
	   	
	   	function checkBeforeSave(courseName,price,beginTime,selectedRow,totalDays){
	   		var returnFlag = false;
	   		if(SHOPMSG.isEmpty(courseName)){
	   			SHOPMSG.showMessage('警告提示','课程名称必须填写','warning');
	   			return false;
	   		}
	   		if(SHOPMSG.isEmpty(price)){
	   			SHOPMSG.showMessage('警告提示','课程价格必须填写','warning');
	   			return false;
	   		}
            if(SHOPMSG.isEmpty(totalDays)){
                SHOPMSG.showMessage('警告提示','课程天数必须填写','warning');
                return false;
            }
	   		if(null == selectedRow || SHOPMSG.isEmpty(selectedRow)){
	   			SHOPMSG.showMessage('警告提示','授课老师必须填写','warning');
	   			return false;
	   		}
	   		return true;
	   	}
	   	
	   	function deleteCourse() {
            if(!showDeleteOrEditMsg('删除')) return;
            $.messager.confirm('确认提示', '确定要删除选中的信息吗?', function (r) {
            	if(!r){
            		return;
            	}
            	result = SHOPMSG.ajax('${rootPath}/course/deleteCourse.html', {id:selectedRow.id});
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
	   		result = SHOPMSG.ajax('${rootPath}/course/loadCourseInfo.html', {id:selectedRow.id});
	   		if(!result.success){
	   			SHOPMSG.showMessage('错误提示',result.message,'error');
	   			return;
	   		}
	   		$("#saveDialog").dialog("open").dialog('setTitle','编辑课程信息');
	   		$("#courseName,#price,#beginTime,#teacherName,#totalDays").removeClass('validatebox-invalid');
	   		
	   		course = result.data;
		    $("#courseName").val(course.courseName);
	        $("#price").val(course.price);
	        $("#totalDays").val(course.totalDays);
	        //$("#beginTime").datebox("setValue",course.beginTime);
            //$('#teacherName').combogrid('setValue', course.teacherName);
            //$('#teacherName').combogrid('grid').datagrid('selectRecord',course.teacherId);
            //alert(course.teacherId);
            $('#teacherName').combogrid('grid').datagrid('selectRecord',course.teacherId);
	   	}
	   	
	   	
	   	function searchInfo(){
            joinQueryParams();
	   		createTable();
	   	}

        function joinQueryParams(){
            var courseName = $('#name').val();
            var startCourseTime = $("#startCourseTime").datebox("getValue");
            var endCourseTime = $("#endCourseTime").datebox("getValue");
            var teacherName = $('#teacherName4Search').val();

            var courseListParam='{courseName:\''+courseName+'\',startCourseTime:\''+startCourseTime+'\',endCourseTime:\''+endCourseTime+'\',teacherName:\''+teacherName+'\'}';
            queryParams = {courseListParam:courseListParam};
        }

        function reloadList(){
            createTable();
        }
	   	
	  </script>
</html>