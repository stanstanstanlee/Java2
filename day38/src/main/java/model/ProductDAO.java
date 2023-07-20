package model;

import java.util.ArrayList;

public class ProductDAO {
	//멤버변수
	private ArrayList<ProductVO> datas;
	public ArrayList<ProductVO> getDatas() {
		return datas;
	}
	//생성자[오버로딩]
	public void setDatas(ArrayList<ProductVO> datas) {
		this.datas = datas;
	}

	public ProductDAO() { //상품 직접 추가; ProductVO에서 오버로딩된 생성자 사용 
		datas=new ArrayList<ProductVO>();
		datas.add(new ProductVO(101,"세제",23000));
		datas.add(new ProductVO(102,"헛개수",1500));
		datas.add(new ProductVO(103,"우유",1100));
		datas.add(new ProductVO(104,"박카스",900));
		datas.add(new ProductVO(105,"닭가슴살",11700));
	}
	
	public ArrayList<ProductVO> selectAll(ProductVO pVO){
		return datas;
	}
	public ProductVO selectOne(ProductVO pVO) {
		for(ProductVO v:datas) {
			if(pVO.getNum()==v.getNum()) {
				return v;
			}
		}
		return null;
	}
}
