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

	<div class="container p-3">
		<a href="/events">Dashboard</a>
		<div class="row">
			<div class="container col-6">
				<h1 class="mb-4"><c:out value="${ event.name }"/></h1>
				<p class="m-0">Host: <c:out value="${ event.host.firstName } ${ event.host.lastName }"/></p>
				<p class="m-0">Date: <c:out value="${ formatter.format(event.date) }"/></p>
				<p class="m-0">Location: <c:out value="${ event.location }, ${ event.state }"/></p>
				<p class="m-0">People who are attending this event: </p>
				<table class="table table-sm table-bordered">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Location</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${ event.joined_users }" var="user">
				    <tr>
				      <td><c:out value="${ user.firstName } ${ user.lastName }"></c:out></td>
				      <td><c:out value="${ user.location }"></c:out></td>
				    </tr>    
				  </c:forEach>
				  </tbody>
				</table>
			</div>
			<div class="container col-6">
			<h3>Message Wall</h3>
			<div class="border overflow-auto" style="height: 300px;">
			<c:forEach items="${ event.comments }" var="comment">
			<p class="m-0 ml-1"><c:out value="${ comment.host.firstName } ${ comment.host.lastName }"/> says: <c:out value="${ comment.comment }"/></p>
			</c:forEach>
			
			</div>
			<form:form class="mt-3" action="/events/${ event.id }" method="POST" modelAttribute="newComment">
				<form:label path="comment">Add Comment:</form:label>
				<form:textarea class="form-control" path="comment" required="required"/>
				<small><form:errors path="comment" class="text-danger d-block"/></small>
				<form:hidden path="host" value="${ user.id }"/>
				<form:hidden path="event" value="${ event.id }"/>
				<form:hidden path="id" value="${ null }"/>
				
				<form:button type="submit" class="btn btn-primary mt-3 float-right">Submit</form:button>
			</form:form>
			</div>
		</div>
	</div>
</body>
</html>