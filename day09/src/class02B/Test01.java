package class02B;

class A { 
	int a;
/*
	A() {
		System.out.println("A() 기본생성자 호출 완료 ");
	}
	*/
	A(int a){ //생성자 
		this.a=a;
		System.out.println("A() 생성자 호출 완료 ");
	}
	void funcA() {
		System.out.println("a= "+this.a);
	}
}

// 부모클래스에서 생성자를 만들었는데 왜 자식클래스에 에러가 발생 했을까?

class B extends A{ //B역시 클래스이기 때문에 기본생성자를 사실 갖고 있음 

	int b;
	B() {
		super(1234); // == A() 부모의 생성자
		System.out.println("B() 기본생성자 호출완료!");
	}
	
	void funcB() {
		System.out.println("b= "+this.b);
	}
}

public class Test01 {
	public static void main(String[] args) {
		
		A aaa = new A(123); // 
		
		B bbb = new B(); // 
	
		bbb.b=20;
		aaa.funcA();
		System.out.println("----------------");
		
		bbb.funcA(); // 0이나옴 초기화를 안함 
		bbb.funcB(); 
		

	}
}
