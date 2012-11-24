
<%@ page import="Tables.PostsTable" %>

<div style="margin-left: 30px" id="postList">
	<%
			// dummy data
			PostsTable[] posts = (PostsTable[])request.getAttribute("posts");
			for(PostsTable post: posts) {
	%>
	<div class = "well well-small">
	<%= post.getBody() %>
	</div>
	<% } %>
	
</div>

