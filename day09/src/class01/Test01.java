package class01;

class A { //기존에 있었던 클래스(부모클래스, 상위클래스) 한개의 맴버변수와 한개의 함수
	int a;
	void funcA() {
		System.out.println("a= "+this.a);
	}
}

// 부모클래스에서는 자식클래스의 내용에 접근 안됨
// 자식클래스에서는 부모클래스의 멤버변수, 메서드에 접근이 가능하다 
class B extends A{ //기존에 존재했던 클래스를 보고 추가로 구현한 클래스
	// 자식 클래스, 하위클래스
	//메인에서 bbb.를 통해a와 funcA 접근 가능하게 됨 
	int b;
	void funcB() {
		System.out.println("b= "+this.b);
	}
}

public class Test01 {
	public static void main(String[] args) {
		
		A aaa = new A(); // 객체와(인스턴스화)
		aaa.a=10; // aaa =-> a, funcA() //생성자 없으니 직접 멤버변수 초기화
		
		B bbb = new B(); // 인스턴스화를 함으로써 bbb라는 객체 생성 // bbb -> a, b, funcA(),funcB()
							//bbb라는 자식 클래스의 객체는 부모의 것을 가질수 있다 -> a, b, funcA(),funcB()
		bbb.a=22; // bbb를 초기화를 하면 나옴 
		bbb.b=20; // aaa.a 와 다른 객체이기 때문에 서로에게 영향을 주지 않음. 
		
		aaa.funcA();
		System.out.println("----------------");
		
		bbb.funcA(); // 0이나옴 초기화를 안함 
		bbb.funcB(); 
		

	}
}
