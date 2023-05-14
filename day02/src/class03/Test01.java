package class03;

// 한 소스코드내에서는
// 유사한 코드가 없도록 작성해보자!!!!!
public class Test01 {
	public static void main(String[] args) {
		
		//a랑 b가 숫자를 몇번출력 할지를 알지 개발자는 모름 그니까 while
		
		int a=10; // 세로줄이 가독성이 좋음
		int b=9;
				
//		if(a<=b) { //a가 작은수 일때
//			int i=a; // 어디서부터 어디까지: 작은수 부터 큰 수 까지
//			while(i<=b) { //
//				System.out.print(i+" "); //'숫자'를 i로 변수화 진짜 숫자가 나와야 하니까
//				i++;
//			}
//		}
//		else { //b가 작은수 일때
//			int i=b;
//			while(i<=a) {
//				System.out.print(i+" ");
//				i++;
//			}
//		}
		
		//repetitiveness를 없애려고 변수를 추가해주는 방식
//		int min=a>b?b:a;
//		int max=a>b?a:b;
		
//	      int i=min;
//	      while(i<=max) { 
//	         System.out.print(i+" ");
//	         i++;
//	      }

		
		// 항상 a가 b보다 작을수있도록
		// "교환 알고리즘"을 활용!
		if(a>b) {//a와 b의 값을 교환해줘!
			int tmp = a; //"임시저장변수"
			a=b;
			b=tmp;
		}
		
		int i=a; 
		while(i<=b) { 
			System.out.print(i+" "); 
			i++;
		}
			
		
	}
}
