package class01;

public class Test03 {
	public static void main(String[] args) {
		/*
		 3시 30분의 1시간 20분 전 시간은 2시 10분입니다. 
		int a = 3;
		int b = 30;
		
		int a = 1;
		int b = 10;
		--->>1시 10분의 1시간 20분 전 시간은 11시 50분입니다. 
		 */
		
		int h=1;
		int m=10;
		
		System.out.println(h+"시 "+ m+"분의 1시간 20분전 시간은");
		
		h--;
		m-=20; //m=m-20' m-=20; 복합대입연산자
		
		if(m<0) {
			m+=60; //노코스트가 아님; 3시 10분의 1시간 20 분 전은 == 1시 50분 
			h--;
		}
		
		if(h<1) {
			h+=12;
		}
		System.out.println(h+"시 " + m + "분입니다.");
	}
}












