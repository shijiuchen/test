<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 订单详情 -->
	
<title>订单详情</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
</head>
<body>
	
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/css/images/title_arrow.gif" /> 订单详情
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>菜名</td>
					<td>单价</td>
					<td>数量</td>
				</tr>
			</thead>
			
			<tbody id="TableData">
				
			 		<tr height="60">
				 		<td>鱼香肉丝</td>
				 		<td>123.0</td>
				 		<td>1</td>
			 		</tr>
			 	
			 		<tr height="60">
				 		<td>杭椒牛柳</td>
				 		<td>92.0</td>
				 		<td>1</td>
			 		</tr>
			 		 	
			</tbody>
		</table>
		
		<div id="TableTail" align="center">
			 <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
		</div>
	</div>
</body>
</html>
