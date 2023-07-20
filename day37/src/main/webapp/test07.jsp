<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="cb" class="test.CalcBean"/> <!-- <<== 짝궁 태그 활용안해서 그냥 닫아버림 -->
<%-- jsp useBean이라는 액션태그(객체화를 담당하는태그) 를 활용하면 객체화를 할 수 있습니다 --%>
<%--
액션태그 == 객체화
CalcBean cb = new CalcBean(); 기본생성자를 사용해줭 
--%>
<%--
지금 상태 : 기본생성자로 이렇게 됨 
num1 = 0;
num2 = 0;
op = null;
result = 0;

setProperty를 해도 이 상태 유지 
그래서 아래에서 op가 null이면 에러 

그래서 CalBean 클래스에서 

	public void calculate() {
		if(this.op==null) {
			this.op="";
		}
		if(this.op.equals("+")) {
			this.result=this.num1+this.num2;
		}
		else if(this.op.equals("-")) {
			this.result=this.num1-this.num2;
		}
	}
이렇게 추가 해 줘야 함 
 --%>
<jsp:setProperty property="*" name="cb" />
<%-- cb라는 객체의 멤버변수 초기화

멤버변수가 4개에요 그래서 setter가 4번 호출 됩니다 자동으로
setter메서드를 전부 호출 하는 태그

객체의 멤버변수의 이름과 파라미터의 이름이 꼭 같아야 함
 	- 그러니 설계서 데로 변수명 생성 
 
 null값도 null값으로 초기화
 parseInt 자동으로 되고 타입도 알아서 자동으로 맞춰줌
 
 
 멤버변수를 초기화 할때에 name값을 보고 자동 호출 하기 때문에 반드시 이름 맞춰줘야 함
 자동 형변환 처리됨
 
 초기화를 안할때에는 그걸 고려해서 로직을 짠다
 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>태그랑 자바랑 코드 분리하기 유지보수용이</title>
</head>
<body>
	<% cb.calculate(); %>
	
	<form method="post">
		<input type="number" name="num1">
		<select name="op">
			<option>+</option>
			<option>-</option>
		</select> <input type="number" name="num2">
		<input type="submit" value="결과확인">
	</form>
	<hr>
	계산결과 : <jsp:getProperty property="result" name="cb" /> <br>
	<%= cb.getResult() %>
	


</body>
</html>