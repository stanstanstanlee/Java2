package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC와 관련된 1,2 => connect()
//4 코드를 "모듈화" => disconnect() 이러한 클래스를 util 클래스라고 함 
//-> 별도의 클래스로 캡슐화하는 것이 더 유리함!
//-> 공통의 로직을 모듈화한 클래스 (별도로 클래스화하는 것) 
// == Util 클래스

/*
 * 장점 (이 코드 쓰면 뭐가 좋아??)
 *  : 유지보수 용이
 *  : 코드 재사용성이 증가
 *  : 중복코드 최소화
 *  : 오류의 파급효과 줄어듦
 *  : 개발 기산, 비용 단축
 *  : 영업이익증가
 */

public class JDBCUtil {
	//상수화된 변수들 상단배치가 보편적 
	static final String driverName_MySQL="com.mysql.cj.jdbc.Driver";
	static final String driverName_Oracle="oracle.jdbc.driver.OracleDriver";

	static final String url_MySQL="jdbc:mysql://localhost/jin";
	static final String url_Oracle="jdbc:oracle:thin:@localhost:1521:xe";
	static final String userName="root";
	static final String passwd="1234";

	public static Connection connect() {
		Connection conn=null;
		// 1. 드라이버 로드

		// 유지보수 용이
		try {
			Class.forName(driverName_MySQL);
			// 클래스명,드라이버명
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. DB 연결
		//  : Connection 객체인 conn를 생성하는 것이 목표!
		try {
			conn=DriverManager.getConnection(url_MySQL, userName, passwd);
			// conn 객체는 DB와의 연결통로 역할!
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void disconnect(PreparedStatement stmt,Connection conn) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void disconnect(ResultSet rs,PreparedStatement stmt,Connection conn) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
