package class04;

class CarA {
	String name;
	int speed; //현재속도
	int max; //최대속도
	
	// this() == 생성자 함수
	CarA() {
//		this.name="무명";
//		this.speed=0;
//		this.max=120;
		this("무명",120);
		System.out.println("확인 1");
	}
	CarA(String name) {
//		this.name=name;
//		this.speed=0;
//		this.max=120;
		this(name,120);
		System.out.println("확인 2");
	}
	CarA(String name, int max) { //인자가 가장 많은 생성자를 먼저 만들어 놓고 다른 생성자들이 가져다 쓴다
		this.name=name;
		this.speed=0;
		this.max=max;
		System.out.println("확인 3");
	}
	
	
	void printInfo() {
		System.out.println(this.name+"님의 차는 ["+this.speed+"/"+this.max+"]입니다.");
	}
	void speedUp() {
		this.speed+=100;
		if(this.speed>this.max) {
			this.speed=this.max;
			System.out.println("과속!");
		}

	}//+++) 자동차.speedUp(23)
	 //     0 -> 23
	void speedUp(int speed) { // 심화// 함수 오버로딩
		this.speed+=speed;
		if(this.speed>this.max) {
			this.speed=this.max;
			System.out.println("과속!");
		}
	}

	void speedDown() {
		this.speed=5;
		if(this.speed<=0) {
			this.speed=0;
			System.out.println("정지...");
		}
	}

}

public class Test05CarAnswer {
	public static void main(String[] args) {
		CarA c1=new CarA();
		CarA c2=new CarA("홍길동");
		CarA c3=new CarA("아무무",200);
		
		c1.printInfo();
		c2.speedDown();
		c2.printInfo();
		c3.speedUp();
		c3.speedUp(50);
		c3.printInfo();
		c3.speedUp(70);
		c3.printInfo();
		c2.speedUp(20);
		c2.printInfo();
		      

	}
}
