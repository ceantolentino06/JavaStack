<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<title>New Person</title>
	</head>
<body>
	<div class="container">
		<div class="container col-8">
			<h1>New Person</h1>
			<form:form action="/person/new" method="POST" modelAttribute="person">
				<div class="form-group">
					<form:label path="firstName">First Name: </form:label>
					<form:errors class="text-danger d-block" path="firstName"/>
					<form:input class="form-control col-6" path="firstName"/>
				</div>
				<div class="form-group">
					<form:label path="lastName">Last Name: </form:label>
					<form:errors class="text-danger d-block" path="lastName"/>
					<form:input class="form-control col-6" path="lastName"/>
				</div>
				<button type="submit" class="btn btn-primary">Create</button>
			</form:form>
		</div>
	</div>
</body>
</html>