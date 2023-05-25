package class06;

import java.util.Random;
import java.util.Scanner;

public class Test06 {
	

	
	public static void test1() {
		Random rand = new Random();
		int num = rand.nextInt(11)+10;
		int res = 0;
		System.out.println(num);
		for(int i=1; i <= num;i++) {
			res += i;
		}
		System.out.println(res);
	}
	
	public static void test02() {
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int count = 0;
		for(int i=1; i<num;i++) {
			 
		}
	}
	
	public static void main(String[] args) {
		test1();
	}
}
