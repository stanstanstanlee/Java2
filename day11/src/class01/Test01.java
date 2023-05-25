package class01;

class Student{
	private String name; //나만 건드릴거얌; 외부에서 다이렉트로 접근 불가; 메인에서 s1.name은 인제 못씀
	private int score;
	Student(String name, int score) {
		this.name=name;
		this.score=score;
		System.out.println(this.name+"학생 생성완료!");
	}
	@Override
	public String toString() {
		return this.name+"학생은 "+this.score+"점입니다";//<<==화면에 무엇이 출력될지 여기다가 작성
	}
	// private된 멤버변수에 접근 가능하도록하는 "메서드"를 추가로 생성
	// setter : 멤버변수의 값을 설정
	// getter : 멤버변수로부터 값을 받아올수있도록 해줌 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	

}
public class Test01 {
	public static void main(String[] args) {
		Student s1 = new Student("아리",89);
//		s1.name="이진"; // 게터세터없이 private멤버변수에 접근 못함
		s1.setScore(95);
		System.out.println(s1.toString()); //toString이 재정의 되어야 나옴 
		System.out.println(s1);
		//함수를 사용하면 로그라는게 남음
		// [ 로그 ] ★★★★★
		// 기록 
		// 하나의 코드로 여러 개발자들이 동시ㅣ에 작업
		// : 프로젝트 완성시 기여도 측정
		// : 오류가 발생시 어떤 액션 + 어떤 기능에서 발생했는지 기록 
		// ==>> 메서드 위주로 기록됨
		// ==>> 단순 연산자는 로그에 안남는다 
		
		
		
	}
}
