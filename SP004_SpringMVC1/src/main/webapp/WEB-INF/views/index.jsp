<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>

<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	
	<div class="container">
	<div class="row">
		<div class="col-4 card mt-3 p-3">
		<h2>Student Registration</h2>
		<hr>
		<form:form action="addStudent" method="post" modelAttribute="student">
		<form:hidden path="id"/>
		
		<div class="form-group">
		<form:label path="name">Name</form:label>
		<form:input path="name" class="form-control"/>
		<form:errors path="name"></form:errors>
		</div>
		<br>
		<div class="form-group">
		<form:label path="email">Email</form:label>
		<form:input path="email" class="form-control"/>
		</div>
		<br>
		<div class="form-group">
		<form:label path="phone">Phone</form:label>
		<form:input path="phone" class="form-control"/>
		</div>
		<br>
		<input type="submit" class="btn btn-primary">
		</form:form>	
		</div>
		<div class="col-1"></div>
		<div class="col-7 card mt-3 p-3">
		<h2>Student Details</h2>
		<hr>
		<table class="table">
		<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Phone</th>
		<th colspan="2">Action</th>
		</tr>
		<c:forEach var="dt" items="${students}">
		<tr>
		<td>${dt.getId()}</td>
		<td>${dt.getName()}</td>
		<td>${dt.getEmail()}</td>
		<td>${dt.getPhone()}</td>
		<td><a href="delete?did=${dt.getId()}" class="btn btn-danger">Delete</a></td>
		<td><a href="edit?eid=${dt.getId()}" class="btn btn-primary">Edit</a></td>
		</tr>
		</c:forEach>
		</table>
		</div>
	</div>
	</div>
			
			
		
		
		
			
</body>
</html>