package class01;

import java.util.Random;
import java.util.Scanner;

public class Test04_369GameReviewLoop {
	public static boolean check(int num, String user) {
		final int NUM = num;
		int cnt = 0; //박수의 개수
		int n=num/1000; //=========================반복시작
		if(n==3 || n==6 || n==9) {
			cnt++;
		}
		
		num=num%1000; // 1234 -> 234 
		n=num/100;//==============================까지 반복
		if(n==3 || n==6 || n==9) {
			cnt++;
		}
		
		num=num%100; // 234 -> 34
		n=num/10;
		if(n==3 || n==6 || n==9) {
			cnt++;
		}
		
		num=num%10; // 34 -> 4
		n=num/10;
		if(n==3 || n==6 || n==9) {
			cnt++;
		}
		/*
		 * int x =1000;
		 * while(x>0) {
		 * 		int n=num/x;
		 * 		if(n==3||n==6||n==9){
		 * 			cnt++;
		 * 		}
		 * 
		 * 		num=num%x; // 1234 -> 234
		 * 		x=x/10;
		 * }
		 * 
		 */
		String ans="";
		for(int i=0; i<cnt; i++) {
			ans+="짝";
		}
		if(cnt==0) {
			ans=Integer.toString(NUM);//처음랜덤수
		}
		System.out.println("ans : " + ans);
		System.out.println("user : " + user);
		
		if(ans.equals(user)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
// 		자기 방식대로 한국어로 풀어내는거 
		// XXXXXXXXXXXXXXfor(3번)XXXXXXXXXXX
		// while(최대 3번)
		// 		[1]
		//		if(오답이라면) -> 종료조건
		// 			break;
		// if(3번 다 정답이야?)
		// 		이름 입력
		// 		입력받은 이름을 출력
		Scanner sc=new Scanner(System.in);
		final int LV = 1;
		int i=0;
		while(i<LV) { //최대 3번이니까 카운트 할 변수 i 생성
			Random rand = new Random();
			int num=rand.nextInt(1000)+1;
			System.out.println("["+num+"] : ");
			String user=sc.next();
			
			if(!check(num, user)) {//  오답상황이라면, -> 종료조건
				System.out.println("오답입니다...");
				break;
			}
			else { 
				System.out.println("정답입니다!");
			}
			
			
//			if(check(num, user)) {//만약에 정답상황이라면 (얘도 플래그를 쓸 수 있음) 정답상황이니? 
//				System.out.println("정답입니다!");
//			}
//			else {//아니라면
//				System.out.println("오답입니다...");
//				break; // 오답이니? 브레이크가 if문 안에 있기 땜문에 바꿔써도 됨
//			}
		}
		if(i==LV) {//3번다 정답이라면
			System.out.println("이름입력) ");
			String name=sc.next();
			System.out.println(name+"님, 축하합니다!~~");
		}
		
	}
}
