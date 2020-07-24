<%@page import="com.product.list.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.product.list.dao.ProductDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Product List</title>
<link rel="stylesheet" href="stylesheet.css"/>
</head>
<body>
	<h1>Product(s) List</h1><hr>
	<div class="input">
		<form action="list" method="post">
			<label>Code/SKU</label>&nbsp;&nbsp;&nbsp;<input type="text" name="code"><br>
			<input type="submit" name="Find" value="Find">
			<!-- <table>
				<tr>
					<td>
						<label>Code/SKU</label>&nbsp;&nbsp;&nbsp;<input type="text" name="code">
					</td>
					<td>
						<input type="submit" name="Find" value="Find">
					</td>
				</tr>
			</table> -->
		</form>
	</div>
		<table>
			<p>
			<h3>Product(s) List</h3>
			
			</p>
			<tr>
				<th>Code/SKU</th><th>Name</th><th>Price</th>
			</tr>
			
			<% 
				String tCode = request.getParameter("code"); 
			%>
		    <% if (tCode == null || tCode.isEmpty()) { %> 
			     <div>
						<c:forEach items="${Products}" var="prod">
							<tr>
								<td>
									<%-- <c:out value="${prod.code}"/> --%> ${prod.code} 
								</td>
								<td>
									${prod.name}
								</td>
								<td>
									${prod.price}
								</td>
							</tr>
						</c:forEach> 
				   </div>
		   <% } else { %>
				   <div>
					<tr>
					<%-- <%
						request.getAttribute("SKU");
						request.getAttribute("Name");
						request.getAttribute("Price");
					%> --%>
					<%
						request.getAttribute("Product");
					%>
						<td>
							<%-- ${SKU} --%>
							${Product.code}
						</td>
						<td colspan=1>
							${Product.name}
						</td>
						<td colspan=1>
							${Product.price}
						</td>
					</tr>
				</div>
    		<% } %>
		</table>
	</body>
</html>