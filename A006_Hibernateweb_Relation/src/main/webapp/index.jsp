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
					<div class="col-5 card p-5 mt-3 ">
					<h1>Add Product</h1>
					 <span class="text-success">${msg}</span>
					<hr>
						<form action="addproduct" method="post" >
						
						<div class="form-group">
						<label>Category</label>
						<select class="form-control" name="category">
							<option>---Select Category---</option>
							<c:forEach var="dt" items="${categories}">
							 <option value="${dt.getId()}" >${dt.getCname()}</option>
							</c:forEach>
						</select>
						</div>
						<br>
						<div class="form-group">
						<label>Product Name</label>
						<input type="text" name="pname" class="form-control">
						</div>
						
						<br>
						
						<input type="submit" class="btn btn-success"> 
						
						
						</form>
						
						
						
					</div>
					<div class="col-2   ">
					</div>
					<div class="col-5 card p-5 mt-3 ">
					<table class="table">
					<tr>
					<th>Id</th>
					<th>Pname</th>
					<th>Category</th>
					</tr>
					
					<c:forEach var="dt" items="${products}">
					<tr>
					<td>${dt.getId() }</td>
					<td>${dt.getPname() }</td>
					<td>${dt.getCategory().getCname() }</td>
					</tr>
					</c:forEach>
					
					
					</table>
					</div>
				</div>
			
			</div>
</body>
</html>