<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>
 <div style="margin-right: 15%; margin-left: 15%">
<h1>Signup page</h1>

<%String message=(String)session.getAttribute("message");%>
<%if(message!=null) {%>
<p style="color: red;"><%=message %></p>
<% session.removeAttribute("message");
} %>

<form:form action="/register" method="post" modelAttribute="userDetails">
<table>
<tr>
<td>Name </td>
<td><form:input type="text" name="name" path="name" required="required"/></td> 
</tr>
<tr>
<td>Country Code </td>
<td>
<form:select path="countryCode" required="required">
<form:option value="+91">+91 India</form:option>
<form:option value="+1">+1 US</form:option>
</form:select>
</td>
</tr>
<tr>
<td>Phone Number</td>
<td><form:input type="tel" name="phoneNo" path="phoneNo" required="required"/></td>
</tr>
<tr>
<td>Email</td>
<td><form:input type="email" name="email" path="email" required="required"/></td>
</tr>
<tr>
<td>Password</td>
<td><form:input type="password" name="password" path="password" required="required"/></td>
</tr>
<tr>
<td>Confirm Password</td>
<td><input type="password" name="confirmPassword" required="required"></td>
</tr>
<tr>
<td><input type="submit" value="Register"></td>
</tr>
</table>
</form:form>
  
</div>
</body>
</html>