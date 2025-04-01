<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Welcome</h1>
	<a href="logout">logout</a>
	
	<%
		String cuser = (String) application.getAttribute("cuser");
		String tuser = (String) application.getAttribute("tuser");
	%>
	Current user :  <%=cuser%>
	Total user : <%=tuser %>
</body>
</html>