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

<script type="text/javascript">
function login() {
	if (document.getElementById("email_login").value=='') {
		alert('email can not be empty');
		return;
	}else if (document.getElementById("password_login").value=='') {
		alert('password can not be empty');
		return;
	} else if (!isAValidMail(document.getElementById("email_login").value)) {
		alert('invalid email');
		return;
	} 
	document.forms.form1.clickedButton.value='login';
	document.forms['form1'].submit();
}
function signUp() {
	if (document.getElementById("first-name").value=='') {
		alert('first name can not be empty');
		return;
	}else if (document.getElementById("last-name").value=='') {
		alert('last name can not be empty');
		return;
	} else if (document.getElementById("password_signup").value=='' || document.getElementById("password_signup").value!=document.getElementById("re-password").value) {
		alert('Invalid password');
		return;
	} else if (!isAValidMail(document.getElementById("email_signup").value)) {
		alert('invalid email');
		return;
	} 
	document.forms.form1.clickedButton.value='signUp';
	document.forms['form1'].submit();
}
function isAValidMail(str){
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	if(reg.test(str) == false) {
		return false;
 	}
	return true;
}
</script>
<form name="form1" method="post" action="/CmpeCommunityWeb/default">

	<!-- Navbar -->
	<input class="FormText" type="hidden" name="clickedButton" id="clickedButton" value="" >
	
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
					<fieldset>
						<legend>Log In</legend>
						<div class="alert alert-error">
							<a class="close" data-dismiss="alert" href="#">×</a>Incorrect E-Mail or Password!
						</div>
						<div class="controls">
							<input type="text" id="email_login" name="email_login" class="input-xlarge" placeholder="E-Mail">
							<input type="password" id="password_login" name="password_login" class="input-xlarge" placeholder="Password">
							<a href="">Forgot password?</a>
							<input type="button" class="btn btn-info pull-right" value="Log In" onclick="login()"/>
						</div>
					</fieldset>
			</div>

			<div class="span2"></div>

			<div class="span3">
					<fieldset>
						<legend>Create an account</legend>
						<div class="controls">
							<input type="text" id="first-name" name="first-name" class="input-xlarge" placeholder="First Name">
							<input type="text" id="last-name" name="last-name" class="input-xlarge" placeholder="Last Name">
							<input type="text" id="email_signup" name="email_signup" class="input-xlarge" placeholder="E-Mail">
							<input type="password" id="password_signup" name="password_signup" class="input-xlarge" placeholder="Password">
							<input type="password" id="re-password" name="re-password" class="input-xlarge" placeholder="Retype Password">
							<input type="button" class="btn btn-info btn-block" value="Create Account" onclick="signUp()"/>
						</div>
					</fieldset>
			</div>
		</div>
	</div>
    </form>
	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/bootstrap-alert.js"></script>
</body>
</html>



