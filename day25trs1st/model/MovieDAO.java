package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MovieDAO {
	
	// Q. 배열리스트를 받아오는데,
	// insert()를 그럼 1번하나요?
	// A. NO! insert()를 배열리스트.size()만큼 for문(반복) 돌립니다!
	public boolean insert(MovieVO mVO) {
		// JDBC
		
		// 1. 드라이버 로드
		// 2. DB 연결
		// 3. 데이터 read,write
		// 4. DB 연결해제
		
		// 1. 드라이버 로드
		final String driverName_MySQL="com.mysql.cj.jdbc.Driver";
		final String driverName_Oracle="oracle.jdbc.driver.OracleDriver";
		// 유지보수 용이
		try {
			Class.forName(driverName_MySQL);
			// 클래스명,드라이버명
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		// 2. DB 연결
		//  : Connection 객체인 conn를 생성하는 것이 목표!
		final String url_MySQL="jdbc:mysql://localhost/kim";
		final String url_Oracle="jdbc:oracle:thin:@localhost:1521:xe";
		final String userName="root";
		final String passwd="1234";
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url_MySQL, userName, passwd);
			// conn 객체는 DB와의 연결통로 역할!
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		// 3. 데이터 read,write
		//  : Statement 객체를 생성하고, 사용하는것이 목표!
		Statement stmt=null;
		final String sql_INSERT="INSERT INTO MOVIE (NAME,ODATE) VALUES('"+mVO.getName()+"','"+mVO.getOdate()+"');";
		try {
			stmt=conn.createStatement();
			stmt.executeUpdate(sql_INSERT);
			// Query -> SELECT
			// Update -> INSERT,UPDATE,DELETE
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
		
		// 4. DB 연결해제
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	public boolean update(MovieVO mVO) {
		return false;
	}
	public boolean delete(MovieVO mVO) {
		return false;
	}
	
	public ArrayList<MovieVO> selectAll(MovieVO mVO) {
		return null;
	}
	public MovieVO selectOne(MovieVO mVO) {
		return null;
	}
	
}
