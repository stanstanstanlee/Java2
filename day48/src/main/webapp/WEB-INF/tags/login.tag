<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty mid }">
	<li><a href="logout.do"> 로그아웃 </a></li>
</c:if>

<c:if test="${empty mid}">
	<a href="javascript:signup()">회원가입</a>
	
	<li>
	<form action="login.do" method="post">
		<input type="text" name="mid" placeholder="아이디 입력" required>
		<input type="password" name="mpw" placeholder="비밀번호 입력" required>
		<input type="submit" value="로그인">
	</form>
	</li>

</c:if>