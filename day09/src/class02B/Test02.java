package class02B;

class Person{//붕어빵틀 : 먼저 호출 할 수 밖에 없다 
	String name;
	Person(String name) { //name을 초기화를 해 주시 때문에 홍길동이 출력됨
		this.name=name;
		System.out.println("Person() 생성자 호출완료!");
	}
	
	void hello() {
		System.out.println("안녕하세요! :D");
	}
	
}

class Student extends Person {//붕어빵을 먼저 구워내고 추가 
	int score;
	Student(String name, int score) {
		super(name); //부모의 기본생성자를 받고 있음 // 부모클래스의 다른 생성자를 호출
//		this.name=name;
		this.score=score;
		System.out.println("Student() 생성자 호출완료!");
	}
	void printInfo() {
		System.out.println(this.name+"학생 "+this.score+"점");
	}
}

public class Test02 {
	public static void main(String[] args) {
		Student stu = new Student("홍길동",100);
		stu.printInfo();
		
	}
	
}
