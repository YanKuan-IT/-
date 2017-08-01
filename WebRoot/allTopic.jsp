<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>allTopic</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		table{
			width:500px;
			border:1px solid blue;
			border-collapse: collapse;
			margin: 30px auto;
		}
		td{
			border: 1px solid red;
			height: 30px;
			text-align: center;
		}
		tr:NTH-CHILD(odd) {
			background: #e6e6e6;
		}
		tr:NTH-CHILD(even) {
			background: #99ccff;
		}
		.box_one{
			text-align: center;
			margin-top:30px; 
		}
	</style>
  </head>
  
  <body  style="background: #f2eada">
  		<jsp:include   page="title.jsp" flush="true"/>
  		
  		<!-- <div class="box_one">
   			<a href="addTopic.jsp">我要发帖</a>
   		</div> -->
   		<table>
   			<tr>
   				<td>序号</td>
   				<td>标题</td>
   				<td>发帖人</td>
   				<td>发帖时间</td>
   				<td>浏览量</td>
   			</tr>
   			<c:forEach items="${allTopics}" var="list" varStatus="vs">
			    <tr>
			    	<td>${vs.count }</td>
			        <td>
			        	<a href="${pageContext.request.contextPath }/FindAllReplyServlet?topic_id=${list.topic_id}">${list.title }</a>
			        </td>
			        <td>${list.author }</td>
			        <td>${list.create_time }</td>
			        <td>${list.click_amount }</td>
			    </tr>
    		</c:forEach>
   		</table>
  </body>
</html>
