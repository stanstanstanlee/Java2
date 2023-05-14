package class06;

public class Test02 {
	public static void main(String[] args) {
		
		int data = 10;
		int x = 10;
		int y;
		
		y = ++x;
		System.out.println("1. x = " + x);
		System.out.println("1. y = " + y);
		System.out.println("-------------");
		y = x++;
		System.out.println("2. x = " + x);
		System.out.println("2. y = " + y);
		
		System.out.println("3. x = " + x);
		System.out.println("3. y = " + y); 
		
		System.out.println("1. data = " + data);
		 
		data++;
		System.out.println("2. data = " + data);
		
		++data;
		System.out.println("3. data = " + data);
	}
}
