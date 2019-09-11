<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
	<div class="container pt-3">
		<div class="container row">
			<div class="col">
				<h5>Songs by artist: <c:out value="${ artist }"/></h5>
			</div>
			<div class="col">
				<form action="search" method="POST">
					<div class="form-row">
						<div class="col">
							<input class="form-control" type="text" name="artist">
						</div>
						<div class="col">
							<button type="submit" class="btn btn-primary">New Search</button>
						</div>
					</div>
				</form>
				<small class="text-danger"><c:out value="${ error }"/></small>
			</div>
			<div>
				<a href="/dashboard" class="float-right">Dashboard</a>
			</div>
		</div>
		<div class="container mt-3">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">Rating</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${ songs }" var="song">
			    <tr>
			      <td><a href="/songs/${ song.id }">${ song.title }</a></td>
			      <td>${ song.rating }</td>
			      <td><a href="/songs/${ song.id }/delete">Delete</a></td>
			    </tr>
			  </c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
</body>
</html>