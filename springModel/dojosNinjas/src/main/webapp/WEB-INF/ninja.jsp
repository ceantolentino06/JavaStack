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
			<h1>New Ninja</h1>
			<form:form action="/ninja/new" method="POST" modelAttribute="newNinjaObj">
				<div class="form-group">
					<form:label path="dojo">Dojo:</form:label>
					<form:select path="dojo" class="form-control col-6">
					<c:forEach items="${ dojos }" var="dojo">
					<form:option value="${ dojo.id }"><c:out value="${ dojo.name }"/></form:option>
					</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<form:label path="firstName">First Name:</form:label>
					<form:errors class="text-danger d-block" path="firstName"/>
					<form:input class="form-control col-6" path="firstName"/>
				</div>
				<div class="form-group">
					<form:label path="lastName">Last Name:</form:label>
					<form:errors class="text-danger d-block" path="lastName"/>
					<form:input class="form-control col-6" path="lastName"/>
				</div>
				<div class="form-group">
					<form:label path="age">Age:</form:label>
					<form:errors class="text-danger d-block" path="age"/>
					<form:input class="form-control col-6" path="age"/>
				</div>
				<form:button type="submit" class="btn btn-primary">Create Ninja</form:button>
			</form:form>
		</div>
	</div>
</body>
</html>