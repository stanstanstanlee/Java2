<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<%
	MemberVO data = (MemberVO)request.getAttribute("data");
%>
	<form action = "controller.jsp" method="post">
		<input type ="hidden" name="action" value="updateMember">
		아이디 <input type = "text" name = "mid" readonly value='<%=data.getMid()%>'> <br>
		비밀번호 변경 <input type="password" name="mpw" value='<%=data.getMpw()%>'> <br>
		이름 변경   <input type="text" name = "name" value='<%=data.getName()%>'>
		<input type="submit" value="회원정보변경">
	</form>

	<form action = "controller.jsp" method="post">
		<input type="hidden" name="action" value="deleteMember">
		<input type="hidden" name="mid" value='<%=data.getMid()%>'>
		<input type="submit" value="회원탈퇴">	
	</form>

	<a href="controller.jsp?action=main">메인으로 돌아가기</a> <!-- 수정 / 삭제가 하기 싫어질수도 -->

</body>
</html>