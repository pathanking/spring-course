<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>First Web App</title>
</head>
<body>
	<h1>Welcome to Our First Java Web Application</h1>

	<form action="WelcomeServlet" method="post">
		User Name: <input type="text" name="un"
			placeholder="Enter Your Username!">
		<button type="submit">Click</button>
	</form>
</body>
</html>