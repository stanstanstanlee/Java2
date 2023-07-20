<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<jsp:useBean id="mDAO" class="model.MemberDAO" />
<jsp:useBean id="mVO" class="model.MemberVO" />
<jsp:setProperty property="*" name="mVO" />
<!-- D페이지 : 로그인 -->
<%-- 로그인 하고 다시 메인 화면으로 올 예정이기 때문에 서비스될 화면이 없음 
    										 내가 보여줘야 되는 화면이 없음
    --%>
<%
/*
	String mid=request.getParameter("mid"); //사용자가 넘겨준 아이디 값을 가져온다. 
											//내가 아까 어떤 이름으로 보냈더라? mid로 보냈었음
											// 로그인 하는 곳 form안의 input에 name이 mid로 적혀있는지 확인 
											//form action에 name = mid로 보냈었음
											
	session.setAttribute("mid", mid); //세션에 "mid"라는 이름으로 id를 저장 하는중
										//이 mid값 request.getParameter로 받아올 수 있음
										//그리고 세션에 mid를 세팅(저장)
	
//session.setAttribute("mid",String mid=request.getParameter("mid")); 이렇게 써도 됨 
	response.sendRedirect("a.jsp");//데이터 유지 안해줘도 되니까 Redirect를 씀 

//아이디를 가져가야 하는데 그걸 session에 저장 했기 때문에 별도로 가져가는건 없음
//가져가야 되는 데이터는 있지만 session에 이미 저장 했기 때문에 신경써야 될 데이터는 없음


mVO=mDAO.selectOne(mVO);
if(mVO == null){
	out.println("<script>alert('로그인 실패...');history.go(-1);</script>");
}
else{
	session.setAttribute("name", mVO.getName());
	
	response.sendRedirect("a.jsp");
}
*/


String mid=request.getParameter("mid");
String mpw=request.getParameter("mpw");

//이 mid와 이 mpw를 가지는 회원이 있니? 어떠한 데이터가 있니 없니를 따질때 selectOne을 씀 그걸 떠나서 로그인 로짓 자체가 selectOne이였었음
		//있으면 a.jsp로 가고 
		//없어도 가긴 할껀데 로그인실패라고 알려줘야 함

session.setAttribute("name",mid);






















%>