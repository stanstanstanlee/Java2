package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//BoardSet이라는 VO같은걸 하나 만들었으니 DAO같은것도 하나 만들었당
public class BoardSetDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
																//리밋을 걸어서 댓글수 제한
	static final private String SQL_SELECTALL="SELECT * FROM BOARD ORDER BY BID DESC LIMIT 0,?";	//해당글의 댓글만 가져와야 해서 where절이 있음
	static final private String SQL_SELECTALL_REPLY="SELECT * FROM REPLY WHERE BID=?"; //bid : fk
											
				//1:N짜리를 받고싶어						//int count를 bVO에 넣을 수 있음
	public ArrayList<BoardSet> selectAll(BoardVO bVO, int count){//인자bVO 1:N일때 1자리가 보통 있음 
		conn=JDBCUtil.connect();
		//1:N짜리 여러개 받아서 줄 준비
		ArrayList<BoardSet> datas=new ArrayList<BoardSet>();

		try {
			pstmt=conn.prepareStatement(SQL_SELECTALL);
			pstmt.setInt(1, count);//첫번째?물음표
			rs=pstmt.executeQuery();
			
			//Board 게시글 하나 불러올 때 마다 그 1개에 달린 댓글(여러개)를 불러와야 함
			//그래서 이안에 Reply의 selectAll도 불러와야 함	
			while(rs.next()) {
				BoardSet bs = new BoardSet(); //이거 하나는 Reply여러개로 이루어져 있음
				
				BoardVO data=new BoardVO();
				data.setBid(rs.getInt("BID"));
				data.setBcontent(rs.getString("BCONTENT"));
				data.setMid(rs.getString("MID"));
				
				bs.setBoard(data);
				
				/////
				pstmt=conn.prepareStatement(SQL_SELECTALL_REPLY);
				pstmt.setInt(1, data.getBid());//첫번째?물음표
				
				ResultSet rs2 = pstmt.executeQuery();//rs=pstmt.executeQuery(); //위의 rs와 같음. 결과를 가져오는 중인데 중간에 가로채면 불러오기가안됨
				//그래서 ResultSet이 1개 더 필요하다
				ArrayList<ReplyVO> rdatas=new ArrayList<ReplyVO>();
				while(rs2.next()) {
					ReplyVO rVO = new ReplyVO();
					rVO.setBid(rs2.getInt("BID"));
					rVO.setDatetime(rs2.getDate("DATETIME"));
					rVO.setMid(rs2.getString("MID"));
					rVO.setRid(rs2.getInt("RID"));
		            rVO.setRcontent(rs2.getString("RCONTENT"));
		            rdatas.add(rVO);

				}
				/////
				bs.setRdatas(rdatas);
				
				datas.add(bs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBCUtil.disconnect(rs, pstmt, conn);

		return datas;
	}
}
