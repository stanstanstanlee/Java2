package model;

import java.util.ArrayList;

public class MovieDAO {
	
	private ArrayList<MovieVO> datas;
//	private Crawling crawling = new Crawling();
	//[생성자]
	public MovieDAO() {
		//this.datas=crawling.sample();
		this.datas=Crawling.sample();
		// Crawling 클래스의 객체가 없는데, 이거 사용가능한가요?
		// sample()이라는 메서드를 '객체와 무관하게,' 클래스에서 바로 사용
	}
	
	public ArrayList<MovieVO> selectAll(MovieVO mVO){
		
		return datas;
		
	}
	public MovieVO selectOne(MovieVO mVO) {
		return null;
	}
	
	public boolean insert(MovieVO mVO) {
		return false;
	}
	public boolean update(MovieVO mVO) {
		return false;
	}
	public boolean delete(MovieVO mVO) {
		return false;
	}
}
