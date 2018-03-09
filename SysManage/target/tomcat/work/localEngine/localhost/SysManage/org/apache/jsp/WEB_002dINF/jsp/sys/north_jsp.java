package org.apache.jsp.WEB_002dINF.jsp.sys;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.hfmx.utils.SessionKey;

public final class north_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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

	String contextPath = request.getContextPath();
	com.hfmx.utils.UserInfo sessionInfo = (com.hfmx.utils.UserInfo) session.getAttribute(SessionKey.UserInfoKey);

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";

      out.write("\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\">\r\n");
      out.write("\tvar logoutFun = function() {\r\n");
      out.write("\t\t$.post('");
      out.print(basePath);
      out.write("/sys/logout.do', function(result) {\r\n");
      out.write("\t\t\tlocation.replace('");
      out.print(basePath);
      out.write("');\r\n");
      out.write("\t\t}, 'json');\r\n");
      out.write("\t};\r\n");
      out.write("\tvar showMyInfoFun = function() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar dialog = parent.$.modalDialog({\r\n");
      out.write("\t\t\ttitle : '我的信息',\r\n");
      out.write("\t\t\twidth : 300,\r\n");
      out.write("\t\t\theight : 250,\r\n");
      out.write("\t\t\thref :'");
      out.print(basePath);
      out.write("jsp/welcome'\r\n");
      out.write("\t\t\t//href : '");
      out.print(basePath);
      out.write("book/test.do',\r\n");
      out.write("\t\t});\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("<div id=\"sessionInfoDiv\" style=\"position: absolute; right: 10px; top: 5px;\">\r\n");
      out.write("\t");

		if (sessionInfo != null) {
			out.print(com.hfmx.utils.StringUtil.formateString("欢迎您，{0}", sessionInfo.getUser().getUserName()));
		}
	
      out.write("\r\n");
      out.write("</div> \r\n");
      out.write("<div style=\"position: absolute; right: 0px; bottom: 0px;\">\r\n");
      out.write("\t<a href=\"javascript:void(0);\" class=\"easyui-menubutton\" data-options=\"menu:'#layout_north_pfMenu',iconCls:'cog'\">更换皮肤</a> <a href=\"javascript:void(0);\" class=\"easyui-menubutton\" data-options=\"menu:'#layout_north_kzmbMenu',iconCls:'cog'\">控制面板</a> <a href=\"javascript:void(0);\" class=\"easyui-menubutton\" data-options=\"menu:'#layout_north_zxMenu',iconCls:'cog'\">注销</a>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"layout_north_pfMenu\" style=\"width: 120px; display: none;\">\r\n");
      out.write("\t<div onclick=\"$.changeTheme('default');\" title=\"default\">default</div> \r\n");
      out.write("\t<div onclick=\"$.changeTheme('gray');\" title=\"gray\">gray</div>\r\n");
      out.write("\t<div onclick=\"$.changeTheme('metro');\" title=\"metro\">metro</div>\r\n");
      out.write("\t<div onclick=\"$.changeTheme('bootstrap');\" title=\"bootstrap\">bootstrap</div>\r\n");
      out.write("\t<div onclick=\"$.changeTheme('black');\" title=\"black\">black</div>\r\n");
      out.write("\t<div class=\"menu-sep\"></div>\r\n");
      out.write("\t<div onclick=\"$.changeTheme('metro-blue');\" title=\"metro-blue\">metro-blue</div>\r\n");
      out.write("\t<div onclick=\"$.changeTheme('metro-gray');\" title=\"metro-gray\">metro-gray</div>\r\n");
      out.write("\t<div onclick=\"$.changeTheme('metro-green');\" title=\"metro-green\">metro-green</div>\r\n");
      out.write("\t<div onclick=\"$.changeTheme('metro-orange');\" title=\"metro-orange\">metro-orange</div>\r\n");
      out.write("\t<div onclick=\"$.changeTheme('metro-red');\" title=\"metro-red\">metro-red</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"layout_north_kzmbMenu\" style=\"width: 100px; display: none;\">\r\n");
      out.write("\t<div data-options=\"iconCls:'ext-icon-user_edit'\" onclick=\"$('#passwordDialog').dialog('open');\">修改密码</div>\r\n");
      out.write("\t<div class=\"menu-sep\"></div>\r\n");
      out.write("\t<div data-options=\"iconCls:'ext-icon-user'\" onclick=\"showMyInfoFun();\">我的信息</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"layout_north_zxMenu\" style=\"width: 100px; display: none;\">\r\n");
      out.write("\t<div data-options=\"iconCls:'ext-icon-lock'\" onclick=\"$('#loginDialog').dialog('open');\">锁定窗口</div>\r\n");
      out.write("\t<div class=\"menu-sep\"></div>\r\n");
      out.write("\t<div data-options=\"iconCls:'ext-icon-door_out'\" onclick=\"logoutFun();\">退出系统</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
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
