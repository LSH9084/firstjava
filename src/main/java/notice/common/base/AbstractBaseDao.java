package notice.common.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AbstractBaseDao {
	protected static final String driver = "org.mariadb.jdbc.Driver";
	protected static final String url = "jdbc:mariadb://localhost:3306/noticedb";
	protected static final String user = "root";
	protected static final String pwd = "1234";
	
	static protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	public AbstractBaseDao() {
		if(conn == null) {
			System.out.println("접속되었습니다.");
			connDB();
		}
	}
	
	public void connDB() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(
					url,
					user,
					pwd
					);
		} catch (Exception e) {
			try {
				rs.close(); conn.close(); pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
