<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div style="margin-left: 15% ; margin-right: 15%">
<h1>Login page</h1>

<%String message=(String)session.getAttribute("message");%>
<%if(message!=null) {%>
<p style="color: red;"><%=message %></p>
<% session.removeAttribute("message");
} %>


<form action="authenticate" method="post">
<table>
<tr>
<td>Email: </td>
<td><input type="email" name="email"></td>
</tr>
<tr>
<td>Password: </td>
<td><input type="password" name="password"></td>
</tr>
</table>
<input type="submit" value="Login">
</form>
</div>
</body>
</html>