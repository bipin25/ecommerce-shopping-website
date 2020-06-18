<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<!-- Bootstrap core CSS -->
<link href="/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Theme(bootswatch.com) -->
<!-- <link href="/assets/css/bootstrap-theme.css" rel="stylesheet"> -->

<!-- Bootstrap datatables (https://datatables.net/download/) -->
<link href="/assets/css/dataTables.bootstrap.css" rel="stylesheet">

<!-- FontawesomeLibary -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/
font-awesome.min.css">

<link href="/assets/css/myapp.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<tiles:insertAttribute name="navbar" />
	</div>

	<div class="wrapper">
		<div class="content">
			<div
				style="padding-top: 60px; padding-bottom: 10px; width: 100%;">
				<tiles:insertAttribute name="body" />
			</div>

		</div>
	</div>

	<div style="clear: both">
		<tiles:insertAttribute name="footer" />
	</div>
	<!-- Jquery -->
	<script src="/assets/vendor/jquery/jquery.min.js"></script>
	
	<!-- Bootstrap core JavaScript -->
	<script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	<!-- Datatabel plugin (https://datatables.net/download/)-->
	<script src="/assets/js/jquery.dataTables.js"></script>
	<script src="/assets/js/dataTables.bootstrap4.js"></script>
	
	<!-- Jquery Validator https://jqueryvalidation.org/ -->
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.js"></script> -->
	
	<!-- custom js -->
	<script src="/assets/js/myapp.js"></script>
</body>
</html>