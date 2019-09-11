<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<title>Class</title>
	</head>
<body>

	<div class="container">
		<div class="container">
			<h1>Classes</h1>
			<form:form action="/classes/create" method="POST" modelAttribute="newCourseObj">
				<form:label path="name">Name:</form:label>
				<form:errors class="text-danger d-block" path="name"/>
				<form:input class="form-control col-6" path="name"/>
				<form:button type="submit" class="btn btn-primary mt-3">Create</form:button>
			</form:form>
		</div>
	</div>
</body>
</html>