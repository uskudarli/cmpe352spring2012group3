<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
	<title>Cmpe Community</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<style type="text/css">
	body { padding-top: 60px; padding-left:100px; }
	
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
	 	 <thead >
		 	 <tr>
			 	 <th><img src = "img\minions.jpg"></th>
		 	 </tr>
		 	 <tr>
		 	 	<th class = "well">Cigdem Kocberber</th>
		 	 </tr>
	 	 </thead>
	 	 <tbody>
		 	 <tr >
		 	 	<td onclick="window.location='default.jsp'">Tags</td>
		 	 </tr>
		 	 <tr class="text-info">
		 	 	<td>Events</td>
		 	 </tr>
		 	 <tr class="text-info">
		 	 	<td>Surveys</td>
		 	 </tr>
		 	 <tr>
		 	 	<th class = "well">Recommended Users</th>
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
 	
 	<div style="margin-top:160px;margin-left:30px">
	 	<ul class="nav span6 nav-tabs">
		  	<li><a href="#home" data-toggle="tab">Permanent Tags</a></li>
		  	<li><a href="#profile" data-toggle="tab">Short Term Tags</a></li>
		 	<li><a href="#messages" data-toggle="tab">People</a></li>
		</ul>
 	</div>
 	
 	
 </div>
</html>




