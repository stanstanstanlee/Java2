package model;

import java.util.ArrayList;

// 회원목록출력
// 회원가입,로그인,로그아웃,마이페이지,회원탈퇴
public class MemberDAO {
	private ArrayList<MemberVO> datas;
	public MemberDAO() {
		datas=new ArrayList<MemberVO>();
		datas.add(new MemberVO("admin","1234","관리자"));
		datas.add(new MemberVO("coding_helper","teemo","작은 티모"));
	}

	public ArrayList<MemberVO> selectAll(MemberVO mVO){
		return datas;
	}
	public MemberVO selectOne(MemberVO mVO){
		for(MemberVO v : datas) { 
			if(mVO.getMid().equals(v.getMid())) {//내가받은값이 datas에 있어?
				if(mVO.getMpw().equals(v.getMpw())) {//비밀번호확인해보기
					return v;//반환
				}
				System.out.println(" 로그: MemberDAO: selectOne(): 비밀번호가 일치하지않습니다!");
				return null;
			}
		}
		System.out.println(" 로그: MemberDAO: selectOne() : 해당 아이디가 없습니다!");
		return null;
	}

	public boolean insert(MemberVO mVO) {
		boolean flag=false;
		for(MemberVO data:datas) {
			if(data.equals(mVO)) {
				flag=true;
				System.out.println(" 로그: MemberDAO: insert(): 아이디 중복");
				break;
			}
		}
		if(flag) {
			return false;
		}
		datas.add(new MemberVO(mVO.getMid(),mVO.getMpw(),mVO.getName()));
		/*
		1) datas.add(new MemberVO());
		 -> datas DB공간에 new 새로운 데이터를 추가
		2) MemberVO(데이터1,데이터2,데이터3)
		 -> 데이터들을 mVO에서 추출하면됨
		 */
		return true;
	}
	public boolean update(MemberVO mVO) { 
		//비밀번호변경
		for(MemberVO v : datas) { 
			if(v.equals(mVO)) {//내가받은값이 datas에 있어? 존재하니?
				v.setMpw(mVO.getMpw());
				return true;
			}
		}
		return false;
	}
	public boolean delete(MemberVO mVO) {
		for(int i=0; i<datas.size();i++) {
			if(datas.get(i).equals(mVO)) {
				datas.remove(i);
				return true;
			}
		}
		return true;
	}
}
