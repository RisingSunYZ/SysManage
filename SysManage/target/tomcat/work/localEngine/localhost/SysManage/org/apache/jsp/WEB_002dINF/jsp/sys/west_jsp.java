package org.apache.jsp.WEB_002dINF.jsp.sys;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.hfmx.utils.SessionKey;

public final class west_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

	String contextPath = request.getContextPath();
	com.hfmx.utils.UserInfo sessionInfo = (com.hfmx.utils.UserInfo) session
	.getAttribute(SessionKey.UserInfoKey);

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar layout_west_tree;\r\n");
      out.write("\tvar layout_west_tree_url = '';\r\n");
      out.write("\tvar sessionInfo_userId = true;//'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionInfo.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\tif (sessionInfo_userId) {\r\n");
      out.write("\t\tlayout_west_tree_url = '");
      out.print(basePath);
      out.write("sys/sysmenu.do';\r\n");
      out.write("\t}\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\tlayout_west_tree = $('#layout_west_tree').tree({\r\n");
      out.write("\t\t\t//checkbox:true,\r\n");
      out.write("\t\t\turl : layout_west_tree_url,\r\n");
      out.write("\t\t\tparentField : 'pid',\r\n");
      out.write("\t\t\t//lines : true,\r\n");
      out.write("\t\t\tonClick : function(node) {\r\n");
      out.write("\t\t\t\tconsole.info(node.attributes);\r\n");
      out.write("\t\t\t\tif (node.attributes && node.attributes.url) {\r\n");
      out.write("\t\t\t\t\tvar url;\r\n");
      out.write("\t\t\t\t\tif (node.attributes.url.indexOf('/') == 0) {/*如果url第一位字符是\"/\"，那么代表打开的是本地的资源*/\r\n");
      out.write("\t\t\t\t\t\turl = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("' + node.attributes.url;\r\n");
      out.write("\t\t\t\t\t\tif (url.indexOf('/druidController') == -1) {/*如果不是druid相关的控制器连接，那么进行遮罩层屏蔽*/\r\n");
      out.write("\t\t\t\t\t\t\tparent.$.messager.progress({\r\n");
      out.write("\t\t\t\t\t\t\t\ttitle : '提示',\r\n");
      out.write("\t\t\t\t\t\t\t\ttext : '数据处理中，请稍后....'\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t} else {/*打开跨域资源*/\r\n");
      out.write("\t\t\t\t\t\turl = node.attributes.url;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\taddTab({\r\n");
      out.write("\t\t\t\t\t\turl : url,\r\n");
      out.write("\t\t\t\t\t\ttitle : node.text,\r\n");
      out.write("\t\t\t\t\t\ticonCls : node.iconCls\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tonBeforeLoad : function(node, param) {\r\n");
      out.write("\t\t\t\tif (layout_west_tree_url) {//只有刷新页面才会执行这个方法\r\n");
      out.write("\t\t\t\t\tparent.$.messager.progress({\r\n");
      out.write("\t\t\t\t\t\ttitle : '提示',\r\n");
      out.write("\t\t\t\t\t\ttext : '数据处理中，请稍后....'\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tonLoadSuccess : function(node, data) {\r\n");
      out.write("\t\t\t\tparent.$.messager.progress('close');\r\n");
      out.write("\t\t\t\t//**展开根节点，根节点id=1\r\n");
      out.write("\t\t\t\tvar RootNode = layout_west_tree.tree('find', 1);\t\t\t\t\r\n");
      out.write("\t\t\t\tlayout_west_tree.tree('expand',RootNode.target);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction addTab(params) {\r\n");
      out.write("\t\tvar iframe = '<iframe src=\"' + params.url + '\" frameborder=\"0\" style=\"border:0;width:100%;height:98%;\"></iframe>';\r\n");
      out.write("\t\tvar t = $('#index_tabs');\r\n");
      out.write("\t\tvar opts = {\r\n");
      out.write("\t\t\ttitle : params.title,\r\n");
      out.write("\t\t\tclosable : true,\r\n");
      out.write("\t\t\ticonCls : params.iconCls,\r\n");
      out.write("\t\t\tcontent : iframe,\r\n");
      out.write("\t\t\tborder : false,\r\n");
      out.write("\t\t\tfit : true\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\tif (t.tabs('exists', opts.title)) {\r\n");
      out.write("\t\t\tt.tabs('select', opts.title);\r\n");
      out.write("\t\t\tparent.$.messager.progress('close');\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tt.tabs('add', opts);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<div class=\"easyui-accordion\" data-options=\"fit:true,border:false\">\r\n");
      out.write("\t<div title=\"系统菜单\" style=\"padding: 5px;\" data-options=\"border:false,isonCls:'anchor',tools : [ {\r\n");
      out.write("\t\t\t\ticonCls : 'database_refresh',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t$('#layout_west_tree').tree('reload');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\ticonCls : 'resultset_next',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\tvar node = $('#layout_west_tree').tree('getSelected');\r\n");
      out.write("\t\t\t\t\tif (node) {\r\n");
      out.write("\t\t\t\t\t\t$('#layout_west_tree').tree('expandAll', node.target);\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$('#layout_west_tree').tree('expandAll');\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\ticonCls : 'resultset_previous',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\tvar node = $('#layout_west_tree').tree('getSelected');\r\n");
      out.write("\t\t\t\t\tif (node) {\r\n");
      out.write("\t\t\t\t\t\t$('#layout_west_tree').tree('collapseAll', node.target);\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$('#layout_west_tree').tree('collapseAll');\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} ]\">\r\n");
      out.write("\t\t<div class=\"well well-small\">\r\n");
      out.write("\t\t\t<ul id=\"layout_west_tree\"></ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div title=\"其他示例\" data-options=\"border:false,iconCls:'anchor'\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li><a href=\"");
      out.print(basePath);
      out.write("jsp/classes/index.do\" target=\"center\">班级管理</a></li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
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
