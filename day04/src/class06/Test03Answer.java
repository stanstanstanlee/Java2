package class06;

public class Test03Answer {
	
	public static void printGrade(int score) {
		if(score<0 || 100<score) {
			System.out.println("점수가 유효하지않습니다! 확인이 필요합니다");
			return; // 합수를 즉시종료하겠습니다.
		}
		char grade='C';
		if(80<=score ) {
			grade='A';
		}
		else if(60<=score) {
			grade='B';
		}
		System.out.println(score+"점은 "+ grade+"등급입니다.");
	}
	
	public static void main(String[] args) {
		
		printGrade(-81);
		printGrade(88);
		printGrade(1);
		
	}
}
