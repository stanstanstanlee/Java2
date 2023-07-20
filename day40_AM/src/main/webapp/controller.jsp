<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.BoardVO" %>
<jsp:useBean id="bDAO" class="model.BoardDAO" />
<%
	ArrayList<BoardVO> datas=bDAO.selectAll(null);
	request.setAttribute("datas", datas);
%>
<jsp:forward page="b_main.jsp" />