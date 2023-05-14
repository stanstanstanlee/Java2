package class05;

public class Test03 {
	public static void main(String[] args) {
/*	
		for(int a=0;a<5;a++) {
			for(int i = 0; i<5;i++) {
				if(a>i) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
			
		}
*/
		
		for(int a=0; a<5; a++) {
			for(int i =0; i < a; i++) {
				System.out.print("+");
			}
			for(int i = 0; i<5-a; i++) {
				System.out.print("*");
			}
			System.out.println();
		}

	
		
		
		
		
	}
	
}
