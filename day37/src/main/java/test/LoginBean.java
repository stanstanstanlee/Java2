package test;
//Bean 클래스
//: 기능을 구현한 클래스
public class LoginBean {
	String mid;
	String mpw;
	String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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

	
	public void login() {
		if(this.mid==null) {
			this.mid="";
		}
		if(this.mid.equals("admin") && this.mpw.equals("1234")) {
			result = "관리자 페이지입니다";
		}
		else {
			result = "다시 입력 해 주세요";
		}
		
	}
	
	
}
