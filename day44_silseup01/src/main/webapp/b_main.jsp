<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.BoardVO,java.util.ArrayList" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="kim" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>

<script src="js/main.js"></script>

<kim:login /><!-- 로그인 관련된거 라는걸 예상 -->

<hr>

<kim:printBoardList border="1">게시글 목록</kim:printBoardList> <!-- 보더가 1 정도 되나보다  -->

<br>

<kim:btn>게시글 작성</kim:btn> <!-- 버튼 관련 테그 : 버튼이 게시글 작설이라고 나오려나부다 예상할 수 있음 -->

</body>

</html>