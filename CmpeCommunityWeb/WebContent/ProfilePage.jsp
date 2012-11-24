<%@page import="Tables.UserTable"%>
<%
	UserTable user = (UserTable)request.getAttribute("user");
%>
<div style="margin-left: 30px">
			<ul class="nav span6 nav-tabs">
				<li><a href="#home" data-toggle="tab">All Tags</a></li>
				<li><a href="#profile" data-toggle="tab">Short Term Tags</a></li>
				<li><a href="#messages" data-toggle="tab">People</a></li>
			</ul>
</div>
<div id="contentBody">
</div>
<script type="text/javascript">
<!--
	$(document).ready(function(){
		Posts.loadNewsFeed(<%=user.getId()%>);
	});
//-->
</script>
