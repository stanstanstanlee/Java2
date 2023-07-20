<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.BoardVO" %>
    <% 
    request.setCharacterEncoding("UTF-8");
    %>
<jsp:useBean id="bDAO" class="model.BoardDAO" />
<jsp:useBean id="mDAO" class="model.MemberDAO" />
<jsp:useBean id="mVO" class="model.MemberVO" />
<jsp:setProperty property="*" name="mVO" />
<jsp:useBean id="bVO" class="model.BoardVO" />
<jsp:setProperty property="*" name="bVO" />
<%
	//실무에선 이렇게 쓰지 않음
	//String action="";
	//action = request.getParameter("action");
	
	
	String action = request.getParameter("action");

	System.out.println("로그 : controller.jsp : ");
	System.out.println("action: "+action);
	System.out.println("bVO: "+bVO);
	System.out.println("mVO: "+mVO);
	 
	if(action.equals("main")){ //전체출력
		ArrayList<BoardVO> datas=bDAO.selectAll(null);
		request.setAttribute("datas", datas);
		request.getRequestDispatcher("b_main.jsp").forward(request, response); //forward는 데이터 유지가 됨; jsp action 태그를 자바로 쓴 형태
	}
	else if(action.equals("board")){ //1개 출력
		bVO=bDAO.selectOne(bVO); //여기에 인자 bVO를 제대로 주려면 
		/*
		BoardDAO bDAO = new BoardDAO();  //bDAO.selectOne을 하려면 dao 객체 필요; useBean이 해줌
		
		bVO.setNum(request.getParameter(num)); // 게시글 selectOne 하려면 num이 필요함 : 
											"controller.jsp?action=board&num=<%=v.getNum()//이걸 main에서 받아오고 있어야 함 num		
		*/
		if(bVO!=null){
			request.setAttribute("data", bVO);
			request.getRequestDispatcher("d_board.jsp").forward(request, response);
		}
	}
	else if(action.equals("login")){
		mVO = mDAO.selectOne(mVO); // mVO에 mid, mpw가 setter에 의해 저장된 상태 
		if(mVO==null){
			out.println("<script>alert('로그인 실패...');history.go(-1);</script>");
		}
		else{
			session.setAttribute("mid", mVO.getMid());
			session.setAttribute("name", mVO.getName());
			response.sendRedirect("controller.jsp?action=main");
		}
	}
	else if(action.equals("logout")){//로그아웃
		session.removeAttribute("mid");//mid 빼기
		response.sendRedirect("controller.jsp?action=main"); //메인으로
	}
	
	else if(action.equals("signupPage")){ //회원가입 페이지로 가줘
		response.sendRedirect("e_signup.jsp"); //보낼 데이터 없음 response.sendRedirect를 씀 (포워드안씀)
	}
	
	else if(action.equals("signup")){ //회원가입 진행 해줘
		boolean flag=mDAO.insert(mVO);
		if(flag){
			out.println("<script>alert('회원가입 성공! 로그인후 이용하세요 :D');location.href='controller.jsp?action=main';</script>");//성공
//			response.sendRedirect("controller.jsp?action=main"); //우선실행되서 alert가 안뜸
			//out.println가 실행될 기회가 없음; script의 실행 주체는 자바가아니라 browser라서 script를 쓸 생각이 있으면 response를 쓰면 안됨
		}
		else{
			out.println("<script>alert('회원가입 실패...');history.go(-1);</script>");//실패
		}
		
		/*
		if(!mDAO.insert(mVO)){ //회원가입 실패면
			out.println("<script>alert('회원가입 실패...');history.go(-1);</script>");//실패
		}
		else { //회원가입성공
			out.println("<script>alert('회원가입 성공!');");//성공
			response.sendRedirect("controller.jsp?action=main"); //메인으로
		}
	*/
	}
	else if(action.equals("insertBoard")){ //게시글작성
		response.sendRedirect("c_insertBoard.jsp"); //c 페이지로 이동해서 게시글작성
	}
	else if(action.equals("saveBoard")){//게시글 저장
		boolean flag = bDAO.insert(bVO);//게시글 저장 진행
		if(flag){//성공
			out.println("<script>alert('글작성 성공!');location.href='controller.jsp?action=main';</script>");			
		}
		else {//실패
			out.println("<script>alert('글작성 실패...');history.go(-1);</script>");
		}
	}
	else if(action.equals("updateBoard")){//글 제목,내용 수정
		/*
		if(session.getAttribute("mid")!=null && session.getAttribute("mid").equals(bVO.getWriter())){ //만약 현재 로그인한 mid와 data의 Writer가 같다면
			boolean flag = bDAO.update(bVO);
				if(flag){ //성공
					out.println("<script>alert('글 수정 성공!');location.href='controller.jsp?action=main';</script>");
				}else { //실패
					out.println("<script>alert('글 수정 실패...');history.go(-1);</script>");
				}
		}
		else {//만약 현재 로그인한 회원의 mid와 data의 Writer가 다르면 
			out.println("<script>alert('본인이 작성한 글이 아닙니다');history.go(-1);</script>");
		}
		*/
		boolean flag = bDAO.update(bVO);//변경된 게시글 저장 진행
		if(flag){//성공
			out.println("<script>alert('글 수정 성공!');location.href='controller.jsp?action=main';</script>");			
		}
		else {//실패
			out.println("<script>alert('글 수정 실패...');history.go(-1);</script>");
		}
		
	}
	else if(action.equals("deleteBoard")){//게시글 삭제
		boolean flag = bDAO.delete(bVO);
		if(flag){//성공
			out.println("<script>alert('글 삭제 성공!');location.href='controller.jsp?action=main';</script>");			
		}
		else {//실패
			out.println("<script>alert('글 삭제 실패...');history.go(-1);</script>");
		}
	}
	else if(action.equals("mypage")){ //마이페이지로 이동
		mVO=mDAO.selectOne(mVO); //selectOne 하려면 비밀번호가 있어야함
		request.setAttribute("data", mVO);
		request.getRequestDispatcher("f_mypage.jsp").forward(request, response);
	}
	else if(action.equals("mypage2")){
		
	}
	else if(action.equals("updateMember")){//회원정보 업데이트 
		boolean flag = mDAO.update(mVO);
		if(flag){//성공
			session.removeAttribute("mid");
			out.println("<script>alert('회원정보 수정 성공! 로그인후 이용하세요 :D');location.href='controller.jsp?action=logout';</script>");
		}
		else {//실패
			out.println("<script>alert('회원정보 수정 실패...');history.go(-1);</script>");
		}
	}
	else if(action.equals("deleteMember")){//회원정보 삭제
		boolean flag = mDAO.delete(mVO);
		if(flag){//성공
			session.removeAttribute("mid");
			out.println("<script>alert('회원탈퇴 성공!');location.href='controller.jsp?action=logout';</script>");
		}
		else {//실패
			out.println("<script>alert('회원탈퇴 실패...');history.go(-1);</script>");
		}
	}
	else{ //url action에 이상한 값이 들어오면 막아주세요; 
		out.println("<script>alert('action 파라미터의 값을 확인해주세요!');history.go(-1);</script>");
	}
%>
















