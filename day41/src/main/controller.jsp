<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.BoardVO" %>
<jsp:useBean id="bDAO" class="model.BoardDAO" />
<jsp:useBean id="mDAO" class="model.MemberDAO" />
<jsp:useBean id="mVO" class="model.MemberVO" />
<jsp:setProperty property="*" name="mVO" />
<jsp:useBean id="bVO" class="model.BoardVO" />
<jsp:setProperty property="*" name="bVO" />
<%
	String action=request.getParameter("action");

	if(action.equals("main")){
		ArrayList<BoardVO> datas=bDAO.selectAll(null);
		request.setAttribute("datas", datas);
		request.getRequestDispatcher("b_main.jsp").forward(request, response);
	}
	else if(action.equals("board")){
		
		
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
			session.setAttribute("name", mVO.getName());
			response.sendRedirect("controller.jsp?action=main");
		}
	}
	else if(action.equals("logout")){
		session.removeAttribute("name");
		response.sendRedirect("controller.jsp?action=main");
	}
	else{
		out.println("<script>alert('action 파라미터의 값을 확인해주세요!');history.go(-1);</script>");
	}
%>