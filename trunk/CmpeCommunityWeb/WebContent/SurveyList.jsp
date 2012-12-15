
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="Tables.SurveyTable"%>
<link href="/CmpeCommunityWeb/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<style>
.progress .bar p {
	color: #000;
	font-size: 12px;
	text-align: left;
	margin-left: -20px text-shadow:      0px -1px 0px rgba(0, 0, 0, 0.25);
}
</style>

	<div class="nav span3 nav-tabs">
		<form id="newsurvey" class='row' action="">
			<fieldset>
				<input id="newquestion" type="text" placeholder="Question">
				<ul id="newchoices">
					<li>
						<div class="input-append">
							<input id="choice0" name="choice0" type="text"
								placeholder="Choice" >
							<button id="addchoice" class="btn btn-success" type="button">
								<i class="icon-plus icon-white"></i>
							</button>
						</div>
					</li>
				</ul>
				<div class="controls">
					<button id="createsurvey" class="btn btn-info" type="button">
						Create Survey <i class="icon-chevron-right icon-white"></i>
					</button>
				</div>
			</fieldset>
		</form>
		My Serveys
		<div class="accordion" id="accordion2">
			<%
				SurveyTable[] surveys = (SurveyTable[]) request
						.getAttribute("userSurvey");
				//for(SurveyTable survey: surveys) {
			%>
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion2" href="#collapseOne"> deneme </a>
				</div>
				<div id="collapseOne" class="accordion-body collapse in">
					<div class="accordion-inner">
						<div>
							<h5>What is your favorite programming language?</h5>
							<div class="row">
								<div class="progress progress-warning">
									<div class="bar" style="width: 50%;">
										<p>&nbsp;50%</p>
									</div>
								</div>
								<div>
									<p>Python</p>
								</div>
							</div>

							<div class="row">
								<div class="progress progress-warning">
									<div class="bar" style="width: 10%;">
										<p>&nbsp;10%</p>
									</div>
								</div>
								<div>
									<p>Java</p>
								</div>
							</div>

							<div class="row">
								<div class="progress progress-warning">
									<div class="bar" style="width: 40%;">
										<p>&nbsp;40%</p>
									</div>
								</div>
								<div>
									<p>C++</p>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion2" href="#collapseOne"> deneme2 </a>
				</div>
				<div id="collapseOne" class="accordion-body collapse in">
					<div class="accordion-inner">
						<div>
							<h5>What is your favorite programming language?</h5>
							<div class="row">
								<div class="progress progress-warning">
									<div class="bar" style="width: 50%;">
										<p>&nbsp;50%</p>
									</div>
								</div>
								<div>
									<p>Python</p>
								</div>
							</div>

							<div class="row">
								<div class="progress progress-warning">
									<div class="bar" style="width: 10%;">
										<p>&nbsp;10%</p>
									</div>
								</div>
								<div>
									<p>Java</p>
								</div>
							</div>

							<div class="row">
								<div class="progress progress-warning">
									<div class="bar" style="width: 40%;">
										<p>&nbsp;40%</p>
									</div>
								</div>
								<div>
									<p>C++</p>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
			<%//}%>
		</div>


	</div>

