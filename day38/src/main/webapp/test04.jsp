<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글 나오게
   request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	선택상자 <%= request.getParameter("box") %> <br>
	체크박스(는 여러개니까 리스트로 출력) 자바로 하면 좋앙
	<ul>
	<%
	String[] datas=request.getParameterValues("fav"); //parametervalues를 이용하면 체크박스의 값들을 여러개 받아올 수 있음
		for(int i=0; i<datas.length; i++){//전달받은데이터개수만큼
			out.println("<li>"+datas[i]+"</li>");
		}
	%>
	</ul>
	 
</body>
</html>