package class06;

public class Test02 {
	
	public static void func(int b) {
		b = 100;
		System.out.println("func()입니다. b= "+b);
	}
	
	public static void main(String[] args) {
 
		int a=10;
		System.out.println("a= " + a);
		func(a);
		System.out.println("a= " + a);
		func(++a);
		System.out.println("a= " + a);
	}
}
