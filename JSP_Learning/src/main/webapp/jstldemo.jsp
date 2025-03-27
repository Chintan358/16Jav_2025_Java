<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 	<c:out value="${'Welcome to tops'}"></c:out>	
 --%>
 	
 	<%-- <c:import url="https://topsint.com/topserp/" var="dt"></c:import>
 	<c:out value="${dt}"></c:out> --%>
 	
<%--  	<c:set var="data" value="5000"></c:set>
 	<c:out value="${data}"></c:out> --%>
 
 	<c:forEach var="dt" begin="1" end="10">${dtṄ}</c:forEach>
 </body>
</html>