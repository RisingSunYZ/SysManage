<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript">
	var ccgrid = $('#ccgrid').combogrid({
		required : true,
		loadMsg : '数据加载中...',
		panelWidth : 450,
		fitColumns : true,
		value : '',
		idField : 'id',
		textField : 'name',
		sortName : "id",// 默认排序
		sortOrder : "asc",
		mode : 'remote',
		url : "book/grid.do",
		pagination : true,
		pageSize : 5,
		pageList : [ 5, 10 ],
		columns : [ [ {
			field : 'id',
			title : 'ID',
			width : 60,
			sortable : true
		}, {
			field : 'name',
			title : 'Name',
			width : 100,
			sortable : true
		}, {
			field : 'model',
			title : '型号',
			width : 120,
			sortable : true
		}, {
			field : 'sellprice',
			title : '销售价',
			width : 100,
			sortable : true
		} ] ],
		delay : 500
	});
	function getCCGridValue() {
		alert(ccgrid.combogrid('getValue') + '_' + ccgrid.combogrid('getText'));
	}
</script>
<input id="ccgrid">
<input id="getselect" value="get" onclick="getCCGridValue()"
	type="button">