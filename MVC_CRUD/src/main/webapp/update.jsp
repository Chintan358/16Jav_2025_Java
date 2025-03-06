<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6 mx-auto card mt-3 p-5" >
			<h1>User Update</h1>
			<hr>
			<span class="text-success">${msg}</span>
			<form action="useredit" method="post">
				<input type="text" name="id" >
				<div class="form-group">
				<label>Username</label>
				<input type="text" name="uname" value="${user.getUname()}" class="form-control">
				</div>
				
				<div class="form-group">
				<label>Email</label>
				<input type="text" name="email" value="${user.getEmail()}" class="form-control">
				</div>
				
				<div class="form-group">
				<label>Phone</label>
				<input type="text" name="phone" value="${user.getPhone()}" class="form-control">
				</div>
				
				<br>
				<div class="form-group">
				
				<input type="submit"  value="update" class="btn btn-success">
				<a href="display" class="btn btn-danger">View Users</a>
				</div>
				
				
				</form>
			
			
			</div>
		</div>
	</div>
				
</body>
</html>