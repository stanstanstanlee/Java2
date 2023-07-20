<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 페이지</title>
</head>
<body>
	<form action="controller.jsp" method="post">
		<input type="hidden" name="action" value="saveBoard" >
		글제목<input type="text" name="title" required>
		글내용<input type="text" name="content" required>
		작성자<input type="hidden" name="writer" value="<%=session.getAttribute("mid")%>">
		<input type="submit" value="글작성">
	</form>
	
	<a href="controller.jsp?action=main">메인으로 돌아가기</a> <!-- 글작성 하기 싫어질수도 -->
</body>
</html>