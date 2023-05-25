package class02;

class A { 
	int a;
	A() { //해결방법 1) 기본생성자를 만들어주면 됨 
	}
 	A(int a){ //기본 생성자를 일반 생성자로 바꿔 버려서 자식 클래스에서 호출이 안됨  
		this.a=a;
		System.out.println("A() 생성자 호출완료!"); //A 생성자 만들자 마자 자식클래스 B에서 에러가 남 
	}
	void funcA() {
		System.out.println("a= "+this.a);
	}
}

// 부모클래스에서 생성자를 만들었는데 왜 자식클래스에 에러가 발생 했을까?

class B extends A{ //

	int b;
	B(int b) { //자식 클래스 생성자를 만들자 class에 있던 빨간줄 오류가 생성자 수준으로 넘어옴 //
		super(); //숨겨져 있던 코드; 직접 명시하자 마자 인자부분에 있던 에러가 super로 넘어옴. 
				 // super() -> 생성자 -> 클래스 // 원래는 super에 에러가 super가 명시 안될 때 생성자에 있었고 생성자가 없을때는 막연하게 클래스 부분에 표시를 해 주고 있었음
		this.b=b;       
		//super() ==>> this()와 유사
		//this() : 자기자신클래스의 생성자
		//super() : 자신의 부모클래스의 생성자를 의미함
		
	}
	
	
	void funcB() {
		System.out.println("b= "+this.b);
	}
}

public class Test01 {
	public static void main(String[] args) {
		
		A aaa = new A(); // 객체와(인스턴스화)
		aaa.a=10; // aaa =-> a, funcA() //생성자 없으니 직접 멤버변수 초기화
		
		B bbb = new B(123); // 인스턴스화를 함으로써 bbb라는 객체 생성 // bbb -> a, b, funcA(),funcB()
							//bbb라는 자식 클래스의 객체는 부모의 것을 가질수 있다 -> a, b, funcA(),funcB()
		bbb.a=22; // bbb를 초기화를 하면 나옴 
		bbb.b=20; // aaa.a 와 다른 객체이기 때문에 서로에게 영향을 주지 않음. 
		
		aaa.funcA();
		System.out.println("----------------");
		
		bbb.funcA(); // 0이나옴 초기화를 안함 
		bbb.funcB(); 
		

	}
}
