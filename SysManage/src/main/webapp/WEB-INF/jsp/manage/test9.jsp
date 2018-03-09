<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/jsp/inc.jsp"></jsp:include>
<link rel="stylesheet" href="<%=basePath%>scripts/jqueryUI/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript"
	src="<%=basePath%>scripts/jqueryUI/zTree/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript"
	src="<%=basePath%>scripts/jqueryUI/zTree/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript"
	src="<%=basePath%>scripts/jqueryUI/extJquery.js"></script>
	<script type="text/javascript"
	src="<%=basePath%>scripts/jqueryUI/zTree/js/jquery.ztree.exedit-3.5.js"></script>
<script type="text/javascript">
var grid;
$(function(){
	initStudentTree();
});
var dtSetting = {
		async : {
			enable : true,
			url : "student/treeGrid.do",
			autoParam : ["id"]
		},
		view : {
			dblClickExpend : false
		},
		data : {
			key:{
				name:"text"
			},
			simpleData : {
				enable : false
			}
		},
		callback : {
			beforeClick : beforeClick,
			onClick : onClick,
			onAsyncSuccess : function(event,treeId,treeNode,msg){
				var selectNode = getSelectNode();
				if(selectNode && selectNode.getParentNode() == treeNode){
					var treeObj = $.fn.zTree.getZTreeObj(treeId);
					var node = treeObj.getNodeByParam("id",selectNode.id,null);
					if(node){
						treeObj.selectNode(node);
						selectNode = node;
					}else{
						selectNode = null;
					}
					showInfo();
				}
			}
		}
};
function beforeClick(treeId,treeNode){
	var cheak = (treeNode != null);
	return cheak;
}
function onClick(e,treeId,treeNode){
	selectId = treeNode.id;
	selectNode = treeNode;
	showInfo();
	$("input[name=studentId]").val(treeNode.id);
	//refreshgrid();
	var studentObj = $("#StudentSel");
	studentObj.attr("value", treeNode.text);
}
var selectId;
var selectNode;
//展示树节点的信息
function showInfo(){
	$("#name").html("");
	$("#age").html("");
	$("#sex").html("");
	$("#birthday").html("");
	//$("#cgLevel").html("");
	if(selectId){
		var treeObj = $.fn.zTree.getZTreeObj("studenttree");
		var node = treeObj.getNodeByParam("id",selectId,null);
		if(node){
			$("#name").html(node.attributes.name);
			$("#sex").html(node.attributes.sex);
			$("#age").html(node.attributes.age);
			$("#birthday").html(node.attributes.birthday);
			//$("#cgLevel").html(node.attributes.cgLevelText);
		}
	}
}
function  initStudentTree(){
	$.getJSON("student/treeGrid.do",function(data){
		$.fn.zTree.init($("#studenttree"), dtSetting, data);
	});
}
function getSelectNode(){
	if(selectId){
		var treeObj = $.fn.zTree.getZTreeObj("studenttree");
		var node = treeObj.getNodeByParam("id",select,null);
		return node;
	}
	return null;
}

function add(){
	console.info("@@@@@@@");
	if(selectId){	
		parent.$.modalDialog({
			title:"添加节点",
			height:300,
			width:200,
			href:'student/fdadd.do?pid='+selectId,
			buttons:[{
				text:"添加",
				handler : function(){
					var f =parent.$.modalDialog.handler.find('#form1');
					if(f.submit()){
						setTimeout("refreshEditNode()",500);
					}
				}
			},{
				text:"取消",
				handler : function(){
					parent.$.modalDialog.handler.dialog('close');
				}
			}]
		});
	}else{
		parent.$.messager.alert("提示","请选择一个上级部门！");
	}
}

function edit() {
	 if(selectId){
		parent.$.modalDialog({
			title : '修改节点',
			width : 300,
			height : 200,
			href : 'student/toEditNode.do?id='+selectId,
			buttons : [ {
				text : '修改',
				handler : function() {
					 console.info("fdsf");
						//parent.$.modalDialog.openner_grid = grid;
						var f = parent.$.modalDialog.handler.find('#form');
						if(f.submit()){
							//refreshEditNode();
							setTimeout("refreshEditNode()",500);
						}  
				}
			}, {
				text : '取消',
				handler : function() {
					parent.$.modalDialog.handler.dialog('close');
				}
			} ]
		});
	 }else{
		 parent.$.messager.alert("提示","请选择您要修改的节点！");
	 }
	}
	
/**
 * 刷新节点
 * @param newcode
 */
function refreshEditNode() {
	if (selectNode && $.trim(selectNode.id) != "") {
		var treeObj = $.fn.zTree.getZTreeObj("departtree");
		var parentNode = selectNode.getParentNode();
		//selectId= newcode;// 修改时会修改编码
		treeObj.reAsyncChildNodes(parentNode, "refresh", false);
	}
}
</script>
<style type="text/css">
.gridbtn1 td {
	padding: 8px 0 5px 0;
}
.student-tree {
	float: left;
	min-width: 250px;
	overflow-x: auto;
	overflow-y: hidden;
	border: 1px solid rgb(220, 220, 220);
	margin-bottom: 10px;
}
.student-info{
	float: left;
	width: 750px;
	border: 1px solid rgb(220, 220, 220);
	margin-left: 10px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div class="student-tree">
	<ul id="studenttree" class="ztree">
	</ul>
	</div>
	<div class="student-info">
	<div class="form-bd" >
				<table class="form-table student-table" style="width: 100%;">
					<tr>
						<td class="table-td-bg-bule" style="width: 80px; text-align: right;">学生姓名：</td>
						<td style="width: 240px;">
							<span id="name"></span>
						</td>
						<td class="table-td-bg-bule" style="width: 80px; text-align: right;">&nbsp;&nbsp;性别：</td>
						<td>
							<span id="sex"></span>
						</td>
					</tr>
					<tr>
						<td class="table-td-bg-bule" style="text-align: right;">年龄：</td>
						<td>
							<span id="age"></span>
						</td>
						<td class="table-td-bg-bule" style="text-align: right;">生日：</td>
						<td>
							<span id="birthday"></span>
						</td>
					</tr></table>
				<div id="tb" class="gridbtn1" cellspacing="0" cellpadding="0">
					
							<a class="button btn-grey" href="javascript:void(0);" onclick="add()">添加</a>
							<a class="button btn-grey" href="javascript:void(0);" onclick="edit()">修改</a>
							<a class="button btn-grey" href="javascript:void(0);" onclick="removeStudent()">删除</a>
				</div>
			</div>
			</div>
</body>
</html>