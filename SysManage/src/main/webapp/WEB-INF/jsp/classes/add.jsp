<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>


<script type="text/javascript">

	$(function() {
		$.extend($.fn.validatebox.defaults.rules, {
			sloganRange : {
				validator : function(value) {
					return value.length <= 10 ;
				},
				message : '口号须少于10个字符'
			},
			realnumber : {
				validator : function(value) {
					return /^\d{8}$/.test(value) ;
				},
				message : '请输入8位的教师编码'
			},
			classNametest:{
				validator: function(value){
					var a = false;
					$.ajax({
						type:'post',
						async:false,
						url:'classes/testClassName/'+value+'.do',
						success:function(result){
							var data = eval("(" + result + ")");//将JSON字符串转换成对象
							a = data.success;
						}
					})
					return a;
				},
				message : '班级名称已被使用'
			},
			teacherNotest:{
				validator:function(value){
					var a = false ;
					$.ajax({
						type:'post',
						async:false,
						url:'classes/testTeacherNo/'+value+'.do',
						success:function(result){
							var data = eval("(" + result + ")");//将JSON字符串转换成对象
							a = data.success;
						}
					})
					return a ;
				},
				message : '教师编号已存在'
			}
		}
		);
		
		
		 $('#classAcademy').combobox({
			onSelect: function(academy){    
	        	$('#classMajor').combobox('setValue', '');  
	            var url = '/SysManage/classes/major/'+academy.aid+'.do';    
	            $('#classMajor').combobox('reload', url);
	        }
		}) 
		
	
		$('#form').form({
			url : 'classes/add.do',
			onSubmit : function() {
				$('#academy').val($('#classAcademy').combobox('getText'));
				$('#major').val($('#classMajor').combobox('getText'));
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				var isValid = $(this).form('validate');
				if (!isValid)
					parent.$.messager.progress('close');
				return isValid;
			},
			success : function(result) {
			
			
				parent.$.messager.progress('close');
				try {
					data = eval("(" + result + ")");//将JSON字符串转换成对象
					if (data && data.success) {
						if (data.msg && data.msg != "")
							parent.$.messager.alert('提示', data.msg);
						else
							parent.$.messager.alert('提示', "添加成功");
						parent.$.modalDialog.openner_grid.datagrid('reload');//刷新Gird数据
						parent.$.modalDialog.handler.dialog('close');//关闭当前模式窗口
					} else
						parent.$.messager.alert('错误', data.msg);//操作失败
				} catch (e) {
					parent.$.messager.alert('错误', result);//提示服务器异常
				}
			}
		});
		
		
		
		$("#img-change").click(function () {
    		$("#classLogo").click();
		})
		
		
		$("#img-change").mouseover(function(e){
			$("#large").show();
			$("#large img").attr("src",$(this).attr("src"));
			$("#large").css({
				"position":"absolute",
				"left":"180px",
				"width":"100%",
				"height":"100%"
			})
		
		}).mouseout(function(){
			$("#large").hide();
		})
		
		
	});
	
		var add= false;
		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){
				return true
			} else {
				return false;
			}
		}
		function append(){
			add=true;
			if (endEditing()){
				$('#dg').datagrid('appendRow',{});
				editIndex = $('#dg').datagrid('getRows').length-1;
				$('#dg').datagrid('beginEdit', editIndex);
			}
		}
		function accept(){
			if($("#dg").datagrid('validateRow',editIndex)){
				$("#dg").datagrid('endEdit', editIndex);
				editIndex = undefined;
			}
		}
		function remove(){
			//添加时点删除
			if (add){
				$('#dg').datagrid('cancelEdit', editIndex)
						.datagrid('deleteRow', editIndex);
				editIndex = undefined;
				add=false;//还原状态
				return
			}
			
			var arows =$('#dg').datagrid('getSelections');
			if(arows&&arows.length==1){
				parent.$.messager.confirm("提示","是否删除选中数据？",function(r){
					if(!r) return ;
					$.ajax({
						type:'post',
						async:false,
						url:'/SysManage/classes/delTeacher1/'+arows[0].teacherNo+'.do',
						success:function(msg){
							$.messager.show({
								title:'提示信息',
								msg:'删除成功!'
							});
							$("#dg").datagrid('reload');
						}
					})
				})
			}else{
				$.messager.show({
					title:'提示信息',
					msg:'请选择一条记录!'
				});
			
			}
			editIndex = undefined;
		}
		
		$('#dg').datagrid({
			onAfterEdit:function(index , record){
				$.post('/SysManage/classes/addTeacher.do' , record , function(result){
				
						data = eval("(" + result + ")");
						if(data.success){
							$.messager.show({
								title:'提示信息',
								msg:data.msg
							});
						$('#dg').datagrid('reload');
						}else{
							parent.$.messager.alert("错误",data.msg);
							editIndex = $('#dg').datagrid('getRows').length-1;
							$('#dg').datagrid('beginEdit', editIndex);
						}
				});
				add= false;
			}
		})
		
		
		
		var filechange=function(event){
	    var files = event.target.files, file;
	    if (files && files.length > 0) {
	        // 获取目前上传的文件
	        file = files[0];// 文件大小校验的动作
	        if(file.size > 1024 * 1024 * 2) {
	            alert('图片大小不能超过 2MB!');
	            return false;
	        }
	        // 获取 window 的 URL 工具
	        var URL = window.URL || window.webkitURL;
	        // 通过 file 生成目标 url
	        var imgURL = URL.createObjectURL(file);
	        //用attr将img的src属性改成获得的url
	        $("#img-change").attr("src",imgURL);
	        // 使用下面这句可以在内存中释放对此 url 的伺服，跑了之后那个 URL 就无效了
	        // URL.revokeObjectURL(imgURL);
	    }
	};
		

</script>
<div>
	<div id="imgtest">
	<form id="form" style="padding: 10px" method="post" enctype="multipart/form-data" >
		<div id="large" style="position:absolute;display:hidden;overflow:hidden;"><img src=""/></div>
		<table>
			<tr>
				<td width="80px" align="right"><label>班级名称：</label></td>
				<td style="padding-left:30px;"><input id="className" name="className"
					type="text" class="easyui-validatebox"  data-options="required:true,validType:'classNametest'" " /><br></td>
				<td></td>
			</tr>
			<tr>
				<td width="80px" align="right"><label>所在学院：</label></td>
				<td style="padding-left:30px;"><input id="classAcademy" class="easyui-combobox" data-options="url:'<%=basePath%>classes/academy.do',valueField:'aid',textField:'aname',required:true,editable:false,missingMessage:'请选择所在学院',panelHeight:'auto'"><br>
					<input type="hidden" id="academy" name ="classAcademy">
				</td>
				<td></td>
			</tr>
			<tr>
				<td width="80px" align="right"><label>专业：</label></td>
				<td style="padding-left:30px;"><input id="classMajor" class="easyui-combobox" data-options="valueField:'mid',textField:'mname',required:true,editable:false,missingMessage:'请选择专业',panelHeight:'auto'">
					<input type="hidden" id="major" name="classMajor"><br>
				</td>
				<td></td>
			</tr>
			<tr>
				<td width="80px" align="right"><label>班级logo：</label></td>
				<td style="padding-left:30px;"><input id="classLogo" name="Logo" type="file" onchange="filechange(event)"><br>
				</td>
				<td style="padding-left:30px;"><img alt="暂无图片" src="" width="30px" height="30px" id="img-change"></td>
			</tr>
			<tr>
				<td width="80px" align="right"><label>班级口号：</label></td>
				<td style="padding-left:30px;"><input id="classSlogan" name="classSlogan" type="text" class="easyui-validatebox"
					data-options="validType:'sloganRange'" /><br></td>
				<td></td>
			</tr>
			<tr>
				<td width="80px" align="right"><label>创建时间：</label></td>
				<td style="padding-left:30px;"><input id="classCreatedate" name="classCreatedate" type="text" class="easyui-datebox"/><br></td>
				<td></td>
			</tr>
			<tr>
				<td width="80px" align="right"><label>班级描述：</label><br></td>
				<td style="padding-left:30px;"><textarea id="classDescription" name="classDescription" class="easyui-validatebox" style="width: 180px; height: 60px;"></textarea><br>
				</td>
				<td></td>
			</tr>
			
		
		</table>
		<input type="hidden" id="teachers" name ="tecahers">
	</form>
	</div>
		<table id="dg" class="easyui-datagrid" title="教师管理"
			data-options="
				url: '/SysManage/classes/addgrid.do',
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',
				pagination:true,
				pageSize:5,
				pagePosition:'top',
				pageList:[5,10],
				sortName:'id',
				sortOrder:'asc',
				scrollbarSize:10,
				toolbar: '#tb',
				
			">
		<thead>
			<tr>
				<th data-options="field:'teacherNo',width:90,
						editor:{
							type:'validatebox',
							options:{
								required:true,
								validType:['realnumber','teacherNotest'],
							}
						}">教师编号</th>
				<th data-options="field:'teacherName',width:80,
						editor:{
							type:'validatebox',
							options:{
								required:true
							}
						}">教师姓名</th>
				<th data-options="field:'teacherSex',width:50,
						editor:{
							type:'combobox',
							options:{
								valueField:'value',
								textField:'text',
								editable:false,
								data:[{value:'男',text:'男'},{value:'女',text:'女'}],
								panelHeight:'auto'
							}
						}">性别</th>
				<th data-options="field:'teacherCreatedate',width:100,
						editor:{
							type:'datebox',
							options:{
								editable:false
							}
						}">创建时间</th>
				<th data-options="field:'ischarger',width:100,
						editor:{
							type:'combobox',
							options:{
								valueField:'value',
								textField:'text',
								editable:false,
								data:[{value:'是',text:'是'},{value:'否',text:'否'}],
								panelHeight:'auto'
							}
						},
						formatter:function(value,row,index){
							if(value==true)
								return '是';
							else
								return '否'
						}">是否为班主任</th>
			</tr>
		</thead>
	</table>
 

 
	<div id="tb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">新增</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="remove()">删除</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存</a>
	</div>


	
</div>