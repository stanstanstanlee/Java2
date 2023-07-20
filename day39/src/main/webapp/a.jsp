<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 후 댓글 작성하기</title>
</head>
<body>

<div id="header"> <!-- 로그인 로그아웃 란 -->
	<%
	if( session.getAttribute("name") == null ){ 
	%>
		<form action="d.jsp" method="post">  <!-- 이곳에 아이디 쓰고 로그인 버튼 누르면 진행 할 수 있게 -->
			아이디 <input type="text" name="mid"> 
			비밀번호 <input type="password" name="mpw"> <br>
			<input type="submit" value="로그인">
		</form>
	<% 
	}
	else{ //로그인 했어? 그럼 로그아웃 버튼 
	%>
			<!-- ㅁㅁㅁ님: ㅁㅁㅁ이 session.getAttribute("mid")임  -->
		<%=session.getAttribute("name")%>님, 안녕하세요! :D | <a href="e.jsp">로그아웃</a> 
	<%
	}
	%>
	
</div>	

<hr>
<%
if( session.getAttribute("name") != null ){ 
%>
<div id="comment">
	<form action = "b.jsp" method = "post">
	댓글창 <input type="text" name= "comment"> <br>
	<input type = "submit" value="글 작성하기">
	</form>
</div>
<%
}
%>


<ul>
<%
//저장된 댓글 출력
ArrayList<String> comment = (ArrayList<String>)application.getAttribute("comment");
if(comment == null){
	out.print("댓글이 없음");
}
else {
	for(String v: comment){
		out.println("<li>"+v+"</li>");
		
	}
	
}

%>
</ul>

</body>
</html>