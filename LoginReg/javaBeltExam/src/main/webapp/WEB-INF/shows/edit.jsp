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
			<h1><c:out value="${ show.title }"></c:out></h1>
			<form method="post" action="/shows/${ show.id }/edit">
					<div class="form-group row">
						<label class="col-3 col-form-label" for="title">Title:</label>
						<input type="text" class="form-control col-9" name="title" id="title" value="${ show.title }" required/>
					</div>		
					<div class="form-group row">
						<label class="col-3 col-form-label" for="network">Network:</label>
						<input type="text" class="form-control col-9" name="network" id="network" value="${ show.network }" required/>
					</div>	
					<button type="submit" class="btn btn-secondary float-right">Create</button>	
			</form>
			<a href="/delete/${ show.id }" class="btn btn-danger">Delete</a>
		</div>
	</div>
</body>
</html>