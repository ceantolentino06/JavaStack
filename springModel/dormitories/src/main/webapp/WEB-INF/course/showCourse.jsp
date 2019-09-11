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
			<h1><c:out value="${ course.name }"/></h1>
			<h4>Students taking this class: </h4>
			<table class="table table-bordered">
			  <thead>
			    <tr>
			      <th scope="col">Name</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${ course.students }" var="student">
			    <tr>
			      <td><c:out value="${ student.firstName } ${ student.lastName }"/></td>
			    </tr>
			  </c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
</body>
</html>