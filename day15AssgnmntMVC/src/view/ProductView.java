package view;

import java.util.ArrayList;
import java.util.Scanner;
/*
	public void printMenu() { // 사용자메뉴출력() 
		syso [사용자]
		1. 음료목록출력 R
		2. 음료구매 U
		3. 음료추가 C
		4. 음료삭제 D
		5. 프로그램종료
	}
 
유효성 : 품절이라고 나와야 함 ==>> toString 재정의 할때??

	등록된 상품이 없는 경우 ==>> model 에서??

	사용자가 입력한 상품이 없는 상품번호라면 ==>>model 에서??
 */

import model.ProductVO;

public class ProductView {
	// main()을 동작시키는것이 목표가아님!
	// main 만들지 않습니다
	//	[멤버변수]
	//		- 인스턴스변수 
	//			- 없음
	//		- 클래스변수
	private static Scanner sc = new Scanner(System.in);//- 스캐너 입력 받음 << 바로 초기화
	private static final int maxMenuNum = 5; //- [사용자]최대메뉴개수 << 바로 초기화

	//	[생성자]
	//	필요 없음 초기화 할거 없음

	//	[메서드]
	public void printMisInput() {
		System.out.println("정수로입력해주세요!");
	}
	
	public void printMenu() {
		System.out.println("===음료상품===\n"
				+ "1. 음료목록출력 \n"
				+ "2. 음료구매 \n"
				+ "3. 음료추가 \n"
				+ "4. 음료삭제 \n"
				+ "5. 프로그램종료");
	}
	
	public int getMenuNum() {  //기능 : 사용자모드에서 메뉴선택시 입력을 저장하는 기능
		while (true){
			try {
				System.out.println("입력 : ");
				int menuNum=sc.nextInt();
				if(menuNum <= maxMenuNum || menuNum>=1) { //사용자메뉴에 있는 번호만 입력
					return menuNum; //OUTPUT : int num(사용자가 선택할 메뉴 번호)
				}
			}
			catch(Exception e) {
				sc.nextLine();
				printMisInput();
			}
		}
	}
	//view는 상품목록 데이터를 가질수 없음; Model이 가지고 있음 ==>> 출력을 하려면 받아와야해요 
	public void printProductList(ArrayList<ProductVO> datas) { //기능 : 등록된 상품을 모두 출력 하는 기능 
		System.out.println("=====상품목록=====");
		for(ProductVO v : datas) {
			System.out.println(v);
		}
	}
	
	public int getNum() {//기능 : 사용자가 상품번호를 입력하면 저장 후 반환
		while(true) {
			try {
				System.out.println("상품번호 입력 : ");
				int num=sc.nextInt(); 
				return num; //상품번호반환
			}
			catch(Exception e) {
				sc.nextLine();
				printMisInput();
			}
		}
	}
	
	public int getCnt() {// 기능 : 사용자가 개수를 입력하면 저장 후 반환
		while(true) {
			try {
				System.out.println("개수입력 : ");
				int cnt = sc.nextInt();
				return cnt; //개수 반환
			}catch(Exception e) {
				sc.nextLine();
				printMisInput();
			}
		}
	}
	
	public int getPrice ( ) { //기능 : 사용자가 가격을 입력하면 저장 후 반환
		while(true) {
			try {
				System.out.println("가격입력 : ");
				int price = sc.nextInt();
				return price; // 가격 반환
			}catch(Exception e) {
				sc.nextLine();
				printMisInput();
			}
		}
		
	}
	public String getProductName() { //기능 : 사용자가 상품이름을 입력 하면 저장 후 반환
		// +유효성 검사 : 정말 그 이름이 맞는지 재확인?
		System.out.println("상품이름 입력 : ");
		String name=sc.next();
		return name; //상품이름 반환
	}
	
	//[멘트 메서드 ]
	public void printAddStart() {//기능 : 상품 추가시 안내멘트
		System.out.println("음료상품 추가를 시작합니다.");
	}
	public void printAddEnd() {//기능 : 상품 추가 완료시 안내멘트
		System.out.println("음료상품 추가완료.");
	}
	public void printDeleteStart() {//기능 : 상품 삭제 시작시 안내멘트
		System.out.println("음료상품 삭제를 시작합니다.");
	}
	public void printDeleteEnd() {//기능 : 상품 삭제 완료시 안내멘트
		System.out.println("음료상품 삭제완료.");
	}
	public void printPwrOff() {//기능 : 프로그램 종료시 안내멘트
		System.out.println("프로그램을 종료합니다.");
	}
	public void printPurchaseStart() {//기능 : 음료 구매 시작시 안내멘트
		System.out.println("어떤 음료를 구매 하시겠습니까.");
	}
	public void printPurchaseEnd() {//기능 : 음료 구매 종료시 안내멘트
		System.out.println("구매완료!");
	}
	
	public void printFalse() {//기능 : 상품번호 불일치 실패 안내 멘트
		System.out.println("서비스를 완료할 수 없습니다");
	}
}
