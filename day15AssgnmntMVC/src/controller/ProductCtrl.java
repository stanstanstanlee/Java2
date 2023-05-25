package controller;

import java.util.ArrayList;

import model.ProductDAO;
import model.ProductVO;
import view.ProductView;

public class ProductCtrl {
	//[멤버변수]
	private ProductView view;
	private ProductDAO dao;

	//[생성자]
	public ProductCtrl() {
		this.view=new ProductView();
		this.dao=new ProductDAO();
	}

	//[메서드]
	
	public void startApp() {
		while(true) {

			// 사용자한테 메뉴보여줘!
			view.printMenu();
			// 사용자가 뭐 할지 입력받아봐
			int menuNum=view.getMenuNum();

			if(menuNum == 1) {
				//목록출력
				ArrayList<ProductVO> datas = dao.selectAll();
				view.printProductList(datas);
			}

			else if(menuNum == 2) {
				//구매
				view.printPurchaseStart();
				//구매가능상품목록
				ArrayList<ProductVO> datas = dao.selectAll();
				view.printProductList(datas);
				//상품번호입력
				int num = view.getNum();
				//구매개수입력
				int cnt = view.getCnt();

				if ( dao.update(num, cnt) ) {
					view.printPurchaseEnd();
				}else {
					view.printFalse();
				}
			}
			else if(menuNum == 3) {
				//상품추가
				view.printAddStart();
				String name = view.getProductName();
				int cnt = view.getCnt();
				int price = view.getPrice();
				dao.insert(name, cnt, price);
				view.printAddEnd();
			}

			else if(menuNum == 4) {
				//상품삭제
				view.printDeleteStart();
				int num = view.getNum();
				if ( dao.delete(num) ) {
					view.printDeleteEnd();
				} else {
					view.printFalse();
				}	 
			}
			else if(menuNum == 5) {
				view.printPwrOff();
				break;
			}
		}

	}
}
