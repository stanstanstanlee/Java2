package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class UpdateBoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward =null; //일단은 null로 해놓음; 실패할수도 성공할수도 있기 때문
		
		BoardDAO bDAO=new BoardDAO();
		BoardVO bVO=new BoardVO();
		//update를 하려면 타이틀, 컨텐트, number가 필요함 BoardDAO에 나와있음
		bVO.setContent(request.getParameter("content"));
		bVO.setNum(Integer.parseInt(request.getParameter("num")));
		bVO.setTitle(request.getParameter("title"));
		boolean flag=bDAO.update(bVO);
		if(flag){
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("board.do?num="+bVO.getNum());
		}
		
		return forward;
	}

}
