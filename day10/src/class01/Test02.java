package class01;

class A {
	int num;

	A(int num) {
		this.num = num;
	}

	void printInfo() {
		System.out.println("A: " + this.num);
	}

	@Override
	public boolean equals(Object obj) {
		A a = (A) obj; // 강제로 다운캐스팅
						// ↓↓obj.num 에서==>> a.num로 다시 적어줘야 함
		if (this.num == a.num) { // 혹시 비교했을대 내 숫자와 상대의 숫자가 같아? int니까 ==써도 되영
			return true;
		}
		return false;
	}
}

//A를 상속받는 B C 클래스
class B extends A {
	B(int num) { // 부모에게 기본 생성자가 없었던게 문제였음 그래서 인자 똑같이 받아옴??
		super(num);
	}
}

class C extends A {
	C(int num) {
		super(num);
	}
}

public class Test02 {
	public static void main(String[] args) {

		B b1 = new B(1);
		B b2 = new B(1); // B클래스의 객체들은 1
		C c1 = new C(2); // C클래스의 객체들은 2
		// 1. 현재 equals()는 Object클래스의 것
		// -> 주소값을 비교중
		// 2. 오버라이딩 할거양
		b1.printInfo();
		if (b1.equals(b2)) { // b1과 b2가 같아? b1==b2 연산자 사용 불가
			System.out.println("O");
		} else
			System.out.println("X");

	}
}
