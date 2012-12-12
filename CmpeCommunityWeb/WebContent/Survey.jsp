<!DOCTYPE html>
<html>
  <head>
    <title>Survey</title>
    <!-- Bootstrap -->
    <link href="/CmpeCommunityWeb/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <style>
      .progress .bar p {
        color: #000;
        font-size: 12px;
        text-align: left;
        margin-left: -20px
        text-shadow: 0px -1px 0px rgba(0, 0, 0, 0.25);
      }
    </style>
  </head>



  <body>
    <div class="content">


		
	<br>
      <form id="newsurvey" class='row span4' action="">
        <fieldset>
          <input id="newquestion" type="text" placeholder="Question" class="span6">
          <ul id="newchoices">
            <li>
              <div class="input-append">
                <input id="choice0" name="choice0" type="text" placeholder="Choice" class="span5">
                <button id="addchoice" class="btn btn-success" type="button"><i class="icon-plus icon-white"></i>
                </button> 
              </div>
            </li>
          </ul>
          <div class="controls offset3">
            <button id="createsurvey" class="btn btn-info" type="button">Create Survey <i class="icon-chevron-right icon-white"></i></button>
          </div>
        </fieldset>
      </form>
    </div>



    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="/CmpeCommunityWeb/js/bootstrap.min.js"></script>
    <script >
      $('#addchoice').click(function(){
        var ul = $(this).closest('ul');
        var li = $(this).closest('li');
        var clone = li.clone(true);
        var name = 'choice' + $('#newchoices>li').length;
        clone.find('input').val('').attr('id', name).attr('name', name);
        clone.appendTo(ul);
        $(this).remove();
      });

      $('createsurvey').click(function(){
        $(document.body).append();
      });
    </script>
  </body>
</html>