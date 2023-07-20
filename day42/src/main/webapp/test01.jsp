<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- 태그 라이브러리 지시어(페이지 지시어) -->
<!-- uri, prefix(뭘로 호출 할지)가 있어야함 -->
<jsp:useBean id="pb" class="test.ProductBean" scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품선택페이지</title>
</head>
<body>

<form action="test02.jsp" method="post">
   <select name="product">

		<!-- JAVA의 for문 기능을 가지는 태그 -->
		<!-- JSTL에서 구현해놓았다! --> <!-- EL식으로 getter를 생략한 형태로 -->
		<c:forEach var="v" items="${pb.pdatas}"> <!-- 라이브러리꺼기 때문에 JSP에 등록을 해야지만 사용가능 -->
			<option>${v}</option>
			<!-- EL식 : 자바표현식; 선언해 놓은 친구를 노코스트로 불러낼 수 있음-->
		   </c:forEach>
   </select>
   <input type="submit" value="상품 선택">
</form>



</body>
</html>