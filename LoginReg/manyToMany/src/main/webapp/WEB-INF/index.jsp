<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="container col-6">
				<h1>Register</h1>
				<form:form method="post" action="/register" modelAttribute="newUser">
					<form:label path="username">Username:</form:label>
					<form:input class="form-control" path="username"/>
					
					<form:label path="password">Password:</form:label>
					<form:password class="form-control" path="password"/>
					
					<form:button type="submit" class="btn btn-info mt-2">Register</form:button>
				</form:form>
			</div>
			<div class="container col-6">
				<h1>Login</h1>
				<form method="post" action="/login">
					<label>Username:</label>
					<input type="text" class="form-control" name="username"/>
					
					<label>Password:</label>
					<input type="password" class="form-control" name="password"/>
					
					<button type="submit" class="btn btn-info mt-2">Login</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>