package org.apache.jsp.WEB_002dINF.jsp.exception;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class error_002dbusiness_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write('\r');
      out.write('\n');
 Exception e = (Exception)request.getAttribute("ex"); 
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head><title>Exception!</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".frame{  \r\n");
      out.write("    float:left;  \r\n");
      out.write("    margin:2px;  \r\n");
      out.write("}  \r\n");
      out.write(".outer {  \r\n");
      out.write("    height: 0px;  \r\n");
      out.write("    width: 0px;  \r\n");
      out.write("    overflow: hidden;  \r\n");
      out.write("    background:gold;  \r\n");
      out.write("    position: static !important;  \r\n");
      out.write("    position: relative;  \r\n");
      out.write("    display: table !important;  \r\n");
      out.write("}  \r\n");
      out.write("#middle { /* for explorer only*/  \r\n");
      out.write("    position: absolute;  \r\n");
      out.write("    top: 50%;  \r\n");
      out.write("}  \r\n");
      out.write("#middle[id] {  \r\n");
      out.write("    display: table-cell;  \r\n");
      out.write("    vertical-align: middle;  \r\n");
      out.write("    position: static;  \r\n");
      out.write("}  \r\n");
      out.write("#inner { /* for explorer only */  \r\n");
      out.write("    position: relative;  \r\n");
      out.write("    top: -50%;  \r\n");
      out.write("    width: 100%;  \r\n");
      out.write("    margin: 0 auto;  \r\n");
      out.write("    text-align:center  \r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- <div class=\"frame\">  \r\n");
      out.write("    <div class=\"outer\">  \r\n");
      out.write("        <div id=\"middle\">  \r\n");
      out.write("            <div id=\"inner\">\r\n");
      out.write("              <img width=\"70%\" height=\"70%\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/SysManage/images/error/exception.png\" style=\"float: center; padding-right: 0px;\" alt=\"\" /><br>\r\n");
      out.write("            e.getMessage()%><br/>\r\n");
      out.write("                  <br/>\r\n");
      out.write("                                                 请刷新页面或与系统管理员联系！</div>  \r\n");
      out.write("        </div>  \r\n");
      out.write("    </div>  \r\n");
      out.write("</div>-->\r\n");
      out.write("   <div style=\"width:100%;height:80%;text-align:center;padding-top:5%;margin:0px auto;top:auto;text-align:center;\">\r\n");
      out.write("        <table align=\"center\" style=\"margin:auto;\">\r\n");
      out.write("            <tr align=\"center\">\r\n");
      out.write("              <td align=\"center\">\r\n");
      out.write("                  <img width=\"70%\" height=\"70%\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/SysManage/images/error/exception.png\" style=\"float: center; padding-right: 0px;\" alt=\"\" />\r\n");
      out.write("              </td>\r\n");
      out.write("              <td align=\"center\">\r\n");
      out.write("                ");
      out.print( e.getMessage());
      out.write("<br/>\r\n");
      out.write("                  <br/>\r\n");
      out.write("                                                 请刷新页面或与系统管理员联系！    \r\n");
      out.write("              </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\t\t\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
