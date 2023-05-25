package class01;
// [ 상속 - 심화]

class Pokemon {
	String name;

	Pokemon() {
		this("포켓몬");
	}

	Pokemon(String name) { // 오버로딩
		this.name = name;
	}

	void printInfo() {
		System.out.println("이 포켓몬은 " + this.name + "입니다.");
	}
	/*
	 * 최상위 클래스 Object로부터 상속받은 메서드인 equals()를 살짝 바꿔서 사용하고싶음! -> 오버라이딩 (메서드시그니처가같아야해 :
	 * 인자개수 같아야함 순서 같아야함 걍 고정) 메서드 재정의 void func(double d) { //int 10이 인자로 설정됨
	 * d=10.0; //그냥 10이 필요함 int i=(int)d; //형변환(타입캐스팅) double d=3; //3.0 자동 형변환 업캐스팅
	 * }
	 */

	@Override // @어노테이션 : 프로그램이 인지하는 주석
	public boolean equals(Object obj) {
		// 타입캐스팅
		Pokemon pokemon = (Pokemon) obj; // 명시적형변환 // 다운캐스팅
		// ==>> (p1.equals(p2)) 이제 쌉가능
		// 내 이름이랑 비교할 대상의 이름이랑 같아?
		if (this.name.equals(pokemon.name)) { // obj.name 오브젝트는 name을 같고있지 않음
			return true;
		}
		return false;
	}
}

class Pika extends Pokemon {
	Pika() {
		super("피카츄"); // this("포켓몬");<<==얘를 쓰고 있는거양
		// this.name="피카츄"; <<== 또 다른 방법
	}
}

class Charm extends Pokemon {
	Charm() {
		super("파이리");
	}
}

public class Test01 {
	public static void main(String[] args) {
		Pika p1 = new Pika();
		Pika p2 = new Pika();
		Charm c1 = new Charm();
		// 키우미집 (여따 맡길 수 있음. 그럼 키우미집에서 키워주고 레벨업 시켜줌)
		// : 포켓몬-1 / 포켓몬-2
		// 종족이 같으면 알을 줌
		// -> 피카츄 피카츄 -> 알
		// -> 파이리 피카츄 -> 알 안줌
		// p1, c1을 키우미집에 맡겼다!
		// p1==c1 XXX에러
		// 연산자의 대상이 객체가 될수 없음!! ex) 문자열 비교 XX
		// equals()메서드는 두개의 객체가 같은주소 일때만 True가 뜬다. equals는 주소를 봄
		// 파란색, 세모 표기는 내가 방금 만든거임
		if (p1.equals(p2)) { // p1과 c1이 같은 포켓몬이야? // 객체를 비교할때, 본질적으로 두개가 같니? 라고 물을 수 없음. 두개의 객체가 같은 주소야?라고
								// 물어보면 안됨. 다른 객체의 것 이기 때문에.
			System.out.println("알을 획득했습니다!");
		} else
			System.out.println(".....");

		// ★★★ Object 클래스
		// : JAVA에서 기본제공해주는 최상위 클래스

	}
}
