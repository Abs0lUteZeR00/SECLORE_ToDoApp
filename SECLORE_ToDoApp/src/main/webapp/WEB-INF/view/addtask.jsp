<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add a TODO</title>
	</head>
	<body>
		<h2>
			Add a new TODO!
		</h2>
		<hr>
		<form:form modelAttribute="todoDetails" action="/todo/add">
			<p>TODO title</p>
			<form:input path="title"/>
			<p>Description</p>
			<form:textarea path="description"/>
			<p>Status</p>
			<form:select path="status">
				<form:option value="PENDING">Pending</form:option>
				<form:option value="INPROGRESS">In Progress</form:option>
				<form:option value="COMPLETED">Completed</form:option>
			</form:select>
			<input type="submit" value="Save" name="submit">
		</form:form>
	</body>
</html>