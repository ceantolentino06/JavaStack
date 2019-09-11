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
			<a href="/shows">Go Back</a>
			<h1><c:out value="${ thisShow.title }"/></h1>
			<p>Network: <c:out value="${ thisShow.network }"/></p>
			<h2 class="mb-3">Users who rated this show</h2>
			<table class="table table-bordered">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">Rating</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${ usersRated }" var="rating">
			    <tr>
			      <td><c:out value="${ rating.rated_by.name }"/></td>
			      <td><c:out value="${ rating.rating }"/></td>
			    </tr>
			  </c:forEach>
			  </tbody>
			</table>
			<a href="/shows/${ thisShow.id }/edit" class="btn btn-secondary">Edit</a>
		</div>
		<div class="container mt-5">
			<form:form method="post" action="/shows/${ thisShow.id }" modelAttribute="newRating">
				<form:hidden path="rated_by" value="${ user.id }"/>
				<form:hidden path="show" value="${ thisShow.id }"/>
				<div class="row">
				<h2 class="col-4"><form:label path="rating">Leave a Rating:</form:label></h2>
				<form:errors class="text-danger" path="rating"></form:errors>
				<c:choose>
					<c:when test="${ thisShow.users_who_rated.contains(user) }">	
					<fieldset disabled>
					<form:input class="form-control" path="rating"/>
					</fieldset>
					</c:when>
					<c:otherwise>
					<form:input class="form-control col-3" path="rating"/>
					</c:otherwise>
				</c:choose>
				<form:hidden path="id" value="${ null }"/>
				<div class="col-auto">
				<c:choose>
					<c:when test="${ thisShow.users_who_rated.contains(user) }">
					<a href="" class="btn btn-secondary disabled">Rate!</a>
					</c:when>
					<c:otherwise>
					<form:button type="submit" class="btn btn-secondary">Rate!</form:button>
					</c:otherwise>
				</c:choose>
				</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>