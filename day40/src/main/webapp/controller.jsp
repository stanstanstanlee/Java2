<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%
	ArrayList<BoardVO> datas=bDAO.SelectAll(null);
	request.setAttribute("datas",datas);
	//response.sendRedirect("b_main.jsp"); //sendRedirect는 버리고감

%>

<jsp:forward page=b_main></jsp:forward>