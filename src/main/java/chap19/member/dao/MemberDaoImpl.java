package chap19.member.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap19.common.base.AbstractBaseDao;
import chap19.member.vo.MemberVo;

public class MemberDaoImpl extends AbstractBaseDao implements MemberDao{
	
	@Override
	public List<MemberVo> selectMember(MemberVo vo) throws Exception {
		List<MemberVo> list1 = new ArrayList<MemberVo>();
		String sql = "";
		String _name = vo.getName();
		if ( _name != null && _name.length() != 0) {
			sql = "SELECT * FROM t_member WHERE name = ? ORDER BY id";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _name);
			
		} else {
			sql = "select * from t_member";
			
			pstmt = conn.prepareStatement(sql);
			
		}
		rs = pstmt.executeQuery();
		while(rs.next()) {
			String id = rs.getString("id");
			String ps = rs.getString("ps");
			String name = rs.getString("name");
			String address = rs.getString("address");
			String p_number = rs.getString("p_number");
			
			MemberVo vo2 = new MemberVo();
			vo2.setAddress(address);
			vo2.setId(id);
			vo2.setName(name);
			vo2.setP_number(p_number);
			vo2.setPs(ps);
			
			list1.add(vo2);


		}
		rs.close();
		
		return list1;
	}

	@Override
	public int inserMember(MemberVo vo) throws Exception{
			int result =0;
			String sql2 = """
					insert into t_member(id, ps, name, address, p_number)
					values (?,?,?,?,?)
					""";
			pstmt = conn.prepareStatement(sql2);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPs());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getP_number());
			
			result = pstmt.executeUpdate();
			return result;
	}

	@Override
	public void updateMember(MemberVo vo)throws Exception {
		String sql3 = "UPDATE t_member SET ps = ?, name = ?, address = ?, p_number = ? WHERE id = ?";
		
		pstmt = conn.prepareStatement(sql3);
		
		
		pstmt.setString(1, vo.getPs());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getAddress());
		pstmt.setString(4, vo.getP_number());
		pstmt.setString(5, vo.getId());
		
		pstmt.executeUpdate();
	}

	@Override
	public void deleteMember(MemberVo vo) throws Exception{
		String sql4 = "delete from t_member where id = ?";
		
		pstmt = conn.prepareStatement(sql4);
		pstmt.setString(1, vo.getId());
		
		pstmt.executeUpdate();
	}
	
	public void close() throws Exception {
		if(conn != null) {
			conn.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(rs != null) {
			rs.close();
		}
	}

	@Override
	public MemberVo checkId(String id) throws Exception {
		int result = 0;
		
		MemberVo vo = new MemberVo();
		
		String _id = id;
		String sql = "SELECT * FROM t_member WHERE Id = ?";
			
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, _id);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String Id 		= rs.getString("Id");
			String Password 	= rs.getString("Password");
			String Name 		= rs.getString("Name");
			String Address 	= rs.getString("Address");
			String P_Number 	= rs.getString("PhoneNum");
			
			vo.setId(Id);
			vo.setName(Password);
			vo.setPs(Name);
			vo.setP_number(Address);
			vo.setAddress(P_Number);
			
		}
		return vo;
	}


}
