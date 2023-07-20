package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class DeleteBoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward = null;//delete가 안될 수도 있어 

		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		//모델씨 뭐 필요해요? 뷰한테 num주세요 
		bVO.setNum(Integer.parseInt(request.getParameter("num")));
		
		boolean flag=bDAO.delete(bVO);

		if(flag){ //성공했을때만 main으로 감
			forward=new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);//전달할건 없음
		}

		return forward;
	}

}
