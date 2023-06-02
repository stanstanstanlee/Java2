package model;

import java.util.ArrayList;

public class MemberVO {
	private String mid; // PK
	private String mpw;
	private String name;
	private ArrayList<Integer> pdatas;
	
	public MemberVO(String mid,String mpw,String name) {
		this.mid=mid;
		this.mpw=mpw;
		this.name=name;
		this.pdatas=new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getPdatas() {
		return pdatas;
	}

	public void setPdatas(ArrayList<Integer> pdatas) {
		this.pdatas = pdatas;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name+"님";
	}

	@Override
	public boolean equals(Object obj) {		
		MemberVO mVO=(MemberVO)obj;
		if(this.mid.equals(mVO.mid)) {
			return true;
		}
		return false;
	}
}
