package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=new ActionForward(); //반환을 2개 해야 하기 때문에 객체를 준비 해 놓음
		
		BoardDAO bDAO=new BoardDAO();
		ArrayList<BoardVO> datas=bDAO.selectAll(null);
		request.setAttribute("datas", datas);
		
		forward.setRedirect(false);
		forward.setPath("b_main.jsp");	//메인으로 가	
		return forward;
	}

}
