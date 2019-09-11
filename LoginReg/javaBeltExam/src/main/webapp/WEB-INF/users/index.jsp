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
				<form:form action="/" method="post" modelAttribute="newUser">
					<div class="form-group row">
						<form:label class="col-sm-4 col-form-label" path="name">Name:</form:label>
						<form:input class="form-control col-8" path="name"/>
						<small><form:errors class="text-danger d-block" path="name"/></small>
					</div>
					<div class="form-group row">
						<form:label class="col-sm-4 col-form-label" path="email">Email:</form:label>
						<form:input type="email" class="form-control col-8" path="email"/>
						<small><form:errors class="text-danger d-block" path="email"/></small>
					</div>
					<div class="form-group row">
						<form:label class="col-sm-4 col-form-label" path="password">Password:</form:label>
						<form:password class="form-control col-8" path="password"/>
						<small><form:errors class="text-danger d-block" path="password"/></small>
					</div>
					<div class="form-group row">
						<form:label class="col-sm-4 col-form-label" path="passwordConfirmation">Password Conf:</form:label>
						<form:password class="form-control col-8" path="passwordConfirmation"/>
						<small><form:errors class="text-danger d-block" path="passwordConfirmation"/></small>
					</div>
					<form:button type="submit" class="btn btn-secondary float-right">Register</form:button>
				</form:form>
			</div>
			<div class="container col-6">
				<h1>Login</h1>
				<small class="text-danger d-block"><c:out value="${ loginFailed }"/></small>
				<form action="/login" method="post">
					<div class="form-group row">
						<label class="col-sm-3 col-form-label" for="email">Email:</label>
						<input type="text" class="form-control col-9" name="email" id="email"/>
					</div>
					<div class="form-group row">
						<label class="col-sm-3 col-form-label" for="password">Password:</label>
						<input type="password" class="form-control col-9" name="password" id="password"/>
					</div>
					<button type="submit" class="btn btn-secondary float-right">Login</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>