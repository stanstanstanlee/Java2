package class01;

import java.util.Random;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		// 1. 상품 4개 이름 입력 
		// 	  배열로 지정
		// 2. 가격, 재고 랜덤으로 설정 
		// 	 2-1. 가격 배열 랜덤, 
		//	 2-2. 재고 배열 랜덤으로 지정
		// 3. 1) 구매하기 2) 종료하기
		//	 3-1. 2) 종료하기
		//   3-2. 1) 메뉴를 재고와 함께 출력
		//   3-3. 1) 제고가 없는 상품은 출력하지 않음
		// 4. 몇개 구매?
		// 5. 가격안내
		// 6. 현금입력 -> 거스름돈 반환
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		//1. 상품 메뉴이름 개수
		int N=4; // 메뉴의 개수
		String[] mName=new String[N]; // 메뉴이름 배열
		mName[0]="아메리카노";
		mName[1]="카페라떼";
		mName[2]="아이스티";
		mName[3]="버블티";
		
		//2-1. 가격 배열 랜덤
		int[] mPrice = new int[N];
		for(int i=0; i<mPrice.length;i++) {
			mPrice[i] = (rand.nextInt(30)+25)*100;
//			System.out.print(mName[i]+" 가격 : "+mPrice[i]+"; ");
		} 
		//		System.out.println();
		//2-2. 재고 배열 랜덤
		int[] mCnt = new int[N];
		for(int i=0; i<mCnt.length;i++) {
			mCnt[i] = rand.nextInt(10)+1;
			//			System.out.print(mName[i]+" 재고 : "+mCnt[i]+"; ");
		}
		while(true) {
			// 프로그램 시작
			System.out.println("1. 메뉴보기 2. 종료");
			System.out.println("입력하세요 : ");
			int action = sc.nextInt();

			if(action == 2) {
				System.out.println("종료합니다.");
				break;
			}
			else if(action<1 || action >2) { //선택지 1도 2도 아니라면
				System.out.println("잘못된 입력값입니다.");
				System.out.println("확인후 다시 이용해주세요!~~");
				System.out.println();
				continue;
			}
			// 구매하기 메뉴 + 재고 출력
			int num = 0;
			while(true) {
				System.out.println("======메뉴판======");
				for(int i=0;i<mName.length;i++) {
					System.out.print((i+1)+"-"+mName[i]);
					if(mCnt[i]> 0) {
						System.out.print("["+mCnt[i]+"] ");
					}else {
						System.out.print("["+"재고없음"+"] ");
					}
				}
				System.out.println();
				System.out.println("=================");

				// 입력시 -> 몇개구매?
				System.out.print("구매할 상품의 번호를 입력: ");
				num=sc.nextInt();
				
				if(1<=num && num<=N) { // 종료조건 : 제대로 입력했다면
					if(mCnt[num-1]==0) { // 재고가 없다면
						System.out.println("재고가없어서 구매가 불가능합니다!");
						continue;
					}
					break;
				} 
				// 1~4가 아닐경우
				System.out.println("없는 상품번호입니다!");
				System.out.println("다시 입력하세요!~~");
				System.out.println();
				
			}
			//재고관리
			int cnt=0; 
			
			while(true) { // 유효성 검사 : 구매할 개수가 음수이거나, 재고보다 많으면 안됨!
				System.out.println("선택한 상품은 "+mName[num-1]+"입니다.");
			
				System.out.println("가격: "+mPrice[num-1]+"원  재고: "+mCnt[num-1]+"개");
				System.out.print("구매할 개수를 입력: ");
				System.out.println();
				cnt=sc.nextInt();

			
				
				if(0<=cnt && cnt<=mCnt[num-1]) {
					break;
				}

				System.out.println("남아있는 재고와 부합한 개수가 아닙니다");
				System.out.println("다시 입력해주세요!~~");
				System.out.println();
			}
			//결제
			int res=mPrice[num-1]*cnt;
			int money;
			System.out.println("금액: "+res+"원");
			while(true) {
				System.out.print("돈 입력: ");
				money=sc.nextInt();
				if(res<=money) {
					break;
				}
				System.out.println("잘못된 입력입니다!");
				System.out.println("새로 입력해주세요!");
				System.out.println();
			}

			res=money-res;
			if(res!=0) {
				System.out.println("거스름돈 "+res+"원 반환 완료!");
			}
			System.out.println("구매 성공!");
			System.out.println();

			mCnt[num-1]-=cnt; 

		}
	}
}
