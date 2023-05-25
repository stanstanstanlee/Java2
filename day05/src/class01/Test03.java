package class01;

public class Test03 {
	public static void func1(int num) {
		num +=100; //num = num + 100
	}
	public static int func2(int num) {
		return num--;
	}
	public static void func3(int[] data) {
		//함수를 호출할대에 인자로 배열을 사용하는경우,
		// (배열 특성상 주소값이 이동하기때문에)
		// 참조에 의한 호출(call by reference) 
		for(int i=0; i<data.length;i++ ) {
			data[i]=123; // [ 123, 123, 123]
					//index	   0    1    2
		}
	}
	public static void main(String[] args) {
		int num = 10;
		int[] data = new int[3];
		for(int i =0;i<data.length;i++) {
			data[i]=i+1; // [ 1, 2, 3 ]
		}
		func1(num);// 
		System.out.println("num1 = " +num);
		num=func2(num); // 
		System.out.println("num2 = " + num);
		func3(data); // <-- [ 123, 123, 123]
		System.out.print("[ ");
		for(int v:data) {
			System.out.print(v+ " ");
			// [ ?, ?, ?]
		}
		System.out.println("]");
	}
}
