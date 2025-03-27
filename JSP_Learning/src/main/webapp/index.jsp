<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<p>Hello</p>
			<h1>Java</h1>
			<%! public int a; %>
			<%
				/* int a = 10;
				int b = a/0; */
				
				/* int a[] = new int[5];
				a[7] = 10; */
				 a = 10;
			
			%>
			
			<%=a%>
			
</body>
</html>