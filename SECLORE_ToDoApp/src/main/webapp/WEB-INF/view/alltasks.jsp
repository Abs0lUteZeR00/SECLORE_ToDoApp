<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All TODOs</title>
</head>
<body>
	<nav>
		<a href="/todo/addtask"> Add a TODO </a> <a href="/logout"> Logout
		</a>
	</nav>
	<h2>Your TODO List</h2>
	<hr>
	<h4><%= session.getAttribute("message") %>>
	</h4>
	<c:choose>
		<c:when test='${session.getAttribute("message") != null}'>
			<p>
				<%-- <c:out value="${session.getAttribute('message')"></c:out>  --%>
			</p>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>Title</th>
					<th>Description</th>
					<th>Status</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="todo" items="${todoList}">
					<tr>
						<td>
								${todo.getTitle()}
						</td>
						<td>
								${todo.getDescription()}
						</td>
						<td>
								${todo.getStatus()}
						</td>
						<td>
							<form:form modelAttribute="todoDetails"	action="/todo/updatedelete" method="post">
								<form:input path="taskId" value="${todo.getTaskId()}" hidden="hidden" /> 
								<form:input path="title" value="${todo.getTitle()}" hidden="hidden" />
								<form:input	path="description" value="${todo.getDescription()}"	hidden="hidden" />
								<form:input path="status" value="${todo.getStatus()}" hidden="hidden" />
								<input type="submit" value="Edit" name="submit">
								<input type="submit" value="Delete" name="submit">
							</form:form>
						</td>						
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

</body>
</html>