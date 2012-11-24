<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.UserTable" %>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
	<title>Cmpe Community</title>
	<link rel="stylesheet" href="/CmpeCommunityWeb/css/bootstrap.min.css">
	<style type="text/css">
	body { padding-top: 60px; }
	
	</style>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/CmpeCommunityWeb/css/bootstrap-responsive.min.css">
</head>
<body>
<%UserTable user=(UserTable)request.getAttribute("user");%>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a href="/CmpeCommunityWeb/" class="brand">Cmpe Community</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li><a href="/CmpeCommunityWeb/Profile">Home</a></li>
						<li><a href="/CmpeCommunityWeb/Forum">Forum</a></li>
					</ul>

					<form action="#" class="navbar-search">
						<input type="text" placeholder="Search" class="search-query span3"
							name="q" value="" /> <input type="hidden" name="scope"
							id="search_scope" value="posts">
					</form>
					<ul class="nav pull-right">
						<li><a href="/CmpeCommunityWeb/User/logout">Account</a></li>
						<li><a href="/CmpeCommunityWeb/User/logout">Logout</a></li>
					</ul>
				</div>
				
			</div>
		</div>
	</div>
	<div class="container">
		<table class="table span3 table-hover">
			<thead>
				<tr>
					<th><img src="/CmpeCommunityWeb/img/minions.jpg"></th>
				</tr>
				<tr>
					<th class="well"><%=user.getName()%></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td onclick="window.location='Tags'">Tags</td>
				</tr>
				<tr>
					<td>Events</td>
				</tr>
				<tr class="text-info">
					<td>Surveys</td>
				</tr>
				<tr class="text-info">
					<td>Discussion Forum</td>
				</tr>
				<tr class="text-info">
					<td>Advance Search</td>
				</tr>
				<tr class="text-success">
		 	 	<td>Emre Sunecli</td>
		 	 </tr>
			 <tr class="text-success">
			 	<td>Suzan Uskudarli</td>
			 </tr>
			 <tr class="text-success">
			 	<td>Alper Gungormusler</td>
			 </tr>
			 <tr>
			 	<th class = "well">Recommended Tags</th>
			 </tr>
			 <tr class="text-error">
			 	<td>Deep Purple</td>
			 </tr>
			 <tr class="text-error">
			 	<td>Pizza</td>
			 </tr>
			 <tr class="text-error">
			 	<td>Tennis</td>
			 </tr>
			</tbody>
		</table>