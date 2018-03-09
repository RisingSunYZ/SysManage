<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">

 <%--  <script src="<%=basePath%>scripts/jqueryUI/jquery-2.0.2.js"></script> --%>
<script type="text/javascript">
	$(function() {
		$("#btnGet").click(function() {
		   var id=$("#txtid").val();
		   console.info(id);  
			$.ajax({
				type : 'Post',
				url : '<%=basePath%>hello/' + id, //通过url传递name参数
				dataType : 'json',
				/* 	data : {
						title : "Mr",
						age: 3
					}, //通过data传递title参数 */
				success : function(data) {

					$("#txtName").val(data.userName);
					$("#txtpassword").val(data.password);
					$("#txtemail").val(data.email);

				},
				error : function(data) {
					if (data.responseText)
						alert(data.responseText);
					else {
						$("#txtName").val("");
						$("#txtpassword").val("");
						$("#txtemail").val("");
					}
				}
			});
		});
	});
</script>  
<div>
	<!-- 显示model中的hello字符串和client对象的name -->
	<br /> id： <input id="txtid" value="1"> <br> <input
		id="btnGet" type="button" value="get user by id" /> <br> 用户名： <input
		id="txtName"> <br> 密码： <input id="txtpassword"> <br>
	email： <input id="txtemail">
</div>



