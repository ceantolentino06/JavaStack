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
		<div class="container col-md-6">
			<a href="/events">Dashboard</a>
			<h1 class="mb-5"><c:out value="${ eventName }"/></h1>
			<h5>Edit Event</h5>
			<form:form action="/events/${ event.id }/edit" method="post" modelAttribute="event">
				<div class="form-group">
					<form:label path="name">Name:</form:label>
					<small><form:errors class="text-danger d-block" path="name"/></small>
					<form:input class="form-control" path="name"/>
				</div>
				<div class="form-group">
					<form:label path="date">Date:</form:label>
					<small><form:errors class="text-danger d-block" path="date"/></small>
					<form:input type="date" class="form-control" path="date"/>
				</div>
				<div class="form-group row">
	        	<div class="col">
	        	<small><form:errors class="text-danger d-block" path="location"/></small>
	            <form:label path="location">Location:</form:label>
	            <form:input class="form-control" path="location"/>
	        	</div>
	        	<div class="col">
	        	<form:label path="state">State:</form:label>
	        	<form:select class="form-control" path="state">
	        	<form:option value="CA">CA</form:option>
	        	<form:option value="AL">AL</form:option>
	        	<form:option value="AZ">AZ</form:option>
	        	<form:option value="AR">AR</form:option>
	        	<form:option value="CO">CO</form:option>
	        	</form:select>
	        	</div>
	        	</div>
	        	<form:button type="submit" class="btn btn-primary float-right">Edit</form:button>
			
			</form:form>
		</div>
	</div>
</body>
</html>