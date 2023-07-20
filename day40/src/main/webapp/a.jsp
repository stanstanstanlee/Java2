<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>

<%

	현재 로그인한 사람의 이름을 세션에서 받아올거임
	
	String name=(String)session.getAttribute("name");
	// == 아, 세션에 로그인 정보가 "name"이라는 변수명으로 저장되어있구나!
	
	if(name==null) {//로그인안된상태
%>		
<form action="controller.jsp" methid="post"> <!-- 로그인로직 MVC로 나눌거기 때문에 무조건 다 컨트롤러에게 -->
	<input type="text" name = "mid">
	<input type="password" name="mpw">
	<input type="submit" value="로그인">

</form>
<% 	
	}
	else {
		//form 태그는 input 태그 등으로 "데이터를 보낼수있음"
		//a 태그는 별도로 데이터를 보내지않을때 사용함
		out.println("<a href='controller.jsp'>마이페이지</a> <a href='controller.jsp'>로그아웃</a>");
	}

%>


로그인했니? (자바가필요)
	마이페이지지이동버튼 / 로그아웃
로그인안했니?
	로그인 / 회원가입페이지이동버튼


<hr>
<%-- 
<게시글 목록></게시글 목록>
<< 이곳의 버튼을 누르면 상세 페이지로 이동할수 있어야함
--%>
<table border="1">
	<tr>
	<th>글 번호</th><th>글제목</th><th>작성자</th>
	</tr>
	<tr><a
	

</table>
로그인했니?
	게시글작성페이지이동버튼

<%
if(name!=null){
	out.println("<a href='controller.jsp'>마이페이지)
	
	
}
%>

</body>
</html>