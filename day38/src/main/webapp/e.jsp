<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//<로그아웃>

	//session.setAttribute("mid", null); //mid를 비워줘
	//session.invalidate(); // 전부 지우기 removeAll임; mpw나 member나 다른것들 다 저장 했었어도 같이 드랍됨
	session.removeAttribute("name"); //세션지우기; 보통은 이걸로 씀
	
	session.removeAttribute("cart"); //장바구니 지우기
	
	response.sendRedirect("a.jsp"); //다시 a.jsp로 넘어가기; 다시 돌아감
	//forward안씀 : 유지할 데이터 없음; 무거움 데이터 유지 하는게 
%>