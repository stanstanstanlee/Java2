package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardSet;
import model.BoardSetDAO;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		/*
		//메인페이지에 데이터를 전달
		//Board테이블에 selectAll()을 해야 한다는거
		BoardDAO bDAO = new BoardDAO();
		bDAO.selectAll(null);
		
		if(flag) {
			forward = new ActionForward();
			forward.setPath(null);
			forward.setRedirect(false);
		}
		*/
		forward = new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		
		String count=request.getParameter("count");
		//null이 제일 앞에 있어야함. 이게 null이면 뒤에걸 할 수가 없음. 항상 null먼저
		if(count==null||count.isEmpty()||count.isBlank()||count.equals("")) {//브라우져가 어떤것을 쓸지 몰라서 모두 씀
			count="2";
		}
		
		int cnt = Integer.parseInt(count);
		
		BoardSetDAO bsDAO = new BoardSetDAO();
		ArrayList<BoardSet> datas=bsDAO.selectAll(null, cnt);
		request.setAttribute("datas", bsDAO); //BoardSet이 제네릭인 어레이리스트
		request.setAttribute("count", cnt);
		return forward;
	}

}
