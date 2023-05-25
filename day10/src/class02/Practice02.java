package class02;
/*
실습 2) 색깔점 클래스 ColorPoint가 있습니다.
int x,int y,String color를 멤버변수로 가지고있습니다.
         점색깔
x,y의 좌표가 같아도 색이 다르면 다른 점으로 인식할수있도록
main(){
   ColorPoint[] data=new ColorPoint[3];
   data[0]에는 파랑(10,20)
   data[1]에는 파랑(10,20)
   data[2]에는 빨강(10,20)
      이 저장되어있습니다.
   data[0]과 data[1],
   data[0]과 data[2]를 비교해주세요!~~
}

 */
class ColorPoint extends Point{
	//멤버변수
	String color;
//	int x; 부모클래스에 이미 있어서 안써도됨
//	int y; 부모클래스에 이미 있어서 안써도됨
	//생성자
	ColorPoint(int x,int y,String color) { //사용자에게 받아오는 입력값(상속과 관련없음)현재 클래스의 멤버변수와만 관련이 있다
		super(x,y); // 부모의 생성자를 호출; 부모 생성자에게 값을 넘겨 준다
		this.color=color; //초기화 
	}
	         
	//메서드
	@Override
	public boolean equals(Object obj) {
		ColorPoint cp = (ColorPoint)obj; 
		if(this.x==cp.x && this.y==cp.y && this.color.equals(cp.color)) {//x,y의 좌표가 같아도 색이 다르면 다른 점으로 인식할수있도록
			return true;
		}
		return false;
	}
}

public class Practice02 {
	public static void main(String[] args) {
		ColorPoint[] data=new ColorPoint[3];
		
		data[0] = new ColorPoint(10,20,"파랑");
		data[1] = new ColorPoint(10,20,"파랑");
		data[2] = new ColorPoint(10,20,"빨강");
		
		if(data[0].equals(data[1])) {//data[0]과 data[1]이 같아??
			System.out.println("OOO");
		} else System.out.println("XXX");
		
		if(data[0].equals(data[2])) {//data[0]과 data[2]가 같아??
			System.out.println("OOO");
		} else System.out.println("XXX");
		
		
	}
}
