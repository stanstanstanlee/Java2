package controller;

public class ActionForward { //반환을 2개이상 못하는 자바의 특징때문에 나온 친구 
	private boolean redirect; //redirect 할거야?
	private String path; //어디로 갈거야?
	
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	

}
