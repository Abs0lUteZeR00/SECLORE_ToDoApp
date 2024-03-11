<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div align="center">
<div style="margin-left: 30% ; margin-right: 30%">
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
</body>
</html>