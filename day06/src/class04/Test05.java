package class04;

/*
자동차 코딩해주세요!
자동차.printInfo()
	-> ㅁㅁ님의 차는 [_/__] 입니다.
		      현재속도/최대속도
자동차.speedUp()
	0 -> 100
	120 -> 과속! -> 120
		최대속도를 못넘어가게 코딩

자동차.speedDown()
	55 -> 45
	5 -> 정지... -> 0
		0보다 작아질수없게 코딩

Car car = new Car();
          무명 / 0 / 120
Car car = new Car("홍길동");
	  홍길동 / 0 / 120
Car car = new Car("아무무",200); // 직접 넣으면 최대속도200
	  아무무 / 0 / 200
 *///--------------------------------------------------------------
// 자동차 클래스를 만들어주세요

// printInfo()라는 함수를 만들고 출력
// 	-> ㅁㅁ님의 차는 [_/__] 입니다.
//	          현재속도/최대속도
// 
// ㅁㅁ님 -> 차주 이름 -> 멤버변수 
// ?? 현재속도 -> 멤버변수 ??

// speedUp()이라는 함수를 만들고 기능 추가
//			0 -> 100
//			120 -> 과속! -> 120
//			최대속도를 못넘어가게 코딩

// ?? 최대속도 -> 멤버변수?? 

// speedDown()이라는 함수를 만들고 기능 추가
// 		    55 -> 45
//			5 -> 정지... -> 0
//			0보다 작아질수없게 코딩
// ?? 최저속도 -> 멤버변수??
class Car {
	//멤버변수
	String name; //차주이름
	int cuSp; //현재속도
	int maxSp; //최대속도
	int minSp; //최저속도---> 0????
	// 생성자를 오버로딩 안한경우 ==> 생성자 1개가 혼자 있을때 
	//3개 전부 다 생성자 오버로딩 
	Car () {
		this.name="무명";
		this.cuSp=0;
		this.minSp=0;
		this.maxSp=120;
	}

	Car (String name){
		this.cuSp=0;
		this.minSp=0;
		this.name=name;
		this.maxSp=120;
	}
	
	Car (String name, int maxSp) {
		this.cuSp=0;
		this.minSp=0;
		this.name=name;
		this.maxSp=maxSp;
		
	}
	
	//기능
	void printInfo() { //상태 출력
		System.out.println(this.name+"님의 차는 ["+this.cuSp + "/"+this.maxSp+"]"+"입니다");
	}
	
	void speedUp() { //속도 증가
		System.out.println("스피드업!");
		if(this.cuSp+100<this.maxSp) {
			this.cuSp+=100;
		}else {
			this.cuSp = this.maxSp;
			System.out.println("속도를 올릴수 없습니다. 과속! 최대속도 ->"+this.maxSp);
		}
	}
	void speedDown() {  //속도 감소
		System.out.println("스피드다운~");
		if(this.cuSp-10>0) {
			this.cuSp-=10;
		}else {
			this.cuSp = this.minSp;
			System.out.println("할 수 없습니다 이미 정지....");
		}
	}
}

public class Test05 {
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car("존윅");
		Car car3 = new Car("타잔",200);
		
		car1.printInfo();
		
		car2.speedUp();
		car2.printInfo();
		car2.speedUp();
		car2.printInfo();
		car2.speedUp();
		car2.printInfo();
		
		car3.printInfo();
		car3.speedUp();
		car3.printInfo();
		car3.speedDown();
		car3.speedDown();
		car3.speedDown();
		car3.speedDown();
		car3.speedDown();
		car3.speedDown();
		car3.speedDown();
		car3.speedDown();
		car3.printInfo();
		car3.speedDown();
		car3.printInfo();
		car3.speedDown();
		car3.printInfo();
	}
}
