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
	.brand
	{
		position: absolute;
		width: 100%;
		left: 0;
		text-align: center;
		margin: auto;
	}
	</style>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap-responsive.min.css">
</head>
<body>
	<!-- Navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a href="/" class="brand">Cmpe Community</a>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="span3 offset2">
				<form action="ProfilePage.jsp" method="post">
					<fieldset>
						<legend>Log In</legend>
						<div class="alert alert-error">
							<a class="close" data-dismiss="alert" href="#">�</a>Incorrect E-Mail or Password!
						</div>
						<div class="controls">
							<input type="text" class="input-xlarge" placeholder="E-Mail">
							<input type="password" class="input-xlarge" placeholder="Password">
							<a href="">Forgot password?</a>
							<button class="btn btn-info pull-right"  >Log In</button>
						</div>
					</fieldset>
				</form>

			</div>

			<div class="span2"></div>

			<div class="span3">
				<form action="">
					<fieldset>
						<legend>Create an account</legend>
						<div class="controls">
							<input type="text" class="input-xlarge" placeholder="First Name">
							<input type="text" class="input-xlarge" placeholder="Last Name">
							<input type="text" class="input-xlarge" placeholder="E-Mail">
							<input type="password" class="input-xlarge" placeholder="Password">
							<input type="password" class="input-xlarge" placeholder="Retype Password">
							<button class="btn btn-info btn-block">Create account</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/bootstrap-alert.js"></script>
</body>
</html>



