<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="test02.MemberVO,java.util.ArrayList" %>
<jsp:useBean id="mDAO" class="test02.MemberDAO" />
<jsp:useBean id="mVO" class="test02.MemberVO" />
<!-- 여기서 기본생성자 필요 -->

<jsp:setProperty property="*" name="mDAO" />
<jsp:setProperty property="*" name="mVO" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작화면</title>

</head>
<body>
<script type = "text/javascript">
<!-- onClick에 연결 안하고 script function으로 연결 해도 됨-->
	function signup() {
		ans=confirm('입력하신 정보로 회원가입을 할까요?')
		if(ans==true) {
			//회원가입진행
			document.test.action.value="singup";//form 태그 내부에있는 action의 값이 signup이 될수있게
			document.test.submit();//그 상태로 submit 진행
		}
		else {
			return;
		}
	}
//로그인 하듯이 똑같이 데이터를 진행하니까 회원가입 역시 submit처럼 진행 되야 하는 것
//어떤 버튼을 누르냐에 따라 어떤 액션을 할지를 알아야 함
</script>

		<!-- 1form 1submit이 원칙;  -->
	<form method="post" name="test"> <!-- form을 select할 수 있어야 하니 name필요 -->
		<!-- 사용자에게는 보이지않는 액션; 사용자는 존재를 모르지만 action이라는 값으로 로그인; 자주쓰는 기법 -->
		<input type="hidden" name="action" value="login">
		
		<input type="text" name="mid" placeholder="아이디" required> <br>
		<input type="password" name="mpw" placeholder="비밀번호" required>
		<br> <input id='login' type="submit" value="로그인">
		<input type="button" value="회원가입" onClick="signup()">
									<!-- button을 쓰는게 맞음. submit을 쓰면 form이 시작됨 -->
									
	</form>
<script type="text/javascript">
<%
if(request.getMethod().equals("POST")){//post 메서드로 요청이 들어왔니?
	//혹시 action 값이 login 이야??
	//사용자가 전송한 값
	if(request.getParameter("action").equals("login"))	{
	
	MemberVO data=mDAO.selectOne(mVO);
	if(data != null){ //혹시 로그인 성공했어?
		 out.println("alert('"+data.getMid()+"님, 로그인 성공!');");
		//ㅁㅁㅁ님 로그인 성공!
	}
	else {
		out.println("alert('로그인 실패!...');"); //로그인 실패!
	}
	}
	else if(request.getParameter("action").equals("signup")){ //혹시 action값이 회원가입이야?
		boolean flag=mDAO.insert(mVO);
		if(flag){
			out.println("alert('회원가입 성공!')");
		}
		else {
			out.println("alert('회원가입 실패...')");
		}
	}
}
%>

</script>
<h2>회원목록</h2>
<ul>
<%
	ArrayList<MemberVO> datas=mDAO.selectAll(null);
	for(MemberVO v:datas){
		// out.println("<li>"+v+"</li>");
%>
	<li><%=v%></li>
<%
	}
%>
</ul>

</body>
</html>