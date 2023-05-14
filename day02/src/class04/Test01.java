package class04;

public class Test01 {
	public static void main(String[] args) {
		
		int a = 37;
		int b = 22;
		
		//삼항연산자 
//		int num = a>b ? b : a;// 최소값
		
		//교환
		if(a>b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		int num = a;
		while(true) {
			System.out.print(num+" ");
			num++;
			
			if(num>b) {
				break;
			}
		}
	}
}
