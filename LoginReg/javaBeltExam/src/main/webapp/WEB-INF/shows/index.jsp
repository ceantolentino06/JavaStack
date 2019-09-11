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
		<div class="container">
			<h1>Welcome, <c:out value="${ user.name }"/></h1>
			<a href="/logout">Logout</a>
			<h4 class="mt-3 mb-3">TV Shows</h4>
			<table class="table table-bordered">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Show</th>
			      <th scope="col">Network</th>
			      <th scope="col">Avg. Rating</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${ allShows }" var="show">
			    <tr>
			      <td><a href="/shows/${ show.id }"><c:out value="${ show.title }"/></a></td>
			      <td><c:out value="${ show.network }"/></td>
			      <td><c:out value="${ show.avgRating }"/></td>
			    </tr>
			  </c:forEach> 
			  </tbody>
			</table>
			<a href="/shows/new" class="btn btn-secondary">Add a show</a>
		</div>
	</div>
</body>
</html>