<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.BoardVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 페이지</title>
</head>
<body>
 
<%
	BoardVO data=(BoardVO)request.getAttribute("data");
%>
글 번호: <%=data.getNum()%> <br>
글 제목: <%=data.getTitle()%> <br>
글 내용: <%=data.getContent()%> <br>
작성자: <%=data.getWriter()%> <br>
<%
if(session.getAttribute("mid")!=null && session.getAttribute("mid").equals(data.getWriter())){
%>
	<form action="controller.jsp" method="post">
	<input type="hidden" name="action" value="updateBoard" >
	글 제목 수정: <input type="text" name="title" required>
	<br>
	글 내용 수정: <input type="text" name="content" required>
	<input type="hidden" name = "num" value="<%= data.getNum()%>">
	<input type="hidden" name="writer" value="<%=data.getWriter()%>">
	<br>
	<input type="submit" value="글 수정">
	</form>

	<form action="controller.jsp" method="post" >
	<input type="hidden" name="action" value="deleteBoard">
	<input type="hidden" name="num" value="<%= data.getNum()%>">
	<input type="submit" value="글 삭제">
	</form>

<%
}
%>
	
	<a href="controller.jsp?action=main">메인으로 돌아가기</a> <!-- 글수정 하기 싫어질수도 -->

</body>
</html>