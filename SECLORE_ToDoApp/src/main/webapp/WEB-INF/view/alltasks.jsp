<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All TODOs</title>
<link rel="stylesheet" href="/css/style1.css" type="text/css">
</head>
<body>
	<nav>
		<div class="nav-item">
			<a href="/todo/addtask" class="nav-btn"> Add a TODO </a>
		</div>
		<div class="nav-item">
			Welcome, <%=(String)session.getAttribute("name")%>
		</div>
		<div class="nav-item">
			<a href="/logout" class="nav-btn"> Logout</a>
		</div>

	</nav>
	<h2>Your TODO List</h2>
	<hr>
	<%String message=(String)session.getAttribute("message");%>
	<%if(message==null){ %>
	<table class="todo-list">
		<tr class="header-row">
			<th>Task ID</th>
			<th>Title</th>
			<th>Description</th>
			<th>Status</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="todo" items="${todoList}">
			<tr class="${todo.getStatus()}">
				<td>${todo.getTaskId()}</td>
				<td>${todo.getTitle()}</td>
				<td>${todo.getDescription()}</td>
				<td>${todo.getStatus()}</td>
				<td><form:form modelAttribute="todoDetails"
						action="/todo/updatedelete" method="post">
						<form:input path="taskId" value="${todo.getTaskId()}"
							hidden="hidden" />
						<form:input path="title" value="${todo.getTitle()}"
							hidden="hidden" />
						<form:input path="description" value="${todo.getDescription()}"
							hidden="hidden" />
						<form:input path="status" value="${todo.getStatus()}"
							hidden="hidden" />
						<input type="submit" value="Edit" name="submit">
						<input type="submit" value="Delete" name="submit">
					</form:form></td>
			</tr>
		</c:forEach>
	</table>
	<%} %>
	<%if(message!=null) {%>
	<p style="color: red;"><%=message %></p>
	<% session.removeAttribute("message");
} %>
</body>
</html>