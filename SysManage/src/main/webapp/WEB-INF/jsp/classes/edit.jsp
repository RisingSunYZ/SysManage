<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<script charset="utf-8">
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
			}
		}
		);
		
	
		if ('${AjaxMsg.success}' == 'false') {
			parent.$.messager.alert('错误', '${AjaxMsg.msg}');
				parent.$.modalDialog.handler.dialog('close');
		}

		$('#classDescription').val($('#description').val());
		
		
		
		
		//二级联动
		$('#classDcademy').combobox({
			onSelect: function(academy){    
	        	$('#classMajor').combobox('setValue', '');  
	            var url = '/SysManage/classes/major/'+academy.aid+'.do';    
	            $('#classMajor').combobox('reload', url);
	        }
		}) 
		
		
		
	
		$('#edform').form({
			url : 'classes/upd.do',
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
							parent.$.messager.alert('提示', "修改成功");
						parent.$.modalDialog.openner_grid.datagrid('reload');//刷新Gird数据
						parent.$.modalDialog.handler.dialog('close');//关闭当前模式窗口
					} else
						parent.$.messager.alert('错误', data.msg);//操作失败
				} catch (e) {
					parent.$.messager.alert('错误', result);//提示服务器异常
				}
			}
		});
		
		
		var id = $('#id').val();
		var tgrid = $('#dg').datagrid({
				url:'classes/showteacher/'+id+'.do',
		})
		
		
		
		
		$("#img-change1").click(function () {
    		$("#Logo").click();
		})
		
		
		$("#img-change1").mouseover(function(e){
			$("#large1").show();
			$("#large1 img").attr("src",$(this).attr("src"));
			$("#large1").css({
				"position":"absolute",
				"z-index":"1",
				"left":"180px"
			})
		
		}).mouseout(function(){
			$("#large1").hide();
		})
		
		
	});
	
		
		var editIndex = undefined;
		var add = false;//是否为添加操作(默认为编辑操作)
		function endEditing(){
			if (editIndex == undefined){
				return true
			} else {
				return false;
			}
		}
		function append(){
			if (endEditing()){
				$('#dg').datagrid('insertRow',{index:0,row:{}});
				editIndex = 0;
				$('#dg').datagrid('beginEdit', editIndex);
				add = true;
			}
		}
		function removeit(){
			//添加时点删除
			if (add){
				$('#dg').datagrid('cancelEdit', editIndex)
						.datagrid('deleteRow', editIndex);
				editIndex = undefined;
				add=false;//还原状态
				return
			}
			
			var trows =$('#dg').datagrid('getSelections');
			if(trows&&trows.length==1){
				parent.$.messager.confirm("提示","是否删除选中数据？",function(r){
					if(!r) return ;
					$.ajax({
						type:'post',
						async:false,
						url:'/SysManage/classes/delTeacher/'+trows[0].id+'.do',
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
		function accept(){
			if($('#dg').datagrid('validateRow',editIndex)){
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = undefined;
			}
		}
		function onDblClickRow(index){
			if (editIndex != index){
				if (endEditing()){
					$('#dg').datagrid('selectRow', index)
							.datagrid('beginEdit', index);
					editIndex = index;
				} else {
					$('#dg').datagrid('selectRow', editIndex);
				}
			}
		}
		
		
		$('#dg').datagrid({
			onAfterEdit:function(index , record){
				var id = $('#id').val();
				if(add){
					if(record.ischarger=="是"){
						parent.$.messager.confirm('确认班主任',"若该老师为班主任，会导致之前的班主任被替换！是否添加？",function(r){
							if(r){
								$.ajax({
									type:'post',
									async:false,
									url:'/SysManage/classes/addTeacher1/'+id+'.do',
									data: record,
									success:function(result){
										$.messager.show({
											title:'提示信息',
											msg:'添加成功!'
										});
										$("#dg").datagrid('reload');
									}
								})
								add=false;
							}
							else{
								editIndex = 0;
								$('#dg').datagrid('beginEdit', editIndex);
								add = true;
								return ;
							}
						})
					}else{
						$.ajax({
							type:'post',
							async:false,
							url:'/SysManage/classes/addTeacher1/'+id+'.do',
							data: record,
							success:function(result){
								$.messager.show({
									title:'提示信息',
									msg:'添加成功!'
								});
								$("#dg").datagrid('reload');
							}
						})
						add=false;
					}
				}else{
					if(record.ischarger=="是"){
						parent.$.messager.confirm('确认班主任',"若该老师为班主任，会导致之前的班主任被替换！是否修改？",function(r){
							if(r){
								$.ajax({
									type:'post',
									async:false,
									url:'/SysManage/classes/updTeacher/'+id+'.do',
									data: record,
									success:function(result){
										$.messager.show({
											title:'提示信息',
											msg:'修改成功!'
										});
										$("#dg").datagrid('reload');
									}
								})
							}else{
								editIndex = index;
								$('#dg').datagrid('beginEdit', editIndex);
								return ;
							}
						})
					}else{
						$.ajax({
							type:'post',
							async:false,
							url:'/SysManage/classes/updTeacher/'+id+'.do',
							data: record,
							success:function(result){
								$.messager.show({
									title:'提示信息',
									msg:'修改成功!'
								});
								$("#dg").datagrid('reload');
							}
						})
					}
				}
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
	        $("#img-change1").attr("src",imgURL);
	        // 使用下面这句可以在内存中释放对此 url 的伺服，跑了之后那个 URL 就无效了
	        // URL.revokeObjectURL(imgURL);
	    }
		};
</script>

<div>

	<div>

	<form id="edform" style="padding: 10px;margin-left:20px;" method="post" enctype="multipart/form-data">
		<div id="large1" style="position:absolute;display:hidden;overflow:hidden;"><img src=""/></div>
		<input type="hidden" id="id" name="id" value="${clazz.id}">
		<table>
			<tr>
				<td width="90px" align="right"><label>班级名称：</label></td>
				<td style="padding-left:30px"><input id="className" name="className" value="${clazz.className}"
					type="text" class="easyui-validatebox" required="true" missingMessage="请输入名称"" /><br></td>
				<td></td>
			</tr>
			<tr>
				<td width="90px" align="right"><label>所在学院：</label></td>
				<td style="padding-left:30px"><input id="classAcademy" value="${clazz.classAcademy}" class="easyui-combobox" data-options="url:'<%=basePath%>classes/academy.do',valueField:'aid',textField:'aname',required:true,editable:false,missingMessage:'请选择所在学院',panelHeight:'auto'"><br>
					<input type="hidden" id="academy" name ="classAcademy" value="${clazz.classAcademy}" >
				</td>
				<td></td>
			</tr>
			<tr>
				<td width="90px" align="right"><label>专业：</label></td>
				<td style="padding-left:30px"><input id="classMajor" value="${clazz.classMajor}" class="easyui-combobox" data-options="url:'<%=basePath%>classes/majorByName/${clazz.classAcademy}.do' ,valueField:'mid',textField:'mname',required:true,editable:false,missingMessage:'请选择专业',panelHeight:'auto'">
					<input type="hidden" id="major" name="classMajor" value="${clazz.classMajor}"><br>
				</td>
				<td></td>
			</tr>
			<tr>
				<td width="90px" align="right"><label>班级logo：</label></td>
				<td style="padding-left:30px"><input id="classLogo" name="classLogo" type="text" class="easyui-validatebox" value="${clazz.classLogo}" readonly="readonly"><br>
					<input type="file" name="Logo" value="${clazz.classLogo}" width="199px" onchange="filechange(event)"/>
				</td>
				<td><img src="/SysManage/classes/image/${clazz.classLogo}.do" width="32px" height="32px" id="img-change1"></td>
			</tr>
			<tr>
				<td width="90px" align="right"><label>班级口号：</label></td>
				<td style="padding-left:30px"><input id="classSlogan" name="classSlogan" value="${clazz.classSlogan}" type="text" class="easyui-validatebox"
					data-options="validType:'sloganRange'" /><br></td>
				<td></td>
			</tr>
			<tr>
				<td width="90px" align="right"><label>创建时间：</label></td>
				<td style="padding-left:30px"><input id="classCreatedate" name="classCreatedate" type="text" value="${clazz.classCreatedate}" class="easyui-datebox"
				/><br></td>
				<td></td>
			</tr>
			<tr>
				<td width="90px" align="right"><label>班级描述：</label><br></td>
				<td style="padding-left:30px"><textarea id="classDescription" name="classDescription"  class="easyui-validatebox" style="width: 199px; height: 60px;resize:none;"></textarea>
				<input type="hidden" id="description" name ="description" value="${clazz.classDescription}"><br>
				</td>
				<td></td>
			</tr>
			
		
		</table>
		<input type="hidden" id="teachers" name ="tecahers">
	</form>
	
	</div>
	<div>
	
		<table id="dg" class="easyui-datagrid" title="教师管理" "
			data-options="
				url: '',
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
				onDblClickRow: onDblClickRow
			">
		<thead>
			<tr><th data-options="field:'id',width:50">编号<th>
				<th data-options="field:'teacherNo',width:90,
						editor:{
							type:'validatebox',
							options:{
								required:true,
								validType:'realnumber',
								invalidMessage:'请输入8位的数字编号'
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
								valueField:'label',
								textField:'value',
								editable:false,
								data:[{label:'男',value:'男'},{label:'女',value:'女'}],
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
								valueField:'label',
								textField:'value',
								editable:false,
								data:[{label:'是',value:'是'},{label:'否',value:'否'}],
								panelHeight:'auto'
							}
						},formatter:function(value,row,index){
				        			if(value==true)
				        				return '是';
				        			else 
				        				return '否';
				        }">是否为班主任</th>
			</tr>
		</thead>
	</table>
 	</div>
	<div id="tb">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">新增</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存</a>
	</div>

</div>