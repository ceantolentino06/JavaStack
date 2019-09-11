<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Show</title>
</head>
<body>
	<div class="container">
		<div class="container col-8">
			<a href="/languages" class="float-right">Dashboard</a>
			<h1>Name: <c:out value="${language.name}"/></h1>
			<h4>Creator: <c:out value="${language.creator}"/></h4>
			<p>Version: <c:out value="${language.version}"/></p>
			<a href="${language.id}/edit">Edit</a>
			<form action="/languages/${language.id}" method="post">
    			<input type="hidden" name="_method" value="delete">
    			<input type="submit" value="Delete">
			</form>
		</div>
	</div>
</body>
</html>