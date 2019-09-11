<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Details</title>
</head>
<body>
	<div class="container">
		<div class="container pt-3">
			<a href="/dashboard" class="float-right">Dashboard</a>
			<div class="container mt-5">
				<h3>Title: <c:out value="${ song.title }"/></h3>
				<h3 class="mt-5">Artist: <c:out value="${ song.artist }"/></h3>
				<h3 class="mt-5 mb-5">Rating(1-10): <c:out value="${ song.rating }"/></h3>
				<a href="/songs/${ song.id }/delete">Delete</a>
			</div>
		</div>
	</div>
</body>
</html>