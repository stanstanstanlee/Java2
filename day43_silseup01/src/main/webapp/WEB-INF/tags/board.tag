<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name = "mid" %>
<%@ attribute name = "data" %>

<form name="form" action="controller.jsp" method="post">
	<input type="hidden" name="action" value="updateBoard">
	글 번호: <input type="text" name="num" value="${data.num}" readonly> <br>
	글 제목: <input type="text" name="title" value="${data.title}" 
				<c:if test="${mid ne data.writer}"> readonly</c:if>> <br>
				
	글 내용: <input type="text" name="content" value="${data.content }" 
				<c:if test="${mid ne data.writer}"> readonly</c:if>> <br>
	작성자: <input type="text" name="writer" value="${data.writer}" readonly> <br>
	<c:if test="${mid==data.writer}">
	<input type="submit" value="게시글 변경"> 
	<input type="button" value="게시글 삭제" onClick="delBoard()">
	</c:if>
</form>


<br>

<a href="controller.jsp?action=main">메인으로 돌아가기</a>
