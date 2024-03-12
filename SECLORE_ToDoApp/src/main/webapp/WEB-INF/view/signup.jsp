<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
<link rel="stylesheet" type="text/css" href="/css/style1.css">
</head>
<body>
<div class="container">
<div align="center">
<div style="margin-left: 20% ; margin-right: 20%">
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
<td><form:input type="text" name="name" path="name" required="required" maxlength="30" /></td> 
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
<td><form:input type="tel" name="phoneNo" path="phoneNo" required="required" maxlength="10"/></td>
</tr>
<tr>
<td>Email</td>
<td><form:input type="email" name="email" path="email" required="required" maxlength="30"/></td>
</tr>
<tr>
<td>Password</td>
<td><form:input id="password" type="password" name="password" path="password" maxlength="22" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"  required="required"/></td>
</tr>
<tr>
<td>Confirm Password</td>
<td><input id="confirmpassword" type="password" name="confirmPassword"  required="required" onkeyup="validate_password()"></td>
</tr>
<tr>
<td colspan="3">
<span id="wrong_pass_alert"></span>
</td>
</tr>
<tr>
<td colspan="2"><input id="submit" type="submit" value="Register"></td>
</tr>
</table>
</form:form>
 <br>
<hr>
<br>
<a href="/">Login</a>
</div>
</div>
</div>
<script type="text/javascript">
function validate_password() {
	 
    let password = document.getElementById('password').value;
    let confirmPassword = document.getElementById('confirmpassword').value;
    if (password != confirmPassword) {
        document.getElementById('wrong_pass_alert').style.color = 'red';
        document.getElementById('wrong_pass_alert').innerHTML= 'Use same password';
        document.getElementById('submit').disabled = true;
    } else {
        document.getElementById('wrong_pass_alert').style.color = 'green';
        document.getElementById('wrong_pass_alert').innerHTML ='Password Matched';
        document.getElementById('submit').disabled = false;
    }
}
</script>
</body>
</html>