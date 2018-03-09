<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript">
$(function(){
$('#cctv').combotree({
		 required : true,
		 checkbox:true,
		 multiple:true,
		 url:'<%=basePath%>sys/sysmenu.do'
		});//返回了checked
		//$('#cctv').combotree('setValues', [1,2,6]);
	});
</script>
<input id="cctv">
