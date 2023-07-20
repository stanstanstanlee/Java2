package test;
//Bean 클래스
// : 기능을 구현한 클래스
public class CalcBean {
	int num1;
	int num2;
	String op;
	int result;
	//웹에서는 특이한 일이 있지 않은 이상 기본 생성자를 활용합니다
	
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
		
	public void calculate() {
		if(this.op==null) {
			this.op="";
		}
		if(this.op.equals("+")) {
			this.result=this.num1+this.num2;
		}
		else if(this.op.equals("-")) {
			this.result=this.num1-this.num2;
		}
	}
	
}
