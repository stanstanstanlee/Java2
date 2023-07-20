<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과화면</title>
</head>
<body>

<%
   String mid=request.getParameter("mid");
   String mpw=request.getParameter("mpw");
   if(mid.equals("admin") && mpw.equals("1234")){
%>
   <h1>관리자페이지입니다.</h1>
<%
   }
   else{
%>
   <h1>다시 시도하세요.</h1>
<%
   }
%>

</body>
</html>