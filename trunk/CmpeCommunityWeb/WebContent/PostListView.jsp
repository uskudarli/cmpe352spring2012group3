
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.PostsTable" %>

<div style="margin-left: 30px" id="postList">
	<%
			PostsTable[] posts = (PostsTable[])request.getAttribute("posts");
			for(PostsTable post: posts) {
	
	%>
	<div style="margin-left:10px; margin-bottom:10px;">
		
					<strong>Cigdem</strong>
				
					<%= post.getBody()%>
				
					<div class="pull-right muted"> <%= post.getPosting_time() %> </div>
		</div>			 
		
					<hr/>

	 
	<%} %>
	
	
</div>
