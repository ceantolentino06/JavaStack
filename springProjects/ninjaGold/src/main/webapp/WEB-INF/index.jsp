<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div class="container pt-2 pb-2">
		<h3>Your Gold: <c:out value="${gold}"/></h3>
		<div class="container row text-center">
			<div class="container col-3 border p-3">
				<h3>Farm</h3>
				<p>(earns 10-20 gold)</p>
				<a href="/Gold/get_gold?location=farm" class="btn btn-primary">Find Gold!</a>
			</div>
			<div class="container col-3 border p-3">
				<h3>Cave</h3>
				<p>(earns 5-10 gold)</p>
				<a href="/Gold/get_gold?location=cave" class="btn btn-primary">Find Gold!</a>
			</div>
			<div class="container col-3 border p-3">
				<h3>House</h3>
				<p>(earns 2-5 gold)</p>
				<a href="/Gold/get_gold?location=house" class="btn btn-primary">Find Gold!</a>
			</div>
			<div class="container col-3 border p-3">
				<h3>Casino!</h3>
				<p>(earns/takes 0-50 gold)</p>
				<a href="/Gold/get_gold?location=casino" class="btn btn-primary">Find Gold!</a>
			</div>
		</div>
		<div class="container pt-3">
			<h3>Activities: </h3>
			<div class="container border overflow-auto" style="height: 200px;">
				<c:forEach items="${actions}" var="action">
					<p class="text-success m-0">${action}</p>
				</c:forEach>
			</div>
		</div>
		<a href="/Gold/reset" class="btn btn-primary mt-4">Reset</a>
	</div>
</body>
</html>