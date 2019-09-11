<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<div class="container">
		<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Creator</th>
      <th scope="col">Version</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${languages}" var="language">
    <tr>
      <td><a href="/languages/${language.id}">${language.name}</a></td>
      <td>${language.creator}</td>
      <td>${language.version}</td>
      <td><a href="/languages/${language.id}/edit">Edit</a>|<form action="/languages/${language.id}" method="post">
    			<input type="hidden" name="_method" value="delete">
    			<input type="submit" value="Delete">
			</form></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
	</div>
	<div class="container col-6">
	<form:form action="/languages" method="post" modelAttribute="language">
		<div class="form-group">
			<form:label path="name">Name:</form:label>
			<form:errors class="text-danger d-block" path="name"/>
        	<form:input class="form-control" path="name"/>
		</div>
		<div class="form-group">
			<form:label path="creator">Creator:</form:label>
			<form:errors class="text-danger d-block" path="creator"/>
        	<form:input class="form-control" path="creator"/>
		</div>
		<div class="form-group">
			<form:label path="version">Version:</form:label>
			<form:errors class="text-danger d-block" path="version"/>
        	<form:input class="form-control" path="version"/>
		</div>		
        
        <input type="submit" class="btn btn-primary float-right" value="Submit"/>
	</form:form>
	</div>
</body>
</html>