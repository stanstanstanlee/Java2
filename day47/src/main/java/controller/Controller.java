package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
/*
사용자가 특정요청을 함
요청이 get일지 post일지 모름
아무튼 하면 doAction을 하게 만들었음
 */
@WebServlet("/Controller")
// 특정 Client(브라우저,사용자)의 요청에 대해 반응할수있음
//  : 필터, 리스너(애초에 서블릿을 상속받은 특수한 서블릿)에서 사용한 @
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L; //직렬화
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() { //웹에서는 기본생성자를 기본으로 활용하기 때문에 꼭 필요함!!
        super();
    }
    
    private void doAction(HttpServletRequest request, HttpServletResponse response) { //doGet, doPost인자와 동일하게
    	//뭘로 호출하던지 얘를 불려야 하니까
    	String action=request.getParameter("action");
    	if(action.equals("main")) {
    		
    	}
    	else if(action.equals("board")) {
    		
    	}
    	else {
    		//
    	}
    	/////////
    	// 3. 요청처리가 완료되면 사용자에게 응답하기 
    	//  : View로 이동
    	/////////
    	
    	ActionForward forward =null;
    	if(forward.isRedirect()){
    		response.sendRedirect(action);
  
    	}
    	else {//데이터를 보낼게 있니? 포워드 데이터를 같이 가져가야되는 상황이면 포워드; 안보내도 되는데 포워드 쓰면 느려짐 데이터가 무거워져서
    		//포워드;
    	}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET요청으로 오면 수행해 달라는거 a href
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식으로 요청이 오면 수행해 달라 form
		doAction(request,response);
	}

}
