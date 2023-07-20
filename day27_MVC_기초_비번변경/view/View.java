package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.MemberVO;
import model.ProductVO;

public class View {
	private static Scanner sc=new Scanner(System.in);

	// 회원비번변경
	public String funcA(MemberVO mVO) {
		// A. 현재 로그인한 ____님,
		//    비번입력해보세요!~~ (확인절차)
		System.out.println(mVO.getMid()+"님 비번입력) ");
		String mpw=sc.next();
		return mpw;
	}
	public String funcB(String mpw) {
		// B. 비번불일치시, 실패
		//    비번일치시, 비번변경가능! << funcB()
		while(true) {
			System.out.print("변경할 비번입력) ");
			String newMpw=sc.next();
			if(!newMpw.equals(mpw)) {//기존비번과 새로운 비번이 같지 않다면
				return newMpw;//C에게 새로운 비번 반환
			}
		}
	}

	// 어떤기능이 가능한지 보여주기
	public int printMenu() {
		System.out.println("=== 메뉴 ===");
		System.out.println("1. 상품목록출력");
		System.out.println("2. 상품검색"); // 실습(이름,가격으로 검색하기)
		System.out.println("3. 상품구매");
		System.out.println("4. 회원가입");
		System.out.println("5. 로그인");
		System.out.println("6. 로그아웃");
		System.out.println("7. 회원비번변경"); // 실습
		System.out.println("8. 회원탈퇴");
		System.out.println("9. 프로그램 종료");
		System.out.print("입력) ");
		int action=sc.nextInt();
		return action;
	}

	// 상품목록출력
	public void printList(ArrayList<ProductVO> pdatas) {
		System.out.println("=== 목록출력 ===");
		if(pdatas.isEmpty()) {
			System.out.println("출력할 리스트 없음!");
			return;
		}
		for(ProductVO pdata:pdatas) {
			System.out.println(pdata);
		}
	}

	// 상품선택
	public int getNum() {
		System.out.print("상품번호입력) ");
		int num=sc.nextInt();
		return num;
	}
	public void printData(ProductVO pdata) {
		if(pdata==null) {
			System.out.println("출력할 데이터 없음!");
			return;
		}
		System.out.println(pdata);
	}

	public void printTrue() {
		System.out.println("성공!");
	}
	public void printFalse() {
		System.out.println("실패.....");
	}

	// 회원가입
	// 로그인
	public MemberVO signin() {
		System.out.print("아이디입력) ");
		String mid=sc.next();
		System.out.print("비밀번호입력) ");
		String mpw=sc.next();
		MemberVO mVO=new MemberVO(mid,mpw);
		return mVO;
	}
}
