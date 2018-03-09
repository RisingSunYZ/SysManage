<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<!-- 引入my97日期时间控件 -->
<script type="text/javascript" src="<%=basePath%>scripts/jqueryUI/My97DatePicker4.8Beta3/My97DatePicker/WdatePicker.js" charset="utf-8"></script>

<!-- 引入kindEditor插件 -->

<!-- 引入jQuery -->
<script src="<%=basePath%>scripts/jqueryUI/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>scripts/jquery.cookie.js"></script>
<!-- 引入Highcharts -->
<%-- <script src="<%=basePath%>scripts/jqueryUI/Highcharts-3.0.5/js/highcharts.js" type="text/javascript" charset="utf-8"></script> --%>

<!-- 引入文件上传 -->
<script type="text/javascript" src="<%=basePath%>scripts/jqueryUI/fileupload/ajaxfileupload-1.0.js"></script>
<script type="text/javascript" src="<%=basePath%>scripts/jqueryUI/fileupload/jquery.mxupload-1.0.js"></script>
<link rel="stylesheet" href="<%=basePath%>scripts/jqueryUI/fileupload/process.css" type="text/css"></link>



<!-- 引入EasyUI -->
<link id="easyuiTheme" rel="stylesheet"
	href="<%=basePath%>scripts/jqueryUI/jquery-easyui-1.3.4/themes/<c:out value="${cookie.easyuiTheme.value}" default="bootstrap"/>/easyui.css"
	type="text/css">

<link rel="stylesheet" href="<%=basePath%>scripts/jqueryUI/jquery-easyui-1.3.4/themes/icon.css" type="text/css"></link>

<script type="text/javascript" src="<%=basePath%>scripts/jqueryUI/jquery-easyui-1.3.4/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>scripts/jqueryUI/jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<!-- 修复EasyUI1.3.3中layout组件的BUG -->
<script type="text/javascript" src="<%=basePath%>scripts/jqueryUI/jquery-easyui-1.3.4/plugins/jquery.layout.js" charset="utf-8"></script>

<!-- 引入EasyUI Portal插件 -->
<link rel="stylesheet" href="<%=basePath%>scripts/jqueryUI/jquery-easyui-portal/portal.css" type="text/css">
<script type="text/javascript" src="<%=basePath%>scripts/jqueryUI/jquery-easyui-portal/jquery.portal.js" charset="utf-8"></script>

<!-- json对象与json字符串相互转换 -->
<script type="text/javascript" src="<%=basePath%>scripts/jqueryUI/json2.js"></script>

<!-- 扩展EasyUI -->
<script type="text/javascript" src="<%=basePath%>scripts/jqueryUI/extEasyUI.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>scripts/jqueryUI/extBrowser.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>scripts/jqueryUI/extByHFMX.js" charset="utf-8"></script>

<!-- 扩展jQuery -->
<script type="text/javascript" src="<%=basePath%>scripts/jqueryUI/extJquery.js" charset="utf-8"></script>

<!-- 自定义扩展 -->
<script type="text/javascript" src="<%=basePath%>scripts/syUtilis.js"></script>

<!-- 扩展EasyUI Icon -->
<link rel="stylesheet" href="<%=basePath%>scripts/jqueryUI/style/extEasyUIIcon.css?v=201305301906" type="text/css">
<!-- 引入bootstrap样式 -->
<!-- <link href="scripts/jqueryUI/bootstrap-2.3.1/css/bootstrap.min.css"
	rel="stylesheet" media="screen"> -->

<!-- 改写Grid行选中颜色(梅江顺) -->
<style type="text/css">
.datagrid-row-selected {
	/* Grid单击行变成蓝色 */
	background: #3baae3 repeat-x 50% 50%;
	color: #fff;
}
</style>