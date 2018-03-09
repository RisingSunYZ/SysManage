package org.apache.jsp.WEB_002dINF.jsp.portal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class working2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\tvar cmb;\r\n");
      out.write("\tcmb=$('#cc').combobox({\r\n");
      out.write("\t\twidth:200,\r\n");
      out.write("\t\t//url :'");
      out.print(basePath);
      out.write("product/CMB.do',\r\n");
      out.write("\t\t//url:'");
      out.print(basePath);
      out.write("book/cmb.do',\r\n");
      out.write("\t\t//valueField : 'id',\r\n");
      out.write("\t\t//textField : 'name',\r\n");
      out.write("\t\t//value : 104,\r\n");
      out.write("\t\turl :'");
      out.print(basePath);
      out.write("jsonData/cmb.json',\r\n");
      out.write("\t\tvalueField : 'id',\r\n");
      out.write("\t\ttextField : 'text',\r\n");
      out.write("\t\tfilter : function(q, row) {\r\n");
      out.write("\t\t\tvar opts = $(this).combobox('options');\r\n");
      out.write("\t\t\t return row[opts.textField].indexOf(q) == 0;\t\t \r\n");
      out.write("\t\t},\r\n");
      out.write("\t\trequired : true\r\n");
      out.write("\t//editable : false\r\n");
      out.write("\t});\r\n");
      out.write("\tfunction getValue() {\r\n");
      out.write("\t\talert(cmb.combobox('getText') + \"_\" + cmb.combobox('getValue'));\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$('#cct').combotree({\r\n");
      out.write("\t\t//required : true\r\n");
      out.write("\t\tcheckbox:true,\r\n");
      out.write("\t\tmultiple:true,\r\n");
      out.write("\t\t url:'");
      out.print(basePath);
      out.write("jsonData/tree_data1.json'   \r\n");
      out.write("\t\t});\r\n");
      out.write("\t$('#cct2').combotree({\r\n");
      out.write("\t\t//required : true\r\n");
      out.write("\t\t//checkbox:true,\r\n");
      out.write("\t\t//multiple:true,\r\n");
      out.write("\t\t url:'");
      out.print(basePath);
      out.write("jsonData/tree_data1.json'   \r\n");
      out.write("\t\t});\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("ComboBox:\r\n");
      out.write("<br>\r\n");
      out.write("<input id=\"cc\">\r\n");
      out.write("<br>\r\n");
      out.write("<input class=\"easyui-combobox\" required=\"true\" missingMessage=\"用户名必填\"\r\n");
      out.write("\tdata-options=\"\t\t   \r\n");
      out.write("\t\tvalueField: 'label',\r\n");
      out.write("\t\ttextField: 'value',\r\n");
      out.write("\t\tdata: [{\r\n");
      out.write("\t\t\tlabel: 'java',\r\n");
      out.write("\t\t\tvalue: 'Java'\r\n");
      out.write("\t\t},{\r\n");
      out.write("\t\t\tlabel: 'perl',\r\n");
      out.write("\t\t\tvalue: 'Perl'\r\n");
      out.write("\t\t},{\r\n");
      out.write("\t\t\tlabel: 'ruby',\r\n");
      out.write("\t\t\tvalue: 'Ruby'\r\n");
      out.write("\t\t}]\" />\r\n");
      out.write("<br>\r\n");
      out.write("<input value=\"get\" onclick=\"getValue()\" type=\"button\" />\r\n");
      out.write("<br>\r\n");
      out.write("<input id=\"cct\">\r\n");
      out.write("<input id=\"cct2\">\r\n");
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
