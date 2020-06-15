<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>


	<div class="wrapper">
		<div class="content">
			<div class="row">
				<!-- <div class="col-xs-12 col-lg-4 col-sm-4">
					<div class="thumbnail">
						<img alt="" src="/assets/images/error.jpg"
							class="img img-responsive" style="width: 100%">
					</div>
				</div> -->


				<div class="col-xs-12 col-lg-12 col-sm-12">
					<div class="jumbotron">

						<c:choose>
							<c:when test="${not empty httpStatus}">
								<h1>${httpStatus}!!!</h1>
								<h1>${errorMessage}</h1>
								<hr>
								<p>${errorDescription}
								<p>
							</c:when>

							<c:otherwise>
								<h1>404</h1>
								<h1>This Page is not Constructed</h1>
								<hr>
								<p>The Page you are looking for is not available
								<p>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

			</div>


		</div>
	</div>

</body>
</html>