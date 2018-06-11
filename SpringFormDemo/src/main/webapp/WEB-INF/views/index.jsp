<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Registration Form</h2>
<c:if test="${user.userId == 0}">
<c:url value="adduser" var="add"></c:url>
<form:form action="${add}" modelAttribute="user">
	Username: <form:input path="username"/>
	Password: <form:input path="password"/>
	Contact no: <form:input path="phone_number"/>
	<input type="submit">
	
</form:form>
</c:if>

<c:if test="${user.userId != 0}">
<c:url value="updateuser" var="update"></c:url>
<form:form action="${update}" modelAttribute="user">
	Id<form:input path="userId" value="${user.userId}"/>
	Username: <form:input path="username"/>
	Password: <form:input path="password"/>
	Contact no: <form:input path="phone_number"/>
	<input type="submit">
	
</form:form>
</c:if>
<h2>User list</h2>
<table border="1px black">
		<tr>
			<th>Id</th>
			<th>Name</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.userId}</td>
				<td>${user.username}</td>
				<td><a href="edituser${user.userId}">Update</a></td>
				<td><a href="deleteuser${user.userId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>