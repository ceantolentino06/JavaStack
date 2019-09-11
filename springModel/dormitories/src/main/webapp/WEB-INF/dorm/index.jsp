<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<title>Insert title here</title>
	</head>
<body>
	<div class="container">
		<div class="container">
			<h1 class="text-center">Create a new Dormitory</h1>
			<div class="form" align="center">
				<form:form action="/dorms/new" method="POST" modelAttribute="newDormObj">
					<form:label class="font-weight-bold" path="name">Name: </form:label>
					<form:errors class="text-danger d-block" path="name"></form:errors>
					<form:input class="form-control col-6" path="name"/>
					<form:button class="btn btn-primary mt-3" type="submit">Create Dorm</form:button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>