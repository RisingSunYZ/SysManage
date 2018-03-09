var teachergrid;
var flag=false;
$(function() {
	if ('${AjaxMsg.success}' == 'false') {
		parent.$.messager.alert('错误', '${AjaxMsg.msg}');
		parent.$.modalDialog.handler.dialog('close');
	}	
	

	$('#form').form({
		url : 'clazz/edit.do',
		onSubmit : function() {
			parent.$.messager.progress({
				title : '提示',
				text : '数据处理中，请稍后....'
			});
			var isValid = $("#tt").tabs('validate');
			// var isValid = $('#form').form('validate');//没有tabs时
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
						parent.$.messager.alert('提示', "修改成功");
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

// 加载子表数据
function loaddatareder(clazz_id) {
	teachergrid = $("#teachergrid").datagrid({
		url : "clazz/teachergrid.do",
		queryParams : {
			clazz_id : clazz_id
		},
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
		}, {
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
		}, {
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
					equired : true,
					editable : false
				}
			}
		}, {
			title : "教师编号",
			field : "no",
			width : 70,
			halign : "center",
			align : "center",			
			editor : {
				type : "validatebox",
				options : {
					required : true,
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
				options : {
					validType : "datebox"
				}
			}
			}, {
				title : "是否为班主任",
				field : "charger",
				hidden:true	
			
		} ] ],
		toolbar : [ {
			text : "添加",
			iconCls : "icon-add",
			handler : addrow
		}, "-", {
			text : "删除",
			iconCls : "icon-remove",
			handler : deleterows
		} , "-", {
			text : "查看教师信息",
			iconCls : "icon-add",
			handler : listinfo
		}],
		onDblClickRow : function(rowIndex, rowData) {
			teachergrid.datagrid("beginEdit", rowIndex);
		},
		onBeforeEdit : function(index, row) {
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
	teachergrid.datagrid("options").view.onBeforeRender = function (target, rows) {
		//console.info(rows);
		$.each(rows, function (index, row) {
			if(row.charger==true){
				flag=true;
			}
			//console.info(row.charger);
		});
	};
}


// 数字列格式化
function formatNumOrFloat(value, row, index) {
	if (value > 0)
		return value;
	else
		return "-";
}
//性别格式化
function formatsex(value, row, index){
	if(value=="1"){
		return "男";
	}else{
		return "女";
	}
}

// 操作列格式化
function formatAction(value, row, index) {
	if (row.editing) {
		var s = '<a href="javascript:void(0);" onclick="saverow(this)">保存</a> ';
		var c = '<a href="javascript:void(0);" onclick="cancelrow(this)">取消</a>';
		return s + c;
	} else {
		var e = '<a href="javascript:void(0);" onclick="editrow(this)">修改</a> ';
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
function addrow() {
	if (addrowindex != undefined) {
		teachergrid.datagrid("endEdit", addrowindex);
	}
	if (addrowindex == undefined) {
		teachergrid.datagrid("insertRow", {
			index : 0,
			row : {
				teacher_no : "",
				teacher_name : "",
				teacher_sex : "",
				create_date:"",
				charger:false
			}
		}).datagrid("beginEdit", 0);
		addrowindex = 0;
	}
}
// 保存单行
function saverow(target) {
	var index = getRowIndex(target);
	teachergrid.datagrid('endEdit', index);
}
// 取消单行的编辑状态
function cancelrow(target) {
	var index = getRowIndex(target);
	if (addrowindex == index) {// 添加行时取消
		teachergrid.datagrid('deleteRow', index);
		addrowindex = undefined;
	} else
		teachergrid.datagrid('cancelEdit', index);
}
// 进入单行编辑状态
function editrow(target) {
	var index = getRowIndex(target);
	teachergrid.datagrid('beginEdit', index);
}
// 删除单行
function deleterow(target) {
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
				for (var i = 0; i < rows.length; i++) {
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
					readersgrid.datagrid("refreshRow",i);
				}
			}
		});
	} else {
		parent.$.messager.alert('提示', "请选择需要删除的记录！");
	}
}
// 先验证编辑行中的数据，无错误后，退出所有的编辑模式
function endEdit() {
	var validate = 0;// 无法退出编辑模式的行数目
	var rows = teachergrid.datagrid('getRows');
	for (var i = 0; i < rows.length; i++) {
		if (teachergrid.datagrid('validateRow', i))
			teachergrid.datagrid('endEdit', i);
		else
			validate++;
	}
	return validate > 0 ? false : true;// 返回false表示有错误无法退出编辑模式
}
// 将读者Grid中的添加修改删除数据写入隐藏input中，通过form提交给后台处理
function accept() {
	var inputdiv = $("#changeinput").empty();
	var insertrows = teachergrid.datagrid('getChanges', "inserted");
	var deleterows = teachergrid.datagrid('getChanges', "deleted");
	var updaterows = teachergrid.datagrid('getChanges', "updated");
	console.info(JSON.stringify(insertrows));
	console.info(JSON.stringify(deleterows));
	console.info(JSON.stringify(updaterows));
	if (insertrows.length > 0) {
		jQuery("<input type='hidden' name='addrows' value='" + encodeURI(JSON.stringify(insertrows)) + "' />").appendTo(inputdiv);
	}
	if (deleterows.length > 0) {
		var deletedata = [];
		for (var i = 0; i < deleterows.length; i++) {
			deletedata.push(deleterows[i].id);
		}
		jQuery("<input type='hidden' name='deleterows' value='" + encodeURI(JSON.stringify(deletedata)) + "' />").appendTo(inputdiv);
	}
	if (updaterows.length > 0) {
		jQuery("<input type='hidden' name='editrows' value='" + encodeURI(JSON.stringify(updaterows)) + "' />").appendTo(inputdiv);
	}
}


function listinfo(){
	parent.$.modalDialogTwo({
		title:"教师管理",
		width:500,
	    height:300,
	    href:'teacherInfo/forwardAdd.do',
	    buttons:[{
	    	text:'添加',
	    	handler:function(){
	    		parent.$.modalDialogTwo.openner_grid=teachergrid;
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
	    		addrowindex=undefined;
	    		parent.$.modalDialogTwo.handler.dialog('close');
	    	}
	    },{
	    	text:'取消',
	    	handler:function(){
	    		parent.$.modalDialogTwo.handle.dialog('close');
	    	}
	    }]
	});
}
