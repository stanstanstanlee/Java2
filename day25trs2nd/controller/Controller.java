package controller;

import java.util.ArrayList;

import model.MovieDAO;
import model.MovieVO;
import view.View;

public class Controller {

	private MovieDAO mDAO;
	private View view;
	public Controller() {
		mDAO=new MovieDAO();
		view=new View();
	}
	
	public void startApp() {
		/*
		view.printMenu();
		
		ArrayList<MovieVO> mdatas=Crawling.sample();
		// Q. 배열리스트를 받아오는데,
		// insert()를 그럼 1번하나요?
		// A. NO! insert()를 배열리스트.size()만큼 for문(반복) 돌립니다!
		for(int i=0;i<mdatas.size();i++) {
			MovieVO mdata=mdatas.get(i);
			boolean flag=mDAO.insert(mdata);
			if(!flag) {
				view.printFalse();
				return;
			}
		}
		
		view.printTrue();
		*/
		
		
		
		
		
		ArrayList<MovieVO> mdatas2=mDAO.selectAll(null);
		view.printMovieList(mdatas2);
		
		
		
		int num=view.getNum();
		MovieVO mVO=new MovieVO(num,null,null);
		MovieVO mdata=mDAO.selectOne(mVO);
		view.printMovie(mdata);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
