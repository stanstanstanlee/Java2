package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ActionDeleteThis {
	abstract public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
		//추상메서드는 메서드 바디가 없어요
		//추상메서드를 가지려면 추상클래스여야함
	
}
