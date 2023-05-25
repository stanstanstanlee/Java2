package model;

import java.util.ArrayList;

//* DAO 도 main만드는 것에 관심 없음 
//* CRUD(비즈니스 메서드, 핵심로직)
//* PK는 사용자로부터 입력받으면 안됨 !!!!
//ID를 입력받을수는있으나, "중복검사"를 함! 
//시스템에서 int값을 부여해야함!!!!!
public class ProductDAO {

	//[멤버변수]
	private ArrayList<ProductVO> datas;//<<== 이것이 모델이 가진 데이터
	private static int PK = 1001;

	//[생성자]

	public ProductDAO() { //생성자
		this.datas=new ArrayList<ProductVO>(); //멤버변수 초기화 //객체화
		this.datas.add(new ProductVO(PK++,"아메리카노",10,1500));
		this.datas.add(new ProductVO(PK++,"라떼",10,2000));
		this.datas.add(new ProductVO(PK++,"버블티",10,3000));
	}

	//[메서드]

	// C : 상품추가
	public boolean insert(String name, int cnt, int price) {
		this.datas.add(new ProductVO(PK++, name, cnt, price)); //PK는 시스템에서 부여하기 때문에 인자에 없음 
		return true;
	}	


	// R : 목록 출력 

	public ArrayList<ProductVO> selectAll() {
		return this.datas;
	}
	
	// U 
//		: 구매 
//		기능 : 사용자가 구매선택 입력후 구매할 상품번호 입력; 
//			구매할 개수 입력;
//			
//		INTPUT : int num(상품번호); int cnt
//		OUTPUT : boolean
		public boolean update (int num, int cnt) {
				for(int i=0;i<this.datas.size();i++) {
					if(this.datas.get(i).getNum()==num) {
//						int totalPrc = cnt*(this.datas.get(i).getPrice());
						
						int cntTmp = cnt;//제고 업데이트
						int cntAfter = this.datas.get(i).getCnt()-cntTmp; 
						this.datas.get(i).setCnt(cntAfter);
						return true;
					}
				}
				System.out.println("  로그: model: ProductDAO: update(): 구매할 수 있는 상품이 없습니다!");
				return false;
		}	
	
	// D : 삭제
//	기능 : 사용자가 삭제선택 입력후 삭제할 상품번호 입력; 
//	INTPUT : int num(상품번호)
//	OUTPUT : boolean
	public boolean delete(int num) {
		for(int i=0;i<this.datas.size();i++) {
			if(this.datas.get(i).getNum()==num) {
				this.datas.remove(i);
				return true;
			}
		}
		System.out.println("  로그: model: StudentDAO: delete(): 삭제학 상품번호가 없습니다!");
		return false;
	}

	
}
