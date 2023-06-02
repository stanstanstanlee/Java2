package ctrl;

import java.util.ArrayList;

import model.MemberDAO;
import model.MemberVO;
import model.ProductDAO;
import model.ProductVO;
import view.AdminView;
import view.ClientView;

public class Ctrl {
	private MemberDAO mDAO;
	private ProductDAO pDAO;
	private AdminView admin;
	private ClientView client;
	public Ctrl() {
		mDAO=new MemberDAO();
		pDAO=new ProductDAO();
		admin=new AdminView();
		client=new ClientView();
	}

	public void startApp() {
		while(true) {
			// 2. V는 입력한 값을 C한테 전달
			int action=client.printClientMenu01();//1.사용자가 console에 회원가입할래~ 1번 입력
			if(action==1234) {//관리자모드실행 /1. 사용자가 관리자인상황.
				while(true) {//관리자모드 진입
					action=admin.printAdminMenu();//2. 관리자가 회원목록볼래~
					if(action==1) {//회원목록출력 //3. V가 C한테 말합니다. 회원목록보겠다는데?
						//4. C가 아, 회원목록데이터가 필요하구나? ㅇㅋ
						//5. M한테 회원목록 좀줘 ~
						//6. M이 selectAll()합니다.
						//7. AL<MVO>가 반환되고 C는 그걸
						//8. -V한테 줍니다. 
						//ArrayList<MemberVO> mdatas=mDAO.selectAll(null);/회원목록줘();
						//admin.printMemberList(mdatas);
						//view.회원목록출력(datas);
						
						admin.printMemberList(mDAO.selectAll(null));
					}
					else if(action==2) {//관리자모드종료
						admin.printAdminEnd();
						break;
					}
				}
			}//3. C는 아~ 회원가입하고 싶구나? ㅇㅋ
			else if(action==1) {//회원가입
				//4. C는 V한테 회원가입할 정보를 입력받아오라고 지시
				//5. V는 사용자한테 회원가입창 보여줌
				// 6. 사용자는 정보를 입력
				 // 7. V는 사용자가 입력한 정보를 C한테 전달
//		● 		회원가입정보 = view.//회원가입화면() 띄워야징 
				MemberVO mVO = client.signUp();
				boolean flag = mDAO.insert(mVO);
		 		 // 8. C는 이 정보를 M한테 전달
				 // 9. M은 회원가입을 수행
				 // 10. M은 insert()가 잘되었는지아닌지를 T,F를 반환
//		● 		boolean 성공실패 여부 = mDao.insert();//model.회원가입(a);
				
				// C는 결과에따라 맞는 V화면을 보여줄수있도록 지시
				 // 사용자는 V가 보여주는 화면을 보게됨
//		●		if() {//성공했어?
//					view.성공화면();
//				} else {
//					view.실패화면();
//				}
//				MemberVO mVO = client.signUp()
//						boolean flag = false;
//				if(flag) {
//					client.signUpTrue();
//				}
//				else {
//					client.signUpFalse();
//				}
				 
				if(mDAO.insert(client.signUp())) {
					client.signUpTrue();
				}
				else {
					client.signUpFalse();
				}
			}
			else if(action==2) {//사용자가 로그인 할래~ 입력
				if(mDAO.selectOne(client.signIn())!=null) {
					client.signInTrue();
					while(true) {
						action=client.printClientMenu02();//메뉴출력
						if(action==1) {//로그아웃
							client.logout();
							client.printClientEnd02();
							break;
						}
						else if(action==2) {//마이페이지
							
						}
						else if(action==3) {//회원탈퇴
							client.printClientEnd02();
							break;
						}
						else if(action==4) {//상품목록출력
							ArrayList<ProductVO> pdatas=pDAO.selectAll(null);
							client.printProductList(pdatas);

						}
						else if(action==5) {//상품목록검색_이름으로 검색
							String name=client.getSearchContent();//뭐 검색 할래??
							ProductVO pVO = new ProductVO(0,name,0,0);
							ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
							client.printProductList(pdatas);
						}
						/*
 a) 버튼입력시 가장비싼상품 출력		selectOne(pVO) -> 안쓰는 인자
						  가격 price
						  name을 안쓰는중
						    -> 비싼상품, 싼상품
							  searchCondition
							  
 b) 버튼입력시 가장싼상품 출력		selectOne(pVO)
 c) 가격입력시 해당금액보다 비싼상품들 출력 	selectAll()
 d) 가격입력시 해당금액보다 싼상품들 출력		selectAll()
 e) 가격을 2번 입력시 금액이 A~B까지의 상품들 출력 		selectAll()
	=> 필터 검색 ☆
						 */
						else if(action==6) {//상품목록검색_가격으로 검색	
											//어떤 가격 검색할래?
											//사용자가 V에게 가격전달
											//V가 C에게 이 가격 상품 보겠다는데?
											//C가 M에게 이 가격, 상품 뭐야?
											//M이 selectOne() 합니다.
											//<AL>ProductVO에서 입력된 가격의 상품이름을 C에게 반환
										    //C가 그걸 V에게 전달
							ProductVO pVO = client.getSearchFilter();
							ArrayList<ProductVO> pdatas = pDAO.selectAll(pVO);
							client.printProductList(pdatas);
						}
						else if(action==7) {//상품검색_최고가 검색
														//searchCondition
							ProductVO pVO=new ProductVO(0,"최고가",0,0);
							ProductVO data = pDAO.selectOne(pVO);//data : output
							client.printProduct(pVO);
						}
					}
				}
				else {
					client.signInFalse();
				}
			}
			else if(action==3) {//프로그램종료
				client.printClientEnd01();
				break;
			}
		}
	}
}
