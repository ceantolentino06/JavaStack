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
		<div class="container">
			<h1>Welcome, <c:out value="${ user.username }"/></h1>
			<a href="/logout">Logout</a>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${ all_events }" var="event">
			    <tr>
			      <td><c:out value="${event.name }"/></td>
			      <td>
			      <c:choose>
			      	<c:when test="${ user.id == event.host.id }">
			      		<p>Edit | Delete</p>
			      	</c:when>
			      	<c:when test="${ event.joined_users.contains(user) }">
			      		<p class="m-0 text-success">Joining</p>
			      	</c:when>
			      	<c:otherwise>
			      		<a href="/join/${ event.id }">Join</a>
			      	</c:otherwise>
			      	</c:choose>
			      </td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>
			<h3>Create An Event</h3>
			<form:form method="post" action="/addEvent" modelAttribute="newEvent">
				<form:label path="name">Name:</form:label>
				<form:input class="form-control col-6 mb-2" path="name"/>
				<form:hidden path="host" value="${user.id }"/>
				<form:button type="submit" class="btn btn-info">Create Event</form:button>
			</form:form>
		</div>
	</div>
</body>
</html>