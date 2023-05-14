package day01HW;

import java.util.Scanner;

public class Q1 {

	public static void main (String[] args) {
		
		/*
		 * 1. 월이 저장된 데이터(==변수)가 있습니다. 3,4,5 -> 봄 6,7,8 -> 여름 9,10,11 -> 가을 12,1,2, -> 겨울
		 * 이라고 console에 출력해주세요
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("월 입력 : ");
		int mo = sc.nextInt();
		
		if(mo == 3 || mo == 4 || mo == 5) {
			System.out.println("봄");
		} 
		else if (mo == 6|| mo == 7 || mo == 8) {
			System.out.println("여름");
		}
		else if (mo == 9 || mo == 10 || mo == 11) {
			System.out.println("가을");
		}
		else if (mo == 12 || mo == 1 || mo == 2){
			System.out.println("겨울");
		}
		else {
			System.out.println("잘못된 월 입니다");
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
