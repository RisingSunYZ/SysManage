package org.apache.jsp.WEB_002dINF.jsp.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class sysLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fdefault_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fdefault_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fdefault_005fnobody.release();
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

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
      out.write("<!-- ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/inc.jsp", out, false);
      out.write(" -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"scripts/jqueryUI/jquery-1.9.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"scripts/jqueryUI/jquery-easyui-1.3.4/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"scripts/jqueryUI/jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"scripts/jqueryUI/jquery-easyui-1.3.4/themes/icon.css\" type=\"text/css\"></link>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"scripts/jqueryUI/jquery-easyui-1.3.4/themes/default/easyui.css\" type=\"text/css\"></link>\r\n");
      out.write("<script type=\"text/javascript\" src=\"scripts/syUtilis.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" id=\"easyuiTheme\"\r\n");
      out.write("\thref=\"scripts/jqueryUI/jquery-easyui-1.3.4/themes/");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("/easyui.css\"\r\n");
      out.write("\ttype=\"text/css\"></link>\r\n");
      out.write("<script type=\"text/javascript\" src=\"scripts/jquery.cookie.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar loginDialog;\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\r\n");
      out.write("\t\tloginDialog = $('#dd').dialog({\r\n");
      out.write("\t\t\tmodal : true,\r\n");
      out.write("\t\t\tclosable : false,\r\n");
      out.write("\t\t\tbuttons : [ {\r\n");
      out.write("\t\t\t\ttext : '注册',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\talert('注册' + sybp());\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\tid : 'loginBtn',\r\n");
      out.write("\t\t\t\ttext : '登陆',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t$('#loginForm').submit();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} ]\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tloginForm = $('#loginForm').form({\r\n");
      out.write("\t\t\turl : sybp() + '/sys/loginVali.do',\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t// data=eval(\"(\"+data+\")\");\r\n");
      out.write("\t\t\t\tconsole.info(data);\r\n");
      out.write("\t\t\t\tdata = $.parseJSON(data);\r\n");
      out.write("\t\t\t\tconsole.info(data);\r\n");
      out.write("\t\t\t\tconsole.info(data.msg);\r\n");
      out.write("\t\t\t\tconsole.info(data.success);\r\n");
      out.write("\t\t\t\tif (data && data.success) {\r\n");
      out.write("\t\t\t\t\tloginDialog.dialog('close');\r\n");
      out.write("\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\ttitle : '提示',\r\n");
      out.write("\t\t\t\t\t\tmsg : data.msg\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\tlocation.replace(sybp() + '/jsp/login/index.do');\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t$.messager.alert('提示', data.msg);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tloginForm.find('input').on('keyup', function(event) {\r\n");
      out.write("\t\t\tif (event.keyCode == '13') {\r\n");
      out.write("\t\t\t\tloginForm.submit();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$.extend($.fn.validatebox.defaults.rules, {\r\n");
      out.write("\t\t\tminLength : {\r\n");
      out.write("\t\t\t\tvalidator : function(value, param) {\r\n");
      out.write("\t\t\t\t\treturn value.length >= param[0];\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tmessage : '至少输入 {0} 字符.'\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<title>My JSP 'test1.jsp' starting page</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t主页登陆\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<div id=\"dd\" title=\"用户登录\" style=\"width: 300px; heigth: 300px\">\r\n");
      out.write("\t\t<form action=\"\" id=\"loginForm\" method=\"post\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>用户名</th>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input name=\"userName\" value=\"admin\" class=\"easyui-validatebox\" data-options=\"required:true\" missingMessage=\"用户名必填\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>密码</th>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input name=\"password\" value=\"admin\" type=\"password\" class=\"easyui-validatebox\" data-options=\"required:true,validType:'minLength[5]'\"\r\n");
      out.write("\t\t\t\t\t\t\tmissingMessage=“密码必填” />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_005fout_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fdefault_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /WEB-INF/jsp/login/sysLogin.jsp(35,51) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cookie.easyuiTheme.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/login/sysLogin.jsp(35,51) name = default type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setDefault("default");
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fdefault_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fdefault_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }
}
