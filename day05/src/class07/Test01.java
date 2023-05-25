package class07;

import java.util.Random;
import java.util.Scanner;

public class Test01 {
	// 이게 먼저임: 
	// 메소드 시크니처를 먼저 고려할것
	// INPUT: int 1개, String 1개
	// OUTPUT: boolean
	// 정답과 사용자의 입력값을 비교해서, 
	// 맞았는지 틀렸는지를 반환 : 양자택일 ===> boolean
	public static boolean check(int num, String user) {
		final int NUM=num; 
		// final : 상수화 바뀔수 없음; 대개 대문자로씀;
		
		int cnt=0; // 박수 횟수 카운트할 변수 
		
		// 1. 진짜 정답을 만들기 String ans
		int n = num/1000; // 1000인 경우, 1을 의미함
		if(n==3 || n==6 || n==9) { // n%3==0 && n!=0 (n이0일때 걸림) //직관적으로 n==3||n==6||n==9 
			cnt++;
		}
		num=num%1000; // 1312인경우, 13을 의미하게 되므로 전처리가 필수!
		n=num/100; //912인 경우, 9를 의미함 //만약 범위가 1312로 늘어났을때 100으로 나누면 13을 의미함
		if(n==3 || n==6||n==9) {
			cnt++;
		}
		
		num=num%100;
		n=num/10; // 56인 경우, 5를 의미함
		if(n==3|| n==6||n==9) {
			cnt++;
		}

		num=num%10;
		n=num/1; // 8인 경우, 8을 의미함
		if(n==3 || n==6 || n==9) {
			cnt++;
		}
		////////////////////////////////////////////////////////
		String ans="";
		for(int i=0; i<cnt;i++) {
			ans+="짝";
		}
		if(cnt==0) {
			// 형변환(casting)
			// 최초의 num값을 기억해줄 변수가 필요하구나! 절대 바뀌면 안되기 때문에 상수화
			ans=Integer.toString(NUM); 
		}
		
		System.out.println("ans: " + ans);
		System.out.println("user: " + user);
		
		// 2. ans와 user를 비교
		if(ans.equals(user)) { //정답과 같니?
			return true;
		}
		return false;
		// 연산자는 기본 자료형 (원시타입) 에게만 적용되는 문법
		// int double char boolean 보라돌이 친구들
		// 원래 스트링 쓰는법 : String str=new String("apple");
		// 약식 : String str = "apple"; 자바에서 허용
		// 클래스(객체)들은 연산자로 비교불가능
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand=new Random();
		
		// 1~1000 중에서 랜덤으로 정수 1개 생성
		// int randNum 
		int randNum=rand.nextInt(1000)+1;
		System.out.println("["+randNum+"] : ");
		String userAns=sc.next();
		
		//check라는 함수로 문제 해결 할 것 (이거 정답이야? 하는거 길어질 예정-->>함수로 뺌)
		if(check(randNum, userAns)) { // randNum==userAns 자료형 맞지 않음 int와 string을 비교 할 수 없음 : 그래서 함수 호출
			System.out.println("정답입니다!");
		}
		else {
			System.out.println("오답입니다.....");
		}
		
		// [randNum] : 출력
		// 사용자가 정답을 입력 : 짝, 19, 22 
		// String userAns = sc.next(); 
		// if(정답)
		// 	syso("정답!);
		//else
		//	syso("오답..."); // <== 여기 까지 한글로 풀이가 됬어야 코딩 할 수 있다
		
		
		
		
		
		
		
	}
}
