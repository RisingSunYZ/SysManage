package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class inc_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<!-- 引入my97日期时间控件 -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/My97DatePicker4.8Beta3/My97DatePicker/WdatePicker.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- 引入kindEditor插件 -->\r\n");
      out.write("\r\n");
      out.write("<!-- 引入jQuery -->\r\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/jquery-1.9.1.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("scripts/jquery.cookie.js\"></script>\r\n");
      out.write("<!-- 引入Highcharts -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 引入文件上传 -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/fileupload/ajaxfileupload-1.0.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/fileupload/jquery.mxupload-1.0.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/fileupload/process.css\" type=\"text/css\"></link>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 引入EasyUI -->\r\n");
      out.write("<link id=\"easyuiTheme\" rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/jquery-easyui-1.3.4/themes/");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("/easyui.css\"\r\n");
      out.write("\ttype=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/jquery-easyui-1.3.4/themes/icon.css\" type=\"text/css\"></link>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/jquery-easyui-1.3.4/jquery.easyui.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<!-- 修复EasyUI1.3.3中layout组件的BUG -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/jquery-easyui-1.3.4/plugins/jquery.layout.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- 引入EasyUI Portal插件 -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/jquery-easyui-portal/portal.css\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/jquery-easyui-portal/jquery.portal.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- json对象与json字符串相互转换 -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/json2.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- 扩展EasyUI -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/extEasyUI.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/extBrowser.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/extByHFMX.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- 扩展jQuery -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/extJquery.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- 自定义扩展 -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("scripts/syUtilis.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- 扩展EasyUI Icon -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(basePath);
      out.write("scripts/jqueryUI/style/extEasyUIIcon.css?v=201305301906\" type=\"text/css\">\r\n");
      out.write("<!-- 引入bootstrap样式 -->\r\n");
      out.write("<!-- <link href=\"scripts/jqueryUI/bootstrap-2.3.1/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\" media=\"screen\"> -->\r\n");
      out.write("\r\n");
      out.write("<!-- 改写Grid行选中颜色(梅江顺) -->\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".datagrid-row-selected {\r\n");
      out.write("\t/* Grid单击行变成蓝色 */\r\n");
      out.write("\tbackground: #3baae3 repeat-x 50% 50%;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write("</style>");
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
    // /WEB-INF/jsp/inc.jsp(29,64) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cookie.easyuiTheme.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/inc.jsp(29,64) name = default type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setDefault("bootstrap");
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fdefault_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fdefault_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }
}
