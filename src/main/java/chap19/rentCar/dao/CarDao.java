package chap19.rentCar.dao;

import java.util.List;

import chap19.rentCar.vo.CarVo;

public interface CarDao {
	public List<CarVo> listCar2(CarVo vo) throws Exception;
	
	public int regCar2(CarVo vo) throws Exception;
	
	public void modCar2(CarVo vo) throws Exception;
	
	public void removeCar2(CarVo vo) throws Exception;
	
	public void close2();
	
}
