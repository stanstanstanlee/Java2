package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDAO=new BoardDAO();
		ArrayList<BoardVO> datas=bDAO.selectAll(null);
		request.setAttribute("datas", datas);
	
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("main.jsp");
		return forward;
	}

}
