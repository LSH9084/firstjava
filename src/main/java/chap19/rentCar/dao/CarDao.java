package chap19.rentCar.dao;

import java.util.List;

import chap19.member.vo.MemberVo;
import chap19.rentCar.vo.CarVo;

public interface CarDao {
	public List<CarVo> listCar2(CarVo vo) throws Exception;
	
	public int regCar2(CarVo vo) throws Exception;
	
	public void modCar2(CarVo vo) throws Exception;
	
	public void removeCar2(CarVo vo) throws Exception;
	
	public void close2();
	
	public List<CarVo> listCarNum2(CarVo vo) throws Exception;
	
	public List<CarVo> listCarColor2(CarVo vo) throws Exception;
	
	public List<CarVo> listCarMade2(CarVo vo) throws Exception;
	
	public CarVo checkId2(String carnum) throws Exception;
	
}
