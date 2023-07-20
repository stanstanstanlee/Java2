<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib tagdir="/WEB-INF/tags" prefix="jin" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>

<script type = "text/javascript">
	function signup(){
		window.open("signup.jsp","회원가입 창","width=350,height=300")
	}
</script>

<div id="header">
	<h1>SNS 커뮤니티 실습 프로젝트</h1>
</div>

<div id="gnb">
	<ul>
		<li><a href="main.do">메인으로가기</a></li>
		<li></li> <%--이걸누르면 새창이 뜨는 동장->자바스크립트자리구나 --%>
		<li><jin:login/></li> <!-- 로그인 / 로그아웃 -> 커스텀태그 -->
		
	</ul>
</div>

<div id="content">
	<section>
	<jin:write/>
	</section>
	<hr>
	<section>
		게시글들을 보여주는 공간
			-> 댓글 작성할수있는 공간
			
		[더보기] : 페이지네이션 	 <!-- 기존의 count + 2를 count라는 파라미터에 줄거야 -->
		<a href="main.do?count=${count+2}">[더보기]</a>
		<!-- 메인 볼거야. 기존의 count값에 2를 더한만큼만 볼거야 -->
		<!-- 그럼 main에 올때 datas가 있어야 되니까 main에 올때 count가 있어야함 -->
		<!-- 내가 datas라고 el식으로 쓰고 있으니까 request.set이 있어야함 -->
		<!-- 그러니까 count도 el식으로 쓰고 있으니까 request.set이 있어야함 -->
		
		
	</section>
</div>

<div id="footer">
	<h3>&copy; NAVER corp. | 회사소개 | 이용약관 | 개인정보처리방침 | 고객센터| </h3>
</div>

</body>
</html>