package day01HW;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		/*
		 * 2. 나이가 저장된 변수가 있습니다. 
		 * 나이가 8살~19이면 1000원 20~65이면 2000원 
		 * 나머지는 무료! 라고 출력해주세요
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나이 입력 :");
		int age = sc.nextInt();
		
		if (age >= 8 && age <=19) {
			System.out.println("1000원");
		} 
		else if (age >=20 && age<=65) {
			System.out.println("2000원");
		} 
		else {
			System.out.println("무료!");
		}
		
		
		
		
		
	}
}
