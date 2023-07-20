<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방문자수가 올라가야하는 곳</title>
</head>
<body>

<%
	Integer cnt=(Integer)application.getAttribute("cnt");
					//obj기때문에 int에 넣을수는없음

	cnt++;
	application.setAttribute("cnt",cnt);
	//application을 활용하면 브라우저를 껐다가 켜도 데이터가 유지 된다 
%>

오늘의 방문자수는 <%=cnt %>명입니다

</body>
</html>