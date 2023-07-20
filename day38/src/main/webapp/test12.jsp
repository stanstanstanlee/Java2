<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>최종결제</title>
</head>
<body>

<h1>결제 페이지</h1>

	
	<%--세션이라는 객체의 멤버변수 attribute를 이용해서 String 타입의ㅊ"member"를 불러와	 --%>
	<!-- 그럼  -->
<h1><%=session.getAttribute("member")%>님이 결제하신 상품목록입니다. </h1> 
<!-- 브라우저가 그대로면 세션도 그대로임 
datas를 다시 null로 만드는 로직을 쓰면 다른 로그인 할때 마다 다른 장바구니-->

<ul>
	<%
		//ArrayList는 장바구니 
		ArrayList<String> datas = (ArrayList<String>)session.getAttribute("datas");
		if(datas==null){ //null 이면 아직 상품을 하나도 구매 안한거임 
			out.println("장바구니가 비어있습니다!");
		}
		else{
		for(String v:datas){
			out.println("<li>"+v+"</li>");
		}
		}
	%>
	<li></li>
</ul>

</body>
</html>