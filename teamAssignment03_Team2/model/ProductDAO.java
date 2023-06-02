package model;

import java.util.ArrayList;

public class ProductDAO {
	// 1. 멤버 변수
	private static int PK=1;
	private ArrayList<ProductVO> datas;

	// 2. 생성자
	public ProductDAO() {
		datas=new ArrayList<ProductVO>();
	}
	// 3. 메서드
	//3-1. INSERT
	public boolean insert(ProductVO vo) {
		datas.add(new ProductVO(PK++,vo.getName(),vo.getPrice(),vo.getCnt()));
		return true;
	}
	//3-2. SELECT ALL
	public ArrayList<ProductVO> selectAll(ProductVO vo) {
		if(vo==null) {
			return this.datas;
		}
		// 이름 검색
		else if (vo.getCnt()== -1) { // 컨트롤 부분에서 약속!
			ArrayList<ProductVO> pdatas =new ArrayList<ProductVO>();
			for(ProductVO data:datas) {
				if(data.getName().contains(vo.getName())) {
					pdatas.add(data);
				}
			}
			return pdatas;
		}
		// 가격 검색 (필터 검색)
		else if (vo.getName().equals("필터검색")) {
			ArrayList<ProductVO> pdatas =new ArrayList<ProductVO>();
			for(ProductVO data:datas) {
				if(vo.getPrice() <= data.getPrice() && data.getPrice() <= vo.getCnt()) {
					pdatas.add(data);
				}
			}
			return pdatas;
		}
		ArrayList<ProductVO> pdatas =new ArrayList<ProductVO>();
		return pdatas;
	}
	//3-3. SELECT ONE
	public ProductVO selectOne(ProductVO vo) {
		for(int i=0;i<datas.size();i++) {
			if(datas.get(i).getNum()==vo.getNum()) {
				ProductVO dVO= new ProductVO(datas.get(i).getNum(),datas.get(i).getName(),datas.get(i).getPrice(),datas.get(i).getCnt());
				return dVO;
			}
		}
		return null;
	}
	//3-4. UPDATE
	public int update(ProductVO vo) {
		if (vo.getName().equals("구매")) {
			for(int i=0;i<datas.size();i++) { // 배열 사이즈만큼 반복
				if(datas.get(i).getNum()==vo.getNum()) { // 번호 확인
//					System.out.println("log: 번호확인 통과");
					if(datas.get(i).getCnt()>=vo.getCnt()) { // 재고 확인 까지 통과되고 나면
//						System.out.println("log: 재고확인 통과");
						int total=datas.get(i).getPrice()*vo.getCnt();
						
						if(total<=vo.getPrice()) { // 금액 확인
//							System.out.println("log: 금액확인 통과");
							datas.get(i).setCnt(datas.get(i).getCnt()-vo.getCnt());
							return 0; // 구매 성공
						}
						return 3; // 실패 3. 낸돈이 부족할때
					}
					return 2; // 실패 2.재고가 갯수보다 적을때.
				}
			}
			return 1; // 실패 1. 번호 안맞을때
		}
		if (vo.getName().equals("재고변경")) {
			for(int i=0;i<datas.size();i++) {
				if(datas.get(i).getNum()==vo.getNum()) {
					datas.get(i).setCnt(datas.get(i).getCnt()+vo.getCnt());
					return 4; // 재고 변경 성공
				}
			}
			return 5; // 실패 1. 번호 안맞을때
		}
		return -1; // 구매, 재고변경 거치지 못할 때는 -1 반환
	}
	//3-5. DELETE
	public boolean delete(ProductVO vo) {
		for (int i=0;i<datas.size();i++) {
			if(datas.get(i).getNum()==vo.getNum()) {
				datas.remove(i);
				return true;
			}
		}
		return false;

	}








}
