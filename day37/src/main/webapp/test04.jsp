<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% //스크립트릿 : 자바영역
	int result=0;
	
	//사용자가 전송한 데이터들은 request 객체에 저장됨
	//웹에서의 모든 데이터는 String값으로 반환 됩니다 
	//별도의 선언없이 사용가능한 객체들이 여러개있는데,
	//이것들을 "내장객체"라고 함
	//맨 처음 화면을 로드하는 모든 요청은 GET 그래서 POST로 바꿔서 작업을 진행 
if(request.getMethod().equals("POST")) { //만약 POST요청이 들어왔다면
	int num1= Integer.parseInt(request.getParameter("num1")); //그거 나줘
	String op=request.getParameter("op");
	int num2=Integer.parseInt(request.getParameter("num2"));
	
	if(op.equals("+")) {
		result=num1+num2;
	}
	else if(op.equals("-")) {
		result=num1-num2;
	}
}
	//만약에 op가 _라면
	// num1과 num2를 더해서
	// result에 대입해
	//만약 op가 - 라면
	// num1 - num2해서 result로 대입해
%>

	<!-- form의 필수 요소인 action 적지 않으면 나에게 전송 해줘 라는 뜻 -->
	<form method="post">

		<!-- 태그는 뷰단의 역할; 사용자에게 입력값 강제 -->
		<input type="number" name="num1">
		<!-- 연산자만 쓸때 트롤 방지법: input 말고 select를 쓰자; 사용자 편의성 상향 -->
		<select name="op">
			<option>+</option>
			<option>-</option>
		</select> <input type="number" name="num2">
		<!-- 사용자가 submit을 통해 데이터를 보낼 수 있는데 num1, op, num2이렇게 3개 보낼수 있음 -->
		<input type="submit" value="결과확인">

	</form>

	<hr>
	<!-- 계산결과에 자바영역을 만들어둠 -->
	<!-- result가 결과값을 의미함; 왜 빨간줄 뜰까용? 변수가 선언이 안되서 그러는겁니당 -->
	계산결과 :
	<%= result %>

</body>
</html>