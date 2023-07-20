<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<c:if test= "${empty mid}"><!-- mid가 세션이여서 attribute 필요 없음 -->
	<%--mid는 컨트롤러가 세션 (브라우저단위)에 저장 하고 넘겨줌 <%@ attribute name = "mid" 없어도 됨
		브라우져에서 mid 가지고 옴 --%>

	<a href="controller.jsp?action=signupPage">회원가입</a>
	<form action="controller.jsp" method="post">
		<input type="hidden" name="action" value="login">
		<input type="text" name="mid">
		<input type="password" name="mpw">
		<input type="submit" value="로그인">
	</form>	
	
	</c:if>

	<c:if test= "${not empty mid}">
		<a href='controller.jsp?action=mypagePage'>${ mid }님의 마이페이지</a> <a href='controller.jsp?action=logout'>로그아웃</a>
	</c:if>
	<br>
	<c:if test= "${not empty mid}">
		<a href='controller.jsp?action=insertBoardPage'>게시글 작성</a>
		</c:if>