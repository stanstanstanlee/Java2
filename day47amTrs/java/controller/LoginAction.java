package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDAO=new MemberDAO();
		MemberVO mVO=new MemberVO();
		mVO = mDAO.selectOne(mVO);
		if(mVO==null){
			out.println("<script>alert('로그인 실패...');history.go(-1);</script>");
		}
		else{
			session.setAttribute("mid", mVO.getMid());
			response.sendRedirect("controller.jsp?action=main");
		}
	}

}
