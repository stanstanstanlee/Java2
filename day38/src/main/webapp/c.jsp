<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ProductVO,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 페이지</title>
</head>
<body>


<%
	int total=0;//총합을 담을 공간
%>
<h1><%=session.getAttribute("name")%>님이 구매한 상품들입니다.</h1>
<hr>
<ol>
<%
	ArrayList<ProductVO> cart=(ArrayList<ProductVO>)session.getAttribute("cart");
	//cart가 null이면 에러니까 if문 추가 
	//총합출력
	if(cart==null){
		out.println("구매한 상품이 없습니다");
	}
	else {
	for(ProductVO v:cart){//반복문 돌려서 목록 출력
		out.println("<li>"+v+"</li>"); //내부객체를 써서 리스트에 넣어준다 li는 ol이랑 세트임; 그래서 ol안에 li가 들어있어야함
		total+=v.getPrice(); //상품가격(v의 금액)을 총합에 더해줌 
	}
	}
//	out.println("<li>총합은 : "+total+"원 입니다</li>"); //ol내부에 있으면 괜찮음
%>
</ol>
<hr><!-- 총 가격이 나올 뷰; 시맨틱 태그 생각 하면 좋음 -->
<h2> 총 금액은 <%=total%>원입니다.</h2>
<hr>
<a href="a.jsp">메인으로 돌아가기</a> <!-- 메인으로 돌아갈 수 있는 버튼 -->

</body>
</html>