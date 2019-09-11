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

	<div class="container-fluid">
		<div class="container col-md-6 col-xs-12 col-xl-4">
			    <h1 class="text-center">Login</h1>
			    <small class="text-danger d-block text-center"><c:out value="${ loginFailed }"/></small>
			    <p><c:out value="${error}" /></p>
			    <form method="post" action="/user/login">
			    	<div class="form-group">
			         	<label for="email">Email:</label>
			         	<input class="form-control" type="text" id="email" name="email"/>
			    	</div>
			    	<div class="form-group">
			         	<label for="password">Password:</label>
			         	<input class="form-control" type="password" id="password" name="password"/>
			    	</div>
			        <input class="btn btn-primary" type="submit" value="Login!"/>
			    </form>
		</div>
	</div>
</body>
</html>