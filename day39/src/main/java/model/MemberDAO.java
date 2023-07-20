package model;

import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<MemberVO> datas;
	public MemberDAO() {
		datas=new ArrayList<MemberVO>();
		datas.add(new MemberVO("admin","1234","관리자"));
	}

	public ArrayList<MemberVO> selectAll(MemberVO mVO){
		return null;
	}
	public MemberVO selectOne(MemberVO mVO){
		for(MemberVO v:datas) {
			if(mVO.getMid().equals(v.getMid())) {
				// 아이디가 존재하는 상황
				if(mVO.getMpw().equals(v.getMpw())) {
					// 비밀번호도 일치하는 상황
					return v;
				}
			}
		}
		return null;
	}
	public boolean insert(MemberVO mVO){
		return false;
	}
	public boolean delete(MemberVO mVO){
		return false;
	}
	public boolean update(MemberVO mVO){
		return false;
	}
}
