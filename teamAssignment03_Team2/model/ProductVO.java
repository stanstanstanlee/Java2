package model;

public class ProductVO {
	// 1. 멤버 변수
	private int num; // 제품 번호
	private String name; // 제품 이름
	private int price; // 제품 가격
	private int cnt; // 제품 재고
	
	// 2. 생성자
	public ProductVO (int num, String name, int price, int cnt) {
		this.num=num;
		this.name=name;
		this.price=price;
		this.cnt=cnt;
	}
	
	// 3. 메서드
	
	// 	getter,setter
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

	// 	toString 오버라이딩
	@Override
	public String toString() {
		String msg = num+". "+name+" "+price+"원 ";
		if (this.cnt == 0) {
			msg+= "[ 품 절 ]";
		}else {
			msg+= "[ "+this.cnt+"개 ]";
		}
		return msg;
	}

	@Override
	public boolean equals(Object obj) {
		   ProductVO drinkVO=(ProductVO)obj;
	        if(this.num==drinkVO.num) {
	            return true;
	        }
	        return false;
	}
	
	
}
