<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response.sendRedirect()</title>
</head>
<body>




<%
//내장객체를 활용하기 때문에 자바영역 필요
	response.sendRedirect("test08.jsp");
	// 처음에 전송한(요청한) 데이터가 유지 xxxxx
	// URL이 변경됨
	//	== 새로운 요청이 처리됨 
	//데이터를 유지 하지 않아도 되면 sendRedirect를 활용
	
%>

</body>
</html>