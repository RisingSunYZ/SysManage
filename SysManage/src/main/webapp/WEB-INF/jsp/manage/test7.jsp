<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="/WEB-INF/jsp/inc.jsp"></jsp:include>

<style type="text/css">
.datagrid-row-selected {
	background: #3baae3 repeat-x 50% 50%;
	color: #fff;
}
</style>
<script type="text/javascript" charset="utf-8">
	var grid;
	$(function() {
		// grid
		grid = $("#grid").datagrid({
			url : "movie/grid.do",
			title : "",// 如果不写或者为空则不绘制标题
			iconCls : "icon-save",// 图标
			pagination : true,// 是否显示分页
			pageSize : 10,// 每页记录数
			pageList : [ 10, 20, 30 ],
			fit : true,// 让grid的宽和高自适应
			fitColumns : false,// 让grid的每个列自适应宽度，如果设为false则每列的宽度固定，如果grid的总宽度比所有列的宽度之和小则会出现水平滚动条
			nowrap : true,// 默认是true表示不允许换行，为false表示允许换行
			border : false,// 是否显示边框
			idField : "id",// 主键字段
			sortName : "name",// 默认排序
			sortOrder : "asc",
			rownumbers : true,// 显示行号列
			singleSelect : true,// 行选择是否只选择一行
			checkOnSelect : false,
			selectOnCheck : false,
			frozenColumns : [ [ {
				field : "ck",
				checkbox : true
			}, {
				field : "id",
				hidden : true
			},{
				title : "电影名称",
				field : "name",
				width : 200,
				halign : "center",
				align : "center",
				editor : {
				type : "combobox",
				options : {
					validType : "text"
				}
			},
				sortable : true
			}, {
				title : "电影放映时间",
				field : "startime",
				width : 200,
				halign : "center",
				align : "center",
				editor : {
				type : "combobox",
				editor : {
				type : "datetimebox",
			}
			},
				sortable : true
			}, {
				title : "价格",
				field : "price",
				width : 200,
				halign : "center",
				align : "center",
				sortable : true,
				formatter : formatNumOrFloat
			} , {
				title : "片长(/分钟)",
				field : "time",
				width : 200,
				halign : "center",
				align : "center",
				sortable : true,
				formatter : formatNumOrFloat
			} ] ],
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
			},"-", {
				text : "选座",
				iconCls : "icon-search",
				handler : selectSeat
			}, "-" ],
			onDblClickRow : function(rowIndex, rowData) {
				if (rowIndex > -1) {
					show(rowData.id);
				}
			}
		});

		// 查询按钮
		$("#searchbtn").bind("click", function() {
			if ($("#search_form").form('validate')) {
				grid.datagrid("load", {
					queryjson : $.serializeJson($("#search_form"))
				});
			}
		});
		// 清空查询按钮
		$("#cleanbtn").bind("click", function() {
			$("#search_form").form("clear");
			grid.datagrid("load", {
				queryjson : ""
			});
		});
	});

	// 数字列格式化
	function formatNumOrFloat(value, row, index) {
		if (value > 0)
			return value;
		else
			return "-";
	}

	  //添加
	function add() {
		parent.$.modalDialog({
			title : '添加资源',
			width : 700,
			height : 400,
			href : 'movie/forwardAdd.do',		
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
			} ]			
		});
		
	}  
	 
	// 修改
	function edit() {
		var rows = grid.datagrid('getSelections');
		if (rows && rows.length == 1) {
			parent.$.modalDialog({
				title : '修改资源',
				width : 700,
				height : 400,
				href : 'movie/forwardEdit/' + rows[0].id + '.do',
				buttons : [ {
					text : '修改',
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
				} ]
			});
		} else {
			parent.$.messager.alert('提示', "请选择一条记录！");
		}
	}

	//查看
	function show(id) {
		if (id > 0) {
			parent.$.modalDialog({
				title : '查看资源',
				width : 700,
				height : 400,
				href : 'movie/forwardShow/' + id + '.do',
				buttons : [ {
					text : '关闭',
					handler : function() {
						parent.$.modalDialog.handler.dialog('close');
					}
				} ]
			});
		}
	}

	// 删除
	function remove() {
		var rows = grid.datagrid('getChecked');
		if (rows && rows.length > 0) {
			$.messager.confirm('提示', '是否删除这些场次?', function(r) {
				if (r) {
					var ids = [];
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						url : "movie/delete/" + ids.join(",") + ".do",
						dataType : "json",
						success : function(data) {
							if (data && data.success) {
								if (data.msg && data.msg != "")
									parent.$.messager.alert('提示', data.msg);
								else {
									parent.$.messager.alert('提示', "删除成功");
								}
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
			parent.$.messager.alert('提示', "请选择需要删除的场次！");
		}
	}
	
	//选座
	function selectSeat() {
		var rows = grid.datagrid('getSelections');
		if (rows && rows.length == 1) {
			parent.$.modalDialog({
				title : '选座',
				width : 700,
				height : 400,
				href : 'movie/forwardSelectSeat/' + rows[0].id + '.do',
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
				} ]
			});
		} else {
			parent.$.messager.alert('提示', "请选择一条记录！");
		}
	}

</script>
</head>
<body>
	<div class="easyui-layout" fit="true" border="true">
		<div region="north" border="true" title="查询"
			style="height: 130px; overflow: hidden;">
			<form id="search_form">
				<table width="100%" border="0" cellspacing="2" cellpadding="3"
					align="center">
					<tr bgcolor="f5f5f5">
						<td width="100px">
							<div align="right">电影名称：</div>
						</td>
						<td width="150px" align="left"> <input id="name" type="text"
							name="Y_name_String_LK" style="width: 150px"> 
						</td>
						<td width="300px"><a id="searchbtn"
							href="javascript:void(0);" class="easyui-linkbutton"
							data-options="iconCls:'icon-search'">查询</a> <a id="cleanbtn"
							href="javascript:void(0);" class="easyui-linkbutton"
							data-options="iconCls:'icon-reload'">清空</a></td>
					</tr> 
				</table>
			</form>
		</div>
		<div region="center" border="true">
			<table id="grid"></table>
		</div>
	</div>
</body>
</html>