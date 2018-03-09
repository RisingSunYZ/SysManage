package org.apache.jsp.WEB_002dINF.jsp.portal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";

      out.write("\r\n");
      out.write(" \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title></title>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write(" \r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/inc.jsp", out, false);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\">\r\n");
      out.write("\tvar portalLayout;\r\n");
      out.write("\tvar portal;\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\tportalLayout = $('#portalLayout').layout({\r\n");
      out.write("\t\t\tfit : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(window).resize(function() {\r\n");
      out.write("\t\t\tportalLayout.layout('panel', 'center').panel('resize', {\r\n");
      out.write("\t\t\t\twidth : 1,\r\n");
      out.write("\t\t\t\theight : 1\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tpanels = [ {\r\n");
      out.write("\t\t\tid : 'p1',\r\n");
      out.write("\t\t\ttitle : 'request对象',\r\n");
      out.write("\t\t\theight : 200,\r\n");
      out.write("\t\t\tcollapsible : true,\r\n");
      out.write("\t\t\thref : '");
      out.print(basePath);
      out.write("jsp/portal/working1'\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tid : 'p2',\r\n");
      out.write("\t\t\ttitle : 'combobox',\r\n");
      out.write("\t\t\theight : 200,\r\n");
      out.write("\t\t\tcollapsible : true,\r\n");
      out.write("\t\t\thref : '");
      out.print(basePath);
      out.write("jsp/portal/working2'\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tid : 'p3',\r\n");
      out.write("\t\t\ttitle : 'combotree',\r\n");
      out.write("\t\t\theight : 200,\r\n");
      out.write("\t\t\tcollapsible : true,\r\n");
      out.write("\t\t\thref : '");
      out.print(basePath);
      out.write("jsp/portal/working3'\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tid : 'p4',\r\n");
      out.write("\t\t\ttitle : 'combogrid',\r\n");
      out.write("\t\t\theight : 200,\r\n");
      out.write("\t\t\tcollapsible : true,\r\n");
      out.write("\t\t\thref : '");
      out.print(basePath);
      out.write("jsp/portal/working4'\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tid : 'p5',\r\n");
      out.write("\t\t\ttitle : 'working5',\r\n");
      out.write("\t\t\theight : 200,\r\n");
      out.write("\t\t\tcollapsible : true,\r\n");
      out.write("\t\t\thref : '");
      out.print(basePath);
      out.write("jsp/portal/working5'\r\n");
      out.write("\t\t}, {\r\n");
      out.write("\t\t\tid : 'p6',\r\n");
      out.write("\t\t\ttitle : 'working6',\r\n");
      out.write("\t\t\theight : 200,\r\n");
      out.write("\t\t\tcollapsible : true,\r\n");
      out.write("\t\t\thref : '");
      out.print(basePath);
      out.write("jsp/portal/working6'\r\n");
      out.write("\t\t} ];\r\n");
      out.write("\r\n");
      out.write("\t\tportal = $('#portal').portal({\r\n");
      out.write("\t\t\tborder : false,\r\n");
      out.write("\t\t\tfit : true,\r\n");
      out.write("\t\t\tonStateChange : function() {\r\n");
      out.write("\t\t\t\t$.cookie('portal-state', getPortalState(), {\r\n");
      out.write("\t\t\t\t\texpires : 7\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tvar state = $.cookie('portal-state');\r\n");
      out.write("\t\tif (!state) {\r\n");
      out.write("\t\t\tstate = 'p1,p2,p3:p4,p5,p6';/*冒号代表列，逗号代表行*/\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\taddPortalPanels(state);\r\n");
      out.write("\t\tportal.portal('resize');\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction getPanelOptions(id) {\r\n");
      out.write("\t\tfor ( var i = 0; i < panels.length; i++) {\r\n");
      out.write("\t\t\tif (panels[i].id == id) {\r\n");
      out.write("\t\t\t\treturn panels[i];\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn undefined;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction getPortalState() {\r\n");
      out.write("\t\tvar aa = [];\r\n");
      out.write("\t\tfor ( var columnIndex = 0; columnIndex < 2; columnIndex++) {\r\n");
      out.write("\t\t\tvar cc = [];\r\n");
      out.write("\t\t\tvar panels = portal.portal('getPanels', columnIndex);\r\n");
      out.write("\t\t\tfor ( var i = 0; i < panels.length; i++) {\r\n");
      out.write("\t\t\t\tcc.push(panels[i].attr('id'));\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\taa.push(cc.join(','));\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn aa.join(':');\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addPortalPanels(portalState) {\r\n");
      out.write("\t\tvar columns = portalState.split(':');\r\n");
      out.write("\t\tfor ( var columnIndex = 0; columnIndex < columns.length; columnIndex++) {\r\n");
      out.write("\t\t\tvar cc = columns[columnIndex].split(',');\r\n");
      out.write("\t\t\tfor ( var j = 0; j < cc.length; j++) {\r\n");
      out.write("\t\t\t\tvar options = getPanelOptions(cc[j]);\r\n");
      out.write("\t\t\t\tif (options) {\r\n");
      out.write("\t\t\t\t\tvar p = $('<div/>').attr('id', options.id).appendTo('body');\r\n");
      out.write("\t\t\t\t\tp.panel(options);\r\n");
      out.write("\t\t\t\t\tportal.portal('add', {\r\n");
      out.write("\t\t\t\t\t\tpanel : p,\r\n");
      out.write("\t\t\t\t\t\tcolumnIndex : columnIndex\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"portalLayout\">\r\n");
      out.write("\t\t<div data-options=\"region:'center',border:false\">\r\n");
      out.write("\t\t\t<div id=\"portal\" style=\"position: relative\">\r\n");
      out.write("\t\t\t\t<div></div>\r\n");
      out.write("\t\t\t\t<div></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
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
