var teachergrid;
$(function() {
	if ('${AjaxMsg.success}' == 'false') {
		parent.$.messager.alert('错误', '${AjaxMsg.msg}');
		parent.$.modalDialog.handler.dialog('close');
	}
});

// 加载子表数据
function loaddatareder(clazzid) {
	teachergrid = $("#teachergrid").datagrid({
		url : "clazz/teachergrid.do",
		queryParams : {
			clazzid : clazzid
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
			title : "班级编号",
			width : 250,
			field : "class_id",
			halign : "center"
		}, {
			title : "教师编号",
			field : "teacher_no",
			width : 120,
			halign : "center",
				editor : {
					type : "validatebox",
					options : {
						required : true,
						validType : [ 'number', 'length[8,8]' ]
					}
				}
		}, {
			title : "姓名",
			field : "teacher_name",
			width : 80,
			halign : "center",
			editor : {
				type : "validatebox",
				options : {
					required : true,
					missingMessage : "请输入姓名"
				}
			}
		}, {
			title : "性别",
			field : "teacher_sex",
			width : 70,
			halign : "center",
			align : "center",
			formatter:formatsex,
			editor : {
				type : "combobox",
				options : {
					url:"clazz/sex.do",
					valueField : 'value',
					textField : 'text',
					required : true,
					editable : false
				}
			}
		} , {
			title : "创建时间",
			field : "create_date",
			width : 70,
			halign : "center",
			align : "center",
			editor : {
				type : "datebox",			
			}
		}, {
			field : "Is_charger",
			hidden:true	
		},{
			title : "班主任",
			field : "action",
			width : 150,
			halign : "center",
			align : "center",
			formatter : formatAction
		}] ]
	});
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
//操作列格式化
function formatAction(value, row, index) {
	var s;
	if (row.charger==true) {
		s = '<span>是</span>';
	} else {
		s = '<span>否</span>';
	}
	return s;
}