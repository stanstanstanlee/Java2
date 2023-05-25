package class02B;

class Shape {
	String name;
	double area;
	
	Shape(String name) {
		this.name=name;
		double area=0;
		System.out.println("Shape() 생성자 호출완료!");
	}
	
	void printArea() {
		System.out.println(name+"의 넓이는 "+area+"입니다");
	}
}

class Circle extends Shape{
	int radius;
	final static double PI = 3.14;
	
	Circle(String name, int radius) {
		super(name);
		this.radius=radius;
		this.area = radius*radius*PI;
		System.out.println("Circle() 생성자 호출완료!");
	}
}

class Rect extends Shape{
	int x;
	int y;
	
	Rect(String name, int x, int y) {
		super(name);
		this.x=x;
		this.y=y;
		this.area = x*y;
		System.out.println("Rect() 생성자 호출완료!");
	}
}

public class Test03 {
	public static void main(String[] args) {
		Circle c = new Circle("원",3);
		Rect r = new Rect("사각형",5,6);
		
		
		c.printArea();
		r.printArea();
	}
}
