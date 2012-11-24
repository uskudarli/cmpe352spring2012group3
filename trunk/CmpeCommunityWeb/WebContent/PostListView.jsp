<!--

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.UserTable" %>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
	<title>Cmpe Community</title>
	<link rel="stylesheet" href="/CmpeCommunityWeb/css/bootstrap.min.css">
	<style type="text/css">
	body { padding-top: 60px; }
	
	</style>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/CmpeCommunityWeb/css/bootstrap-responsive.min.css">
</head>
<body>

-->
<%@ page import="Tables.PostsTable" %>

<div style="margin-left: 30px" id="postList">
	<%
			PostsTable[] posts = (PostsTable[])request.getAttribute("posts");
			for(PostsTable post: posts) {
	
	%>
	<div class = "well well-small">
		<table class = "table table-condensed">
			<tr>
				<td>
					<p><strong>Cigdem</strong></p>
				</td>
				<td>
					 <!-- Class body bla bla-->
					<%= post.getBody()%>
					
				</td>
				<td>
					<p class = "muted">  
					<%= post.getPosting_time() %>
					 
					</p>
				</td>
			</tr>
		</table>
		<div class = "well well-small"> <table class = "table">
			
			<tr>
				<td>
					<p><strong>Cigdem</strong></p>
				</td>
				<td>
					 <!--  Class body bla bla-->
					<%=post.getBody()%>
					
				</td>
				<td>
					<p class = "muted">  <!-- 19Kasim-->
					<%= post.getPosting_time() %>
					 
					</p>
				</td>
			</tr>
		</table></div>
	</div>
	 
	<%} %>
	
	
</div>



		
<!--	
</body>
</html>
-->