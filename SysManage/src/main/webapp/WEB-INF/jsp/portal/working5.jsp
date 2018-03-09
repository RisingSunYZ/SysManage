<%@ page language="java" pageEncoding="UTF-8"%>
<div class="well well-large" style="margin: 10px;"> </div>
<div class="well well-small" style="margin: 10px;">
	<h1>Spring MVC 异常演示例子</h1>
<h3><a href="./dao.do?id=1">Dao正常错误</a></h3>
<h3><a href="./dao.do?id=10">Dao参数错误</a></h3>
<h3><a href="./dao.do?id=">Dao未知错误</a></h3>
<br />
<h3><a href="./service.do?id=1">Service正常错误</a></h3>
<h3><a href="./service.do?id=10">Service参数错误</a></h3>
<h3><a href="./service.do?id=">Service未知错误</a></h3>
<br />
<h3><a href="./controller.do?id=1">Controller正常错误</a></h3>
<h3><a href="./controller.do?id=10">Controller参数错误</a></h3>
<h3><a href="./controller.do?id=">Controller未知错误</a></h3>
<br />
<h3><a href="./404.do?id=1">404错误</a></h3>
</div>