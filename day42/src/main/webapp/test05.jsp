<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실무 - 쇼핑몰 상품 선택 페이지</title>
</head>
<body>
	<form>
		<select name="sel"> <!-- 들어온 파라미터가 a야? 그럼 a로 보여줘 -->
			<option ${param.sel == 'a' ? 'select' : ''}>a</option>
			<option ${param.sel == 'b' ? 'select' : ''}>b</option>
			<option ${param.sel == 'c' ? 'select' : ''}>c</option>
		</select>
		<input type = "submit" value="선택">
	</form>	
	
	<hr>
	
	<c:choose>
		<c:when test="${param.sel == 'a'}">
			a를 선택했습니다. </c:when>
			
		<c:when test="${param.sel == 'b'}">
			b를 선택했습니다. </c:when>
			
		<c:when test="${param.sel == 'c'}">
			c를 선택했습니다. </c:when>
			
		<c:otherwise>
			??? 잘못된 파라미터입니다. </c:otherwise>
	</c:choose>
	

	
</body>
</html>