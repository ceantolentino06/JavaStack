<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Add Song</title>
</head>
<body>
	<div class="container">
		<div class="container pt-3">
			<a href="/dashboard" class="float-right">Dashboard</a>
			<div class="container mt-5 col-6">
				<form:form action="/songs/new" method="POST" modelAttribute="song">
					<div class="form-group">
						<form:label path="title">Title:</form:label>
						<form:errors class="text-danger d-block" path="title"/>
						<form:input class="form-control" path="title"/>
					</div>
					<div class="form-group">
						<form:label path="artist">Artist:</form:label>
						<form:errors class="text-danger d-block" path="artist"/>
						<form:input class="form-control" path="artist"/>
					</div>
					<div class="form-group">
						<form:label path="rating">Rating:</form:label>
						<form:errors class="text-danger d-block" path="rating"/>
						<form:select class="form-control col-4" path="rating">
						<option value=1>1</option>
						<option value=2>2</option>
						<option value=3>3</option>
						<option value=4>4</option>
						<option value=5>5</option>
						<option value=6>6</option>
						<option value=7>7</option>
						<option value=8>8</option>
						<option value=9>9</option>
						<option value=10>10</option>
						
						</form:select>
					</div>
					<button type="submit" class="btn btn-primary float-right">Add Song</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>