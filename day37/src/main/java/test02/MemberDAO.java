package test02;

import java.util.ArrayList;

public class MemberDAO {
	ArrayList<MemberVO> datas;
	public MemberDAO () {
		datas = new ArrayList<MemberVO>();
		datas.add(new MemberVO ("admin","1234"));
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
		for(MemberVO mVO : datas) {
			if(mVO.getMid().equals(vo.getMid()) && mVO.getMpw().equals(vo.getMpw())) {
				//기존 데이터 보존
				MemberVO data=new MemberVO(mVO.getMid(),mVO.getMpw()); //애초에 생성할때 이렇게 만든당
				return data; 
			}
		}
		return null;
	}

}
