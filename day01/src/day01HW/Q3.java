package day01HW;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		/*
		 3. 3시 30분의 1시간 20분 전 시간은 2시 10분입니다. 
		int a = 3;
		int b = 30;

		int a = 1;
		int b = 10;
		--->>1시 10분의 1시간 20분 전 시간은 11시 50분입니다. 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int hr = 0;
		int min = 0;
		int hr2 = 0;
		int min2 = 0;
		
		System.out.println("시 : ");
		hr = sc.nextInt();
		System.out.println("분 : ");
		min = sc.nextInt();
		
		
		hr2 = (hr - 1);
		min2 = (min - 20);
		
		System.out.println(hr2);
		System.out.println(min2);
		
		if(min2 < 0) {
			min2 = 60 + (min - 20);
			hr2 = hr - 2;
			
			if(hr2 <= 0) {
				hr2 = 12 - 1;
			}
		}
		
		System.out.println(hr + "시 " + min + "분의 1시간 20분 전 시간은 " + hr2 + "시 " + min2 + "분 입니다");
		
		
	}
}
