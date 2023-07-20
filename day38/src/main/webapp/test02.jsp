<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="test01.jsp" %>
    							<!-- 에러발생했을때 여기로 가 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일부러만드는에러</title>
</head>
<body>

<%
	String str="apple";
	int i=Integer.parseInt(str);
%>


</body>
</html>