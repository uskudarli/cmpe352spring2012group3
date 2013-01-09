
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.TagsTable"%>
<%@ page import="Tables.UserTable"%>
<%@page import="Tables.UserTable"%>

<style>
.progress .bar p {
	color: #000;
	font-size: 12px;
	text-align: left;
	margin-left: -20px text-shadow:   0px -1px 0px rgba(0, 0, 0, 0.25);
}
</style>
<script type="text/javascript"
	src="/CmpeCommunityWeb/js/bootstrap-tagmanager.js"></script>
<script type="text/javascript">
	function addTags() {
		document.forms['form1'].submit();
	}
</script>
<script src="/CmpeCommunityWeb/js/bootstrap.js"></script>

<div class="nav span6 nav-tabs">
<%
	UserTable user = (UserTable)request.getAttribute("user");
%>
	<div class="row span3">
		<div>
<form name="form2" method="post" action="/CmpeCommunityWeb/Profile/editAction">
					<fieldset>
						<legend>Update Account</legend>
						<div class="controls">
							<h5>Profile Picture:</h5><input type="file" id="file" >
							<input type="text" id="first-name" name="first-name" class="input-xlarge" placeholder="Full Name" value="<%=user.getName()%>">
							<br/>
							<input type="password" id="password_signup" name="password_signup" class="input-xlarge" placeholder="Password">
							<br>
							<input type="password" id="re-password" name="re-password" class="input-xlarge" placeholder="Retype Password">
							<br>
							<input type="text" id="email_signup" name="email_signup" class="input-xlarge" placeholder="E-Mail" value="<%=user.getEmail()%>">
							<input type="button" class=" btn btn-info btn-block" value="Update" onclick=""/>
						</div>
					</fieldset>
    			</form>
		</div>
	</div>	
<script src="/CmpeCommunityWeb/js/bootstrap.js"></script>

