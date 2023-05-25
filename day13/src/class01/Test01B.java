package class01;
// [ 예외와 예외처리 ]
// 예외 // 예외,오류,버그, ... (연구소에서 다 다르게 구별함) 
// 1. 스크린샷 -> 포스팅
// 2. 예외 발생한 라인넘버
// 3. 원인 --->> 해결방안

public class Test01B {
	public static void main(String[] args) {
		
		int a = 10;
		int b = 0; // 정수 / 정수 자체는 문제가 없음
//만약에 예외가 발생했어? 0으로 나눠서?
				//-> 그럼 걍 1로 나눠줭; if로는 못해여
		try {
			System.out.println("확인1");
			System.out.println(a/b); // 실행을 하려고보니까, 0이였던것!
			// 코딩 자체에는 문제가 없으나,
			// '실행시' 발생하는 문제를 예외라고 함 
			System.out.println("확인2");
		}
		catch(ArithmeticException e) {
			System.out.println("확인3");
			System.out.println(a/1);
			System.out.println("확인4");
		
		
		}
		
		
	}
}
