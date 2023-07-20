<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//<로그아웃>
	session.removeAttribute("name"); //세션지우기; 보통은 이걸로 씀
	response.sendRedirect("a.jsp"); //다시 a.jsp로 넘어가기; 다시 돌아감
	//forward안씀 : 유지할 데이터 없음; 무거움 데이터 유지 하는게 
%>