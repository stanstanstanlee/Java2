package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.MemberVO;
import model.MusicVO;

public class ClientView {
	// 1. 멤버 변수
	private static Scanner sc = new Scanner(System.in);
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
				if(action < 0 ) {
					System.out.println("\n'0'이상의 숫자만 입력 가능합니다.");
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
	// 각각의 메뉴 출력은 해당하는 메뉴들 갯수만큼까지만 입력하게 하기 위해 output을 int로 반환.
	// 프로그램 메뉴 출력
	public int printMain() {
		System.out.println("\n=== 프로그램 ===");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("0. 프로그램 종료");
		System.out.println("============");
		return 2;
	}
	// 음악 메뉴 출력
	public int printMusic(MemberVO mVO) {
		System.out.println("\n["+mVO.getName()+"] 님");
		System.out.println("=== 멜 론 ===");
		System.out.println("1. 노래 목록");
		System.out.println("2. 플레이리스트");
		System.out.println("3. 최고 재생횟수");
		System.out.println("4. 노래 이름 검색");
		System.out.println("5. 노래 재생");
		System.out.println("6. 랜덤 재생");
		System.out.println("7. 마이 페이지");
		System.out.println("0. 로그아웃");
		System.out.println("============");
		return 7;
	}
	// 마이페이지 메뉴 출력	
	public int printMyPageMenu() {
		System.out.println("\n=== 마 이 페 이 지 ===");
		System.out.println("1. 이름 변경");
		System.out.println("2. 비밀번호 변경");
		System.out.println("0. 나가기");
		System.out.println("============");
		return 2;
	}
	// 실행 번호 입력
	public int getNum(int menu) {
		int retry=0;
		while(true) {
			if (retry != 0) {
				System.out.print("재");
			}else {
				System.out.print("번호 ");
			}
			int num = tryCatch();
			if (num > menu) { // 최대 메뉴갯수
				System.out.println("\n번호가 일치하지 않습니다.");
				retry++;
				continue;
			}
			return num;
		}
	}
	// 노래 번호 입력 (추가, 재생)	
	public int getMusicNum(int action) {
		int retry=0;
		while(true) {
			if (retry != 0) {
				System.out.print("재");
			}else {
				if (action == 2 || action == 4) {
					System.out.print("추가할");
				}else if (action == 5) {
					System.out.print("재생할");
				}
				System.out.print(" 노래 번호 ");
			}
			int num = tryCatch();
			if (num > 100) { // 최대 메뉴갯수
				System.out.println("\n번호가 일치하지 않습니다.");
				retry++;
				continue;
			}
			return num;
		}
	}

	// 나가기 문구
	public void exitNum() {
		System.out.println("\n[나가기 0번]");
	}
	// 나가기 완료
	public void exitNumEnd() {
		System.out.println("\n나가기 성공!");
	}
	// 프로그램 종료
	public void programEnd() {
		System.out.println("\n프로그램 종료!");
	}


	// 재생 완료(성공)
	public void playMusic(MusicVO vo) {
		System.out.println("\n["+vo.getArtist()+" - "+vo.getTitle()+"] 재생합니다.");
	}
	// 노래 이름 검색
	public String getSearchContent() {
		System.out.println("\n=== 노 래 검 색 ===");
		System.out.print("검색어 입력 : ");
		String name = sc.next();
		return name;
	}
	// 뮤직리스트 출력 ( 각 상황에 맞게 )
	public void printMusicList(ArrayList<MusicVO> mdatas,int action) {
		System.out.println();
		if(mdatas.isEmpty()) { // 사용자편의성고려(UI/UX)
			System.out.println("=== 노 래 없 음 ===");
			return;
		}
		if(action==1) {
			System.out.println("=== 노 래 목 록 ===");
		}
		else if(action==3) {
			System.out.println("=== 최 고 재 생 횟 수 ===");
		}
		else if(action==4) {
			System.out.println("=== 검 색 결 과 ===");
		}
		for(MusicVO data:mdatas) {
			System.out.println(data); // .toString()은 자동호출됩니다!
		}
		System.out.println("=================");
	}
	// === 플레이리스트 ======================================
	// 플레이리스트는 멤버vo 의 Pdatas 를 건드는거라 여기서 구현하기 어려워서 따로 뺐음.
	// 플리 출력 실패
	public void printPlayListEmpty () {
		System.out.println("\n=== 노 래 없 음 ===");
	}
	// 플리 출력 시작
	public void printPlayListStart () {
		System.out.println("\n=== 플 레 이 리 스 트 ===");
	}
	// 플리 출력 완료
	public void printPlayListEnd () {
		System.out.println("======================");
	}
	// 노래 한개 출력
	public void printMusicOne(MusicVO mdata) {

		System.out.println(mdata);
	}
	// 플리 추가할번호 문구
	public void isAddPlayList() {
		System.out.println("\n플레이리스트에 추가할 번호를 입력해주세요.");
	}
	// 플리 추가 실패 - 중복
	public void addPlayListFailDuplicate() {
		System.out.println("\n이미 플레이리스트에 저장되어 있습니다.");
	}
	// 플리 추가 실패 - 번호
	public void addPlayListFailNum() {
		System.out.println("\n검색결과에 없는 번호입니다.");
	}
	// 플리 추가 완료(성공)
	public void addPlayListTrue(MusicVO vo) {
		System.out.println("\n["+vo.getArtist()+" - "+vo.getTitle()+"] 추가합니다.");
	}
	// ====================================================

	// === 회원 가입 ========================================
	// 회원가입 입력
	public MemberVO signUp() {
		System.out.println("\n=== 회 원 가 입 ===");
		System.out.print("아이디 입력 : ");
		String mid=sc.next();
		System.out.print("비밀번호입력 : ");
		String mpw=sc.next();
		System.out.print("비밀번호확인 : ");
		String mpw2=sc.next();
		if(mpw.equals(mpw2)) {
			System.out.print("이름입력 : ");
			String name=sc.next();
			return new MemberVO(mid,mpw,name);
		}
		return null;
	}
	// 회원가입 완료(성공)
	public void signUpTrue() {
		System.out.println("\n회원가입 성공!");
	}
	// 회원가입 실패
	public void signUpFalse() {
		System.out.println("\n회원가입 실패...");
	}
	// ====================================================



	// === 마이페이지 ========================================
	// 비번 입력값
	public String getMpw() {
		System.out.println("\n=== 비 밀 번 호 확 인 ===");
		System.out.print("비밀번호 입력 : ");
		String mpw=sc.next();
		return mpw;
	}
	// 비밀번호 불일치
	public void getMpwFalse() {
		System.out.println("\n비밀번호 불일치...");
	}
	// 새 이름 설정
	public String getSetMname() {
		System.out.print("\n새 이름 입력 : ");
		String mpw=sc.next();
		return mpw;
	}
	// 새 이름 설정 완료(성공)
	public void printSetMnameTrue() {
		System.out.println("\n이름 변경 성공!");
	}
	// 새 이름 설정 실패
	public void printSetMnameFalse() {
		System.out.println("\n이름 변경 실패...");
	}
	// 새 비밀번호 설정
	public String getSetMpw() {
		System.out.print("\n새 비밀번호 입력 : ");
		String mpw=sc.next();
		return mpw;
	}
	// 새 비밀번호 설정 완료(성공)
	public void printSetMpwTrue() {
		System.out.println("\n비밀번호 변경 성공!");
	}
	// 새 비밀번호 설정 실패
	public void printSetMpwFalse() {
		System.out.println("\n비밀번호 변경 실패...");
	}
	// ====================================================


	// === 로그인 ===========================================
	// 로그인
	public MemberVO signIn() {
		System.out.println("\n=== 로 그 인 ===");
		System.out.print("아이디입력 : ");
		String mid=sc.next();
		System.out.print("비밀번호입력 : ");
		String mpw=sc.next();
		return new MemberVO(mid,mpw,null);
	}
	// 로그인 완료(성공)
	public void signInTrue() {
		System.out.println("\n로그인 성공!");
	}
	// 로그인 실패
	public void signInFalse() {
		System.out.println("\n로그인 실패...");
	}

	// 로그아웃
	public void logout() {
		System.out.println("\n=== 로 그 아 웃 ===");
	}
	// 음악 메뉴 종료
	public void printMusicEnd() {
		System.out.println("\n=== 멜 론 종 료 ===");
	}
	// ====================================================
}