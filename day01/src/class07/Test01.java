package class07;

public class Test01 {
	public static void main(String[] args) {
		
		int data = 10>5 ? 1 : 2;
		System.out.println(data);
		
		/*
		 * int a=100; int b=200; a와 b를 비교하여 더 큰 수를 console에 출력해주세요~~
		 * 
		 * -------------------------------------------
		 * 
		 * int c=9; c가 짝수라면 'E' , 홀수라면 '0'를 console에 출력할수있도록 코딩해주세요~~ Hint) 정수를 2로 나누었을때
		 * 나머지가 0이 되면 짝수입니다~~~
		 */
		
		/*
		 * 내답 : 
		int a = 200;
		int b = 200;
		
		System.out.println(a>b ? a : b);
		System.out.println( (a > b) ? a : (a < b) ? b : "두수가같다");
		
		int c = 9;
		
		System.out.println(c%2==0 ? 'E' : 'O');
		*/
		//////////////////////////////////////////////
		
		//정답 : 
		System.out.println("-------------------------");
		int a = 100;
		int b = 200;
		int res = a>b ? a:b; //정답을 저장할 변수
		System.out.println(res);
		
		//////////////////////////////////////////////
		System.out.println("-------------------------");
		
		int c = 10;    
		//스도코딩 --> char res2 = c가 짝수니? 'E' : 'O';
		char res2 = c % 2 == 0 ? 'E':'O';
		char res3 = c%2 != 1 ? 'E' : 'O';
		System.out.println(res2);
		System.out.println(res3);
		
		
	}
}
