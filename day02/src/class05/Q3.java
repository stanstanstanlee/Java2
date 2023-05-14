package class05;

public class Q3 {
	public static void main(String[] args) {
		for(int a = 0; a <3; a++) {
			for(int i = 0; i<2-a; i++) {
				System.out.print(" ");
			}
			for(int i = 0; i<(2*a)+1; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
