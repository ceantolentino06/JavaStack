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
		<div class="container col-6">
			<h1>Create a new show</h1>
			<small class="d-block mb-1 text-danger"><c:out value="${ showError }"/></small>
			<form method="post" action="/createShow">
					<div class="form-group row">
						<label class="col-3 col-form-label" for="title">Title:</label>
						<input type="text" class="form-control col-9" name="title" id="title" required/>
					</div>		
					<div class="form-group row">
						<label class="col-3 col-form-label" for="network">Network:</label>
						<input type="text" class="form-control col-9" name="network" id="network" required/>
					</div>	
					<button type="submit" class="btn btn-secondary float-right">Create</button>	
			</form>
		</div>
	</div>
</body>
</html>