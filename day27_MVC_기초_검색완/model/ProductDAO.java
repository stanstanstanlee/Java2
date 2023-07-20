package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;

	private boolean insert(ProductVO pVO) {
		return false;
	}
	// 상품구매
	public boolean update(ProductVO pVO) {
		final String sql_update="UPDATE PRODUCT SET CNT=CNT-1 WHERE NUM="+pVO.getNum();

		conn=JDBCUtil.connect();
		try {
			stmt = conn.createStatement();
			int result=stmt.executeUpdate(sql_update);
			if(result<=0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		JDBCUtil.disconnect(rs, stmt, conn);
		return true;
	}
	private boolean delete(ProductVO pVO) {
		return false;
	}

	// 상품목록출력
	// 상품검색
	public ArrayList<ProductVO> selectAll(ProductVO pVO){
		final String sql_selectAll_NAME="SELECT NUM,NAME,CNT,PRICE FROM PRODUCT WHERE NAME LIKE '%"+pVO.getName()+"%'";
		final String sql_selectAll_PRICE="SELECT NUM,NAME,CNT,PRICE FROM PRODUCT WHERE "+pVO.getPrice()+"<=PRICE AND PRICE<="+pVO.getTmp();
		final String sql_selectAll="SELECT NUM,NAME,CNT,PRICE FROM PRODUCT WHERE NAME LIKE '%"+pVO.getName()+"%' AND "+pVO.getPrice()+"<=PRICE AND PRICE<="+pVO.getTmp();

		ArrayList<ProductVO> pdatas=new ArrayList<ProductVO>();

		conn=JDBCUtil.connect();
		try {
			stmt = conn.createStatement();
			if(pVO.getSearchCondition().equals("이름")) {
				rs=stmt.executeQuery(sql_selectAll_NAME);
			}
			else if(pVO.getSearchCondition().equals("가격")) {
				rs=stmt.executeQuery(sql_selectAll_PRICE);
			}
			else if(pVO.getSearchCondition().equals("이름가격")) {
				rs=stmt.executeQuery(sql_selectAll);
			}

			while(rs.next()) {
				pdatas.add(new ProductVO(rs.getInt("NUM"),rs.getString("NAME"),rs.getInt("CNT"),rs.getInt("PRICE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		JDBCUtil.disconnect(rs, stmt, conn);

		return pdatas;
	}
	// 상품선택(상품구매 시)
	public ProductVO selectOne(ProductVO pVO){
		final String sql_selectOne="SELECT NUM,NAME,CNT,PRICE FROM PRODUCT WHERE NUM="+pVO.getNum();

		ProductVO pdata=null;

		conn=JDBCUtil.connect();
		try {
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql_selectOne);

			if(rs.next()) {
				pdata=new ProductVO(rs.getInt("NUM"),rs.getString("NAME"),rs.getInt("CNT"),rs.getInt("PRICE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		JDBCUtil.disconnect(rs, stmt, conn);

		return pdata;
	}
}
