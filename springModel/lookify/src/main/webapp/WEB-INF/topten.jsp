<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<title>Insert title here</title>
	</head>
<body>
	<div class="container">
		<div class="container pt-3">
			<a href="/dashboard" class="float-right">Dashboard</a>
			<h1>Top Ten Songs:</h1>
			<table class="table mt-3">
			  <thead>
			    <tr>
			      <th scope="col">Rating</th>
			      <th scope="col">Title</th>
			      <th scope="col">Artist</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${ TopSongs }" var="song">
			    <tr>
			      <td><c:out value="${ song.rating }"/></td>
			      <td><a href="/songs/${ song.id }"><c:out value="${ song.title }"/></a></td>
			      <td><c:out value="${ song.artist }"/></td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
</body>
</html>