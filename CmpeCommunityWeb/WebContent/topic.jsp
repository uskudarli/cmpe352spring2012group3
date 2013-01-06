<%@page import="Tables.UserTable"%>
<%@page import="drivers.ForumsDriver"%>
<%@page import="Tables.ForumPostTable"%>
<%@page import="com.sun.org.apache.xpath.internal.FoundIndex"%>
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

.center-text {
	text-align: center !important;
}
</style>
<script type="text/javascript">
function stoppedTyping(text)
  {
    if (text.length > 0)
      document.getElementById("replybutton").disabled = false;
    else
      document.getElementById("replybutton").disabled = true;
  }
</script>
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
			ForumsTable forum = (ForumsTable) request
					.getAttribute("forum");
			ForumsTable[] parents = (ForumsTable[]) request.getAttribute("parents");
			ForumTopicTable topic = (ForumTopicTable)request.getAttribute("topic");
			ForumPostTable[] posts = (ForumPostTable[])request.getAttribute("posts");
			Map<Integer, UserTable> users = (Map<Integer, UserTable>)request.getAttribute("users");
			UserTable user = (UserTable)request.getAttribute("user");
		%>

		<ul class="breadcrumb">
			<li><i class="icon-home"></i><a href="/CmpeCommunityWeb/Forum">
					Board Index</a></li>
			<%
				for (int i = parents.length - 1; i > 0; i--) {
			%>
			<li><span class="divider">/</span><a
				href=<%="/CmpeCommunityWeb/Forum/index/" + parents[i].getId()%>>
					<%=parents[i].getName()%></a></li>
			<%
				}
			%>
			<li><span class="divider">/</span><a
				href=<%="/CmpeCommunityWeb/Forum/index/" + forum.getId()%>>
					<%=forum.getName()%></a></li>
					
			<li class="active"><span class="divider">/</span><%=topic.getTitle() %></li>		
		</ul>

		<div style="margin-left: 8px">
			<h2><%=topic.getTitle() %></h2>
		</div>

		<br />

		<div class="row">
			<div class="span1">
				<img src="/CmpeCommunityWeb/img/minions.jpg"/>
			</div>
			<div class="span10">
				<div style="margin: -10px 0px 5px 10px">
					<a href="/CmpeCommunityWeb/Profile/details/<%=users.get(posts[0].getUserId()).getId()%>"><strong><%= users.get(posts[0].getUserId()).getName() %></strong></a> &raquo; <%= ForumsDriver.niceTime(posts[0].getPostTime()) %>
				</div>
				<p class="well"><%= posts[0].getContent() %></p>
			</div>
		</div>

		<h4>Replies</h4>
		<hr />
		<%for(int i = 1; i < posts.length; i++){ %>
		<div class="row">
			<div class="span1">
				<img src="/CmpeCommunityWeb/img/minions.jpg" />
			</div>
			<div class="span10">
				<div style="margin: -10px 0px 5px 10px">
					<a href="/CmpeCommunityWeb/Profile/details/<%=users.get(posts[0].getUserId()).getId()%>"><strong><%= users.get(posts[i].getUserId()).getName() %></strong></a> &raquo; <%= ForumsDriver.niceTime(posts[i].getPostTime()) %>
				</div>
				<p class="well"><%= posts[i].getContent() %></p>
			</div>
		</div>
		<br />
		<%} %>
		<%if(posts.length == 1){ %>
			<div>No replies yet</div>
		<%} %>
 		<br />
 		
		<div class="row">
			<form action="/CmpeCommunityWeb/Forum/reply/<%= topic.getId() %>" method="post" class="span11">
				<fieldset>
					<legend>Post a new Reply</legend>

					<div class="span1" style="margin-left: 0px">
						<img src="/CmpeCommunityWeb/img/minions.jpg" />
					</div>

					<div class="controls span10">
						<a style="margin-left: 10px" href="/CmpeCommunityWeb/Profile/details/<%=user.getId()%>"><strong><%= user.getName() %></strong></a>
						<textarea onkeyup="stoppedTyping(this.value)" name="content" rows="5" class="span10"></textarea>
					</div>
					<div class="controls">
						<button id="replybutton" disabled="true" class="btn btn-info pull-right">
							Send Reply <i class="icon-chevron-right icon-white"></i>
						</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>

	<script type="text/javascript" src="/CmpeCommunityWeb/js/bootstrap.js"></script>
</body>
</html>