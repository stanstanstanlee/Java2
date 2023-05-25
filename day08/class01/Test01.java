package class01;

import java.util.Scanner;

class Product{
	// 1. 멤버변수
	int num; // PK
	String name;
	int cnt;
	int price;

	// 3. 생성자
	Product(int num,String name,int price){
		this.num=num;
		this.name=name;
		this.cnt=5; // 재고의 디폴트값은 5
		this.price=price;
		System.out.println(this.name+" 생성완료!");
	}

	// 2. 메서드
	//  1) 기능파악
	// : 사용자가 3개구매할건데, 구매가능?
	// : 가능하다면 재고 마이너스
	// : 총 가격안내
	// : 불가능하다면 구매실패
	//  2) 메서드 시그니처 파악
	// : INPUT -> int 구매할상품의개수
	// : OUTPUT -> int 총가격, boolean
	//          => int 총가격(구매실패시 0원)
	//  3) 기능구현
	int sell(int cnt) {
		int sum=0;
		if(this.cnt>=cnt) {
			this.cnt-=cnt;
			sum=cnt*this.price;
			System.out.println("총 금액은 "+sum+"원 입니다.");
		}
		else {
			System.out.println(this.name+" 재고가 부족합니다.");
		}
		return sum;
	}
	// 1) 관리자가 ㅁㅁㅁ원으로 가격을 변경
	//    변경되었습니다!
	// 2) INPUT -> int 가격
	//    OUTPUT -> void
	// 3) 
	void setPrice(int price) { // 멤버변수(인스턴스변수)의 값을 새로 정의하는 것 == setter
		this.price=price;
		System.out.println(this.name+" 가격변경완료!");
	}
	void printInfo() {
		System.out.println(this.name+" ["+this.cnt+"] "+this.price+"원");
	}
}

public class Test01 {
	public static void main(String[] args) {
		// ※ main()에서 객체의 멤버변수에 직접적으로 접근 xxxxx

		Product[] data=new Product[3];
		// 현재 상품배열 data[]에 저장된 상품의 개수는 0개!
		// data[]의 크기 == 3
		int index=0; // 상품배열에 저장되어있는 상품의 개수

		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("=== 자판기 ===");
			System.out.println("1. 메뉴추가");
			System.out.println("2. 메뉴출력");
			System.out.println("3. 메뉴구매");
			System.out.println("4. 가격변경");
			System.out.println("5. 프로그램종료");
			System.out.println("===============");
			System.out.print("입력) ");
			int action=sc.nextInt();

			if(action==5) {
				System.out.println("프로그램종료...");
				break;
			}
			else if(action==1) { // C
				// 상품 객체를 생성해서,
				System.out.println("생성할 상품의 이름입력");
				System.out.print("입력) ");
				String name=sc.next();
				System.out.println("생성할 상품의 가격입력");
				System.out.print("입력) ");
				int price=sc.nextInt();
				
				// 상품 객체 배열에 저장해줘~
				data[index++]=new Product(index,name,price);
			}
			else if(action==2) { // R
				// 상품배열에 저장되어있는 상품만큼 화면에 출력해줘~
				for(int i=0;i<index;i++) { // 상품배열에 저장되어있는 상품의 개수
					///// System.out.println((i+1)+". "+data[i].name+" ["+data[i].cnt+"] "+data[i].price+"원");
					///// 안정성(보안)의 문제로, 이렇게 코딩 xxxxx
					System.out.print((i+1)+". ");
					data[i].printInfo();
				}
			}
			else if(action==3) { // U
				// 사용자가 구매할상품번호입력
				// 해당상품구매를 진행
				System.out.println("구매할 상품의 번호입력");
				System.out.print("입력) ");
				int num=sc.nextInt();
				System.out.println("구매할 상품의 개수입력");
				System.out.print("입력) ");
				int cnt=sc.nextInt();
				data[num-1].sell(cnt);
			}
			else if(action==4) { // U
				System.out.println("가격변경할 상품의 번호입력");
				System.out.print("입력) ");
				int num=sc.nextInt();
				System.out.println("상품의 가격입력");
				System.out.print("입력) ");
				int price=sc.nextInt();
				data[num-1].setPrice(price);
			}
			else { // 유효성 검사(사용자의 입력값 검사)
				System.out.println("잘못된 번호입니다! 확인후 다시이용해주세요!");
			}
		}
















	}
}
