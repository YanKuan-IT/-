<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>addTopic</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body  style="background: #f2eada">
  		<jsp:include   page="title.jsp" flush="true"/>
    	
    	<form action="AddTopicServlet" method="post">
    		
    		<!-- 从session中获取token -->
    		<input type="hidden" name="token" value="${token }"/>
    		
    		<table align="center" style="margin-top:30px;">
    			<tr>
    				<td>作者:</td>
    				<td><input type="text" name="author"></td>
    			</tr>
    			<tr>
    				<td>标题:</td>
    				<td><input type="text" name="title"></td>
    			</tr>
    			<tr>
    				<td>内容:</td>
    				<td><textarea rows="7" cols="22" name="content"></textarea></td>
    			</tr>
    			<tr>
    				<td align="center" colspan="2"><input type="submit" value="发表"></td>
    			</tr>
    		</table>
    	</form>
    	
    	
  </body>
</html>
