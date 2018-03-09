<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:include page="/WEB-INF/jsp/inc.jsp"></jsp:include>
<script type="text/javascript" src="<%=basePath%>scripts/jqueryUI/extJquery.js" charset="utf-8"></script>
<script type="text/javascript">

	$(function(){
		
		var grid = $("#grid");
		
		$("#searchbtn").bind("click", function() {
			if ($("#search_form").form('validate')) {
				grid.datagrid("load", {
					queryjson : $.serializeJson($("#search_form"))
				});
			}
		});
		
		$("#cleanbtn").bind("click", function() {
			$("#search_form").form("clear");
			grid.datagrid("load", {
				queryjson : ""
			});
		});
		
		
		
		grid.datagrid({
			url : '<%=basePath%>classes/grid.do',
			fitColumns:true,
			iconCls:"icon-save",
			pagination:true,//显示分页  
            pageSize:5,//分页大小  
            pageList:[5,10],//每页的个数  
			title:'班级管理',
			checkOnSelect:true,
			pagination:true,
			sortName:"id",
			sortOrder:"asc",
			columns:[[    
				{field:'check',checkbox:true},
        		{field:'id',title:'编号',sortable:true,width:30},    
        		{field:'className',title:'班级名称',sortable:true,width:50},
        		{field:'classAcademy',title:'所在学院',sortable:true,width:50},
        		{field:'classMajor',title:'专业',sortable:true,width:90},
        		{field:'classLogo',title:'班级logo',width:100,
        		formatter:function(value,row,index){
        			if(value==null)
        				return "暂无logo图片，待添加";
        			return "<img src='/SysManage/classes/image/"+value+".do' width=45px height=45px >";
        		}},    
        		{field:'classSlogan',title:'口号',sortable:true,width:80},    
        		{field:'classCreatedate',title:'创建时间',sortable:true,width:80},    
        		{field:'classDescription',title:'班级描述',sortable:true,width:120},
        		{field:'teacherName',title:'班主任',sortable:true,width:80,
				formatter:function(value,row,index){
        			if(value==null)
        				return "暂无班主任";
        			else
        				return value;
        		}},    
    		]],
    		toolbar : [ {
				text : "添加",
				iconCls : "icon-add",
				handler : add
			}, "-", {
				text : "修改",
				iconCls : "icon-edit",
				handler : edit
			}, "-", {
				text : "删除",
				iconCls : "icon-remove",
				handler : remove
			}, "-", {
				text : "查看",
				iconCls : "icon-search",
				handler : detail
			}]
    		
		});
			
		
		
		
		
		
		
		
			function add() {
			//添加之前删除游离状态的teacher（没有classId的老师）
				$.ajax({
					url:'classes/delDetachedTch.do',
					type:'post',
					async:false,
					success:function(msg){
					}
				})
				$("#layout").layout("collapse","south");
				parent.$.modalDialog({
					title : '添加班级',
					width : 460,
					height : 665,
					href : 'classes/forwardAdd.do',
					buttons : [ {
						text : '添加',
						handler : function() {
							parent.$.modalDialog.openner_grid = grid;
							var f = parent.$.modalDialog.handler.find('#form');
							f.submit();
						}
					}, {
						text : '取消',
						handler : function() {
							parent.$.modalDialog.handler.dialog('close');
						}
					} ],
					
				});
			}
		
		
		
			function edit() {
				$("#layout").layout("collapse","south");
				var rows = grid.datagrid('getSelections');
				if (rows && rows.length == 1) {
					parent.$.modalDialog({
						title : '修改资源',
						width : 520,
						height : 665,
						href : 'classes/forwardEdit/' + rows[0].id + '.do',
						buttons : [ {
							text : '修改',
							handler : function() {
								parent.$.modalDialog.openner_grid = grid;
								var f = parent.$.modalDialog.handler.find('#edform');
								f.submit();
							}
						}, {
							text : '取消',
							handler : function() {
								parent.$.modalDialog.handler.dialog('close');
							}
						} ]
					});
				} else {
					parent.$.messager.alert('提示', "请选择一条记录！");
				}
			}

			
			
			
			
			function remove() {
				$("#layout").layout("collapse","south");
				var rows = grid.datagrid('getChecked');
				if (rows && rows.length > 0) {
					parent.$.messager.confirm('提示', '是否删除这些班级?注意，删除时，会将班级的老师也删除', function(r) {
						if (r) {
							var ids = [];
							for ( var i = 0; i < rows.length; i++) {
								ids.push(rows[i].id);
							}
							$.ajax({
								url : "classes/delete/" + ids.join(",") + ".do",
								dataType : "json",
								success : function(data) {
									if (data && data.success) {
										if (data.msg && data.msg != "")
											parent.$.messager.alert('提示', data.msg);
										else
											parent.$.messager.alert('提示', "删除成功");
										grid.datagrid('reload');
										grid.datagrid('uncheckAll');//把选择的checked记录全部清空
									} else {
										parent.$.messager.alert('错误', data.msg);
									}
								}
							});
						}
					});
				} else {
					parent.$.messager.alert('提示', "请选择需要删除的记录！");
				}
			}
		
		
		
		
		
			function detail(){
	
				var rows = grid.datagrid('getSelections');
				var uname = "";
				if(rows.length==0){
					$.messager.alert("提示","请选择要查看的班级。","info");
					return ;
				}else{
					if(rows.length>1){
						$.messager.alert("提示","一次只能查看一个班级","error");
						return ;
					}
					else if(rows.length==1){
						uname = rows[0].className;
						uid = rows[0].id
					}
					
					parent.$.messager.confirm("提示","将要查看"+uname+"班的老师",function(r){
						if(!r) return;
						$('#teachergrid').datagrid({
							url:'/SysManage/classes/showteacher/'+uid+'.do',
							title:uname+'班老师',
							singleSelect:true,
							pagination:true,
							pageList:[5],
							sortName:'id',
							sortOrder:'asc',
							columns:[[    
				        		{field:'id',title:'编号',width:30},    
				        		{field:'teacherNo',title:'教师编号',width:80},
				        		{field:'teacherName',title:'教师姓名',width:80},    
				        		{field:'teacherSex',title:'性别',width:50},    
				        		{field:'teacherCreatedate',title:'创建时间',width:80},    
				        		{field:'ischarger',title:'是否为班主任',width:50,
				        		formatter:function(value,row,index){
				        			if(value==true)
				        				return "是";
				        			else 
				        				return "否";
				        		}
				        		},    
				    		]],
				    		fitColumns:true,
							iconCls:"icon-search",
						})
						grid.datagrid('clearSelections');
						$("#layout").layout({
							title:"查看",
							region:"south",
							collapsible:true
						})
						$("#layout").layout("expand","south");
						
					})
				}
			}
			
	})
	
	

</script>


</head>
<body>
	
	<div id="layout" class="easyui-layout" fit="true" border="true">
     	<div region="north" border="true" title="查询" style="height: 115px; overflow: hidden;">
      		<form id="search_form">
        <table width="100%" border="0" cellspacing="2" cellpadding="3" align="center" style="padding-top:10px;">
          <tr bgcolor="f5f5f5">
            <td width="100px">
              <div align="right">班级名称：</div>
            </td>
            <td width="300px" align="left">
              <input type="text" name="Y_className_String_LK" style="width: 237px">
            </td>
            <td width="100px">
              <div align="right">学院：</div>
            </td>
            <td width="150px" align="left">
              <input id="code" name="Y_classAcademy_String_LK" editable="false" style="width: 150px">
            </td>
            <td width="100px">
              <div align="right">专业：</div>
            </td>
            <td width="150px" align="left">
              <input id="model" name="Y_classMajor_String_LK" editable="false" style="width: 150px">
            </td>
            <td></td>
          </tr>
          <tr bgcolor="f5f5f5">
            <td width="100px">
              <div align="right">班级描述：</div>
            </td>
            <td width="300px" align="left">
              <input type="text" name="Y_classDescription_String_LK" style="width: 200px" class="easyui-validatebox" >
            </td>
            <td width="100px">
              <div align="right">创建时间：</div>
            </td>
            <td width="150px" align="left" colspan="2">
              <input type="text" name="Y_classCreatedate_Date_GE" style="width: 106px" class="easyui-datebox" editable="false">
              &nbsp;-&nbsp;
              <input type="text" name="Y_classCreatedate_Date_LE" style="width: 106px" class="easyui-datebox" editable="false">
            </td>
            <td width="300px">
              <a id="searchbtn" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
              <a id="cleanbtn" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">清空</a>
            </td>
            <td></td>
          </tr>
        </table>
</form>

    		</div>
    		<div region="center" border="true">
      			<table id="grid" ></table>
    		</div>
    		
    		<div region="south"  style="height: 215px; overflow: hidden" collapsed="true" collapsible="false">
      			<table id="teachergrid"></table>
    		</div>
	</div>
	
	
	
	
	
</body>
</html>