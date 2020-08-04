<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<form action="create" method="post">
			<table>
				<tr>
					<td><label>Code/SKU</label></td><td><input type="text" name="cr_code"></td>
				</tr>
				<tr>
					<td><label>Product Name</label></td> <td><input type="text" name="cr_name"></td>
				</tr>
				<tr>
					<td><label>Price</label></td> <td><input type="text" name="cr_price"></td>
				</tr>
					<td><td><input type="submit" name="Cancel" value="Cancel"></td></td> 
					<td><input type="submit" name="Create" value="Create"></td>
				</tr>
			</table>
		</form>
	</body>
</html>