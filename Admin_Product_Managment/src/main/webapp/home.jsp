<%@page import="dto.Admin"%>
<%@page import="dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%Admin sessionadmin = (Admin)request.getSession().getAttribute("admin"); %>
	<h1> Welcome <%=sessionadmin.getAdminName()%></h1>
	<br><br>
	<a href="addproduct.jsp"> ADD PRODUCT </a>
	<br> <br> 
	<table border="2p" >
	<tr>
	<th>id</th>
	<th>name</th>
	<th>category</th>
	<th>brand</th>
	<th>price</th>
	<th>edit</th>
	<th>delete</th>
	</tr>
	<% List<Product> products = (List)request.getAttribute("products"); %>
	<% for(Product p : products) { %>
	<tr>
	<td> <%= p.getProductid() %></td>
	<td> <%= p.getProductName() %></td>
	<td> <%= p.getProductCategory() %></td>
	<td> <%= p.getProductBrand() %></td>
	<td> <%= p.getProductPrice() %></td>
	<td> <a href="edit?id=<%= p.getProductid() %>"> edit </a></td>
	<td> <a href="delete?id=<%= p.getProductid() %>"> delete </a> </td>
	</tr>
	<% } %>
	</table>
	<br> <br> 
	<a href="logout"> LOGOUT</a>

</body>
</html>