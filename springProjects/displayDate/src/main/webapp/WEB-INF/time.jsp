<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/scriptTime.js" ></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>Display Time</title>
</head>
<body>
	<h1 class="time"><c:out value="${time}" /></h1>
</body>
</html>