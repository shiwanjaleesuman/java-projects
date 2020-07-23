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
		// To prevent the back-button after Logout 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Usually used for the latest version of Browsers.
		response.setHeader("Pragma","no-cache"); // HTTP-1.0
		response.setHeader("Expires", "0"); // Proxies
	
		if(session.getAttribute("uName") == null)
		{
			response.sendRedirect("Login.jsp");
		}
	%>
	 
	Welcome ${uName}...<br>
	
	<a href="Home.jsp">All about Us</a></br>
	
	<form action="logout" method="get">
		<input type="submit" value="Logout">
	</form>

</body>
</html>