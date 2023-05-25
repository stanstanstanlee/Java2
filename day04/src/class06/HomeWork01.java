package class06;

import java.util.Scanner;

public class HomeWork01 {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		//a, b 증감 변수 생성
		int a = 0;
		int b = 0;
		int cnt= 0;
		for(int i = 0; i<10; i++) { //정수를 10번 입력 예정
			System.out.println((i+1)+"번 정수를 입력 해 주세요 : ");
			int num = sc.nextInt();
			
			if(num==0) { //0이 입력되면 프로그램 종료
				break;
			}
			if(num%2==0) { //혹시 짝수야? 
				a++;
			} 
			if(num<0) { //혹시 음수야?
				b++;
			}
			cnt++;
		}
		//출력
		System.out.println(cnt+"번 입력 완료했습니다. "+"a=" +a+",\t"+"b="+b+"입니다.");
	
	}
}
