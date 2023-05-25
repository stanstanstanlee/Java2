package class06;

import java.util.Random;

/*	유형 4
 연습문제1)
 1. abs()라는 함수가 있습니다
 2. 정수를 넣으면, 넣은 정수의 절대값을 반환해주는 기능을 수행합니다 // input, output, 기능
 3. 해당함수를 선언(정의)해주세요
 */
public class Test05 {
	
	public static int abs(int num) {
		if(num<0) { //음수야? 
			num*=(-1);
		}
		return num;
	}
	
	public static void test1() { // ★ "메소드 시그니처" 가 가장 중요 ★
		Random rand = new Random();
		int num=rand.nextInt(11)+10;  //10~20
		System.out.println("랜덤수: " + num);
		int sum=0;
		for(int i=1; i<=num;i++) {
			sum+=i;
		}
		System.out.println("총합: " + sum);
	}
	
	public static int test2(int num) {
		int cnt = 0;
		for(int i=1; i<=num;i++) {
			if(i%2==0) {
				cnt++;
			}
		}
		return cnt;
	
	}

	public static String test3(int num) {
		String msg = "apple";
		if(num<=10) {
			msg = "banana";
		}
		return msg;
//		if(num>10) {
//			return "apple";
//		}
//		else {
//			return "banana";
//		}
	
	}
	
	public static void main(String[] args) {
		test1();
		int cnt = test2(15);
		System.out.println("cnt= " + cnt);
		System.out.println(test3(7));
	}
}
