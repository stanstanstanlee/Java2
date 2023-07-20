package test;

// VO랑 DAO가 합쳐져있는 클래스
public class LoginBeanAnswer {
	private String mid;
	private String mpw;
	private boolean flag;
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
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public void check() {
		if(this.mid.equals("admin") && this.mpw.equals("1234")) {
			this.flag=true;
		}
	}
}
