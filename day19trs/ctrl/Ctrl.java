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
	private MemberVO member; // 현재 로그인한 회원정보
	public Ctrl() {
		mDAO=new MemberDAO();
		pDAO=new ProductDAO();
		admin=new AdminView();
		client=new ClientView();
		member=null;
		// 프로그램을 실행한다고해서, 자동로그인이 되지는않기때문에 null로 초기화!
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
				MemberVO mVO=client.signIn();
				// mVO에는 사용자가 입력한 아이디,비밀번호가 저장되어있음!
				
				member=mDAO.selectOne(mVO);
				// mdata에는 유효한 사용자 정보 or null
				// 유효한 사용자 정보 == "현재 로그인한 회원"
								
				if(member==null) {
					client.signInFalse();
					continue;
				}
				client.signInTrue();
				while(true) { // 사용자모드 진입
					action=client.printClientMenu02(member);
					if(action==1) { // 로그아웃
						member=null;				
						
						client.logout();
						client.printClientEnd02();
						break;
					}
					else if(action==2) { // 마이페이지
						String mpw=client.mypage(member);
						MemberVO mdata=new MemberVO(member.getMid(),mpw,null);
						boolean flag=mDAO.update(mdata);
						if(flag) {
							client.printMemberUpdateTrue();
						}
						else {
							client.printMemberUpdateFalse();
						}
					}
					else if(action==3) { // 회원탈퇴
						String mpw=client.getMpw(); // 사용자가 입력한 비밀번호
						if(!member.getMpw().equals(mpw)) {
							client.printFalse();
							continue;
						}
						
						if(!mDAO.delete(member)) { //모종의 이유로 false가 뜰수도있기때문에 해준건데
													//JAVA에서는 false날일이 0죠 거의
							client.printMemberDeleteFalse();
							continue;
						}
						client.printMemberDeleteTrue();
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
			else if(action==3) { // 프로그램종료
				client.printClientEnd01();
				break;
			}
		}
	}
}
