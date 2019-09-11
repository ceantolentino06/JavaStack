<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
	<div class="container">
		<div class="container col-6 pt-4">
			<div class="navs float-right">
				<a href="" class="mr-3">Delete</a>
				<a href="/languages">Dashboard</a>
			</div>	
			<%@ page isErrorPage="true" %> 
			<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
			<input type="hidden" name="_method" value="put">
			<div class="form-group">
			<form:label path="name">Name:</form:label>
			<form:errors class="text-danger d-block" path="name"/>
        	<form:input class="form-control" path="name"/>
			</div>
			<div class="form-group">
			<form:label path="creator">Creator:</form:label>
			<form:errors class="text-danger d-block" path="creator"/>
        	<form:input class="form-control" path="creator"/>
			</div>
			<div class="form-group">
			<form:label path="version">Version:</form:label>
			<form:errors class="text-danger d-block" path="version"/>
        	<form:input class="form-control" path="version"/>
			</div>		
        
        	<input type="submit" class="btn btn-primary float-right" value="Submit"/>
			</form:form>
		</div>
	</div>
</body>
</html>