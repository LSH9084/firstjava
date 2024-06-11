package chap16.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chap16.vo.E03MemberVO;

public class E02MemberDAO {
	Connection conn = null;
	Statement stmt = null; //sql 문장을 처리하는 객체
	ResultSet rs = null; //query 결과값 처리하는 객체
	PreparedStatement pstmt = null;
	public E02MemberDAO(){
		
		try {
			// DB 드라이브 로드
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/mydb", // host 
					"java", // 계정
					"1234" // 패스워드
					);
			if(conn!=null) {
				System.out.println("conn: " + conn);
				System.out.println("접속되었습니다.");
			}
			
		} catch (Exception e) {
			e.getMessage();
		} 

	} // 생성자 괄호
	
	//데이터 입력
	public int insert(E03MemberVO vo ) {
//		int result = 0;
		int result2 =0;
		try {
//			String sql = "insert into MEMBER (memberno, id, NAME) VALUES ("+vo.getMemberno()+", '"+vo.getId()+"' , '"+vo.getName()+"' )";
			String sql2 = """
					insert into member(memberno, id, name)
					values (?,?,?)
					""";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, vo.getMemberno());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getName());
			result2 = pstmt.executeUpdate();
			
			
//			System.out.println("sql : "+ sql);
//			stmt = conn.createStatement(); // sql 문장을 처리할 객체
//			System.out.println("stmt : "+stmt);
//			result = stmt.executeUpdate(sql); // 생성 삭제 갱신은 전부 업데이트에 속함
			
		} catch (Exception e) {}

//		return result;
		return result2;
		
	} 
	
	public List<E03MemberVO> list() {
		List<E03MemberVO> list = new ArrayList<E03MemberVO>();
		
		try {
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while( rs.next()) {
				E03MemberVO vo = new E03MemberVO();
				
				vo.setMemberno(rs.getInt("memberno"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {}
		return list;
	}
	
//	public List<E03MemberVO> list() {
//		List<E03MemberVO> list = new ArrayList<E03MemberVO>();
//		
//		try {
//			String sql = "select * from member";
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			
//			while( rs.next()) {
//				E03MemberVO vo = new E03MemberVO();
//				
//				vo.setMemberno(rs.getInt("memberno"));
//				vo.setId(rs.getString("id"));
//				vo.setName(rs.getString("name"));
//				
//				list.add(vo);
//			}
//			
//		} catch (Exception e) {}
//		
//		//System.out.println("query select result : "+list);
//		return list;
//	}
	
	public void close() {
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {}
		}
	}
	
	public int delete (int memberno) {
		int result = 0;
		try {
			String sql = "DELETE FROM member WHERE memberno=" + memberno;
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (Exception e) {}
		return result;
	}
	
	public int update(E03MemberVO vo) {
		int result = 0;
		try {
			String sql = "UPDATE MEMBER SET id = ?, name = ? WHERE memberno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getMemberno());
			result = pstmt.executeUpdate();

			
		} catch (Exception e) {}
		return result;
	}
		
	public E03MemberVO selectOne(int memberno) {
		E03MemberVO vo = new E03MemberVO();
		try {
			String sql = "SELECT * FROM member WHERE memberno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setMemberno(rs.getInt("memberno"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
			}
		} catch (Exception e) {}
		return vo;
	}

		
}
