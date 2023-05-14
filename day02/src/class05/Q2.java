package class05;

public class Q2 {
	public static void main(String[] args) {
		for(int a = 0; a<5; a++) {
			for(int i = 0; i<4-a; i++) {
				System.out.print(" ");
			}
			for(int i = 0; i <=a; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
