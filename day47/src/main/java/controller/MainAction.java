package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements Action { //MainAction을 수행할 예정이다
	public VO execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO bDAO=new BoardDAO();
		ArrayList<BoardVO> datas= bDAO.selectAll(null);
		request.setAttribute("datas",datas);
		//request.getRequestDispatcher("main.jsp").forward(request,response); 컨트롤러 서블릿에서 할거임
		// ctrl로 돌아갈 준비
		// 1. 리다이렉트? 포워드?
		// 2. 어디로 가야되니?
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("boad.jsp");
		return forward;
		
		
		
	}
}
