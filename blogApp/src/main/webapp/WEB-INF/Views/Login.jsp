<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href='<c:url value="Scripts/Bootstrap/css/bootstrap.min.css"></c:url>'>
<script
	src='<c:url value="Scripts/Bootstrap/jQuery/jquery_3-2-1.js"></c:url>'></script>
<script
	src='<c:url value="Scripts/Bootstrap/js/bootstrap.min.js"></c:url>'></script>
<link rel="stylesheet"
	href='<c:url value="Scripts/CSS/Login.css"></c:url>'>
<title>Blog App</title>
</head>
<body>
	<div id="main" class="container login">
		<div class="row justify-content-sm-center">
			<div class="col-sm-5">
				<c:if test="${Message}">
					<div class="alert alert-danger alert-dismissible fade show">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<strong>Attention!</strong> ${MessageText}
					</div>
				</c:if>
				<h3 align="center">Blog.com</h3>
				<form id="loginForm" action="Login" method="post">
					<div class="form-group">
						<label for="userName">Username:</label> <input type="text"
							name="userName" class="form-control" id="userName">
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							name="password" class="form-control" id="password">
					</div>
					<div align="center">
						<button type="submit" class="btn btn-primary">Login</button>
						<a href="Register" class="btn btn-primary" role="button">Register</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>