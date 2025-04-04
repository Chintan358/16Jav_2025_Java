<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
		<div class="container card mt-5 mx-auto col-10">
		<table class="table">
		<h1 class="text-center">User Data</h1>
		<hr>
		<thead>
		<tr>
		<th>UserId</th>
		<th>UserName</th>
		<th>Email</th>
		<th>image</th>
	
		<th colspan="2">Action</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="dt" items="${data}">
		<tr>
			<td>${dt.getId()}</td>
			<td>${dt.getUsername()}</td>
			<td>${dt.getEmail()}</td>
			<td><img alt="${dt.getImage()}" src="img/${dt.getImage()}" width="50px" height="50px"> </td>
			<td><a href="update?uid=${dt.getId()}&action=delete" class="btn btn-danger">Delete</a></td>
			<td><a href="update?uid=${dt.getId()}&action=update" class="btn btn-primary">Update</a></td>
	
		</tr>
		</c:forEach>
		</tbody>
		</table>
		</div>
		
</body>
</html>