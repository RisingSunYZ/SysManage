<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript">
	var cmb;
	cmb=$('#cc').combobox({
		width:200,
		//url :'<%=basePath%>product/CMB.do',
		//url:'<%=basePath%>book/cmb.do',
		//valueField : 'id',
		//textField : 'name',
		//value : 104,
		url :'<%=basePath%>jsonData/cmb.json',
		valueField : 'id',
		textField : 'text',
		filter : function(q, row) {
			var opts = $(this).combobox('options');
			 return row[opts.textField].indexOf(q) == 0;		 
		},
		required : true
	//editable : false
	});
	function getValue() {
		alert(cmb.combobox('getText') + "_" + cmb.combobox('getValue'));
	}
	
	$('#cct').combotree({
		//required : true
		checkbox:true,
		multiple:true,
		 url:'<%=basePath%>jsonData/tree_data1.json'   
		});
	$('#cct2').combotree({
		//required : true
		//checkbox:true,
		//multiple:true,
		 url:'<%=basePath%>jsonData/tree_data1.json'   
		});	
</script>

ComboBox:
<br>
<input id="cc">
<br>
<input class="easyui-combobox" required="true" missingMessage="用户名必填"
	data-options="		   
		valueField: 'label',
		textField: 'value',
		data: [{
			label: 'java',
			value: 'Java'
		},{
			label: 'perl',
			value: 'Perl'
		},{
			label: 'ruby',
			value: 'Ruby'
		}]" />
<br>
<input value="get" onclick="getValue()" type="button" />
<br>
<input id="cct">
<input id="cct2">

