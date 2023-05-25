package class01;

import java.util.Random;
import java.util.Scanner;

//한번은 넘어야 하는 산
// 369게임 1,2번 풀이
public class Test03ThreeSixNineGameReview {
	//[1]번 방식
	// input: 정답과 사용자의 입력값을 알려주면
	// output: 맞췄는지 틀렸는지를 반환
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
// 		스도코딩이 완료되었어야 코드로 생성 할 수 있는 겁니다 
		// int num
		// 1~1000중에서 랜덤으로 정수 1개 생성
		// syso("[num] : ") 방금만든에를 보여주고
		// 사용자가 입력을 시도함 짝, 숫자 입력해야하니 String
		// 		-> String user
		// if(정답상황이라면,)
		// 		syso("정답")
		// else 
		// 	    syso("오답")
		Scanner sc=new Scanner(System.in);
		Random rand = new Random();
		int num=rand.nextInt(1000)+1;
		System.out.println("["+num+"] : ");
		String user=sc.next();
		
		if(check(num, user)) {//만약에 정답상황이라면 (얘도 플래그를 쓸 수 있음) 정답상황이니? 
			System.out.println("정답입니다!");
		}
		else {//아니라면
			System.out.println("오답입니다...");
		}
		
		
		
	}
}
