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
		<h1>Welcome</h1>
		<div class="row mt-5">
				<div class="container col-md-6">
		<h1 class="text-center">Register!</h1>
 
	    
	    <form:form method="POST" action="/" modelAttribute="newUser">
	        <div class="form-group">
	        	<small><form:errors class="text-danger d-block" path="firstName"/></small>
	            <form:label path="firstName">First Name:</form:label>
	            <form:input class="form-control" path="firstName" required="required"/>
	        </div>
	        <div class="form-group">
	        	<small><form:errors class="text-danger d-block" path="lastName"/></small>
	            <form:label path="lastName">Last Name:</form:label>
	            <form:input class="form-control" path="lastName" required="required"/>
	        </div>
	        <div class="form-group">
	        	<small><form:errors class="text-danger d-block" path="email"/></small>
	            <form:label path="email">Email:</form:label>
	            <form:input class="form-control" type="email" path="email" required="required"/>
	        </div>
	        <div class="form-group row">
	        	<div class="col-8">
	        	<small><form:errors class="text-danger d-block" path="location"/></small>
	            <form:label path="location">Location:</form:label>
	            <form:input class="form-control" path="location"/>
	        	</div>
	        	<div class="col-4">
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
	        <div class="form-group">
	        	<small><form:errors class="text-danger d-block" path="password" required="required"/></small>
	            <form:label path="password">Password:</form:label>
	            <form:password class="form-control" path="password"/>
	        </div>
	        <div class="form-group">
	        	<small><form:errors class="text-danger d-block" path="passwordConfirmation" required="required"/></small>
	            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
	            <form:password class="form-control" path="passwordConfirmation"/>
	        </div>
	        <input class="btn btn-primary" type="submit" value="Register!"/>
	    </form:form>
    
		</div>
		<div class="container col-md-6">
			    <h1 class="text-center">Login</h1>
			    <small class="text-danger d-block text-center"><c:out value="${ loginFailed }"/></small>
			    <p><c:out value="${error}" /></p>
			    <form method="post" action="/login">
			    	<div class="form-group">
			         	<label for="email">Email:</label>
			         	<input class="form-control" type="text" id="email" name="email"/>
			    	</div>
			    	<div class="form-group">
			         	<label for="password">Password:</label>
			         	<input class="form-control" type="password" id="password" name="password"/>
			    	</div>
			        <input class="btn btn-primary" type="submit" value="Login!"/>
			    </form>
		</div>
		</div>
	</div>
</body>
</html>