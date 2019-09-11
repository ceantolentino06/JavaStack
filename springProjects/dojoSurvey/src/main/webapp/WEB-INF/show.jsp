<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Insert title here</title>
</head>
<body>
	<div class="container p-3">
		<div class="container border col-6 p-3">
			<h4><u>Submitted Info</u></h4>
			<div class="container">
				<h6>Name: <c:out value="${name}"/></h6>
				<h6>Dojo Location: <c:out value="${location}"/></h6>
				<h6>Favorite Language: <c:out value="${lang}"/></h6>
				<h6>Comment: <c:out value="${comment}"/></h6>
			</div>
			<a href="/" class="btn btn-primary mb-2">Go Back</a>
		</div>
	</div>
</body>
</html>