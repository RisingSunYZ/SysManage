package org.apache.jsp.WEB_002dINF.jsp.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.hfmx.utils.SessionKey;
import com.hfmx.utils.UserInfo;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String contextPath = request.getContextPath();
 	UserInfo  sessionInfo = (UserInfo) session.getAttribute(SessionKey.UserInfoKey);

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";

      out.write('\r');
      out.write('\n');

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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/inc.jsp", out, false);
      out.write("\r\n");
      out.write("<title>My JSP 'index.jsp' starting page</title>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar index_tabs;\r\n");
      out.write("\tvar index_tabsMenu;\r\n");
      out.write("\tvar index_layout;\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\tindex_layout = $('#index_layout').layout({\r\n");
      out.write("\t\t\tfit : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t/*index_layout.layout('collapse', 'east');*/\r\n");
      out.write("\r\n");
      out.write("\t\tindex_tabs = $('#index_tabs').tabs({\r\n");
      out.write("\t\t\tfit : true,\r\n");
      out.write("\t\t\tborder : false,\r\n");
      out.write("\t\t\tonContextMenu : function(e, title) {\r\n");
      out.write("\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t\tindex_tabsMenu.menu('show', {\r\n");
      out.write("\t\t\t\t\tleft : e.pageX,\r\n");
      out.write("\t\t\t\t\ttop : e.pageY\r\n");
      out.write("\t\t\t\t}).data('tabTitle', title);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ttools : [ {\r\n");
      out.write("\t\t\t\ticonCls : 'database_refresh',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\tvar href = index_tabs.tabs('getSelected').panel('options').href;\r\n");
      out.write("\t\t\t\t\tif (href) {/*说明tab是以href方式引入的目标页面*/\r\n");
      out.write("\t\t\t\t\t\tvar index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));\r\n");
      out.write("\t\t\t\t\t\tindex_tabs.tabs('getTab', index).panel('refresh');\r\n");
      out.write("\t\t\t\t\t} else {/*说明tab是以content方式引入的目标页面*/\r\n");
      out.write("\t\t\t\t\t\tvar panel = index_tabs.tabs('getSelected').panel('panel');\r\n");
      out.write("\t\t\t\t\t\tvar frame = panel.find('iframe');\r\n");
      out.write("\t\t\t\t\t\ttry {\r\n");
      out.write("\t\t\t\t\t\t\tif (frame.length > 0) {\r\n");
      out.write("\t\t\t\t\t\t\t\tfor ( var i = 0; i < frame.length; i++) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tframe[i].contentWindow.document.write('');\r\n");
      out.write("\t\t\t\t\t\t\t\t\tframe[i].contentWindow.close();\r\n");
      out.write("\t\t\t\t\t\t\t\t\tframe[i].src = frame[i].src;\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\tif (navigator.userAgent.indexOf(\"MSIE\") > 0) {// IE特有回收内存方法\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttry {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tCollectGarbage();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t} catch (e) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t} catch (e) {\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\ticonCls : 'delete',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\tvar index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));\r\n");
      out.write("\t\t\t\t\tvar tab = index_tabs.tabs('getTab', index);\r\n");
      out.write("\t\t\t\t\tif (tab.panel('options').closable) {\r\n");
      out.write("\t\t\t\t\t\tindex_tabs.tabs('close', index);\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert('提示', '[' + tab.panel('options').title + ']不可以被关闭！', 'error');\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} ]\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tindex_tabsMenu = $('#index_tabsMenu').menu({\r\n");
      out.write("\t\t\tonClick : function(item) {\r\n");
      out.write("\t\t\t\tvar curTabTitle = $(this).data('tabTitle');\r\n");
      out.write("\t\t\t\tvar type = $(item.target).attr('title');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif (type === 'refresh') {\r\n");
      out.write("\t\t\t\t\tindex_tabs.tabs('getTab', curTabTitle).panel('refresh');\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif (type === 'close') {\r\n");
      out.write("\t\t\t\t\tvar t = index_tabs.tabs('getTab', curTabTitle);\r\n");
      out.write("\t\t\t\t\tif (t.panel('options').closable) {\r\n");
      out.write("\t\t\t\t\t\tindex_tabs.tabs('close', curTabTitle);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tvar allTabs = index_tabs.tabs('tabs');\r\n");
      out.write("\t\t\t\tvar closeTabsTitle = [];\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t$.each(allTabs, function() {\r\n");
      out.write("\t\t\t\t\tvar opt = $(this).panel('options');\r\n");
      out.write("\t\t\t\t\tif (opt.closable && opt.title != curTabTitle && type === 'closeOther') {\r\n");
      out.write("\t\t\t\t\t\tcloseTabsTitle.push(opt.title);\r\n");
      out.write("\t\t\t\t\t} else if (opt.closable && type === 'closeAll') {\r\n");
      out.write("\t\t\t\t\t\tcloseTabsTitle.push(opt.title);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tfor ( var i = 0; i < closeTabsTitle.length; i++) {\r\n");
      out.write("\t\t\t\t\tindex_tabs.tabs('close', closeTabsTitle[i]);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar loginFun = function() {\r\n");
      out.write("\t\t\tif ($('#loginDialog form').form('validate')) {\r\n");
      out.write("\t\t\t\t$('#loginBtn').linkbutton('disable');\r\n");
      out.write("\t\t\t\t$.post('");
      out.print(basePath);
      out.write("sys/loginVali.do', $('#loginDialog form').serialize(), function(result) {\r\n");
      out.write("\t\t\t\t\tif (result.success) {\r\n");
      out.write("\t\t\t\t\t\t$('#loginDialog').dialog('close');\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert('提示', result.msg, 'error', function() {\r\n");
      out.write("\t\t\t\t\t\t\t$('#loginDialog form :input:eq(1)').focus();\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t$('#loginBtn').linkbutton('enable');\r\n");
      out.write("\t\t\t\t}, 'json');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t$('#loginDialog').show().dialog({\r\n");
      out.write("\t\t\tmodal : true,\r\n");
      out.write("\t\t\tclosable : false,\r\n");
      out.write("\t\t\ticonCls : 'ext-icon-lock_open',\r\n");
      out.write("\t\t\tbuttons : [ {\r\n");
      out.write("\t\t\t\tid : 'loginBtn',\r\n");
      out.write("\t\t\t\ttext : '登录',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\tloginFun();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\tonOpen : function() {\r\n");
      out.write("\t\t\t\t$('#loginDialog form :input[name=\"data.pwd\"]').val('');\r\n");
      out.write("\t\t\t\t$('form :input').keyup(function(event) {\r\n");
      out.write("\t\t\t\t\tif (event.keyCode == 13) {\r\n");
      out.write("\t\t\t\t\t\tloginFun();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}).dialog('close');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t$('#passwordDialog').show().dialog({\r\n");
      out.write("\t\t\tmodal : true,\r\n");
      out.write("\t\t\tclosable : true,\r\n");
      out.write("\t\t\ticonCls : 'ext-icon-lock_edit',\r\n");
      out.write("\t\t\tbuttons : [ {\r\n");
      out.write("\t\t\t\ttext : '修改',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\tif ($('#passwordDialog form').form('validate')) {\r\n");
      out.write("\t\t\t\t\t\t$.post('");
      out.print(basePath);
      out.write("/sys/updatePWD.do', {\r\n");
      out.write("\t\t\t\t\t\t\t'Password' : $('#pwd').val()\r\n");
      out.write("\t\t\t\t\t\t}, function(result) {\r\n");
      out.write("\t\t\t\t\t\t\tif (result.success) {\r\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.alert('提示', '密码修改成功！', 'info');\r\n");
      out.write("\t\t\t\t\t\t\t\t$('#passwordDialog').dialog('close');\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.alert('提示', '密码修改失败！', 'info');\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}, 'json');\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\tonOpen : function() {\r\n");
      out.write("\t\t\t\t$('#passwordDialog form :input').val('');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}).dialog('close');\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"easyui-layout\" id=\"index_layout\">\r\n");
      out.write("\r\n");
      out.write("\t<div data-options=\"region:'north',href:'");
      out.print(basePath);
      out.write("jsp/sys/north.do'\"\r\n");
      out.write("\t\tstyle=\"height: 70px; overflow: hidden;\" class=\"logo\"></div>\r\n");
      out.write("\t<div\r\n");
      out.write("\t\tdata-options=\"region:'south',href:'");
      out.print(basePath);
      out.write("jsp/sys/south.do',border:false\"\r\n");
      out.write("\t\tstyle=\"height: 30px; overflow: hidden;\"></div>\r\n");
      out.write("\r\n");
      out.write("\t<!--   <div data-options=\"region:'east',title:'East',split:true,href:'");
      out.print(basePath);
      out.write("jsp/sys/east'\"\r\n");
      out.write("\t\tstyle=\"width:100px;\"></div> \r\n");
      out.write("\t-->\r\n");
      out.write("\t<div data-options=\"region:'west',href:'");
      out.print(basePath);
      out.write("jsp/sys/west.do',split:true\" title=\"导航\"\r\n");
      out.write("\t\tstyle=\"width: 200px; overflow: hidden; padding: 10px;\">\r\n");
      out.write("\t\t<ul id=\"mainMenu\"></ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div data-options=\"region:'center'\" title=\"\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t<div id=\"index_tabs\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t<div title=\"首页\" data-options=\"border:false\" style=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t<iframe name=\"center\" src=\"");
      out.print(basePath);
      out.write("jsp/portal/index.do\" frameborder=\"0\" style=\"border: 0; width: 100%; height: 98%;\"></iframe>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"index_tabsMenu\" style=\"width: 120px; display: none;\">\r\n");
      out.write("\t\t<div title=\"refresh\" data-options=\"iconCls:'transmit'\">刷新</div>\r\n");
      out.write("\t\t<div class=\"menu-sep\"></div>\r\n");
      out.write("\t\t<div title=\"close\" data-options=\"iconCls:'delete'\">关闭</div>\r\n");
      out.write("\t\t<div title=\"closeOther\" data-options=\"iconCls:'delete'\">关闭其他</div>\r\n");
      out.write("\t\t<div title=\"closeAll\" data-options=\"iconCls:'delete'\">关闭所有</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"loginDialog\" title=\"解锁登录\" style=\"display: none;\">\r\n");
      out.write("\t\t<form method=\"post\" class=\"form\" >\r\n");
      out.write("\t\t\t<table class=\"table\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th width=\"50\">登录名</th>\r\n");
      out.write("\t\t\t\t\t ");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td><input name=\"userName\"  value=\"\" class=\"easyui-validatebox\" data-options=\"required:true\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>密码</th>\r\n");
      out.write("\t\t\t\t\t<td><input name=\"password\" type=\"password\" class=\"easyui-validatebox\" data-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"passwordDialog\" title=\"修改密码\" style=\"display: none;\">\r\n");
      out.write("\t\t<form method=\"post\" class=\"form\" >\r\n");
      out.write("\t\t\t<table class=\"table\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>新密码</th>\r\n");
      out.write("\t\t\t\t\t<td><input id=\"pwd\" name=\"data.pwd\" type=\"password\" class=\"easyui-validatebox\" data-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>重复密码</th>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" class=\"easyui-validatebox\" data-options=\"required:true,validType:'eqPwd[\\'#pwd\\']'\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
