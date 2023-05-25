package class06;

public class Test04 {
	//input xxx output ooo
	public static String funcC() {
		//함수 유형 C
		System.out.println("funcC() 동작!");
		
		return "apple"; //함수 즉시 종료됨!!!!! 반환시 메모리 해제
		//System.out.println("funcC()의 마지막 코드"); 반환후 유효하지 않은 코드 
	}
	
	public static void main(String[] args) {
		
		funcC(); // == "apple"; 아무일도 일어나지 않음 // return값은 (output은) 해당함수를 호출한 자리로 이동함
		System.out.println("main() 공간 : "+funcC()); // == syso("apple")
		// 1. println()해주세요
		// 2. funcC() 호출해주세요.
		// 2 >> 1 괄호안에 있으니까 2 먼저 
		String msg=funcC();
		// 1. = 대입 연산자
		// 2. funcC() 호출해주세요.
		// 2 >> 1 대입연산자가 더 느림
		System.out.println("msg: " + msg);
		
		// 1. 일반적으로 OUTPUT이 존재하는 함수들은 main에
		//		a) 출력하거나, 
		//		b) 변수에 저장하거나
		//		해서 활용함
		
		// 2. return값은 해당함수를 호출한 자리로 이동함 
	}
	
}
