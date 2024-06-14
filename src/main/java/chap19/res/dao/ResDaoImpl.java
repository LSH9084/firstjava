package chap19.res.dao;

import java.time.LocalDate;
import java.util.List;

import chap19.common.base.AbstractBaseDao;
import chap19.res.vo.ResVo;

public class ResDaoImpl extends AbstractBaseDao implements ResDao {

	@Override
	public List<ResVo> searchRes2() throws Exception {
		String sql = "select * from t_res";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String rent_num = rs.getString("rent_num");
			LocalDate rent_day = rs.getDate("rent_day").toLocalDate();
			
			ResVo vo2 = ResVo.builder().build();
		}
		
		
		
		return null;
	}

	@Override
	public void regRes2() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modRes2() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remRes2() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
