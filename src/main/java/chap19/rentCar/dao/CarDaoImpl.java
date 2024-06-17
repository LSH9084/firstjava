package chap19.rentCar.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap19.common.RentTableModel;
import chap19.common.base.AbstractBaseDao;
import chap19.rentCar.vo.CarVo;

public class CarDaoImpl extends AbstractBaseDao implements CarDao {
	
	
	@Override
	public List<CarVo> listCar2(CarVo vo) throws Exception {
		List<CarVo> list2 = new ArrayList<CarVo>();
		String sql = "";
		String _carName = vo.getCar_name();
//		String _carNum = vo.getCar_num();
//		String _carColor = vo.getCar_color();
//		String _carSize = String.valueOf(vo.getCar_size());
//		String _carMade = vo.getCar_made();
		
		if(_carName !=null && _carName.length() !=0) {
			sql = "SELECT * FROM t_car WHERE car_Name = ? ORDER BY car_Name";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _carName);
		} else {
			sql = "select * from t_car";
			pstmt = conn.prepareStatement(sql);
		}
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String car_num = rs.getString("car_num");
			String car_name = rs.getString("car_name");
			String car_color = rs.getString("car_color");
			int car_size = rs.getInt("car_size");
			String car_made = rs.getString("car_made");
			
			CarVo vo2 = CarVo.builder()
					.car_num(car_num)
					.car_name(car_name)
					.car_color(car_color)
					.car_size(car_size)
					.car_made(car_made)
					.build();
			
			list2.add(vo2);
		}
		
		
		return list2;
		
	}
	
	public List<CarVo> listCarNum2(CarVo vo) throws Exception {
		List<CarVo> list2 = new ArrayList<CarVo>();
		String sql = "";
//		String _carName = vo.getCar_name();
		String _carNum = vo.getCar_num();
//		String _carColor = vo.getCar_color();
//		String _carSize = String.valueOf(vo.getCar_size());
//		String _carMade = vo.getCar_made();
		
		
		if(_carNum !=null && _carNum.length() !=0) {
			sql = "SELECT * FROM t_car WHERE car_num = ? ORDER BY car_num";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _carNum);
		} else {
			sql = "select * from t_car";
			pstmt = conn.prepareStatement(sql);
		}
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String car_num = rs.getString("car_num");
			String car_name = rs.getString("car_name");
			String car_color = rs.getString("car_color");
			int car_size = rs.getInt("car_size");
			String car_made = rs.getString("car_made");
			
			CarVo vo2 = CarVo.builder()
					.car_num(car_num)
					.car_name(car_name)
					.car_color(car_color)
					.car_size(car_size)
					.car_made(car_made)
					.build();
			
			list2.add(vo2);
		}
		
		
		return list2;
		
	}
	
	public List<CarVo> listCarMade2(CarVo vo) throws Exception {
		List<CarVo> list2 = new ArrayList<CarVo>();
		String sql = "";
//		String _carName = vo.getCar_name();
//		String _carNum = vo.getCar_num();
//		String _carColor = vo.getCar_color();
//		String _carSize = String.valueOf(vo.getCar_size());
		String _carMade = vo.getCar_made();
		
		if(_carMade !=null && _carMade.length() !=0) {
			sql = "SELECT * FROM t_car WHERE car_made = ? ORDER BY car_made";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _carMade);
		} else {
			sql = "select * from t_car";
			pstmt = conn.prepareStatement(sql);
		}
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String car_num = rs.getString("car_num");
			String car_name = rs.getString("car_name");
			String car_color = rs.getString("car_color");
			int car_size = rs.getInt("car_size");
			String car_made = rs.getString("car_made");
			
			CarVo vo2 = CarVo.builder()
					.car_num(car_num)
					.car_name(car_name)
					.car_color(car_color)
					.car_size(car_size)
					.car_made(car_made)
					.build();
			
			list2.add(vo2);
		}
		
		
		return list2;
		
	}
	
	public List<CarVo> listCarColor2(CarVo vo) throws Exception {
		List<CarVo> list2 = new ArrayList<CarVo>();
		String sql = "";
//		String _carName = vo.getCar_name();
//		String _carNum = vo.getCar_num();
		String _carColor = vo.getCar_color();
//		String _carSize = String.valueOf(vo.getCar_size());
//		String _carMade = vo.getCar_made();
		
		if(_carColor !=null && _carColor.length() !=0) {
			sql = "SELECT * FROM t_car WHERE car_color = ? ORDER BY car_color";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _carColor);
		} else {
			sql = "select * from t_car";
			pstmt = conn.prepareStatement(sql);
		}
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String car_num = rs.getString("car_num");
			String car_name = rs.getString("car_name");
			String car_color = rs.getString("car_color");
			int car_size = rs.getInt("car_size");
			String car_made = rs.getString("car_made");
			
			CarVo vo2 = CarVo.builder()
					.car_num(car_num)
					.car_name(car_name)
					.car_color(car_color)
					.car_size(car_size)
					.car_made(car_made)
					.build();
			
			list2.add(vo2);
		}
		
		
		return list2;
		
	}
	
	
	
	

	@Override
	public int regCar2(CarVo vo) throws Exception {
		int result = 0;
		String sql2 = """
				insert into t_car (car_num, car_name, car_color, car_size, car_made)
				values (?,?,?,?,?)
				""";
		pstmt = conn.prepareStatement(sql2);
		pstmt.setString(1, vo.getCar_num());
		pstmt.setString(2, vo.getCar_name());
		pstmt.setString(3, vo.getCar_color());
		pstmt.setInt(4, vo.getCar_size());
		pstmt.setString(5, vo.getCar_made());
		
		result=pstmt.executeUpdate();
		return result;
	}

	@Override
	public void modCar2(CarVo vo) throws Exception {
		String sql3 = "update t_car set car_name = ? , car_color = ?, car_size = ?, car_made = ? where car_num = ?";
		pstmt = conn.prepareStatement(sql3);
		
		pstmt.setString(1, vo.getCar_name());
		pstmt.setString(2, vo.getCar_color());
		pstmt.setInt(3, vo.getCar_size());
		pstmt.setString(4, vo.getCar_made());
		pstmt.setString(5, vo.getCar_num());
		
		pstmt.executeUpdate();
		
		
	}

	@Override
	public void removeCar2(CarVo vo) throws Exception {
		String sql4 = "delete from t_car where car_num = ?";
		
		pstmt = conn.prepareStatement(sql4);
		
		pstmt.setString(1, vo.getCar_num());
		
		pstmt.executeUpdate();
	}

	@Override
	public void close2() {
		
	}
	
	public CarVo checkId2(String carnum) throws Exception {
		int result = 0;
		
		CarVo vo = new CarVo();
		
		String _carnum = carnum;
		String sql = "select * from t_car where car_num = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, _carnum);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String car_num 		= rs.getString("car_num");
			String car_name		= rs.getString("car_name");
			String car_color 	= rs.getString("car_color");
			int car_size 		= rs.getInt("car_size");
			String car_made		= rs.getString("car_made");
			
			vo.setCar_num(car_num);
			vo.setCar_name(car_name);
			vo.setCar_color(car_color);
			vo.setCar_size(car_size);
			vo.setCar_made(car_made);
		}
		return vo;
	}

	
	
//	else if(_carNum != null && _carNum.length() !=0) {
//		sql = "select * from t_car where car_num = ? order by car_num";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, _carNum);
//	}else if(_carColor != null && _carColor.length() !=0) {
//		sql = "select * from t_car where car_Color = ? order by _carColor";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, _carColor);
//	} else if(_carSize != null && _carSize.length() !=0) {
//		sql = "select * from t_car where car_Size = ? order by _carSize";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, _carSize);
//	}  else if(_carMade != null && _carMade.length() !=0) {
//		sql = "select * from t_car where car_Made = ? order by _carMade";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, _carMade);
//	}
	   

}
