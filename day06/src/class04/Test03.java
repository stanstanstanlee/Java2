package class04;
// 원 객체들을 생성하고 싶습니다 ==>> 원 객체들을 만들어달라란뜻
// Point 1. 지역변수 vs 멤버변수
// Point 2. 멤버변수에 대입연사자 사용 절대 안한다 xxx
// 			->생성자를 정의하여 해결
class Circle {
	//상태,속성,멤버변수 : 실무에서는 클래스안 멤버변수에 절대로 값을 직접 대입하지 않습니다. 
	String name;
	int radius;
	double PI; // = 3.14; //<<== 원이라면 누구든 갖고있으니 속성으로 
	double area;// = radius*radius*PI;
	
	//생성자(는 함수입니다)
	//1. input
	//2. output 당연히 안씀 -> 당연히 객체가 output이기 때문
	//3. 생성자함수명==클래스명 동일 
	//★★★★★ 생성자의 존재이유 ★★★★★
	// : 멤버변수의 값들을 초기화 하기 위해서 사용함~
	Circle(String name,int radius) {
		this.name=name;
		this.radius=radius;
		this.PI=3.14;
		this.area=this.radius*this.radius*this.PI;
		System.out.println(this.name+"이(가) 생성완료!");
	}
	
	void printInfo() { // output printInfo(input) : input은 없고, 출력만할꺼니까 output도 없음
		//갈색글씨 : 지역변수를 의미
		// 파랑글씨 : 멤버변수를 의미
//		double area = (radius*radius)*3.14;
		System.out.println(this.name+"은(는) 넓이가 " +this.area+"입니다.");
	}
}

public class Test03 {
	public static void main(String[] args) {
		/*
		int num;
		num=10;
		
		Circle c=new Circle();
		c.name="원";
		
		int num =10;
		Circle c = new Circle("원"); //인자가생김
		c.name="원";
		*/
		//생성자를 1개라도 코더가 제작하게 되면
		//더이상 기본생성자는 제공되지않습니다. 
		Circle c1 = new Circle("동그라미",11);
		Circle c2 = new Circle("똥끄라미",20);
		
		// ↓인제 필요없음
//		c1.name ="동그라미";
//		c1.radius = 11;
//		
//		c2.name="똥끄라미";
//		c2.radius = 20;
		
		c1.printInfo();
		c2.printInfo();
	}
}
