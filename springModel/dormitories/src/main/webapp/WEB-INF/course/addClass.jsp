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
			<h1><c:out value="${ student.firstName } ${ student.lastName }"/></h1>
			<form:form action="/students/${student.id}/add" method="POST" modelAttribute="newRelObj">
				<form:label path="course">Classes:</form:label>
				<form:select class="form-control col-6" path="course">
					<c:forEach items="${ courses }" var="course">
						<form:option value="${ course.id }"><c:out value="${ course.name }"/></form:option>
					</c:forEach>
				</form:select>
				<form:hidden path="student" value="${ student.id }"/>
				<form:button type="submit" class="btn btn-info mt-2">Add</form:button>
			</form:form>
		</div>
		<div class="container mt-3">
			<h4>Your Schedule</h4>
			<table class="table table-bordered">
			  <thead>
			    <tr>
			      <th scope="col">Class Name</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${ studentCourses }" var="course">
			    <tr>
			      <td><c:out value="${ course.course.name }"/></td>
			      <td><a href="/drop/${ student.id }/${ course.id }">Drop</a></td>
			    </tr>
			  </c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
</body>
</html>