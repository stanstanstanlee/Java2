package test;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

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
    	ArrayList<MemberVO> datas = new ArrayList<MemberVO>(); 
    	for(int i=0; i<5; i++) {
    		MemberVO data= new MemberVO();
    		data.setName("홍길동"+(i+1)); //5명의 홍길동 넣기 
    		data.setAge(i+1);
    		datas.add(data);
    	}
    	
    	datas.add(new MemberVO()); //무명인 2명 넣기
    	datas.add(new MemberVO());
    	
    	
    	MemberVO mVO = new MemberVO(); //그와 별개로 티모 넣기
    	mVO.setName("티모");
    	mVO.setAge(13);
    	
    	//application.setAttribute("datas",datas); application이 없잔하용
    	//인자로 sce가 있음; 이걸로 ServletContext를 뽑아와 보쟝
    	ServletContext sc = sce.getServletContext(); //얘가 어플리케이션 역할을 하는구낭!
    	sc.setAttribute("datas", datas);
    	sc.setAttribute("data", mVO);
    	
    	System.out.println("로그: 리스너 수행완료!");
    }
	
}
