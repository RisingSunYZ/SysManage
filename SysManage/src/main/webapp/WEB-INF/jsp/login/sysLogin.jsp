<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	java.util.Map<String, Cookie> cookieMap = new java.util.HashMap<String, Cookie>();
	Cookie[] cookies = request.getCookies();
	if (null != cookies) {
		for (Cookie cookie : cookies) {
			cookieMap.put(cookie.getName(), cookie);
		}
	}
	String easyuiTheme = "bootstrap";//指定如果用户未选择样式，那么初始化一个默认样式
	if (cookieMap.containsKey("easyuiTheme")) {
		Cookie cookie = (Cookie) cookieMap.get("easyuiTheme");
		easyuiTheme = cookie.getValue();
	}
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<!-- <jsp:include page="/WEB-INF/jsp/inc.jsp"></jsp:include> -->
<script type="text/javascript" src="scripts/jqueryUI/jquery-1.9.1.js"></script>
<script type="text/javascript" src="scripts/jqueryUI/jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="scripts/jqueryUI/jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="scripts/jqueryUI/jquery-easyui-1.3.4/themes/icon.css" type="text/css"></link>
<link rel="stylesheet" href="scripts/jqueryUI/jquery-easyui-1.3.4/themes/default/easyui.css" type="text/css"></link>
<script type="text/javascript" src="scripts/syUtilis.js"></script>

<link rel="stylesheet" id="easyuiTheme"
	href="scripts/jqueryUI/jquery-easyui-1.3.4/themes/<c:out value="${cookie.easyuiTheme.value}" default="default"/>/easyui.css"
	type="text/css"></link>
<script type="text/javascript" src="scripts/jquery.cookie.js"></script>
<script type="text/javascript">
	var loginDialog;
	$(function() {

		loginDialog = $('#dd').dialog({
			modal : true,
			closable : false,
			buttons : [ {
				text : '注册',
				handler : function() {
					alert('注册' + sybp());
				}
			}, {
				id : 'loginBtn',
				text : '登陆',
				handler : function() {
					$('#loginForm').submit();
				}
			} ]
		});

		loginForm = $('#loginForm').form({
			url : sybp() + '/sys/loginVali.do',
			success : function(data) {
				// data=eval("("+data+")");
				console.info(data);
				data = $.parseJSON(data);
				console.info(data);
				console.info(data.msg);
				console.info(data.success);
				if (data && data.success) {
					loginDialog.dialog('close');
					$.messager.show({
						title : '提示',
						msg : data.msg
					});
					location.replace(sybp() + '/jsp/login/index.do');
				} else {

					$.messager.alert('提示', data.msg);

				}
			}
		});

		loginForm.find('input').on('keyup', function(event) {
			if (event.keyCode == '13') {
				loginForm.submit();
			}
		});
		$.extend($.fn.validatebox.defaults.rules, {
			minLength : {
				validator : function(value, param) {
					return value.length >= param[0];
				},
				message : '至少输入 {0} 字符.'
			}
		});

	});
</script>
<title>My JSP 'test1.jsp' starting page</title>
</head>
<body>
	主页登陆
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<div id="dd" title="用户登录" style="width: 300px; heigth: 300px">
		<form action="" id="loginForm" method="post">
			<table>
				<tr>
					<th>用户名</th>
					<td>
						<input name="userName" value="admin" class="easyui-validatebox" data-options="required:true" missingMessage="用户名必填" />
					</td>
				</tr>
				<tr>
					<th>密码</th>
					<td>
						<input name="password" value="admin" type="password" class="easyui-validatebox" data-options="required:true,validType:'minLength[5]'"
							missingMessage=“密码必填” />
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
