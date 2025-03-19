<%@page import="dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% Product p = (Product)request.getAttribute("products"); %>
	
	<form action="updateproduct" method="post">
	
	ID : <input type="text" name="id" value="<%= p.getProductid() %>" readonly="readonly"> <br> <br>
	
	Name : <input type="text" name="name"  value="<%= p.getProductName() %>" > <br> <br>

	Category : <input type="text" name="category"  value="<%= p.getProductCategory() %>" > <br> <br>
	
	Brand : <input type="text" name="brand"  value="<%= p.getProductBrand() %>" > <br> <br>
	
	Price : <input type="text" name="price"  value="<%= p.getProductPrice() %>" > <br> <br>
	
	<input type="submit">
	</form>

</body>
</html>