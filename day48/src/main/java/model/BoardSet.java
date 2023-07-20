package model;

import java.util.ArrayList;

public class BoardSet {
	private BoardVO board;//1
	private ArrayList<ReplyVO> rdatas;//N

	public BoardVO getBoard() {
		return board;
	}

	public void setBoard(BoardVO board) {
		this.board = board;
	}

	public ArrayList<ReplyVO> getRdatas() { //BoardDAO에서 selectAll로 읽어와 볼건데
											//게시글만 읽으면 안되고 댓글들도 여러개 읽어와야함
											//그래서 ReplyDAO selectAll행동도 같이 해 줘야해
		return rdatas;
	}

	public void setRdatas(ArrayList<ReplyVO> rdatas) {
		this.rdatas = rdatas;
	}
}
