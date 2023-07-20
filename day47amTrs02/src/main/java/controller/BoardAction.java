package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDAO=new BoardDAO();
		BoardVO bVO=new BoardVO();
		bVO=bDAO.selectOne(bVO);
		if(bVO!=null){
			request.setAttribute("data", bVO);
			
		}
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("board.jsp");
		return forward;
	}

}
