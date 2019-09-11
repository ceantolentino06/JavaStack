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
		<div class="container">
			<a href="/logout" class="float-right mt-2">Logout</a>
			<h1>Welcome, <c:out value="${ user.firstName }"/></h1>
		</div>
		<div class="container mt-3">
			<h6>Here are some of the events in your state:</h6>
			<table class="table table-bordered">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">Date</th>
			      <th scope="col">Location</th>
			      <th scope="col">Host</th>
			      <th scope="col">Action/Status</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${ eventsInMyState }" var="event">
			    <tr>
			      <td><a href="/events/${ event.id }"><c:out value="${ event.name }"/></a></td>
			      <td><c:out value="${ formatter.format(event.date) }"/></td>
			      <td><c:out value="${ event.location }"/></td>
			      <td><c:out value="${ event.host.firstName }"/></td>
			      <td>
				  <c:choose>
					<c:when test="${ event.host.id == user.id }">
			      		<a href="/events/${ event.id }/edit">Edit</a> | <a href="/delete">Delete</a>
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
		</div>
		<div class="container mt-5">
			<h6>Here are some of the events in other states:</h6>
			<table class="table table-bordered">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">Date</th>
			      <th scope="col">Location</th>
			      <th scope="col">State</th>
			      <th scope="col">Host</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${ eventsInOtherStates }" var="event">
			    <tr>
			      <td><a href="/events/${ event.id }"><c:out value="${ event.name }"/></a></td>
			      <td><c:out value="${ formatter.format(event.date) }"/></td>
			      <td><c:out value="${ event.location }"/></td>
			      <td><c:out value="${ event.state }"/></td>
			      <td><c:out value="${ event.host.firstName }"/></td>
			      <td>
			      <c:choose>
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
		</div>
		<div class="container">
			<h3>Create an Event</h3>
			<form:form action="/events" method="POST" modelAttribute="newEvent">
				<div class="form-group">
					<small><form:errors class="text-danger d-block" path="name"/></small>
					<form:label path="name">Name:</form:label>
					<form:input class="form-control col-5" path="name"/>
				</div>
				<div class="form-group">
					<small><form:errors class="text-danger d-block" path="date"/></small>
					<form:label path="date">Date:</form:label>
					<form:input type="date" class="form-control col-5" path="date"/>
				</div>
				<div class="form-group row">
	        	<div class="col-3">
	        	<small><form:errors class="text-danger d-block" path="location"/></small>
	            <form:label path="location">Location:</form:label>
	            <form:input class="form-control" path="location"/>
	        	</div>
	        	<div class="col-2">
	        	<form:label path="state">State:</form:label>
	        	<form:select class="form-control" path="state">
	        	<form:option value="CA">CA</form:option>
	        	<form:option value="AL">AL</form:option>
	        	<form:option value="AZ">AZ</form:option>
	        	<form:option value="AR">AR</form:option>
	        	<form:option value="CO">CO</form:option>
	        	</form:select>
	        	</div>
	        	<form:hidden path="host" value="${ user.id }"/>
	        	</div>
	        	<form:button type="submit" class="btn btn-info">Create Event</form:button>
			</form:form>
		</div>
	</div>
</body>
</html>