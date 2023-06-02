package ctrl;

import java.util.ArrayList;

import model.ProductDAO;
import model.ProductVO;
import view.AdminView;
import view.ClientView;

// 컨트롤러에서는 dao 와 view만 사용하여
// M과 V를 왔다갔다 해줄 수 있게 하는 공간
public class ProductCtrl {
	// 1. 멤버 변수
	private ClientView client;
	private AdminView admin;
	private ProductDAO dao;

	// 2. 생성자
	public ProductCtrl () {
		this.client = new ClientView();
		this.admin = new AdminView();
		this.dao = new ProductDAO();
	}

	// 3. 메서드
	// 출력할 상품이 없으면 멘트 출력.
	// 있으면 프로그램 실행 멘트 출력하고 상품 한번 출력해줘.
	public boolean runAdmin (int action) {
		ArrayList<ProductVO> pdatas=dao.selectAll(null); // selectAll로 pdatas에 저장
		boolean flag = admin.printListStart(pdatas);    // clientview에서 상품목록 리스트 여부 반환
		if(!flag) {
			admin.printListFail(action);
			return true;
		}else {
			admin.programStart(action);
			admin.printList(pdatas);
		}
		return false;
	}
	public boolean runClient (int action) {
		ArrayList<ProductVO> pdatas=dao.selectAll(null); 
		boolean flag = client.printListStart(pdatas);
		if(!flag) {
			client.printListFail(action);
			return true;
		}else if (action == 1 || action == 2){ //상품목록출력, 구매하기
			client.programStart(action);
			client.printList(pdatas);
		}else {// 이름검색, 가격검색은 리스트 보여줄 필요 없음!
			client.programStart(action);
		}
		return false;
	}
	public void startApp () {

		while(true) {
//			System.out.println("로그: 사용자가 새로 입장합니다.");
			ArrayList<ProductVO> cart=new ArrayList<ProductVO>(); // 장바구니 장바구니=초기화;
			while(true) {
				client.printCMenu(); // 프로그램 출력
				int action = client.getCNum();
				if(action == 1) { // 상품목록출력
					if(runClient(action)) {
						continue;
					}
				}
				else if(action == 2) { // 구매하기
					// 상품목록 출력
					if(runClient(action)) {
						continue;
					}
					// 구매할 상품 번호 받기 했는데 실패하면 1;
					int num = client.getCProdNum(); // view 에서 상품번호 입력값 받아옴
					ProductVO vo = new ProductVO(num, "구매", 0, 0); // 묶음으로 처리해서 보낼예정, 이름 "구매"
					int resNum = dao.update(vo); // update에 vo 로 전달
					if(resNum==1) { // 1이 나오면
						client.buyFailNum(); // 실패문구 띄우고
						continue; // 컨티뉴로 처음으로 돌림
					} 
					// 구매할 상품 개수 받기
					int cnt = client.getCProdCnt();
					vo = new ProductVO(num, "구매", 0, cnt);
					int resCnt = dao.update(vo); 
					if(resCnt==2) {
						client.buyFailCnt();
						continue;
					}
					// 받을 돈 입력 받기
					int money = client.getCProdPrice();
					vo = new ProductVO(num, "구매", money, cnt);
					boolean flag = client.getAns(vo);
					if (flag) {
						int res = dao.update(vo);
						if(res == 0) {   // 구매 성공
							ProductVO vo2 = dao.selectOne(vo); // 같은거 찾아서 vo2에 저장
							vo2.setCnt(cnt); // cnt만 내가 구매한 갯수로 변경
							boolean flag2 = false; // 산거 있는지 확인용
							int index=0;
							for(int i=0;i<cart.size();i++) {
								if(vo2.equals(cart.get(i))) {
									index=i;
									flag2=true;
								}
							}
							if (flag2){ 
								cart.get(index).setCnt(cart.get(index).getCnt()+cnt); // 중복값이면 재고추가
							}
							else {
								cart.add(vo2); // 장바구니.add(내가 구매한 상품);
							}
							client.printListCart(cart);
							client.buyEnd();

						}else if(res == 3){ // 낼 돈이 총가격보다 적으면
							client.buyFailPrice(); // 돈이 부족합니다.
						}
					}
					else {
						client.buyFail(); // 대답에 다른거 눌렀을때
					}
				}
				else if(action == 3) { // 상품 이름으로 검색하기
					if(runClient(action)) {
						continue;
					}
					String name=client.getSearchContent();
					// 사용자에게서 검색어를 받아와서 아래에 넣어줌
					ProductVO pVO=new ProductVO(0,name,0,-1); // 이름 검색은 vo.getCnt를 -1로 약속
					ArrayList<ProductVO> pdatas=dao.selectAll(pVO);
					boolean flag = client.printListStart(pdatas);
					if(!flag) {
						client.printListFail(action);
					}else {
						client.printList(pdatas);
					}
				}
				else if(action == 4) { // 상품 가격으로 검색하기
					if(runClient(action)) {
						continue;
					}
					ProductVO pVO=client.getSearchFilter();
					ArrayList<ProductVO> pdatas=dao.selectAll(pVO);
					boolean flag = client.printListStart(pdatas);   // clientview에서 상품목록 리스트 출력하는 기능 호출
					if(!flag) {
						client.printListFail(action);
					}else {
						client.printList(pdatas);
					}
				}
				else if(action == 5) { // 프로그램 종료
					client.programStart(action);  // 프로그램 종료 멘트
					break;
				}
				else if(action == 1234) { // 관리자모드
					System.out.println();
					while(true) {
						admin.printAMenu();   // 관리자모드 메뉴출력
						action = admin.getANum();
						if(action == 1) {  // 상품 추가
							admin.programStart(action);
							String name=admin.getAProdName();
							int price=admin.getAProdPrice();
							int cnt=admin.getAProdCnt();
							ProductVO vo=new ProductVO(0,name,price,cnt); 
							boolean flag = admin.getAns(vo); // 잘 입력 했는지 확인하기
							if(flag) {
								if(dao.insert(vo)) {
									admin.insProdEnd(); // 상품 추가 완료 멘트
									continue;
								}   
							}                     
							admin.insProdFail(); // 상품 추가 실패
						}
						else if(action == 2) { // 상품 재고 변경
							if(runAdmin(action)) {
								continue;
							}
							int num = admin.getAProdNum();
							ProductVO vo=new ProductVO(num,"재고변경",0,0); // 이름을 "재고변경"으로 세팅
							if(dao.update(vo) == 5 ) {
								admin.setCntFailNum(); // 일치하는 번호 없을때
								continue;
							}
							int cnt = admin.getAProdAddCnt();
							vo=new ProductVO(num,"재고변경",0,cnt);
							boolean flag = admin.getAns(vo);
							if(flag) {
								if(dao.update(vo) == 4) {
									admin.setCntEnd();
									continue;
								}
							}
							admin.setCntFail(); // 재고 변경 실패
						}
						else if(action == 3) { // 상품 삭제 하기
							if(runAdmin(action)) {
								continue;
							}
							int num=admin.getAProdNum();
							ProductVO vo=new ProductVO(num,null,0,0);   // 이름을 "null"로 세팅
							ProductVO vo2=dao.selectOne(vo);
							if(vo2==null) {
								admin.delProdFailNum();
							}else {
								boolean flag = admin.getAns(vo);
								if(flag) {
									if(dao.delete(vo)) {  
										admin.delProdEnd(); 
										continue;
									}
								}
								admin.delProdFail();
							}
						}
						else if(action == 4) {  // 관리자모드 종료
							admin.programStart(action);   // 관리자모드 종료 멘트
							break;
						}
					}
				}
			}
//			System.out.println("로그 : 사용자가 나갑니다");
			cart.clear();
		}
	}
}