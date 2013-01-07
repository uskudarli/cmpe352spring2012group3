
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.TagsTable"%>
<%@ page import="Tables.UserTable"%>
<%@ page import="Tables.SurveyTable"%>
<%@ page import="Tables.ChoiceTable"%>
<%@ page import="drivers.SurveyDriver"%>
<%@ page import="java.util.ArrayList;"%>
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

<div class="nav span6 nav-tabs">
<%
	UserTable user = (UserTable)request.getAttribute("user");
	String type = (String)request.getAttribute("type"); 
%>
<%if (type.equals("mySurvey")){ %> 
	<div class="row">
		<div>
				<fieldset>
					<input id="newquestion" type="text" placeholder="Question"
						class="span6" name="newquestion">
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
						<input type="submit" onclick="Surveys.add(<%=user.getId()%>);" value="Create Survey" class="btn btn-info">
					</div>
				</fieldset>
		</div>
	</div>
<%} %> 
	
	<script src="/CmpeCommunityWeb/js/bootstrap.js"></script>
	
<% SurveyTable[] surveyList = (SurveyTable[])request.getAttribute("surveyList"); %>


<% 
ChoiceTable[] choices=null;
for (int i=0;i<surveyList.length;i++) { %>

	<div class="accordion" id="accordion2">
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#accordion2" href="#collapseOne"> <%=surveyList[i].getQuestion() %> </a>
			</div>
			<div id="collapseOne" class="accordion-body collapse">
			<div class="accordion-inner">
			<% choices = surveyList[i].getChoiceTable();%>
			<% for (int j=0;j<choices.length;j++) { %>
			            <div class="row-fluid">
						<div class="progress progress-warning span2">
							<div class="bar" style="width:<%=choices[j].getPercentageVotes()+"%" %>;">
								<p>&nbsp;<%=choices[j].getVotes() %></p>
							</div>
						</div>
						<div class="span5">
							<p><%=choices[j].getChoice() %></p>
						</div>
					</div>
            <% } %>
					
				</div>
			</div>
		</div>
		<% } %>
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