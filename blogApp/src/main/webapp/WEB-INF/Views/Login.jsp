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
<title>Blog App</title>
</head>
<body>
	<div>
		<form action="Login" method="post">
			<input type="text" name="userName" required="required"> <input
				type="password" name="password" required="required"> <input
				type="submit" value="Login">
		</form>
	</div>
</body>
</html>