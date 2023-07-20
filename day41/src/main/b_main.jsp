<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.BoardVO,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
<%
/*
로그인 여부에 따라 
session으로 부터 현재 로그인 한 사람의 mid를 받아오도록

input이 submit을 제외하고 총 3가지 

mid
mpw
action이라는 이름으로 login을 넣어둠
	1개의 컨트롤러를 쓸건데 action값이 뭐니? 하는 기능 

*/
%>

<%
	String name=(String)session.getAttribute("mid");
	// == 아, 세션에 로그인 정보가 "name"이라는 변수명으로 저장되어있구나!

	if(mid==null){ // 로그인안된상태
%>
	<form action="controller.jsp" method="post">
		<input type="hidden" name="action" value="login">
		<input type="text" name="mid">
		<input type="password" name="mpw">
		<input type="submit" value="로그인">
	</form> <!-- form이 블록 요소라서 한칸을 혼자 다 차지(자동 줄바꿈) -->
	<a href = "contrller.jsp">회원가입</a>
<%
	}
	else{ //else는 로그인이 되어 있는거임 
		out.println("<a href='controller.jsp'>마이페이지</a> <a href='controller.jsp?action=logout'>로그아웃</a>");
	}
%>

<hr>

<table border="1">
	<tr>
		<th>글 번호</th><th>글 제목</th><th>작성자</th>
	</tr>
	<%
		ArrayList<BoardVO> datas=(ArrayList<BoardVO>)request.getAttribute("datas");
		for(BoardVO v:datas){
	%>
	<tr>
		<td><a href="controller.jsp?action=board&num=<%=v.getNum()%>"><%=v.getNum()%></a></td>
		<td><%=v.getTitle()%></td>
		<td><%=v.getWriter()%></td>
	</tr>
	<%
		}
	%>
</table>
<br>
<%
	if(mid!=null){
		out.println("<a href='controller.jsp'>게시글 작성</a>");
	}
%>

</body>
</html>