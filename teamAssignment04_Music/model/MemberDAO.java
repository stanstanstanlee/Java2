package model;

import java.util.ArrayList;

// 회원목록출력
// 회원가입,로그인,로그아웃,마이페이지,회원탈퇴
public class MemberDAO {
	private ArrayList<MemberVO> datas;
	public MemberDAO() {
		datas=new ArrayList<MemberVO>();
		datas.add(new MemberVO("1","1","김태환"));
		datas.add(new MemberVO("admin","1234","관리자"));
	}
	
	public ArrayList<MemberVO> selectAll(MemberVO mVO){
		return datas;
	}
	public MemberVO selectOne(MemberVO mVO){
		for(MemberVO v:datas) {
			if(mVO.getMid().equals(v.getMid())) {
				if(mVO.getMpw().equals(v.getMpw())) {
					return v;
				}
//				System.out.println(" 로그: MemberDAO: selectOne(): 비밀번호가 일치하지않습니다!");
				return null;
			}
		}
//		System.out.println(" 로그: MemberDAO: selectOne(): 해당 아이디가 없습니다!");
		return null;
	}
	
	public boolean insert(MemberVO mVO) {
		boolean flag=false;
		for(MemberVO data:datas) {
			if(data.equals(mVO)) {
				flag=true;
//				System.out.println(" 로그: MemberDAO: insert(): 아이디 중복");
				break;
			}
		}
		if(flag) {
			return false;
		}
		datas.add(new MemberVO(mVO.getMid(),mVO.getMpw(),mVO.getName()));
		return true;
	}
	public boolean update(MemberVO mVO) {
		if(mVO.getMpw().equals("이름변경")) {
			for(int i=0;i<datas.size();i++) {
				if(datas.get(i).equals(mVO)) {
					datas.get(i).setName(mVO.getName());
					return true;
				}
			}
		}
		if(mVO.getName().equals("비밀번호변경")) {
			for(int i=0;i<datas.size();i++) {
				if(datas.get(i).equals(mVO)) {
					datas.get(i).setMpw(mVO.getMpw());
					return true;
				}
			}
		}
		return false;
	}
	public boolean delete(MemberVO mVO) {
//		for(int i=0;i<datas.size();i++) {
//			if(datas.get(i).equals(mVO)) {
//				datas.remove(i);
//				return true;
//			}
//		}
		return false;
	}
}
