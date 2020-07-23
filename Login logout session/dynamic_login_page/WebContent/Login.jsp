<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<p>
		<h3>Please Login here</h3>
	</p>
	<form action="login" method="post">
		<label>User Name:</label>&nbsp;&nbsp;<input type="text" name="userName"/><br>
		<label>Password:</label>&nbsp;&nbsp;<input type="password" name="pasword"><br>
		<input type="submit" name="Login" value="Login">
	</form>
</body>
</html>