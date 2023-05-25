package class04;
/*
===== 메뉴 =====
1. 점 생성
2. 점 목록 출력
3. 점 1개 출력
4. 점 이동
5. 색 변경
6. 점 합치기 (+)
7. 프로그램 종료
===============
Point[] data=new Point[3]; // 최대 3개
   new Point(); // 점(0,0)
   new Point(3,4); // 점(3,4)
   new ColorPoint(); // 검정(0,0)
   new ColorPoint(1,2); // 검정(1,2)
   new ColorPoint("빨강",3,4); // 빨강(3,4)
2번 눌렀을때 :

점(1,2)
검정(2,3)
분홍(-1,-3)

point.move(); -> +1 +1
point.move(10); -> +10 +10
point.move(1,2); -> +1 +2

point.changeColor("빨강")

1,2 + 2,3 => 3,5

검사순서
1. 설계서
2. 한글코딩
3. 잘 돌아가는거 확인
4. 유효성 추가
 */
//=========================================================================================
// 한글 코딩
//class Point 부모생성
//
//	[맴버변수] 
//	 -인스턴스변수
//		정수로 x값
//		정수로 y값
//	
//	 -클래스변수 
//	 	없음
//	
//	[생성자(함수)] 오버로딩 해야함 
//
//		Point() {
//			this(0,0);
//		}
//		Point(int x, int y) { 인자로 x , y를 받을 경우 점의 시작점 위치를 그 값으로 지정; 멤버변수 초기화 해야함
//			this.x=x;
//			this.y=y;
//		}
//		
//		
//	[메서드]
//	프린트메서드 
//		- 기능 : 객체배열에 저장된 것들 다 출력 해야 함. num값으로 선택해서 1개의 값을 출력해야함
//				색깔과 x, y값이 나와야 함 
//		- INPUT : 없음
// 		- OUTPUT : 없음
// 		void printDot() { //오버라이드??
// 			syso((x , y));
//		} 
//		
//	점위치 바꾸는 메서드
// 		- 기능 : 인자 없이 호출 하면 x , y둘다 +1 이동
// 				인자 1개 받으면 x , y 둘다 인자로 받은 값 만큼 이동
// 				인자 2개 받으면 x는 x인자로 받은 만큼 y는 y읹자로 받은 만큼 이동
//				==>> 오버로딩
//		- INPUT : 없는거, int x만 있는거 int x y둘다 있는거 
// 		- OUTPUT : 없엉 
//		void move() {
//			x ++;
// 			y ++;
//		}
//		void move(int x) { 인자 값을 1개 받고 점의 x와 y모두 인자 값 만큼 바뀜 
//			x += x;  
//			y += x;
//		}
//		void move() { 인자 값을 2개 받고 점의 x와 는 x만큼 y모두 y값 만큼 바뀜 
//			x += x;
//			y += y;
//		}
//		
//		
//	class ColorPoint 자식 클래스 생성 상속 extends Point
//		[멤버변수]
//		- 인스턴스 변수
//			String color; //색깔 추가
// 		- 클래스 변수
//			없음
//		[생성자]
//		ColorPoint() {
//			super(0,0);
//			this.color = "검정";
//		}
//		ColorPoint(int x, int y) {
//			super(x,y);
//		}
//
//		ColorPoint(String color, int x, int y) {초기화
//			super(x,y);
//			this.color=color;
//		}
//	
//
//		[메서드]
// 		changeColor(String color)
//		기능 : 색 변경 해 줘야 함. 디폴트 검정인데 point.changeColor("빨강") 이런식으로 색을 인자값으로 주고 호출 하면 색이 빨강이 되야함
//		INPUT : String color 메인에서 메서드 호출 할때 색깔인자 불러와야함
// 		OUTPUT : 없음
//		
//		void changeColor(String color) {
//			컬러를 인자로 받아서 함수 호출 하면 그 색깔이 되어야해 
//			this.color=color
//		}
//		
//		[오버라이딩]
//		@Override
//		void printDot() {
//			syso(("색깔", x , y));
//			syso(this.color+","+this.x+","+this.y) 색까지 프린트 해줘야함 
//		}
//==============[ main ]======================
//	
//	Scanner 불러오기
//	Scanner sc = new Scanner(System.in);
//	
//	객체배열 생성 크기 3개
// 	부모클래스 자료형 객체 2개
//		- new Point(); 인수 없음; 점(0,0)
//		- new Point(3,4); 인수 x,y값; 점(3,4)
//	
//  자식클래스 자료형 객체 3개
//		- new ColorPoint(); 인수 없음; 검정(0,0)
//		- new ColorPoint(1,2); 인수 x,y값; 검정(1,2)
//		- new ColorPoint("빨강",3,4); 인수 색깔, x, y값; 빨강(3,4)
// 	int index = 0; 배열 위치 접근 (사용자가 1번 점이라고 하면 0번 index)
//	while문 안에 있어야 함 7번 누를때 까지 {
//		메뉴 출력
//		int action=sc.nextInt();로 메뉴 선택
//		
//	    if() { [종료조건] 만약에 action 이 7이면 프로그램 종료
//			break;
//		}
//		else if() { 만약에 action이 1 이면 점 추가 배열에다강 
//			data[index++] = new Point(index, x, y);
//			data[index++] = new ColorPoint(); 색깔있으면 여기다가?????????
//			==>> 여기서 막히면 물어물어라도 알아내야 함
//			==>> 어차피 자기 능력으로 구현 못한다는거임 
//		}
//		else if() { 만약에 action이 2 이면 저장된 점 목록 출력
//	
//		}
//		else if() { 만약에 action이 3 이면 저장된 점 1개 선택 출력
//	
//		}
//		else if() { 만약에 action이 4 이면 점 이동
//	
//		}
//		else if() { 만약에 action이 5 이면 색 변경
//	
//		}
//	}
//	
//	
//

class Point {
	//멤버변수
	int x;
	int y;
	//생성자
	//메서드
	
}
class ColorPoint extends Point {
	
}

public class PointMove {
	
	
	public static void main(String[] args) {
		String msg = "===== 메뉴 =====\n"
				+ "1. 점 생성\n"
				+ "2. 점 목록 출력\n"
				+ "3. 점 1개 출력\n"
				+ "4. 점 이동\n"
				+ "5. 색 변경\n"
				+ "6. 점 합치기 (+)\n"
				+ "7. 프로그램 종료\n"
				+ "===============";
		
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
