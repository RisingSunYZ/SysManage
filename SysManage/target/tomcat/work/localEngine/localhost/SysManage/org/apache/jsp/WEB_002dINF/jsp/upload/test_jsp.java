package org.apache.jsp.WEB_002dINF.jsp.upload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";

      out.write("\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/inc.jsp", out, false);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$(\"#uploadbtn\").mxupload({\r\n");
      out.write("\t\t\turl : $(\"#basePath\").val() + \"file/upload.do\",\r\n");
      out.write("\t\t\tprocessurl : $(\"#basePath\").val() + \"file/progress.do\",\r\n");
      out.write("\t\t\tfileType : 'gif|jpg|png|bmp|pdf|doc',\r\n");
      out.write("\t\t\tsavefile : false,\r\n");
      out.write("\t\t\tautoSubmit : true,\r\n");
      out.write("\t\t\tbeforeSend : function() {\r\n");
      out.write("\t\t\t\tdocument.getElementById('progressBar').style.display = 'block';\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tvar fileid = data.result.fileid;\r\n");
      out.write("\t\t\t\tvar filename = data.result.fileName;\r\n");
      out.write("\t\t\t\tvar url = data.result.url;\r\n");
      out.write("\t\t\t\t$(\"#successinfo\").html(data.msg + \"<br/>文件ID:\" + fileid + \"<br/>文件名称:\" + filename + \"<br/>文件地址:\" + $(\"#basePath\").val() + url);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmessge : function(msg) {\r\n");
      out.write("\t\t\t\tif (msg != \"\")\r\n");
      out.write("\t\t\t\t\tparent.$.messager.alert('提示', msg);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tprogress : function(status, filename, loaded, total, percent) {\r\n");
      out.write("\t\t\t\t$('#pb_info').html(percent + '%(' + loaded + 'M/' + total + 'M)');\r\n");
      out.write("\t\t\t\t$('.pb-value').css({\r\n");
      out.write("\t\t\t\t\t'width' : percent + '%'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(ismsg, xhr, msg) {\r\n");
      out.write("\t\t\t\tif (ismsg)\r\n");
      out.write("\t\t\t\t\tparent.$.messager.alert('错误', msg);\r\n");
      out.write("\t\t\t\telse\r\n");
      out.write("\t\t\t\t\tparent.$.errorDialog(xhr.responseText);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<div class=\"easyui-layout\" fit=\"true\" border=\"true\">\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<input id='basePath' value='");
      out.print(basePath);
      out.write("' type=\"hidden\" />\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>上传：</th>\r\n");
      out.write("\t\t\t\t<td width=\"350\">\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<input id=\"uploadbtn\" type=\"button\" value=\"选择文件\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"progressBar\" class=\"process\" style=\"display: none;\">\r\n");
      out.write("\t\t<div class=\"process-bar skin-green\">\r\n");
      out.write("\t\t\t<div class=\"pb-wrapper\">\r\n");
      out.write("\t\t\t\t<div class=\"pb-highlight\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"pb-container\">\r\n");
      out.write("\t\t\t\t\t<div id=\"pb_info\" class=\"pb-info\">0%(0.00M/0.00M)</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"pb_value\" class=\"pb-value\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t<div id=\"pb_text\" class=\"pb_text\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"successinfo\"></div>\r\n");
      out.write("</div>");
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
