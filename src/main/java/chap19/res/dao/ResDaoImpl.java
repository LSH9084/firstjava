package chap19.res.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import chap19.common.base.AbstractBaseDao;
import chap19.member.vo.MemberVo;
import chap19.rentCar.vo.CarVo;
import chap19.res.vo.ResVo;

public class ResDaoImpl extends AbstractBaseDao implements ResDao {

	@Override
	public List<ResVo> searchRes2(ResVo vo) throws Exception {
		String sql = "select * from t_res where rent_end <= ? or rent_start >= ?";
		List<ResVo> list2 = new ArrayList<ResVo>();
		LocalDate start1 = vo.getRent_start();
		LocalDate end1 = vo.getRent_end();
		
		java.sql.Date start2 = Date.valueOf(vo.getRent_start());
		java.sql.Date end2 = Date.valueOf(vo.getRent_end());
		
		System.out.println(start2+"start2");
		pstmt = conn.prepareStatement(sql);
		pstmt.setDate(1, start2);
		pstmt.setDate(2, end2);
		rs = pstmt.executeQuery();
		System.out.println("rs: "+rs);
		while(rs.next()) {
			String rent_num = rs.getString("rent_num");
			LocalDate rent_day = rs.getDate("rent_day").toLocalDate();
			LocalDate rent_start = rs.getDate("rent_start").toLocalDate();
			LocalDate rent_end = rs.getDate("rent_end").toLocalDate();
			String rent_car_num = rs.getString("rent_car_num");
			String rent_id = rs.getString("rent_id");
			
			System.out.println(rent_start+"====");

			
			ResVo vo2 = ResVo.builder()
					.rent_num(rent_num)
					.rent_day(rent_day)
					.rent_start(rent_start)
					.rent_end(rent_end)
					.rent_car_num(rent_car_num)
					.rent_id(rent_id)
					.build();
			
			list2.add(vo2);
			list2.stream().forEach(System.out::println);
		}
		rs.close();
		
		
		list2.stream().forEach(System.out::println);
		return list2;
		
	}

	@Override
	public int regRes2(ResVo vo) throws Exception {
		int result = 0;
		String sql1 = """
					insert into t_res (rent_num,rent_day,rent_start,rent_end,rent_car_num,rent_id)
					values (?,?,?,?,?,?)
				""";
		
		pstmt = conn.prepareStatement(sql1);
		LocalDate lc1 = vo.getRent_day();
		Date day = Date.valueOf(lc1);
		LocalDate lc2 = vo.getRent_start();
		Date start = Date.valueOf(lc2);
		LocalDate lc3 = vo.getRent_end();
		Date end = Date.valueOf(lc3);
		pstmt.setString(1, vo.getRent_num());
		pstmt.setDate(2, day);
		pstmt.setDate(3, start);
		pstmt.setDate(4, end);
		pstmt.setString(5, vo.getRent_car_num());
		pstmt.setString(6, vo.getRent_id());
		
		result = pstmt.executeUpdate();
		
		return result;
				
				
				
		
	}

	@Override
	public void modRes2(ResVo vo) throws Exception {
		String sql2 = "update t_res set rent_start = ?, rent_end = ? where rent_num = ?";
		pstmt = conn.prepareStatement(sql2);
		LocalDate start1 = vo.getRent_start();
		LocalDate end1 = vo.getRent_end();
		
		java.sql.Date start2 = java.sql.Date.valueOf(vo.getRent_start());
		java.sql.Date end2 = java.sql.Date.valueOf(vo.getRent_end());
		
		
		
		pstmt.setDate(1, start2);
		pstmt.setDate(2, end2);
		pstmt.setString(3, vo.getRent_num());
		
		pstmt.executeUpdate();
		
		
		
	}

	@Override
	public void remRes2(ResVo vo) throws Exception {
		String sql = "delete from t_res where rent_num = ?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getRent_num());
		pstmt.executeUpdate();
		
	}

	
	public ResVo checkId3(String rentNum) throws Exception {
		int result =0;
		ResVo vo = new ResVo();
		
		String _rentNum = rentNum;
		String sql3 = "select * from t_res where rent_num = ?";
		
		pstmt = conn.prepareStatement(sql3);
		pstmt.setString(1, _rentNum);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String rent_num = rs.getString("rent_num");
			LocalDate rent_day = rs.getDate("rent_day").toLocalDate();
			LocalDate rent_start = rs.getDate("rent_start").toLocalDate();
			LocalDate rent_end = rs.getDate("rent_end").toLocalDate();
			String rent_car_num = rs.getString("rent_car_num");
			String rent_id = rs.getString("rent_id");
			
			vo.builder()
			.rent_num(rent_num)
			.rent_day(rent_day)
			.rent_start(rent_start)
			.rent_end(rent_end)
			.rent_car_num(rent_car_num)
			.rent_id(rent_id)
			.build();
		}
		return vo;
		
	}
	
	

	
}
