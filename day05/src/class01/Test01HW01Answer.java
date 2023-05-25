package class01;

import java.util.Scanner;

public class Test01HW01Answer {
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
			if(num==0) { //0이 입력되었을때 !=10번입력했을때, 0이 입력됬을때 //// 여기서 함수 한번
				System.out.println("0이 입력되어 종료합니다...");
				System.out.println();
				break;
			}
			cnt++;
		//2번 && 3번------------------------------------------------------------------------------------
			if(num%2==0) { //여기서 함수 한번
				a++;
			}
			if(num<0) { //여기서 함수 한번
				b++;
			}
		}
		
		System.out.println(cnt+"번 입력완료했습니다");
		System.out.println("짝수 : " +a+"개");
		System.out.println("음수 : " +b+"개");
	}
}
