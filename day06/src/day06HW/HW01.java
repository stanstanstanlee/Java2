package day06HW;
/*
※※※※※※※※※※
1. 멤버변수,메서드
2. 생성자 오버로딩
	this()
3. this.
※※※※※※※※※※

[ 과제 1 ]
"점" 만들어주세요!~~
class Point
   int x
   int y
Point point=new Point();
   (0,0)
Point point=new Point(10);
   (10,10)
Point point=new Point(2,3);
   (2,3)
point.move();
   (11,12) -> (12,13)
point.move(3);
   (11,12) -> (14,15)
point.move(4,5);
   (11,12) -> (15,17)
point.printInfo();
   현재위치는 (20,30)입니다.
 */
class Point {
	//멤버변수
	int x;
	int y;
	
	//생성자 (오버로딩)
	Point() {
		this(0,0);
	}
	Point(int x) {
		this(x,x);
	}
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//함수(기능) (오버로딩)
	void move() { //+1 씩
		this.x++;
		this.y++;
	}
	void move(int x) { //인자로 받는 수를 x 와 y 모두 이동
		this.x+=x;
		this.y+=x;
	}
	void move(int x, int y) { //인자로 x를 받고 x는 그만큼 y를 또 인자로 받고 y는 그만큼 다르게 이동
		this.x+=x;
		this.y+=y;
	}
	void printInfo() {
		System.out.println("현재위치는 ("+this.x+","+this.y+") 입니다.");
	}
}

public class HW01 {
	public static void main(String[] args) {
		
		Point p1=new Point();
		Point p2=new Point(10);
		Point p3=new Point(2,3);
		
		p3.printInfo();
		p2.printInfo();
		p2.move();
		p2.printInfo();
		p2.move(2);
		p2.printInfo();
		p2.move(2,3);
		p2.printInfo();
	
	}
}
