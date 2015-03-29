<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="../../resources/css/style.css" rel="stylesheet"
		type="text/css">
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="../../resources/css/bootstrap.min.css" />

		<!-- Optional theme -->
		<link rel="stylesheet"
			href="../../resources/css/bootstrap-theme.min.css" />

		<!-- Latest compiled and minified JavaScript -->
		<script src="../../resources/js/bootstrap.min.js"></script>
		<title>Home Page</title>
</head>

<body class="background">
	<form action="../FeedbackServlet.do" method="get">
		<div class="header">
			<div class="googleHeader">
				Logged in as
				<%=request.getAttribute("user")%>
				<a href="../FeedbackServlet.do?googleLogin=logout">Logout</a>
			</div>
			<div>
				<ul class="nav nav-pills nav-justified">
					<li role="presentation" class="active"><a href="#">Home</a></li>
					<li role="presentation"><a href="../FeedbackServlet.do?pagename=about">About</a></li>
					<li role="presentation"><a href="../FeedbackServlet.do?pagename=contactus">Contact Us</a></li>
				</ul>
			</div>
		</div>
		<div class="content">
			<p>This is a paragraph</p>
		</div>
		<div class="footer">
			<p>This is a footer</p>
		</div>
	</form>
</body>
</html>