  <!-- 장바구니에 추가하는 로직 -->
<!-- 추가가 완료되면 '추가하였습니다'멘트 뜨고 다시 돌아갈거에용 -->
<!-- 여기도 역시 서비스 되는 화면이 없음 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ProductVO,java.util.ArrayList" %>
<jsp:useBean id="pDAO" class="model.ProductDAO" />
<!-- ProductDAO pDAO = new ProductDAO() 객체화 인스턴스화 -->
<jsp:useBean id="pVO" class="model.ProductVO" />
<!-- ProductVO pVO = new ProductVO() -->
<jsp:setProperty property="*" name="pVO" /> <!-- //value가 num으로 넘어옴 그래서 pVO그냥 인자로 줄 수 있음 -->
						  <!-- 자동으로 세팅 -->
<%--사용자가 넘겨주는 태그의 이름을 확인해야 한다 ==>> 그 이름과 같은 VO의 멤버변수가 세팅되기 때문에
==> 근대 뭐로 세팅이 되는가?
==> 이번에는 option 태그에서 값을 넘겨받는데
==> 스크립트는 객체를 넘길수 없습니다. (무조건 string)을 넘겨줌

<%
				ArrayList<ProductVO> datas=pDAO.selectAll(null);
				for(ProductVO v:datas){
					out.println("<option value='"+v.getNum()+"'>"+v+"</option>");
									//사용자가 선택한 v.getNum(가짜값)을 value(진짜값)로 넘겨줌 그래서 num이 value로 등록된다
				}
			%>
			
			 
==> 그래서 다른값을 넘겨줄건데 : v는 객체기 때문에 따로 num을 빼줄 필요가 있다
==> value에다가 num을 넣어서 보낸다. 

VO에 name에 적혀있는것과 같은것이 있어야 한다 

 --%>
<%--    pVO의 모든 setter를 호출하겠다.
   setter에 넣을 값을 request.getParameter()에서 자동으로 매핑해주겠다! 형변환까지 서비스~ --%>
<%	
	//========================================
	/*
	//상품을 받아와서,
	String product = request.getParameter("product"); output이 String이에요 그래서 overriding한거가 와요
	//name+" : " + price + "원" 이게 a.jsp에 있는 v에서 와요 
	
	//그걸 장바구니에 추가하고, 에 해당하는 '그걸' == ProductVO 객체 말하는거야; 그니까 String으로 오는애를 객체로 바꿔야되
	<! --  'ProductVO 객체==그걸' 이라는건 : 
	스트링으로 오는 애를 객체로 바꿔야 되 
	JAVA MVC프로젝트에서 했던거에용~~~
		== selectOne(PK)을 씁니다 (앞으로도 계속, 고정이에요 언어가바뀌어도 selectOne 써요) --!>
			PK를 뷰에서 받아오는게 유리한거에용 ==> 뷰님들아(V) PK로 주샘!이라고 이야기 할거임
	
			
			
	그르면 int num = Integer.parseInt(request.getParameter("num")); <<num이구용 
		헷갈리니까 이름 num으로 맞춤
		그리고 인제 String이 아니라 int이니까 parseInt. 그럼 인제 오는게 PK가 101같은 숫자가 와요
		그다음

			
		ProductVO pVO = new ProductVO();
		pVO.setNum(num);
		
		이 data는 product data일 거고 
		ProductVO data = pDAO.selectOne( pVO ); pVO객체를 줘서 
							
	
	//혹시 장바구니가 없으면 ? 만들어서 넣으면 됨
			
	//사용자한테 ㅁㅁ가 장바구니에 추가 되었습니다! 띄워주고
	//다시 메인으로 이동 
	*/
	//========================================

	//원래는 setPK() 이런거 해서 PK값을 객체에 넘겨줘야한다. 
	//jsp의 setProperty가 모든걸 다 설정 해 주니깡 
	//자동으로 setter를 사용한다. 
	
	//[재활용한거]
	/*
	Product pVO = pDAO.selectOne(pVO)
	*/
	
	//[재활용안한거]
			//data를 새로 만들어줌 
			//장바구니에 넣을수 있는 data
	ProductVO data = pDAO.selectOne( pVO ); //상품값 가져오기 //Product 객체 1개임
					//value가 num으로 setProperty의 pVO로 넘어옴 그래서 pVO그냥 인자로 줄 수 있음
	//pVO를 쓰려면객체가 필요함==> 객체화
			//근데 어디있는줄 모르니까 import=
	
	//int num = Integer.parseInt(request.getParameter("num")); // 강제 형변환을 한 다음에 
	//ProductVO pVO = new ProductVO(PK,"",0) //여기 넣어주고 이거를
	//ProductVO data = pDAO.selectOne( pVO ); 에 넣었음// 인제 다 생략 

	
	//new가 없으니까 여기서 장바구니를 만드는건 아님
	ArrayList<ProductVO> cart=(ArrayList<ProductVO>)session.getAttribute("cart");//"cart"는 변수명 같은건데 get하면 객체정보가 딸려옴
													//세션에서 가져와야함 반환 타입이 Object라 다운캐스팅을 해야함
													
	if(cart == null){//만약장바구니가 비어있다면
		//장바구니를 여기서 만드는거임
		cart=new ArrayList<ProductVO>(); //장바구니 객체를 새로 만들어서 대입해 
		session.setAttribute("cart",cart); //그리고 session에 'cart'라는 이름으로 ProductVO타입의 어레이리스트 객체를 저장해
				//set할때는 "변수명",그리고 객체에 대한정보  ==>> session에 저장
	}
	
	cart.add(data); //그걸 장바구니(카트)에 추가 
%>
<script>
		        //상품이름
	alert('<%=data.getName()%>이(가) 장바구니에 추가되었습니다! :D');
	location.href='a.jsp'; //a.jsp로 이동
</script>