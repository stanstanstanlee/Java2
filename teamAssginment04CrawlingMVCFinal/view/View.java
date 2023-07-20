package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.MemberVO;
import model.ShoppingVO;

public class View {
	private static Scanner sc = new Scanner(System.in);
	// 자주사용하는 문구출력 모듈화 
	// #1 Program  프로그램 실행문구
	// =====================================================================================================================
	private static String pMenu1 = "회원 가입";
	private static String pMenu2 = "회원 로그인";
	private static String pMenu3 = "프로그램 종료"; // 프로그램 종료
	// #2 Client  로그인한후 실행문구
	// =====================================================================================================================
	private static String cMenu1 = "목록출력";
	private static String cMenu2 = "상품검색";
	private static String cMenu3 = "상품구매";
	private static String cMenu4 = "회원 탈퇴"; // 이전 메뉴(#1)로 돌아감
	private static String cMenu5 = "회원정보 변경";
	private static String cMenu6 = "로그아웃"; // 이전 메뉴(#1)로 돌아감
	// #2-2 Search  검색시 실행문구
	// =====================================================================================================================
	private static String sMenu1 = "이름검색";
	private static String sMenu2 = "가격검색";
	private static String sMenu3 = "가장 인기있는 상품";
	private static String sMenu4 = "검색 메뉴 종료"; // 이전 메뉴(#2)로 돌아감
	// #2-5 Update  회원정보 변경시 문구
	// =====================================================================================================================
	private static String uMenu1 = "이름변경";
	private static String uMenu2 = "비밀번호 변경";
	private static String uMenu3 = "개인정보 출력";
	private static String uMenu4 = "회원정보 변경 종료"; // 이전 메뉴(#2)로 돌아감

	// 각 메뉴번호의 범위
	private static final int pMaxMenuNum = 3;   //프로그램 실행문구 메뉴 수
	private static final int cMaxMenuNum = 6;   //로그인한후 실행문구 메뉴 수 
	private static final int sMaxMenuNum = 4;   //검색시 실행문구 메뉴 수 
	private static final int uMaxMenuNum = 4;   //회원정보 메뉴변경시 문구 수 

	//자주 사용하는 메세지 
	private static final String TRUE = " 성공";
	private static final String FALSE = " 실패";
	private static final String START = " 실행";
	private static final String END = " 되었습니다."; // (종료)
	private static final String RE = "다시 입력해주세요.."+"\n입력) "; 

	// 성공
	// =====================================================================================================================

	public void pTrue(int pAction) {
		if (pAction == 1) {
			System.out.println("\n" + pMenu1 + TRUE); // 회원가입 성공
		} else if (pAction == 2) {
			System.out.println("\n" + pMenu2 + TRUE); // 로그인 성공
		}
	}

	public void cTrue(int cAction) {
		if (cAction == 3) {
			System.out.println("\n" + cMenu3 + TRUE); // 상품구매 성공
		} else if (cAction == 4) {
			System.out.println("\n" + cMenu4 + END); // 탈퇴 완료
		}
	}

	public void uTrue(int uAction) {
		if (uAction == 1) {
			System.out.println("\n" + uMenu1 + TRUE); // 이름변경 성공
		} else if (uAction == 2) {
			System.out.println("\n" + uMenu2 + TRUE); // 비밀번호 변경 성공
		}
	}

	// 실패
	// =====================================================================================================================
	public void pFalse(int pAction) {
		if (pAction == 1) {
			System.out.println("\n" + pMenu1 + FALSE); // 회원가입 실패
		} else if (pAction == 2) {
			System.out.println("\n" + pMenu2 + FALSE); // 회원 로그인 실패
		}
	}

	public void cFalse(int cAction) {
		if (cAction == 2) {
			System.out.println("\n" + cMenu2 + FALSE); // 상품 검색 실패
		} else if (cAction == 3) {
			System.out.println("\n" + cMenu3 + FALSE); // 상품 구매 실패
		} else if (cAction == 4) {
			System.out.println("\n" + cMenu4 + FALSE); // 회원 탈퇴 실패
		}
	}

	public void sFalse(int sAction) {
		if (sAction == 1) {
			System.out.println("\n" + sMenu1 + FALSE); // 이름검색 실패
		} else if (sAction == 2) {
			System.out.println("\n" + sMenu2 + FALSE); // 가격검색 실패
		}
	}

	public void uFalse(int uAction) {
		if (uAction == 1) {
			System.out.println("\n" + uMenu1 + FALSE); // 이름변경 실패
		} else if (uAction == 2) {
			System.out.println("\n" + uMenu2 + FALSE); // 비밀번호 변경 실패
		}
	}

	// 실행
	// =====================================================================================================================
	public void pStart(int pAction) { // 로그인메뉴
		if (pAction == 1) {
			System.out.println("\n" + pMenu1 + START); // 회원 가입 실행
		} else if (pAction == 2) {
			System.out.println("\n" + pMenu2 + START); // 회원 로그인 실행
		}
	}

	public void cStart(int cAction) { // 사용자메뉴
		if (cAction == 1) {
			System.out.println("\n" + cMenu1 + START); // 목록출력 실행
		} else if (cAction == 2) {
			System.out.println("\n" + cMenu2 + START); // 상품검색 실행
		} else if (cAction == 3) {
			System.out.println("\n" + cMenu3 + START); // 상품구매 실행
		} else if (cAction == 4) {
			System.out.println("\n" + cMenu4 + START); // 회원탈퇴 실행
		} else if (cAction == 5) {
			System.out.println("\n" + cMenu5 + START); // 회원정보 변경 실행
		}
	}

	public void sStart(int sAction) { // 검색메뉴
		if (sAction == 1) {
			System.out.println("\n" + sMenu1 + START); // 이름검색 실행
		} else if (sAction == 2) {
			System.out.println("\n" + sMenu2 + START); // 가격검색 실행
		}
	}

	public void uStart(int uAction) { // 회원정보변경 메뉴
		if (uAction == 1) {
			System.out.println("\n" + uMenu1 + START); // 이름변경 실행
		} else if (uAction == 2) {
			System.out.println("\n" + uMenu2 + START); // 비밀번호 변경 실행
		}
	}

	// 종료
	// =====================================================================================================================

	public void pEnd(int pAction) {
		if (pAction == 3) {
			System.out.println("\n" + pMenu3 + END); // 프로그램 종료 되었습니다.
		}
	}

	public void cEnd(int cAction) {
		if (cAction == 6) {
			System.out.println("\n" + cMenu6 + END); // 로그아웃 되었습니다.
		}
	}

	public void sEnd(int sAction) {
		if (sAction == 4) {
			System.out.println("\n" + sMenu4 + END); // 메뉴 종료 되었습니다.
		}
	}

	public void uEnd(int uAction) {
		if (uAction == 4) {
			System.out.println("\n" + uMenu4 + END); // 정보변경 종료 되었습니다.
		}
	}

	// 정수만 입력 받을수 있도록 유효성 검사
	public int tryCatch() {
		while (true) { // 정수 입력 받을때까지 실행
			try { // 정수로 입력했으면
				int action = sc.nextInt();
				if (action < 0) { // 0이하면 다시 입력
					System.out.println("0 이상만 입력해주세요..");
					System.out.print("입력) ");
					continue;
				}
				return action; // 정수 반환
			} catch (Exception e) { // 아닐경우 아래 출력문
				sc.nextLine();
				System.out.println("정수만 입력해주세요..");
				System.out.print("입력 ) ");

			}
		}
	}

	// 메뉴
	// =====================================================================================================================

	// 1.프로그램 메뉴
	public int printProgramMsg() {
		System.out.println();
		System.out.println("==== 프로그램 메뉴 ====");
		System.out.println("1. " + pMenu1); // 회원가입
		System.out.println("2. " + pMenu2); // 회원로그인
		System.out.println("3. " + pMenu3); // 프로그램 종료
		System.out.println("===================");
		System.out.print("번호 입력) ");
		while (true) {
			int pAction = tryCatch();
			if (pAction <= pMaxMenuNum && pAction >= 1) { // 1~배열의 길이까지만 입력
				return pAction;
			} else
				System.out.println(RE);

			continue;
		}
	}

	// 2.사용자 메뉴
	public int printClientMsg() {
		System.out.println();
		System.out.println("==== 사용자 메뉴 ====");
		System.out.println("1. " + cMenu1); // 목록출력
		System.out.println("2. " + cMenu2); // 상품검색 -> 3.검색 메뉴로 이동
		System.out.println("3. " + cMenu3); // 상품구매
		System.out.println("4. " + cMenu4); // 회원탈퇴 -> 성공 시 1.프로그램 메뉴로
		System.out.println("5. " + cMenu5); // 회원정보 변경 ->업데이트 메뉴로 이동
		System.out.println("6. " + cMenu6); // 메뉴종료 -> 1.프로그램 메뉴로 이동
		System.out.println("==================");
		System.out.print("번호 입력) ");
		while (true) {
			int cAction = tryCatch();
			if (cAction <= cMaxMenuNum && cAction >= 1) { // 1~배열의 길이까지만 입력
				return cAction;
			} else
				System.out.println(RE);
			continue;
		}
	}

	// 3.검색 메뉴
	public int printSearchMsg() {
		System.out.println();
		System.out.println("==== 검색 메뉴 ====");
		System.out.println("1. " + sMenu1); // 이름검색
		System.out.println("2. " + sMenu2); // 가격검색
		System.out.println("3. " + sMenu3); // 가장 인기있는 상품
		System.out.println("4. " + sMenu4); // 메뉴 종료 -> 이전 메뉴( 2.사용자 메뉴)로 이동
		System.out.println("================");
		System.out.print("번호 입력) ");
		while (true) {
			int sAction = tryCatch();
			if (sAction <= sMaxMenuNum && sAction >= 1) { // 1~배열의 길이까지만 입력
				return sAction;
			} else
				System.out.println(RE);
			continue;
		}
	}

	// 4.업데이트 메뉴
	public int printUpdateMsg() {
		System.out.println();
		System.out.println("=== 회원정보변경 메뉴 ===");
		System.out.println("1. " + uMenu1); // 이름변경
		System.out.println("2. " + uMenu2); // 비밀번호 변경
		System.out.println("3. " + uMenu3); // 회원정보 출력
		System.out.println("4. " + uMenu4); // 정보변경종료 -> 이전 메뉴( 2.사용자 메뉴)로 이동
		System.out.println("====================");
		System.out.print("번호 입력) ");
		while (true) {
			int uAction = tryCatch();
			if (uAction <= uMaxMenuNum && uAction >= 1) { // 1~배열의 길이까지만 입력
				return uAction;
			} else
				System.out.println(RE);
			continue;
		}
	}

	// 입력
	// =====================================================================================================================

	// 상품 번호 입력
	public int getNum() {
		System.out.print("상품번호 입력) ");
		while (true) { // 상품번호가 제대로 입력될때까지 반복
			int num = tryCatch(); // 정수만 통과
			
			
			return num;
		}
	}
	public void noItem() {
		System.out.println("해당 상품이 존재하지 않습니다.");
	}

	// 아이디 입력
	public String getID() {
		System.out.print("아이디 입력 ) ");
		String mid = sc.next();
		return mid;
	}

	// 패스워드입력
	public String getPassword() {
		System.out.print("비밀번호 입력 ) ");
		String mpw = sc.next();
		return mpw;
	}

	// 새로운 비밀번호 입력
	public String getNewPassword() {
		System.out.print("새로운 비밀번호 입력 ) ");
		String mpw = sc.next();
		return mpw;
	}

	// 이름 입력
	public String getName() {
		System.out.print("이름 입력 ) ");
		String mName = sc.next();
		return mName;
	}

	// 새로운 이름 입력
	public String getNewName() {
		System.out.print("새로운 이름 입력 ) ");
		String mName = sc.next();
		return mName;
	}

	// 가격으로 상품검색시 사용하기위해............★★가격입력 최저가와 최고가를 고객에게 입력 받아 전달★★굿!! 광원이형 짱!!
	public ShoppingVO getPrice() {
		System.out.print("최저가 입력 ) ");
		int minPrice = tryCatch();
		System.out.print("최고가 입력 ) ");
		int maxPrice = tryCatch();

		if (minPrice > maxPrice) {   //★★고객이 최저가 최고가를 바꿔서 입력 시 바꿔줌
			int tmpPrice = minPrice;//임시 저장변수 
			minPrice = maxPrice;
			maxPrice = tmpPrice;
		}
		ShoppingVO data = new ShoppingVO(0, "필터검색", minPrice, maxPrice);
		return data;
	}

	// 기능
	// =====================================================================================================================

	// 회원가입
	public MemberVO createMember() {
		System.out.println();
		System.out.print("아이디 입력 ) ");
		String mid = sc.next();
		System.out.print("비밀번호 입력 ) ");
		String mpw = sc.next();
		System.out.print("이름 입력 ) ");
		String mName = sc.next();

		return new MemberVO(mid, mpw, mName);
	}

	// 로그인
	public MemberVO login() {
		System.out.println();
		System.out.print("아이디 입력 ) ");
		String mid = sc.next();
		System.out.print("비밀번호 입력 ) ");
		String mpw = sc.next();
		return new MemberVO(mid, mpw, null);
	}


	// 상품 목록 출력
	public void printShoppingList(ArrayList<ShoppingVO> datas) { // 상품목록을 받아서
		if (datas.isEmpty()) {
			System.out.println("해당 상품이 없습니다.");
		}
		for (ShoppingVO v : datas) {
			System.out.println(v);
		}
	}

	// 상품 구매 출력
	public void printShopping(ShoppingVO data) { // 상품목록을 받아서
		System.out.println("구매하신 상품은 "); // 고객 확인용
		System.out.println(data.getName() + "의 가격은 :" + data.getPrice()+"원"); // 구매 품목의 이름과 가격만 출력
	}

	// 회원 정보 출력
	public void printMember(MemberVO mVO) {
		System.out.print("현재 로그인한 아이디는 :");
		System.out.println(mVO);
	}

	// 회원 비밀번호 변경
	public String pwUpdate(MemberVO mVO) {
		while (true) {
			System.out.print("비밀번호 입력 ) ");
			String mpw = sc.next();

			if (mVO.getMpw().equals(mpw)) {
				System.out.print("새로운 비밀번호 입력 ) ");
				String nMpw = sc.next();
				if (!nMpw.equals(mVO.getMpw())) {
					return nMpw;
				}
			} else {
				System.out.println(RE);
			}
		}
	}

	// 회원 이름 변경
	public String nameUpdate(MemberVO mVO) {
		while (true) {
			System.out.print("비밀번호 입력 ) ");
			String mpw = sc.next();

			if (mVO.getMpw().equals(mpw)) {
				System.out.print("새로운 이름 입력 ) ");
				String nMname = sc.next();
				
				if (!nMname.equals(mVO.getmName())) {
					return nMname;
				}
			} else {
				System.out.println(RE);
			}

		}
	}
}