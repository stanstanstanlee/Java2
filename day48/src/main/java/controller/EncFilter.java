package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter({ "*.do", "*.jsp" })
public class EncFilter extends HttpFilter implements Filter {
    private String encoding;
 
    public EncFilter() {
        super();
    }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.encoding);
		response.setCharacterEncoding(this.encoding);
		System.out.println("로그 : ");
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		//내 멤버변수로 = cp를 받아와~
		this.encoding=fConfig.getServletContext().getInitParameter("encoding");
	}

}
