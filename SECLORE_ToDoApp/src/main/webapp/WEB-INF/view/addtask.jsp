<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a TODO</title>
<link rel="stylesheet" type="text/css" href="/css/style1.css">
</head>
<body>
	<div class="container">
		<div align="center">
			<div style="margin-left: 20%; margin-right: 20%">
				<h2>Add a new TODO!</h2>
				<hr>
				<form:form modelAttribute="todoDetails" action="/todo/add"
					method="post">
					<p>TODO title</p>
					<form:input path="title" maxlength="50"/>
					<p>Description</p>
					<form:textarea path="description" maxlength="100"/>
					<p>Status</p>
					<form:select path="status">
						<form:option value="PENDING">Pending</form:option>
						<form:option value="INPROGRESS">In Progress</form:option>
						<form:option value="COMPLETED">Completed</form:option>
					</form:select>
					<input type="submit" value="Save" name="submit">
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>