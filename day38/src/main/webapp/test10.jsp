<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	
	//request객체의 멤버변수 parameter의 getter로 		스트링타입의 member변수에 할당 
	String member=request.getParameter("mid");
	if(session.getAttribute("member")==null){ //혹시 첫 로그인이야? 그때만 세팅 해  
		session.setAttribute("member", member); //멤버등록 해 줘야 하니까 처음꺼에 "member"
	}
%>

<h1><%=session.getAttribute("member")%>님, 안녕하세요!:D</h1>
<form action="test11.jsp">
	상품 <select name = "product"> 
	<option>티셔츠</option>
	<option>목도리</option>
	<option>청바지</option>
	<option>운동화</option>
	<option>가방</option>
	</select>
	<input type="submit" value="장바구니에 추가하기">
</form>

<hr>
<a href="test12.jsp">최종결제</a>

</body>
</html>