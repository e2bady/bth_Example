<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="./selectionBox/jquery.multiselect.css" />
<link rel="stylesheet" type="text/css" href="./selectionBox/jquery.multiselect.filter.css" />
<link rel="stylesheet" type="text/css" href="./selectionBox/jquery-ui-1.8.23.custom.css" />

<script type="text/javascript" src="./selectionBox/jquery-1.8.0.js"></script>
<script type="text/javascript" src="./selectionBox/jquery-ui-1.8.23.custom.js"></script>
<script type="text/javascript" src="./selectionBox/jquery.ui.widget.js"></script>
<script type="text/javascript" src="./selectionBox/jquery.ui.progressbar.js"></script>
<script type="text/javascript" src="./selectionBox/jquery.multiselect.js"></script>
<script type="text/javascript" src="./selectionBox/jquery.multiselect.filter.js"></script>
<script src="./selectionBox/jsBase.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
$(document).ready(function() {  
	$.get('UserTable')
	  .success(function(responseJson) {        
        var $div = $('#mywebform');
        $(responseJson).appendTo($div);  
        
        //Foreach #datepicker_.*
        //$(function() {
		//$( "#datepicker_.*" ).datepicker({ dateFormat: "dd.mm.yy" });
		//});
        
        //Foreach #multiselectfilter_.*
        //$("#multiselectfilter_.*").multiselect().multiselectfilter();
        
        //Foreach #multiselect_.*
        //$("#multiselectfilter_.*").multiselect();
      })
	  .error(function() { })
      .complete(function() {  });
});
</script>
<body>
	<div id="mywebform">
		
	</div>
</body>
</html>