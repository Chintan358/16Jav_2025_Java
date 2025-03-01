<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%-- <%
			String msg = (String)request.getAttribute("msg");
			if(msg!=null)
			{%>
				<span> <%=msg%></span>
			<%}
		%> --%>
		<span>${msg}</span>
		<form action="registration" method="post">
		<input type="text" name="uname" placeholder="Enter username">
		<br>
		<br>
		<input type="text" name="email" placeholder="Enter email">
		<br>
		<br>
		<input type="text" name="phone" placeholder="Enter Phone">
		<br>
		<br>
		<input type="submit">
		 
		
		
		</form>
</body>
</html>