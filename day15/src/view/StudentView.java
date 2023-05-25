package view;
// MVC주에서 V를 담당하는 클래스로,
// main()을 동작시키는것이 목표가아님!
// main 만들지 않습니다

import java.util.ArrayList;
import java.util.Scanner;
import model.StudentVO;

public class StudentView {
	private static Scanner sc = new Scanner(System.in);
	private static final int maxMenuNum=3; //<<static 멤버변수에서 초기화 할 수 있는건 static 객체와 무관하게
	//높은 응집도를 가진 코드를 구현하기위함!
	
	// 메뉴를 안내해주는 기능
	// 1. 학생목록 출력
	// 2. 학생검색
	// 3. 학생정보변경
	
	public void printMenu() {
		System.out.println("===학생부 프로그램===");
		System.out.println("1. 목록출력");
		System.out.println("2. 학생검색");
		System.out.println("3. 정보변경");
		System.out.println("4. 학생추가");
		System.out.println("5. 학생삭제");
		System.out.println("6. 프로그램종효");
		
	}
	// 사용자의 입력을 저장하는 기능
	// +유효성 검사
//		Scanner sc = new Scanner(System.in); //계속 만드네?

	public int getMenuNum() {
		while(true) {
			try {
				System.out.print("입력) ");
				int menuNum=sc.nextInt();

				if(1<=menuNum && menuNum<=maxMenuNum) {
					return menuNum;
				}
			}
			catch(Exception e) {
				sc.nextLine();
				System.out.println("정수로 입력해주세요!");
			}			
		}		
	}
	
	// 학생목록을 출력하는 기능
	// view는 학생목록 데이터를 가질수 없음; Model이 가지고 있음 ==>> 출력을 하려면 받아와야해요 
	public void printStudentList(ArrayList<StudentVO> datas) { //나는 학생목록데이터가 없어. 너가 줭
		System.out.println("===학생 목록 출력 ===");
		for(StudentVO v:datas) {
			System.out.println(v);
		}
	}
	
	// 검색한 학생의 정보를 출력하는 기능
	public void printStudent(StudentVO data) {
		System.out.println("===학생 출력===");
		System.out.println(data);
	}
	// 사용자가 입력한 번호를 저장하는 기능
//	Scanner sc = new Scanner(System.in); //계속 만드네?
	public int getStudentNum() {
		System.out.println("학생번호 입력 : ");
		int num=sc.nextInt();
		return num;
	}
	
	// 사용자가 입력한 점수를 저장하는 기능 
	public int getStudentScore() {
		System.out.println("학생점수 입력 : ");
		int score=sc.nextInt();
		return score;
	}
	
	// 변경완료를 안내해주는 기능 
	public void printInfo() {
		System.out.println("학생정보변경완료");
	}
	
	// 학생추가시 안내멘트
	public void printInfo_C_Start() {
		System.out.println("학생추가를 시작합니다.");
	}
	// 이름 입력받기
	public String getStudentName() {
		System.out.println("이름입력: ");
		String name = sc.next();
		return name;
	}
	// 학생추가완료를 안내해주는 기능
	public void printInfo_C_End() {
		System.out.println("학생추가완료!");
	}
	// 학생삭제시 안내멘트
	public void printInfo_D_Start() {
		System.out.println("학생삭제를 시작합니다.");
	}
	
	// 학생삭제완료를 안내해주는 기능 
	// 학생삭제시 안내멘트
	public void printInfo_D_End() {
		System.out.println("학생삭제완료!");
	}
	//프로그램 종료 안내해주는 기능 
	public void printEnd() {
		System.out.println("프로그램 종료 ....");
	}
	
	public void printFalse() {
		System.out.println("서비스실패..");
	}
	
}
