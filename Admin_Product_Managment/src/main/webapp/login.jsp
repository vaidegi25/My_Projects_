<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="login" method="post">                                
	
	Email : <input type="text" name="email"> <br>
	PassWord : <input type="text" name = "password"> <br>
	
	<input type="submit"> 
	
	 </form>
	 
	 <% String message = (String) request.getAttribute("message");  %>
	 <% if(message != null) { %>
	 <h2>  <%= message %> </h2>
	 <% } %>

</body>
</html>