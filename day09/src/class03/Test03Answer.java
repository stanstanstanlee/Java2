package class03;//코딩스타일 선생님처럼 

class Shape{ //부모클래스 코딩이 끝났다 라는 확신을 가지고 넘어가야 함. 

	String name;
	double area;
	Shape(String name) { //멤버변수를 초기화 : 이게 필요한데, 넓이는 반지름, 가로,세로 추가적인게 필요할 것이다 해서 이것도 만듬
						 //대비
		this(name,0.0);
	}
	Shape(String name,double area) { //넓이를 입력받을 일은 결코 없을거야 하면 지워도 됨
									 //내가 가진 모든 멤버변수를 초기화 할 수 있는 생성자가 무조건 있어야 함 ! 
		this.name=name;
		this.area=area;
	}
	void printArea() {
		System.out.println(this.name+"의 넓이는 " +this.area+"입니다.");
	}
}

/////////////////////부모 클래스의 코딩이 완전히 끝나야, 자식 클래스를 코딩한다!
/////////////////////자식 클래스를 코딩한다! 

class Circle extends Shape {//자기가 가진 멤버변수 4개를 모두 초기화 할 수 있는지 생각
	int r; //멤버변수 = (인스턴스변수 + 클래스변수) 공유자원일지 아닐지 생각 해 봐야함
	final static double PI=3.14;
	Circle(int r) { //세상의 모든 원은 이름이 원이였음 좋겠어서 name인자로 안받음
//		super("원"); //세상 모든 원의 이름은 '원' 이여야해
//		this.r=r;
//		this.area=this.r*this.r*Circle.PI;
		
		this("원",r); //저는 생성자 둘 다 쓰고싶어요
	}
	Circle(String name,int r) { //외부에서 들어올수 있는 값인지 생각
		super(name); 
		this.r=r;
		this.area=this.r*this.r*Circle.PI;
	}
}

class Rect extends Shape { //부모가 갖고있지 않은 멤버변수만 
	int x;
	int y;
	Rect(String name, int x, int y) {
		super(name);
		this.x=x;
		this.y=y;
		this.area=this.x*this.y;
	}
}

public class Test03Answer {
	public static void main(String[] args) {
		Circle c1=new Circle(1);
		Circle c2=new Circle("도넛",10);
		c1.printArea();
		c2.printArea();
	
		Rect r = new Rect("네모네모",3,4);
		r.printArea();
		
		
	}
}
