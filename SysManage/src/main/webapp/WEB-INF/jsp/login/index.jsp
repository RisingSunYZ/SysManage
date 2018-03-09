<%@page import="com.hfmx.utils.SessionKey"%>
<%@page import="com.hfmx.utils.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
 	UserInfo  sessionInfo = (UserInfo) session.getAttribute(SessionKey.UserInfoKey);
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
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
<jsp:include page="/WEB-INF/jsp/inc.jsp"></jsp:include>
<title>My JSP 'index.jsp' starting page</title>

<script type="text/javascript">
	var index_tabs;
	var index_tabsMenu;
	var index_layout;
	$(function() {
		index_layout = $('#index_layout').layout({
			fit : true
		});
		/*index_layout.layout('collapse', 'east');*/

		index_tabs = $('#index_tabs').tabs({
			fit : true,
			border : false,
			onContextMenu : function(e, title) {
				e.preventDefault();
				index_tabsMenu.menu('show', {
					left : e.pageX,
					top : e.pageY
				}).data('tabTitle', title);
			},
			tools : [ {
				iconCls : 'database_refresh',
				handler : function() {
					var href = index_tabs.tabs('getSelected').panel('options').href;
					if (href) {/*说明tab是以href方式引入的目标页面*/
						var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
						index_tabs.tabs('getTab', index).panel('refresh');
					} else {/*说明tab是以content方式引入的目标页面*/
						var panel = index_tabs.tabs('getSelected').panel('panel');
						var frame = panel.find('iframe');
						try {
							if (frame.length > 0) {
								for ( var i = 0; i < frame.length; i++) {
									frame[i].contentWindow.document.write('');
									frame[i].contentWindow.close();
									frame[i].src = frame[i].src;
								}
								if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
									try {
										CollectGarbage();
									} catch (e) {
									}
								}
							}
						} catch (e) {
						}
					}
				}
			}, {
				iconCls : 'delete',
				handler : function() {
					var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
					var tab = index_tabs.tabs('getTab', index);
					if (tab.panel('options').closable) {
						index_tabs.tabs('close', index);
					} else {
						$.messager.alert('提示', '[' + tab.panel('options').title + ']不可以被关闭！', 'error');
					}
				}
			} ]
		});

		index_tabsMenu = $('#index_tabsMenu').menu({
			onClick : function(item) {
				var curTabTitle = $(this).data('tabTitle');
				var type = $(item.target).attr('title');

				if (type === 'refresh') {
					index_tabs.tabs('getTab', curTabTitle).panel('refresh');
					return;
				}

				if (type === 'close') {
					var t = index_tabs.tabs('getTab', curTabTitle);
					if (t.panel('options').closable) {
						index_tabs.tabs('close', curTabTitle);
					}
					return;
				}

				var allTabs = index_tabs.tabs('tabs');
				var closeTabsTitle = [];

				$.each(allTabs, function() {
					var opt = $(this).panel('options');
					if (opt.closable && opt.title != curTabTitle && type === 'closeOther') {
						closeTabsTitle.push(opt.title);
					} else if (opt.closable && type === 'closeAll') {
						closeTabsTitle.push(opt.title);
					}
				});

				for ( var i = 0; i < closeTabsTitle.length; i++) {
					index_tabs.tabs('close', closeTabsTitle[i]);
				}
			}
		});
		
		var loginFun = function() {
			if ($('#loginDialog form').form('validate')) {
				$('#loginBtn').linkbutton('disable');
				$.post('<%=basePath%>sys/loginVali.do', $('#loginDialog form').serialize(), function(result) {
					if (result.success) {
						$('#loginDialog').dialog('close');
					} else {
						$.messager.alert('提示', result.msg, 'error', function() {
							$('#loginDialog form :input:eq(1)').focus();
						});
					}
					$('#loginBtn').linkbutton('enable');
				}, 'json');
			}
		};
		$('#loginDialog').show().dialog({
			modal : true,
			closable : false,
			iconCls : 'ext-icon-lock_open',
			buttons : [ {
				id : 'loginBtn',
				text : '登录',
				handler : function() {
					loginFun();
				}
			} ],
			onOpen : function() {
				$('#loginDialog form :input[name="data.pwd"]').val('');
				$('form :input').keyup(function(event) {
					if (event.keyCode == 13) {
						loginFun();
					}
				});
			}
		}).dialog('close');
		
		
			$('#passwordDialog').show().dialog({
			modal : true,
			closable : true,
			iconCls : 'ext-icon-lock_edit',
			buttons : [ {
				text : '修改',
				handler : function() {
					if ($('#passwordDialog form').form('validate')) {
						$.post('<%=basePath%>/sys/updatePWD.do', {
							'Password' : $('#pwd').val()
						}, function(result) {
							if (result.success) {
								$.messager.alert('提示', '密码修改成功！', 'info');
								$('#passwordDialog').dialog('close');
							}
							else{
								$.messager.alert('提示', '密码修改失败！', 'info');
							}
						}, 'json');
					}
				}
			} ],
			onOpen : function() {
				$('#passwordDialog form :input').val('');
			}
		}).dialog('close');
	});
</script>
</head>

<body class="easyui-layout" id="index_layout">

	<div data-options="region:'north',href:'<%=basePath%>jsp/sys/north.do'"
		style="height: 70px; overflow: hidden;" class="logo"></div>
	<div
		data-options="region:'south',href:'<%=basePath%>jsp/sys/south.do',border:false"
		style="height: 30px; overflow: hidden;"></div>

	<!--   <div data-options="region:'east',title:'East',split:true,href:'<%=basePath%>jsp/sys/east'"
		style="width:100px;"></div> 
	-->
	<div data-options="region:'west',href:'<%=basePath%>jsp/sys/west.do',split:true" title="导航"
		style="width: 200px; overflow: hidden; padding: 10px;">
		<ul id="mainMenu"></ul>
	</div>
	
	<div data-options="region:'center'" title="" style="overflow: hidden;">
			<div id="index_tabs" style="overflow: hidden;">
				<div title="首页" data-options="border:false" style="overflow: hidden;">
					<iframe name="center" src="<%=basePath%>jsp/portal/index.do" frameborder="0" style="border: 0; width: 100%; height: 98%;"></iframe>
				</div>
			</div>
		</div>


<div id="index_tabsMenu" style="width: 120px; display: none;">
		<div title="refresh" data-options="iconCls:'transmit'">刷新</div>
		<div class="menu-sep"></div>
		<div title="close" data-options="iconCls:'delete'">关闭</div>
		<div title="closeOther" data-options="iconCls:'delete'">关闭其他</div>
		<div title="closeAll" data-options="iconCls:'delete'">关闭所有</div>
	</div>
	
	<div id="loginDialog" title="解锁登录" style="display: none;">
		<form method="post" class="form" >
			<table class="table">
				<tr>
					<th width="50">登录名</th>
					 <%-- <%=sessionInfo.getUser().getUserName()%>  readonly="readonly" type="hidden"--%>
					<td><input name="userName"  value="" class="easyui-validatebox" data-options="required:true"/></td>
				</tr>
				<tr>
					<th>密码</th>
					<td><input name="password" type="password" class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="passwordDialog" title="修改密码" style="display: none;">
		<form method="post" class="form" >
			<table class="table">
				<tr>
					<th>新密码</th>
					<td><input id="pwd" name="data.pwd" type="password" class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>重复密码</th>
					<td><input type="password" class="easyui-validatebox" data-options="required:true,validType:'eqPwd[\'#pwd\']'" /></td>
				</tr>
			</table>
		</form>
	</div>
	
</body>


</html>
