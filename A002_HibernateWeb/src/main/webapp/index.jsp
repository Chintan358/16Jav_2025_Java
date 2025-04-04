<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
			<div class="container">
				<div class="row">
					<div class="col-5 card p-5 mt-3 mx-auto">
					<h1>User Registration</h1>
					 <span class="text-success">${msg}</span>
					<hr>
						<form action="reg" method="post" enctype="multipart/form-data">
						
						<input type="hidden" name="id" value="${udata.getId()}">
						<div class="form-group">
						<label>Username</label>
						<input type="text" name="uname" placeholder="enter username" class="form-control" value="${udata.getUsername()}">
						</div>
						<br>
						<div class="form-group">
						<label>Email</label>
						<input type="text" name="email" placeholder="enter email" class="form-control" value="${udata.getEmail()}">
						</div>
						<br>
						<div class="form-group">
						<label>Password</label>
						<input type="password" name="pass" placeholder="enter password" class="form-control" value="${udata.getPassword() }">
						</div>
						<br>
						<div class="form-group">
						<label>Image</label>
						<input type="file" name="file" class="form-control">
						</div>
						<br>
						
						
						
						<div class="form-group">
						
						<c:if test="${udata.getId()==null}">
						<input type="submit" class="btn btn-success">
						</c:if>
						<c:if test="${udata.getId()!=null}">
						<input type="submit" value="update" class="btn btn-success">
						</c:if>
						
						<a href="display">View Users</a>
						</div>
						
						
						</form>
					</div>
				</div>
			
			</div>
</body>
</html>