<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="/css/style1.css" type="text/css">
</head>
<body>
<div class="container">
<div align="center">
<div style="margin-left: 20% ; margin-right: 20%">
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
<td><input type="email" name="email" required="required"></td>
</tr>
<tr>
<td>Password: </td>
<td><input type="password" name="password" required="required"></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Login"></td>
</tr>
</table>

</form>
<br>
<hr>
<br>
<a href="signup">Sign Up</a>
</div>
</div>
</div>
</body>
</html>