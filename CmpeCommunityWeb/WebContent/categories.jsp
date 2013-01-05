<%@page import="drivers.ForumsDriver"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Tables.ForumPostTable"%>
<%@page import="Tables.UserTable"%>
<%@page import="Tables.ForumTopicTable"%>
<%@page import="java.util.Map"%>
<%@page import="Tables.ForumsTable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cmpe Community Forums</title>
<link rel="stylesheet" href="/CmpeCommunityWeb/css/bootstrap.min.css">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}

.center-text{
	text-align: center !important;
}
</style>
</head>
<body>
	<div class="navbar navbar-fixed-top navbar-inverse">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="/CmpeCommunityWeb/">Cmpe Community</a>
				<ul class="nav pull-right">
					<li><a href="/User/logout"> <i class="icon-off icon-white"></i>
							Logout
					</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container">
		<%
			ForumsTable[] categories = (ForumsTable[])request.getAttribute("categories");
			Map<Integer, ForumsTable[]> subForums = (Map<Integer, ForumsTable[]>)request.getAttribute("subForums");
			Map<Integer, ForumPostTable> posts = (Map<Integer, ForumPostTable>)request.getAttribute("posts");
			Map<Integer, UserTable> users = (Map<Integer, UserTable>)request.getAttribute("users");
		%>

		<ul class="breadcrumb">
			<li><i class="icon-home"></i><a
				href="/CmpeCommunityWeb/Forum"> Board Index</a></li>
		</ul>

		<%
			for(ForumsTable category: categories) {
		%>
		<div style="margin-left: 8px">
			<h4>
				<a href="<%= "Forum/index/" + category.getId()%>"><%= category.getName() %></a>
			</h4>
		</div>

		<table class="table table-hover table-bordered">
			<thead>
				<tr class="well">
					<th>Forums</th>
					<th class="span1 center-text">Topics</th>
					<th class="span1 center-text">Posts</th>
					<th class="span3">Last Post</th>
				</tr>
			</thead>
			<tbody>
			<% for(ForumsTable forum: subForums.get(category.getId())) { /*for(int j = 0; j < forums[i]; j++){*/ %>
			<tr>
				<td>
					<div><a href="<%= "Forum/index/" + forum.getId()%>"><strong><%= forum.getName() %></strong></a></div>
					<div><%= forum.getDescription() %></div>
					<% if(subForums.get(forum.getId())!=null && subForums.get(forum.getId()).length > 0){
						ForumsTable[] subForumsObjects = subForums.get(forum.getId());
					%>
						<div>
							<b>Subforums:</b>
							<% for(int i = 0; i < subForumsObjects.length; i++) {%> 
								<a href="<%= "Forum/index/" + subForumsObjects[i].getId()%>"><%= subForumsObjects[i].getName() %></a><%= (i == subForumsObjects.length - 1) ? "" : "," %>
							<% } %>
						</div>
					<% } %>
				</td>
				<td class="center-text"><%= forum.getTopicsCount() %></td>
				<td class="center-text"><%= forum.getPostsCount() %></td>
				<td class="span3">
				<% ForumPostTable p = posts.get(forum.getLastPostId());
 					if(p != null){
						UserTable u = users.get(p.getUserId());%>
					<div><small><a href="/CmpeCommunityWeb/Profile/details/<%=u.getId()%>">
					<%=u.getName() %></a></small> <a href="/CmpeCommunityWeb/Forum/topic/<%= p.getTopicId()%>"><i class="icon-play-circle" title="View the latest post"></i></a></div>
					<div><small><%=ForumsDriver.niceTime(p.getPostTime()) %></small></div>
					<%}else{%>
						No posts
					<% } %>
				</td>
			</tr>
			<% } %>
			</tbody>
		</table>
		<br />
		<%
			}
		%>

	</div>

	<script type="text/javascript" src="/CmpeCommunityWeb/js/bootstrap.js"></script>
</body>
</html>