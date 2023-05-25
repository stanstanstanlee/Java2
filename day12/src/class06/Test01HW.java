package class06;

import java.util.ArrayList;
import java.util.Scanner;

/*
//Product class 일반클래스 
§ 설계서 

상품 : PK,이름,가격,재고
 [멤버변수] 모두 프라이빗 ==>> getter, setter
 private int num //PK 학생번호
 private String name // 상품이름 
 private int price // 상품가격
 private int cnt // 재고 카운트 트래킹 해야 함; 각 상품마다 디폴트 재고 10개씩 

[생성자{}]         
 Product(num,name,price){ //num으로 학생번호 입력받을것임,name상품이름 입력받을것임,price상품가격 입력받을 것임 
 	this.num초기화
	this.name초기화
	this.price초기화	
	this.cnt초기화 = 10 //각 상품마다 디폴트 재고 10개씩 
 }

[메서드(){}]

 판매() 
	기능 :	메인에서 사용자가 몇개 구매할지를 입력받음. 
		재고와 비교해서 구매 가능 하다면 총 금액을 '반환' 해 줘야함.
		구매 한 만큼 재고 줄여줘야 함. 

	INPUT : int cnt
	OUTPUT : int totalPrice;

 재고변경() 메인에서 사용자에게 상품번호입력받은 후 
	기능 : 해당 상품번호의 새로운 재고를 입력받음. 새로운 재고로 다시 초기화
	INPUT : int cnt
	OUTPUT : 없음

[getter,setter]  private 멤버변수 접근 
num 
name 
price 
cnt 
-------------------------------------
[사용자 모드] - userMenu 
1. 상품목록출력 Read 
	- 재고없는상품은 [품절] 이라고 나와야 함
	- 상품추가가 안되어있으면 : 등록된 상품이 없습니다

2. 구매하기 Update 
	- 판매()함수 호출 
	- 돈받고 거스름돈?-->메인에서?메서드?

3. 프로그램종료 
	- 종료조건 break;

[관리자 모드] - 입력값 1234로 이동 
	- adminMenu

1. 상품추가 Create 메인에서 하는일
	- 상품 몇개생길지 알수없음, 배열길이 알수없음; 인덱스 필요함, 순서필요함; 
		- ArrayList<Product> 에 저장 

2. 상품재고변경 Update 
	- 재고변경()함수 호출 

3. 상품삭제 Delete 메인에서 하는일
	- .remove();로 메인에서 직접 삭제 // 학생번호도 영구 삭제 해야 함

4. 관리자모드종료 (사용자모드로 돌아감) 
 */
class Product {
	private int num; //PK 상품번호
	private String name; // 상품이름 
	private int price; // 상품가격
	private int cnt; // 재고 카운트 트래킹 해야 함; 각 상품마다 디폴트 재고 10개씩 
	//	[생성자{}]         
	Product(int num, String name, int price){ //num으로 학생번호 입력받을것임,name상품이름 입력받을것임,price상품가격 입력받을 것임 
		this.num=num;
		this.name=name;
		this.price=price;	
		this.cnt = 10; //각 상품마다 디폴트 재고 10개씩 
	}
	//	[메서드(){}]
	/*
	판매() 
	기능 :	메인에서 사용자가 몇개 구매할지를 입력받음. 
	재고와 '비교'해서 구매 가능 하다면 총 금액을 '반환' 해 줘야함.
	구매 한 만큼 재고 줄여줘야 함. 
	 */
	int sell(int cnt) { //INPUT : int 구매하겠다는 상품의 구매 요구 개수
		int totalPrc=0; //사용자가 결제할 총 금액;
		if(this.cnt>=cnt) {//만약 사용자가 구매 하겠다는 상품의 재고가 구매 하겠다는 사용자의 요구개수와 같거나 더 크다면
			totalPrc=cnt*this.price; //사용자가 결제해야 하는 총 금액은 요구 구매개수 * 구매 희망 상품의 개당 가격
			System.out.println("결제하실 총 금액은 :"+totalPrc+"원 입니다.");
		} 
		return totalPrc; //	OUTPUT : 사용자가 결제할 총 금액;
	}

//	재고변경() - 메인에서 사용자에게 상품번호입력받은 후 
//	기능 : 해당 상품번호의 새로운 재고를 입력받음. 새로운 재고로 다시 초기화
	void changeCnt(int cnt) { //INPUT : int cnt <<사용자가 변경희망 하는 새로운 재고숫자
		this.cnt=cnt;
		System.out.println("재고변경 완료."); //????어떤 상품의 재고가 어떠어떻게 바뀌었다 출력????
	} //	OUTPUT : 없음
	
	//[getter,setter]  private 멤버변수 접근 
	public int getNum() {
		return num; 
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
public class Test01HW {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //사용자에게 입력 받아야함
		// 제네릭 : 같은 Product Product 자료형만 취급 할 수 있음.  
		ArrayList<Product> data = new ArrayList<Product>();//생성된 상품들을 저장할 배열리스트
		// ArrayList는 index를 따로 둘 필요가 없음; list.size(); 함수로 접근하는 리스트의 크기가 저장된 개수랑 같음 
		int numPK=1001; // 프로그램이 부여 하는 방식 : 1001번부터 순서대로 부여; 우리는 사용자에게 입력 받지 않을것임;
		String userDsply = "======[자판기]======\n"
						  + "1. 상품목록출력 \n"//사용자모드 화면 선택창
						  + "2. 구매하기 \n"
						  + "3. 프로그램종료\n"
						  + "번호 입력 : ";
		String adminDsply ="======[관리자]=====\n" 
						  +	"1. 상품추가 \n" //관리자모드 화면 선택창
						  + "2. 상품재고변경 \n"
					      + "3. 상품삭제 \n"
						  + "4. 관리자모드종료\n"
						  + "번호 입력 : ";
		//프로그램 언제 종료 할지 알수 없음 ==>> while(true); 종료조건 : 사용자가 3번선택 프로그램종료
		while(true) {//전체 프로그램 while문의 시작
			System.out.println(userDsply);// 사용자 모드 
			int action = sc.nextInt();
			if(action == 3) {//사용자가 3을 입력 하면 프로그램종료\n
				System.out.println("프로그램을 종료합니다.");
				break;
			}//사용자가 1을 입력 하면 상품목록 출력
			else if(action == 1) {
				if(data.isEmpty()) { // 유효성 검사 - 상품추가가 안되어있으면 ==>> 등록된 상품이 없습니다
					System.out.println("저장된 학생이 없습니다!");
					continue;
				}
			}else if(action == 2) {//사용자가 2를 입력 하면 구매하기(판매함수)
				
				
			}else if(action == 1234) {//사용자가 1234를 입력하면 관리자모드로 전환
				System.out.println("관리자 모드로 이동합니다.");
				while (true) {
					System.out.print(adminDsply);
					action = sc.nextInt(); // 관리자 메인화면의 번호 입력받음
				}
				
				
				
				
				
				
				
				
				
				
			}//관리자모드 else if문의 끝 
			
			
			
		
		}//전체 프로그램 while문의 끝
	}
}
