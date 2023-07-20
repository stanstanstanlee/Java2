package model;

public class ProductVO {
	private int num;
	private String name;
	private int price;
	
	//생성자 오버로딩중
	public ProductVO() {//기본 생성자를 웹에서 디폴트로 사용하고 있기 때문에 반드시 추가해줘야 함  
		this(0,null,0);
	}
	
	public ProductVO(int num,String name,int price) {//DAO에서 사용중; datas.add(new ProductVO(101,"세제",23000));
		this.num=num;
		this.name=name;
		this.price=price;
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

	@Override
	public String toString() {
		return name+" : "+price+"원";
	}	
}
