<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<title>New License</title>
	</head>
<body>
	<div class="container">
		<div class="container">
			<h1>New License</h1>
			<form action="/licenses/new" method="POST">
				<div class="form-group">
					<label for="person">Person:</label>
					<select name="person" class="form-control col-4" id="person">
					<c:forEach items="${ persons }" var="person">
					<option value="${ person.id }"><c:out value="${ person.firstName } ${ person.lastName }"/></option>
					</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label for="state">State:</label>
					<input type="text" name="state" class="form-control col-4" id="state">
				</div>
				<div class="form-group">
					<label for=date>Expiration Date:</label>
					<input type="date" name="date" class="form-control col-4" id="date">
				</div>
				<button type="submit" class="btn btn-primary">Create</button>
			</form>
 		</div>
	</div>
</body>
</html>