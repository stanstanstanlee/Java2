package class06;

public class Test03 {
	
	public static void printGrade(int score) {
		
		if(score>=80 && score<=100) {
			System.out.println(score+"점은 A등급입니다");
		}
		else if(score>=60&&score<=79) {
			System.out.println(score+"점은 B등급입니다");
		
		}else if(score>=0&&score<=59) {
			System.out.println(score+"점은 C등급입니다");
		}else System.out.println("잘못된점수입니다");
	}
	
	public static void main(String[] args) {
		int score = -100;
		printGrade(score);
	}
}
