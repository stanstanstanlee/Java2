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
	private MemberVO member; //현재 로그인한 회원정보 <<상단배치 해도 됨 
	//	private CommonView common;//공통의 무언가를 구현하는 코드; 어디서든 사용할 로직들이 담겨있구낭
	public Ctrl() {
		mDAO=new MemberDAO();
		pDAO=new ProductDAO();
		admin=new AdminView();
		client=new ClientView();
		member=null;// 세션로그인데이터
					// 컨트롤러가 생긴다고 해서 로그인한 회원이 생기는건 아니기 때문에 초기화 하지 않음
					// 프로그램을 실행한다고해서, 자동로그인이되지는않기때문에
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
				// M은 VO를 반환 == 존재하는 회원
				// -> 로그인 성공 V
				//  => 다음 스텝으로 이동
				// 		null을 반환 == 없거나, 비밀번호가 틀림! 
				// -> 로그인 실패 V
				//  => 프로그램 모드에 계속 있어야함
				MemberVO mVO = client.signIn();
				//mVO에는 사용자가 입력한 아이디,비밀번호가 저장되어있음!
				//MemberVO mdata
				member = mDAO.selectOne(mVO); //mVO를 재활용 하는것이 헷갈리면 새로 하나 만들어도 됨
				// mdata에는 유효한 사용자 정보 or null
				// 유효한 사용자 정보 == 현재 로그인한 회원

				// 아이디입력해봐! 라고 V가 사용자에게 요청
				// 비밀번호도 같이 입력해~~

				// C는 이 정보가 있는지, 그리고 맞는지 (==유효한지)
				// 위의 여부를 M한테 판단을 부탁함
				// ----->> selectOne(); // 이 '사람' 데이터 있어??
				if(member==null) {
					client.signInFalse();//로그인실패V
					continue;//프로그램모드에계속존재
				}
				client.signInTrue();//로그인성공
				//다음스텝으로이동
				
				while(true) { // 사용자모드 진입
					action=client.printClientMenu02(member);
					if(action==1) { // 로그아웃
						//사용자가 로그아웃을 원하면,
						//C에 mdata가 현재 존재하는데, 이걸
						
						//현재로그인한 회원이였기때문에
						member = null;//제거하고
						
						// V->C->V 로그아웃은 모델 불필요  
						// V->C->M->C->V 대부분 이렇게 진행
						
						client.logout();//로그아웃이 되었음을 사용자에게 알려주자!~~
						client.printClientEnd02();
						break;
					}
					else if(action==2) { // 마이페이지
						// V가 변결할 비번을 입력받음
						String mpw=client.mypage(member);
						// V는 비번을 C에게 전달
						MemberVO mdatas=new MemberVO(member.getMid(),mpw,null); //지금 로그인한사람 PK, 변경할 비번, X);
						// C는 M.update()수행
						boolean flag = mDAO.update(mdatas);
						// T -> ㅇㅋ
						if(flag) {
							client.printMemberUpdateTrue();
						}
						// F -> ㄴㄴ
						else client.printMemberUpdateFalse();
						
						/*
						//비밀번호 확인
						String mpw=client.getMpw();//view.비번입력해봐();
						//비밀번호 일치
						// 비밀번호를 한번더 확인하는 로직
						// 비밀번호가 불일치 -> 회원탈퇴를 막아버리면됨 (너 데이터제거할 수 있는 위치에 있어?)
						if(!member.getMpw().equals(mpw)) {//현재 로그인한 사람의 비밀번호와 사용자가 입력한 비밀번호와 같니? 
							client.printFalse();//view.비밀번호불일치();	//	비밀번호 불일치
								continue;
						}
						// 비밀번호 일치 해야
						// -> 
						// 로그인이 되어있는 회원이
						//변경할 비밀번호 입력
						System.out.println("새로운비번입력:");
						String npw=client.getMpw();
						//변경된 비밀번호 임시 저장
						member.setMpw(npw);
						
						//모델에서 변경 
						if(!mDAO.update(member)) {
							System.out.println("실패");
						}
						
						//비번변경성공
						System.out.println("성공");
						break;
						*/
					}
					else if(action==3) { // 회원탈퇴
						// 현재 로그인한 상황.
						String mpw=client.getMpw();//view.비번입력해봐();
						//비밀번호 일치
						// 비밀번호를 한번더 확인하는 로직
						// 비밀번호가 불일치 -> 회원탈퇴를 막아버리면됨 (너 데이터제거할 수 있는 위치에 있어?)
						if(!member.getMpw().equals(mpw)) {//현재 로그인한 사람의 비밀번호와 사용자가 입력한 비밀번호와 같니? 
							client.printFalse();//view.비밀번호불일치();	//	비밀번호 불일치
								continue;
						}
						// 비밀번호 일치 해야
						// -> 
						// 로그인이 되어있는 회원을
						// 전체회원목록에서 제거
						
						if(!mDAO.delete(member)) {	//model.delete(지금로그인한사람)
							client.printMemberDeleteFalse();//회원탈퇴실패
							continue;
						}
						//회원탈퇴성공
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
					else if(action==8) {// 상품검색_최저가 검색
						ProductVO pVO=new ProductVO(0,"최저가",0,0);
						ProductVO data=pDAO.selectOne(pVO);
						client.printProduct(data);
						
					}
				}

				

				//				if(true) { // mDAO.selectOne(client.signIn())!=null
				//					client.signInTrue();
				//					while(true) { // 사용자모드 진입
				//						action=client.printClientMenu02();
				//						if(action==1) { // 로그아웃
				//							client.logout();
				//							client.printClientEnd02();
				//							break;
				//						}
				//						else if(action==2) { // 마이페이지
				//
				//						}
				//						else if(action==3) { // 회원탈퇴
				//							client.printClientEnd02();
				//							break;
				//						}
				//						else if(action==4) { // 상품목록출력
				//							ArrayList<ProductVO> pdatas=pDAO.selectAll(null);
				//							client.printProductList(pdatas);
				//						}
				//						else if(action==5) { // 상품목록검색_이름으로 검색
				//							String name=client.getSearchContent();
				//							ProductVO pVO=new ProductVO(0,name,0,0);
				//							ArrayList<ProductVO> pdatas=pDAO.selectAll(pVO);
				//							client.printProductList(pdatas);
				//						}
				//						else if(action==6) { // 상품목록검색_가격으로 검색
				//							ProductVO pVO=client.getSearchFilter();
				//							ArrayList<ProductVO> pdatas=pDAO.selectAll(pVO);
				//							client.printProductList(pdatas);
				//						}
				//						else if(action==7) { // 상품검색_최고가 검색
				//							ProductVO pVO=new ProductVO(0,"최고가",0,0);
				//							ProductVO data=pDAO.selectOne(pVO);
				//							client.printProduct(data);
				//						}
				//					}
				//				}

			}
			else if(action==3) { // 프로그램종료
				client.printClientEnd01();
				break;
			}
		}
	}
}
