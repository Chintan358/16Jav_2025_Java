<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<sql:setDataSource driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/15janjava" user="root" password="root" var="datasource"/>
		
		<sql:query var="data" dataSource="${datasource}">
			select * from users;
		</sql:query>
		<c:forEach var="d" items="${data.rows}">
		<table>
		<tr>
		<td>${d.id}</td>
		<td>${d.name }</td>
		<td>${d.email }</td>
		<td>${d.phone }</td>
		</tr>
		</table>
		</c:forEach>
		
</body>
</html>