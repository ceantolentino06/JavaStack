<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<p style="color:red"><c:out value="${error}"/></p>
	<form action="/submit" method="POST">
		<h1>What is the code?</h1>
		<input type="text" name="code">
		<button type="submit">Try Code</button>
	</form>
</body>
</html>