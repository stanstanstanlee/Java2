package controller;

import java.util.ArrayList;

import model.DrinkDAO;
import model.DrinkVO;
import view.DrinkView;

public class DrinkCtrl {
	private DrinkView view;
	private DrinkDAO dao;
	public DrinkCtrl() {
		view=new DrinkView();
		dao=new DrinkDAO();
	}
	/*★★★한 라인에 절대 model과 view가 함께 하지 않는다★★
	 * 
    사용자에게 메뉴화면을 보여주어야함
    메뉴화면을 본 사용자는 console에 사용할 메뉴를 입력
    C는 V에게 입력값을 받아서,
    어떤 M(기능)을 수행해야하는지 연결해줄예정

    만약에 음료주가를 사용자가 선택했다면,
    C는 M한테 음료추가를 부탁할 예정
    M은 음료추가(C,insert())를 하기위해-
    -음료의이름,음료의가격,음료의재고를필요로함
    C는 이런 M의 상황을 알고,
    V한테 부탁합니다.
    V는 이름,가격,재고를,순서대로 사용자에게 입력받아옴
    입력값 V->C 넘겨줌
    C는 입력값을 M한테 넘겨줌

    만약에 음료목록출력을 선택했다면,
    C가 M한테 R(selectAll())을 요첨함
    M은 selectAll()을 수행하고, 그 결과값을 C한테 줌 
    C는 결과값을 V한테 전달
    V는 받은값을 console화면에 출력

    만약에 구매를 선택했다면,
    V는 사용자한테 뭐살래? 물어봄
    사용자는 console에 번호입력
    V는 받은 번호를 C한테 줌
    C는 M한테 U(update())를 요청
    이때, 받은 번호를 M한테 전달함
    M은 U 수행결과를 T or F로 C에게 반환해줌
    그러면 C는 수행결과를 아니까,
    수행결과에 맞는 화면을 V에게 요청함

    만약에 삭제를 선택했다면,
    V는 사용자한테 뭐 삭제할래? 물어봄
    사용자는 console에 번호입력
    V는 받은 번호를 C한테 줌
    C는 M한테 D(delete())를 요청
    이때, 받은 번호를 M한테 전달함
    M은 D수행결과를 T or F로 C에게 반환해줌
    C는 수행결과를 아니까, 
    수행결과 맞는 화면을 V에게 요청함

    프로그램 종료
	 */
	public void startApp() {
		while(true ) {
			System.out.println("로그 : 사용자가 새로 입장합니다.");
			//로그
			// : 확인을 위한 것
			// : 실제 서비스에서는 출력 XXX
				//장바구니 장바구니; 사용자가 들어오면
				//음료 여러개 구매할때 Set을 쓰면 콜라 2개 콜라추가에서 콜라1개로 덮어씌움 
			ArrayList<DrinkVO> cart = new ArrayList<DrinkVO>();
			
			while(true) {
				int action=this.view.printMenu();
				//어떤 M(기능)을 수행해야하는지 연결해줄예정
				if(action==1) {//만약에 음료추가를 사용자가 선택했다면,
					String name=this.view.getDrinkName();
					int price=this.view.getDrinkPrice();
					int cnt=this.view.getDrinkCnt();
					DrinkVO vo = new DrinkVO(0, name, price, cnt); //안줘도 되는 값은 0, null
					// DAO의 CRUD에게 전달해야하는 값만 설정
					// 전달하지 않아도 되는 값들은 0, null 등으로 설정
					if(this.dao.insert(vo)){//  M은 음료추가(C,insert())를 하기위해-) 
						//-음료의이름,음료의가격,음료의재고를필요로함
						this.view.printTrue();
					} else this.view.printFalse();

					//입력값 V -> C , C -> M
				}else if(action==2) {
					ArrayList<DrinkVO> datas=dao.selectAll(new DrinkVO(0,null,0,0));
					view.printDrinkList(datas);

				}else if(action==3) { //재품을 구매하겠습니다 라고 할때에만 장바구니와 연관이 생김 

					int num=this.view.getDrinkNum();
					int cnt=view.getDrinkCnt();
					DrinkVO vo = new DrinkVO(num, null, 0, cnt);
					if(this.dao.update(vo)) {
						// 구매에 성공 했을때에만 장바구니에 해당 상품을 추가
						// 장바구니.add(내가 구매한 상품);
						DrinkVO data=dao.selectOne(vo);
						data.setCnt(cnt); // PK, name, price는 자판기에 저장된 상품 정보로 가능
						//cnt는 사용자가 입력했던 정보로 변경해야함 
						
						boolean flag=false;
						int index=0;
						for(int i=0;i<cart.size();i++) {
							if(data.equals(cart.get(i))){//사용자가 선택한 제품이 cart에 없던 제품이었니? 오버라이딩
								index=i;
								flag = true;
							}
						}
						if(flag) { //재고변경이야
							cart.get(index).setCnt(cart.get(index).getCnt());//기존+cnt
						}
						else {
							cart.add(data); //PK, name, price, cnt
						}
						
						this.view.printDrinkList(cart);
						
						this.view.printTrue();
					}
					else {
						this.view.printFalse();
					}

				}else if(action==4) {//update랑 delete랑 괸장히 비슷
					int num=this.view.getDrinkNum();
					DrinkVO vo = new DrinkVO(num, null, 0, 0);
					if(this.dao.delete(vo)) {
						this.view.printTrue();
					}
					else {
						this.view.printFalse();
					}
				}
				else if(action==5) {
					int num=view.getDrinkNum();
					int cnt=view.getDrinkCnt();
					DrinkVO vo=new DrinkVO(num,null,0,cnt);
					if(dao.update(vo)) {
						view.printTrue();
					}
					else {
						view.printFalse();
					}
				}

				else if(action==6) {
					String name=view.getDrinkName();
					ArrayList<DrinkVO> datas=dao.selectAll(new DrinkVO(0,name,0,0));
					view.printDrinkList(datas);
				}

				else if(action == 7) {//종료조건이라면
					this.view.printEnd();
					break;
				}
			}
		}
	}
}