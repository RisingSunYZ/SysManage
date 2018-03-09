<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<title>物料类别</title>
	<base href="<%=basePath%>">
	<jsp:include page="/WEB-INF/jsp/inc.jsp"></jsp:include>
	<script type="text/javascript" src="scripts/js/wl/list.js?<%=Math.random()%>" charset="utf-8"></script>
	<style type="text/css">
		.category-tree {
			float: left;
			width: 220px;
			overflow: auto;
			border: 1px solid rgb(220, 220, 220);
		}
		
		.category-info {
			float: left;
			width: 750px;
			overflow: auto;
			border: 1px solid rgb(220, 220, 220);
			margin-left: 10px;
		}
		
		.category-table>tbody>tr>td {
			padding: 8px;
		}
		
		.tech {
			table-layout: fixed;
			border-collapse: collapse;
			border-spacing: 0;
			font: inherit;
			border: 0 none;
		}
		
		.tech th {
			background-color: #DBE9F4;
			color: #543333;
			padding: 1px 2px;
		}
		
		.tech td {
			padding: 5px 2px;
		}
		
		.tech th,.tech td {
			border-bottom: 1px solid rgb(213, 221, 227);
			border-top: 1px solid rgb(213, 221, 227);
			text-align: center;
			vertical-align: middle;
			line-height: 22px;
		}
		
		.tech .first {
			border-left: 1px solid rgb(213, 221, 227);
		}
		
		.tech .last {
			border-right: 1px solid rgb(213, 221, 227);
		}
		
		.btn-add {
			color: rgb(0, 85, 204);
			cursor: pointer;
			display: inline-block;
		}
		
		.removebtn {
			overflow: hidden;
			cursor: pointer;
			height: 15px;
			width: 15px;
		}
		
		.tabs_tips {
			background: none repeat scroll 0 0 rgb(238, 255, 204);
			border: 1px solid rgb(0, 153, 0);
			padding: 10px 20px 10px;
			margin-top: 15px;
		}
		
		.tabs_tips .status1 {
			color: rgb(102, 102, 255);
		}
		
		.tabs_tips .status2 {
			color: rgb(51, 51, 51);
		}
		
		.gridbtn1 td {
			padding: 8px 0 5px 0;
		}
		
		.drapDiv{
			float:left;
			margin:0 1px;
			width:2px;
			height:100%;
		}
		.drapDiv:hover{
			cursor:e-resize;
		}
		.tabtitle {
			margin: 0;
			padding: 0;
			height: 30px;
			border-bottom: 1px solid #1D79BF;
			padding-left: 15px;
			margin-top: 5px;
			margin-bottom: 5px;
		}
		
		.tabtitle .s1 {
			margin: 0;
			padding: 0;
			float: left;
			font-size: 15px;
			font-weight: bold;
			line-height: 32px;
			font-family: '微软雅黑', arial, simsun, sans-serif;
		}
		
		.tabtitle .s2 {
			margin: 0;
			padding: 0;
			float: left;
			font-size: 12px;
			font-weight: bold;
			line-height: 29px;
			font-family: '微软雅黑', arial, simsun, sans-serif;
		}
		
		label{
			color: #2072c4;
			display: inline-block;
			text-align: center;
			background-color: #f7f7f7;
			border: 1px solid #eaeaea;
			text-decoration: none;
			padding: 4px;
		}
		
		.button1{
			float: right;
			margin: 0px 5px;
			display: block;
			font-family: "宋体";
			font-size: 12px;
			text-decoration: none !important;
			font-family: "宋体" Helvetica, Arial, sans serif;
			padding: 6px 20px;
			-moz-border-radius: 3px;
			-webkit-border-radius: 3px;
			border-radius: 3px;
			line-height: 14px;
			cursor: pointer;
		}
		
		.icon-info {
			margin-left: 10px;
			float: left;
			background-image: url(images/icon-32.png);
			background-position: -64px 0;
			display: inline-block;
			vertical-align: middle;
			width: 32px;
			height: 32px;
			overflow: hidden;
		}
		.hd{
			padding-top:8px;
			padding-left:5px;
		}
		
	</style>
</head>
<body>
	<div class="page-hd" style="padding: 0 20px;">
		<div class="content-right-1 font-color-999">
			您的位置：
			<a class="a-lightbule" href="homepage/fdHome.do"> 首页</a>
			> 物料分类
		</div>
	</div>
	
	<div class="category-body" style="padding: 0 20px;">
		<div class="category-tree" style="float:left;">
			<ul id="cytree" class="ztree" style="margin-top: 0;"></ul>
		</div>
		<div class="drapDiv"></div>
		<div class="category-info" style="float:left;margin-left:0px;" >
			<div id="tableinfo" style="margin: 0; padding: 2px 15px; overflow: hidden;">
				<div class="form-bd">
					<table class="gridbtn1" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<c:forEach var="item" items="${Buttons}" varStatus="status">
									<a class="button btn-grey" href="javascript:void(0);" onclick="${item.handler}">${item.text}</a>
								</c:forEach>
							</td>
						</tr>
					</table>
					<div class="tabtitle">
						<span class="s1">固有属性</span>
					</div>
					<table class="form-table category-table" style="width: 100%;">
						<tr>
							<td class="table-td-bg-bule" style="width:80px; text-align: right;">父类编码：</td>
							<td style="width: 240px;">
								<span id="parentCode"></span>
							</td>
							<td class="table-td-bg-bule" style="width: 80px; text-align: right;">类别编码：</td>
							<td style="width: 240px;">
								<span id="mCode"></span>
							</td>
						</tr>
						<tr>
							<td class="table-td-bg-bule" style="width: 80px; text-align: right;">类别名称：</td>
							<td colspan="3">
								<span id="mName"></span>
							</td>
						</tr>
						<tr>
							<td class="table-td-bg-bule" style="width: 80px; text-align: right;">规格型号：</td>
							<td>
								<span id="spec"></span>
							</td>
							<td class="table-td-bg-bule" style="width: 80px; text-align: right;">单位：</td>
							<td>
								<span id="unit"></span>
							</td>
						</tr>
						<tr>
							<td class="table-td-bg-bule" style="text-align: right;">备注：</td>
							<td colspan="3" style="height: 50px;">
								<div id="remark"></div>
							</td>
						</tr>
					</table>
					<div class="tabtitle">
						<span class="s1">继承属性</span>
					</div>
					<table id="grid0" class="form-table category-table" style="width: 100%;">
						<tr id="g0_t0">
							<td class="table-td-bg-bule" style="text-align:center;width:20%;">属性编码</td>
							<td class="table-td-bg-bule" style="text-align:center;width:20%;">属性名称</td>
							<td class="table-td-bg-bule" style="text-align:center;width:30%;">属性值可选域</td>
							<td class="table-td-bg-bule" style="text-align:center;width:15%;">是否可被继承</td>
							<td class="table-td-bg-bule" style="text-align:center;width:15%;">属性格式</td>
						</tr>
						<tr>
							<td colspan="5">
							<a href='javascript:;' class="button btn-grey" onclick="modify(0)">编辑</a>
							</td>
						</tr>
					</table>
					<div class="tabtitle">
						<span class="s1">自定义属性</span>
					</div>
					<table id="grid1" class="form-table category-table" style="width: 100%;">
						<tr id="g1_t0">
							<td class="table-td-bg-bule" style="text-align:center;width:20%;">属性编码</td>
							<td class="table-td-bg-bule" style="text-align:center;width:20%;">属性名称</td>
							<td class="table-td-bg-bule" style="text-align:center;width:30%;">属性值可选域</td>
							<td class="table-td-bg-bule" style="text-align:center;width:15%;">是否可被继承</td>
							<td class="table-td-bg-bule" style="text-align:center;width:15%;">属性格式</td>
						</tr>
						<tr>
							<td colspan="5">
							<a href='javascript:;' class="button btn-grey" onclick="modify(1)">编辑</a>
							</td>
						</tr>
					</table>
					<div class="tabtitle">
						<span class="s1">组合约束</span>
					</div>
					<table id="grid2" class="form-table category-table" style="width: 100%;">
						<tr id="g2_t0">
							<td>
							<a href='javascript:;' class="button btn-grey" onclick="addCombo()">添加</a>
							</td>
						</tr>
					</table>
					<div class="tabtitle">
						<span class="s1">组件/部件报价模板</span>
					</div>
					<table id="grid3" class="form-table category-table" style="width:100%;">
						<tr id="g3_t0">
							<td class="table-td-bg-bule" style="text-align:center;width:5%;">序号</td>
							<td class="table-td-bg-bule" style="text-align:center;width:15%;">成本项分类</td>
							<td class="table-td-bg-bule" style="text-align:center;width:10%;">明细项分类</td>
							<td class="table-td-bg-bule" style="text-align:center;width:10%;">规格型号</td>
							<td class="table-td-bg-bule" style="text-align:center;width:10%;">含量</td>
							<td class="table-td-bg-bule" style="text-align:center;width:10%;">单位</td>
							<td class="table-td-bg-bule" style="text-align:center;width:10%;">单价(元)</td>
							<td class="table-td-bg-bule" style="text-align:center;width:10%;">合计</td>
							<td class="table-td-bg-bule" style="text-align:center;width:10%;">备注</td>
							<td class="table-td-bg-bule" style="text-align:center;width:10%;">属性</td>
						</tr>
						<tr>
							<td colspan="10">
							<a href='javascript:;' class="button btn-grey" onclick="addPart(1)">添加属性组件</a>
							<a href='javascript:;' class="button btn-grey" onclick="addPart(2)">添加分项组件</a>
							<a href='javascript:;' class="button btn-grey" onclick="modify(3)">编辑</a>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>