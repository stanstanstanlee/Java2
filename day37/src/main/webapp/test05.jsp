<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% //스크립트릿 : 자바영역
	String result="";
	
if(request.getMethod().equals("POST")) { //만약 POST요청이 들어왔다면
	String id= request.getParameter("id"); //그거 나줘
	String pw=request.getParameter("pw");
	
	if(id.equals("admin") && pw.equals("1234")) {
		result="관리자님 환영합니다! :D ";
	}
	else {
		result="다시 입력하세요";
	}
}

%>
	<form method="post"> 
		<input type="text" name="id" required> 
		<input type="password" name="pw" required>
		<input type="submit" value="로그인">
	</form>

	<hr>

	<%= result %>

</body>
</html>