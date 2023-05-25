package class01;
//함수 사용시 배열 안씀; 배열의 길이를 모르기 때문에(0이 언제 입력될지 모름)
import java.util.Scanner;

public class Test01HW01Answer02Function {
	// 다른 개발자들의 타입에 맞추면 됨 : 
	//1. 메소드 시그니처를 먼저 만들고, 그 다음에 기능을 구현
	//2. 기능을 먼저 만들고, 메소드 시그니처를 문제에 맞추는 방법
	// 90프로 1번 방법을 씀
	// [1] 	어떤기능을 만들어달라고 요청 받았을때씀  기능 : 
	// Q1) 요구사항 : 어떤정수가 입력되었을때, 짝수인지아닌지 '판별'하는 함수 T or F (boolean: is?? has?? 어쩌구 이름이 많음)
	// INPUT: int 1개
	// OUTPUT: boolean 
	public static boolean isEven(int num) {
		if(num%2==0) {
			return true; // 함수 즉시 종료
		}//else를 달면 depth가 깊어지고 가독성이 떨어짐 
		return false; // 이미 return이 위에 있어서 '함수 즉시 종료' 되기 때문에 else 필요 없음
	}//---------------------------------------------------------------------------------------------------------------
	// [2] 이미 만들어저 있는 기능을 분리하고 함수화 할때 쓰는 방식
	// Q2) main에 구현되어있던 기능을 뜯어서 func()에 우선 넣고 시작 ! 
	public static int checkMinus(int num, int b) {
		if(num<0) {
			b++;
		}
		return b; //main에서 b를 써야함 main 에게 b전달
				//b를 함수 안에서 선언 하면 = 0 으로 계속 초기화 됨 반복문 안에서 함수가 실행 되는 매번
		
	}//완성된 기능들의 묶음을 하나하나 분리해내는 작업 == 모듈화,컴포넌트화
	// : 코드 재사용성이 증가함 == 안정적인 코드를 반복 해서 씀 == 개발 시간 감소 == 비용 감소
	// : 유지보수 용이 (이익증가)
//------------------------------------------------------------------------------------------------------------------
	//[1]번방식 //input, output 먼저 파악
	//Q3) 어떤 정수가 0이니? 그럼 프로그램을 종료할예정이야...
	//	  프로그램 종료안내멘트 출력해줘 syso ouput과 관련 없음
	// INPUT: 어떤 정수가 0이니? int 1개
	// OUTPUT: boolean 종료 할지 말지?
	public static boolean check(int num) {
		if(num==0) { //0이 입력되면 종료
//			bye();
			System.out.println("0이 입력되어 프로그램을 종료합니다...");
			System.out.println();
			return true;
		}
		return false; //일반적으로는 종료 안함
	}// 함수는 모듈화가 되어 있을 수록 좋다. 출력과 같이 있기 때문 더 잘게 쪼개는 것이 좋다. 
//	public static void bye() {
//		System.out.println("0이 입력되어 프로그램을 종료합니다...");
//		System.out.println();
//	}//----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		/*
		1. main()에서 정수를 10번 입력할예정입니다. 
		2. if(짝수야?) a++;
		3. if(음수야?) b++;
		4. 10번 입력완료했습니다. a=ㅁ, b=ㅁ입니다.
		5. 만약, 입력된 정수가 0이라면 프로그램을 종료
		3번 입력완료했습니다. a=2, b=1입니다. 
		 */

		Scanner sc = new Scanner(System.in);
		//1번 && 5번----------------------------------------------------------------------------- 
		//CTRL C, V를 하고 있네? --->> 반복문!
		//while VS for : 0이 언제 나올지 모르니 while
		int cnt = 0; //몇번입력 했는지 카운트
		int a=0; //짝수의 개수
		int b=0; //음수의 개수
		while(cnt<10) { //10번 입력될때 까지; //이 maximum인데 그전에 0이 나오면 탈출 이라는 늬앙스
			System.out.println((cnt+1)+"번 정수를 입력하세요."); // 사용자 편의성을 고려; UI/UX
			System.out.println("입력) ");
			int num=sc.nextInt();
			
//			if(num==0) { //0이 입력되었을때 !=10번입력했을때, 0이 입력됬을때 // 여기서 함수 한번
//				System.out.println("0이 입력되어 종료합니다...");
//				System.out.println();
//				break;
//			} 함수화 : 
			if(check(num)) { 
				break;
			}
			cnt++;
			//2번 && 3번------------------------------------------------------------------------------------
//			if(num%2==0) { //여기서 함수 한번
//				a++;
//			}함수화 :
			if(isEven(num)) {
				a++;
			}
//			if(num<0) { //여기서 함수 한번
//				b++;
//			}함수화 : 
			b = checkMinus(num, b);
			System.out.println(checkMinus(num, b)); //왜 안됨??
		}
		System.out.println(cnt+"번 입력완료했습니다");
		System.out.println("짝수 : " +a+"개");
		System.out.println("음수 : " +b+"개");
	}
}
