package test;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncFilter
 */
//@를 어노테이션 annotation이라고 부름
@WebFilter("*.jsp")
public class EncFilter extends HttpFilter implements Filter {
       
	private String encoding; //멤버변수 초기화 해야됨
	
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncFilter() { //기본 생성자 필수
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// 필터가 메모리에서 해제될때 자동 호출
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 인코딩 처리 로직 (보통 chain.doFilter위에 넣음)
		//request.setCharacterEncoding("UTF-8");//"UTF-8"이 하드코딩 되어있음 : 유지보수 불리함
		// --->> 상수화 
		request.setCharacterEncoding(this.encoding);
		// --->> 설정파일을 생성해서 해당 파일의 내용을 로드(불러와서) 사용 WEB-INF하위에 XML파일 
		//			: JAVA를 재작성하게되면 컴파일을 다시 해야 됩니다.
		//			: 라는건 서버거 최소 1초이상 정지 되어야 한다는거임 == 사용자가 그 시간동안 이용을 못한다
		// 			: -->> 영업손실
		
		System.out.println("로그ㅠㅠㅠ");
		
		chain.doFilter(request, response); //== 이녀석이 바로 사용자의 요청
		//여기 안에 사용자의 요청 정보들이 모두 저장되어있음
		// 사용자의 요청정보를 보고, 무엇을 요청했는지를 찾아서 다음 페이지로 이동하기 때문에,
		//이동하기 전에 인코딩 처리 해야함
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 필터가 최초로 생성될때 자동 호출
		// '최초로 생성될때' 호출되기 때문에 단 1번 호출됨
		//this.encoding="UTF-8"; //멤버변수 초기화
		//멤버변수 초기화는 생성자의 역할인데 왜 init에서 합니까?
			// Not POJO의 초기화는 init에서 합니다
			// 생성자들이 이미 하는게 너무 많아; 일반적으로 Not POJO들은 생성자를 건들지 않음
			//그래도 그래야하는 이링 있기 때문에 init이 있는거임
		//↑이것도 하드코딩 아닌가요??
		
		this.encoding=fConfig.getServletContext().getInitParameter("encoding");
		System.out.println("로그 init 동작");
	}	

}
