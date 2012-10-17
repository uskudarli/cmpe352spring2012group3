<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>Cmpe Community</title>
<link rel="stylesheet" href="css/bootstrap.css">
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
						<li><a href="/events">Events</a></li>
						<li><a href="/tags">Tags</a></li>
					</ul>

					<form action="/search" class="navbar-search">
						<input type="text" placeholder="Search" class="search-query span3"
							name="q" value="" /> <input type="hidden" name="scope"
							id="search_scope" value="posts">
					</form>
					<ul class="nav pull-right">
						<li><a href="/logout">Logout</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
	<div class="row">
			<div class="span3">Erdem</div>
		<div class="span6">Erdem</div>
		<div class="span3">Erdem</div>
	
	</div>
	</div>
</html>