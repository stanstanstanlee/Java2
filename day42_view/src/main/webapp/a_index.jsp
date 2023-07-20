<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.sendRedirect("controller.jsp?action=main");
//이 시간부로 controller 없이는 메인 페이지로 이동이 불가능 하다
// datas가 없으니까 
%>