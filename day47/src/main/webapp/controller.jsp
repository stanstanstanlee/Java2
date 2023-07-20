<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//내가 받은 액션값은 어느 내장객체에 있죠? request
/*
자바바껭 없는데 jsp에서 하니까 불편 --> 그럼 자바에서 작업해 보자 하는게 프레임워크의 1번
*/
	String action = request.getParameter("action");
	
	if(action.equals("main")){
	
	}
	else if(action.equals("board")){
		
	}
	else {
		/// 없는 파라미터
	}
	


%>