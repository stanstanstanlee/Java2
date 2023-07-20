package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReplyDAO {
	// C 댓글 작성하기
	// R 댓글 목록보기
	// (R 댓글 1개 선택하기)
	// D 댓글 삭제
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	static final private String SQL_SELECTALL="SELECT * FROM REPLY";
	static final private String SQL_SELECTONE="SELECT * FROM REPLY WHERE RID=?";
	static final private String SQL_INSERT="INSERT INTO REPLY (BID,MID,RCONTENT,DATE) VALUES(?,?,?,NOW())";
	static final private String SQL_DELETE="DELETE FROM REPLY WHERE RID=?";
	
	public ArrayList<ReplyVO> selectAll(ReplyVO rVO){
		conn=JDBCUtil.connect();

		ArrayList<ReplyVO> datas=new ArrayList<ReplyVO>();

		try {
			pstmt=conn.prepareStatement(SQL_SELECTALL);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				ReplyVO data=new ReplyVO();
				data.setRid(rs.getInt("RID"));
				data.setRcontent(rs.getString("RCONTENT"));
				data.setMid(rs.getString("MID"));
				data.setDatetime(rs.getDate("DATE"));

				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBCUtil.disconnect(rs, pstmt, conn);

		return datas;
	}
	
	public ReplyVO selectOne(ReplyVO rVO){
		conn=JDBCUtil.connect();

		ReplyVO data=null;

		try {
			pstmt=conn.prepareStatement(SQL_SELECTONE);
			pstmt.setInt(1, rVO.getBid());
			rs=pstmt.executeQuery();

			if(rs.next()) {
				data=new ReplyVO();
				data.setRid(rs.getInt("RID"));
				data.setRcontent(rs.getString("RCONTENT"));
				data.setMid(rs.getString("MID"));
				data.setDatetime(rs.getDate("DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBCUtil.disconnect(rs, pstmt, conn);

		return data;
	}
	
	public boolean insert(ReplyVO rVO) {
		conn=JDBCUtil.connect();

		try {
			pstmt=conn.prepareStatement(SQL_INSERT);
			pstmt.setInt(1, rVO.getBid());
			pstmt.setString(2, rVO.getMid());
			pstmt.setString(3, rVO.getRcontent());
			int rs=pstmt.executeUpdate();
			if(rs<=0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		JDBCUtil.disconnect(pstmt, conn);

		return true;
	}
	
	public boolean delete(ReplyVO rVO) {
		conn=JDBCUtil.connect();

		try {
			pstmt=conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, rVO.getRid());
			int rs=pstmt.executeUpdate();
			if(rs<=0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		JDBCUtil.disconnect(pstmt, conn);

		return true;
	}
}
