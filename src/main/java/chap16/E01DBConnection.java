package chap16;

import java.sql.Connection;
import java.sql.DriverManager;

public class E01DBConnection {
	public static void main(String[] args) {
		
		//데이터 베이스 접속 
		Connection conn = null;
		
		try {
			// DB 드라이브 로드
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306", // host 
					"java", // 계정
					"1234" // 패스워드
					);
			if(conn!=null) {
				System.out.println("conn: " + conn);
				System.out.println("접속되었습니다.");
			}
			
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if(conn !=null) {
				try {
					conn.close();
				} catch (Exception e2) {}
			}
		}
		
		
		
		
		
		
		
	}
}
