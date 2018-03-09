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
	initDepartTree();
});



var dtSetting = {
		async : {
			enable : true,
			url : "department/treeGrid.do",
			autoParam : [ "id" ]
		// dataFilter : filter
		},
		view : {
			dblClickExpand : false
		},
		data : {
			key : {
				name : "text"
			},
			simpleData : {
				enable : false
			}
		},
	 	callback : {
			beforeClick : beforeClick,
			onClick : onClick,
			onAsyncSuccess : function(event, treeId, treeNode, msg) {
				// 修改或者删除重新选择节点
				var selectNode=getSelectNode();
				if (selectNode && selectNode.getParentNode() == treeNode) {
					var treeObj = $.fn.zTree.getZTreeObj(treeId);
					var node = treeObj.getNodeByParam("id", selectNode.id, null);
					if (node) {
						treeObj.selectNode(node);
						selectNode = node;
					} else {
						selectNode = null;
					}
					showInfo();
				}
			}
		} 
	};

function beforeClick(treeId, treeNode) {
	var check = (treeNode != null);
	return check;
} 

  function onClick(e, treeId, treeNode) {
	selectId=treeNode.id;
	selectNode=treeNode;
	showInfo();
	$("input[name=deptId]").val(treeNode.id);
	//refreshgrid();
	var departObj = $("#departSel");
	departObj.attr("value", treeNode.text);

} 
  var selectId;
  var selectNode;
  //展示树节点信息
  function showInfo(){
  	$("#deptName").html("");
  	$("#chargeMan").html("");
  	$("#telephone").html("");
  	$("#fax").html("");
  	$("#cgLevel").html("");
  	if(selectId){
  		var treeObj = $.fn.zTree.getZTreeObj("departtree");
  		var node=treeObj.getNodeByParam("id", selectId, null);
  		if(node){
  			$("#deptName").html(node.attributes.deptName);
  			$("#chargeMan").html(node.attributes.chargeMen);
  			$("#telephone").html(node.attributes.telephone);
  			$("#fax").html(node.attributes.fax);
  			$("#cgLevel").html(node.attributes.cgLevelText);
  		}
  	}
  }
 function initDepartTree(){
	$.getJSON("department/treeGrid.do", function(data) {
		$.fn.zTree.init($("#departtree"), dtSetting, data);
	});
}
 function getSelectNode(){
		if(selectId){
			var treeObj = $.fn.zTree.getZTreeObj("departtree");
			var node=treeObj.getNodeByParam("id", selectId, null);
			return node;
		}
		return null;
	}
 
 function add() {
	 if(selectId){
		parent.$.modalDialog({
			title : '添加节点',
			width : 300,
			height : 200,
			href : 'department/toAddNode.do?pid='+selectId,
			buttons : [ {
				text : '添加',
				handler : function() {
						var f = parent.$.modalDialog.handler.find('#form1');
						
 						//f.submit(); 
						if(f.submit()){
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
		 parent.$.messager.alert("提示","请选择一个上级部门！");
	 }
	}
 
 function edit() {
	 if(selectId){
		parent.$.modalDialog({
			title : '修改节点',
			width : 300,
			height : 200,
			href : 'department/toEditNode.do?id='+selectId,
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
						//$("#form").submit();
						//console.info(f);
					
				}
			}, {
				text : '取消',
				handler : function() {
					parent.$.modalDialog.handler.dialog('close');
				}
			} ]
		});
	 }else{
		 parent.$.messager.alert("提示","请选择您要修改的部门！");
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

 /**
  * 删除部门
  */
 function removeDepart() {
 	var rootId=$("#rootId").val();
 	if(selectId){
 		if ($.trim(selectId) == rootId) {
 			parent.$.messager.alert('提示',"根部门不能删除！");
 			return;
 		}
 		parent.$.messager.confirm('确认','请确认下面没有子部门，如果有子部门将不能删除！',function(r){
 			if(r){
 			$.ajax({
 				url : "department/delect.do?id="+selectId,
 				dataType : "json",
 				success : function(data) {
 					if (data && data.success) {
 						if (data.msg && data.msg != "")
 							parent.$.messager.alert('提示', data.msg);
 						else
 							parent.$.messager.alert('提示',"删除成功");
 						refreshDeleteNode();
 					} else {
 						parent.$.messager.alert('提示',data.msg);
 					}
 				}
 			});
 			}
 		});
 	}else{
 		parent.$.messager.alert("提示","请选择一个需要删除的部门！");
 	}
 }
//删除时刷新节点
 function refreshDeleteNode() {
 	if (selectNode && $.trim(selectNode.id) != "") {
 		var treeObj = $.fn.zTree.getZTreeObj("departtree");
 		var parentNode = selectNode.getParentNode();
 		if (parentNode.children.length <= 1) {
 			parentNode.isParent = false;// 删除后如果没有孩子节点，则去掉+号
 		}
 		if(parentNode.getParentNode()){
 			parentNode=parentNode.getParentNode();
 		}
 		treeObj.updateNode(parentNode);
 		treeObj.reAsyncChildNodes(parentNode, "refresh", false);
 		selectNode=null;
 		selectId="";
 		$("#deptName").html("");
 		$("#chargeMan").html("");
 		$("#telephone").html("");
 		$("#fax").html("");
 	}
 }
 
</script>
<style type="text/css">
.gridbtn1 td {
	padding: 8px 0 5px 0;
}
.department-tree {
	float: left;
	min-width: 250px;
	overflow-x: auto;
	overflow-y: hidden;
	border: 1px solid rgb(220, 220, 220);
	margin-bottom: 10px;
}
.department-info {
	float: left;
	width: 750px;
	border: 1px solid rgb(220, 220, 220);
	margin-left: 10px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div class="department-tree">
	<ul id="departtree" class="ztree">
	</ul>
	</div>
	<div class="department-info">
	<div class="form-bd" >
				<table class="form-table department-table" style="width: 100%;">
					<tr>
						<td class="table-td-bg-bule" style="width: 80px; text-align: right;">部门名称：</td>
						<td style="width: 240px;">
							<span id="deptName"></span>
						</td>
						<td class="table-td-bg-bule" style="width: 80px; text-align: right;">&nbsp;&nbsp;负责人：</td>
						<td>
							<span id="chargeMan"></span>
						</td>
					</tr>
					<tr>
						<td class="table-td-bg-bule" style="text-align: right;">电&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
						<td>
							<span id="telephone"></span>
						</td>
						<td class="table-td-bg-bule" style="text-align: right;">传&nbsp;&nbsp;&nbsp;&nbsp;真：</td>
						<td>
							<span id="fax"></span>
						</td>
					</tr></table>
				<div id="tb" class="gridbtn1" cellspacing="0" cellpadding="0">
					
							<a class="button btn-grey" href="javascript:void(0);" onclick="add()">添加</a>
							<a class="button btn-grey" href="javascript:void(0);" onclick="edit()">修改</a>
							<a class="button btn-grey" href="javascript:void(0);" onclick="removeDepart()">删除</a>
				</div>
			</div>
			</div>
</body>
</html>