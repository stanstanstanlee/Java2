<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입페이지</title>
</head>
<body>
	<form action = "controller.jsp" method="post"><!-- url이랑 post랑 같이 안씀; 문법상 post에서 안씀; url은 GET에있음 -->
		<input type ="hidden" name="action" value="signup">
		아이디 <input type = "text" name = "mid" required>
		비밀번호 <input type="password" name="mpw" required> <br>
		이름	   <input type="text" name = "name" required>
		<input type="submit" value="회원가입">
	</form>
	<%
	/*
	a 태그는 별도로 데이터를 보내지않을때 사용함
	10번에서 15번 사이에 action값을 보냈어야 하는것
	*/
	%>
	<br>
	
	<a href="controller.jsp?action=main">메인으로 돌아가기</a> <!-- 회원가입 하기 싫어질수도 -->
</body>
</html>