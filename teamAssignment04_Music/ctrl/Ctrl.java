package ctrl;

import java.util.ArrayList;
import java.util.Random;

import model.MemberDAO;
import model.MemberVO;
import model.MusicDAO;
import model.MusicVO;
import view.ClientView;

// 컨트롤러에서는 dao 와 view만 사용하여
// M과 V를 왔다갔다 해줄 수 있게 하는 공간
public class Ctrl {
	// 1. 멤버 변수
	private ClientView view;
	private MusicDAO MusicDAO;
	private MemberDAO MemberDAO;
	private MemberVO member;
	private static Random rand=new Random();

	// 2. 생성자
	public Ctrl () {
		this.view = new ClientView();
		this.MusicDAO = new MusicDAO();
		this.MemberDAO = new MemberDAO();
		this.member = null;
	}
	// 3. 메서드
	// 출력할 상품이 없으면 멘트 출력.
	// 있으면 프로그램 실행 멘트 출력하고 상품 한번 출력해줘.
	
	public void startApp () {
		while(true) {
			// 프로그램 출력
			int menu =view.printMain();
			int action = view.getNum(menu);
			// 로그인
			if(action == 1) {
				MemberVO mVO=view.signIn();
				member=MemberDAO.selectOne(mVO);
				if(member==null) {
					view.signInFalse();
					continue;
				}
				view.signInTrue();
				while(true) {
					menu = view.printMusic(member);
					action = view.getNum(menu);
					// 크롤링 노래 목록
					if(action==1) {
						ArrayList<MusicVO> mdatas = MusicDAO.selectAll(null);
						view.printMusicList(mdatas,action);
					}
					// 플레이리스트 만들기
					else if(action==2) {
						if(member.getPdatas().isEmpty()) { // 멤버의 Pdatas가 비어있으면, 플레이리스트 숫자가 없으니까
							view.printPlayListEmpty();
						}
						else {
						view.printPlayListStart();
						for(int i=0; i<member.getPdatas().size();i++) { 
							MusicVO musicVO = new MusicVO(member.getPdatas().get(i),null,null,0);
							MusicVO musicVO2 = MusicDAO.selectOne(musicVO);
							view.printMusicOne(musicVO2);
						}
						view.printPlayListEnd();
						}
						view.exitNum();
						int num=view.getMusicNum(action);
						boolean flag =false;
						for(int i=0;i<member.getPdatas().size();i++) {
							if(member.getPdatas().get(i)==num) {
								flag = true;
								break;
							}
						}
						// 멤버DAO. update
						if(num == 0) { // 번호가 0 이면 나가기
							view.exitNumEnd();
							continue;
						}
						if(flag) {
							view.addPlayListFailDuplicate(); // 중복인 경우
							continue;
						}
						member.getPdatas().add(num);
						// 플리 번호 추가
						ArrayList<MusicVO> playList = new ArrayList<MusicVO>();
						MusicVO musicVO2 = null;
						for(int i=0; i<member.getPdatas().size();i++) {
							MusicVO musicVO = new MusicVO(member.getPdatas().get(i),null,null,0);
							musicVO2 = MusicDAO.selectOne(musicVO);
							playList.add(musicVO2);
						}
						view.addPlayListTrue(musicVO2);
					}
					// 최고조회수
					else if(action==3) {
						MusicVO musicVO=new MusicVO(-1,null,null,0);
						ArrayList<MusicVO> mdatas = MusicDAO.selectAll(musicVO);
						view.printMusicList(mdatas,action);
					}
					// 노래 이름 검색
					else if(action==4) {
						String keywords=view.getSearchContent();
						MusicVO musicVO=new MusicVO(0,keywords,keywords,-1);
						ArrayList<MusicVO> mdatas=MusicDAO.selectAll(musicVO);
						view.printMusicList(mdatas,action);
						if(mdatas.isEmpty()) {
							continue;
						}
						view.isAddPlayList();
						view.exitNum();
						int num=view.getMusicNum(action);
						if(num==0) {
							view.exitNumEnd();
							continue;
						}
						boolean flag =false;
						for(int i=0;i<member.getPdatas().size();i++) {
							if(member.getPdatas().get(i)==num) { // 플리 중복검사
								flag = true;
								break;
							}
						}
						if(flag) {
							// view.이미 플레이스트에 있습니다.
							view.addPlayListFailDuplicate();
							continue;
						}
						boolean flag2 =false;
						for (int i=0;i<mdatas.size();i++) {
							if(mdatas.get(i).getNum()==num) { // 검색 결과에서 같은 번호 있는 경우
								flag2 = true;
							}
						}
						if(!flag2) {
							// 검색결과에 없는 번호임..
							view.addPlayListFailNum();
							continue;
						}
						member.getPdatas().add(num); 
						// 플리 번호 추가
						ArrayList<MusicVO> playList = new ArrayList<MusicVO>();
						MusicVO musicVO2 = null;
						for(int i=0; i<member.getPdatas().size();i++) { // 3번 반복
							MusicVO pmusicVO = new MusicVO(member.getPdatas().get(i),null,null,0);
							musicVO2 = MusicDAO.selectOne(pmusicVO);
							playList.add(musicVO2);
						}
						view.addPlayListTrue(musicVO2);
					}
					// 노래 재생
					else if(action==5) {
						ArrayList<MusicVO> mdatas = MusicDAO.selectAll(null);
						view.printMusicList(mdatas,1); // 1 > "노래 목록"
						view.exitNum();
						int num= view.getMusicNum(action);
						if( num == 0) {
							view.exitNumEnd();
							continue;
						}
						MusicVO musicVO= new MusicVO(num,"재생",null,0);
						boolean flag=MusicDAO.update(musicVO);
						if(flag) {
							MusicVO musicVO2 = MusicDAO.selectOne(musicVO);
							view.playMusic(musicVO2);
							// 재생완료
						}
					}
					// 랜덤 재생
					else if(action==6) {
						ArrayList<MusicVO> mdatas = MusicDAO.selectAll(null);
						int num = rand.nextInt(mdatas.size())+1;
						MusicVO musicVO= new MusicVO(num,"랜덤",null,0);
						boolean flag=MusicDAO.update(musicVO);
						if(flag) {
							MusicVO musicVO2 = MusicDAO.selectOne(musicVO);
							view.playMusic(musicVO2);
							// 재생완료
						}
					}
					// 마이페이지
					else if(action==7) {
						menu = view.printMyPageMenu();
						action = view.getNum(menu);
						//이름 정보 변경.
						if (action == 1) {
							String mpw=view.getMpw();
							if(!member.getMpw().equals(mpw)) {
								view.getMpwFalse();
								continue;
							}
							else {
								String mName = view.getSetMname();
								mVO = new MemberVO(member.getMid(),"이름변경",mName);
								if(MemberDAO.update(mVO)) {
									view.printSetMnameTrue();
									continue;
								}
								view.printSetMnameFalse();
							}
						}
						//비밀번호 정보 변경.
						else if (action == 2) {
							String mpw=view.getMpw();
							if(!member.getMpw().equals(mpw)) {
								view.getMpwFalse();
								continue;
							}
							else {
								mpw=view.getSetMpw();
								mVO = new MemberVO(member.getMid(), mpw, "비밀번호변경");
								if(MemberDAO.update(mVO)) {
									view.printSetMpwTrue();
									continue;
								}
								view.printSetMpwFalse();
							}
						}
						// 마이페이지 나가기
						else if (action == 0) {
							view.exitNumEnd();
							continue;
						}
					}
					// 로그아웃
					else if(action==0) {
						member=null;				

						view.logout();
						view.printMusicEnd();
						break;

					}
				}
			}
			// 회원가입
			else if(action == 2) {
				MemberVO mVO=view.signUp();
				if(mVO==null) {
					view.signUpFalse();
					continue;					
				}
				boolean flag=MemberDAO.insert(mVO);
				if(flag) {
					view.signUpTrue();
				}
				else {
					view.signUpFalse();
				}
			}
			// 프로그램 종료
			else if(action == 0) {
				view.programEnd();
				break;
			}

		}
	}
}
