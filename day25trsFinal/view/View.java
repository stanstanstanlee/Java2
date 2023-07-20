package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.MovieVO;

public class View {

	private static Scanner sc=new Scanner(System.in);
	
	public String getName() {
		System.out.println("영화의 이름을 입력하세요.");
		System.out.print("입력) ");
		String name=sc.nextLine();
		return name;
	}
	public int getNum() {
		System.out.println("영화의 번호를 입력하세요.");
		System.out.print("입력) ");
		int num=sc.nextInt();
		sc.nextLine();
		return num;
	}
	public void printMovie(MovieVO mVO) {
		System.out.println("=== 영 화 정 보 ===");
		if(mVO==null) {
			System.out.println("없음!");
			return;
		}
		System.out.println(mVO);
	}
	
	public void printMenu() {
		System.out.println("영화 프로그램입니다.");
		System.out.println("샘플 데이터를 크롤링합니다...");
	}
	
	public void printTrue() {
		System.out.println("작업 성공!");
	}
	public void printFalse() {
		System.out.println("작업 실패.....");
	}
	
	public void printMovieList(ArrayList<MovieVO> mdatas) {
		System.out.println("=== 영 화 목 록 ===");
		if(mdatas.size()==0) {
			System.out.println("없음!");
			return;
		}
		for(MovieVO mdata:mdatas) {
			System.out.println(mdata);
		}
	}
	
}
