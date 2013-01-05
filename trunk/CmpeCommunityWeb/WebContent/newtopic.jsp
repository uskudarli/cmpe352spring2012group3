<%@page import="java.util.Map"%>
<%@page import="Tables.ForumsTable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cmpe Community Forums</title>
<script type="text/javascript" src="/CmpeCommunityWeb/js/jquery.min.js"></script>
<script type="text/javascript" src="/CmpeCommunityWeb/js/forum.js"></script>
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
			ForumsTable forum = (ForumsTable) request.getAttribute("forum");
			ForumsTable[] parents = (ForumsTable[]) request
					.getAttribute("parents");
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
			<li class="active"><span class="divider">/</span><%=forum.getName()%></li>
		</ul>

		<div class="row">
			<div class="well span11">
				<form method="post" action="/CmpeCommunityWeb/Forum/createtopic/<%=forum.getId()%>">
					<fieldset>
						<legend>New Topic</legend>

						<div class="controls">
							<input type="text" name="title" class="span9" placeholder="Title" />
						</div>

						<div class="controls">
							<textarea name="content" rows="10" class="span11"></textarea>
						</div>
						<div class="controls">
							<button class="btn btn-info pull-right">
								Create Topic <i class="icon-chevron-right icon-white"></i>
							</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/CmpeCommunityWeb/js/bootstrap.js"></script>
</body>
</html>