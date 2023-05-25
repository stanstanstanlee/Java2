package class02;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03Answer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//
//		for(int i=0;i<3;i++) { //정수를 입력 하든 말든 일단 3번 
//			try {
//				System.out.println("정수입력 : ");
//				int num=sc.nextInt();
//				System.out.println("num = " + num);
//			}
//			catch(InputMismatchException e) {//예외들(exception)들도 클래스임
//				sc.nextLine(); //버퍼에 남아있는 쓰레기값을 제거하는 코드
//				System.out.println("정수로만 입력하셔야합니다");
//			}
//		}
//	
	
		//정상적인 입력을 3번할때까지 계속 
		int cnt=0;
		while(cnt<3) {
			try {
				
				System.out.println("정수입력 : ");
				int num=sc.nextInt();
				System.out.println("num = "+num);
				
				cnt++;
			}
			catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("정수로만 입력");
			
			}
		}
	
	
	
	
	}
}
