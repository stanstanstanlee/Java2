<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체</title>
</head>
<body>

<%
	application.setAttribute("memberName","홍길동");//회원의 이름을 하나 넣음
	
	application.setAttribute("cnt","0");
%>

<a href="test02.jsp">방문자수 확인하기</a>

</body>
</html>