<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/script.js" ></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>Display Date</title>
</head>
<body>
	<h1 class="date"><c:out value="${date}" /></h1>
</body>
</html>