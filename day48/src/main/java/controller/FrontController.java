package controller;
//아무것도 안해도 임포트 되어있다 == not pojo다
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("*.do")//listener나 필터도 가지고 있는거
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;//객체 직렬화
       
    public FrontController() {//기본생성자로 돌아가는거
        super();
    }
    
    
    //어떤 요청이든 doAction을 하는 형태 
    public void doAction(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	//1. client (브라우져 뷰) 에서 요청을 추출 합니다
    	//전체 URI에서 프로젝트 이름을 뺌
    	String uri=request.getRequestURI();
    	String cp=request.getContextPath();
    	String command=uri.substring(cp.length());//contextpath
    	System.out.println("FrontController 클래스 : doAction() 메서드 : command"+command); //뭘 볼건지
    	
    	//2. Action 클래스의 execute()메서드를 호출
    	ActionForward forward = null;
    	if(command.equals("/main.do")) { //추출한 요청의
    		forward=new MainAction().execute(request, response); //맞는 action.execute의 결과는 forward
    	}
    	else if(command.equals("/signup.do")) {
    		forward=new SignupAction().execute(request, response);
    	}
    	else if (command.equals("/login.do")) {
    		forward=new LoginAction().execute(request, response);
    	}
    	else if (command.equals("/logout.do")) {
    		forward=new LogoutAction().execute(request, response);
    	}
    	else if (command.equals("/insertBoard.do")) {
    		forward=new InsertBoardAction().execute(request, response);
    	}
    	//3. 사용자에게 응답. View로 이동
    	if(forward!=null) { //
    		if(forward.isRedirect()) {
    			//리다이렉트. 데이터 x
    			response.sendRedirect(forward.getPath());
    		}
    		else {
    			//포워드. 데이터 O
    			request.getRequestDispatcher(forward.getPath()).forward(request,response);
    		}
    	}
    	
    	else { //null이라면 뭐가 잘못됨. e.g. 없는 요청 혹은 DAO flag가 false
    		response.sendRedirect("goback.jsp");
    	}
    	
    }
    //get요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	//post요청
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

}
