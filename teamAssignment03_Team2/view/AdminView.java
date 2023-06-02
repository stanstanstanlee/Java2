package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.ProductVO;

public class AdminView {
	// 1. 멤버 변수
	private static Scanner sc=new Scanner(System.in);
	private static String menu1 = "상품 추가하기";
	private static String menu2 = "상품 재고변경";
	private static String menu3 = "상품 삭제하기";
	private static String menu4 = "관리자 종료";

	// 2. 메서드

	//try-catch
	public int tryCatch() {
		int retry=0;
		while (true) {
			try {
				if(retry != 0) {
					System.out.print("재");
				}
				System.out.print("입력 : ");
				int action = sc.nextInt();
				if(action < 1 ) {
					System.out.println("\n'1'이상의 숫자만 입력 가능합니다.");
					retry++;
					continue;
				}
				return action;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("\n숫자만 입력 가능합니다.");
				retry++;
			}
		}
	}
	//관리자 메뉴 출력
	public void printAMenu() {
		System.out.println("=== 관리자 ===");
		System.out.println("1. "+menu1);
		System.out.println("2. "+menu2);
		System.out.println("3. "+menu3);
		System.out.println("4. "+menu4);
		System.out.println("============");
	}
	//실행 번호 입력
	public int getANum () {
		int retry=0;
		while(true) {
			if (retry != 0) {
				System.out.print("재");
			}else {
			System.out.print("번호 ");
			}
			int num = tryCatch();
			if (num > 4) { // 최대 메뉴갯수
				System.out.println("\n번호가 일치하지 않습니다.");
				retry++;
				continue;
			}
			return num;
		}
	}
	//상품 이름 입력
	public String getAProdName () {
		System.out.print("상품 이름 입력 : ");
		String name=sc.next();
		return name;
	}
	//상품 번호 입력
	public int getAProdNum () {
		System.out.print("상품 번호 ");
		int num=tryCatch();
		return num;
	}
	//상품 재고 입력
	public int getAProdCnt () {
		System.out.print("상품 재고 ");
		int cnt=tryCatch();
		return cnt;
	}
	//상품 추가 재고 입력
	public int getAProdAddCnt () {
		System.out.print("추가 재고 ");
		int cnt=tryCatch();
		return cnt;
	}
	//상품 금액 입력
	public int getAProdPrice () {
		System.out.print("상품 금액 ");
		int price=tryCatch();
		return price;
	}
	// 대답 입력 >> admin에서는 메뉴마다 사용
	public boolean getAns(ProductVO vo) {
		if (vo.getNum()==0) {
			System.out.println("\n"+vo.getName()+" 상품 추가하시겠습니까?");
			System.out.println("금액 : "+vo.getPrice()+"원, 재고 : "+vo.getCnt()+"개");
		}
		if (vo.getName()==null) {
			System.out.println("\n"+vo.getNum()+"번 상품 삭제하겠습니까?");
		}
		else if(vo.getName().equals("재고변경")) {
			System.out.println("\n"+vo.getNum()+"번 상품 "+vo.getCnt()+"개 추가하시겠습니까?");
		}
		System.out.println("1) Yes  2) No    ");
		System.out.print("번호 ");
		int ans = tryCatch();
		if( ans == 1) {
			return true;
		}else {
			return false;
		}
	}
	// 프로그램 실행문
	public void programStart(int action) {
		if (action==1) {
			System.out.print("\n"+menu1+" 실행");
		}else if (action==2) {
			System.out.print(menu2+" 실행");
		}else if (action==3) {
			System.out.print(menu3+" 실행");
		}else if (action==4) {
			System.out.print("\n"+menu4);
		}
		System.out.println("합니다.\n");
	}

	// 1.상품 목록 존재여부 확인
	public boolean printListStart(ArrayList<ProductVO> pdatas) {
		System.out.println();
		if (pdatas.isEmpty()) { // 비어있으면 false로 반환 >> 실패하는경우
			return false; // 이해하기 쉽게 false로 반환해야겠다 생각해서
		}
		else {
			return true; // 비어있지 않으면, true로 반환
		}
	}
	// 2.상품 목록 출력 완료
	public void printList(ArrayList<ProductVO> pdatas) {
		System.out.println("==== 상 품 목 록 ====");
		for (ProductVO data : pdatas) {
			System.out.println(data);
		}
		System.out.println("===================\n");
	}
	// 3.상품 목록 출력 실패
	public void printListFail(int action) {
		System.out.print("※ ");
		if (action==2) {
			System.out.print("변경할 ");
		}else if (action==3) {
			System.out.print("삭제할 ");
		}
		System.out.println("상품이 없습니다.\n");
	}

	//1. 상품 추가 완료
	public void insProdEnd () {
		System.out.println();
		System.out.println("상품 추가를 완료했습니다.\n");

	}
	//1. 상품 추가 실패
	public void insProdFail () {
		System.out.println();
		System.out.println("상품 추가에 실패했습니다.\n");
	}

	//2. 상품 재고 변경 완료
	public void setCntEnd () {
		System.out.println();
		System.out.println("상품 재고변경을 완료했습니다.\n");
	}
	//2. 상품 재고 변경 실패
	public void setCntFail() {
		System.out.println();
		System.out.println("상품 재고변경을 실패했습니다.\n");
	}
	public void setCntFailNum() {
		System.out.println();
		System.out.println("변경할 상품 번호가 일치하지 않습니다.\n");
	}

	//3. 상품 삭제 완료
	public void delProdEnd () {
		System.out.println();
		System.out.println("상품 삭제가 완료되었습니다.\n");
	}
	//3. 상품 삭제 실패
	public void delProdFail () {
		System.out.println();
		System.out.println("상품 삭제에 실패했습니다.\n");
	}
	public void delProdFailNum () {
		System.out.println();
		System.out.println("삭제할 상품 번호가 일치하지 않습니다.\n");
	}
}