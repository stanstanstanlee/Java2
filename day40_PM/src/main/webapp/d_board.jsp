<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.BoardVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
</head>
<body>

<%
	BoardVO data=(BoardVO)request.getAttribute("data");
%>
글 번호: <%=data.getNum()%> <br>
글 제목: <%=data.getTitle()%> <br>
글 내용: <%=data.getContent()%> <br>
작성자: <%=data.getWriter()%> <br>

</body>
</html>