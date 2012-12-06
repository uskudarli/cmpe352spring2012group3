
<%@ page import="Tables.PostsTable" %>
<%@ page import="Tables.UserTable" %>
<%@ page import="drivers.PostDriver" %>
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
				
					<div class="pull-right muted"> <%= PostDriver.niceTime(post.getPosting_time()) %> </div>
		</div>			 
		<form name="reply_form" method="post" onsubmit="Reply.create(<%=post.getId()%>); return false;">
					<fieldset>
						<div class="controls">
							<input type="text" style="height:10px; margin-left:30px;" name="reply_<%=post.getId()%>" placeholder="Reply...">
						</div>
					</fieldset>
    			</form>
					<hr/>
	<%} %>
	
	
</div>