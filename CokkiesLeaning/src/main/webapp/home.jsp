<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<%
				Cookie ck[] = request.getCookies();
				for(int i=0;i<ck.length;i++)
				{
					out.print	(ck[i].getName()+" "+ck[i].getValue());
				}
			
			%>
</body>
</html>