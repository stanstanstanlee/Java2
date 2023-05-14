package class01;

public class Test01 {
	
	public static void main(String[] args) {
		
		for(int a = 0; a<3; a++) { //가로로 몇번찍을지 몰라도 세로로 3번찍는건 확실 하다 
			for(int i = 0; a+i<2; i++) { //+ or ++ or NA 반복 하긴 할건데 몇번할지 몰라 
				System.out.print(" ");
			}
			for(int j=0; j<(2*a)+1; j++) {
				System.out.print("*"); // +보다는 뒤에 있지만 줄바꿈 보다는 전에 있기때문에 이 자리
			}
			
			System.out.println();
		}
		
/*


++*    
+***  
*****
	
	
 */
		
	}
}






