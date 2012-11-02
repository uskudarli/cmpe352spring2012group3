<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
	<title>Cmpe Community</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<style type="text/css">
	body { padding-top: 60px; }
	
	</style>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap-responsive.min.css">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a href="/" class="brand">Cmpe Community</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li><a href="/home">Home</a></li>
						<li><a href="/forum">Forum</a></li>
					</ul>

					<form action="/search" class="navbar-search">
						<input type="text" placeholder="Search" class="search-query span3"
							name="q" value="" /> <input type="hidden" name="scope"
							id="search_scope" value="posts">
					</form>
					<ul class="nav pull-right">
						<li><a href="/logout">Account</a></li>
						<li><a href="/logout">Logout</a></li>
					</ul>
				</div>
				
			</div>
		</div>
	</div>
	<div class="container">
		<table class="table span3 table-hover">
			<thead>
				<tr>
					<th><img src="img\minions.jpg"></th>
				</tr>
				<tr>
					<th class="well">Cigdem Kocberber</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td onclick="window.location='default.jsp'">Tags</td>
				</tr>
				<tr>
					<td>Events</td>
				</tr>
				<tr>
					<td>Surveys</td>
				</tr>
				<tr>
					<td>Discussion Forum</td>
				</tr>
				<tr>
					<td>Advance Search</td>
				</tr>
			</tbody>
		</table>