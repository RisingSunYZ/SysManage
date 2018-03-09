package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write(" ");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$(\"#btnGet\").click(function() {\r\n");
      out.write("\t\t   var id=$(\"#txtid\").val();\r\n");
      out.write("\t\t   console.info(id);  \r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype : 'Post',\r\n");
      out.write("\t\t\t\turl : '");
      out.print(basePath);
      out.write("hello/' + id, //通过url传递name参数\r\n");
      out.write("\t\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\t\t/* \tdata : {\r\n");
      out.write("\t\t\t\t\t\ttitle : \"Mr\",\r\n");
      out.write("\t\t\t\t\t\tage: 3\r\n");
      out.write("\t\t\t\t\t}, //通过data传递title参数 */\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t$(\"#txtName\").val(data.userName);\r\n");
      out.write("\t\t\t\t\t$(\"#txtpassword\").val(data.password);\r\n");
      out.write("\t\t\t\t\t$(\"#txtemail\").val(data.email);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror : function(data) {\r\n");
      out.write("\t\t\t\t\tif (data.responseText)\r\n");
      out.write("\t\t\t\t\t\talert(data.responseText);\r\n");
      out.write("\t\t\t\t\telse {\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtName\").val(\"\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtpassword\").val(\"\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#txtemail\").val(\"\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>  \r\n");
      out.write("<div>\r\n");
      out.write("\t<!-- 显示model中的hello字符串和client对象的name -->\r\n");
      out.write("\t<br /> id： <input id=\"txtid\" value=\"1\"> <br> <input\r\n");
      out.write("\t\tid=\"btnGet\" type=\"button\" value=\"get user by id\" /> <br> 用户名： <input\r\n");
      out.write("\t\tid=\"txtName\"> <br> 密码： <input id=\"txtpassword\"> <br>\r\n");
      out.write("\temail： <input id=\"txtemail\">\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
