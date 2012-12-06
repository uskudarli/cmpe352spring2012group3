
<%@ page import="Tables.PostsTable" %>
<%@ page import="Tables.UserTable" %>
<%@page import="java.util.Map"%>
<% Map<Integer, UserTable> users = (Map<Integer, UserTable>)request.getAttribute("users"); %>
<div style="margin-left: 30px" id="postList">
	<%
			PostsTable[] posts = (PostsTable[])request.getAttribute("posts");
			for(PostsTable post: posts) {
	
	%>
	<div style="margin-left:10px; margin-bottom:10px;">
		
					<strong><a href="/CmpeCommunityWeb/Profile/details/<%= ((UserTable)users.get(post.getOwner_id())).getId() %>"><%= ((UserTable)users.get(post.getOwner_id())).getName() %>:</a></strong>
				
					<%= post.getBody()%>
				
					<div class="pull-right muted"> <%= post.getPosting_time() %> </div>
		</div>			 
		
					<hr/>

	 
	<%} %>
	
	
</div>