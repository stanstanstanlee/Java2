package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	static final String sql_update="UPDATE PRODUCT SET CNT=CNT-1 WHERE NUM=?";
	static final String sql_selectAll_NAME="SELECT NUM,NAME,CNT,PRICE FROM PRODUCT WHERE NAME LIKE '%' ? '%'";
	static final String sql_selectAll_PRICE="SELECT NUM,NAME,CNT,PRICE FROM PRODUCT WHERE ? <=PRICE AND PRICE<= ? ";
	static final String sql_selectAll="SELECT NUM,NAME,CNT,PRICE FROM PRODUCT WHERE NAME LIKE '%' ? '%' AND ? <= PRICE AND PRICE<= ? ";
	static final String sql_selectOne="SELECT NUM,NAME,CNT,PRICE FROM PRODUCT WHERE NUM=?";
	
	
	private boolean insert(ProductVO pVO) {
		return false;
	}
	// 상품구매
	public boolean update(ProductVO pVO) {
		
		conn=JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, pVO.getNum());
			int result=pstmt.executeUpdate();
			if(result<=0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		JDBCUtil.disconnect(rs, pstmt, conn);
		return true;
	}
	private boolean delete(ProductVO pVO) {
		return false;
	}

	// 상품목록출력
	// 상품검색
	public ArrayList<ProductVO> selectAll(ProductVO pVO){
		
		ArrayList<ProductVO> pdatas=new ArrayList<ProductVO>();

		conn=JDBCUtil.connect();
		try {
			if(pVO.getSearchCondition().equals("이름")) {
				pstmt = conn.prepareStatement(sql_selectAll_NAME);
				pstmt.setString(1, pVO.getName());
			}
			else if(pVO.getSearchCondition().equals("가격")) {
				pstmt = conn.prepareStatement(sql_selectAll_PRICE);
				pstmt.setInt(1, pVO.getPrice());
				pstmt.setInt(2,  pVO.getTmp());
			}
			else if(pVO.getSearchCondition().equals("이름가격")) {
				pstmt = conn.prepareStatement(sql_selectAll);
				pstmt.setString(1, pVO.getName() );
				pstmt.setInt(2,  pVO.getPrice());
				pstmt.setInt(3,  pVO.getTmp());
			}
			rs=pstmt.executeQuery();

			while(rs.next()) {
				pdatas.add(new ProductVO(rs.getInt("NUM"),rs.getString("NAME"),rs.getInt("CNT"),rs.getInt("PRICE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		JDBCUtil.disconnect(rs, pstmt, conn);

		return pdatas;
	}
	// 상품선택(상품구매 시)
	public ProductVO selectOne(ProductVO pVO){
		

		ProductVO pdata=null;

		conn=JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, pVO.getNum());
			rs=pstmt.executeQuery();

			if(rs.next()) {
				pdata=new ProductVO(rs.getInt("NUM"),rs.getString("NAME"),rs.getInt("CNT"),rs.getInt("PRICE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		JDBCUtil.disconnect(rs, pstmt, conn);

		return pdata;
	}
}
