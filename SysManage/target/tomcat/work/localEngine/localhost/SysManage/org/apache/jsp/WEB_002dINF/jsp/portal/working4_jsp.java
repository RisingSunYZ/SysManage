package org.apache.jsp.WEB_002dINF.jsp.portal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class working4_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar ccgrid = $('#ccgrid').combogrid({\r\n");
      out.write("\t\trequired : true,\r\n");
      out.write("\t\tloadMsg : '数据加载中...',\r\n");
      out.write("\t\tpanelWidth : 450,\r\n");
      out.write("\t\tfitColumns : true,\r\n");
      out.write("\t\tvalue : '',\r\n");
      out.write("\t\tidField : 'id',\r\n");
      out.write("\t\ttextField : 'name',\r\n");
      out.write("\t\tsortName : \"id\",// 默认排序\r\n");
      out.write("\t\tsortOrder : \"asc\",\r\n");
      out.write("\t\tmode : 'remote',\r\n");
      out.write("\t\turl : \"book/grid.do\",\r\n");
      out.write("\t\tpagination : true,\r\n");
      out.write("\t\tpageSize : 5,\r\n");
      out.write("\t\tpageList : [ 5, 10 ],\r\n");
      out.write("\t\tcolumns : [ [ {\r\n");
      out.write("\t\t\tfield : 'id',\r\n");
      out.write("\t\t\ttitle : 'ID',\r\n");
      out.write("\t\t\twidth : 60,\r\n");
      out.write("\t\t\tsortable : true\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tfield : 'name',\r\n");
      out.write("\t\t\ttitle : 'Name',\r\n");
      out.write("\t\t\twidth : 100,\r\n");
      out.write("\t\t\tsortable : true\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tfield : 'model',\r\n");
      out.write("\t\t\ttitle : '型号',\r\n");
      out.write("\t\t\twidth : 120,\r\n");
      out.write("\t\t\tsortable : true\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tfield : 'sellprice',\r\n");
      out.write("\t\t\ttitle : '销售价',\r\n");
      out.write("\t\t\twidth : 100,\r\n");
      out.write("\t\t\tsortable : true\r\n");
      out.write("\t\t} ] ],\r\n");
      out.write("\t\tdelay : 500\r\n");
      out.write("\t});\r\n");
      out.write("\tfunction getCCGridValue() {\r\n");
      out.write("\t\talert(ccgrid.combogrid('getValue') + '_' + ccgrid.combogrid('getText'));\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<input id=\"ccgrid\">\r\n");
      out.write("<input id=\"getselect\" value=\"get\" onclick=\"getCCGridValue()\"\r\n");
      out.write("\ttype=\"button\">");
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
