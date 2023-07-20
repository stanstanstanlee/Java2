<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글기록</title>
</head>
<body>
<%
	String cmnt= request.getParameter("comment"); //comment가져왕

	ArrayList<String> comment = (ArrayList<String>)application.getAttribute("comment");

	if(comment==null){
		comment = new ArrayList<String>();
		application.setAttribute("comment",comment);
	}
	if(cmnt.equals("")){
		out.print("<script> alert('내용이없습니다')</script>");
	} else {
		comment.add(session.getAttribute("name")+": "+cmnt); //리스트에 담을 현재 댓글을 작성한 사용자의 이름과 그 사용자가 작성한 댓글
	}
%>
<script>
	location.href="a.jsp";
</script>
</body>
</html>