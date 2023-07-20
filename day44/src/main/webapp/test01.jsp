<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫 페이지</title>
</head>
<body>
<!-- 지금 서버가 꺼져있고 run하면 서버가 시작되는것이 가장 먼저임
	console을 보면 로그: 리스너 수행완료! 를 볼수 있음
	서버가 시작됨과 동시에 리스너가 서버가 시작됨을 감지했다
	어플리케이션을 통해 넣었잖앙 -->
<h1> 첫 페이지 </h1>
<hr>
${data.name } | ${data.age } <br> <!-- 데이터 넣었잖ㅇ: 데이터에 있는 나이와 이름도 볼수 있을까? 예 -->
<ul>
<%--
<c:out value=""></c:out> <!-- 단순 출력 -->
 잘 안쓰임
 --%>
	<c:forEach var="v" items="${ datas }"> <!--  어플리케이션 스코프에 데이터가 있어서 EL식으로 불러올 수 있음-->
		<li><c:out value="${v.name }" escapeXml="false"><font color='red'>이름없음</c:out> | ${v.age }</li> <!-- 무명이였던 친구들 0에서 이름없음으로 나옴 -->
	</c:forEach><!-- font를 태그로 인식 못함 ==>>> escape false로 해야함 -->
</ul>

</body>
</html>