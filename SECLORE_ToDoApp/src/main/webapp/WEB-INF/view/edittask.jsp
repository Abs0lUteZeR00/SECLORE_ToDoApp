<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit a TODO</title>
	</head>
	<body>
		<h2>
			Edit a TODO
		</h2>
		<hr>
		<form:form modelAttribute="todoDetails" action="/todo/update">
			<p>TODO title</p>
			<form:input path="title" value="${todoDetails.getTitle()}"/>
			<p>Description</p>
			<form:textarea path="description">
				<c:out value="${todoDetails.getDescription{}"></c:out>
			</form:textarea>
			<p>Status (Currently <c:out value="${todoDetails.getStatus()}"></c:out>)</p>
			<form:select path="status">
				<form:option value="PENDING">Pending</form:option>
				<form:option value="INPROGRESS">In Progress</form:option>
				<form:option value="COMPLETED">Completed</form:option>
			</form:select>
			<input type="submit" value="Save" name="submit">
		</form:form>
	</body>
</html>