package model;

import java.util.ArrayList;

// 회원목록출력
// 회원가입,로그인,로그아웃,마이페이지,회원탈퇴
public class MemberDAO {
	private ArrayList<MemberVO> datas;
	public MemberDAO() {
		datas=new ArrayList<MemberVO>();
		datas.add(new MemberVO("admin","1234","관리자"));
		datas.add(new MemberVO("coding_helper","timo","작은 티모"));
	}
	
	public ArrayList<MemberVO> selectAll(MemberVO mVO){
		return datas;
	}
	public MemberVO selectOne(MemberVO mVO){
		return null;
	}

	public boolean insert(MemberVO mVO) {
		//mVO가 의미하는것 == 회원가입할 정보
		//mVO를 datas에 넣어줄예정
		//PK 중복검사를 해야하고, 성공하면 add()
				//실패하면 false 반환
		boolean flag = false;
		for(MemberVO data:datas) {
			if(data.equals(mVO)) {//아이디 같은거 있어? 객체비교는 equals
				flag=true;
				System.out.println(" 로그 : MemberDAO : inser(): 아이디 중복");
				break;
			}
		}
		if(flag) {//PK가 중복되었어?
			return false;
		}
		//datas에 mVO정보를 저장 add();
		datas.add(new MemberVO(mVO.getMid(),mVO.getMpw(),mVO.getName()));
		/*
		 * 1) datas.add(new MemberVO());
		 * 		-> datas DB공간에 new 새로운 데이터를 추가
		 * 2) MemberVO(데이터1,데이터2,데이터3)
		 * 		->데이터들을 mVO에서 추출하면됨
		 */
		
		
		return true;
	}
	public boolean update(MemberVO mVO) {
		return true;
	}
	public boolean delete(MemberVO mVO) {
		return true;
	}
}
