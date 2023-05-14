package day01HW;

public class Q3_2 {
	public static void main(String[] args) {
		
		int hr = 1;
		int min = 10;
		
		int hr2 = 0, min2 = 0;
		
		hr2 = (hr - 1);
		min2 = (min - 20);
		
		System.out.println(hr2);
		System.out.println(min2);
		
		if(min2 < 0) {
			min2 = 60 + (min - 20);
			if (hr2 <= 0) {
				hr2 = 12 - 1;
			}
		}
		
		System.out.println(hr2);
		System.out.println(min2);
		
	}
}
