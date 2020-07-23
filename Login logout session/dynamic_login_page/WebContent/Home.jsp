<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
		if(session.getAttribute("uName") == null)
		{
			response.sendRedirect("Login.jsp");
		}
	%>
	Hey, this is the home page for telusko practice.<br> 
	
	<!-- https://www.youtube.com/watch?v=GODAlxW5Pes -->
	<iframe width="560" height="315"
		src="https://www.youtube.com/embed/GODAlxW5Pes" frameborder="0"
		allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
		allowfullscreen></iframe>
	<br>

	<form action="logout" method="get">
		<input type="submit" value="Logout">
	</form>
	
</body>
</html>