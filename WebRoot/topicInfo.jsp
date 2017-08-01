<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>topicInfo</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body style="background: #f2eada">
    	
    	<jsp:include   page="title.jsp" flush="true"/>
    	
    	<div>
    		<table align="center">
    			<tr>
    				<th>${topic.title }&nbsp;&nbsp;</th>
    				<th>${topic.author }&nbsp;&nbsp;</th>
    				<th>${topic.create_time }&nbsp;&nbsp;</th>
    				<th>共浏览过${topic.click_amount }次</th>
    			</tr>
    			<tr>
    				<td colspan="4"><strong>正文：</strong>${topic.content }</td>
    			</tr>
    		</table>
    	</div>
    	<hr>
    	<div>		
    	
    		<table align="center">
    			<c:forEach items="${allReply}" var="list" varStatus="vs">
			    <tr>
			        <td>昵称：${list.author }</td>
			        <td>时间：${list.create_time }</td>
			    </tr>
			    <tr>
			    	<td colspan="2" align="center">${list.content }</td>
			    </tr>
    		</c:forEach>
    		</table>
    	</div>
    	<hr>
    	<form action="${pageContext.request.contextPath }/AddReplyServlet" method="post">
    		<!-- 从session中获取token -->
    		<input type="hidden" name="token" value="${token }"/>
    		<input type="hidden" name="topic_id" value="${topic.topic_id }">
	    	<table align="center">
	    		<tr>
	    			<td>昵称：<input type="text" name="author"></td>
	    		</tr>
	    		<tr>
	    			<td>评论：<textarea rows="7" cols="20" name="content"></textarea></td>
	    		</tr>
	    		<tr>
	    			<td colspan="2"><input type="submit" value="发表评论" id="submit"></td>
	    		</tr>
	    	</table>
    	</form>
    	
    	
  </body>
</html>
