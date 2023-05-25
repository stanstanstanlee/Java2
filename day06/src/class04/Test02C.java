package class04;

class Book3 {
	// 멤버변수(속성,상태)값으로 :
	String title;
	int price;
	int cnt;
	
	//생성자
	Book3(String title, int price) {
		this.title=title;
		this.price=price;
		this.cnt=0; //꼭넣어야함 멤버변수 늘어났으면
		System.out.println(this.title+ " 생성완료!");
	}
	//생성자 오버로딩
	Book3(String title, int price, int cnt) {
		this.title = title;
		this.price = price;
		this.cnt = cnt;
		System.out.println(this.title+" 생성완료!");
	}
	
	// 메서드(기능, 동작)
	void printInfo() {
		System.out.println(this.title+"은(는) " + this.price+ "원입니다. 팬매량은"+this.cnt+"권 입니다");
	}
	//판매량기록 //일반적으로 멤버변수 추가되면 그에 따른 메서드들이 생김
	// INTPUT : 판매개수 int
	// OUTPUT : 판매량 +=10;
	void sell() {
		this.cnt +=10;
		System.out.println(this.title+" 판매완료");
	}
	
}

public class Test02C {
	public static void main(String[] args) {
		
		// 객체들 (객체를 사용하려면 생성자(함수) 선언 해야함)그 객체를 사용하려면 생성자가 있어야 한다는 것. 그래서 자바가 기본생성자 준다고~
		Book3 b1 = new Book3("어린왕자",7800); // 선언하지않아도 기본적으로 제공되는 생성자 (자바 : Book클래스가 만들어졌네? 객체를 쓰겠지? ==>>기본생성자만들어줄겡)
		Book3 b2 = new Book3("해리포터",23000); // 기본(디폴트)생성자 : 인자없음
					//생성자(함수) : 1) 클래스와 이름이 같고 2) 객체를 생성할 수 있으며 3) new 연산자와 함께 사용
//		b1.title="어린왕자";
//		b1.price=7800;
		
		b1.printInfo();// 15~23번 라인까지 함수는 총 4개
						// 함수 1개
						//메서드 1개*
						//생성자 2개
		
		b2.printInfo();
		Book3 b3 = new Book3("비전공자를 위한 이해할 수 있는 IT지식",16800,100);
		b3.sell();
		b3.printInfo();
		
		
	}
}
