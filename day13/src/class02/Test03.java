package class02;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		//정상적인 입력을 3번할때까지 계속 
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> data = new ArrayList<>();
		
		
		while(data.size()<2) {
			for(int i=0;i<3;i++) { //정수를 입력 하든 말든 일단 3번 
				try {
					System.out.println("정수입력 : ");
					int num=sc.nextInt();
					System.out.println("num = " + num);
					data.add(num);
				}
				catch(InputMismatchException e) {//예외들(exception)들도 클래스임
					sc.nextLine(); //버퍼에 남아있는 쓰레기값을 제거하는 코드
					System.out.println("정수로만 입력하셔야합니다");
				}
			}
			if(data.size()==2) {
				break;
			}
		}
	}
}
