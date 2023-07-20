<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
<%
	String msg=request.getParameter("msg");
if(msg.isBlank()){
	out.println("<script>alert('내용을 입력해주세요!');history.go(-1);</script>");
}
else{
	String writer=request.getParameter("writer");
	msg=("["+writer+"님] ["+msg+"]");

	ArrayList<String> datas=(ArrayList<String>)application.getAttribute("datas");
	if(datas == null){
		datas=new ArrayList<String>();
		application.setAttribute("datas", datas);
	}
	datas.add(0, msg);
	
	response.sendRedirect("a.jsp");
}
%>