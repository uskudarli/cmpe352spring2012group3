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
</style>
</head>
<body>
	<div class="navbar navbar-fixed-top navbar-inverse">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="/">Cmpe Community</a>
				<ul class="nav pull-right">
					<li><a href="/logout"> <i class="icon-off icon-white"></i>
							Logout
					</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container">
		<%
			// dummy data
			int categories = 3;
			int[] forums = { 3, 4, 2 };
			int[][] subforums = { { 2, 1, 5 }, { 0, 2, 3, 1 }, { 1, 0 } };
		%>

		<ul class="breadcrumb">
			<li><i class="icon-home"></i><a
				href="/CmpeCommunityWeb/categories.jsp"> Board Index</a></li>
		</ul>

		<%
			for (int i = 0; i < categories; i++) {
		%>
		<div style="margin-left: 8px">
			<h4>
				<a href="">Category <%= i + 1 %></a>
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
			<% for(int j = 0; j < forums[i]; j++){ %>
			<tr>
				<td>
					<div><a href=""><strong>Forum <%= j + 1 %></strong></a></div>
					<div>Description of forum <%= j + 1 %></div>
					<% if(subforums[i][j] != 0){ %>
					<div>
						<b>Subforums:</b>
						<% for(int k = 0; k < subforums[i][j]; k++){ %> 
						<a href="">Subforum <%= k + 1 %></a> 
						<% if(k + 1 != subforums[i][j]){out.print(",");} %>
						<% } %>
					</div>
					<% } %>
				</td>
				<td class="center-text">0</td>
				<td class="center-text">0</td>
				<td class="span3">
					No posts
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