var teachergrid;
var flag=false;
$(function() {

	// 读者信息
	teachergrid = $("#teachergrid").datagrid({
		url : null,
		fit : true,
		fitColumns : true,
		nowrap : true,
		border : false,
		singleSelect : true,
		checkOnSelect : false,
		selectOnCheck : false,
		columns : [ [ {
			field : "ck",
			width : 50,
			checkbox : true
		}, {
			title : "姓名",
			width : 100,
			field : "name",
			halign : "center",
			editor : {
				type : "validatebox",
				options : {
					required : true,
					missingMessage : "请输入姓名"
				}
			}
		
		},/* {
			title : "班级号",
			field : "clazz_id",
			width : 120,
			halign : "center",
			editor : {
				type : "validatebox",
				options : {
					validType : "number"
				}
			}
		},*/ {
			title : "性别",
			field : "sex",
			width : 80,
			halign : "center",
			formatter:formatsex,
			editor : {
				type : "combobox",
				options : {
					url : 'clazz/sex.do',
					valueField : 'value',
					textField : 'text',
					required : true,
					editable : false
				}
			}
		}, {
			title : "教师编号",
			field : "no",
			width : 70,
			halign : "center",
			align : "center",
			formatter : formatNumOrFloat,
			editor : {
				type : "validatebox",
				options : {
					validType : [ 'number', 'length[8,8]' ]
				}
			}
		}, {
			title : "操作",
			field : "action",
			width : 150,
			halign : "center",
			align : "center",
			formatter : formatAction
			
		}, {
			title : "添加时间",
			field : "date",
			width : 120,
			halign : "center",
			align : "center",
			editor : {
				type : "datebox",
			}
			}, {
				title : "是否为班主任",
				field : "charger",
				hidden:true	,
			
		} ] ],							
		toolbar :[ {
			text : "添加",
			iconCls : "icon-add",
			handler : addrow1
		}, "-", {
			text : "删除",
			iconCls : "icon-remove",
			handler : deleterows
		}, "-", {
			text : "查看教师信息",
			iconCls : "icon-remove",
			handler : listInfo
		}  ],
		onDblClickRow : function(rowIndex, rowData) {
			teachergrid.datagrid("beginEdit", rowIndex);
		},
		onBeforeEdit : function(index, row) {
			console.info(row);
			row.editing = true;// 标识是否编辑
			teachergrid.datagrid('refreshRow', index);// 将上面的标识写入行数据中
		},
		onAfterEdit : function(index, row) {
			row.editing = false;
			teachergrid.datagrid('refreshRow', index);
			if (addrowindex == index)// 添加行退出编辑模式
				addrowindex = undefined;
		},
		onCancelEdit : function(index, row) {
			row.editing = false;
			teachergrid.datagrid('refreshRow', index);
		}
	});

	
	
	$('#form').form({
		url : 'clazz/add.do',
		onSubmit : function() {
			console.info("222222222");
			parent.$.messager.progress({
				title : '提示',
				text : '数据处理中，请稍后....'
			});
			console.info("33333333333");
			var isValid = $("#tt").tabs('validate');
			if (!isValid) {
				console.info("4444444444444");
				parent.$.messager.progress('close');
				return false;
			}
			var gridValid = endEdit1();// 子表退出编辑验证
			if (!gridValid) {
				console.info("55555555555");
				parent.$.messager.progress('close');
				return false;
			}
			accept1();// 将子表中添加修改删除的数据写入隐藏input
			console.info("666666666666");
			return true;
		},
		success : function(result) {
			parent.$.messager.progress('close');
			try {
				data = eval("(" + result + ")");// 将JSON字符串转换成对象
				if (data && data.success) {
					if (data.msg && data.msg != "")
						parent.$.messager.alert('提示', data.msg);
					else
						parent.$.messager.alert('提示', "添加成功");
					parent.$.modalDialog.openner_grid.datagrid('reload');// 刷新Gird数据
					parent.$.modalDialog.handler.dialog('close');// 关闭当前模式窗口
				} else
					parent.$.messager.alert('错误', data.msg);// 操作失败
			} catch (e) {
				parent.$.errorDialog(result);// 提示服务器异常
			}
		}
	});
	
	
	$('#form1').form({
		url : 'teacherInfo/add.do',
		onSubmit : function() {
			parent.$.messager.progress({
				title : '提示',
				text : '数据处理中，请稍后....'
			});
			var isValid = $("#tt").tabs('validate');
			if (!isValid) {
				parent.$.messager.progress('close');
				return false;
			}
			var gridValid = endEdit();// 子表退出编辑验证
			if (!gridValid) {
				parent.$.messager.progress('close');
				return false;
			}
			accept();// 将子表中添加修改删除的数据写入隐藏input
			return true;
		},
		success : function(result) {
			parent.$.messager.progress('close');
			try {
				data = eval("(" + result + ")");// 将JSON字符串转换成对象
				if (data && data.success) {
					if (data.msg && data.msg != "")
						parent.$.messager.alert('提示', data.msg);
					else
						parent.$.messager.alert('提示', "添加成功");
					parent.$.modalDialog.openner_grid.datagrid('reload');// 刷新Gird数据
					parent.$.modalDialog.handler.dialog('close');// 关闭当前模式窗口
				} else
					parent.$.messager.alert('错误', data.msg);// 操作失败
			} catch (e) {
				parent.$.errorDialog(result);// 提示服务器异常
			}
		}
	});
	
});




//性别格式化
function formatsex(value, row, index){
	console.info(row)
	if(value=="1"){
		return "男";
	}else{
		return "女";
	}
}
// 数字列格式化
function formatNumOrFloat(value, row, index) {
	if (value > 0)
		return value;
	else
		return "-";
}

// 操作列格式化
function formatAction(value, row, index) {
	if (row.editing) {
		var s = '<a href="javascript:void(0);" onclick="saverow1(this)">保存</a> ';
		var c = '<a href="javascript:void(0);" onclick="cancelrow1(this)">取消</a>';
		return s + c;
	} else {
		var e = '<a href="javascript:void(0);" onclick="editrow1(this)">修改</a> ';
		var d = '<a href="javascript:void(0);" onclick="deleterow(this)">删除</a>';
		if(flag!=false){	
			if(row.charger==true){
				var g='<a href="javascript:void(0);" onclick="cancelcharger(this)">取消班主任</a>'	
			}else{
				var g='';	
			}
			return e + d + g;
		}else{
			var g='<a href="javascript:void(0);" onclick="savecharger(this)">设为班主任</a>'	
			return e + d + g;
		}
	}
}

function cancelcharger(target){
	flag=false;
	//var row=teachergrid.datagrid("selectRow",getRowIndex(target));
	//var row= teachergrid.datagrid("getSelected");
	var row = teachergrid.datagrid("selectRow", getRowIndex(target)).datagrid("getSelected");
	console.info(row);
	row.charger=false;
	console.info(row);
	var rows=teachergrid.datagrid("getRows");
	for(var i=0;i<rows.length;i++){
		teachergrid.datagrid("refreshRow",i);
	}
}

function savecharger(target){
	flag=true;
	var row = teachergrid.datagrid("selectRow", getRowIndex(target)).datagrid("getSelected");
	console.info(row);
	row.charger=true;
	console.info(row);
	var rows=teachergrid.datagrid("getRows");
	for(var i=0;i<rows.length;i++){
		teachergrid.datagrid("refreshRow",i);
	}
}
// 由于format里的index是始终不变的，我们需要从tr上获取行号
function getRowIndex(target) {
	var tr = $(target).closest('tr.datagrid-row');
	return parseInt(tr.attr('datagrid-row-index'));
}
// 保证只有一个添加行
var addrowindex = undefined;
// 添加
function addrow1() {
	if (addrowindex != undefined) {
		teachergrid.datagrid("endEdit", addrowindex);
	}
	if (addrowindex == undefined) {
		teachergrid.datagrid("insertRow", {
			index : 0,
			row : {
				no : "",
				name : "",
				sex : "",
				date:"",
				charger:false
			}
		}).datagrid("beginEdit", 0);
		addrowindex = 0;
	}
}
// 保存单行
function saverow1(target) {
	var index = getRowIndex(target);
	teachergrid.datagrid('endEdit', index);
}
// 取消单行的编辑状态
function cancelrow1(target) {
	var index = getRowIndex(target);
	if (addrowindex == index) {// 添加行时取消
		teachergrid.datagrid('deleteRow', index);
		addrowindex = undefined;
	} else
		teachergrid.datagrid('cancelEdit', index);
}
// 进入单行编辑状态
function editrow1(target) {
	var index = getRowIndex(target);
	teachergrid.datagrid('beginEdit', index);
}
// 删除单行
function deleterow1(target) {
	var index = getRowIndex(target);
	$.messager.confirm('确认', '确认删除么?', function(r) {
		if (r) {
			teachergrid.datagrid('deleteRow', index);
			if (addrowindex == index)// 添加行退出编辑模式\被删除了
				addrowindex = undefined;
		}
	});
}
// 删除多行
function deleterows() {
	var rows = teachergrid.datagrid('getChecked');
	if (rows && rows.length > 0) {
		parent.$.messager.confirm('提示', '是否删除这些记录?', function(r) {
			if (r) {
				for ( var i = 0; i < rows.length; i++) {
					var index = teachergrid.datagrid('getRowIndex', rows[i]);
					if (index > -1) {
						teachergrid.datagrid('deleteRow', index);
						if (addrowindex == index)// 添加行退出编辑模式\被删除了
							addrowindex = undefined;
					}
				}
				teachergrid.datagrid('uncheckAll');
				var rows1=teachergrid.datagrid("getRows");
				for(var i=0;i<rows1.length;i++){
					teachergrid.datagrid("refreshRow",i);
				}
			}
		});
	} else {
		parent.$.messager.alert('提示', "请选择需要删除的记录！");
	}
}
// 先验证编辑行中的数据，无错误后，退出所有的编辑模式
function endEdit1() {
	var validate = 0;// 无法退出编辑模式的行数目
	var rows = teachergrid.datagrid('getRows');
	for ( var i = 0; i < rows.length; i++) {
		if (teachergrid.datagrid('validateRow', i))
			teachergrid.datagrid('endEdit', i);
		else
			validate++;
	}
	return validate > 0 ? false : true;// 返回false表示有错误无法退出编辑模式
}
// 将读者Grid中的添加修改删除数据写入隐藏input中，通过form提交给后台处理
function accept1() {
	var inputdiv = $("#changeinput").empty();
	console.info("dffds");
	//var insertrows = teachergrid.datagrid('selectAll');
	var insertrows = teachergrid.datagrid('getChanges', "inserted");
	var deleterows = teachergrid.datagrid('getChanges', "deleted");
	var updaterows = teachergrid.datagrid('getChanges', "updated");
	
	console.info(insertrows);
	if (insertrows.length > 0) {
		jQuery("<input type='hidden' name='addrows' value='" + encodeURI(JSON.stringify(insertrows)) + "' />").appendTo(inputdiv);
	}
	if (deleterows.length > 0) {
		var deletedata = [];
		for ( var i = 0; i < deleterows.length; i++) {
			deletedata.push(deleterows[i].id);
		}
		jQuery("<input type='hidden' name='deleterows' value='" + encodeURI(JSON.stringify(deletedata)) + "' />").appendTo(inputdiv);
	}
	if (updaterows.length > 0) {
		jQuery("<input type='hidden' name='editrows' value='" + encodeURI(JSON.stringify(updaterows)) + "' />").appendTo(inputdiv);
	}
}
function listInfo(){
	parent.$.modalDialogTwo({
		title : '教师信息',
		width : 500,
		height : 300,
		href : 'teacherInfo/forwardAdd.do',
		buttons : [ {
			text : '添加',
			handler : function() {
				parent.$.modalDialogTwo.openner_grid = teachergrid;
				//var f = parent.$.modalDialogTwo.handler.find('#form1');
				//创建save22方法
				var rows = parent.$.modalDialogTwo.save22();
				console.info(rows);
				$.each(rows,function(index,row){
					teachergrid.datagrid("insertRow", {
						index : 0,
						row : {
							no:row.no,
							sex:row.sex,
							name:row.name,
							date:"",
							charger:false
						}
					});
				});
				addrowindex = undefined;
				parent.$.modalDialogTwo.handler.dialog('close');
				//f.submit();
			}
		}, {
			text : '取消',
			handler : function() {
				parent.$.modalDialogTwo.handler.dialog('close');
			}
		} ]			
	});
}
