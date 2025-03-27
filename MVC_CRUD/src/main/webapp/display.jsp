<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
				<%
				String uname = (String)session.getAttribute("uname");
				if(uname==null)
				{
					request.setAttribute("err", "Please Login first !!!!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				
				%>
				<div class="container">
					<div class="row">
					<div class="col-10 mx-auto card p-5 mt-5">
					<h1 align="center">User Details</h1>
					<hr>
				<table class="table">
				<tr>
				<th>Id</th>
				<th>Username</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Action</th>
				<th><a href="logout" class="btn btn-warning">Logout</a></th>
				</tr>
				
				
			<%-- <%
			   ArrayList<User> users =(ArrayList)request.getAttribute("data");					
				for(User u : users)
				{ %>
					
					<tr>
					<td><%=u.getId()%></td>
					<td><%=u.getUname() %></td>
					<td><%=u.getEmail() %></td>
					<td><%=u.getPhone() %></td>
					<td><a href="update?uid=<%=u.getId()%>&action=delete" class="btn btn-danger">Delete</a></td>
					<td><a href="update?uid=<%=u.getId()%>&action=update" class="btn btn-primary">Update</a></td>
					</tr>
				<%}
			%> --%>
			
			<c:forEach items="${data}" var="u">
			
			<tr>
					<td>${u.getId()}</td>
					<td>${u.getUname() }</td>
					<td>${u.getEmail()}</td>
					<td>${u.getPhone()}</td>
					<td><a href="update?uid=${u.getId()}&action=delete" class="btn btn-danger">Delete</a></td>
					<td><a href="update?uid=${u.getId()}&action=update" class="btn btn-primary">Update</a></td>
					</tr>
			</c:forEach>
			
			</table>
			</div>
					</div>
				</div>
</body>
</html>