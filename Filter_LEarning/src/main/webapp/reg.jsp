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
			<h1>User Registration</h1>
			<hr>
			<span class="text-danger">${err}</span>
			<span class="text-success">${msg}</span>
			<form action="reg" method="post">
				<div class="form-group">
				<label>Username</label>
				<input type="text" name="uname" class="form-control" value="<%if(request.getParameter("uname")!=null){out.print(request.getParameter("uname"));}%>">
				<span class="text-danger">${unameErr}</span>
				</div>
				
				<div class="form-group">
				<label>Email</label>
				<input type="text" name="email" class="form-control" value="<%if(request.getParameter("email")!=null){out.print(request.getParameter("email"));}%>">
				<span class="text-danger">${emailErr}</span>
				</div>
				
				<div class="form-group">
				<label>Password</label>
				<input type="password" name="pass" class="form-control" value="<%if(request.getParameter("pass")!=null){out.print(request.getParameter("pass"));}%>">
				<span class="text-danger">${passErr}</span>
				</div>
				
				<div class="form-group">
				<label>Phone</label>
				<input type="text" name="phone" class="form-control" value="<%if(request.getParameter("phone")!=null){out.print(request.getParameter("phone"));}%>">
				<span class="text-danger">${phoneErr}</span>
				</div>
				
				<br>
				<div class="form-group">
				
				<input type="submit"  class="btn btn-success">
					</div>
				
				
				</form>
			
			
			</div>
		</div>
	</div>
</body>
</html>