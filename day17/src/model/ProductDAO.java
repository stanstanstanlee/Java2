package model;

import java.util.ArrayList;

// 목록출력,목록검색_이름,목록검색_가격순,목록검색_조회수
public class ProductDAO {
	private ArrayList<ProductVO> datas;
	private static int PK=1001;
	public ProductDAO() {
		datas=new ArrayList<ProductVO>();
		datas.add(new ProductVO(PK++,"장갑",12000,2));
		datas.add(new ProductVO(PK++,"화장지",1000,1));
		datas.add(new ProductVO(PK++,"장화",23000,0));
		datas.add(new ProductVO(PK++,"지갑",120000,1));
		datas.add(new ProductVO(PK++,"화분",5500,2));
	}

	public ArrayList<ProductVO> selectAll(ProductVO pVO){
		//높은 응집도를 위해
		//여러기능을 하나의 메서드에서 작성
		if(pVO==null) {
			
			return datas;
		}
		else if(pVO.getName().equals("필터검색")) {//searchCondition이 "필터"//이거 필터검색이야?
			//어! 
			ArrayList<ProductVO> mdatas=new ArrayList<ProductVO>();//그러면 반환해줄 배열 만들고
			//가격범위에 들어가는 데이터들을 추가해서
			for(ProductVO data:datas) {								//★maxPrice Cnt에 넣어놓았었음!
				if(pVO.getPrice() <=data.getPrice() && data.getPrice() <= pVO.getCnt()) {//가격범위에 들어가는 데이터야? 최저<= 내 가격 && 내 가격 <=최대
					mdatas.add(data);
				}
			}
			return mdatas;//반환해~
			
		}
		if(pVO!=null) {//pVO.getName()!=null//이름으로 검색중이니?!
			//상품목록출력을 할때에는 인자(pVO)가 null이므로
			//pVO가 null이 아니라면 '이름으로검색'임!
			ArrayList<ProductVO> mdatas=new ArrayList<ProductVO>();		//사용자가 입력한 이름을 가진 데이터를
			for(ProductVO data:datas) {//output(mdatas)에 저장해서
				if(data.getName().contains(pVO.getName())) {//사용자가 입력한 이름을 가진 데이터야?
					//pVO.getName() == 사용자가 검색한 단어

					mdatas.add(data);//mdatas에 저장해
				}
			}
			return mdatas;		//return outout하자!
		}
		return datas;
	}
	public ProductVO selectOne(ProductVO pVO){
		if(pVO.getName().equals("최고가")) {//지금 최고가 검색이야?
			int max=datas.get(0).getPrice();//ㅇㅇ
			int maxIndex=0;//최고가격을 찾는 알고리즘을 활용
			for(int i=1;i<datas.size();i++) {
				if(max<datas.get(i).getPrice()) {
					max=datas.get(i).getPrice();
					maxIndex=i;
				}
			}
			return datas.get(maxIndex);//최고가상품;
		}
		
		return null;
	}

	public boolean insert(ProductVO pVO) {
		return true;
	}
	public boolean update(ProductVO pVO) {
		return true;
	}
	public boolean delete(ProductVO pVO) {
		return true;
	}
}
