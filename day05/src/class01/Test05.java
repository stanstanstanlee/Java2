package class01;

// [ 오버로딩 ]
// : 기능이 같은 함수
// : 메서드 시그니처가 다른경우에는
//		-> 인자의 개수, 자료형이 다른경우에는 
// : 함수명 중복정의를 허용
// 상황을 알아야 함 

public class Test05 {
	public static int plus(int a, int b) {
		return a+b;
	}
	public static int plus(int a, int b,int c) {
		return a+b+c;
	}
	public static double plus(double a, double b) {
		return a+b;
	}
	public static double plus(double a, double b, double c) {
		return a+b+c;
	}
	public static void main(String[] args) {
		// 함수가 업그레이드 되고(패치, 업데이트) 함수명이 바뀌면 매번 바뀐 함수명을 호출 하기가 불편
		int res = plus(1,2);
		double res2 = plus(3.1, 2.3);
		
		//오버로딩의 대표예시 
		//System.out.println 오버로딩 10개 되어 있음 ctrl+shift로 확인
		// 그래서 가능 : 
//		System.out.println(100);
//		System.out.println("apple");
//		System.out.print(); <--에러 void() 인자 없이 오버로딩 안되어있음; 함수정의가 안되어있다. 
		System.out.println(); //<-- void()오버로딩 되어있음
	}
}
