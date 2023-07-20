package model;

import java.util.Date;

public class BoardVO {
	
	private int bid;
	private String mid;
	private String bcontent;
	private int favcnt;
	private int replycnt;
	private Date datetime;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public int getFavcnt() {
		return favcnt;
	}
	public void setFavcnt(int favcnt) {
		this.favcnt = favcnt;
	}
	public int getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bid=" + this.bid + ", mid=" + this.mid + ", bcontent=" + 
				this.bcontent + ", favcnt=" + this.favcnt + "]";
	}
	
}
