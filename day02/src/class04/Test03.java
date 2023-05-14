package class04;

public class Test03 {

	public static void main(String[] args) {
/*	
		// 1. a=5,b=3
		// 작은수부터 큰수까지 출력해주세요
		// 3 4 5
		int a = 5;
		int b = 3;
		if(a>b) {
			int tmp =a;
			a=b;
			b=tmp;
		}
		for(int i = a;i<=b;i++) {
			System.out.print(i);
		}
*/	
		// 1. 출력문구가 반복되네? 반복문써야지!
		// 2. while VS for
		// for : a부터 b까지 "범위"
		// 3. 반목문을 썼으니까, "조건식"
		// 4. a가 무조건 작아! --> 교환 알고리즘
		//	  OR min, max 설정하기
		
		// 2.a=1,b=10
		// 작은수부터 큰수까지 출력해주세요
		// 1 3 5 7 9 
		
		int a = 1;
		int b = 10;
		if(a>b) {
			int tmp = a;
			a=b;
			b=tmp;
		}
		// 1. 홀수일때 출력해!
		// 2. 짝수일대 출력하지마!!! --->> continue
		for(int i = a; i <=b; i++) {
			if(i%2==0) {
				continue; //반복수행자체는 유지하되, 이 아래로는 수행하지마! 
				// == "즉시" 반복문의 처음으로 이동
			}
			System.out.print(i+" ");
		}
		System.out.println();
		// 3. 1부터 100까지 총합을 출력해주세요

		// 1) 주어진 것 == 데이터
		// 2) output을 생성(정의)
		int s = 1; //start
		int e = 100; //end
		int sum = 0;;
		
		// 3) 내가 해야하는 문장을 작성 ---->> 반복되는 문장을 찾음!!
		// for : 범위가 주어져있기때문에!
//		sum = sum+(s+0);
//		sum = sum+(s+1);
//		sum = sum+(s+2);
		
		for(int i = s; i <= e; i++) {
			sum+=i;
		}
		System.out.println(sum);
		//내답: 
//		1.
//		int a = 5;
//		int b = 3;
//		int min=a>b?b:a;
//		int max=a>b?a:b;
//		
//		for(int i = min; i <= max; i++) {
//			System.out.print(i+" ");
//		}
//		2.
//		int a = 1;
//		int b = 10;
//		int min=a>b?b:a;
//		int max=a>b?a:b;
//		
//		for(int i = min; i <= max; i++) {
//			if(i%2!=0) {
//			System.out.print(i+" ");
//			}
//		}
//		3.
//		int tmp = 0;
//		
//		for(int i = 1; i<=100; i++) { // for(int i = 0; i<=100; i++) 과 결과는 같지만 수행횟수가 1개가 적기 때문 더 좋다
//			tmp+=i;
//		}
//		System.out.println(tmp);
		   
	}
	
}
