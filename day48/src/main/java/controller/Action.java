package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//메서드 바디가 없는것이 특징;
public interface Action { //Action류는 
	ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException; 

	
	
}
