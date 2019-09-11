<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Insert title here</title>
</head>
<body>
	<div class="container p-3">
		<div class="container col-6 border p-2" style="height:480px;">
			<form action="/submit" method="POST">
				<label for="name">Your Name:</label>
				<input class="form-control mb-2" type="text" name="name" id="name">
				<label for="location">Dojo Location:</label>
				<select class="form-control mb-2" name="location" id="location">
  					<option value="San Jose">San Jose</option>
  					<option value="Berkeley">Berkeley</option>
  					<option value=Seattle>Seattle</option>
				</select>
				<label for="lang">Favorite Language:</label>
				<select class="form-control mb-2" name="lang" id="lang">
  					<option value="Java">Java</option>
  					<option value="Javascript">Javascript</option>
  					<option value=Python>Python</option>
				</select>
				<label for="comment">Comment:</label>
				<textarea class="form-control mb-2" name="comment" id="comment" rows="5" cols="23"></textarea>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>