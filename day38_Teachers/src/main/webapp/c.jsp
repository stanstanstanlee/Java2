<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ProductVO,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	int total=0;
%>

<h1><%=session.getAttribute("name")%>님이 구매한 상품들입니다.</h1>
<hr>
<ol>
<%
	ArrayList<ProductVO> cart=(ArrayList<ProductVO>)session.getAttribute("cart");
	for(ProductVO v:cart){
		out.println("<li>"+v+"</li>");
		total+=v.getPrice();
	}
%>
</ol>
<hr>
<h2>총 금액은 <%=total%>원입니다.</h2>
<hr>
<a href="a.jsp">메인으로 돌아가기</a>

</body>
</html>