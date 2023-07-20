package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class DeleteMemberAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=null;
		
		MemberDAO mDAO=new MemberDAO();
		MemberVO mVO = new MemberVO();
		HttpSession session = request.getSession();
		mVO.setMid((String)session.getAttribute("mid")); //mid는 세션에 있음; Obj다운캐스팅
		
		boolean flag=mDAO.delete(mVO);
		if(flag){
			forward = new ActionForward();
			forward.setPath("logout.do");
		}
		
	
		return forward;
	}

}
