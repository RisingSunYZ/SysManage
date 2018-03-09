<%@page import="com.hfmx.utils.SessionKey"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	com.hfmx.utils.UserInfo sessionInfo = (com.hfmx.utils.UserInfo) session.getAttribute(SessionKey.UserInfoKey);
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<script type="text/javascript" charset="utf-8">
	var logoutFun = function() {
		$.post('<%=basePath%>/sys/logout.do', function(result) {
			location.replace('<%=basePath%>');
		}, 'json');
	};
	var showMyInfoFun = function() {
		
		var dialog = parent.$.modalDialog({
			title : '我的信息',
			width : 300,
			height : 250,
			href :'<%=basePath%>jsp/welcome'
			//href : '<%=basePath%>book/test.do',
		});
	};
</script>
<div id="sessionInfoDiv" style="position: absolute; right: 10px; top: 5px;">
	<%
		if (sessionInfo != null) {
			out.print(com.hfmx.utils.StringUtil.formateString("欢迎您，{0}", sessionInfo.getUser().getUserName()));
		}
	%>
</div> 
<div style="position: absolute; right: 0px; bottom: 0px;">
	<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'cog'">更换皮肤</a> <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_kzmbMenu',iconCls:'cog'">控制面板</a> <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_zxMenu',iconCls:'cog'">注销</a>
</div>
<div id="layout_north_pfMenu" style="width: 120px; display: none;">
	<div onclick="$.changeTheme('default');" title="default">default</div> 
	<div onclick="$.changeTheme('gray');" title="gray">gray</div>
	<div onclick="$.changeTheme('metro');" title="metro">metro</div>
	<div onclick="$.changeTheme('bootstrap');" title="bootstrap">bootstrap</div>
	<div onclick="$.changeTheme('black');" title="black">black</div>
	<div class="menu-sep"></div>
	<div onclick="$.changeTheme('metro-blue');" title="metro-blue">metro-blue</div>
	<div onclick="$.changeTheme('metro-gray');" title="metro-gray">metro-gray</div>
	<div onclick="$.changeTheme('metro-green');" title="metro-green">metro-green</div>
	<div onclick="$.changeTheme('metro-orange');" title="metro-orange">metro-orange</div>
	<div onclick="$.changeTheme('metro-red');" title="metro-red">metro-red</div>
</div>
<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
	<div data-options="iconCls:'ext-icon-user_edit'" onclick="$('#passwordDialog').dialog('open');">修改密码</div>
	<div class="menu-sep"></div>
	<div data-options="iconCls:'ext-icon-user'" onclick="showMyInfoFun();">我的信息</div>
</div>
<div id="layout_north_zxMenu" style="width: 100px; display: none;">
	<div data-options="iconCls:'ext-icon-lock'" onclick="$('#loginDialog').dialog('open');">锁定窗口</div>
	<div class="menu-sep"></div>
	<div data-options="iconCls:'ext-icon-door_out'" onclick="logoutFun();">退出系统</div>
</div>

