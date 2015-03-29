<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="../../resources/css/style.css" rel="stylesheet"
	type="text/css">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="../../resources/css/bootstrap.min.css" />

	<!-- Optional theme -->
	<link rel="stylesheet"
		href="../../resources/css/bootstrap-theme.min.css" />

	<!-- Latest compiled and minified JavaScript -->
	<script src="../../resources/js/bootstrap.min.js"></script>
	<title>Contact Us</title>
</head>

<body class="background">
	<div class="header">
		<div class="googleHeader">
			Logged in as
			<%=request.getAttribute("user")%>
			<a href="../FeedbackServlet.do?googleLogin=logout">Logout</a>
		</div>
		<ul class="nav nav-pills nav-justified">
			<li role="presentation"><a href="homepage.jsp">Home</a></li>
			<li role="presentation"><a href="About.jsp">About</a></li>
			<li role="presentation" class="active"><a href="ContactUs.jsp"
				onclick="">Contact Us</a></li>
		</ul>
	</div>
	<div class="content">
		<form action="../FeedbackServlet.do" method="post">
			<p>Your Feedback is very valuable</p>
			<p>
				<input id="email" name="emailID" type="text" class="form-control"
					placeholder="Enter Email ID" style="width: 500px" />
			</p>
			<p>
				<input id="name" name="name" type="text" class="form-control"
					placeholder="Enter your name" style="width: 500px" />
			</p>
			<textarea name="feedback" rows="5" cols="23"
				placeholder="Enter Your Feedback!" class="form-control"
				style="width: 500px"></textarea>
			<input type="submit" name="Submit" class="btn btn-primary" /> <input
				type="reset" name="reset" class="btn btn-primary" />
		</form>
	</div>
	<div class="footer">
		<p>This is a footer</p>
	</div>

</body>
</html>