package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.ProductVO;

public class ClientView {
	// 1. 멤버 변수
	private static Scanner sc = new Scanner(System.in);
	private static String menu1 = "상품 목록출력";
	private static String menu2 = "상품 구매하기";
	private static String menu3 = "상품검색_이름";
	private static String menu4 = "상품검색_가격";
	private static String menu5 = "프로그램 종료";
	// 2. 메서드

	// try-catch
	public int tryCatch() {
		int retry=0; // 오류,유효성 검사 체크용
		while (true) {
			try {
				if(retry != 0) { // > 횟수가 다시 시작하는거니까
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
	// 프로그램 메뉴 출력
	public void printCMenu() {
		System.out.println("=== 자판기 ===");
		System.out.println("1. "+menu1);
		System.out.println("2. "+menu2);
		System.out.println("3. "+menu3);
		System.out.println("4. "+menu4);
		System.out.println("5. "+menu5);
		System.out.println("============");
	}
	// 실행 번호 입력
	public int getCNum() {
		int retry=0;
		while(true) {
			if (retry != 0) {
				System.out.print("재");
			}else {
				System.out.print("번호 ");
			}
			int num = tryCatch();
			if (num > 5 && num != 1234) { // 관리자 비번, 최대 메뉴갯수
				System.out.println("\n번호가 일치하지 않습니다.");
				retry++;
				continue;
			}
			return num;
		}
	}
	// 상품 번호 입력
	public int getCProdNum() {
		System.out.print("상품 번호 ");
		int num = tryCatch();
		return num;
	}
	// 상품 재고 입력
	public int getCProdCnt() {
		System.out.print("구매 갯수 ");
		int cnt = tryCatch();
		return cnt;
	}
	// 상품 금액 입력
	public int getCProdPrice() {
		System.out.print("금액 ");
		int price = tryCatch();
		return price;
	}
	// 대답 입력 >> client에서는 구매하기에서 사용
	public boolean getAns(ProductVO vo) {
		System.out.println(vo.getNum()+"번 상품 "+vo.getCnt()+"개 구매하시겠습니까?");
		System.out.println("1) Yes  2) No   ");
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
			System.out.print(menu1+" 실행");
		}else if (action==2) {
			System.out.print(menu2+" 실행");
		}else if (action==3) {
			System.out.print(menu3+" 실행");
		}else if (action==4) {
			System.out.print(menu4+" 실행");
		}else if (action==5) {
			System.out.print("\n"+menu5);
		}
		System.out.println("합니다.\n");
	}


	//1. 상품 목록 존재여부 확인
	public boolean printListStart(ArrayList<ProductVO> pdatas) {
		System.out.println();
		if (!pdatas.isEmpty()) { // 사용자 편의성 고려 (UI/UX)
			return true;
		}
		return false;
	}
	//1. 상품 목록 출력 완료
	public void printList(ArrayList<ProductVO> pdatas) {
			System.out.println("==== 상 품 목 록 ====");
			for (ProductVO data : pdatas) {
				System.out.println(data);
			}
			System.out.println("===================\n");
	}
	public void printListCart(ArrayList<ProductVO> pdatas) {
			System.out.println("==== 장 바 구 니 ====");
			for (ProductVO data : pdatas) {
				System.out.println(data);
			}
			System.out.println("===================\n");
	}
	//1. 상품 목록 출력 실패
	public void printListFail(int action) {
		System.out.print("※ ");
		if (action==1) {
			System.out.print("출력할 ");
		}else if (action==2) {
			System.out.print("구매할 ");
		}else if (action==3) {
			System.out.print("이름으로 검색할 ");
		}else if (action==4) {
			System.out.print("가격으로 검색할 ");
		}
		System.out.println("상품이 없습니다.\n");
	}

	//2. 상품 구매 하기 완료
	public void buyEnd() {
		System.out.println("상품 구매를 완료했습니다.");
		System.out.println();
	}

	//2. 상품 구매 하기 실패
	public void buyFail() {
		System.out.println();
		System.out.println("상품 구매를 실패했습니다.");
		System.out.println();
	}
	// 2-3-1. 상품 번호가 일치하지 않을때
	public void buyFailNum() {
		System.out.println();
		System.out.println("상품 번호가 일치하지 않습니다.");
		System.out.println();
	}

	// 2-3-2. 재고 부족
	public void buyFailCnt() {
		System.out.println();
		System.out.println("재고가 부족합니다.");
		System.out.println();

	}
	// 2-3-3. 상품 가격이 일치하지 않을때
	public void buyFailPrice() {
		System.out.println();
		System.out.println("상품 가격이 일치하지 않습니다.");
	}


	// 3. 상품검색_이름으로 찾기
	public String getSearchContent() {
		System.out.println("=== 이 름 으 로 검 색 ===");
		System.out.println("검색어 입력 : ");
		String name = sc.next();
		return name;
	}

	// 4. 상품검색_가격으로 찾기
	public ProductVO getSearchFilter() {
		System.out.println("=== 가 격 으 로 검 색 ===");
		System.out.print("최저가격 ");
		int minPrice = tryCatch();
		System.out.print("최고가격 ");
		int maxPrice = tryCatch();
		// 교환 알고리즘
		if(maxPrice < minPrice) {
			System.out.println();
			System.out.println("최저가격 "+maxPrice+"\n최고가격 "+minPrice+" 로 검색합니다.");
			int tmp= minPrice;
			minPrice = maxPrice;
			maxPrice = tmp;
		}
		ProductVO pVO=new ProductVO(0,"필터검색",minPrice,maxPrice);

		// searchCondition
		return pVO;
	}

}