<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<form:form action="adduser" method="post" modelAttribute="user" enctype="multipart/form-data">
			<form:hidden path="id"/>
			<form:label path="name">Name</form:label>
			<form:input path="name"/>
			<form:errors path="name"></form:errors>
			<br>
			<form:label path="email">Email</form:label>
			<form:input path="email"/>
			<form:errors path="email"></form:errors>
			<br>
			<form:label path="password">Password</form:label>
			<form:input path="password"/>
			<form:errors path="password"></form:errors>
			<br>
			<label>Profile Picture</label>
			<input type="file" name="file">
			<input type="submit">
			</form:form>
			
			<br>
			<br>
			
			<table>
			<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>image</th>
			
			<th colspan="2">Action</th>
			</tr>
			<c:forEach var="dt" items="${users}">
			<tr>
			<td>${dt.getId()}</td>
			<td>${dt.getName()}</td>
			<td>${dt.getEmail()}</td>
			<td><img alt="${dt.getImage()}" src="Image/${dt.getImage()}" width="50px" height="50px"> </td>
			<td><a href="delete?uid=${dt.getId()}">Delete</a></td>
			<td><a href="edit?uid=${dt.getId()}">Edit</a></td>
			</tr>
			</c:forEach>
			
			</table>
			
			
</body>
</html>