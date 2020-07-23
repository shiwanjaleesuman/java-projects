<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<%
		// To prevent the back-button after Logout 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("uName") == null)
		{
			response.sendRedirect("Login.jsp");
		}
	%>
	Welcome ${User}...<br>
	
	<a href="Home.jsp">All about Us</a></br>
	
	<form action="logout" method="get">
		<input type="submit" value="Logout">
	</form>
</body>
</html>