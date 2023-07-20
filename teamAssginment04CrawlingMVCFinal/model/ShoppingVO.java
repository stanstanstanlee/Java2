package model;
/*
 */
public class ShoppingVO {
	//[멤버변수]
	private int num; //1001번 번호(PK)          
	private String name; //이름 -> 크롤링해서 받아올것   
	private int price; //가격 -> 크롤링해서 받아올것   
	private int cnt; //구매횟수 -> 처음값 0   
	//[생성자] 
	//맴버변수 초기화 
	public ShoppingVO (int num, String name, int price, int cnt) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}

	//[메서드]
	//- getter / setter

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	//기능 : 쇼핑물 상품 이름과 구매횟수 출력 
	//INPUT : 없음
	//OUTPUT : 없음
	@Override
	public String toString() {
		return this.num+"번 상품 "+this.name+"의 가격 :"+this.price+"원 구매횟수 :"+this.cnt;
	}

}
