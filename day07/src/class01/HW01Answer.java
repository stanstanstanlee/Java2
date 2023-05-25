package class01;
/*★★★★★ 한글코딩 ★★★★★
 습관 ===>> 코딩 확신 갖기 
 * */
//'점' 만들어 주세요 라는 부탁
		// class Point 만드는게 목표구나

class Point {	// 1. 멤버변수[속성] 2. 메서드[기능] 3. 생성자
	//멤버변수
	int x; // 작성 된데로
	int y; 
	
// 	※this() : 인자가 가장 많은 생성자만 살려두고 
	//생성자 [오버로딩]
	Point() { // : 멤버변수 초기화
		this(0,0);
	}
	Point(int x) {
		this(x,x);
	}
	Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	//메서드 [오버로딩] // 통상적으로 메서드는 생성자처럼 this() 안함; 메서드는 계속 발전함
	void move() {//내 의견 없음 걍 하라는데로
		this.x++;
		this.y++;
	}
	void move(int x) {
		this.x+=x;
		this.y+=x;
	}
	
	void move(int x, int y ) {
		this.x+=x;
		this.y+=y;
	}
	void printInfo() {
		System.out.println("현재위치는 ("+this.x+","+this.y+") 입니다.");
	}
	
}
public class HW01Answer {
	public static void main(String[] args) {
		// '점' 만들어 주세요 라는 부탁
		// class Point 만드는게 목표구나
		
		Point p1 = new Point();
		Point p2 = new Point(10);
		Point p3 = new Point(1,2);
		
		p1.move();
		p1.printInfo();
		
		p2.move(-5);
		p2.printInfo();
		
		p3.move(3,4);
		p3.printInfo();
		
	}
}
