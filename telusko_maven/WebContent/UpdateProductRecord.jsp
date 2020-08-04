<%@page import="com.product.list.entities.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<form action="update" method="post">
			<table>
				<%-- <%
					request.getAttribute("Product");
				%> --%>
				<%--<input type="hidden" name="code" value="${Product.code}" /> --%>
				<tr>
					<td><label>Code/SKU</label></td><td><input type="text" name="up_code"></td>
				</tr>
				<tr>
					<td><label>Product Name</label></td> <td><input type="text" name="up_name"></td>
				</tr>
				<tr>
					<td><label>Price</label></td> <td><input type="text" name="up_price" value="Product.price"></td>
				</tr>
					<td><input type="submit" name="Cancel" value="Cancel"></td>
					<td><input type="submit" name="Update" value="Update"></td>
				</tr>
			</table>
		</form>
	</body>
</html>