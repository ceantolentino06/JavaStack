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
		<div class="container col-md-6 col-xs-12 col-xl-4">
		<h1>Register!</h1>
 
	    
	    <form:form method="POST" action="/user/register" modelAttribute="user">
	        <div class="form-group">
	        	<small><form:errors class="text-danger d-block" path="email"/></small>
	            <form:label path="email">Email:</form:label>
	            <form:input class="form-control" type="email" path="email"/>
	        </div>
	        <div class="form-group">
	        	<small><form:errors class="text-danger d-block" path="password"/></small>
	            <form:label path="password">Password:</form:label>
	            <form:password class="form-control" path="password"/>
	        </div>
	        <div class="form-group">
	        	<small><form:errors class="text-danger d-block" path="passwordConfirmation"/></small>
	            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
	            <form:password class="form-control" path="passwordConfirmation"/>
	        </div>
	        <input class="btn btn-primary" type="submit" value="Register!"/>
	    </form:form>
    
		</div>
	</div>
</body>
</html>