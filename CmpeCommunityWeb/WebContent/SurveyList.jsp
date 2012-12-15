
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.TagsTable"%>
<%@ page import="Tables.UserTable"%>

<%String type = (String)request.getAttribute("type"); %>


<link rel="stylesheet"
	href="/CmpeCommunityWeb/css/bootstrap-tagmanager.css">

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


<div style="margin-left: 30px">
			<ul class="nav span6 nav-tabs">
				<li><a onclick="" data-toggle="tab">My surveys</a></li>
				<li><a onclick="" data-toggle="tab">Completed surveys</a></li>
			</ul>
	<div id="contentBody" class="span6"></div>
</div>
<script type="text/javascript">
<!--
// 	$(document).ready(function(){
<%-- 		Posts.loadNewsFeed(<%=user.getId()%>, $('.nav-tabs li:first a')); --%>
// 	});
//-->
</script>

<div class="nav span6 nav-tabs">
<%-- <%if (type.equals("mysurveys")){ %> --%>
	<div class="row">
		<div>
			<form id="newsurvey" class='row span4' action="">
				<fieldset>
					<input id="newquestion" type="text" placeholder="Question"
						class="span6">
					<ul id="newchoices">
						<li>
							<div class="input-append">
								<input id="choice0" name="choice0" type="text"
									placeholder="Choice" class="span5">
								<button id="addchoice" class="btn btn-success" type="button">
									<i class="icon-plus icon-white"></i>
								</button>
							</div>
						</li>
					</ul>
					<div class="controls offset3">
						<button id="createsurvey" class="btn btn-info" type="button">
							Create Survey <i class="icon-chevron-right icon-white"></i>
						</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
<%-- 	<%} %> --%>
	
	<script src="/CmpeCommunityWeb/js/bootstrap.js"></script>

	<div class="accordion" id="accordion2">
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#accordion2" href="#collapseOne"> What is your
					favorite programming language? </a>
			</div>
			<div id="collapseOne" class="accordion-body collapse">
				<div class="accordion-inner">
					<div class="row-fluid">
						<div class="progress progress-warning span2">
							<div class="bar" style="width: 50%;">
								<p>&nbsp;50%</p>
							</div>
						</div>
						<div class="span5">
							<p>Python</p>
						</div>
					</div>

					<div class="row-fluid">
						<div class="progress progress-warning span2">
							<div class="bar" style="width: 10%;">
								<p>&nbsp;10%</p>
							</div>
						</div>
						<div class="span5">
							<p>Java</p>
						</div>
					</div>

					<div class="row-fluid">
						<div class="progress progress-warning span2">
							<div class="bar" style="width: 40%;">
								<p>&nbsp;40%</p>
							</div>
						</div>
						<div class="span5">
							<p>C++</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#accordion2" href="#collapseTwo"> What is your
					favorite TV show? </a>
			</div>
			<div id="collapseTwo" class="accordion-body collapse">
				<div class="accordion-inner">
					<form>
						<label class="radio"> <input type="radio"
							name="id_of_survey"> Friends
						</label> <label class="radio"> <input type="radio"
							name="id_of_survey"> The Big Bang Theory
						</label> <label class="radio"> <input type="radio"
							name="id_of_survey"> House M.D.
						</label>

						<div class="controls">
							<button class="btn btn-success" type="button">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script>
	$('#addchoice').click(function() {
		var ul = $(this).closest('ul');
		var li = $(this).closest('li');
		var clone = li.clone(true);
		var name = 'choice' + $('#newchoices>li').length;
		clone.find('input').val('').attr('id', name).attr('name', name);
		clone.appendTo(ul);
		$(this).remove();
	});

	$('createsurvey').click(function() {
		$(document.body).append();
	});
	</script>