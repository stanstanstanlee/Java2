package test;
//db받아오고 set하는거 다 생략
//세팅은 끝났고 getter로 다 받아올거당
public class ProductBean {
	private String[] pdatas= {"apple","banana","kiwi","hong","test"};
	
	private int num1=100;
	private int num2=30;
	
	public String[] getPdatas() {
		return pdatas;
	}
	public int getNum1() {
		return num1;
	}
	public int getNum2() {
		return num2;
	}
	
	
	
}
