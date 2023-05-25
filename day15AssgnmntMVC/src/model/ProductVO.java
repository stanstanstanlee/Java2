package model;
/*
※※ProductVO※※ //음료상품 데이터 그 자체를 의미함
VO도 main만드는 것에 관심 없음 
멤버변수+getter,setter
 toString() 오버라이딩
 생성자(오버로딩)

[멤버변수]
private int num; //PK상품번호
private String name; //상품이름
private int price; //상품가격
private int cnt; //상품제고

[생성자]

[getter, setter]

[메서드]
@Override
public String toString() {
	return this.num + "번 상품 '" + this.name + "' [" + this.cnt +"] 개 , '"+ price+"원'";
}
*/
public class ProductVO {
	//[멤버변수]
	private int num; //PK상품번호
	private String name; //상품이름
	private int price; //상품가격
	private int cnt; //상품제고
	//[생성자]
	public ProductVO(int num, String name, int cnt, int price) {
		this.num=num;	//초기화
		this.name=name;
		this.price=price;
		this.cnt = cnt; 
		System.out.println(this.name + "상품 생성 완료!");
	}
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
	@Override
	public String toString() {
		return this.num + "번 상품 '" + this.name + "' [" + this.cnt +"] 개 , '"+ this.price+"원'";
	}
	
}
