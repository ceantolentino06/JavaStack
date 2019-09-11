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
			<h1><c:out value="${ dorm.name }"/> Dormitory</h1>
			
			<form action="/dorms/${ dorm.id }" method="POST">
			<label for="student">Students:</label>
				<select class="form-control col-4" name="student">
					<c:forEach items="${ students }" var="student">
						<option value="${ student.id }"><c:out value="${ student.firstName } ${ student.lastName }"/></option>
					</c:forEach>
				</select>
				<input type="submit" class="btn btn-primary mt-2" value="Add"/>
			</form>
		</div>
		<div class="container mt-3">
			<table class="table table-bordered">
			  <thead>
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${ dorm.students }" var="student">
			    <tr>
			      <td><c:out value="${ student.firstName } ${ student.lastName }"/></td>
			      <td><a href="/dorms/${dorm.id}/remove/${student.id}">Remove</a></td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
</body>
</html>