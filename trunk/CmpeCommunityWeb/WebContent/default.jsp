<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>Cmpe Community</title>
<link rel="stylesheet" href="/CmpeCommunityWeb/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/CmpeCommunityWeb/css/bootstrap-tagmanager.css">
<style type="text/css">
body {
	padding-top: 60px;
}

.brand {
	position: absolute;
	width: 100%;
	left: 0;
	text-align: center;
	margin: auto;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="/CmpeCommunityWeb/css/bootstrap-responsive.min.css">
	
<script src="/CmpeCommunityWeb/js/tagcanvas.min.js" type="text/javascript"></script>

</head>
<body>

	<script type="text/javascript">
		function login() {
			if (document.getElementById("email_login").value == '') {
				alert('email can not be empty');
				return;
			} else if (document.getElementById("password_login").value == '') {
				alert('password can not be empty');
				return;
			} else if (!isAValidMail(document.getElementById("email_login").value)) {
				alert('invalid email');
				return;
			}
			document.forms.form1.clickedButton.value = 'login';
			document.forms['form1'].submit();
		}
		function signUp() {
			if (document.getElementById("first-name").value == '') {
				alert('first name can not be empty');
				return;
			} else if (document.getElementById("last-name").value == '') {
				alert('last name can not be empty');
				return;
			} else if (document.getElementById("password_signup").value == ''
					|| document.getElementById("password_signup").value != document
							.getElementById("re-password").value) {
				alert('Invalid password');
				return;
			} else if (!isAValidMail(document.getElementById("email_signup").value)) {
				alert('invalid email');
				return;
			}
			document.forms.form2.clickedButton.value = 'signUp';
			document.forms['form2'].submit();
		}
		function isAValidMail(str) {
			var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
			if (reg.test(str) == false) {
				return false;
			}
			return true;
		}
	</script>

	<!-- Navbar -->

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a href="/CmpeCommunityWeb/" class="brand">Cmpe Community</a>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">

			<div class="span4 offset1">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#login" data-toggle="tab">Login</a></li>
					<li><a href="#register" data-toggle="tab">Register</a></li>
				</ul>

				<div class="tab-content">
					<div class="tab-pane active span3" id="login">
						<form name="form1" method="post"
							action="/CmpeCommunityWeb/User/loginAction">
							<input class="FormText" type="hidden" name="clickedButton"
								id="clickedButton" value="">
							<fieldset>
								<br>
								<%
									if (request.getAttribute("loginFailed") != null) {
								%>
								<div class="alert alert-error">
									<a class="close" data-dismiss="alert" href="#">×</a>Incorrect
									E-Mail or Password!
								</div>
								<%
									}
								%>
								<div class="controls">
									<input type="text" id="email_login" name="email_login"
										class="input-xlarge" placeholder="E-Mail"> <input
										type="password" id="password_login" name="password_login"
										class="input-xlarge" placeholder="Password"> <a
										href="">Forgot password?</a> <input type="button"
										class="btn btn-info pull-right" value="Log In"
										onclick="login()" />
								</div>
							</fieldset>
						</form>
					</div>

					<div class="tab-pane span3" id="register">
						<form name="form2" method="post"
							action="/CmpeCommunityWeb/User/registerAction">
							<input class="FormText" type="hidden" name="clickedButton"
								id="clickedButton" value=""> <br>
							<fieldset>
								<div class="controls">
									<input type="text" id="first-name" name="first-name"
										class="input-xlarge" placeholder="First Name"> <input
										type="text" id="last-name" name="last-name"
										class="input-xlarge" placeholder="Last Name"> <input
										type="text" id="email_signup" name="email_signup"
										class="input-xlarge" placeholder="E-Mail"> <input
										type="password" id="password_signup" name="password_signup"
										class="input-xlarge" placeholder="Password"> <input
										type="password" id="re-password" name="re-password"
										class="input-xlarge" placeholder="Retype Password"> <input
										type="text" name="tags" placeholder="Tags" class="tagManager" />
									<input type="button" class="btn btn-info btn-block"
										value="Create Account" onclick="signUp()" />
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>

			<div class="span6 offset1">

				<div id="myCanvasContainer">
					<canvas width="500" height="500" id="tagcanvas">
        <p>Anything in here will be replaced on browsers that support the canvas element</p>
      </canvas>
				</div>

				<div id="taglist" style="display: none">
					<ul>
						<li><a href="http://www.google.com" target="_blank">Google</a></li>
						<li><a href="/fish">Fish</a></li>
						<li><a href="/fish">451</a></li>
						<li><a href="/fish">Cmpe</a></li>
						<li><a href="/fish">Osman</a></li>
						<li><a href="/fish">Orman</a></li>
						<li><a href="/fish">Erdem</a></li>
						<li><a href="/chips">Chips</a></li>
						<li><a href="/salt">Salt</a></li>
						<li><a href="/vinegar">Vinegar</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript" src="/CmpeCommunityWeb/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="/CmpeCommunityWeb/js/bootstrap-alert.js"></script>
	<script type="text/javascript"
		src="/CmpeCommunityWeb/js/bootstrap-tagmanager.js"></script>
	<script>
	  jQuery(".tagManager").tagsManager();
	  var oopts = {
				textFont: 'Impact,Arial Black,sans-serif',
				textHeight: 20,
				maxSpeed: 0.1,
				decel: 0.9,
				depth: 0.99,
				outlineColour: '#f6f',
				outlineThickness: 3,
				pulsateTo: 0.2,
				pulsateTime: 0.5,
				wheelZoom: false
			}, ttags = 'taglist', lock, shape = 'sphere';
	  
			window.onload = function() {
				TagCanvas.textFont = 'Trebuchet MS, Helvetica, sans-serif';
			  TagCanvas.textColour = '#0099CC';
			  TagCanvas.textHeight = 25;
			  TagCanvas.outlineColour = '#ff9999';
			  TagCanvas.maxSpeed = 0.03;
			  TagCanvas.minBrightness = 0.2;
				TagCanvas.depth = 0.92;
				TagCanvas.pulsateTo = 0.6;
				TagCanvas.initial = [0.1,-0.1];
				TagCanvas.decel = 0.98;
				TagCanvas.reverse = true;
				TagCanvas.hideTags = false;
				TagCanvas.shadow = '#ccf';
				TagCanvas.shadowBlur = 3;
				TagCanvas.weight = false;
				TagCanvas.imageScale = null;
				try {
					TagCanvas.Start('tagcanvas','taglist');
				} catch(e) {
			        document.getElementById('tagcanvas').style.display = 'none';
				}};
	</script>
</body>
</html>



