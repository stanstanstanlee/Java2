package class02;

class A {
	int a; //인스턴스변수,멤버변수,필드,속성,프로퍼티,어트리뷰트
//	int b; // 인스턴스변수는 : 각각의 객체들이 고유한 값을 저장, 객체들끼리 값을 공유하지 않습니다
	
	static int b; //공유자원; 클래스랑 관련이 있어! 객체와 무관하게; 
				  // 클래스변수가 됨.(공유자원)
				  // : 주인이 클래스라서 객체들끼리 값을 공유함
				  // : 이 클래스라면 누구라도 이용가능 
	
	void printInfo() {
		System.out.println("a= "+this.a);
		System.out.println("b= "+this.b); //b는 클래스변수인데 this쓰는게 맞아?? 라고 물어봐주는것
	}
	
}


public class Test01 {
	public static void main(String[] args) {
		A a1=new A();
		a1.a=10; //a,b는 인스턴스 변수라서 다른 객체들 끼리 값을 공유하지 않았다 (서로 다른 영역이라는것)
		a1.b=10;
		A a2=new A();
		a2.a=10;
		a2.b=10;
		a2.a++;
		a2.b++;
		
		a1.printInfo();
		a2.printInfo();
	}
}
