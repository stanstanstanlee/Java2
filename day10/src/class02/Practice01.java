package class02;
/*
실습 1) 점 클래스 Point가 있습니다
int x, int y를 멤버변수로 가지고 있습니다.
	좌표

x,y의 좌표가 같다면 같은 점으로 인식할수있도록해주세요!~~

main () {
	Point[] data=new Point[3];
	data[0]에는 점(10,20)
	data[1]에는 점(123,20)
	data[2]에는 점(10,20)
		이 저장되어 있습니다.
	data[0]과 data[1],
	data[0]과 data[2]를 비교해주세요!~~
}
 */
class Point {
	//멤버변수
	int x;
	int y;
	//생성자
	Point(int x, int y) { //사용자에게 받아오는 입력값(상속과 관련없음)현재 클래스의 멤버변수와만 관련이 있다
		this.x=x;
		this.y=y;
	}

	//메서드
	void printInfo() {
		System.out.println("X : "+this.x+", Y : "+this.y);
	}
	@Override
	public boolean equals(Object obj) {
		Point p = (Point)obj; //다운캐스팅
		
		if(this.x==p.x && this.y==p.y) {
			return true;
		}
		return false;
	}
}

//class ColorPoint extends Point{
//	//멤버변수
//	String color;
//	
//	//생성자
//	ColorPoint(int x,int y,String color) {
//		super(x,y);
//		this.color=color;
//	}
//	         
//	//메서드
//	@Override
//	public boolean equals(Object obj) {
//		ColorPoint cp = (ColorPoint)obj;
//		if(this.x==cp.x && this.y==cp.y && this.color.equals(cp.color)) {//x,y의 좌표가 같아도 색이 다르면 다른 점으로 인식할수있도록
//			return true;
//		}
//		return false;
//	}
//}


public class Practice01 {
	public static void main(String[] args) {
		Point[] data=new Point[3];
		
		data[0] = new Point(10,20);
		data[1] = new Point(123,20);
		data[2] = new Point(10,20);
		
		ColorPoint[] data1=new ColorPoint[3];
		
		data1[0] = new ColorPoint(10,20,"파랑");
		data1[1] = new ColorPoint(10,20,"파랑");
		data1[2] = new ColorPoint(10,20,"빨강");
	
		if(data1[0].equals(data1[1])) {//data[0]과 data[1]이 같아??
			System.out.println("OOO");
		} else System.out.println("XXX");
		
		if(data1[0].equals(data1[2])) {//data[0]과 data[2]가 같아??
			System.out.println("OOO");
		} else System.out.println("XXX");
	
		data[0].printInfo();
		data[1].printInfo();
		data[2].printInfo();
	
	}
}
