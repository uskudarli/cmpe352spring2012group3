
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.PostsTable" %>

<div class="row">
			<div class="span3">
				<form name="form1" method="post" action="/CmpeCommunityWeb/Posts/addPosts/">
					<input class="FormText" type="hidden" name="clickedButton" id="clickedButton" value="" >
					<fieldset>
						<div class="controls">
							<input type="text" name="posts" placeholder="Enter a new posts" class="" style="width:500px"/>
							<input type="submit" class="btn btn-info btn-block" value="Post" style="width:100px;float:right"/>
						</div>
					</fieldset>
    			</form>
			</div>
		</div>
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
					<%=post.getBody()%>
					
				</td>
				<td>
					<p class = "muted">
					<%= post.getPosting_time() %>
					 
					</p>
				</td>
			</tr>
		</table></div>
	</div>
	 
	<%} %>
	
	
</div>
