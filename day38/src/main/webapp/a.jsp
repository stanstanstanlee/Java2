<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.ProductVO" %>
<jsp:useBean id="pDAO" class="model.ProductDAO" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%--
로그인 로그아웃과 상품선택이 한 페이지에 있을 예정
보통 사이트가 이렇게 되어 있기 때문
 
 --%>
<body> <!-- id="header" 시맨틱테그: 문서의 구조와 의미를 더 명확하게 전달 -->
<div id="header" > <!-- 영역1: 로그인&로그아웃 란 -->
	<%
	//로그인을 안했다면 로그인 버튼을 띄울것임
	//내가 만약 로그인을 했다면 로그아웃 버튼을
	if( session.getAttribute("name") == null ){ //혹시 로그인 안했어? 그럼 로그인 버튼
	//로그인이라는걸 하려면 input아이디, input비밀번호, input버튼 이렇게 넣어야 함
	//input들을 감싸줄 form이 필요함
	//로그인이라는걸 하게 되면 session에 mid값을 저장 하게 됨
	// 로그인 안했어? 라는 건session에 mid값이 저장이 안되어있어?? 와 같은 뜻임
			
	%>
		<form action="d.jsp" method="post">  <!-- 이곳에 아이디 쓰고 로그인 버튼 누르면 진행 할 수 있게 -->
			<%--form 태그에 메서드를 작성 하지 않았기 때문에 get 방식 
									메서드 post는 post--%>
			아이디 <input type="text" name="mid"> 
			비밀번호 <input type="password" name="mpw"> <br>
			<input type="submit" value="로그인">
		</form>
	<% 
	}
	else{ //로그인 했어? 그럼 로그아웃 버튼 
			//로그아웃을 할때 필요한 데이터가 없음 : 보낼 데이터가 없기 때문에 <a 태그로 작업
			//a태그는 전달 방식이 default로 get 입니다
	%>
			<!-- ㅁㅁㅁ님: ㅁㅁㅁ이 session.getAttribute("mid")임  -->
		<%=session.getAttribute("name")%>님, 안녕하세요! :D | <a href="e.jsp">로그아웃</a> 
	<%
	}
	%>
</div>

<hr>
		<!-- 시맨틱태그 content -->
<div id="content"> <!-- 영역2: 상품목록을 출력하고 선택 하는 공간 -->
	<!--  상품목록에서 상품을 하나 고를 예정이니까 -->
	<form action="b.jsp"> <!-- 추가하는건 b.jsp에서 진행 -->
		상품선택 <select name="num"> <!-- 넘겨져서 오는 값은 product인데 pk니까 num으로 세팅 -->
			<%	//<option을 DB에서 꺼내 볼거임. DAO의 datas한테서 부터 꺼내서 볼거라는 것
				//ProductDAO pDAO = new ProductDAO();를 써줘야 하는데 useBean이 대신 해줌 ㅎㅎ 
				ArrayList<ProductVO> datas=pDAO.selectAll(null);//productDAO한테서 불러옴
				//null값으로 줘도 상관이 없는데 DAO의 selectAll에서 기능이 바로 return datas; 해주기 때문에
				//인자인 pVO에 아무거나 줘도 상관 없음. 원래는 모델 selectAll메서드에 기능이 있고 인자가 있으면
				// 발할라의대천사 : selectAll 에서 조건이 하나도 없는 상태여서 뭘 넣어도 return datas; 해주기 때문에 null 넣어도 괜찮은거죠!
				//selectAll(pVO) 이런식으로 줘야함 
				for(ProductVO v:datas){ //만약에 datas가 없으면 NullPointerException에러 뜸
					out.println("<option value='"+v.getNum()+"'>"+v+"</option>"); //이거 누르면 PK보내야 한다고 value=v.getNum()
									//사용자가 선택한 v.getNum(가짜값)을 value(진짜값)로 넘겨줌 그래서 num이 value로 등록된다
				}
			%>
		</select>
		<input type="submit" value="장바구니에 추가하기"><!-- 상품선택 -->
	</form>
</div>

<hr>

<!-- 영역3: 결제 하는 란-->
<a href="c.jsp">결제하기</a> <!-- 마지막 a태그를 누르면 결제화면으로 이동 할 예정 -->





</body>
</html>