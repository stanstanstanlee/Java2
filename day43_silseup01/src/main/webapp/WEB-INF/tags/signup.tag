<%@ tag language="java" pageEncoding="UTF-8"%>

<form action="controller.jsp" method="post">
	<input type="hidden" name="action" value="signup">
	아이디 <input type="text" name="mid"> <br>
	비밀번호 <input type="password" name="mpw"> <br>
	이름 <input type="text" name="name"> <br>
	<input type="submit" value="회원가입">
</form>

<br>

<a href="controller.jsp?action=main">메인으로 돌아가기</a>