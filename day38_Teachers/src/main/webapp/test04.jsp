<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
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
	체크박스
	<ul>
	<%
		String[] datas=request.getParameterValues("fav");
		for(int i=0;i<datas.length;i++){
			out.println("<li>"+datas[i]+"</li>");
		}
	%>
	</ul>

</body>
</html>