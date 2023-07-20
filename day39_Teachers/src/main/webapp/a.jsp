<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String name=(String)session.getAttribute("name");
	%>

	<div id="header">
		<%
			if(name == null){
		%>
		<form action="b.jsp" method="post">
			<input type="text" name="mid" placeholder="아이디">
			<input type="password" name="mpw" placeholder="비밀번호">
			<input type="submit" value="로그인">
		</form>
		<%
			}
			else{
				out.println(name+"님, 환영합니다! :D   <a href='d.jsp'>로그아웃</a>");
			}
		%>		
	</div>
	
	<hr>
	
	<div id="wrap">
		<div class="content">
			<form action="c.jsp">
				<input type="hidden" name="writer" value="<%=name%>">
				<%
					if(name == null){
						out.println("<input size='30' type='text' name='msg' required disabled placeholder='글을 작성하려면 로그인하세요!'> <input type='submit' disabled value='글 작성하기'>");
					}
					else{
						out.println("<input size='30' type='text' name='msg' required placeholder='메세지'> <input type='submit' value='글 작성하기'>");
					}
				%>
				
			</form>
		</div>
		
		<hr>
		
		<div class="list">
			<%
				ArrayList<String> datas=(ArrayList<String>)application.getAttribute("datas");
				if(datas==null){
					out.println("<p>글이 아직 작성되지않았어요!</p>");
				}
				else{
					out.println("<ol>");
					for(String v:datas){
						out.println("<li>"+v+"</li>");
					}
					out.println("</ol>");
				}
			%>
		</div>
	</div>

</body>
</html>