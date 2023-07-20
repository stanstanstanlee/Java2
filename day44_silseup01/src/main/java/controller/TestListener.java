package controller;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.BoardDAO;
import model.BoardVO;
import model.Crawling;

/**
 * Application Lifecycle Listener implementation class TestListener
 *
 */
@WebListener
public class TestListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {  //리스너 소멸 할때 할 행동
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {  //리스너 생성할때 할 행동
    	/*이 부분에서
    	크롤링해주세요~
    	그리고 DB에 넣어주세요! :D
    	*/
    	//DB에 클롤링한 데이터 밀어넣기
    	ArrayList<BoardVO> bdatas = Crawling.sample(); 
    	BoardDAO bDAO= new BoardDAO();
    	
    	//크롤링 해 온 것을 저장 해야함 bVO객체마다 한번씩
    	for(int i=0; i<bdatas.size(); i++) {
    		bdatas.get(i).setWriter("admin");
    		bDAO.insert(bdatas.get(i));
    	}
    	
    	
    	
    	//DB대용이였음, 인제 필요 없음
    	//application.setAttribute("datas",datas); application이 없잔하용
    	//인자로 sce가 있음; 이걸로 ServletContext를 뽑아와 보쟝
    	//ServletContext sc = sce.getServletContext(); //얘가 어플리케이션 역할을 하는구낭!
    	//sc.setAttribute("datas", datas);
    	//sc.setAttribute("data", bVO);
    	
    	
    	
    	System.out.println("로그: 리스너 수행완료!");
    }
	
}
