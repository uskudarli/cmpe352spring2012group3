
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.*" %>
<%UserTable user = (UserTable)request.getAttribute("user"); %>
<% Map<Integer, UserTable> users = (Map<Integer, UserTable>)request.getAttribute("users"); %>
<div class="row">
			<div >
				<fieldset>
					<div class="controls">
						<input type="text" name="posts" placeholder="Enter a new posts" style="width:350px; margin-left:90px;"/>
						<input type="submit" onclick="Posts.createWithTaggedUserId(<%=user.getId()%>);" class="btn btn-info btn-block" value="Post" style="width:100px;float:right"/>
					</div>
				</fieldset>
			</div>
		</div>
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
