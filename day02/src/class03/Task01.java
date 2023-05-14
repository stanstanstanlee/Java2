package class03;

public class Task01 {
	public static void main(String[] args) {
		/*
		 a부터 b까지 출력해주세요!~~
			a=33
			b=29
			29 30 31 32 33
			--> "무한루프를 활용해서" 풀어보세용^^
		 */
	
		int a = 12;
		int b = 21;
			
		if(b>a) {//a와 b의 값을 교환해줘!
			int tmp = a; //"임시저장변수"
			a=b;
			b=tmp;
		}
		
		int max = a;
		int min = b;
		
		while(true) {
			System.out.print(min+" ");
			min++;
			if (min>max) {
				break;
			}
		} 
	
		

	}
}
