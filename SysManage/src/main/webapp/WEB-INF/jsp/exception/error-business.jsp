<%@ page contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% Exception e = (Exception)request.getAttribute("ex"); %>
<html>
<head><title>Exception!</title>
<style type="text/css">
.frame{  
    float:left;  
    margin:2px;  
}  
.outer {  
    height: 0px;  
    width: 0px;  
    overflow: hidden;  
    background:gold;  
    position: static !important;  
    position: relative;  
    display: table !important;  
}  
#middle { /* for explorer only*/  
    position: absolute;  
    top: 50%;  
}  
#middle[id] {  
    display: table-cell;  
    vertical-align: middle;  
    position: static;  
}  
#inner { /* for explorer only */  
    position: relative;  
    top: -50%;  
    width: 100%;  
    margin: 0 auto;  
    text-align:center  
}
</style>
</head>
<body>

<!-- <div class="frame">  
    <div class="outer">  
        <div id="middle">  
            <div id="inner">
              <img width="70%" height="70%" src="${basePath}/SysManage/images/error/exception.png" style="float: center; padding-right: 0px;" alt="" /><br>
            e.getMessage()%><br/>
                  <br/>
                                                 请刷新页面或与系统管理员联系！</div>  
        </div>  
    </div>  
</div>-->
   <div style="width:100%;height:80%;text-align:center;padding-top:5%;margin:0px auto;top:auto;text-align:center;">
        <table align="center" style="margin:auto;">
            <tr align="center">
              <td align="center">
                  <img width="70%" height="70%" src="${basePath}/SysManage/images/error/exception.png" style="float: center; padding-right: 0px;" alt="" />
              </td>
              <td align="center">
                <%= e.getMessage()%><br/>
                  <br/>
                                                 请刷新页面或与系统管理员联系！    
              </td>
            </tr>
        </table>		
    </div>

</body>
</html>