package model;

public class MusicVO {
	// 1. 멤버 변수
	private int num; // 노래 번호
	private String artist; // 노래 가수
	private String title; // 노래 제목
	private int cnt; // 조회수
	
	// 2. 생성자
	public MusicVO (int num, String artist, String title, int cnt) {
		this.num=num;
		this.artist=artist;
		this.title=title;
		this.cnt=cnt;
	}
	
	// 3. 메서드
	

	// 	toString 오버라이딩
	@Override
	public String toString() {
		String msg = num+". ["+artist+" - "+title+"] [플레이 수: "+cnt+"]";
		return msg;
	}

	// 	getter,setter
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public boolean equals(Object obj) {
		   MusicVO musicVO=(MusicVO)obj;
	        if(this.num==musicVO.num) {
	            return true;
	        }
	        return false;
	}
	
	
}
