package class04;

import java.util.Random;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {

		Random rand=new Random();
		Scanner sc = new Scanner(System.in);
		int num=0;

		int N=4; // 상품이 4개란 뜻
		String[] mName=new String[N]; // 메뉴이름 배열
		for(int i=0;i<mName.length;i++) {
			System.out.print((i+1)+"번 상품이름 입력: ");
			mName[i]=sc.nextLine(); // 문자열 입력
			System.out.println(mName[i]+" 상품 저장완료!");
			System.out.println();
		}
		
		int[] mPrice = new int[N];
		for(int i=0; i<mPrice.length;i++) {
			System.out.print(mName[i]+"의 가격입력: ");
			mPrice[i] = sc.nextInt();
		} 
		int[] mCnt = new int[N];
		for(int i=0; i<mCnt.length;i++) {
			System.out.print(mName[i]+"의 개수입력: ");
			mCnt[i] = sc.nextInt();
		}
		/*
		String[] mName=new String[N]; // 메뉴이름 배열
		mName[0]="아메리카노";
		mName[1]="카페라떼";
		mName[2]="아이스티";
		mName[3]="프라푸치노";

		int[] mPrice = new int[N];
		for(int i=0; i<mPrice.length;i++) {
			mPrice[i] = (rand.nextInt(6)+10)*100; // 1000~1500
			// 10~15 X 100 : 연산자 우선순위 이슈 체크!
		} 
		int[] mCnt = new int[N];
		for(int i=0; i<mCnt.length;i++) {
			mCnt[i] = rand.nextInt(4);//0~3
		}
		 */
		while(true) {
			System.out.println("1. 구매 2. 종료");
			System.out.println("입력)");
			int action=sc.nextInt();
			if(action==2) {
				System.out.println("프로그램 종료...");
				System.out.println();
				break;
			}
			else if(action<1 || 2<action) {
				System.out.println("유효하지않은 값입니다!");
				System.out.println("다시입력해주세요!");
				continue;
			}			///------------------------까지1,2,3,4 완료
			
			while(true) { //몇번이나 제대로 입력 안할지 모름 //무한루프 열었으면 무조건 종료조건부터
				System.out.println("===== 메뉴목록 ====");
				for(int i=0;i<mName.length;i++) {
					System.out.print((i+1)+". "+mName[i]+"[");
					if(mCnt[i]==0) {
						System.out.println("재고없음]");
					}
					else {
						System.out.println(mCnt[i]+"]");
					}
				}
				System.out.println("=================");
				System.out.println("번호입력) ");
				num=sc.nextInt();
				//				(1<=num && num<=N) && (mCnt[num-1]>0)
				if((1<=num && num<=N) && (mCnt[num-1]>0)) { //제대로 입력 했다면 //정상입력이란 일단 1~4사이이고, 재고도 있어야함!
					break;
				}
				if(num<1 || N<num) {
					System.out.println("없는 상품입니다!");
				}
				else if(mCnt[num-1]==0){
					System.out.println("재고가 없어서 구매가 불가능합니다!");
				}
			}
 
//			System.out.println("몇개?");
//			System.out.println("돈?");
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
			else { // 1~4가 아닐경우
				System.out.println("없는 상품번호입니다!");
				System.out.println("다시 입력하세요!~~");
				System.out.println();
			}
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

