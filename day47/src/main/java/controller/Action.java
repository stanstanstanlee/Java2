package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// 클래스와 유사한데
	// 클래스는 아니라서 "생성자"가 없음
	// 그럼 "객체화(인트선트화)"도 안됨
	// "메서드 오버라이딩 강제"하려고 존재하는 문법
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;// {
		//디폴트로 abstract키워드가 존재함. 그래서 바디가 없어야함.
	//}
	//public 또한 디폴트 설정임 
	
}
