<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!-- 화면에 보여줄 예정이 전혀 없음 html 필요 없음 -->
<%
//★★★★★★★★★★★
//장바구니, 로그인 유지 여부, 광고 띄우지않기 설정 등
//서버가 변경되어도 '브라우저가 유지되고있었다면 설정이 유지되어야하는 상태'에 있는 데이터들을
//"세션(session)"으로 관리!!!!
//일정 시간이 흐르면 연결이 해제됨
//★★★★★★★★★★★

request.setCharacterEncoding("UTF-8");

//session 내장객체야, 너가 가지고 있는 것 중에 장바구니 좀 줘라
//처음보는 메서드를 활용 할 떄에는 output을 확인 해 줘야 함
//output String 이니까 형변환
//session에는 오브젝트로 저장되어 있으니까 꺼내서 쓸때마다 다운캐스팅 해줘야 한다
//attribute는 session의 멤버변수
//Parameter는 단발성; 다른 페이지로 가면 바로 드랍됨 

ArrayList<String> datas = (ArrayList<String>)session.getAttribute("datas");
//세션이라는 객체의 멤버변수 attribute로 '"datas"'라는 이름의 String을 불러와
//datas라는 String타입의 어레이리스트(장바구니)를 선언하고 거기에 대입
//근데 session은 타입이 obj라서 ArrayList<String> 타입으로 다운캐스팅을 할거얌

String product=request.getParameter("product"); 
//String타입의 product라는 변수에 request라는 객체의 parameter라는 멤버변수로 String타입의 "product"를 불러와서 대입해
//"product"는 test10에 상품 <select name = "product">로 5개의 상품있어

if(datas==null){ //혹시 datas(장바구니)가 비어있어? 즉, 첫번째 상품이니?
		datas = new ArrayList<String>();
		//그럼 이전에 선언한 스트링타입 어레이리스트의 datas(장바구니)에 새로운 어레이리스트 객체를 생성해서 대입해 
		
		session.setAttribute("datas",datas); //[장바구니를 session에 저장 하는거임]
		//그리고 세션이라는 객체의 멤버변수 attribute를 "datas"라는 이름의 식별자(key)로 참조할 수 있게 지정하고 
		//datas라는 이름으로 ArrayList<String>객체를 session에 저장해
}	
datas.add(product);//그리고 datas라는 스트링타입 어레이리스트에 위서에 불러온 product를 추가해 



//사용자가 product라는 이름의 파라미터를 전송할 예정
//전달받은 상품을 "장바구니"에 추가
//현재 한글 데이터 전송중 -> 인코딩 필수

// 장바구니를 맨 처음 만드는 경우에는 새로 new
// 기존 장바구니가 있는 경우에는 .add()

//서버가 바뀌더라도 브라우져가 유지 되고 있었다면 장바구니도 유지가 되어야 함

//추가 완료되면 다시 test10.jsp로 이동

%>

<script>
	alert('<%=product%>이(가) 장바구니에 추가되었습니다! :D');
	history.go(-1); //현재에서 이전 페이지로 이동 js의 history 객체를 이용

</script>