<%@ page contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% Exception e = (Exception)request.getAttribute("ex"); %>
<html>
<head><title>Exception!</title></head>
<body>
    <table style="height: 100%; width: 270px; text-align: center;">
        <tr>
			<td align="left">
				<img width="100" height="100" src="${basePath}/SysManage/images/error/exception.png" style="float: left; padding-right: 0px;" alt="" />
			</td>
			<td align="center">
			<%= e.getMessage()%><br/>
                                                 请刷新页面或与系统管理员联系！                        
            </td>
		</tr>
    </table>
</body>
</html>