package class01;

// "포켓몬" 객체는 없는것 아닌가요?
// "피카츄, 파이리" 객체만 있으면되는거아닌가요? 네, 맞아요

//	[ 추상 클래스 (abstract class) ] (표본) 
// "객체화 하는것이 목표가 아니라, 설꼐를 하는것이 목표였던 클래스들"
// "클래스들의 기준이 되는것이 목표"
abstract class Shape{ //
	String name;
	double area;
	abstract void draw();//추상메서드 오버라이딩을 강제함; 중괄호{}를 가질 수 없음
}
class Rect extends Shape{ //오버라이딩 안하면 에러남 must implement inherited abstract method
	@Override
	void draw() {
		System.out.println("네모 그리기");
	}
}
class Circle extends Shape{
	@Override
	void draw() {
		System.out.println("원 그리기");
	}
}
class Tri extends Shape{
	@Override
	void draw() {
		System.out.println("세모 그리기");
	}
}
public class Test02 {
	public static void main(String[] args) {
		
		Circle c = new Circle();
		c.draw();
		Rect r = new Rect();
		r.draw();
		
		
		
		
		
		
	}
}
