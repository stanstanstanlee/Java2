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
		
		
		
		
		
		MovieVO mVO=new MovieVO(0,"",null);
		ArrayList<MovieVO> mdatas2=mDAO.selectAll(mVO);
		view.printMovieList(mdatas2);
		
		
		
		int num1=view.getNum();
		MovieVO mVO1=new MovieVO(num1,null,null);
		MovieVO mdata1=mDAO.selectOne(mVO1);
		view.printMovie(mdata1);
		
		
		
		int num2=view.getNum();
		MovieVO mVO2=new MovieVO(num2,null,null);
		boolean flag2=mDAO.delete(mVO2);
		if(flag2) {
			view.printTrue();
		}
		else {
			view.printFalse();
		}
		
		int num3=view.getNum();
		String name3=view.getName();
		MovieVO mVO3=new MovieVO(num3,name3,null);
		boolean flag3=mDAO.update(mVO3);
		if(flag3) {
			view.printTrue();
		}
		else {
			view.printFalse();
		}
		
		
		
		String name4=view.getName();
		MovieVO mVO4=new MovieVO(0,name4,null);
		ArrayList<MovieVO> mdatas4=mDAO.selectAll(mVO4);
		view.printMovieList(mdatas4);
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
