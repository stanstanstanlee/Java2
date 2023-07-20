package test;

import java.util.ArrayList;

public class MemberDAO {
	ArrayList<MemberVO> datas;
	public MemberDAO() {
		datas=new ArrayList<MemberVO>();
		datas.add(new MemberVO("admin","1234"));
		datas.add(new MemberVO("timo","1234"));
		datas.add(new MemberVO("kim","1234"));
	}
	
	public boolean insert(MemberVO vo) {
		return false;
	}
	public boolean update(MemberVO vo) {
		return false;
	}
	public boolean delete(MemberVO vo) {
		return false;
	}
	public ArrayList<MemberVO> selectAll(MemberVO vo) {
		return datas;
	}
	public MemberVO selectOne(MemberVO vo) {
		MemberVO data=new MemberVO();
		
		return data;
	}
}
