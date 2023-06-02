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
			int action=client.printClientMenu01();
			if(action==1234) { // 관리자모드실행
				while(true) { // 관리자모드 진입
					action=admin.printAdminMenu();
					if(action==1) { // 회원목록출력
						ArrayList<MemberVO> mdatas=mDAO.selectAll(null);
						admin.printMemberList(mdatas);
					}
					else if(action==2) { // 관리자모드종료
						admin.printAdminEnd();
						break;
					}
				}
			}
			else if(action==1) { // 회원가입
				MemberVO mVO=client.signUp();
				boolean flag=mDAO.insert(mVO);
				if(flag) {
					client.signUpTrue();
				}
				else {
					client.signUpFalse();
				}
			}
			else if(action==2) { // 로그인
				if(true) { // mDAO.selectOne(client.signIn())!=null
					client.signInTrue();
					while(true) { // 사용자모드 진입
						action=client.printClientMenu02();
						if(action==1) { // 로그아웃
							client.logout();
							client.printClientEnd02();
							break;
						}
						else if(action==2) { // 마이페이지

						}
						else if(action==3) { // 회원탈퇴
							client.printClientEnd02();
							break;
						}
						else if(action==4) { // 상품목록출력
							ArrayList<ProductVO> pdatas=pDAO.selectAll(null);
							client.printProductList(pdatas);
						}
						else if(action==5) { // 상품목록검색_이름으로 검색
							String name=client.getSearchContent();
							ProductVO pVO=new ProductVO(0,name,0,0);
							ArrayList<ProductVO> pdatas=pDAO.selectAll(pVO);
							client.printProductList(pdatas);
						}
						else if(action==6) { // 상품목록검색_가격으로 검색
							ProductVO pVO=client.getSearchFilter();
							ArrayList<ProductVO> pdatas=pDAO.selectAll(pVO);
							client.printProductList(pdatas);
						}
						else if(action==7) { // 상품검색_최고가 검색
							ProductVO pVO=new ProductVO(0,"최고가",0,0);
							ProductVO data=pDAO.selectOne(pVO);
							client.printProduct(data);
						}
					}
				}
				else {
					client.signInFalse();
				}
			}
			else if(action==3) { // 프로그램종료
				client.printClientEnd01();
				break;
			}
		}
	}
}
