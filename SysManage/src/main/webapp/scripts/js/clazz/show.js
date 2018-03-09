var teachergrid;
$(function() {
	if ('${AjaxMsg.success}' == 'false') {
		parent.$.messager.alert('错误', '${AjaxMsg.msg}');
		parent.$.modalDialog.handler.dialog('close');
	}
});

// 加载子表数据
function loaddatareder(clazz_id) {
	readersgrid = $("#teachergrid").datagrid({
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
			title : "老师编号",
			field : "no",
			width : 50,
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
			title : "性别",
			field : "sex",
			width : 80,
			halign : "center",
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
		}, {
			title : "添加时间",
			field : "date",
			width : 100,
			halign : "center",
			align : "center",
			//formatter : formatNumOrFloat,
			editor : {
				type : "datebox",
			/*
			 * options : { validType : "number" }
			 */
			}
		}, {
			field:"charger",
			hidden:true		
		},{
			title : "班主任",
			field : "action",
			width : 150,
			halign : "center",
			align : "center",
			formatter : formatAction
		} ] ]
	});
}

//性别格式化
function formatsex(value, row, index){
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