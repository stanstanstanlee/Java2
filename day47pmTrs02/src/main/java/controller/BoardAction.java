package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BoardDAO;
import model.BoardVO;

public class BoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null; 
		
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		bVO.setNum(Integer.parseInt(request.getParameter("num")));
		bVO=bDAO.selectOne(bVO);
		
		if(bVO!=null){
			request.setAttribute("data", bVO);
			
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("d_board.jsp");
		}
//		else { null인 상태로 그냥 감 
//			forward.setRedirect(true);
//		} 
		
		
		return forward; //없는 데이터를 보려고 한다던지 올바르지 못한 접근이나 실패했을때 
		//forward를 null인 상태로 보냄 
	}
}
