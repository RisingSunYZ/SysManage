package org.apache.jsp.WEB_002dINF.jsp.portal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class working5_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"well well-large\" style=\"margin: 10px;\"> </div>\r\n");
      out.write("<div class=\"well well-small\" style=\"margin: 10px;\">\r\n");
      out.write("\t<h1>Spring MVC 异常演示例子</h1>\r\n");
      out.write("<h3><a href=\"./dao.do?id=1\">Dao正常错误</a></h3>\r\n");
      out.write("<h3><a href=\"./dao.do?id=10\">Dao参数错误</a></h3>\r\n");
      out.write("<h3><a href=\"./dao.do?id=\">Dao未知错误</a></h3>\r\n");
      out.write("<br />\r\n");
      out.write("<h3><a href=\"./service.do?id=1\">Service正常错误</a></h3>\r\n");
      out.write("<h3><a href=\"./service.do?id=10\">Service参数错误</a></h3>\r\n");
      out.write("<h3><a href=\"./service.do?id=\">Service未知错误</a></h3>\r\n");
      out.write("<br />\r\n");
      out.write("<h3><a href=\"./controller.do?id=1\">Controller正常错误</a></h3>\r\n");
      out.write("<h3><a href=\"./controller.do?id=10\">Controller参数错误</a></h3>\r\n");
      out.write("<h3><a href=\"./controller.do?id=\">Controller未知错误</a></h3>\r\n");
      out.write("<br />\r\n");
      out.write("<h3><a href=\"./404.do?id=1\">404错误</a></h3>\r\n");
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
