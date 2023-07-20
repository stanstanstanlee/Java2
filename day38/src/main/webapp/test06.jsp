<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward 액션</title>
</head>
<body>

<!-- 액션태그 -->
	<jsp:forward page="test08.jsp">
		<jsp:param value="12345" name="test"/>
	</jsp:forward>
	<%-- 
	http://localhost:8080/day38/test06.jsp <<== url이 test06인 상태
	forward 액션 태그를 활용하면
	처음에  요청했던(전송했던) 데이터드링 유지 가능 
	URL이 변경되지 않음 
		== 진짜로 새로운 요청이 된것이 아니라, 새로운 요청이 (추가된 요청이) 처리된 것 처럼 동작--%>

</body>
</html>