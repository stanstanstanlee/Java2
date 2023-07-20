package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardVO;
import model.MemberDAO;
import model.MemberVO;

public class UpdateMemberAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

ActionForward forward=null;
		
		MemberDAO mDAO=new MemberDAO();
		MemberVO mVO = new MemberVO();
		mVO.setMid(request.getParameter("mid")); 
		mVO.setMpw(request.getParameter("mpw"));
		mVO.setName(request.getParameter("naem"));
		boolean flag=mDAO.update(mVO);
		if(flag){
			forward = new ActionForward();
			forward.setPath("logout.do");
		}
		
		return forward;
	}

}
