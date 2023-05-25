package practice;

import java.util.Scanner;

public class PracticeHW01 {
	
	//1. 메소드 시그니처를 먼저 만들고, 그 다음에 기능을 구현
		//2. 기능을 먼저 만들고, 메소드 시그니처를 문제에 맞추는 방법
		// 90프로 1번 방법을 씀
		// [1] 	어떤기능을 만들어달라고 요청 받았을때씀  기능 : 
		// Q) 요구사항 : 어떤 정수가 입력 되었을때 짝수인지 아닌지 판별 하는 기능 =>> boolean
		// INPUT : int 1개
		// OUTPUT : return true or false boolean
		public static boolean isEven(int num) {
			if(num%2 == 0) {
				return true;
			}
			return false;
		}
		// [2] 이미 만들어저 있는 기능을 분리하고 함수화 할때 쓰는 방식
		// Q2 main에 있던 기능을 함수에 넣고 시작
		public static boolean checkMinus(int num) {
			if(num<0) { //여기서 함수 한번
				return true;
			}
			return false;
		}
		
		//[1]번방식 //input, output 먼저 파악
		//Q3) 어떤 정수가 0이니? 그럼 프로그램을 종료할예정이야...
		// INPUT : int 1개
		// OUTPUT : boolean ;종료 할지 말지?
		public static boolean check(int num) {
			if (num == 0) {
				System.out.println("0이 입력되어 종료합니다");
				System.out.println();
				return true;
			}
			return false;
		}
		
		
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
		while(cnt<10) { //10번 입력될때 까지; //10이 maximum인데 그전에 0이 나오면 탈출 이라는 늬앙스
			System.out.println((cnt+1)+"번 정수를 입력하세요."); // 사용자 편의성을 고려; UI/UX
			System.out.println("입력) ");
			int num=sc.nextInt();
			
			if(check(num)) { //0이 입력되었을때 !=10번입력했을때, 0이 입력됬을때 //// 여기서 함수 한번
				break;
			}
			cnt++;
			
			//2번 && 3번------------------------------------------------------------------------------------
			if(isEven(num)) { //여기서 함수 한번
				a++;
			}
			if(checkMinus(num)) { //여기서 함수 한번
				b++;
			}
			
		}

		System.out.println(cnt+"번 입력완료했습니다");
		System.out.println("짝수 : " +a+"개");
		System.out.println("음수 : " +b+"개");
	}
}
