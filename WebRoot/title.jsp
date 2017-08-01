<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>title</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body{
			padding:0;
			margin:0;
		}
		.box_title{
			background: #e6e6e6;
			height: 50px;
		}
		.box_a{
			margin:0 auto;
			text-align: center;
			line-height: 50px;
		}
	</style>
  </head>
  
  <body>
    	<div class="box_title">
    		<div class="box_a">
	    		<a href="addTopic.jsp">我要发帖</a>
	    		&nbsp;&nbsp;&nbsp;&nbsp;
	    		<a href="${pageContext.request.contextPath }/FindAllTopicServlet">查看所有帖子</a>
    		</div>
    	</div>
  </body>
</html>
